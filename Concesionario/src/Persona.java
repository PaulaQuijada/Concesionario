public class Persona {
    private String nombre;
    private String direccion;
    private String DNI;
    private int telefono;

    public Persona(String nombre, String direccion, String DNI, int telefono) throws Exception{
       if (nombre.equals("")) throw new Exception("El campo 'nombre' no puede estar vacío");
        this.nombre = nombre;
        this.direccion = direccion;
        if (DNI.equals("")) throw new Exception("El campo 'DNI' no puede estar vacío");
        this.DNI = DNI;
        if () throw new Exception("El teléfono introducido no es válido");
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
