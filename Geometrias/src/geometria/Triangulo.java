/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometria;

/**
 *
 * @author user
 */
public class Triangulo extends Figura {
        @Override
    public double calcularArea(int valor1, int valor2) {
      return  (valor1*valor2)/2;
              
    }

    @Override
    public double calcularPerimetro(int valor1, int valor2) {
        return valor1*3;
    }
    
    
    

}
