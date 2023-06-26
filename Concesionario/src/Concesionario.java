import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Cliente> clientes;
    private ArrayList<VendedorAComision> vendedores;
    private ArrayList<Coche> coches;
    private ArrayList<Exposicion> exposiciones;

    public Concesionario(ArrayList<Cliente> clientes, ArrayList<VendedorAComision> vendedores, ArrayList<Coche> coches, ArrayList<Exposicion> exposiciones) {
        this.clientes = clientes;
        this.vendedores = vendedores;
        this.coches = coches;
        this.exposiciones = exposiciones;

    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
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
    public ArrayList<Cliente> clientes (){ //Aquí agrego clientes base

        clientes.add(new Cliente("Pepe", "C/Sevilla", "36354641G", 634657584));
        clientes.add(new Cliente("Lucía", "C/Málaga", "26539704W", 624378512));
        return clientes;
    }
    public void agregarCliente(Cliente cliente) { //Este servirá para agregar un cliente por scanner
        clientes.add(cliente);
    }
    public void removeCliente(Cliente cliente) { //Este servirá para eliminar un cliente por scanner
        clientes.remove(cliente);
    }
    public ArrayList<VendedorAComision> vendedores(){ //Aquí agrego vendedores base
        vendedores.add(new VendedorAComision("David","Avd. Las Flores", "07317266F", 671365975));
        return vendedores;
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
