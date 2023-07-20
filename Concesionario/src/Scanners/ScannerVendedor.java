package Scanners;

import Clases.Coche;
import Clases.VendedorAComision;
import Clases.Concesionario;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarDireccion;
import Comprobaciones.String.ComprobarNombre;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static Concesionario.Main.menu;

public class ScannerVendedor {
    private Concesionario concesionario;
    private HashMap<String, VendedorAComision> vendedores;
    private ScannerVentas scannerVentas;
    private ScannerReservas scannerReservas;
    private ComprobarNombre comprobarNombre = new ComprobarNombre();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();
    public ScannerVendedor(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.vendedores = concesionario.getVendedores();
    }

    public void agregarVendedor() {
        Scanner añadirVendedor = new Scanner(System.in);
        try {
            System.out.println("Introduzca los datos del vendedor: ");
            System.out.print("Nombre: ");
            String nombre = añadirVendedor.nextLine();
            comprobarNombre.comprobacion(nombre);
            System.out.println("Apellido: ");
            String apellido = añadirVendedor.nextLine();
            comprobarNombre.comprobacion(apellido);
            System.out.print("Dirección: ");
            String direccion = añadirVendedor.nextLine();
            comprobarDireccion.comprobacion(direccion);
            System.out.print("DNI: ");
            String dni = añadirVendedor.nextLine();
            comprobarDNI.comprobacion(dni);
            System.out.print("Teléfono: ");
            int telefono = añadirVendedor.nextInt();
            comprobarTlf.comprobacion(telefono);
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
            comprobarDNI.comprobacion(dni);
            HashMap<String, VendedorAComision> vendedor = concesionario.getVendedores();
            if (vendedor.containsKey(dni)) {
                concesionario.removeVendedor(dni);
            } else throw new NotFoundException("El vendedor no está dado de alta");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidException i){
            System.out.println(i.getMessage());
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
            comprobarDNI.comprobacion(dni);
            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                System.out.println("Datos del vendedor: ");
                System.out.println("Nombre: " + vendedor.getNombre());
                System.out.println("Dirección: " + vendedor.getDireccion());
                System.out.println("DNI: " + vendedor.getDNI());
                System.out.println("Teléfono: " + vendedor.getTelefono());
                System.out.println("------------------------");
            } else throw new NotFoundException("Este vendedor no está dado de alta");
        } catch (NotFoundException | InvalidException e) {
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

        } catch (NotFoundException n) {
            System.out.println(n.getMessage());
        }
        catch (InvalidException e){
            System.out.println(e.getMessage());
        }
    }

    public void consolaVendedor() {
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
                if (opcion == 1) scannerVentas.venderCocheStock();
                if (opcion == 2) scannerReservas.reservarCoche();
                if (opcion == 3)
                if (opcion == 4)
                if (opcion == 5) concesionario.imprimirExposiciones();
                if (opcion == 6) menu();
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            consolaVendedor();
        }
    }
}



