import java.util.Scanner;
import java.util.Arrays;

public class MetodosMatriz{
    public static void main(String[] args){
        int[][] ar1, ar2, ar3;
        int[][] ar1orden, ar2orden;
        
        Matriz ab= new Matriz();
        ar1 = ab.cargarArreglo();
        ar2 = ab.cargarArreglo();
        System.out.println("Matriz\n" + ab.mostrarArreglo(ar1));
        System.out.println("Matriz 2\n" + ab.mostrarArreglo(ar2));
        
        ar1orden = ab.ordenarArreglo(ar1);
        ar2orden = ab.ordenarArreglo(ar2);
        System.out.println("Matriz 1 Ordenada\n" + ab.mostrarArreglo(ar1orden));
        System.out.println("Matriz 2 Ordenada\n" + ab.mostrarArreglo(ar2orden));
        
        ar3 = ab.sumarArreglo(ar1, ar2);
        System.out.println("Matrices Sumadas\n" + ab.mostrarArreglo(ar3));

        ar3 = ab.restarArreglo(ar1, ar2);
        System.out.println("Matrices Restadas\n" + ab.mostrarArreglo(ar3));

        ar3 = ab.multiplicarArreglo(ar1, ar2);
        System.out.println("Matrices Multiplicadas\n" + ab.mostrarArreglo(ar3));
    }
}

class Matriz{
    int[][] cargarArreglo(){
        Scanner leer = new Scanner(System.in);
        int r, c;
        
        System.out.println("Introduce el numero de filas");
        r = leer.nextInt();
        
        System.out.println("Introduce el numero de columnas");
        c = leer.nextInt();
        
        int[][] mat = new int[r][c];
        
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                mat[i][j] = (int) ((Math.random() * 201) - 100);
            }
        }
        return mat;
    }

    String mostrarArreglo(int[][] mat){
        String s = "matriz\n";
    
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                s = s + mat[i][j] + "...\t";
            }
        s = s + "\n";
        }
        return s;
    }

    int[][] ordenarArreglo(int[][] mat){
        int filas = mat.length;
        int columnas = mat[0].length;
        int[] tempArray = new int[filas * columnas];
        int index = 0;
    
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                tempArray[index++] = mat[i][j];
            }
        }
        Arrays.sort(tempArray);
        int[][] OrdenMat = new int[filas][columnas];
        index = 0;
    
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                OrdenMat[i][j] = tempArray[index++];
            }
        }
        return OrdenMat;
    }

    int[][] sumarArreglo(int[][] mat1, int[][] mat2){
        int maxRows = Math.max(mat1.length, mat2.length);
        int maxCols = Math.max(mat1[0].length, mat2[0].length);
        int[][] mat3 = new int[maxRows][maxCols];
    
        for (int i = 0; i < mat1.length; i++){
            for (int j = 0; j < mat1[i].length; j++){
                mat3[i][j] += mat1[i][j];
            }
        }
    
        for (int i = 0; i < mat2.length; i++){
            for (int j = 0; j < mat2[i].length; j++){
                mat3[i][j] += mat2[i][j];
            }
        }
        return mat3;
    }

    int[][] restarArreglo(int[][] mat1, int[][] mat2){
        int maxRows = Math.max(mat1.length, mat2.length);
        int maxCols = Math.max(mat1[0].length, mat2[0].length);
        int[][] mat3 = new int[maxRows][maxCols];
    
        for (int i = 0; i < mat1.length; i++){
            for (int j = 0; j < mat1[i].length; j++){
                mat3[i][j] -= mat1[i][j];
            }
        }
    
        for (int i = 0; i < mat2.length; i++){
            for (int j = 0; j < mat2[i].length; j++){
                mat3[i][j] -= mat2[i][j];
            }
        }
        return mat3;
    }

    int[][] multiplicarArreglo(int[][] mat1, int[][] mat2) {
        int filasMat1 = mat1.length;
        int columnasMat1 = mat1[0].length;
        int filasMat2 = mat2.length;
        int columnasMat2 = mat2[0].length;

        if (columnasMat1 != filasMat2) {
            System.out.println("Las matrices no se pueden multiplicar");
            return null;
        }

        int[][] mat3 = new int[filasMat1][columnasMat2];

        for (int i = 0; i < filasMat1; i++){
            for (int j = 0; j < columnasMat2; j++){
                mat3[i][j] = 0;
                for (int k = 0; k < columnasMat1; k++){
                    mat3[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return mat3;
    }
}
