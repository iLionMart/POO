import java.util.Scanner;
public class Examen {
    public static void main(String[] args){

        Potencia obs = new Potencia();

        obs.LeerDatos();
        obs.CalcularFormula();
        System.out.println(obs.MostrarResultado());
    }
}

class Potencia{
    double A=0,B=0,C=0;
    int m=0,n=0;

    public void LeerDatos(){
        Scanner tec= new Scanner(System.in);
        System.out.println("Introduce el primero numero: ");
        A = tec.nextInt();
        System.out.println("Introduce el segundo numero: ");
        B = tec.nextInt();
        System.out.println("Introduce el tercer numero: ");
        C = tec.nextInt();
        System.out.println("Introduce la primera potencia: ");
        m = tec.nextInt();
        System.out.println("Introduce la segunda potencia: ");
        n = tec.nextInt();
    }
    public double CalcularFormula(){
        double x=0, a=0, b=0, c=0;

        a = CalcularPotencias(A, m);
        b = CalcularPotencias(B, n);
        c = CalcularPotencias(C, (m-n));

        x= a/(b * c);
        return(x);
    }
    public double CalcularPotencias(double num, int potencia){
        double p=0, q=0;

        if(potencia == 0){
            p= 1;
        }else if (potencia > 0){
            p = num;
            for(int i=1; i< potencia; i++){
                p*= num;
            }
        }else if (potencia < 0){
            q = num;
            for(int i=1; i< potencia; i++){
                q*= num;
            }
            p= 1/q;
        }
        return(p);
    }
    String MostrarResultado(){
        String resultado;

        resultado= "El resultado de la formula es: " + CalcularFormula();
        return(resultado);
    }
}