package Scanners;

import Clases.*;
import Excepciones.InvalidException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerVentas {
    private Concesionario concesionario;
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Coche> coches;

    public ScannerVentas(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.clientes = concesionario.getClientes();
        this.vendedores = concesionario.getVendedores();
        this.coches = concesionario.getCoches();
    }

    public void venderCoche() {
        Scanner venta = new Scanner(System.in);
       try{ System.out.println("Introduce la matrícula del coche a vender: ");
        String matricula = venta.nextLine();
        if (coches.containsKey(matricula)) {
            Coche coche = coches.get(matricula);
            if(coche.getEstado() == EstadoCoche.EN_REPARACION) throw new InvalidException("El coche tiene reparaciones pendientes, por lo tanto no se puede vender");
            System.out.println("Introduce el dni del cliente comprador: ");
            String dni = venta.nextLine();
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                System.out.println("Introduce el dni del vendedor:");
                dni = venta.nextLine();
                if (vendedores.containsKey(dni)) {
                    VendedorAComision vendedor = vendedores.get(dni);
                    coche.setEstado(EstadoCoche.VENDIDO);
                    cliente.agregarCocheComprado(coche);
                    vendedor.agregarCocheVendido(coche);
                    coches.remove(matricula);
                    System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido vendido al cliente: " + cliente.getNombre());
                } else System.out.println("El vendedor no está dado de alta");
            } else System.out.println("El cliente no está dado de alta");
        } else System.out.println("El coche no está disponible en el stock del concesionario.");
    }
       catch (InvalidException e){
           System.out.println(e.getMessage());
       }

    }

    public void venderCocheReservas() {
        Scanner venta = new Scanner(System.in);
       try{ System.out.println("Introduce el dni del cliente que ha reservado el coche:");
        String dni = venta.nextLine();
        if (clientes.containsKey(dni)) {
            Cliente cliente = clientes.get(dni);
            System.out.println("Introduce el dni del vendedor:");
            dni = venta.nextLine();
            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                System.out.println("Introduce la matrícula del coche a vender: ");
                String matricula = venta.nextLine();
                ArrayList<Coche> reservas = cliente.getCochesReservados();
                    for (Coche coche : reservas) {
                        if (coche.getMatricula().equals(matricula)) {
                            coche.setEstado(EstadoCoche.VENDIDO);
                            vendedor.agregarCocheVendido(coche);
                            cliente.agregarCocheComprado(coche);
                            cliente.getCochesReservados().remove(coche);
                            System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido vendido al cliente: " + cliente.getNombre());
                            break;
                        } else throw new InvalidException("El coche introducido no está en la lista de reservas del cliente");
                    }

                } else throw new InvalidException("El vendedor no está dado de alta");
            } else throw new InvalidException("El cliente no está dado de alta");
        }
       catch (InvalidException e){
           System.out.println(e.getMessage());
       }
    }
    }
