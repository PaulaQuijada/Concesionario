import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Cliente> clientes;
    private ArrayList<VendedorAComision> vendedores;
    private ArrayList<Coche> coches;
    private ArrayList<Exposicion> exposiciones;
    public void queCliente(){}
    public void queCoches(){}
    public ArrayList<Coche> cochesStock(ArrayList<Coche> coches){
        return coches;
    }
    public void cochesDisponibles(ArrayList<Coche> coches){
        coches.add(new Coche());
    }
    public void venderCoche(Coche coche,VendedorAComision vendedor, Cliente cliente){}
    public void reservarCoche(coche,cliente){}
    public void cambiarExposicion(coche,exposicion){}
}
