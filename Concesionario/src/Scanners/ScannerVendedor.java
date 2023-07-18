package Scanners;

import Clases.Coche;
import Clases.VendedorAComision;
import Clases.Concesionario;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerVendedor {
    private Concesionario concesionario;
    private HashMap<String, VendedorAComision> vendedores;

    public ScannerVendedor(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.vendedores = concesionario.getVendedores();
    }

    public void agregarVendedor() {
        Scanner añadirVendedor = new Scanner(System.in);
        try {
            System.out.println("Introduzca los datos del vendedor: ");
            System.out.print("Introduzca su nombre: ");
            String nombre = añadirVendedor.nextLine();
            System.out.print("Introduzca su dirección: ");
            String direccion = añadirVendedor.nextLine();
            System.out.print("Introduzca su DNI: ");
            String dni = añadirVendedor.nextLine();
            System.out.print("Introduzca su número de teléfono: ");
            int telefono = añadirVendedor.nextInt();
            VendedorAComision vendedor = new VendedorAComision(nombre, "", direccion, dni, telefono);
            concesionario.agregarVendedor(vendedor);
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            //consola.director();
        }
    }

    public void removeVendedor() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el DNI del vendedor a dar de baja: ");
            String dni = scanner.nextLine();
            HashMap<String, VendedorAComision> vendedor = concesionario.getVendedores();
            if (vendedor.containsKey(dni)) {
                concesionario.removeVendedor(dni);
            } else throw new NotFoundException("El cliente no está dado de alta");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimirCochesVendidos() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el dni del vendedor: ");
            String dni = scanner.nextLine();
            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                ArrayList<Coche> coches = vendedor.getCochesVendidos();
                if (coches.isEmpty()) {
                    throw new InvalidException("No existen coches vendidos");
                } else {
                    System.out.println("Coches vendidos: ");
                    for (Coche coche : coches) {
                        System.out.println("Marca: " + coche.getMarca());
                        System.out.println("Modelo: " + coche.getModelo());
                        System.out.println("Color: " + coche.getColor());
                        System.out.println("Matrícula: " + coche.getMatricula());
                        System.out.println("Precio de compra: " + coche.getPrecioCompra());
                        System.out.println("Precio de venta: " + coche.getPrecioVenta());
                        System.out.println();
                    }
                }
            } else throw new NotFoundException("El vendedor no está dado de alta");
        } catch (NotFoundException notFound) {
            System.out.println(notFound.getMessage());
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimirDatosVendedor() { // imprime los datos del vendedor
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el dni del vendedor: ");
            String dni = scanner.nextLine();
            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                System.out.println("Datos del vendedor: ");
                System.out.println("Nombre: " + vendedor.getNombre());
                System.out.println("Dirección: " + vendedor.getDireccion());
                System.out.println("DNI: " + vendedor.getDNI());
                System.out.println("Teléfono: " + vendedor.getTelefono());
                System.out.println("------------------------");
            } else throw new NotFoundException("Este vendedor no está dado de alta");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarVendedor() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el dni del vendedor a modificar datos: ");
            String dni = scanner.nextLine();

            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                System.out.println("Introduzca los nuevos datos para el cliente con DNI " + vendedor.getDNI() + ": ");
                System.out.println("Introduzca su nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                vendedor.setNombre(nuevoNombre);
                System.out.println("Introduzca su nueva dirección: ");
                String nuevaDireccion = scanner.nextLine();
                vendedor.setDireccion(nuevaDireccion);
                System.out.println("Introduzca su nuevo teléfono: ");
                int nuevoTeléfono = scanner.nextInt();
                vendedor.setTelefono(nuevoTeléfono);
            } else throw new NotFoundException("El vendedor no está dado de alta");

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public void consolaVendedor() {
        Scanner scanner = new Scanner(System.in);
        try {
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("1-VENDER COCHE");
                System.out.println("2-RESERVAR COCHE");
                System.out.println("3-CONSULTAR DATOS DE CLIENTES");
                System.out.println("4-CONSULTAR DATOS DE COCHES");
                System.out.println("5-CONSULTAR DATOS DE EXPOSICIONES");
                System.out.println("6-MENU PRINCIPAL");
                System.out.print("Elige una opción:");
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > 6) throw new InvalidException("Introduce una de las opciones");
                if (opcion == 1)
                    if (opcion == 2)
                        if (opcion == 3)
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            consolaVendedor();
        }
    }*/
}



