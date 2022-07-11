
package geometria;

import java.util.Scanner;


public class Geometrias {

  //clase principal main 
    public static void main(String[] args) {

        
        int pos = 0;//asignacion
        //Un objeeto de la clase Scanner nos permite escribir un valor desde la consola
        Scanner entrada = new Scanner(System.in);
        String mensaje1= "";
        String mensaje2= "";
        
        //creando un objeto de la clase figura como clase hija, para hacer un objeto que se puedea usar en muchas clases
        
        Figura figura = new Cuadrado();
        
        System.out.println("escribe el numero correspondiente a la figura");
        System.out.println("1.- Cuadrado");
        System.out.println("2.- Rectangulo");
         System.out.println("3.- Circulo");
         System.out.println("4.- Triangulo");
        pos = entrada.nextInt(); //nextInt porque la variable pos arriba es un entero
        
        switch(pos)
        {
            case 1: 
              mensaje1="el lado";
              figura=new Cuadrado();
                     break;
            case 2:
                mensaje1="el Ancho";
                mensaje2="el Alto";
                figura=new Rectangulo();
                   break;
            case 3:
                mensaje1="el radio ";
                figura=new Circulo();
                   break;
            case 4:
                mensaje1="la Base";
                mensaje2="la Altura";
                figura=new Triangulo();
                   break;
            default:
                System.out.println("el mensaje escrito no es valido");
                System.exit(0);//manda mensaje de error y se sale del programa 
                break;
        }
        System.out.println("Escribe el valor de "+mensaje1);
        figura.valor1= entrada.nextInt();
        if (pos==2 || pos ==4)
        {System.out.println("Escribe el valor de "+mensaje2);
        figura.valor2= entrada.nextInt();
        }
        figura.area=figura.calcularArea(figura.valor1, figura.valor2);
         figura.perimetro=figura.calcularPerimetro(figura.valor1, figura.valor2);
        
        System.out.println("El area es " + figura.area);
         System.out.println("El perimetro es " + figura.perimetro);
        
        
    }
    
}
 