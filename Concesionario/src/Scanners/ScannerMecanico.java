package Scanners;

import Clases.Coche;
import Clases.Concesionario;
import Clases.EstadoCoche;
import Clases.Reparacion;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerMecanico {

    private Concesionario concesionario;
    private HashMap<String, Coche> coches;

    public ScannerMecanico(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
    }
    public void repararCoche() {
        Scanner reparar = new Scanner(System.in);
        try {
            System.out.print("Introduce la matrícula del coche a reparar:");
            String matricula = reparar.nextLine();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                ArrayList<Reparacion> reparaciones = coche.getReparaciones();
                if(!reparaciones.isEmpty()){
                    for(Reparacion reparacion : reparaciones){
                        reparacion.setResuelta(true);
                    }
                    coche.setEstado(EstadoCoche.EN_VENTA);
                    System.out.println("Todas las reparaciones han sido corregidas");
                } else throw new InvalidException("El coche no tiene reparaciones");
            } else throw new NotFoundException("El coche no se encuentra en el stock del concesionario");
        }
        catch (InvalidException e){
            System.out.println(e.getMessage());
        }
        catch (NotFoundException notFound){
            System.out.println(notFound.getMessage());
        }
    }

}
