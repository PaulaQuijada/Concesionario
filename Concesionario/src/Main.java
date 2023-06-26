import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario(new ArrayList<Cliente>(), new ArrayList<VendedorAComision>(), new ArrayList<Coche>(), new ArrayList<Exposicion>());
        concesionario.imprimirStock(concesionario.cochesStock()); //imprime coches en venta
        System.out.println("----------------");
        concesionario.venderCoche(concesionario.getCoches().get(0),concesionario.clientes().get(0)); // añade al cliente el coche a comprar (compra el coche 0 del array cochesStock)
        concesionario.clientes().get(0).imprimirCochesComprados(concesionario.clientes().get(0));// imprime coche comprado del cliente1
        System.out.println("----------------");
        concesionario.imprimirStock(concesionario.getCoches()); // imprime los coches en stock
        //Falta implementar que el coche se saque de la lista de coches en venta cuando el cliente lo compra



    }
}