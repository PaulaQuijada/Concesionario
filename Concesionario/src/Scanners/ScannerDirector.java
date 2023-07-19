package Scanners;

import Clases.Cliente;
import Clases.Concesionario;
import Clases.DirectorComercial;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarDireccion;
import Comprobaciones.String.ComprobarNombre;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.Scanner;

public class ScannerDirector {
    private ComprobarNombre comprobarNombre = new ComprobarNombre();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();
    private Concesionario concesionario;

    public ScannerDirector(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void agregarDirector() {
        Scanner añadirDirector = new Scanner(System.in);
        try {
            System.out.println("Introduzca los datos del cliente: ");
            System.out.print("Nombre: ");
            String nombre = añadirDirector.nextLine();
            comprobarNombre.comprobacion(nombre);
            System.out.print("Apellido: ");
            String apellido = añadirDirector.nextLine();
            comprobarNombre.comprobacion(apellido);
            System.out.print("Dirección: ");
            añadirDirector.nextLine();
            String direccion = añadirDirector.nextLine();
            comprobarDireccion.comprobacion(direccion);
            System.out.print("DNI: ");
            String dni = añadirDirector.nextLine();
            comprobarDNI.comprobacion(dni);
            System.out.print("Número de teléfono: ");
            int telefono = añadirDirector.nextInt();
            comprobarTlf.comprobacion(telefono);

            concesionario.agregarDirector(new DirectorComercial(nombre,apellido,direccion,dni,telefono));
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            agregarDirector();
        }
    }
    public void modificarDirector() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el dni del director a modificar datos: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            DirectorComercial director = concesionario.getDirector();
            if(director.getDNI().equals(dni)) {
                System.out.println("Introduzca los nuevos datos para el director con DNI " + director.getDNI() + ": ");
                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();
                director.setDireccion(direccion);
                System.out.print("Teléfono: ");
                int teléfono = scanner.nextInt();
                director.setTelefono(teléfono);
                System.out.println("Los datos se han modificado correctamente");
            } else throw new NotFoundException("El director no está dado de alta");
        } catch (NotFoundException n) {
            System.out.println(n.getMessage());
        }
        catch (InvalidException e){
            System.out.println(e.getMessage());
        }
    }

}
