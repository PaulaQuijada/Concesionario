package Scanners;

import Clases.VendedorAComision;
import Clases.Concesionario;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarDireccion;
import Comprobaciones.String.ComprobarNombre;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.HashMap;
import java.util.Scanner;


import static Concesionario.Proyecto.menu;

public class ScannerVendedor {
    private Concesionario concesionario;
    private HashMap<String, VendedorAComision> vendedores;
    private ScannerVentas scannerVentas;
    private ScannerReservas scannerReservas;
    private ComprobarNombre comprobarNombre = new ComprobarNombre();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();
    public ScannerVendedor(Concesionario concesionario) throws InvalidException {
        this.concesionario = concesionario;
        vendedores = concesionario.getVendedores();
        scannerVentas = new ScannerVentas(concesionario);
        scannerReservas = new ScannerReservas(concesionario);

    }

    public void agregarVendedor() {
        try {
            Scanner agregarVendedor = new Scanner(System.in);
            System.out.println("Introduzca los datos del vendedor: ");
            System.out.print("Nombre: ");
            String nombre = agregarVendedor.nextLine();
            comprobarNombre.comprobacion(nombre);

            System.out.print("Apellido: ");
            String apellido = agregarVendedor.nextLine();
            comprobarNombre.comprobacion(apellido);

            System.out.print("Dirección: ");
            String direccion = agregarVendedor.nextLine();
            comprobarDireccion.comprobacion(direccion);

            System.out.print("DNI (Introducir 8 dígitos y una letra en mayúscula) : ");
            String dni = agregarVendedor.nextLine();
            if(!concesionario.validarDni(dni)) throw new InvalidException("El dni introducido no puede estar repetido");
            comprobarDNI.comprobacion(dni);

            System.out.print("Teléfono: ");
            int telefono = agregarVendedor.nextInt();
            if(!concesionario.validarTelefono(telefono)) throw new InvalidException("El teléfono introducido no puede estar repetido");
            comprobarTlf.comprobacion(telefono);

            VendedorAComision vendedor = new VendedorAComision(nombre, apellido, direccion, dni, telefono);
            concesionario.agregarVendedor(vendedor);
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void removeVendedor() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el DNI del vendedor a dar de baja: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            HashMap<String, VendedorAComision> vendedores = concesionario.getVendedores();
            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                if(vendedor.getCochesVendidos().isEmpty()){
                concesionario.removeVendedor(dni);
                System.out.println("El vendedor ha sido eliminado correctamente");
                } else throw new InvalidException("No se puede dar de baja a un vendedor que ha realizado ventas");
            } else throw new NotFoundException("El vendedor no está dado de alta");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void imprimirDatosVendedor() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el dni del vendedor: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                System.out.println("Datos del vendedor: ");
                System.out.println("Nombre: " + vendedor.getNombre());
                System.out.println("Apellido: " + vendedor.getApellido());
                System.out.println("Dirección: " + vendedor.getDireccion());
                System.out.println("DNI: " + vendedor.getDNI());
                System.out.println("Teléfono: " + vendedor.getTelefono());
                System.out.println("------------------------");
            } else throw new NotFoundException("Este vendedor no está dado de alta");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void modificarVendedor() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el dni del vendedor a modificar datos: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                System.out.println("Introduzca los nuevos datos para el vendedor con DNI " + vendedor.getDNI() + ": ");
                System.out.println("Dirección: ");
                String direccion = scanner.nextLine();
                vendedor.setDireccion(direccion);
                System.out.println("Teléfono: ");
                int telefono = scanner.nextInt();
                if(!concesionario.validarTelefono(telefono)) throw new InvalidException("El teléfono introducido no puede estar repetido");
                vendedor.setTelefono(telefono);
            } else throw new NotFoundException("El vendedor no está dado de alta");

        } catch (NotFoundException | InvalidException n) {
            System.out.println(n.getMessage());
            menu(concesionario);
        }
    }
    public void consolaVendedor() {
        try {
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 6) {
                System.out.println("************************");
                System.out.println("*** MENÚ VENDEDORES ***");
                System.out.println("************************");
                System.out.println("1-VENTAS");
                System.out.println("2-RESERVAS");
                System.out.println("3-CONSULTAR DATOS DE CLIENTES");
                System.out.println("4-CONSULTAR DATOS DE COCHES");
                System.out.println("5-CONSULTAR DATOS DE EXPOSICIONES");
                System.out.println("6-MENU PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > 6) throw new InvalidException("Debe introducir una de las opciones disponibles");
                if (opcion == 1) scannerVentas.consolaVentas();
                if (opcion == 2) scannerReservas.consolaReservas();
                if (opcion == 3) concesionario.imprimirClientes();
                if (opcion == 4) concesionario.imprimirStock();
                if (opcion == 5) concesionario.imprimirExposiciones();
                if (opcion == 6)  menu(concesionario);
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }
}



