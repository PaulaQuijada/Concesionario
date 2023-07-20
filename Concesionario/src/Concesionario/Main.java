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
        this.SCli = new ScannerCliente(this.concesionario);
        this.SCo = new ScannerCoche(this.concesionario);
        this.SVend = new ScannerVendedor(this.concesionario);
        this.SDir = new ScannerDirector(this.concesionario);
        this.SMec = new ScannerMecanico(this.concesionario);
        this.SExpo = new ScannerExpo(this.concesionario);
        this.SRep = new ScannerReparacion(this.concesionario);
        this.SVentas = new ScannerVentas(this.concesionario);
        this.SRes = new ScannerReservas(this.concesionario);
        this.SConce = new ScannerConcesionario(this.concesionario);
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
            Scanner consola = new Scanner(System.in);
            int num = 0;
            while (num != 4) {
                System.out.println("Bienvenido a Concesionario");
                System.out.println("Elija una de estas opciones: ");
                System.out.println("Para entrar como cliente pulsa 1");
                System.out.println("Para entrar como vendedor pulsa 2");
                System.out.println("Para entrar como director pulsa 3");
                System.out.println("Para salir del menú pulsa 4");
                int numero = consola.nextInt();
                if (numero == 1) {
                   /* ScannerCliente SCli = new ScannerCliente();*/
                }
            }
        }
        public static void main(String[] args) {
          try{
              Proyecto proyecto = new Proyecto();
              ScannerVentas ventas = proyecto.getSVentas();
              ScannerCoche coches = proyecto.getSCo();
              ScannerCliente clientes = proyecto.getSCli();
              ScannerVendedor vendedores = proyecto.getSVend();
              ScannerMecanico mecanicos = proyecto.getSMec();
              ScannerReparacion reparaciones = proyecto.getSRep();
              ScannerConcesionario concesionario = proyecto.getSConce();

              mecanicos.agregarMecanico();
              coches.agregarCoche();
              reparaciones.agregarReparacion();
              reparaciones.agregarReparacion();
              mecanicos.repararCoche();
              coches.listarReparacionesOrdenadas();


        }
          catch (InvalidException e){
              System.out.println(e.getMessage());
          }
        }
    }
