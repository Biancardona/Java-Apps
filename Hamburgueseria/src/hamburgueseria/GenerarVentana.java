/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hamburgueseria;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

/**
 *
 * @author user
 */
public class GenerarVentana implements WindowListener,ActionListener,ItemListener  {
    
    Checkbox cbHamb, cbPapa, cbRef, rbHambCh, rbHambM, rbHambG, rbPapaCh, rbPapaM, rbPapaG, rbRefC, rbRefM, rbRefG, rbGhostH,rbGhostR, rbGhostP ;
    Label lbHamb, lbPapa, lbRef, lbTotal, lbPrecioH, lbPrecioP, lbPrecioR, lbPrecioT;
    Button btnLimpiar;
    Producto producto = new Hamb();
    Double total = 0.0;
    DecimalFormat formato = new DecimalFormat("#,##0.00");

    
     public static void main(String[] args) {
          GenerarVentana correr = new GenerarVentana();
        
                  }

public GenerarVentana(){

Frame ventana = new Frame();
        ventana.setTitle("Hamburgueseria");
        ventana.setSize(400, 300);
        ventana.setResizable(true);
        ventana.setLayout(new FlowLayout());
        ventana.add(crearRadiosH());
        ventana.add(crearRadiosP());
        ventana.add(crearRadiosR());
        ventana.add(crearLimpiarButton());
        ventana.add(crearResultadosProductos());
        ventana.addWindowListener(this);
        ventana.setVisible(true);
        
}

public Panel crearRadiosH(){
Panel p =new Panel (new GridLayout(4,1));
CheckboxGroup grupo = new CheckboxGroup();
    
cbHamb = new Checkbox("Hamburguesa", false);
rbHambCh = new Checkbox("Chico", grupo, false);
rbHambM = new Checkbox("Mediano", grupo, false);
rbHambG = new Checkbox ("Grande", grupo, false);
rbGhostH = new Checkbox("", grupo, false);

 rbHambCh.setEnabled(false);
 rbHambM.setEnabled(false);
 rbHambG.setEnabled(false);

 cbHamb.addItemListener(this);
 rbHambCh.addItemListener(this);
 rbHambM.addItemListener(this);
 rbHambG.addItemListener(this);

p.add(cbHamb);
p.add(rbHambCh);
p.add(rbHambM);
p.add(rbHambG);

return p;
}

public Panel crearRadiosP(){
Panel p =new Panel (new GridLayout(4,1));
CheckboxGroup grupo = new CheckboxGroup();
        
cbPapa = new Checkbox("Papas", false);
rbPapaCh = new Checkbox("Chico", grupo, false);
rbPapaM = new Checkbox("Mediano", grupo, false);
rbPapaG = new Checkbox ("Grande", grupo, false);
rbGhostP = new Checkbox("", grupo, false);
        
        
 rbPapaCh.setEnabled(false);
 rbPapaM.setEnabled(false);
 rbPapaG.setEnabled(false);

 cbPapa.addItemListener(this);
 rbPapaCh.addItemListener(this);
 rbPapaM.addItemListener(this);
 rbPapaG.addItemListener(this);

p.add(cbPapa);
p.add(rbPapaCh);
p.add(rbPapaM);
p.add(rbPapaG);

return p;
}

public Panel crearRadiosR(){
Panel p =new Panel (new GridLayout(4,1));
CheckboxGroup grupo = new CheckboxGroup();
        
cbRef = new Checkbox("Refresco", false);
rbRefC = new Checkbox("Chico", grupo, false);
rbRefM = new Checkbox("Mediano", grupo, false);
rbRefG = new Checkbox ("Grande", grupo, false);
rbGhostR = new Checkbox("", grupo, false);

 cbRef.addItemListener(this);
 rbRefC.addItemListener(this);
 rbRefM.addItemListener(this);
 rbRefG.addItemListener(this);
 
 rbRefC.setEnabled(false);
 rbRefM.setEnabled(false);
 rbRefG.setEnabled(false);

p.add(cbRef);
p.add(rbRefC);
p.add(rbRefG);
p.add(rbRefM);

return p;
}

public Panel crearLimpiarButton(){
Panel p = new Panel(new GridLayout(1,0));
btnLimpiar = new Button("Limpiar");

btnLimpiar.addActionListener(this);

p.add(btnLimpiar);

return p;
}

public Panel crearResultadosProductos(){
Panel p = new Panel(new GridLayout(4, 2));
lbHamb = new Label("Hamburguesa");
lbPrecioP = new Label (" ");
lbPapa = new Label("Papas");
lbRef = new Label("Refresco");
lbTotal = new Label("Total");
lbPrecioH = new Label(" ");
 lbPrecioP = new Label (" ");
lbPrecioR = new Label(" "); 
lbPrecioT= new Label(" ");

p.add(lbHamb);
p.add(lbPrecioH);
p.add(lbPrecioP);
p.add(lbPapa);
p.add(lbPrecioP);
p.add(lbRef);
p.add(lbPrecioR);
p.add(lbTotal);
p.add(lbPrecioT); 

return p;
}

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
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
    
