package p1_compi1;

import java.util.ArrayList;


public class Estado {
    
    int id;  // El numero que le asignamos al crear el estado
    boolean aceptacion = false;
    ArrayList<Integer> lista = new ArrayList<>(); // lista de posiciones, este lo vamos a usar para comparar si ya esxiste un estado 
    ArrayList<transicion> transiciones = new ArrayList<>(); //lista para las trancisiones a otros estados
    
    public Estado(int id, ArrayList<Integer> lista){
        this.id = id;
        this.lista = lista;
    }
    
    public Estado(int id){
        this.id = id;
        estado_aceptacion();
        
    }
    
    public int get_id(){
        return id;
    }
    
    public ArrayList<Integer> get_posiciones(){
        return lista;
    }
    
    public ArrayList<transicion> get_transiciones(){
        return transiciones;
    }
    
    public void set_transicion( transicion nueva){
        transiciones.add(nueva);  
    }
    
    public void set_posiciones(ArrayList<Integer> posiciones){
        this.lista = posiciones;
    
    }
    public void estado_aceptacion(){
        aceptacion = true;
    }
    public boolean get_aceptacion(){
        return aceptacion;
    }
            
  
    
}
