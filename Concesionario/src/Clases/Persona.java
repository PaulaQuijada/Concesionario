package Clases;

import Excepciones.InvalidException;

public class Persona {
    private String nombre;
    private String apellido;
    private String direccion;
    private String DNI;
    private int telefono;

    /* EXCEPCIONES:
    NOMBRE Y APELLIDO: SIN NUMEROS
    DNI: 9 DIGITOS 1ºLETRA O ULTIMO
    MATRICULA: 7-8 DIGITOS
    TELEFONO: 9 DIGITOS
    */
    public Persona(String nombre, String apellido, String direccion, String DNI, int telefono) throws InvalidException {
        if(nombre == null || nombre.trim().isEmpty()) throw new InvalidException("El nombre no puede estar vacío");
        this.nombre = nombre;
        this.apellido = apellido;
        if(direccion == null || direccion.trim().isEmpty()) throw new InvalidException("La dirección no puede estar vacía");
        this.direccion = direccion;
        if (DNI == null || DNI.length() != 9 || !DNI.matches("\\d{8}[A-Z]")) throw new InvalidException("El DNI ingresado es inválido");
        this.DNI = DNI;
        int cantidadCifras = String.valueOf(telefono).length();
        cantidadCifras = 9;
        if(cantidadCifras !=9) throw new InvalidException("El teléfono introducido no es válido");
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
