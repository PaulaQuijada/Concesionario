package Scanners;

import Clases.*;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarDireccion;
import Comprobaciones.String.ComprobarNombre;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerMecanico {

    private Concesionario concesionario;
    private HashMap<String, Coche> coches;
    private HashMap<String, Mecanico> mecanicos;
    private ComprobarNombre comprobarNombre = new ComprobarNombre();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();


    public ScannerMecanico(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
        this.mecanicos = concesionario.getMecanicos();
    }
    public void agregarMecanico() {
        Scanner añadirMecanico = new Scanner(System.in);
        try {
            System.out.println("Introduzca los datos del mecánico: ");
            System.out.print("Nombre: ");
            String nombre = añadirMecanico.nextLine();
            comprobarNombre.comprobacion(nombre);

            System.out.println("Apellido: ");
            String apellido = añadirMecanico.nextLine();
            comprobarNombre.comprobacion(apellido);

            System.out.print("Dirección: ");
            String direccion = añadirMecanico.nextLine();
            comprobarDireccion.comprobacion(direccion);

            System.out.print("DNI: ");
            String dni = añadirMecanico.nextLine();
            comprobarDNI.comprobacion(dni);

            System.out.print("Teléfono: ");
            int telefono = añadirMecanico.nextInt();
            comprobarTlf.comprobacion(telefono);
            Mecanico mecanico = new Mecanico(nombre, apellido, direccion, dni, telefono);
            concesionario.agregarMecanico(mecanico);
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            agregarMecanico();
        }
    } //COMPROBADO

    public void removeMecanico() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el DNI del mecánico a dar de baja: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            HashMap<String, Mecanico> mecanicos = concesionario.getMecanicos();
            if (mecanicos.containsKey(dni)) {
                concesionario.removeMecanico(dni);
            } else throw new NotFoundException("El mecánico no está dado de alta");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
        }
    }

    public void repararCoche() {
        Scanner reparar = new Scanner(System.in);
        try {
            concesionario.imprimirMecanicos();
            System.out.println("Introduce el dni del mecánico que quieras que arregle tu vehículo: ");
            String dni = reparar.nextLine();
            if (mecanicos.containsKey(dni)) {
                Mecanico mecanico = mecanicos.get(dni);
                System.out.print("Introduce la matrícula del coche a reparar:");
                String matricula = reparar.nextLine();
                if (coches.containsKey(matricula)) {
                    Coche coche = coches.get(matricula);
                    ArrayList<Reparacion> reparaciones = coche.getReparaciones();
                    if (!reparaciones.isEmpty()) {

                        for (Reparacion reparacion : reparaciones) {
                            reparacion.setResuelta(true);

                        }
                        mecanico.agregarCochesReparados(coche);
                        coche.setEstado(EstadoCoche.EN_VENTA);
                        System.out.println("Todas las reparaciones han sido corregidas");
                    } else throw new InvalidException("El coche no tiene reparaciones");
                } else throw new NotFoundException("El coche no se encuentra en el stock del concesionario");
            } else throw new NotFoundException("El mecánico escogido no está dado de alta");
        }
        catch (InvalidException | NotFoundException e){
            System.out.println(e.getMessage());
        }
    } //COMPROBADO

    public void consolaMecanico(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-CONSULTAR COCHES A REPARAR");
        System.out.println("2-REPARAR COCHE");
        int opcion = scanner.nextInt();
        if(opcion == 1) concesionario.consultarCochesAReparar();
        if(opcion == 2) repararCoche();


    }
}
