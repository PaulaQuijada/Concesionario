package Scanners;

import Clases.Cliente;
import Clases.Coche;
import Clases.Concesionario;
import Clases.EstadoCoche;
import Excepciones.InvalidException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerReservas {
    private Concesionario concesionario;
    private HashMap<String, Coche> coches;
    private HashMap<String, Cliente> clientes;

    public ScannerReservas(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
        this.clientes = concesionario.getClientes();
    }

    public void reservarCoche() {
        Scanner reserva = new Scanner(System.in);
        try {
            System.out.println("Introduce la matrícula del coche a reservar: ");
            String matricula = reserva.nextLine();

            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                System.out.println("Introduce el dni del cliente:");
                String dni = reserva.nextLine();

                if (clientes.containsKey(dni)) {
                    Cliente cliente = clientes.get(dni);
                    coche.setEstado(EstadoCoche.RESERVADO);
                    cliente.agregarCocheReservado(coche);
                    concesionario.removeCoche(matricula);
                    System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido reservado por el cliente: " + cliente.getNombre());
                } else System.out.println("El cliente no está dado de alta");
            } else System.out.println("El coche no está disponible en el stock del concesionario.");
        }
     catch(Exception e){
         System.out.println(e.getMessage());
        }
    }
    public void cancelarReserva(){
        Scanner cancelar = new Scanner(System.in);
        try{ System.out.println("Introduce el dni del cliente:");
        String dni = cancelar.nextLine();
        if (clientes.containsKey(dni)) {
            Cliente cliente = clientes.get(dni);
            System.out.println("Introduce la matrícula del coche para cancelar la reserva");
            String matricula = cancelar.nextLine();
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
                if(conteo == reservas.size()) System.out.println("El coche no está en la lista de reservas del cliente");
            }

        } else throw new InvalidException("El cliente no está dado de alta");
    }
        catch (InvalidException e){
            System.out.println(e.getMessage());
            //volver al menú principal
        }
    }
}
