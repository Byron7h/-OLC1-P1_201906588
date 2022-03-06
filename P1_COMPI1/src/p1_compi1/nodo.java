package p1_compi1;
import analizadores.Token;
import java.util.ArrayList;

public class nodo {
        
    nodo padre = null;
    int hijos ; // Cantidad de hijos (1|2)
    nodo derecha = null;
    nodo izquierda = null;
    nodo abajo = null;
    Token contenido; 
    boolean recorrido = false;
    
    boolean enlazable = false;
    String anulable = "F"; //Será falso por defecto
    ArrayList<Integer> pos_p;
    ArrayList<Integer> pos_u;
    String tipo;

    
    //SETS
    
    public nodo(int hijos, Token contenido){
        this.contenido = contenido;
        this.hijos = hijos;
        this.tipo= contenido.tipo;
        
        if ("id".equals(contenido.tipo) ||"cadena".equals(contenido.tipo) ||"aceptacion".equals(contenido.tipo)){
            this.enlazable = true;
        }
    }
    
    public void set_padre(nodo padre){
        this.padre = padre;
    }
    
    public void set_derecha(nodo derecha){
        this.derecha = derecha;
    }
        
    public void set_izquierda(nodo izquierda){
        this.izquierda = izquierda;
    }
    
    public void set_abajo(nodo abajo){
        this.abajo = abajo;
    }
    
    public void set_pos_u(ArrayList<Integer> pos_u){
        this.pos_u = pos_u;
    }
    
    public void set_pos_p(ArrayList<Integer> pos_p){
        this.pos_p = pos_p;
    }
        
    public void set_recorrido(){
        this.recorrido = true;
    }
    
    public void es_anulable(){
        this.anulable = "V";
    }
    
    public void es_enlazable(){
        this.enlazable= true;
    }
    
    //GETS
    
    public Token get_contenido(){
        return contenido;
    }
    
    public nodo get_derecha(){
        return derecha;
    }
    
    public nodo get_izquierda(){
        return izquierda;
    }
        
    public nodo get_abajo(){
        return abajo;
    }
    
    
    public ArrayList<Integer> get_pos_u(){
        return pos_u;
    }
    
    public ArrayList<Integer> get_pos_p(){
        return pos_p;
    }
    
    public boolean get_recorrido(){
        return recorrido;
    }
    
    public int get_hijos(){
        return hijos;
    }
    
    public boolean get_anulable(){
        if ("F".equals(anulable)){
            return false;
        }else{
            return true;
        }
        
    }
    
    public String get_str_anulable(){
        return anulable; 
    }
    

    public boolean get_enlazable(){
        return enlazable;
    }
    
    public String get_lexema(){
        return contenido.lexema;
    }
    
    public String get_tipo(){
        return tipo;
    }
    
}
