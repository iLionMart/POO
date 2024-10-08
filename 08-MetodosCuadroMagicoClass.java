import java.util.Scanner;

public class MetodosCuadroMagico {
    public static void main(String[] args){
        int[][] arreglo;

        CuadroMagico cm = new CuadroMagico();
        arreglo = cm.cargarArreglo();
        cm.mostrarCuadroMagico(arreglo);
        cm.sumarArreglo(arreglo);
    }
}

class CuadroMagico {
    int[][] cargarArreglo(){
        int f = 0;
        boolean verificador = false;
        Scanner filas = new Scanner(System.in);
        
        while(!verificador){
            System.out.println("Introduce el número de filas y columnas (debe ser impar):");
            f = filas.nextInt();
        
            if(f% 2 == 0){
                System.out.println("El número de filas y columnas debe ser impar, vuelve a introducirlo");
            }else{
                verificador = true;
            }
        }
        
        int[][] arreglo = new int[f][f];
        int num = 1;
        int i= 0, j= f/2;
        
        while(num <= f * f){
            arreglo[i][j] = num;
            num++;
            if(num % f == 1){
                i++;
            }else{
                i--;
                j++;
            }
            if(i< 0){
                i= f - 1;
            }
            if(j== f){
                j= 0;
            }
        }
        return arreglo;
    }
    
    void mostrarCuadroMagico(int[][] arreglo){
        for(int[] fila : arreglo){
            for(int num : fila){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    void sumarArreglo(int[][] arreglo){
        int tamaño = arreglo.length;
        int[] sumafilas = new int[tamaño];
        int[] sumacolumnas = new int[tamaño];
        int sumadiagonal = 0;
 
        for(int i=0; i<tamaño; i++){
            for(int j=0; j<tamaño; j++){
                sumafilas[i] += arreglo[i][j];
                sumacolumnas[i] += arreglo[j][i];

                if(i==j){
                    sumadiagonal += arreglo[i][j];
                }
            }
        }
        
        System.out.print("La suma de las filas es: ");
        for(int i=0; i<tamaño; i++){
            System.out.print(sumafilas[i] + " ");
        }
        System.out.println();

        System.out.print("La suma de las columnas es: ");
        for(int i=0; i<tamaño; i++){
            System.out.print(sumacolumnas[i] + " ");
        }
        System.out.println();
        System.out.println("La suma de la diagonal es: " + sumadiagonal);
    }
}
