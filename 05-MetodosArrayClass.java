import java.util.Scanner;
public class MetodosArrayClass {
    public static void main(String[] args){
        int x;
        String res=" ";
        int [] vec1;
        int [] vec2;

        Vector vg=new Vector();
        vec1=vg.LlenarVector();

        System.out.println("Vector 1"+vg.imprimirVector(vec1));

        vec2=vg.LlenarVector();
        System.out.println("Vector 2"+vg.imprimirVector(vec2));

        if(vec1.length==vec2.length){
            int [] vec3=new int[vec1.length];
            vg.sumaVectores(vec1, vec2, vec3);
            System.out.println("La suma de vectores es"+vg.imprimirVector(vec3));
        }else{
            System.out.println("nO se puede realizar la suma");
        }

        if(vec1.length==vec2.length){
            int [] vec3=new int[vec1.length];
            vg.sumaVectoresInv(vec1, vec2, vec3);
            System.out.println("La suma de vectores invertida es"+vg.imprimirVector(vec3));
        }else{
            System.out.println("nO se puede realizar la suma");
        }
    }
}
class Vector {
    public int [] LlenarVector(){
        Scanner tec=new Scanner(System.in);
        int n;
        System.out.println("Teclea número de elementos del vector");
        n=tec.nextInt();
        int [] vector=new int[n];
        for(int i=0; i<vector.length; i++){
            System.out.println("Teclea valor ["+ (i+1)+"] ");
            vector[i]=tec.nextInt();
        }
        return vector;
    }

    public String imprimirVector(int[] vector){
        String s ="\nElementos del arreglo\n";
        for(int i=0;i<vector.length;i++){
            s=s+vector[i]+"\n";
        }
        return s;
    }
    public void sumaVectores(int[] vecA,int[] vecB,int[] vecSuma){
        for(int k=0;k<vecA.length;k++){
            vecSuma[k]=vecA[k]+vecB[k];
        }
    }
    public void sumaVectoresInv(int[] vecA,int[] vecB,int[] vecSuma){
        int k=0, l=vecB.length - 1;
        while(k<vecA.length){
            vecSuma[k]=vecA[k]+vecB[l];
            k+=1;
            l-=1;
        }
    }
}