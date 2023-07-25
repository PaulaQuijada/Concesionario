package Concesionario;

import java.util.Scanner;

import Clases.*;
import Excepciones.InvalidException;
import Scanners.*;

class Proyecto {
    private ScannerCliente SCli;
    private ScannerCoche SCo;
    private ScannerConcesionario SConce;
    private ScannerDirector SDir;
    private ScannerExpo SExpo;
    private ScannerMecanico SMec;
    private ScannerReparacion SRep;
    private ScannerReservas SRes;
    private ScannerVendedor SVend;
    private ScannerVentas SVentas;

    private Concesionario concesionario;

    public Proyecto() throws InvalidException {
        this.concesionario = new Concesionario();
        this.SCli = new ScannerCliente();
        this.SCo = new ScannerCoche();
        this.SVend = new ScannerVendedor();
        this.SDir = new ScannerDirector();
        this.SMec = new ScannerMecanico();
        this.SExpo = new ScannerExpo();
        this.SRep = new ScannerReparacion();
        this.SVentas = new ScannerVentas();
        this.SRes = new ScannerReservas();
        this.SConce = new ScannerConcesionario();
    }

    public ScannerCliente getSCli() {
        return SCli;
    }

    public ScannerCoche getSCo() {
        return SCo;
    }

    public ScannerConcesionario getSConce() {
        return SConce;
    }

    public ScannerDirector getSDir() {
        return SDir;
    }

    public ScannerExpo getSExpo() {
        return SExpo;
    }

    public ScannerMecanico getSMec() {
        return SMec;
    }

    public ScannerReparacion getSRep() {
        return SRep;
    }

    public ScannerReservas getSRes() {
        return SRes;
    }

    public ScannerVendedor getSVend() {
        return SVend;
    }

    public ScannerVentas getSVentas() {
        return SVentas;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }
}

public class Main {
    public static void menu() {
        try {
            Proyecto proyecto = new Proyecto();
            ScannerCliente clientes = proyecto.getSCli();
            ScannerVendedor vendedores = proyecto.getSVend();
            ScannerMecanico mecanicos = proyecto.getSMec();
            ScannerDirector director = proyecto.getSDir();
            Scanner consola = new Scanner(System.in);
            int num = 0;
            while (num != 5) {
                System.out.println("********************************");
                System.out.println("** Bienvenido a Concesionario **");
                System.out.println("********************************");
                System.out.println("*** MENÚ PRINCIPAL ***");
                System.out.println("1- MENÚ DEL CLIENTE");
                System.out.println("2- MENÚ DEL VENDEDOR");
                System.out.println("3- MENÚ DEL MECÁNICO");
                System.out.println("4- MENÚ DEL DIRECTOR");
                System.out.println("5- SALIR");
                System.out.print("Elija una de estas opciones: ");
                num = consola.nextInt();
                if (num == 1) clientes.consolaClientes();
                if (num == 2) vendedores.consolaVendedor();
                if (num == 3) mecanicos.consolaMecanico();
                if (num == 4) director.consolaDirector();


            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
           menu();


    }
}
