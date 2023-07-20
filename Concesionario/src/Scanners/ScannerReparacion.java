package Scanners;
import Clases.*;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.*;

public class ScannerReparacion {
    private Concesionario concesionario;
    private HashMap<String, Coche> coches;
    private HashMap<String, Mecanico> mecanicos;

    public ScannerReparacion(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
        this.mecanicos = concesionario.getMecanicos();
    }
    public void agregarReparacion() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce la matrícula del coche que tiene que ser reparado: ");
            String matricula = scanner.nextLine();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                System.out.println("Introduce la reparación a añadir: ");
                System.out.print("Selecciona el tipo de reparación: 1- Mecanica / 2- Electrica / 3- Chapa / 4- Revisión ");
                int opcion = scanner.nextInt();
                TipoReparacion tipo = null;
                if (opcion == 1) tipo = TipoReparacion.MECANICA;
                if (opcion == 2) tipo = TipoReparacion.ELECTRICA;
                if (opcion == 3) tipo = TipoReparacion.CHAPA;
                if (opcion == 4) tipo = TipoReparacion.REVISION;
                System.out.print("Fecha de la reparación: ");
                scanner.nextLine();
                String fecha = scanner.nextLine();
                Reparacion reparacion = new Reparacion(tipo, fecha, false);
                coche.agregarCocheAReparar(reparacion);

            } else throw new NotFoundException("El coche no está en el stock del concesionario ");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void consultarReparacionesDeCoche() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce la matrícula del coche a consultar reparaciones: ");
            String matricula = scanner.nextLine();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                if (!coche.getReparaciones().isEmpty()) {
                    coche.imprimirReparaciones();
                } else throw new InvalidException("El coche no tiene ninguna reparación");
            } else throw new NotFoundException("El coche introducido no está en el stock del concesionario");
        } catch (NotFoundException notFound) {
            System.out.println(notFound.getMessage());
        }
        catch (InvalidException e){
            System.out.println(e.getMessage());
        }
    }
}
