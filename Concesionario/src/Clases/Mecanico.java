package Clases;

import Excepciones.InvalidException;
import Excepciones.PersonaException;

import java.util.ArrayList;

public class Mecanico extends Persona {
    private ArrayList<Coche> cochesReparados;
    public Mecanico(String nombre, String apellido, String direccion, String DNI, int telefono) throws InvalidException, PersonaException {
        super(nombre, apellido, direccion, DNI, telefono);
        cochesReparados = new ArrayList<>();
    }

    public ArrayList<Coche> getCochesReparados() {
        return cochesReparados;
    }

    public void setCochesReparados(ArrayList<Coche> cochesReparados) {
        this.cochesReparados = cochesReparados;
    }

}