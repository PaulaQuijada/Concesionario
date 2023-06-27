import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Concesionario {
    private HashMap<String, Cliente> clientes;
    private ArrayList<VendedorAComision> vendedores;
    private ArrayList<Coche> coches;
    private ArrayList<Exposicion> exposiciones;

    public Concesionario(HashMap<String,Cliente> clientes, ArrayList<VendedorAComision> vendedores, ArrayList<Coche> coches, ArrayList<Exposicion> exposiciones) {
        this.clientes = clientes;
        this.vendedores = vendedores;
        this.coches = coches;
        this.exposiciones = exposiciones;

    }
    public HashMap<String,Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String,Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<VendedorAComision> getVendedores() {
        return vendedores;
    }

    public void setVendedores(ArrayList<VendedorAComision> vendedores) {
        this.vendedores = vendedores;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public ArrayList<Exposicion> getExposiciones() {
        return exposiciones;
    }

    public void setExposiciones(ArrayList<Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }
    public void clientes (){ //Aquí agrego clientes base

        clientes.put("36354641G", new Cliente("Pepe", "C/Sevilla", "36354641G", 634657584));
        clientes.put("26539704W", new Cliente("Lucía", "C/Málaga", "26539704W", 624378512));

    }
    public void agregarCliente() { //Este servirá para agregar un cliente por scanner
        Scanner añadirCliente = new Scanner(System.in);
        System.out.println("Introduzca los datos del cliente: ");
        System.out.println("Introduzca su nombre: ");
        String nombre = añadirCliente.nextLine();
        System.out.println("Introduzca su dirección: ");
        String direccion = añadirCliente.nextLine();
        System.out.println("Introduzca su DNI: ");
        String dni = añadirCliente.nextLine();
        System.out.println("Introduzca su número de teléfono: ");
        int telefono = añadirCliente.nextInt();
        // if(nuevoTeléfono < 99999999 && nuevoTeléfono > 999999999) throw new Exception("El nuevo teléfono no puede ser menor ni mayor a 9 cifras");

        clientes.put(dni, new Cliente(nombre,direccion,dni,telefono));
    }
    public void removeCliente() { //Este servirá para eliminar un cliente por scanner
        Scanner removeCliente = new Scanner(System.in);
        System.out.println("Introduce el DNI del cliente a dar de baja: ");
        String dni = removeCliente.nextLine();
        clientes.remove(dni);
    }
    public void imprimirDatosCliente() {
        for (Map.Entry<String, Cliente> altaClientes : clientes.entrySet()) {
            Cliente cliente = altaClientes.getValue();
            System.out.println("Nombre del cliente: " + cliente.getNombre());
            System.out.println("Dirección del cliente: " + cliente.getDireccion());
            System.out.println("DNI del cliente: " + cliente.getDNI());
            System.out.println("Teléfono del cliente: " + cliente.getTelefono());
            System.out.println("------------------------");
        }
    }
    public ArrayList<VendedorAComision> vendedores(){ //Aquí agrego vendedores base
        vendedores.add(new VendedorAComision("David","Avd. Las Flores", "07317266F", 671365975));
        return vendedores;
    }
    public void agregarVendedor(VendedorAComision vendedor) { //Este servirá para agregar un cliente por scanner
        vendedores.add(vendedor);
    }
    public void removeVendedor(VendedorAComision vendedor) { //Este servirá para eliminar un cliente por scanner
        vendedores.remove(vendedores);
    }
    public void queCliente(){}
    public void queCoches(){}
    public ArrayList<Coche> cochesStock() {
        Coche coche1 = new Coche("Seat", "Ibiza","blanco", "turismo", "en venta", "2452GVW", 15000f, 6000f);
        Coche coche2 = new Coche("Audi", "Q8","negro","turismo", "en venta", "1648TBD",85.000f, 38.000f);

        coches.add(coche1);
        coches.add(coche2);
        return coches;
    }
    public void imprimirStock(ArrayList<Coche> cochesStock){
        if (cochesStock.isEmpty()){
            System.out.println("No hay coches en stock");
        }
        else {
            for (Coche stock : coches) {
                System.out.println("Coches en venta: ");
                System.out.println("Marca: " + stock.getMarca());
                System.out.println("Modelo: " + stock.getModelo());
                System.out.println("Color: " + stock.getColor());
                System.out.println("Estado: " + stock.getEstado());
                System.out.println("Matrícula: " + stock.getMatricula());
                System.out.println("Precio de compra: " + stock.getPrecioCompra());
                System.out.println("Precio de venta: " + stock.getPrecioVenta());
                System.out.println();
            }
        }
    }

    public void venderCoche(Coche coche, Cliente cliente) {
        if (coches.contains(coche)) { //Comprueba si el coche está en ArrayList cochesStock

            cliente.agregarCocheComprado(coche); // el coche que se compra se agrega al método agregarCocheComprado de la clase Cliente
             coches.remove(coche); //y aquí se elimina el coche del arraylist cochesStock

                System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido vendido al cliente: " + cliente.getNombre());
            } else {
                System.out.println("El coche no está disponible en el stock del concesionario.");
            }
        }
    public void reservarCoche(Coche coche,Cliente cliente){
            if (coches.contains(coche)) { //Comprueba si el coche está en mi arraylist cochesStock

                cliente.agregarCocheReservado(coche); //el coche reservado se agrega al método agregarCocheReservado de la clase Cliente


                System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido reservado al cliente: " + cliente.getNombre());
            } else {
                System.out.println("El coche no está disponible en el stock del concesionario.");
            }
        }

    public void cambiarExposicion(Coche coche,Exposicion exposicion){}


}
