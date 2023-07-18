package Scanners;

import Clases.Cliente;
import Clases.Concesionario;
import Clases.VendedorAComision;

import java.util.HashMap;
import java.util.Scanner;

public class ScannerConcesionario {
    private Concesionario concesionario;
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;

    public ScannerConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.clientes  = concesionario.getClientes();
        this.vendedores = concesionario.getVendedores();
    }

    public void queCliente() { //CAMBIAR METODO PARA QUE DEVUELVA CLIENTE
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el dni del cliente para consultar los datos de los coches que ha comprado/reservado: ");
        String dni = scanner.nextLine();
        if (clientes.containsKey(dni)) {
            Cliente cliente = clientes.get(dni);
            cliente.imprimirCochesComprados();
            cliente.imprimirCochesReservados();
        }
    }
    public void queCoches(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el dni del vendedor para consultar sus coches vendidos: ");
        String dni = scanner.nextLine();
        if (vendedores.containsKey(dni)) {
            VendedorAComision vendedor = vendedores.get(dni);
            vendedor.imprimirCochesVendidos();
        }
    }
}
