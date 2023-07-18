package Scanners;
import Clases.Cliente;
import Clases.Coche;
import Clases.Concesionario;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerCliente {
    private Concesionario concesionario;
    private HashMap<String, Cliente> clientes;

    public ScannerCliente(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.clientes = concesionario.getClientes();
    }

    public void agregarCliente() {
        Scanner añadirCliente = new Scanner(System.in);
        try {
            System.out.println("Introduzca los datos del cliente: ");
            System.out.print("Nombre: ");
            String nombre = añadirCliente.nextLine();
            System.out.print("Apellido: ");
            String apellido = añadirCliente.nextLine();
            System.out.print("Edad: ");
            int edad = añadirCliente.nextInt();
            System.out.print("Dirección: ");
            String direccion = añadirCliente.nextLine();
            System.out.print("DNI: ");
            String dni = añadirCliente.nextLine();
            System.out.print("Número de teléfono: ");
            int telefono = añadirCliente.nextInt();

            concesionario.agregarCliente(new Cliente(nombre, apellido, edad, direccion, dni, telefono));
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            agregarCliente();
        }
    }

    public void removeCliente() {
        Scanner removeCliente = new Scanner(System.in);
        try {
            System.out.print("Introduce el DNI del cliente a dar de baja: ");
            String dni = removeCliente.nextLine();
            Cliente cliente = concesionario.getClientes().get(dni);
            if (clientes.containsKey(dni)) {
                if (cliente.getCochesComprados().isEmpty() && cliente.getCochesReservados().isEmpty()) {
                    concesionario.removeCliente(dni);
                    System.out.println("El cliente se ha eliminado correctamente");
                } else throw new InvalidException("El cliente no se puede eliminar ya que tiene coches reservados y/o comprados");
            } else throw new NotFoundException("El cliente no está registrado en el concesionario");
        }
        catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
        catch (NotFoundException notFound){
            System.out.println(notFound.getMessage());
        }
    }

    public void imprimirDatosCliente() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el dni para imprimir sus datos");
            String dni = scanner.nextLine();
            HashMap<String, Cliente> clientes = concesionario.getClientes();
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                System.out.println("Datos del cliente: ");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Dirección: " + cliente.getDireccion());
                System.out.println("DNI: " + cliente.getDNI());
                System.out.println("Teléfono: " + cliente.getTelefono());
                System.out.println("------------------------");
            } else throw new NotFoundException("Este cliente no está dado de alta");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
            //volver a menú clientes consola.clientes();
        }
    }

    public void scannerCochesComprados() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el dni del cliente:");
            String dni = scanner.nextLine();
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                ArrayList<Coche> compras = cliente.getCochesComprados();
                if (compras.isEmpty()) {
                    throw new InvalidException("No existen coches comprados");
                } else {
                    for (Coche coche : compras) {
                        System.out.println("Coches comprados: ");
                        System.out.println("Marca: " + coche.getMarca());
                        System.out.println("Modelo: " + coche.getModelo());
                        System.out.println("Color: " + coche.getColor());
                        System.out.println("Matrícula: " + coche.getMatricula());
                        System.out.println("Precio de compra: " + coche.getPrecioCompra());
                        System.out.println("Precio de venta: " + coche.getPrecioVenta());
                        System.out.println();
                    }
                }
            } else throw new NotFoundException("El cliente no está dado de alta");

        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
        catch (NotFoundException notFound){
            System.out.println(notFound.getMessage());
        }
    }

    public void scannerCochesReservados() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el dni del cliente:");
            String dni = scanner.nextLine();
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                ArrayList<Coche> reservas = cliente.getCochesReservados();
                if (reservas.isEmpty()) {
                    throw new InvalidException("No existen coches reservados");
                } else {
                    for (Coche coche : reservas) {
                        System.out.println("Coches reservados: ");
                        System.out.println("Marca: " + coche.getMarca());
                        System.out.println("Modelo: " + coche.getModelo());
                        System.out.println("Matrícula: " + coche.getMatricula());
                        System.out.println("Precio de compra: " + coche.getPrecioCompra());
                        System.out.println("Precio de venta: " + coche.getPrecioVenta());
                        System.out.println();
                    }
                }
            }else throw new NotFoundException("El cliente no está dado de alta");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
        catch (NotFoundException notFound){
            System.out.println(notFound.getMessage());
        }
    }

    public void modificarCliente() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el dni del cliente a modificar datos:");
            String dni = scanner.nextLine();
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                System.out.println("Introduzca los nuevos datos para el cliente con DNI " + cliente.getDNI() + ": ");
                System.out.print("Dirección: ");
                String nuevaDireccion = scanner.nextLine();
                cliente.setDireccion(nuevaDireccion);
                System.out.print("Teléfono: ");
                int nuevoTeléfono = scanner.nextInt();
                cliente.setTelefono(nuevoTeléfono);
            }
            else throw new NotFoundException("El cliente no está dado de alta");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void consolaClientes() {
        Scanner consola = new Scanner(System.in);
        try {
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("1-CONSULTAR COCHES EN STOCK");
                System.out.println("2-CONSULTA EXPOSICIONES");
                System.out.println("3-CONSULTAR REPARACIONES RESERVADOS");
                System.out.println("4-MENU PRINCIPAL");
                opcion = consola.nextInt();
                if (opcion < 1 || opcion > 4) throw new InvalidException("Introduce una de las opciones");
                if (opcion == 1) concesionario.imprimirStock();
                if (opcion == 2) //concesionario.imprimirExposicion;
                    if (opcion == 3) ; //imprimir reparaciones;
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            consolaClientes();
        }
    }
}

