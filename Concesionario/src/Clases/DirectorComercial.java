package Clases;
import Excepciones.PersonaException;

public class DirectorComercial extends Persona {
    public DirectorComercial(String nombre, String apellido, String direccion, String DNI, int telefono) throws PersonaException {
        super(nombre, apellido, direccion, DNI, telefono);
    }
    public void imprimirDatosDirector(){
        System.out.println("Datos del director: ");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("DNI: " + getDNI());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("------------------------");
    }
}
