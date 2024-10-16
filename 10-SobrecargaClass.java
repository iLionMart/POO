import java.util.Scanner;

public class Sobrecarga{
    public static void main(String[] args){
        Scanner Menu = new Scanner(System.in);
        int a, b, c, d;

        int menu=0;
        System.out.println("Teclea el triangulo que quieras operar:\n"
                            + "     1 para Equilatero\n"
                            + "     2 para Isoseles\n"
                            + "     3 para Escaleno\n"
                            + "     4 para Cuadrado\n");
        menu = Menu.nextInt();
        Triangulo trio = new Triangulo();

        switch (menu){
            case 1:
                a = 0;
                System.out.println(trio.calcularTriangulo(a));
                break;
            case 2:
                a = 0;
                b = 0;
                System.out.println(trio.calcularTriangulo(a, b));
                break;
            case 3:
                a = 0;
                b = 0;
                c = 0;
                System.out.println(trio.calcularTriangulo(a, b, c));
                break;
            case 4:
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                System.out.println(trio.calcularTriangulo(a, b, c, d));
                break;
        }
    }
}
class Triangulo {
    String calcularTriangulo(double a){
        String s = null;
        double h=0, r=0, p=0;

        Scanner tec = new Scanner(System.in);
        System.out.println("Teclea la medida del lado a");
        a = tec.nextDouble();

        h = (Math.sqrt(3) * a) / 2;
        p = 3 * a;
        r = (Math.sqrt(3) / 4) * (Math.pow(a, 2));

        s = "El triangulo es equilatero\n"
                + "El perimetro del triangulo es: " + p + "\n"
                + "La altura del trinagulo es: " + h + "\n"
                + "El area del triangulo es: " + r;

        return s;
    }
    String calcularTriangulo(double a, double b){
        String s = null;
        double h=0, r=0, p=0;

        Scanner tec = new Scanner(System.in);
        System.out.println("Teclea la medida del lado a");
        a = tec.nextDouble();
        System.out.println("Teclea la medida de la base");
        b = tec.nextDouble();

        h = (Math.sqrt((Math.pow(a, 2) - (Math.pow(b, 2) / 4))));
        p = b + (2 * a);
        r = (b * (Math.sqrt((Math.pow(a, 2) - (Math.pow(b, 2) / 4))))) / 2;

        s = "El triangulo es isoseles\n"
                + "El perimetro del triangulo es: " + p + "\n"
                + "La altura del trinagulo es: " + h + "\n"
                + "El area del triangulo es: " + r;

        return s;
    }
    String calcularTriangulo(double a, double b, double c){
        String s = null;
        double sp=0, r=0, p=0;

        Scanner tec = new Scanner(System.in);
        System.out.println("Teclea la medida del lado a");
        a = tec.nextDouble();
        System.out.println("Teclea la medida del lado b");
        b = tec.nextDouble();
        System.out.println("Teclea la medida del lado c");
        c = tec.nextDouble();

        sp = (a+b+c) / 2;
        p = a + b + c;
        r = Math.sqrt(sp * (sp-a) * (sp-b) * (sp-c));

        s = "El triangulo es escaleno\n"
                + "El perimetro del triangulo es: " + p + "\n"
                + "El area del triangulo es: " + r;

        return s;
    }
    String calcularTriangulo(double a, double b, double c, double d){
        String s = null;
        double r=0, p=0;
        d = 90;

        Scanner tec = new Scanner(System.in);
        System.out.println("Teclea la medida del lado a");
        a = tec.nextDouble();
        System.out.println("Teclea la medida del lado b");
        b = tec.nextDouble();

        c = Math.sqrt((Math.pow(a,2) + Math.pow(b,2)));
        p = a + b + c;
        r = (b * a) / 2;

        s = "El triangulo es cuadrado\n"
                + "El lado c mide: " + c + "\n"
                + "El perimetro del triangulo es: " + p + "\n"
                + "El area del triangulo es: " + r;

        return s;
    }
}