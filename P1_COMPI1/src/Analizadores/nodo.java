package analizadores;

public class nodo { //nodo para los asteriscos
    
    // Atributos nativos
    nodo padre = null;
    int hijos ; //Cantidad de hijos (1|2)
    nodo derecha;
    nodo izquierda;
    nodo abajo;
    Token contenido; 
    boolean recorrido;
    
    String tipo = "nodo";
    boolean anulable = false;
    String pos_p ;
    String pos_u;

    
    
    public nodo(){
    }
    
}
