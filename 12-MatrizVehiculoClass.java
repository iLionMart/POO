import java.util.Scanner;
public class MatrizCarros{
    public static void main(String[] args){

        Estacionamiento estacionamiento = new Estacionamiento();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Bienvenido al sistema de estacionamiento:");
            System.out.println("1: Estacionar veh�culo");
            System.out.println("2: Mostrar estacionamiento");
            System.out.println("3: Cerrar");

            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("Ingrese la fila (0-4):");
                    int fila = scanner.nextInt();
                    System.out.print("Ingrese la columna (0-5):");
                    int columna = scanner.nextInt();

                    if (estacionamiento.esEspacioDisponible(fila, columna)){
                        estacionamiento.estacionarVehiculo(fila, columna);
                    }else{
                        System.out.println("El espacio est� ocupado.");
                    }
                    break;
                case 2:
                    estacionamiento.mostrarEstacionamiento();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opci�n no v�lida, no seas wey");
            }
        }
    }
}

abstract class Vehiculo {
    protected String color;
    protected String modelo;
    protected double precio;
    protected double impuesto;
    public abstract double calcularImpuesto();
    public void capturar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el color del veh�culo:");
        this.color = scanner.nextLine();
        System.out.println("Ingrese el modelo del veh�culo:");
        this.modelo = scanner.nextLine();
        System.out.println("Ingrese el precio del veh�culo:");
        this.precio = scanner.nextDouble();
    }
    public void mostrar() {
        System.out.println("Color: " + color);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio: " + precio);
        System.out.println("Impuesto: " + impuesto);
    }
}

class Electrico extends Vehiculo {
    @Override
    public double calcularImpuesto() {
        this.impuesto = this.precio * 0.09;
        return this.impuesto;
    }
}

class Combustion extends Vehiculo {
    @Override
    public double calcularImpuesto() {
        this.impuesto = this.precio * 3;
        return this.impuesto;
    }
}

class Estacionamiento{
    private Vehiculo[][] matVec = new Vehiculo[5][6];
    public Estacionamiento(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                matVec[i][j] = null;
            }
        }
    }

    public boolean esEspacioDisponible(int fila, int columna){
        return matVec[fila][columna] == null;
    }

    public void estacionarVehiculo(int fila, int columna){
        Scanner scanner = new Scanner(System.in);

        if (esEspacioDisponible(fila, columna)) {
            System.out.println("Selecciona el tipo de veh�culo (1- El�ctrico, 2- Combusti�n): ");
            int tipo = scanner.nextInt();
            Vehiculo vehiculo;

            if (tipo == 1) {
                vehiculo = new Electrico();
            } else {
                vehiculo = new Combustion();
            }

            vehiculo.capturar();
            vehiculo.calcularImpuesto();
            vehiculo.mostrar();

            matVec[fila][columna] = vehiculo;
            System.out.println("Veh�culo estacionado correctamente.");
        }else{
            System.out.println("El espacio seleccionado ya est� ocupado.");
        }
    }

    public void mostrarEstacionamiento(){
        System.out.println("Reporte de veh�culos en el estacionamiento:");
        Vehiculo vehiculo;

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                if (matVec[i][j] != null){
                    System.out.println("Fila " + i + ", Columna " + j + ": Ocupado");
                }else{
                    System.out.println("Fila " + i + ", Columna " + j + ": Vac�o");
                }
            }
        }
    }
}