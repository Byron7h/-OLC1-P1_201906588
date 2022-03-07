package p1_compi1;
import java.util.ArrayList;

// de este objeto sera nuestras filas en la tabla de simbolos

public class nodo_tabla_siguientes {
    String simbolo; // simbolo del nodo, lo que contiene su hoja en el arbol
    Integer id;  // El numero que le asignamos al crear el nodo
    ArrayList<Integer> siguientes = new ArrayList<>(); // lista de posiciones siguientws
    
    public nodo_tabla_siguientes(String simbolo, Integer id){
        this.simbolo = simbolo;
        this.id = id;

    }
    
    public String get_simbolo(){
        return simbolo;
    }
    
    public Integer get_id(){
        return id;
    }
        
    public ArrayList<Integer> get_lista_siguientes(){
        return siguientes;
    }
    
    public void set_lista_siguientes(ArrayList<Integer> siguientes){
        this.siguientes = siguientes ;
    }
    
    
}
