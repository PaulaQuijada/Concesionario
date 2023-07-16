package Clases;
import Excepciones.PersonaException;

public class Persona {
    private String nombre;
    private String direccion;
    private String DNI;
    private int telefono;

    public Persona(String nombre, String direccion, String DNI, int telefono) throws PersonaException {
        if(nombre == null || nombre.trim().isEmpty()) throw new PersonaException("El nombre no puede estar vacío");
        this.nombre = nombre;
        if(direccion == null || direccion.trim().isEmpty()) throw new PersonaException("La dirección no puede estar vacía");
        this.direccion = direccion;
        if (DNI == null || DNI.length() != 9 || !DNI.matches("\\d{8}[A-Z]")) throw new PersonaException("El DNI ingresado es inválido");
        this.DNI = DNI;
        int cantidadCifras = String.valueOf(telefono).length();
        cantidadCifras = 9;
        if(cantidadCifras !=9) throw new PersonaException("El teléfono introducido no es válido");
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
