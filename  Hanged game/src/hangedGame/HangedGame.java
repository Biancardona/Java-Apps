/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hangedGame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class HangedGame extends JFrame implements ActionListener, ItemListener {

    Label lblLetra;
    TextField txtLetra;
    Button btnAceptar;
    Checkbox animalescb, frutascb, paisescb;
    Font fuente, fuente2;
    String[] frutasArray, paisesArray, animalesArray;
    Image imagen;
    int rand = 0, ganados = 0, perdidos = 0, v0 = 0;
    int[] errors;
    String letra, resultado, mensajeGanaste, mensajePerdiste;
    String randomString = "";
    String palabra;
    Boolean val = true;
    Boolean val1 = true;
    String ruta = "/Users/user/Pictures/Hanged/";
    private int imgClicks = 0;

    public static void main(String[] args) {
        HangedGame hangedgame = new HangedGame();
    }

    public HangedGame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setTitle("HangedGame");
        this.setLayout(new BorderLayout());
        this.add(panelSuperior(), "North");
        this.add(panelInferior(), "South");
        this.setVisible(true);

    }

    public Panel panelSuperior() {
        Panel p = new Panel(new GridLayout(1, 3));

        CheckboxGroup grupo = new CheckboxGroup();
        animalescb = new Checkbox("Animales", grupo, true);
        frutascb = new Checkbox("Frutas", grupo, false);
        paisescb = new Checkbox("Paises", grupo, false);
        animalesArray = new String[]{"ballena", "ardilla", "guacamaya", "hipopotamo", "puerco", "abeja", "jaguar", "huron", "oso", "lobo"};
        frutasArray = new String[]{"naranja", "pera", "piña", "platano", "pomelo", "mora", "ciruela", "frambuesa", "higo", "lima"};
        paisesArray = new String[]{"alemania", "cuba", "ecuador", "egipto", "honduras", "irlanda", "luxemburgo", "madagascar", "monaco", "peru"};
        errors = new int[]{0, 0, 0, 0, 0, 0};

        animalescb.addItemListener(this);
        frutascb.addItemListener(this);
        paisescb.addItemListener(this);

        p.add(animalescb);
        p.add(frutascb);
        p.add(paisescb);

        return p;

    }

    public Panel panelInferior() {

        Panel p2 = new Panel(new BorderLayout(1, 1));

        lblLetra = new Label("Ecribe una letra");
        txtLetra = new TextField(8);
        btnAceptar = new Button("Aceptar");

        btnAceptar.addActionListener(this);
        p2.add(txtLetra, BorderLayout.CENTER);
        p2.add(lblLetra, BorderLayout.WEST);
        p2.add(btnAceptar, BorderLayout.EAST);

        return p2;

    }

    public void paint(Graphics g) { //  Paint es un metodo preestablecido, viene dentro de la clase JFrame, y ya tenemos un objeto (g) dentro del metodo paint
        super.paint(g);

        imagen = Toolkit.getDefaultToolkit().getImage(ruta + v0 + ".png");

        g.drawImage(imagen, 50, 100, 250, 250, this);
        g.setColor(Color.red);
        fuente = new Font("ArialBlack", Font.BOLD, 16);
        g.setFont(fuente);
        g.drawString("Ganados", 20, 100);
        g.drawString("Perdidos", 280, 100);

        g.drawString(String.valueOf(ganados), 40, 120);
        g.drawString(String.valueOf(perdidos), 300, 120);
        fuente2 = new Font("ArialBlack", Font.BOLD, 30);
        switch (imgClicks) {
            case 1:

                Image img1
                        = Toolkit.getDefaultToolkit().getImage(ruta + 1 + ".png");
                g.drawImage(img1, 50, 100, 250, 250, this);
                break;

            case 2:
                Image img2
                        = Toolkit.getDefaultToolkit().getImage(ruta + 2 + ".png");
                g.drawImage(img2, 50, 100, 250, 250, this);
                break;
            case 3:

                Image img3
                        = Toolkit.getDefaultToolkit().getImage(ruta + 3 + ".png");
                g.drawImage(img3, 50, 100, 250, 250, this);
                break;
            case 4:
                Image img4
                        = Toolkit.getDefaultToolkit().getImage(ruta + 4 + ".png");
                g.drawImage(img4, 50, 100, 250, 250, this);
                break;
            case 5:
                Image img5
                        = Toolkit.getDefaultToolkit().getImage(ruta + 5 + ".png");
                g.drawImage(img5, 50, 100, 250, 250, this);
                break;
            case 6:
                Image img6
                        = Toolkit.getDefaultToolkit().getImage(ruta + 6 + ".png");
                g.drawImage(img6, 50, 100, 250, 250, this);

                windowClosing();
                imgClicks = 0;
                errors[0] = 0;
                perdidos = perdidos + 1;
                break;
                
            default:

        }
        g.setColor(Color.blue);

        if (val1 == true) {
            repaint();
          
            palabra = "";//limpia los guiones(palabra
            rand = (int) (Math.random() * animalesArray.length);

            if (animalescb.getState()) {//Si esta seleccionado el checkbox 
                randomString = animalesArray[rand];
            } else if (frutascb.getState()) {
                randomString = frutasArray[rand];
            } else if (paisescb.getState()) {
                randomString = paisesArray[rand];
            }
            for (int i = 0; i < randomString.length(); i++) {

                palabra = palabra + "_ ";

            }
            val1 = false;

            repaint();
            System.out.println("Random String:" + randomString);
        }

        g.drawString(palabra, 160, 400);

    }

    public void actionPerformed(ActionEvent e) {
        repaint();

        if (e.getSource() == btnAceptar) {
            repaint();
            desactivarBotones(false, animalescb, frutascb, paisescb);
            letra = "";
            letra = txtLetra.getText().toLowerCase();
            txtLetra.setText("");
            char[] c = new char[]{letra.charAt(0)};
            char[] charArray = randomString.toCharArray();
            char[] charArrayCopy = randomString.toCharArray();
            System.out.println(charArray);
            System.out.println(c);
            System.out.println(palabra);

            StringBuffer buffer = new StringBuffer(palabra);
            boolean val = contains(charArray, c[0]);
            System.out.println("Array contains " + c[0] + "? \n" + val);
            if (val == true) {

                for (int j = 0; j < charArrayCopy.length; j++) {
                    if (charArrayCopy[j] == c[0]) {
                        repaint();
                        buffer.replace(j * 2, (j * 2) + 1, "" + c[0]);

                        System.out.println("buffer: " + buffer);
                        palabra = buffer.toString();
                        System.out.println(palabra);
                        System.out.println(randomString);
                        if (!palabra.contains("_")) {
                            windowClosing();
                            ganados = ganados + 1;

                        }

                    }
                }

            } else {
                errors[imgClicks] = rand;
                repaint();
                if ((imgClicks == 0) || (imgClicks == 1) || (imgClicks == 2) || (imgClicks == 3) || (imgClicks == 4) || (imgClicks == 5) || (imgClicks == 6)) {
                    errors[imgClicks] = rand;
                    imgClicks++;
                    repaint();
                    System.out.println(imgClicks);
                }

            }

        }
        repaint();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        val1 = true;
        repaint();

    }

    public static boolean contains(final char[] array, final char key) {
        Arrays.sort(array);
        return Arrays.binarySearch(array, key) >= 0;
    }

    public void desactivarBotones(Boolean act, Checkbox animales, Checkbox frutas, Checkbox paises) {
        animales.setEnabled(act);
        frutas.setEnabled(act);
        paises.setEnabled(act);

    }

    private void windowClosing() {

        JFrame jFrame = new JFrame("HangedGame");
        int result;
        result = JOptionPane.YES_NO_OPTION;;
        JOptionPane.showConfirmDialog(jFrame, "¿Deseas volver a jugar?","Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            desactivarBotones(true, animalescb, frutascb, paisescb);
             repaint();
        } else if (result == 1) {
            System.exit(0);
        } else {
            System.exit(0);
        }

    }

}
