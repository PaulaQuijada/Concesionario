import Clases.Concesionario;
import Scanners.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Proyecto {
    private static ScannerCliente SCli;
    private ScannerCoche SCo;
    private ScannerVendedor SVen;
    private ScannerDirector SDir;
    private ScannerMecanico SMec;
    private ScannerExpo SExpo;
    private ScannerReparacion SRep;
    private ScannerConcesionario SConce;

    public Proyecto() {
        this.SCli = new ScannerCliente(new Concesionario());
        this.SCo = new ScannerCoche(new Concesionario());
        this.SVen = new ScannerVendedor(new Concesionario());
        this.SDir = new ScannerDirector(new Concesionario());
        this.SMec = new ScannerMecanico(new Concesionario());
        this.SExpo = new ScannerExpo(new Concesionario());
        this.SRep = new ScannerReparacion(new Concesionario());
        this.SConce = new ScannerConcesionario(new Concesionario());
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
                    SCli.consolaClientes();
                }
            }
        }
        public static void main(String[] args) {
            menu();
        }
    }
}