import java.util.Scanner;
public class MetodosCombinacion{
    public static void main(String[] args){

        Combinacion obs = new Combinacion();
        
        obs.leer();
        obs.calcular();
        System.out.println(obs.mostrar());
        
    }
}

class Combinacion{
    int m=0, n=0, l=0, c=0, f=0;
    int M=0, N=0, L=0;

    public void leer(){
        Scanner tec= new Scanner(System.in);
        boolean verificador = false;

        while(verificador == false){
            while(m<=0){
                System.out.println("Teclea el numero de objetos en total");
                m = tec.nextInt();
            }
        
            while(n<=0){
                System.out.println("Teclea el numero de muestras");
                n = tec.nextInt();
            }
        
            if(m<n){
                System.out.println("No se pueden seleccionar más elementos de los que hay");
                m = 0;
                n = 0;
            }else{
                verificador = true;
            }
        }
        l = m-n;
    }

    public int facto(int num){
        f= 1;

        for (int i = 1; i <= num; i++) {
            f*= i;
        }
        return(f);
    }

    public int calcular(){
        M = facto(m);
        N = facto(n);
        L = facto(l);

        c = M / (N * L);

        return c;
    }

    String mostrar(){
        String resultado;

        resultado = "EL total de combinaciones de " + m + " objetos con " + n + " muestras es: " + c;
        return(resultado);
    }
}
