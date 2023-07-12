
import java.util.Date;
import java.util.ArrayList;

public class Reparacion {
    private TipoReparacion tipo;
    private Date fecha;
    private String descripcion;
    private Coche coche;
    private boolean resuelta;

    public Reparacion(TipoReparacion tipo, Date fecha, String descripcion, Coche coche) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.coche = coche;

    }

    public TipoReparacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoReparacion tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }

    // Método para cambiar el estado de un coche a "En reparación"


    // Otros métodos relevantes para la gestión de reparaciones

    @Override
    public String toString() {
        return "Reparacion{" +
                "tipo=" + tipo +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}