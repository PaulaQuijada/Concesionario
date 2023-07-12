
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Concesionario {
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Coche> coches;
    private HashMap<Coche, Cliente> compras;
    private HashMap<Integer, Exposicion> exposiciones;

    public Concesionario() { // Creo los hashmap vacíos y llamando a los métodos se agregan de base
        clientes = new HashMap<>();
        clientes();
        vendedores = new HashMap<>();
        vendedores();
        coches = new HashMap<>();
        cochesStock();
        compras = new HashMap<>();
        exposiciones = new HashMap<>();
    }


    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<String, VendedorAComision> getVendedores() {
        return vendedores;
    }

    public void setVendedores(HashMap<String, VendedorAComision> vendedores) {
        this.vendedores = vendedores;
    }

    public HashMap<String, Coche> getCoches() {
        return coches;
    }

    public void setCoches(HashMap<String, Coche> coches) {
        this.coches = coches;
    }

    public HashMap<Coche, Cliente> getCompras() {
        return compras;
    }

    public void setCompras(HashMap<Coche, Cliente> compras) {
        this.compras = compras;
    }

    public HashMap<Integer,Exposicion> getExposiciones() {
        return exposiciones;
    }

    public void setExposiciones(HashMap<Integer,Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }

    public void clientes() { //Aquí agrego clientes base

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

        clientes.put(dni, new Cliente(nombre, direccion, dni, telefono));
    }

    public void removeCliente() { //Este servirá para eliminar un cliente por scanner
        Scanner removeCliente = new Scanner(System.in);
        System.out.println("Introduce el DNI del cliente a dar de baja: ");
        String dni = removeCliente.nextLine();
        clientes.remove(dni);
    }

    public Cliente obtenerCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI del cliente: ");
        String dni = scanner.nextLine();

        if (getClientes().containsKey(dni)) {
            return getClientes().get(dni);
        } else {
            System.out.println("El cliente con DNI " + dni + " no existe en el concesionario.");
            System.out.println("Si quiere darse de alta como cliente introduce 1: ");

            return obtenerCliente();
        }
    }

    public void imprimirDatosCliente() {
        for (Map.Entry<String, Cliente> altaClientes : clientes.entrySet()) {
            Cliente cliente = altaClientes.getValue();
            System.out.println("Datos del cliente: ");
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("DNI: " + cliente.getDNI());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("------------------------");
        }
    }

    public void vendedores() { //Aquí agrego vendedores base
        vendedores.put("07317266F", new VendedorAComision("Mariano", "Avd. Las Flores", "07317266F", 671365975));
        vendedores.put("53187645H", new VendedorAComision("Carlota", "C/Mayor", "53187645H", 654059348));

    }

    public void agregarVendedor() { //Este servirá para agregar un vendedor por scanner
        Scanner añadirVendedor = new Scanner(System.in);
        System.out.println("Introduzca los datos del cliente: ");
        System.out.println("Introduzca su nombre: ");
        String nombre = añadirVendedor.nextLine();
        System.out.println("Introduzca su dirección: ");
        String direccion = añadirVendedor.nextLine();
        System.out.println("Introduzca su DNI: ");
        String dni = añadirVendedor.nextLine();
        System.out.println("Introduzca su número de teléfono: ");
        int telefono = añadirVendedor.nextInt();
        // if(nuevoTeléfono < 99999999 && nuevoTeléfono > 999999999) throw new Exception("El nuevo teléfono no puede ser menor ni mayor a 9 cifras");

        vendedores.put(dni, new VendedorAComision(nombre, direccion, dni, telefono));
    }

    public void removeVendedor() { //Este servirá para eliminar un vendedor por scanner
        Scanner removeVendedor = new Scanner(System.in);
        System.out.println("Introduce el DNI del vendedor a dar de baja: ");
        String dni = removeVendedor.nextLine();
        vendedores.remove(dni);
    }

    public VendedorAComision obtenerVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI del vendedor: ");
        String dni = scanner.nextLine();

        if (getVendedores().containsKey(dni)) {
            return getVendedores().get(dni);
        } else {
            System.out.println("El vendedor con DNI " + dni + " no existe en el concesionario.");
            System.out.println("Si quiere darse de alta como vendedor introduce 1: ");

            return obtenerVendedor();
        }
    }

    public void imprimirDatosVendedor() {
        for (Map.Entry<String, VendedorAComision> altaVendedor : vendedores.entrySet()) {
            VendedorAComision vendedores = altaVendedor.getValue();
            System.out.println("Datos del vendedor: ");
            System.out.println("Nombre: " + vendedores.getNombre());
            System.out.println("Dirección: " + vendedores.getDireccion());
            System.out.println("DNI: " + vendedores.getDNI());
            System.out.println("Teléfono: " + vendedores.getTelefono());
            System.out.println("------------------------");
        }
    }

    public void agregarCoche() { //Este servirá para agregar un coche por scanner
        Scanner añadirCoche = new Scanner(System.in);
        String tipo = "x";
        System.out.println("Introduce el tipo de coche a añadir siendo 1-Vehículos.Turismo, 2-Vehículos.Industrial o 3-Vehículos.Todoterreno: ");
        int num = añadirCoche.nextInt();
        añadirCoche.nextLine();
        if (num == 1) tipo = "Vehículos.Turismo";
        if (num == 2) tipo = "Vehículos.Industrial";
        if (num == 3) tipo = "Vehículos.Todoterreno";
        System.out.println("Introduzca los datos del coche a añadir: ");
        System.out.println("Marca: ");
        String marca = añadirCoche.nextLine();
        System.out.println("Modelo: ");
        String modelo = añadirCoche.nextLine();
        System.out.println("Color: ");
        String color = añadirCoche.nextLine();
        String estado = "en venta";
        System.out.println("Matrícula: ");
        String matricula = añadirCoche.nextLine();
        System.out.println("Precio de compra: ");
        float precioCompra = añadirCoche.nextFloat();
        System.out.println("Precio de venta: ");
        float precioVenta = añadirCoche.nextFloat();

        if (num == 1)
            coches.put(matricula, new Turismo(tipo, marca, modelo, color, estado, matricula, precioCompra, precioVenta));
        if (num == 2)
            coches.put(matricula, new Industrial(tipo, marca, modelo, color, estado, matricula, precioCompra, precioVenta));
        if (num == 3)
            coches.put(matricula, new Todoterreno(tipo, marca, modelo, color, estado, matricula, precioCompra, precioVenta));
    }

    public void removeCoche() { //Este servirá para eliminar un coche por scanner
        Scanner removeCoche = new Scanner(System.in);
        System.out.println("Introduce la matrícula del coche a eliminar: ");
        String matricula = removeCoche.nextLine();
        coches.remove(matricula);
    }

    public void registrarVenta(Coche coche, Cliente cliente) {
        compras.put(coche, cliente);
    }

    public HashMap<Coche, Cliente> clientesCompradores() {
        return compras;
    }

    public void queCoches() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un dni para consultar datos de los coches: ");
        String dni = scanner.nextLine();
        if (clientes.containsKey(dni)) {
            Cliente cliente = clientes.get(dni);
            cliente.imprimirCochesComprados();
            cliente.imprimirCochesReservados();
        }
        if (vendedores.containsKey(dni)) {
            VendedorAComision vendedor = vendedores.get(dni);
            vendedor.imprimirCochesVendidos();
        }
    }

    public HashMap<String, Coche> cochesStock() {
        Turismo coche1 = new Turismo("turismo", "Seat", "Ibiza", "blanco", "en venta", "2452GVW", 15000f, 6000f);
        Turismo coche2 = new Turismo("turismo", "Audi", "Q8", "negro", "en venta", "1648TBD", 85000f, 38000f);

        coches.put("2452GVW", coche1);
        coches.put("1648TBD", coche2);
        return coches;
    }

    public void imprimirStock(HashMap<String, Coche> cochesStock) {
        if (cochesStock.isEmpty()) {
            System.out.println("No hay coches en stock");
        } else {
            for (Coche stock : cochesStock.values()) {
                System.out.println("Coches en venta: ");
                System.out.println("Tipo: " + stock.getTipo());
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

    public void venderCoche() {
        Scanner venta = new Scanner(System.in);
        System.out.println("Introduce la matrícula del coche a vender: ");
        String matricula = venta.nextLine();

        if (coches.containsKey(matricula)) { // Comprueba si el coche está en el HashMap de coches del concesionario
            Coche coche = getCoches().get(matricula); // Obtiene el coche del HashMap de coches

            Cliente cliente = obtenerCliente(); // Obtén el cliente de alguna manera, por ejemplo, a través de la entrada del usuario o consultando el concesionario
            VendedorAComision vendedor = obtenerVendedor();

            vendedor.agregarCocheVendido(coche);
            cliente.agregarCocheComprado(coche); // Agrega el coche al método agregarCocheComprado de la clase Cliente
            getCoches().remove(matricula); // Elimina el coche del HashMap de coches del concesionario
            System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido vendido al cliente: " + cliente.getNombre());
        } else {
            System.out.println("El coche no está disponible en el stock del concesionario.");
        }
    }

    public void reservarCoche() {
        Scanner reserva = new Scanner(System.in);
        System.out.println("Introduce la matrícula del coche a reservar: ");
        String matricula = reserva.nextLine();

        if (getCoches().containsKey(matricula)) { // Comprueba si el coche está en el HashMap de coches del concesionario
            Coche coche = getCoches().get(matricula); // Obtiene el coche del HashMap de coches

            Cliente cliente = obtenerCliente(); // Obtén el cliente de alguna manera, por ejemplo, a través de la entrada del usuario o consultando el concesionario

            cliente.agregarCocheReservado(coche); // Agrega el coche al método agregarCocheComprado de la clase Cliente
            getCoches().remove(matricula); // Elimina el coche del HashMap de coches del concesionario
            System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido reservado por el cliente: " + cliente.getNombre());
            cliente.imprimirCochesReservados();
        } else {
            System.out.println("El coche no está disponible en el stock del concesionario.");
        }
    }

    public Exposicion agregarExposicion(){
        Scanner expo = new Scanner(System.in);
        System.out.println("Introduce los datos para crear una exposición: ");
        System.out.println("Tipo de exposición: ");
        String tipo = expo.nextLine();
        System.out.println("Número de exposición: ");
        int numExpo = expo.nextInt();
        System.out.println("Teléfono: ");
        int telefono = expo.nextInt();
        String consumirespacio = expo.nextLine();
        System.out.println("Dirección: ");
        String direccion = expo.nextLine();

        Exposicion exposicion = new Exposicion(tipo,numExpo,telefono,direccion);
        exposiciones.put(numExpo, exposicion);

        return exposicion;
    }
    public void removeExposicion(){}

    public void imprimirDatosExposicion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige la exposición a ver: ");
        int numExpo = scanner.nextInt();
        if (exposiciones.containsKey(numExpo)) {
            Exposicion exposicion = exposiciones.get(numExpo);
            System.out.println("Tipo de exposición: " + exposicion.getTipo());
            System.out.println("Número de exposición: " + exposicion.getNumExposicion());
            System.out.println("Teléfono: " + exposicion.getTelefono());
            System.out.println("Dirección: " + exposicion.getDireccion());
            ArrayList<Coche> coches1= exposicion.getCoches();
            if(coches1 == null || coches1.isEmpty()) System.out.println("Esta exposición no tiene coches");

            else {
                for (Coche coches : coches1) {
                    coches.imprimirCoche();
                }
            }
        }
        else System.out.println("No existe la exposición introducida");
    }

    public void agregarCocheAExpo(){
        Scanner expo = new Scanner (System.in);
        System.out.println("Introduce la matrícula del coche a agregar a la exposición: ");
        String matricula = expo.nextLine();
        if(coches.containsKey(matricula)){
            Coche coche = coches.get(matricula);

            System.out.println("Elige si quieres crear una nueva exposición o utilizar una existente: ");
            System.out.println("1-Crear nueva exposición");
            System.out.println("2-Exposición existente");
            int num = expo.nextInt();
            if(num == 1){
                Exposicion exposicion = agregarExposicion(); // crea una nueva expo
                exposiciones.put(exposicion.getNumExposicion(),exposicion); // se añade la expo al hashmap de exposiciones
                exposicion.agregarCoche(coche); // se añade el coche a la expo
                coches.remove(matricula);
            }
            else{
                System.out.println("Introduce el número de exposición: ");
                num = expo.nextInt();
                if(exposiciones.containsKey(num)){
                    Exposicion exposicion1= exposiciones.get(num);
                    exposicion1.agregarCoche(coche);
                    coches.remove(matricula);
                }
                else System.out.println("La exposición indicada no existe");
            }

        }
        else System.out.println("El coche introducido no existe");

    }

    public void cambiarExposicion() {
        Scanner cambio = new Scanner(System.in);
        if (exposiciones.isEmpty()) {
            System.out.println("No existen exposiciones");
            return;
        }

        System.out.println("Introduce el número de exposición a revisar: ");
        int num = cambio.nextInt();
        cambio.nextLine(); // Consumir el carácter de nueva línea

        if (!exposiciones.containsKey(num)) {
            System.out.println("No existe la exposición indicada");
        }

        Exposicion exposicion = exposiciones.get(num);
        System.out.println("Introduce la matrícula del coche a cambiar de exposición: ");
        String matricula = cambio.nextLine();

        ArrayList<Coche> cocheExpo = exposicion.getCoches();
        Coche cocheEncontrado = null;

        for (Coche coche : cocheExpo) {
            if (coche.getMatricula().equals(matricula)) {
                cocheEncontrado = coche;
                break;
            }
        }

        if (cocheEncontrado != null) {
            cocheExpo.remove(cocheEncontrado);
            System.out.println("Elige entre dos opciones: ");
            System.out.println("1-Añadir a una exposición nueva ");
            System.out.println("2-Añadir a una exposición ya existente ");
            int numExpo = cambio.nextInt();
            cambio.nextLine(); // Consumir el carácter de nueva línea

            if (numExpo == 1) {
                Exposicion exposicionNueva = agregarExposicion();
                exposicionNueva.agregarCoche(cocheEncontrado);
                int nuevoNumExpo = exposicionNueva.getNumExposicion();
                exposiciones.put(nuevoNumExpo, exposicionNueva);
                exposicion.borrarCoche(cocheEncontrado);
            } else {
                System.out.println("Introduce el número de exposición a la cual se mueve el coche: ");
                numExpo = cambio.nextInt();
                cambio.nextLine(); // Consumir el carácter de nueva línea

                if (exposiciones.containsKey(numExpo)) {
                    if (num != numExpo) {
                        Exposicion exposicionExistente = exposiciones.get(numExpo);
                        exposicionExistente.agregarCoche(cocheEncontrado);
                    } else {
                        System.out.println("Estás moviéndolo a la exposición anterior");
                    }
                } else {
                    System.out.println("La exposición introducida no existe");
                }
            }
        } else {
            System.out.println("El coche no existe");
        }
    }


    public void consola() {
        boolean infinito = true;
        Scanner consola = new Scanner(System.in);
        while (infinito == true) {
            System.out.println("Bienvenido a Concesionarios Pochaula");
            System.out.println("Elija una de estas opciones: ");
            System.out.println("Para entrar como cliente pulsa 1");
            System.out.println("Para entrar como vendedor pulsa 2");
            System.out.println("Para entrar como director pulsa 3");
            System.out.println("Para salir del menú pulsa 4");
            int numero = consola.nextInt();
            if (numero == 4) infinito = false;
            if(numero == 1){
                System.out.println("Para consultar los coches que tenemos en stock pulse 1.");
            }
        }


    }
}
