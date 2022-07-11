
package geometria;


public class Cuadrado extends Figura {

    @Override
    public double calcularArea(int valor1, int valor2) {
      return  valor1*valor1;
              
    }

    @Override
    public double calcularPerimetro(int valor1, int valor2) {
        return valor1*4;
    }
    
    
    
}
