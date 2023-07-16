package Scanners;
import Clases.Coche;
import Clases.Concesionario;
import Clases.Reparacion;
import Clases.TipoReparacion;
import Excepciones.InvalidException;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerReparacion {
    private Concesionario concesionario;
    private HashMap<String, Coche> coches;

    public ScannerReparacion(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
    }
    public void agregarCocheReparacion() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce la matrícula del coche que tiene que ser reparado: ");
            String matricula = scanner.nextLine();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                System.out.println("Introduce la reparación a añadir: ");
                System.out.println("Selecciona el tipo de reparación: 1- Mecanica / 2- Electrica / 3- Chapa / 4- Revisión ");
                int opcion = scanner.nextInt();
                TipoReparacion tipo = null;
                if (opcion == 1) tipo = TipoReparacion.MECANICA;
                if (opcion == 2) tipo = TipoReparacion.ELECTRICA;
                if (opcion == 3) tipo = TipoReparacion.CHAPA;
                if (opcion == 4) tipo = TipoReparacion.REVISION;
                System.out.println("Fecha de la reparación: ");
                scanner.nextLine();
                String fecha = scanner.nextLine();
                Reparacion reparacion = new Reparacion(tipo, fecha, false);
                coche.agregarCocheAReparar(reparacion);

            } else throw new InvalidException("El coche que pides no está en el stock del concesionario ");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }
    public void consultarReparacionesDeCoche() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce la matrícula del coche a consultar reparaciones: ");
            String matricula = scanner.nextLine();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                if (!coche.getReparaciones().isEmpty()) {
                    coche.imprimirReparaciones();
                } else throw new InvalidException("El coche no tiene ninguna reparación");
            } else System.out.println("El coche introducido no está en el stock del concesionario");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }
}
