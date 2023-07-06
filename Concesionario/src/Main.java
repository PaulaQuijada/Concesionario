import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario(new HashMap<String, Cliente>(), new HashMap<String, VendedorAComision>(), new HashMap<String, Coche>(), new ArrayList<Exposicion>());
        /*concesionario.imprimirStock(concesionario.cochesStock()); //imprime coches en venta
        System.out.println("----------------");*/
        /*concesionario.venderCoche(concesionario.getCoches().get(0),concesionario.clientes().get(0)); // añade al cliente el coche a comprar (compra el coche 0 del array cochesStock)
        concesionario.clientes().get(0).imprimirCochesComprados(concesionario.clientes().get(0));// imprime coche comprado del cliente1
        System.out.println("----------------");
        concesionario.imprimirStock(concesionario.getCoches()); // imprime los coches en stock

       /* concesionario.clientes();
        concesionario.imprimirDatosCliente();
        concesionario.removeCliente();
        concesionario.imprimirDatosCliente();*/

       /* concesionario.cochesStock();
        concesionario.imprimirStock(concesionario.getCoches());
        concesionario.removeCoche();
        concesionario.imprimirStock(concesionario.getCoches());*/

       /* concesionario.vendedores();
        concesionario.imprimirDatosVendedor();
        concesionario.removeVendedor();
        concesionario.imprimirDatosVendedor();*/

        concesionario.agregarCoche();
        concesionario.imprimirStock(concesionario.cochesStock()); //imprime coches en venta


    }
}