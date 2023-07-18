package Clases;
import Excepciones.InvalidException;
import Excepciones.PersonaException;

import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<Coche> cochesComprados;
    private ArrayList<Coche> cochesReservados;

    private Concesionario concesionario;

    public Cliente(String nombre, String apellido, String direccion, String DNI, int telefono) throws PersonaException {
        super(nombre, apellido, direccion, DNI, telefono);
        cochesComprados = new ArrayList<>();
        cochesReservados = new ArrayList<>();
    }

    public ArrayList<Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void setCochesComprados(ArrayList<Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }

    public ArrayList<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void setCochesReservados(ArrayList<Coche> cochesReservados) {
        this.cochesReservados = cochesReservados;
    }

    public void agregarCocheComprado(Coche coche) {
        cochesComprados.add(coche);

    }
    public void agregarCocheReservado(Coche coche) {
        cochesReservados.add(coche);
    }
    public void removeCocheReservado(Coche coche){
        cochesReservados.remove(coche);

    }
    public void imprimirCochesComprados() {

        if (!cochesComprados.isEmpty()) {
            System.out.println("Coches comprados: ");
            for (Coche coche : cochesComprados) {
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("Color: " + coche.getColor());
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Precio de compra: " + coche.getPrecioCompra());
                System.out.println("Precio de venta: " + coche.getPrecioVenta());
                System.out.println();
            }
        }
        else System.out.println("No existen coches comprados");
    }
    public void imprimirCochesReservados(){
        if (!cochesReservados.isEmpty()) {
            System.out.println("Coches reservados: ");
            for (Coche coche : cochesReservados) {
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("Color: " + coche.getColor());
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Precio de compra: " + coche.getPrecioCompra());
                System.out.println("Precio de venta: " + coche.getPrecioVenta());
                System.out.println();
            }
        }
        else System.out.println("No existen coches reservados");
    }
}
