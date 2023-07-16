package Scanners;
package Clases;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Clases.*;
import Excepciones.CocheException;
import Excepciones.InvalidException;

public class ScannerCoche {
    private Concesionario concesionario;
    private HashMap<String, Coche> coches;

    public ScannerCoche(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
    }

    public void agregarCoche() {
        Scanner añadirCoche = new Scanner(System.in);
        try {
            TipoCoche tipo = null;
            System.out.println("Introduce el tipo de coche a añadir siendo 1-Turismo, 2-Industrial o 3-Todoterreno: ");
            int num = añadirCoche.nextInt();
            añadirCoche.nextLine();
            if (num == 1) tipo = TipoCoche.TURISMO;
            if (num == 2) tipo = TipoCoche.INDUSTRIAL;
            if (num == 3) tipo = TipoCoche.TODOTERRENO;
            System.out.println("Introduzca los datos del coche a añadir: ");
            System.out.println("Marca: ");
            String marca = añadirCoche.nextLine();
            System.out.println("Modelo: ");
            String modelo = añadirCoche.nextLine();
            System.out.println("Color: ");
            String color = añadirCoche.nextLine();
            EstadoCoche estado = EstadoCoche.EN_VENTA;
            System.out.println("Matrícula: ");
            String matricula = añadirCoche.nextLine();
            System.out.println("Precio de compra: ");
            float precioCompra = añadirCoche.nextFloat();
            System.out.println("Precio de venta: ");
            float precioVenta = añadirCoche.nextFloat();
            Coche coche = new Coche(tipo, marca, modelo, color, estado, matricula, precioCompra, precioVenta);
            concesionario.agregarCoche(coche);
        } catch (CocheException e){
            System.out.println(e.getMessage());
            //ScannerDirector.consolaDirector();
        }
    }

    public void removeCoche() {
        Scanner removeCoche = new Scanner(System.in);
        try {
            System.out.println("Introduce la matrícula del coche a eliminar: ");
            String matricula = removeCoche.nextLine();
            HashMap<String, Coche> coches = concesionario.getCoches();
            if (coches.containsKey(matricula)) {
                concesionario.removeCoche(matricula);
            } else throw new InvalidException("El coche no está dado de alta en el concesionario");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            //volver a menú clientes
        }
    }

    public void imprimirCoche() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce la matricula del coche: ");
            String matricula = scanner.nextLine();
            HashMap<String, Coche> coches = concesionario.getCoches();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                ArrayList<Reparacion> reparaciones = coche.getReparaciones();
                System.out.println("Datos del coche:");
                System.out.println("Tipo de coche: " + coche.getTipo());
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("Color: " + coche.getColor());
                System.out.println("Estado: " + coche.getEstado());
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Precio de venta: " + coche.getPrecioVenta());
                System.out.println("Precio de compra: " + coche.getPrecioCompra());
                if (reparaciones.size() == 0) System.out.println("Este coche no tiene reparaciones pendientes");
                else for (Reparacion reparacion : reparaciones) {
                    System.out.println("Reparaciones:" + reparacion.toString());
                }
            } else throw new InvalidException("El coche no se encuentra en el concesionario");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }
    public void modificarCoche(){
        Scanner scanner = new Scanner(System.in);
       try{ System.out.println("Introduce la matrícula del coche: ");
        String matricula = scanner.nextLine();
        if(coches.containsKey(matricula)) {
            Coche coche = coches.get(matricula);
            System.out.println("Introduce los nuevos datos para el coche con matrícula " + coche.getMatricula() + ": ");
            System.out.println("Color: ");
            String color = scanner.nextLine();
            coche.setColor(color);
            System.out.println("Precio de venta:");
            float nuevoPrecioVenta = scanner.nextFloat();
            coche.setPrecioVenta(nuevoPrecioVenta);
            System.out.println("Precio de compra: ");
            float nuevoPrecioCompra = scanner.nextFloat();
            coche.setPrecioCompra(nuevoPrecioCompra);
            System.out.println("Los datos han sido modificados correctamente");
            System.out.println();
        }
        else throw new InvalidException("El coche no existe");
       }
       catch (InvalidException e){
           System.out.println(e.getMessage());

        }
    }
    public void consolaCoches(){
        //scanner para dar de alta/baja un coche, modificar coche,
    }
    }

