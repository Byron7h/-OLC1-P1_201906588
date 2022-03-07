package p1_compi1;

import java.util.ArrayList;
import java.util.Collections;

public class Tabla_siguientes {
    
    ArrayList<nodo_tabla_siguientes> simbolos = new ArrayList<>(); // lista de nodos_tabla
    
    // metodo pare recibir nodo nuevo
    public void agregar(String simbolo, Integer id){
        nodo_tabla_siguientes nuevo = new nodo_tabla_siguientes(simbolo,id);
        simbolos.add(nuevo);
    }
    
    // metodo para asignar a los siguientes de un simbolo
    // vamos a recibir 2 arraylist<Integer>, la primera son los simbolos a los que se les van a aplicar los siguiente
    // y la otra serán llos siguientes a asignar
    
    public void agregar_siguientes(ArrayList<Integer> lista_1, ArrayList<Integer> lista_2){
        
        for (nodo_tabla_siguientes actual : simbolos){
            for (Integer numero: lista_1){
                if (numero == actual.id){
                    actual.set_lista_siguientes(unir_posiciones(actual.get_lista_siguientes(),lista_2));
                }
            } 
        } 
    }
    
    public static ArrayList<Integer> unir_posiciones (ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        //lista1, en la que se va a buscar e isertar
        //lista2 de la que se van a extraer los elementos
        
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        
        for (Integer num : lista1) {
            auxiliar.add(num);
        }
        

        for (Integer num : lista2) {
            if (auxiliar.indexOf(num)== -1){ //no se encuentra en esa lista
                auxiliar.add(num);
            }
        }
        //System.out.println(lista1.toString()); //podemos imprimirla de esta forma
        Collections.sort(auxiliar);
        return auxiliar;
    
    }
    
    public void imprimir() { //retorna una cadena de informacion 
                            // Acá ya podemos colocarle código html, para los reportes
        String data = "\n";
        data += "Tabla de siguientes\n";
        data += "Simbolo    Número   Siguientes\n";
        
        for (nodo_tabla_siguientes actual : simbolos) {
            data += "   " + actual.get_simbolo();
            data += "   " + actual.get_id();
            data += "   " + actual.get_lista_siguientes() +"\n";
        }
        
        System.out.println(data);
    }
    
}
