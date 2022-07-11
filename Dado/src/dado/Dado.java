/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dado;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Dado extends JFrame implements ActionListener {//se hereda la clase JFRame y ya se pueden dar caracteristicas al constructor 

    Button btnJugar;
    int rand = 0;
    int saldo = 15;
    int[] tiros;
    Font fuente;
    Image imagen;
    String ruta = "/Users/user/Documents/Dados/", mensajeGanaste, mensajePerdiste;
    private int numClicks = 0;

    public static void main(String[] args) {
        Dado dado = new Dado();//creando un objeto de la clase para que se mande llamar el constructor
    }

    public Dado() {
//Constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setTitle("Dado");
        this.setLayout(new FlowLayout());
        this.add(crearCosas());
        this.setVisible(true);
    }

    public Panel crearCosas() {
        Panel p = new Panel(new GridLayout());
        tiros = new int[]{0, 0, 0};
        btnJugar = new Button("Jugar");
        btnJugar.addActionListener(this);

        p.add(btnJugar);

        return p;
    }

    public void paint(Graphics g) { //  Paint es un metodo preestablecido, viene dentro de la clase JFrame, y ya tenemos un objeto (g) dentro del metodo paint
        super.paint(g);
        g.setColor(Color.blue);
        fuente = new Font("ArialBlack", Font.BOLD, 16);
        g.setFont(fuente);
        g.drawString("Saldo", 130, 300);
        g.drawString("Tiro 1=", 130, 350);
        g.drawString("Tiro 2=", 130, 390);
        g.drawString("Tiro 3=", 130, 430);

        switch (rand) {
            case 1:

                Image img1
                        = Toolkit.getDefaultToolkit().getImage("/Users/user/Documents/Dados/1.png");
                g.drawImage(img1, 100, 100, this);
                break;

            case 2:
                Image img2
                        = Toolkit.getDefaultToolkit().getImage("/Users/user/Documents/Dados/2.png");
                g.drawImage(img2, 100, 100, this);
                break;
            case 3:
                rand = 3;
                Image img3
                        = Toolkit.getDefaultToolkit().getImage("/Users/user/Documents/Dados/3.png");
                g.drawImage(img3, 100, 100, this);
                break;
            case 4:
                Image img4
                        = Toolkit.getDefaultToolkit().getImage("/Users/user/Documents/Dados/4.png");
                g.drawImage(img4, 100, 100, this);
                break;
            case 5:
                Image img5
                        = Toolkit.getDefaultToolkit().getImage("/Users/user/Documents/Dados/5.png");
                g.drawImage(img5, 100, 100, this);
                break;
            case 6:
                Image img6
                        = Toolkit.getDefaultToolkit().getImage("/Users/user/Documents/Dados/6.png");
                g.drawImage(img6, 100, 100, this);

                break;
            default:

        }

        g.drawString(String.valueOf(saldo), 180, 300);
        g.setColor(Color.black);
        g.drawString(String.valueOf(tiros[0]), 195, 350);
        g.drawString(String.valueOf(tiros[1]), 195, 390);
        g.drawString(String.valueOf(tiros[2]), 195, 430);
        g.drawString(mensajeGanaste, 100, 90);
        g.setColor(Color.red);
        g.drawString(mensajePerdiste, 100, 90);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnJugar) {
            repaint();
            mensajeGanaste = "";
            mensajePerdiste = "";
            rand = (int) (Math.random() * 6 + 1);
            System.out.println("Random Number:" + rand);
            tiros[numClicks] = rand;
            repaint();
            
            if (numClicks == 0) {
                repaint();
                tiros[numClicks] = rand;
                clear();
                numClicks++;

            } else if (numClicks == 1) {
                tiros[numClicks] = rand;
                numClicks++;

            } else if (numClicks == 2) {
                repaint();
                tiros[numClicks] = rand;
                numClicks = 0;

                //tiros = new int[]{6, 6, 6};
                if ((tiros[0] == 6) && (tiros[1] == 6) && (tiros[2] == 6)) {
                    saldo = saldo + 5;
                    mensajeGanaste = "Ganaste 5 puntos";
                    repaint();
                

                } else if ((tiros[0] == tiros[1]) && (tiros[0] == tiros[2])) {//Three equals
                    saldo = saldo + 3;
                    mensajeGanaste = "Ganaste 3 puntos";
                    repaint();

                } else if ((tiros[0] == tiros[2]) || (tiros[0] == tiros[1]) || (tiros[1] == tiros[2])) {//pairs
                    saldo = saldo + 1;
                    mensajeGanaste = "Ganaste 1 punto";
                    repaint();

                } else {
                    saldo = saldo - 3;
                    mensajePerdiste = "Perdiste 3 puntos";
                    repaint();

                }

                repaint();
                if (saldo <= 0) {
                    windowClosing();
                    repaint();
                }
                repaint();
            }
            System.out.println(numClicks);
        }
    }

    private void windowClosing() {

        JFrame jFrame = new JFrame("Dado");
        int result = JOptionPane.showConfirmDialog(jFrame, "Se acabó tu saldo. Deseas seguir jugando?.");

        if (result == 0) {
            saldo = 15;
            numClicks = 0;
             mensajeGanaste = "";
            mensajePerdiste = "";
            tiros[0] =0;
            clear();
        } else if (result == 1) {
            System.exit(0);
        } else {
            System.exit(0);
        }

    }

    private void clear() {
    
        tiros[1] = 0;
        tiros[2] = 0;
      
    }

}
