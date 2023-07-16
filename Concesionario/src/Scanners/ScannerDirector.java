package Scanners;

import Clases.Concesionario;
import Clases.DirectorComercial;
import Excepciones.InvalidException;

import java.util.Scanner;

public class ScannerDirector {
    private Concesionario concesionario;

    public ScannerDirector(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void modificarDirector() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el dni del director a modificar datos: ");
            String dni = scanner.nextLine();
            DirectorComercial director = concesionario.getDirector();
            if(director.getDNI().equals(dni)) {
                System.out.println("Introduzca los nuevos datos para el director con DNI " + director.getDNI() + ": ");
                System.out.println("Introduzca su nombre");
                String nombre = scanner.nextLine();
                director.setNombre(nombre);
                System.out.println("Introduzca su dirección: ");
                String direccion = scanner.nextLine();
                director.setDireccion(direccion);
                System.out.println("Introduzca su teléfono: ");
                int teléfono = scanner.nextInt();
                director.setTelefono(teléfono);
                System.out.println("Los datos se han modificado correctamente");
            } else throw new InvalidException("El director no está dado de alta");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }

}
