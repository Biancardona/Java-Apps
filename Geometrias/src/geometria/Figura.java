
package geometria;


 //Si la clase tiene metodos abstractos, la clase debe ser abstracta
public abstract class Figura {
    
    int valor1=0, valor2=0;//variable tipo entero
  double area=0, perimetro=0;//variable tipo double
  
  public abstract double calcularArea(int valor1,int valor2); //Metodo abstract permite indicar que el codigo es obligatorio en todas las clases que se hereden de la clase Figura, la clase debe ser abstracta tmb */
  public abstract double calcularPerimetro(int valor1, int valor2); //Carac del metodo abstracto: EL codigo va ir en la clase que se hereda y es obligatorio que esas que se heredan tengan el metodo abstracto
 
    
}
