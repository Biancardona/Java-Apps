/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thewall;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author user
 */
public class TheWall extends JFrame implements ActionListener {//se hereda la clase JFRame y ya se pueden dar caracteristicas al constructor 
    Button btnAceptar;
    Button btnLimpiar;
    TextField txtAncho;
    TextField txtAlto;
    TextField txtLadrillos;
    TextField txtFilas;
    Label LbLadrillos, LbFilas, LbAncho, LbAlto;
    int ancho =0;
    int alto = 0;
    int ladrillos=0; 
    int filas =0;
    int desface = 0;
  
    public static void main(String[] args) {
    TheWall pared = new TheWall();//creando un objeto de la clase para que se mande llamar el constructor
    }
    
    public TheWall(){//Constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setTitle("The Wall");
        this.setLayout(new FlowLayout());
        this.add(crearCosas());
        this.setVisible(true);
      
        
    }
    
    public Panel crearCosas(){
    Panel p =new Panel (new GridLayout(3,0));
    btnAceptar = new Button ("Aceptar");
    btnLimpiar = new Button ("Limpiar");
    txtAncho = new TextField(10);
    txtAlto = new TextField(6);
    txtLadrillos = new TextField(6);
    txtFilas = new TextField(6);
    btnAceptar.addActionListener(this);
    btnLimpiar.addActionListener(this);
    LbLadrillos = new Label ("Ladrillos");
    LbFilas = new Label("Filas");
    LbAncho = new Label("Ancho");
    LbAlto = new Label ("Alto");
    
    
    
    p.add(LbAncho);
    p.add(txtAncho);
    p.add(LbAlto);
    p.add(txtAlto);
    p.add(LbLadrillos);
    p.add(txtLadrillos);
    p.add(LbFilas);
    p.add(txtFilas);
    p.add(btnAceptar);
    p.add(btnLimpiar);
    
   return p;
    }
    
    public void paint(Graphics g ){ //  Paint es un metodo preestablecido, viene dentro de la clase JFrame, y ya tenemos un objeto (g) dentro del metodo paint
    super.paint(g); //borra los valores anteriores
//  g.setColor(Color.YELLOW);
   // g.setColor(Color.YELLOW);//para que se vea bien la linea roja, se debe poner primero el relleno 
  //  g.fillRect(10, 120, ancho, alto);
    //g.fillRect(10, 100, this.ancho, 100);
  //  g.setColor(Color.BLACK);// Aplica el color a todo lo de abajo 
// g.drawRect(10, 120, ancho, alto);


   for(int j= 0; j < filas ; j++ ) {  
       if(j%2==0){
       desface =ancho/2+20;
       }else 
       {desface =20;
       }
 for( int i = 0; i < ladrillos; i ++) {
     g.setColor(Color.YELLOW);
        g.fillRect(desface + ancho* i , 120   + ancho*j,ancho, alto);
        g.setColor(Color.BLACK);
        g.drawRect(desface + ancho * i ,  120  + ancho*j,ancho, alto);
     }
 
 }
 }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== btnAceptar)
        {
        ancho = Integer.valueOf(txtAncho.getText());
repaint();

alto = Integer.valueOf(txtAlto.getText()); 
repaint();
ladrillos = Integer.valueOf(txtLadrillos.getText()); 
repaint();
filas = Integer.valueOf(txtFilas.getText());
repaint(); //vuelve a mandar a correr el metodo paint

        }
        
    
    if (e.getSource() ==btnLimpiar)
    {
    ancho=0;
    alto=0;
    ladrillos=0;
    filas=0;
    txtAlto.setText("");
    txtAncho.setText("");  
    txtFilas.setText("");
    txtLadrillos.setText("");    
        repaint();
    }
}
}
    


