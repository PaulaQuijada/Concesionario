import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario(new ArrayList<Cliente>(), new ArrayList<VendedorAComision>(), new ArrayList<Coche>(), new ArrayList<Exposicion>());
        Cliente cliente1 = new Cliente("Pepe", "C/ a", "3635464G", 4657584);
        concesionario.imprimirStock(concesionario.cochesStock()); //imprime coches en venta
        System.out.println("----------------");
        cliente1.agregarCocheComprado(concesionario.cochesStock().get(0)); // añade al cliente el coche a comprar (compra el coche 0 del array cochesStock)
        cliente1.imprimirCochesComprados(cliente1);// imprime coche comprado del cliente1
        System.out.println("----------------");
        concesionario.imprimirStock(concesionario.cochesStock()); // imprime los coches en stock
        //Falta implementar que el coche se saque de la lista de coches en venta cuando el cliente lo compra



    }
}