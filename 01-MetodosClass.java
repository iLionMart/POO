public class Metodos {
    public static void main(String[] args) {
      
        Ejecutar ej = new Ejecutar();
        ej.metodo();
    }
}
    
    class Ejemplo{
        public void leer(){
            System.out.println("Se ejecuta leer");
        }

        public int calcular(int a, int b){
            int i = a*b;
            return i;
        }

        public double obtener(double x, int y, int z){
            y=calcular(25,z);
            return(y+x*3.1416);
        }

        public void recursivo(double x, int y,int z){
            if(z!=0){
                System.out.println("Se llama el numero conn z: "+z);
                recursivo(3.1416*z,25+z,z-1);
                System.out.println("Sale con recursividad con z: "+z);
            }else{
                System.out.println("Fin de la Recursividad");
            }
        }
    }
    
class Ejecutar{
    public void metodo(){
        int m = 10, n=15,l;
        double d, e=1.0;
           
        Ejemplo ej2 = new Ejemplo();
           
        ej2.leer();
        l= ej2.calcular(m,n);
        System.out.println("L = "+l);
           
        m= ej2.calcular(5,l-30);
        System.out.println("M = "+m);
           
        d= ej2.obtener(e,n,20);
        System.out.println("D = "+d);
    }
}
