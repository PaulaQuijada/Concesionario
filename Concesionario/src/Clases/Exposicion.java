package Clases;

import Excepciones.InvalidException;

import java.util.ArrayList;

public class Exposicion {
    private String tipo;
    private int numExposicion;
    private int telefono;
    private String direccion;
    private ArrayList<Coche> coches;

    public Exposicion(String tipo, int numExposicion, int telefono, String direccion) throws InvalidException {
        this.tipo = tipo;
        this.numExposicion = numExposicion;
        this.telefono = telefono;
        this.direccion = direccion;
        coches = new ArrayList<>();

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumExposicion() {
        return numExposicion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public void agregarCoche(Coche coche){
        coches.add(coche);
    }
    public void borrarCoche(Coche coche){
        coches.remove(coche);
    }
    public void imprimirCochesExpo () {
        for (Coche coche : coches) {
            System.out.println("Tipo: " + coche.getTipo());
            System.out.println("Marca: " + coche.getMarca());
            System.out.println("Modelo: " + coche.getModelo());
            System.out.println("Color: " + coche.getColor());
            System.out.println("Matricula: " + coche.getMatricula());
            System.out.println("Estado: " + coche.getEstado());
            System.out.println("Precio de venta: " + coche.getPrecioVenta());
            System.out.println("Precio de compra: " + coche.getPrecioCompra());
            System.out.println("------------------------------");
        }
    }


}