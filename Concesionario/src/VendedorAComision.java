import java.util.ArrayList;

public class VendedorAComision extends Persona{
    private ArrayList<Coche> coches;
    public VendedorAComision(String nombre, String direccion, String DNI, int telefono) throws Exception {
        super(nombre, direccion, DNI, telefono);
    }

    public void agregarCocheVendido(Coche coche){

    }
}
