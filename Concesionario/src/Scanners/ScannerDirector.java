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

    public void agregarDirector() { //PARA AGREGAR UN DIRECTOR NUEVO O MODIFICAR SUS DATOS
        Scanner añadirDirector = new Scanner(System.in);
        try { DirectorComercial director = new DirectorComercial();
            System.out.println("Introduzca los datos para agregar o modificar al director: ");
            System.out.print("Nombre: ");
            String nombre = añadirDirector.nextLine();
            director.setNombre(nombre);

            System.out.print("Apellido: ");
            String apellido = añadirDirector.nextLine();
            director.setApellido(apellido);

            System.out.print("Dirección: ");
            añadirDirector.nextLine();
            String direccion = añadirDirector.nextLine();
            director.setDireccion(direccion);

            System.out.print("DNI: ");
            String dni = añadirDirector.nextLine();
            director.setDNI(dni);

            System.out.print("Número de teléfono: ");
            int telefono = añadirDirector.nextInt();
            director.setTelefono(telefono);

            concesionario.agregarDirector(director);
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            agregarDirector();
        }
    }

    public void consolaDirector(){

    }
}
