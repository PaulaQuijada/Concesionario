
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        concesionario.reservarCoche();
        concesionario.venderCoche();
        concesionario.getClientes().get("26539704W").imprimirCochesComprados();




       /* concesionario.reservarCoche();
        concesionario.cancelarReserva();*/

       /* concesionario.agregarExposicion();
        concesionario.imprimirDatosExposicion();
        System.out.println("Dime el número de exposicion");
        int numExpo = 1;
        Exposicion exposicion = concesionario.getExposiciones().get(numExpo);
        exposicion.modificarExpo();
        concesionario.imprimirDatosExposicion();*/
        /*concesionario.agregarCocheReparacion();
        concesionario.consultarReparacionesDeCoche();
        concesionario.repararCoche();
        concesionario.consultarReparacionesDeCoche();*/


       /* concesionario.agregarExposicion();
        concesionario.imprimirDatosExposicion();
        concesionario.removeExposicion();
        System.out.println(concesionario.getExposiciones().size());*/
        /*concesionario.agregarCocheAExpo();
        concesionario.removeCocheExpo();
        concesionario.imprimirDatosExposicion();
        System.out.println();
        concesionario.imprimirStock();*/
        /*concesionario.imprimirDatosExposicion();
        concesionario.cambiarExposicion();
        concesionario.imprimirDatosExposicion();*/

       /* concesionario.imprimirStock(concesionario.cochesStock()); //imprime coches en venta
       /* System.out.println("----------------");
        concesionario.venderCoche(); // añade al cliente el coche a comprar (compra el coche 0 del array cochesStock)
        /*concesionario.reservarCoche();*/
        /*System.out.println("----------------");
        concesionario.queCoches();
        /*concesionario.clientesCompradores();*/
        /*concesionario.imprimirStock(concesionario.getCoches()); // imprime los coches en stock*/

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

        /*concesionario.agregarCoche();
        concesionario.imprimirStock(concesionario.cochesStock()); //imprime coches en venta

        concesionario.cochesStock();*/


    }
}