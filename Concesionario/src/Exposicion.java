import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exposicion {
    private String tipo;
    private int numExposicion;
    private int telefono;
    private String direccion;
    private ArrayList<Coche> coches;

    public Exposicion(String tipo, int numExposicion, int telefono, String direccion) {
        this.tipo = tipo;
        this.numExposicion = numExposicion;
        this.telefono = telefono;
        this.direccion = direccion;
        coches = new ArrayList<>();

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumExposicion() {
        return numExposicion;
    }

    public void setNumExposicion(int numExposicion) {
        this.numExposicion = numExposicion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public void agregarCoche(Coche coche){
        coches.add(coche);
        coche.setEstado("en exposición");
   }
    public void borrarCoche(Coche coche){
        coches.remove(coche);
    }

    public void modificarExpo(){
        Scanner expo = new Scanner(System.in);
        System.out.println("Introduce los nuevos datos de la exposicion" + getNumExposicion() + ": ");
        System.out.println("Tipo de exposición: ");
        String tipo = expo.nextLine();
        setTipo(tipo);
        System.out.println("Teléfono: ");
        int telefono = expo.nextInt();
        setTelefono(telefono);
        System.out.println("Dirección: ");
        expo.nextLine();
        String direccion = expo.nextLine();
        setDireccion(direccion);
        System.out.println("Los datos han sido modificados correctamente");
    }
}