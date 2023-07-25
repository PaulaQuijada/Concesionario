package Scanners;

import Clases.*;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static Concesionario.Main.menu;

public class ScannerVentas {
    private Concesionario concesionario;
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Coche> coches;

    public ScannerVentas() throws InvalidException {
        this.concesionario = new Concesionario();
        this.clientes = concesionario.getClientes();
        this.vendedores = concesionario.getVendedores();
        this.coches = concesionario.getCoches();
    }

    //COMPROBADO
    public void venderCocheStock() {
        try {
            Scanner venta = new Scanner(System.in);
            System.out.print("Introduce la matrícula del coche a vender: ");
            String matricula = venta.nextLine();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                if (coche.getEstado() == EstadoCoche.EN_REPARACION)
                    throw new InvalidException("El coche tiene reparaciones pendientes, por lo tanto no se puede vender");
                System.out.print("Introduce el dni del cliente comprador: ");
                String dni = venta.nextLine();
                if (clientes.containsKey(dni)) {
                    Cliente cliente = clientes.get(dni);
                    System.out.print("Introduce el dni del vendedor:");
                    dni = venta.nextLine();
                    if (vendedores.containsKey(dni)) {
                        VendedorAComision vendedor = vendedores.get(dni);
                        coche.setEstado(EstadoCoche.VENDIDO);
                        cliente.agregarCocheComprado(coche);
                        concesionario.registrarVenta(matricula, cliente.getNombre());
                        vendedor.agregarCocheVendido(coche);
                        coches.remove(matricula);
                        System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido vendido al cliente: " + cliente.getNombre());
                    } else throw new NotFoundException("El vendedor no está dado de alta");
                } else throw new NotFoundException("El cliente no está dado de alta");
            } else throw new NotFoundException("El coche no está disponible en el stock del concesionario.");
        } catch (NotFoundException notFound) {
            System.out.println(notFound.getMessage());
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }

    public void venderCocheReservas() {
        try {
            Scanner venta = new Scanner(System.in);
            System.out.print("Introduce el dni del cliente que ha reservado el coche:");
            String dni = venta.nextLine();
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                System.out.print("Introduce el dni del vendedor:");
                dni = venta.nextLine();
                if (vendedores.containsKey(dni)) {
                    VendedorAComision vendedor = vendedores.get(dni);
                    System.out.print("Introduce la matrícula del coche a vender: ");
                    String matricula = venta.nextLine();
                    ArrayList<Coche> reservas = cliente.getCochesReservados();
                    for (Coche coche : reservas) {
                        if (coche.getMatricula().equals(matricula)) {
                            coche.setEstado(EstadoCoche.VENDIDO);
                            vendedor.agregarCocheVendido(coche);
                            cliente.agregarCocheComprado(coche);
                            cliente.getCochesReservados().remove(coche);
                            concesionario.registrarVenta(matricula, cliente.getNombre());
                            System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido vendido al cliente: " + cliente.getNombre());
                            break;
                        } else
                            throw new NotFoundException("El coche introducido no está en la lista de reservas del cliente");
                    }

                } else throw new NotFoundException("El vendedor no está dado de alta");
            } else throw new NotFoundException("El cliente no está dado de alta");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void consolaVentas() {
        try {
            Scanner ventas = new Scanner(System.in);
            System.out.println("1-VENDER COCHE DE STOCK");
            System.out.println("2-VENDER COCHE DE RESERVAS");
            System.out.println("3-MENÚ PRINCIPAL");
            System.out.print("Elige entre una de las opciones: ");
            int opcion = ventas.nextInt();
            if (opcion < 1 || opcion > 3) throw new InvalidException("Debe introducir una de las opciones disponibles");
            if (opcion == 1) venderCocheStock();
            if (opcion == 2) venderCocheReservas();
            if (opcion == 3) menu();
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }
}