   if(e.getSource()== btnLimpiar)
    {activarBotones(false, rbHambCh, rbHambM,rbHambG, rbGhostH, lbPrecioH, lbPrecioT );
    activarBotones(false, rbPapaCh, rbPapaM, rbPapaG, rbGhostP, lbPrecioP, lbPrecioT);
    activarBotones(false, rbRefC, rbRefM, rbRefG, rbGhostR , lbPrecioR, lbPrecioT);    
    }
       cbHamb.setState(false);
       cbPapa.setState(false);
       cbRef.setState(false);
       lbPrecioT.setText(""); 
        }

    @Override
    public void itemStateChanged(ItemEvent e) {// Usar el metodo activarBotones para activarlos y desactivarlos en caso se seleccionarse el checkbox respectivo
            activarBotones(cbHamb.getState(), rbHambCh, rbHambM, rbHambG, rbGhostH, lbPrecioH, lbPrecioT );
            activarBotones(cbPapa.getState(), rbPapaCh, rbPapaM, rbPapaG, rbGhostP, lbPrecioP, lbPrecioT);
            activarBotones(cbRef.getState(), rbRefC, rbRefM, rbRefG, rbGhostR , lbPrecioR, lbPrecioT);
            total=0.0;//Se limpia antes de elegir el producto para que no acumule los valores anteriores. 
            elegirProducto();//Se manda llamar el metodo elegir PRoducto para qeu aparezcan los precios en la label 
                   
    }
   
    
   private void elegirProducto(){
        if(cbHamb.getState())//Si esta seleccionado el checkbox 
        {  producto= new Hamb();
            elegirTamaño(rbHambCh, rbHambM, rbHambG, lbPrecioH);
        } if(cbPapa.getState())//Si esta seleccionado el checkbox 
        {  elegirTamaño(rbPapaCh, rbPapaM, rbPapaG, lbPrecioP );
            producto= new Papas(); 
        } if(cbRef.getState())//Si esta seleccionado el checkbox 
        {  elegirTamaño(rbRefC, rbRefM, rbRefG, lbPrecioR);
            producto= new Ref(); 
        }
      
        
    }
 
    private void elegirTamaño (Checkbox ch, Checkbox m, Checkbox g, Label etiqueta ){
    if(ch.getState())
    {etiqueta.setText(formato.format(producto.getCh()));
    total+=producto.getCh();
    } else if (m.getState())           
    {etiqueta.setText(formato.format(producto.getM()));
    total+=producto.getM();
    } else if (g.getState())
    {etiqueta.setText(formato.format(producto.getG()));
    total+=producto.getG();
    }
    lbPrecioT.setText(formato.format(+total));
    }
    
     private void activarBotones (Boolean act, Checkbox Ch, Checkbox M, Checkbox G, Checkbox Ghost, Label Etiqueta, Label Total ){ //Metodo en el cual se usara para activar los radiobuttons si se seleccionanlos checkboxes. Por medio de parametros
   Ch.setEnabled(act);
   M.setEnabled(act);
   G.setEnabled(act);
   
    if (act == false){
        Ghost.setState(true);
           Etiqueta.setText(""); 
    }
 
    
    }
}