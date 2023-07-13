
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Coche {
    private String tipo;
    private String marca;
    private String modelo;
    private String color; //he añadido este atributo
    private String estado;
    private String matricula;
    private float precioVenta;
    private float precioCompra;
    private Exposicion exposicion;
    private ArrayList<Reparacion> reparaciones;

    public Coche(String tipo, String marca, String modelo, String color, String estado, String matricula, float precioVenta, float precioCompra) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.estado = estado;
        this.matricula = matricula;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        reparaciones = new ArrayList<>();

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Exposicion getExposiciones() {
        return exposicion;
    }

    public void setExposiciones(Exposicion exposicion) {
        this.exposicion = exposicion;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public void modificarCoche(){
        Scanner coche = new Scanner(System.in);
        System.out.println("Introduce los nuevos datos para el coche con matrícula " + getMatricula() + ": ");
        System.out.println("Color: ");
        String color = coche.nextLine();
        setColor(color);
        System.out.println("Matrícula: ");
        String matricula = coche.nextLine();
        setMatricula(matricula);
        System.out.println("Precio de venta:");
        float nuevoPrecioVenta = coche.nextFloat();
        setPrecioVenta(nuevoPrecioVenta);
        System.out.println("Precio de compra: ");
        float nuevoPrecioCompra = coche.nextFloat();
        setPrecioCompra(nuevoPrecioCompra);
        System.out.println("Los datos han sido modificados correctamente");
        System.out.println();
    }
    public void agregarCocheAReparar(Reparacion reparacion) {
        reparaciones.add(reparacion);
        setEstado("en reparación");
    }

    public void agregarCochesReparados(Reparacion reparacion) {
        if (reparacion.isResuelta()) {
            reparaciones.add(reparacion); // Agregamos la reparación a la lista de reparaciones reparadas
            setEstado("reparado");
        }
    }

    public void imprimirReparaciones() {
        reparaciones.sort((r1, r2) -> r2.getFecha().compareTo(r1.getFecha()));
        System.out.println("Reparaciones del coche: " + matricula);
        for (Reparacion reparacion : reparaciones) {
            System.out.println("Tipo de reparación: " + reparacion.getTipo());
            if(reparacion.isResuelta() == true) System.out.println("Estado: resuelta");
            else System.out.println("Estado: no resuelta");
            System.out.println("Fecha: " + reparacion.getFecha());
            System.out.println("--------------------------");
        }
    }
    public void imprimirCoche(){
        System.out.println("Datos del coche:");
        System.out.println("Tipo de coche: " + getTipo());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Color: " + getColor());
        System.out.println("Estado: " + getEstado());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Precio de venta: " + getPrecioVenta());
        System.out.println("Precio de compra: " + getPrecioCompra());
        if(reparaciones.size() == 0) System.out.println("Este coche no tiene reparaciones pendientes");
        else System.out.println("Reparaciones:" + getReparaciones());
    }
}
