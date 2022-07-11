/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometria;

import java.awt.Button; //se añaden las librerias de los botones 
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;



/*
Listener son los metodos para colocar codigo en los objetos
WindowListener es para ventanas
ActionListener es para Botones
ItemListener es para radios y checkboxes
*/



public class GenerarVentana implements WindowListener,ActionListener,ItemListener {
    
       //objetos globales
      Button btnAceptar, btnLimpiar;
      TextField txtValor1, txtValor2;
      Label lbValor1, lbValor2, lbArea, lbPerimetro;
      Checkbox cbCuadrado, cbRectangulo, cbTriangulo, cbCirculo;  
      Figura figura = new Cuadrado();//creando un objeto de la clase figura como clase hija, para hacer un objeto que se puedea usar en muchas clases
      DecimalFormat formato = new DecimalFormat("#,##0.00");//Almohadillas que si no hay numero no ponga nada, y los ceros, cuando no haya numeros ponga ceros 
      
      public static void main(String[] args) {
          GenerarVentana correr = new GenerarVentana();
          
          
    

                  }
      //Generando el constructor 1.- debe ser publico, 2, tiene que tener el nombre de la clase
      
      
      public GenerarVentana (){
          
          //Generar Ventana (objeto)
          Frame ventana = new Frame();
          ventana.setTitle("Figuras Geometricas");
          ventana.setSize(250, 400);
          ventana.setResizable(true);
          ventana.setLayout(new FlowLayout());//Flow es cuando los objetos se acomodan de acuerdo a lo que cabe en la ventana
          ventana.add(crearRadios());
          ventana.add(crearCajas());
          ventana.add(crearResultados());
          
          //Enlazar los metodos con la ventana
          ventana.addWindowListener(this);

          ventana.setVisible(true);// es lo ultimo para que se muestre todo lo de arriba
      
      }
      
      
    public Panel crearRadios ()
            {
                Panel p = new Panel(new GridLayout(5,1)); //objeto de tipo panel , lleva 5 filas y 1 columna
                CheckboxGroup grupo = new CheckboxGroup();
                
                
                
                 //inicializando los radiobuttons (seran las 5 filas (son objetos) )
                Label lb2 = new Label ("Elige la figura geometrica");//label fija
                cbCuadrado = new Checkbox("Cuadrado", grupo, true);//false es para que no este habilitado el radiobutton
                cbRectangulo = new Checkbox("Rectangulo", grupo, false);
                cbTriangulo = new Checkbox("Triangulo", grupo, false);
                cbCirculo = new Checkbox("Circulo", grupo, false);
                
                
                cbCuadrado.addItemListener(this);
                cbCirculo.addItemListener(this);
                cbTriangulo.addItemListener(this);
                cbRectangulo.addItemListener(this);
               
                   //Agregar los objetos al panel ,aqui sera el acomodo en como se vea
                   p.add(lb2);
                   p.add(cbCuadrado);
                   p.add(cbRectangulo);
                   p.add(cbCirculo);
                   p.add(cbTriangulo);
                   
                   
                   
                return  p; 
            }   
    
    public Panel crearCajas()
    {
        Panel p =new Panel(new GridLayout(2,2));  //Se puede volver a nombrar igual que el de arriba porque es un objeto local 
        lbValor1= new Label("Lado");//Como el cuadrado esta true para el radiobutton esta seleccionado, es el texto por default que va aparecer
        lbValor2= new Label(""); 
        txtValor1 = new TextField(10);//tamaño, ancho del espacio para escribir
        txtValor2 = new TextField(10);
      
        
        //se hace invisible label 2 y caja2
        lbValor2.setVisible(false);
        txtValor2.setVisible(false);
        
        p.add(lbValor1);
        p.add(lbValor2);
        p.add(txtValor1);
        p.add(txtValor2);
        return p;
        
    
    }
    
    public Panel crearResultados()
    {
    Panel p =new Panel (new GridLayout(3,2));
    btnAceptar = new Button("Aceptar");
    btnLimpiar = new Button("Limpiar");
    lbArea= new Label ("Area");
    lbPerimetro= new Label ("Perimetro");
    Label lb2 = new Label ("");
    
    
    btnAceptar.addActionListener(this);
    btnLimpiar.addActionListener(this);
    
    
    p.add(btnAceptar);
    p.add(btnLimpiar);
    p.add(lbArea);
    p.add(lbPerimetro);
    return p;
    
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) { //metodo que manda cerrar (Que funcione
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 
      //metodo para todos los botones
      if(e.getSource()==btnAceptar)
              
      {
             try{
                 
                 figura.valor1= Integer.parseInt(txtValor1.getText());
      
      if(cbRectangulo.getState()|| (cbTriangulo.getState()))
      {figura.valor2=Integer.parseInt(txtValor2.getText());
                  }
    figura.area=figura.calcularArea(figura.valor1,figura.valor2);
    figura.perimetro=figura.calcularPerimetro(figura.valor1, figura.valor2);
    lbArea.setText(formato.format(figura.area));
    lbPerimetro.setText(formato.format(figura.perimetro));
    
      }catch(Exception a)
              {
              //Mensaje en pantalla
              JOptionPane.showMessageDialog(null, "El valor escrito no es valido");
              }
      }
      if(e.getSource() == btnLimpiar)
      {
      cbCuadrado.setState(true);
      mostrarObjetos(false, "lado", " ");//Reseteando el checkbox
      lbArea.setText(" ");
      lbPerimetro.setText(" ");
      txtValor1.setText("");
      txtValor2.setText("");
      figura = new Cuadrado();
      
      }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if(cbCuadrado.getState()) //Si esta seleccionado el boton cuadrado
        {mostrarObjetos(false, "lado", "");
        figura=new Cuadrado();
        }else if(cbRectangulo.getState())
        { mostrarObjetos(true, "ancho", "alto");
        figura = new Rectangulo();
        }else if(cbTriangulo.getState())
        {mostrarObjetos(true,"base", "altura");
        figura = new Triangulo();
        }else if (cbCirculo.getState())
        {mostrarObjetos(false,"radio", " ");
        figura= new Circulo();
        }  
            }
    public void mostrarObjetos(Boolean act, String texto1, String texto2){
    txtValor2.setVisible(act);
            lbValor2.setVisible(act);
            lbValor1.setText(texto1);
            lbValor2.setText(texto2);
            
    }
}         
        

