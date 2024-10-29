import java.util.Scanner;

public class MetodosHerencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FiguraGeo figura = null;

        while (true) {
            System.out.println("Seleccione la figura con la que desea trabajar:");
            System.out.println("1. Cuadrado");
            System.out.println("2. Rectángulo");
            System.out.println("3. Círculo");
            System.out.println("4. Triángulo");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    figura = new Cuadrado();
                    break;
                case 2:
                    figura = new Rectangulo();
                    break;
                case 3:
                    figura = new Circulo();
                    break;
                case 4:
                    figura = new Triangulo();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            figura.cargar();
            figura.calcularArea();
            figura.calcularPerimetro();
            figura.mostrar();
            System.out.println();
        }
    }
}

abstract class FiguraGeo {
    protected double area;
    protected double perimetro;

    public void mostrar() {
        System.out.println("Área: " + area);
        System.out.println("Perímetro: " + perimetro);
    }

    public abstract void cargar();
    public abstract void calcularArea();
    public abstract void calcularPerimetro();
}

class Cuadrado extends FiguraGeo {
    private double lado;

    @Override
    public void cargar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el lado del cuadrado: ");
        lado = scanner.nextDouble();
    }

    @Override
    public void calcularArea() {
        area = lado * lado;
    }

    @Override
    public void calcularPerimetro() {
        perimetro = 4 * lado;
    }
}

class Rectangulo extends FiguraGeo {
    private double largo;
    private double ancho;

    @Override
    public void cargar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el largo del rectángulo: ");
        largo = scanner.nextDouble();
        System.out.print("Ingrese el ancho del rectángulo: ");
        ancho = scanner.nextDouble();
    }

    @Override
    public void calcularArea() {
        area = largo * ancho;
    }

    @Override
    public void calcularPerimetro() {
        perimetro = 2 * (largo + ancho);
    }
}

class Circulo extends FiguraGeo {
    private double radio;

    @Override
    public void cargar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el radio del círculo: ");
        radio = scanner.nextDouble();
    }

    @Override
    public void calcularArea() {
        area = Math.PI * radio * radio;
    }

    @Override
    public void calcularPerimetro() {
        perimetro = 2 * Math.PI * radio;
    }
}

class Triangulo extends FiguraGeo {
    private double base;
    private double altura;

    @Override
    public void cargar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la base del triángulo: ");
        base = scanner.nextDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        altura = scanner.nextDouble();
    }

    @Override
    public void calcularArea() {
        area = (base * altura) / 2;
    }

    @Override
    public void calcularPerimetro() {
        perimetro = 3 * base;
    }
}
