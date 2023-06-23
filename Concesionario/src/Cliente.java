import java.util.ArrayList;
public class Cliente extends Persona{
    private ArrayList<Coche> coches;
    private ArrayList<Cliente> clientes;
    public Cliente(String nombre, String direccion, String DNI, int telefono) throws Exception {
        super(nombre, direccion, DNI, telefono);
    }
    public void agregarCliente(ArrayList<Cliente> clientes) throws Exception {
        clientes.add(new Cliente());
    }
    public void removeCliente(int posicion, ArrayList<Cliente> clientes) throws Exception {
        clientes.remove(posicion);
    }
    public int agregarCocheComprado(Coche coche){
        coches.add(new Coche("turismo", "disponible","Seat", "Ibiza", "5828RKY", 10.000f, 7.000f));
    }
    public int agregarCocheReservado(Coche coche){}

}
