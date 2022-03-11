/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_compi1;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Ventana extends JFrame implements ActionListener{
                    
    //Botones
    private JButton b_buscar, b_aceptar, b_operar;
    //Etiquetas en el frame
    private JLabel etiqueta_ruta, etiqueta_titulo;
    
    private JComboBox<String> combo1;
    String direccion;
    public String titulo_grafica;
    //variables y artilugios
    int prueba = -1;
    //boolean ruta_chooser = false;
    //array categorias

    int contador=0;

    
    
    //CONSTRUXTOR DE VENTANA SUPERIOR
    
    public Ventana(){
    
    
     this.setBounds(200, 100, 800, 250);
     this.setTitle("Proyecto 1 OLC1");
     this.setLayout(null);
     this.setResizable(false);
 
     Inicio();
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     
     
     
     
    }
    
    private void Inicio (){
        
       etiqueta_ruta = new JLabel("Ruta del archivo"); 
       etiqueta_ruta.setBounds(20, 12, 450, 50); 
       this.add(etiqueta_ruta);
       
       etiqueta_titulo = new JLabel("Expresion regular a buscar"); 
       etiqueta_titulo.setBounds(20, 80, 450, 50); 
       this.add(etiqueta_titulo);
        
       //ruta= new JTextField();               
       //ruta.setBounds(20, 55, 600, 25);   
       //this.add(ruta);

       
       b_buscar = new JButton("Buscar"); 
       b_buscar.setBounds(20, 55, 600, 25);
       b_buscar.addActionListener(this);
       this.add(b_buscar);
       
       
       b_operar = new JButton("Operar"); 
       b_operar.setBounds(650, 55, 100, 25);
       b_operar.addActionListener(this);
       this.add(b_operar);
       
       
       b_aceptar = new JButton("Mostrar"); 
       b_aceptar.setBounds(350, 170, 100, 25);
       b_aceptar.addActionListener(this);
       this.add(b_aceptar);
       
       combo1=new JComboBox<String>();
       combo1.setBounds(20, 120, 740, 25);
       this.add(combo1);
       
      
       
       
       
       
       
       //set visibles
       etiqueta_ruta.setVisible(true);
       etiqueta_titulo.setVisible(false);
       //ruta.setVisible(true);

       b_buscar.setVisible(true);
       b_aceptar.setVisible(false);
       combo1.setVisible(false);

       
       

        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if( ae.getSource() == b_buscar ){
            
            
                    

             
            //creando un nuevo objeto de tipo FileChooser
            JFileChooser fc = new JFileChooser();
            //el op guardará la seleccion del filechooser, si acepta o cancela
            int op = fc.showOpenDialog(this); 
            // Si el usuario acepta, entonces...
            if(op == JFileChooser.APPROVE_OPTION){
                try {
                direccion = fc.getSelectedFile().toString();
                System.out.println(direccion);
                //ruta_chooser = true;
                prueba =2;
                
                }catch(NumberFormatException e){
                e.printStackTrace();
                }     
            }
            
            
        }else if( ae.getSource() == b_aceptar){
                        

            String nombre= (String)combo1.getSelectedItem();
            String file = new String("C:/Users/usuario/Documents/Byron/7mo semestre/Compi 1/P1/-OLC1-PROYECTO_1_201906588/P1_COMPI1/reportes/Reporte_"+nombre+".html"); 
            
            try {

                File objetofile = new File (file);
                Desktop.getDesktop().open(objetofile);

            }catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Archivo no válido");
                System.out.println(ex);
            }

            }else if( ae.getSource() == b_operar){
     
            System.out.println("Se opero");
            Operador este = new Operador(direccion);
            ArrayList<Automata> Automatas = new ArrayList<>();
            Automatas = este.Automatas;
            
            if (Automatas.isEmpty()!= true){
                for (Automata auto : Automatas){
                combo1.addItem(auto.get_id());
                }
                etiqueta_titulo.setVisible(true);
                combo1.setVisible(true);
                b_aceptar.setVisible(true);
            }

            
            
 
 
 
 }
        
        
}

}
