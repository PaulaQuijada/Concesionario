package Scanners;

import Clases.Cliente;
import Clases.Concesionario;
import Clases.DirectorComercial;
import Clases.VendedorAComision;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarDireccion;
import Comprobaciones.String.ComprobarNombre;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.Scanner;

public class ScannerDirector {
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private Concesionario concesionario;
    private ScannerCliente clientes = new ScannerCliente(concesionario);

    public ScannerDirector(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void agregarModificarDirector() { //PARA AGREGAR UN DIRECTOR NUEVO O MODIFICAR SUS DATOS
        Scanner añadirDirector = new Scanner(System.in);
        try { DirectorComercial director = new DirectorComercial();
            System.out.println("Introduzca los datos para agregar o modificar al director: ");
            System.out.print("Nombre: ");
            String nombre = añadirDirector.nextLine();
            director.setNombre(nombre);

            System.out.print("Apellido: ");
            String apellido = añadirDirector.nextLine();
            director.setApellido(apellido);

            System.out.print("Dirección: ");
            String direccion = añadirDirector.nextLine();
            director.setDireccion(direccion);

            System.out.print("DNI (Introducir 8 dígitos y una letra en mayúscula) : ");
            String dni = añadirDirector.nextLine();
            director.setDNI(dni);

            System.out.print("Número de teléfono: ");
            int telefono = añadirDirector.nextInt();
            director.setTelefono(telefono);

            concesionario.agregarDirector(director);
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            agregarModificarDirector();
        }
    } //COMPROBADO
    public void imprimirDatosDirector() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el dni del director: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (concesionario.getDirector().getDNI().equals(dni)) {
                DirectorComercial director = concesionario.getDirector();
                System.out.println("Datos del director: ");
                System.out.println("Nombre: " + director.getNombre());
                System.out.println("Dirección: " + director.getDireccion());
                System.out.println("DNI: " + director.getDNI());
                System.out.println("Teléfono: " + director.getTelefono());
                System.out.println("------------------------");
            } else throw new NotFoundException("El director no está dado de alta");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
        }
    } //COMPROBADO

    public void consolaDirector(){
    Scanner director = new Scanner(System.in);
        System.out.println("1-AÑADIR/MODIFICAR DIRECTOR");
        System.out.println("2-IMPRIMIR DATOS DEL DIRECTOR");
        System.out.println("3-CLIENTES");
        System.out.println("4-VENDEDORES");
        System.out.println("5-MECÁNICOS");
        System.out.println("6-VEHÍCULOS");
        System.out.println("7-EXPOSICIONES");
        System.out.println("8-VENTAS/RESERVAS");
        System.out.println("9-TALLER");
        System.out.println("10-INFORMES");
        System.out.println("-MENU PRINCIPAL");
        int opcion = director.nextInt();
        if(opcion == 1) agregarModificarDirector();
        if(opcion == 2) imprimirDatosDirector();
        if(opcion == 3) {
            System.out.println("1-DAR DE ALTA CLIENTE");
            System.out.println("2-MODIFICAR CLIENTE");
            System.out.println("3-CONSULTAR DATOS CLIENTE");
            System.out.println(4);
            System.out.println("-DAR DE BAJA CLIENTE");
            if(opcion == 1) clientes.agregarCliente();
            if(opcion == 2) clientes.modificarCliente();
            if(opcion == 3) clientes.imprimirDatosCliente();
            if(opcion == 4) clientes.removeCliente();
        }

    }
}
