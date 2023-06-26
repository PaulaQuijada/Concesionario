import java.util.ArrayList;

public class VendedorAComision extends Persona{
    private ArrayList<Coche> coches;
    public VendedorAComision(String nombre, String direccion, String DNI, int telefono){
        super(nombre, direccion, DNI, telefono);
        coches = new ArrayList<>();
    }

    public void agregarCocheVendido(Coche coche){


    }
}
