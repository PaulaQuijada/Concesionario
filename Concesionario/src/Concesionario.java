import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Cliente> clientes;
    private ArrayList<VendedorAComision> vendedores;
    private ArrayList<Coche> coches;
    private ArrayList<Exposicion> exposiciones;

    public Concesionario(ArrayList<Cliente> clientes, ArrayList<VendedorAComision> vendedores, ArrayList<Coche> coches, ArrayList<Exposicion> exposiciones) {
        this.clientes = clientes;
        this.vendedores = vendedores;
        this.coches = coches;
        this.exposiciones = exposiciones;

    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
    public void queCliente(){}
    public void queCoches(){}
    public ArrayList<Coche> cochesStock() {
        Coche coche1 = new Coche("Seat", "Ibiza", "turismo", "en venta", "2452GVW", 15000f, 6000f);

        for(Coche stock: coches) { //este for evita que se vuelva a añadir al arraylist de cochesStock
           if(stock.getMatricula().equals(coche1.getMatricula())){
               return coches;
           }
        }
        coches.add(coche1);
        return coches;
    }

    public void imprimirStock(ArrayList<Coche> cochesStock){
        for(Coche stock: cochesStock){
            System.out.println("Coches en venta: ");
            System.out.println("Marca: " + stock.getMarca());
            System.out.println("Modelo: " + stock.getModelo());
            System.out.println("Matrícula: " + stock.getMatricula());
            System.out.println("Precio de compra: " + stock.getPrecioCompra());
            System.out.println("Precio de venta: " + stock.getPrecioVenta());
        }
    }
    public void venderCoche(Coche coche,VendedorAComision vendedor, Cliente cliente){

    }
    public void reservarCoche(Coche coche,Cliente cliente){}
    public void cambiarExposicion(Coche coche,Exposicion exposicion){}
}
