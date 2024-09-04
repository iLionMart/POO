import java.util.Scanner;
public class MetodosSeno {
    public static void main(String[] args){

        Seno obs = new Seno();
        obs.leer();
        obs.calcular();
        obs.mostrar();

    }
}

class Seno{
    int grados;
    double resS, x, div;


    public void leer(){
        Scanner tec= new Scanner(System.in);
        System.out.println("Teclea el angulo en grados");
        grados = tec.nextInt();
    }

    public double calcular(){
        x = grados * Math.PI/180;
        resS = 0;
        boolean bandera = true;

        for(int i=1; i<=9; i+=2){
            div = Math.pow(x,i)/facto(i);
            if(bandera == true){
                resS += div;
                bandera = false;
            }else{
                resS -= div;
                bandera = true;
            }
        }
        return x;
    }

    public double facto(int n){
        double f;
        f = 1;

        for(int i= 1; i<= n; i++){
            f=f*i;
        }

        return f;
    }

    String mostrar(){
        String avx;

        avx = "grados " + grados + " radianes = " + x + " seno = " + resS;
        return avx;
    }
}