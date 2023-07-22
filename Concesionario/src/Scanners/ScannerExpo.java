package Scanners;
import Clases.Coche;
import Clases.Concesionario;
import Clases.EstadoCoche;
import Clases.Exposicion;
import Comprobaciones.Float.ComprobarPrecioCompra;
import Comprobaciones.Int.ComprobarNumExpo;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDireccion;
import Comprobaciones.String.ComprobarMatricula;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerExpo {
    private Concesionario concesionario;
    private HashMap<Integer, Exposicion> exposiciones;
    private HashMap<String, Coche> coches;
    private ComprobarNumExpo comprobarNumExpo = new ComprobarNumExpo();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();

    public ScannerExpo(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.exposiciones = concesionario.getExposiciones();
        this.coches = concesionario.getCoches();
    }

    public Exposicion agregarExposicion() {
        Scanner expo = new Scanner(System.in);
        try {
            System.out.println("Introduce los datos para crear una exposición: ");
            System.out.print("Número de exposición: ");
            int numExpo = expo.nextInt();
            comprobarNumExpo.comprobacion(numExpo);

            System.out.print("Teléfono: ");
            int telefono = expo.nextInt();
            comprobarTlf.comprobacion(telefono);

            System.out.print("Dirección: ");
            expo.nextLine();
            String direccion = expo.nextLine();
            comprobarDireccion.comprobacion(direccion);

            Exposicion exposicion = new Exposicion(numExpo, telefono, direccion);
            concesionario.agregarExposicion(exposicion);
            return exposicion;
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
        return null;
    } //COMPROBADO

    public void removeExposicion() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el número de exposición a eliminar: ");
            int numExpo = scanner.nextInt();
            comprobarNumExpo.comprobacion(numExpo);
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                exposiciones.remove(numExpo, exposicion);
                System.out.println("La exposición ha sido eliminada correctamente");
            } else throw new NotFoundException("La exposición indicada no existe en el concesionario");
        }
        catch (NotFoundException | InvalidException notFound){
            System.out.println(notFound.getMessage());
        }
    } //COMPROBADO

    public void imprimirDatosExposicion() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el número de exposición a ver: ");
            int numExpo = scanner.nextInt();
            comprobarNumExpo.comprobacion(numExpo);
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                System.out.println("Número de exposición: " + exposicion.getNumExposicion());
                System.out.println("Teléfono: " + exposicion.getTelefono());
                System.out.println("Dirección: " + exposicion.getDireccion());
            } else throw new NotFoundException("El número de exposición introducido no existe");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
        }
    } //COMPROBADO

    public void imprimirCochesExpo() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el número de exposición para mirar sus coches:");
            int numExpo = scanner.nextInt();
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                ArrayList<Coche> coches = exposicion.getCoches();
                if (coches == null || coches.isEmpty()) {
                    throw new InvalidException("Esta exposición no tiene coches");
                } else {
                    for (Coche coche : coches) {
                        exposicion.imprimirCochesExpo();
                    }
                }
            } else throw new NotFoundException("El número de exposición introducido no existe");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
        catch (NotFoundException notFound){
            System.out.println(notFound.getMessage());
        }
    } //COMPROBADO

    public void modificarExpo() {
        Scanner expo = new Scanner(System.in);
        try {
            System.out.print("Introduce el número de exposición a modificar: ");
            int numExpo = expo.nextInt();
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                System.out.println("Introduce los nuevos datos de la exposicion número " + exposicion.getNumExposicion() + ": ");
                System.out.print("Teléfono: ");
                int telefono = expo.nextInt();
                exposicion.setTelefono(telefono);

                System.out.print("Dirección: ");
                expo.nextLine();
                String direccion = expo.nextLine();
                exposicion.setDireccion(direccion);


                System.out.println("Los datos han sido modificados correctamente");
            } else throw new NotFoundException("El número de exposición introducido no existe");

        } catch (NotFoundException | InvalidException n) {
            System.out.println(n.getMessage());
        }
    } //COMPROBADO

    public void agregarCocheAExpo() {
        Scanner expo = new Scanner(System.in);
        try {
            System.out.print("Introduce la matrícula del coche a agregar a la exposición: ");
            String matricula = expo.nextLine();

            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);

                System.out.println("Elige si quieres crear una nueva exposición o utilizar una existente: ");
                System.out.println("1-Crear nueva exposición");
                System.out.println("2-Exposición existente");
                int num = expo.nextInt();
                if (num == 1) {
                    Exposicion exposicion = agregarExposicion();
                    coche.setEstado(EstadoCoche.EN_EXPOSICION);
                    exposicion.agregarCoche(coche);
                    coches.remove(matricula);
                } else {
                    System.out.print("Introduce el número de exposición para añadir el coche: ");
                    num = expo.nextInt();
                    if (exposiciones.containsKey(num)) {
                        Exposicion exposicion1 = exposiciones.get(num);
                        coche.setEstado(EstadoCoche.EN_EXPOSICION);
                        exposicion1.agregarCoche(coche);
                        coches.remove(matricula);
                    } else throw new NotFoundException("La exposición indicada no existe");
                }

            } else throw new NotFoundException("El coche introducido no existe");

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    } //COMPROBADO

    public void removeCocheExpo() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Para eliminar un coche de la exposición introduce primero el número de exposición: ");
            int numExpo = scanner.nextInt();
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                System.out.println("------------------------------");
                System.out.println("Estos son los coches que tiene esta exposición: ");
                exposicion.imprimirCochesExpo();
                System.out.print("Introduce la matrícula del coche a eliminar de la exposición: ");
                scanner.nextLine();
                String matricula = scanner.nextLine();
                ArrayList<Coche> coches = exposicion.getCoches();
                for (Coche coche : coches) {
                    if (coche.getMatricula().equals(matricula)) {
                        coche.setEstado(EstadoCoche.EN_VENTA);
                        exposicion.borrarCoche(coche);
                        concesionario.agregarCoche(coche);
                    } else throw new InvalidException("El coche introducido no existe");
                }
            } else throw new InvalidException("No existe la exposición introducida");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    } //COMPROBADO


    public void cambiarCocheDeExposicion() {
        Scanner cambio = new Scanner(System.in);
        try {
            System.out.println("Introduce el número de exposición a modificar: ");
            int numExpo = cambio.nextInt();

            if (exposiciones.containsKey(numExpo)) {
                System.out.println("Aquí está la lista de coches de la exposición: ");
                Exposicion exposicion = exposiciones.get(numExpo);
                exposicion.imprimirCochesExpo();
                System.out.println("-----------------------");
                System.out.println("Introduce la matrícula del coche a cambiar de exposición: ");
                cambio.nextLine();
                String matricula = cambio.nextLine();
                ArrayList<Coche> cochesExpo = exposicion.getCoches();
                for (Coche coche : cochesExpo) {
                    if (coche.getMatricula().equals(matricula)) {
                        exposicion.borrarCoche(coche);
                        System.out.println("Elige entre dos opciones: ");
                        System.out.println("1-Añadir coche a una exposición nueva ");
                        System.out.println("2-Añadir coche a una exposición ya existente ");
                        numExpo = cambio.nextInt();
                        if (numExpo == 1) {
                            Exposicion nuevaExpo=agregarExposicion();
                            nuevaExpo.agregarCoche(coche);
                            System.out.println("El coche se ha añadido correctamente");
                        } else if(numExpo == 2) {System.out.println("Introduce el número de exposición donde quieres mover el coche: ");
                        numExpo = cambio.nextInt();
                        if (exposiciones.containsKey(numExpo)) {
                            Exposicion exposicion1 = exposiciones.get(numExpo);
                            exposicion1.agregarCoche(coche);
                            System.out.println("El coche se ha añadido correctamente");
                            break;
                        }
                        } else throw new InvalidException("El número de exposición introducida no existe");
                    } else throw new NotFoundException("El coche no se encuentra en la exposición");
                }
            }
        }
        catch (InvalidException | NotFoundException e){
            System.out.println(e.getMessage());
        }
    } //COMPROBADO
}
