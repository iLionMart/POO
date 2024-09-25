import javax.swing.*;
import java.util.Scanner;

public class MetodosComparacion {
    public static void main(String[] args){
        int n;

        Scanner tec = new Scanner(System.in);
        System.out.println("Teclea número de elementos");
        n = tec.nextInt();

        String[] nom = new String[n];
        String[] numEmp = new String[n];
        double[] sueldo = new double[n];

        cargarArreglos(numEmp, nom, sueldo);
        System.out.println(mostrarArreglos(numEmp, nom, sueldo));

        ordenaArreglos(numEmp, nom, sueldo);
        System.out.println(mostrarArreglos(numEmp, nom, sueldo));

        busquedaArreglos(numEmp, nom, sueldo);
    }

    static void cargarArreglos(String[] ne, String[] no, double[] sdo){
        for (int i = 0; i < ne.length; i++) {
            ne[i] = JOptionPane.showInputDialog("Teclea clave del trabajador");
            no[i] = JOptionPane.showInputDialog("Teclea nombre del trabajador " + ne[i]);
            sdo[i] = Double.parseDouble(JOptionPane.showInputDialog("Teclea sueldo del trabajador " + no[i]));
        }
    }

    static String mostrarArreglos(String[] ne, String[] no, double[] sdo){
        String s = "Datos Trabajadores\n";

        for (int i = 0; i < ne.length; i++){
            s += ne[i] + " \t" + no[i] + " \t" + sdo[i] + "\n";
        }
        return s;
    }

    static void ordenaArreglos(String[] ne, String[] no, double[] sdo){
        String auxI;
        String auxS;
        double auxD;

        for (int pas = 1; pas < ne.length; pas++){
            for (int com = 1; com <= (ne.length) - pas; com++){
                if (ne[com - 1].compareTo(ne[com]) > 0){

                    auxI = ne[com - 1];
                    ne[com - 1] = ne[com];
                    ne[com] = auxI;

                    auxS = no[com - 1];
                    no[com - 1] = no[com];
                    no[com] = auxS;

                    auxD = sdo[com - 1];
                    sdo[com - 1] = sdo[com];
                    sdo[com] = auxD;
                }
            }
        }
    }

    static void busquedaArreglos(String[] ne, String[] no, double[] sdo){
        String busqueda;
        boolean verificador = false;
        busqueda = JOptionPane.showInputDialog("Teclea la clave del trabajador que desea buscar");

        for(int i =0; i<ne.length && !verificador; i++){
            if(busqueda.equals(ne[i])){
                System.out.println("El empleado numero: " + busqueda + " si existe en la lista");
                System.out.println("Su nombre es: " + no[i] + " y su sueldo es: " + sdo[i]);
                verificador = true;
            }
        }
        if(!verificador){
            System.out.println("El empleado numero: " + busqueda + " no existe en la lista");
        }
    }
}