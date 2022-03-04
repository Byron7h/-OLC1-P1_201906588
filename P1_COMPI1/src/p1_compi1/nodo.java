package p1_compi1;
import analizadores.Token;

public class nodo {
        
    nodo padre = null;
    int hijos ; // Cantidad de hijos (1|2)
    nodo derecha = null;
    nodo izquierda = null;
    nodo abajo = null;
    Token contenido; 
    boolean recorrido = false;
    
    String tipo = "nodo";
    boolean anulable = false; //Será falso por defecto
    String pos_p;
    String pos_u;

    
    //SETS
    
    public nodo(int hijos, Token contenido){
        this.contenido = contenido;
        this.hijos = hijos;
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
    
    public void set_pos_u(String pos_u){
        this.pos_u = pos_u;
    }
    
    public void set_pos_p(String pos_p){
        this.pos_p = pos_p;
    }
        
    public void set_recorrido(){
        this.recorrido = true;
    }
    
    public void es_anulable(){
        this.anulable = true;
    }
    
    //GETS
    
    public nodo get_derecha(){
        return derecha;
    }
    
    public nodo get_izquierda(){
        return izquierda;
    }
        
    public nodo get_abajo(){
        return abajo;
    }
    
    public String get_tipo(){
        return tipo;
    }
    
    public String get_pos_u(){
        return pos_u;
    }
    
    public String get_pos_p(){
        return pos_p;
    }
    
    public boolean get_recorrido(){
        return recorrido;
    }
    
    public int get_hijos(){
        return hijos;
    }
    
    public boolean get_anulable(){
        return anulable;
    }
}
