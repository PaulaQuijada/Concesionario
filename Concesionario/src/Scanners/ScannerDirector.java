package Scanners;

import Clases.Concesionario;
import Clases.DirectorComercial;
import Excepciones.NotFoundException;

import java.util.Scanner;

public class ScannerDirector {
    private Concesionario concesionario;

    public ScannerDirector(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void modificarDirector() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el dni del director a modificar datos: ");
            String dni = scanner.nextLine();
            DirectorComercial director = concesionario.getDirector();
            if(director.getDNI().equals(dni)) {
                System.out.println("Introduzca los nuevos datos para el director con DNI " + director.getDNI() + ": ");
                System.out.print("Introduzca su nombre");
                String nombre = scanner.nextLine();
                director.setNombre(nombre);
                System.out.print("Introduzca su dirección: ");
                String direccion = scanner.nextLine();
                director.setDireccion(direccion);
                System.out.print("Introduzca su teléfono: ");
                int teléfono = scanner.nextInt();
                director.setTelefono(teléfono);
                System.out.println("Los datos se han modificado correctamente");
            } else throw new NotFoundException("El director no está dado de alta");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
