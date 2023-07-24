package Scanners;

import Clases.*;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarMatricula;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerReservas {
    private Concesionario concesionario;
    private HashMap<String, Coche> coches;
    private HashMap<String, Cliente> clientes;
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarMatricula comprobarMatricula = new ComprobarMatricula();

    public ScannerReservas(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
        this.clientes = concesionario.getClientes();

    }

    public void reservarCoche() {
        Scanner reserva = new Scanner(System.in);
        try {
            System.out.print("Introduce la matrícula del coche a reservar: ");
            String matricula = reserva.nextLine();
            comprobarMatricula.comprobacion(matricula);
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                System.out.print("Introduce el dni del cliente:");
                String dni = reserva.nextLine();
                comprobarDNI.comprobacion(dni);
                if (clientes.containsKey(dni)) {
                    Cliente cliente = clientes.get(dni);
                    coche.setEstado(EstadoCoche.RESERVADO);
                    cliente.agregarCocheReservado(coche);
                    concesionario.removeCoche(matricula);
                    System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido reservado por el cliente: " + cliente.getNombre());
                } else throw new NotFoundException("El cliente no está dado de alta");
            } else throw new NotFoundException("El coche no está disponible en el stock del concesionario.");
        }
     catch(NotFoundException | InvalidException e){
         System.out.println(e.getMessage());
        }
    }
    public void cancelarReserva(){
        Scanner cancelar = new Scanner(System.in);
        try{ System.out.print("Introduce el dni del cliente:");
        String dni = cancelar.nextLine();
            comprobarDNI.comprobacion(dni);
        if (clientes.containsKey(dni)) {
            Cliente cliente = clientes.get(dni);
            System.out.print("Introduce la matrícula del coche para cancelar la reserva");
            String matricula = cancelar.nextLine();
            comprobarMatricula.comprobacion(matricula);
            ArrayList<Coche> reservas = cliente.getCochesReservados();
            int conteo = 0;
            for(Coche coche : reservas){
                conteo++;
                if(coche.getMatricula().equals(matricula)){
                    coche.setEstado(EstadoCoche.EN_VENTA);
                    concesionario.agregarCoche(coche);
                    cliente.removeCocheReservado(coche);
                    conteo = 0;
                }
                if(conteo == reservas.size()) throw new NotFoundException("El coche no está en la lista de reservas del cliente");
            }

        } else throw new NotFoundException("El cliente no está dado de alta");
    }
        catch (NotFoundException | InvalidException e){
            System.out.println(e.getMessage());
        }
    }
    public void consolaReservas(){
        Scanner reservas = new Scanner(System.in);
        System.out.println("1-RESERVAR COCHE");
        System.out.println("2-CANCELAR RESERVA");
        int opcion = reservas.nextInt();
        if(opcion == 1) reservarCoche();
        if(opcion == 2) cancelarReserva();
    }

}
