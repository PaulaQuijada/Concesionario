import java.util.ArrayList;
public class Cliente extends Persona{
    private ArrayList<Coche> cochesComprados;
    private ArrayList<Coche> cochesReservados;

    public Cliente(String nombre, String direccion, String DNI, int telefono){ // lo que pido para crear un cliente
        super(nombre, direccion, DNI, telefono);
        cochesComprados = new ArrayList<>();
        // inicializo los dos arrays vacíos
        cochesReservados = new ArrayList<>();
    }
    public void agregarCocheComprado(Coche coche){
        cochesComprados.add(coche);
        coche.setEstado("comprado");
    }
    public void agregarCocheReservado(Coche coche){
        cochesReservados.add(coche);
        coche.setEstado("reservado");

    }
    public void imprimirCochesComprados(Cliente cliente){
        for(Coche coche: cochesComprados){
            System.out.println("Coches comprados: ");
            System.out.println("Marca: " + coche.getMarca());
            System.out.println("Modelo: " + coche.getModelo());
            System.out.println("Matrícula: " + coche.getMatricula());
            System.out.println("Precio de compra: " + coche.getPrecioCompra());
            System.out.println("Precio de venta: " + coche.getPrecioVenta());
        }
    }
    public void imprimirCochesReservados(Cliente cliente){
        for(Coche coche: cochesReservados){
            System.out.println("Coches reservados: ");
            System.out.println("Marca: " + coche.getMarca());
            System.out.println("Modelo: " + coche.getModelo());
            System.out.println("Matrícula: " + coche.getMatricula());
            System.out.println("Precio de compra: " + coche.getPrecioCompra());
            System.out.println("Precio de venta: " + coche.getPrecioVenta());
        }
    }
}
