package Clases;
import Excepciones.CocheException;
import java.util.ArrayList;

public class Coche {
    private TipoCoche tipo;
    private String marca;
    private String modelo;
    private String color; //he añadido este atributo
    private EstadoCoche estado;
    private String matricula;
    private float precioVenta;
    private float precioCompra;

    private ArrayList<Reparacion> reparaciones;

    public Coche(TipoCoche tipo, String marca, String modelo, String color, EstadoCoche estado, String matricula, float precioVenta, float precioCompra) throws CocheException {
        this.tipo = tipo;
        if(marca == null || marca.trim().isEmpty()) throw new CocheException("La marca del coche no puede estar vacía");
        this.marca = marca;
        if(modelo == null || modelo.trim().isEmpty()) throw new CocheException("El modelo del coche no puede estar vacío");
        this.modelo = modelo;
        if(color == null || color.trim().isEmpty()) throw new CocheException("El color del coche no puede estar vacío");
        this.color = color;
        if(estado == null) throw new CocheException("El estado del coche no puede estar vacío");
        this.estado = estado;
        String ultimasTresLetras = matricula.substring(4); // Obtener las últimas tres letras
        if(matricula == null || matricula.length() !=7 || !ultimasTresLetras.matches("[A-Z]{3}")) throw new CocheException("La matrícula introducida no es válida");
        this.matricula = matricula;
        if(precioVenta <= 0) throw new CocheException("El precio no puede ser menor o igual a 0");
        this.precioVenta = precioVenta;
        if(precioCompra <= 0) throw new CocheException("El precio no puede ser menor o igual a 0");
        this.precioCompra = precioCompra;

        this.reparaciones = new ArrayList<>();
    }

    public TipoCoche getTipo() {
        return tipo;
    }

    public void setTipo(TipoCoche tipo) {
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

    public EstadoCoche getEstado() {
        return estado;
    }

    public void setEstado(EstadoCoche estado) {
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

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }


    public void agregarCocheAReparar(Reparacion reparacion) {
        reparaciones.add(reparacion);
    }

    public void agregarCochesReparados(Reparacion reparacion) {
        if (reparacion.isResuelta()) {
            reparaciones.add(reparacion); // Agregamos la reparación a la lista de reparaciones reparadas
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

}

