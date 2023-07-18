package Scanners;
import Clases.Cliente;
import Clases.Coche;
import Clases.Concesionario;
import Clases.VendedorAComision;
import Excepciones.NotFoundException;

import java.util.HashMap;
import java.util.Scanner;

public class ScannerConcesionario {
    private Concesionario concesionario;
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Coche> coches;
    private HashMap<String, String> ventas;

    public ScannerConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.clientes  = concesionario.getClientes();
        this.vendedores = concesionario.getVendedores();
        this.ventas = concesionario.getVentas();
    }

    public void queCliente() {
        Scanner scanner = new Scanner(System.in);
       try{ System.out.print("Introduce la matrícula del coche a consultar: ");
        String matricula = scanner.nextLine();
        if (ventas.containsKey(matricula)) {
            String nombreCliente = ventas.get(matricula);
            System.out.println("El coche ha sido comprado o reservado por " + nombreCliente);
            }
        else throw new NotFoundException("El coche no ha sido encontrado en el registro de ventas");
        }
       catch (NotFoundException e) {
           System.out.println(e.getMessage());}
    }
    public void queCoches(){
        Scanner scanner = new Scanner(System.in);
        try {System.out.print("Introduce el dni del vendedor para consultar sus coches vendidos: ");
        String dni = scanner.nextLine();
        if (vendedores.containsKey(dni)) {
            VendedorAComision vendedor = vendedores.get(dni);
            vendedor.imprimirCochesVendidos();
        } else throw new NotFoundException("El vendedor no está registrado en el concesionario");
    }
        catch (NotFoundException e){
            System.out.println(e.getMessage());}
    }
}
