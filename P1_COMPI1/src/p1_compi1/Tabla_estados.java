
package p1_compi1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usuario
 */
public class Tabla_estados {
    
        ArrayList<Estado> pendientes = new ArrayList<>(); // lista de estados
        ArrayList<Estado> finales = new ArrayList<>(); // lista de estados
    
        Tabla_siguientes tabla ;
        int contador = 0;
        
        // va apedir una raiz y la tabla de estados
        public Tabla_estados(ArrayList<Integer> raiz, Tabla_siguientes tabla){
            
            this.tabla = tabla;
            Estado nuevo = new Estado (contador, raiz); // Nuestro estado inicial
            pendientes.add(nuevo);
            
        }
        
        
        public void generar_tabla(){
            //1 identificar raiz
            int contagor_general = 1;
            
            while (contagor_general!=0){
            
            Estado primero = pendientes.get(0);
            System.out.println("RAIZ -> "+primero.get_posiciones());
            int contador_estados = 1; 
            
            for ( int num : primero.get_posiciones()){                
                System.out.println("    "+num+" -> " + simbolo_en_tabla(num) +" -> " + siguientes_en_tabla(num));
            }
            
            ArrayList<String> simbolos = simbolos_en_estado(primero.get_posiciones());
            ArrayList<Integer> posiciones = primero.get_posiciones();
            int contador_interno = 0; 
            for (String simbolo: simbolos){  //acá va a desarrollarse todo el proceso 
                 contador_interno ++;
                 if ("#".equals(simbolo)){
                     primero.estado_aceptacion();
                     
                    if ( contador_interno == simbolos.size()){
                        finales.add(primero);
                        pendientes.remove(0);
                        contagor_general--;
                        
                        
                    }
                     
                     
                     
                 }else{
                    ArrayList<Integer> posiciones_estado = new ArrayList<>();
                    for (int i = 0; i < posiciones.size(); i++){
                        if( simbolo.equals(simbolo_en_tabla(posiciones.get(i)))){
                            ArrayList<Integer> auxiliar = unir_posiciones(posiciones_estado, siguientes_en_tabla(posiciones.get(i)));
                            posiciones_estado = auxiliar;
                        } 
                    }
                    // acá ya tenemos juntas todas las siguientes posiciones del mismo simbolo en este estado  
                    System.out.println(posiciones_estado);
                
                    //ahora vemos si ya tenemos un estado con esas posiciones guardado
                    Estado siguiente_estado = new Estado(contador_estados, posiciones_estado);
                    boolean encontrado = false;
                
                    // buscamos si este estado ya existe
                    for (Estado estado_actual : finales){ // si encuentra uno que ya esté guardado lo regresará
                        if (estado_actual.get_posiciones() == posiciones_estado){
                            siguiente_estado = estado_actual; 
                            encontrado = true;
                            break;
                        }
                    }
                
                    if (encontrado){ //hacemos transicion
                        transicion nueva = new transicion(simbolo, siguiente_estado);
                        primero.set_transicion(nueva);
                         
                    }else{ // insertamos el nuevo nodo, aumntamos el contador y hacemos transiciones                       
                        pendientes.add(siguiente_estado);
                        contador_estados ++; 
                        transicion nueva = new transicion(simbolo, siguiente_estado);
                        primero.set_transicion(nueva);
                        contagor_general ++;
                        
                    }
                    
                    if ( contador_interno == simbolos.size()){
                        finales.add(primero);
                        pendientes.remove(0);
                        contagor_general--;
                        
                    }
               
                 }
               }
            
                System.out.println(contagor_general);
            }
        }
            
        
        
        
        
        
        
        
        
        
        
        
        // Estos 2 métodos se pueden hacer en 1 para no consumir muchos recursos,
        // pero no lo intentamos unir por tiempo
        public ArrayList<Integer> siguientes_en_tabla(int id){
            
            ArrayList<Integer> siguientes = new ArrayList<>();   
            for (nodo_tabla_siguientes actual: tabla.simbolos ){
                if(actual.get_id() == id){
                    siguientes = actual.get_lista_siguientes(); 
                    break;
                }
            }   
            return siguientes;
        }
        
        public String simbolo_en_tabla(int id){
                   
            String simbolo = "";
            for (nodo_tabla_siguientes actual: tabla.simbolos ){
                if(actual.get_id() == id){
                    simbolo = actual.get_simbolo(); 
                    break;
                }
            }  
            return simbolo;
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
        data += "Tabla de estados finales\n";
        data += "Estados\n";
        
        for (Estado actual : finales) {
            data += "S" + actual.get_id()+"\n";
            ArrayList<transicion> transiciones = actual.get_transiciones();
            for (transicion trans : transiciones){
                data += "   Con " + trans.get_simbolo() +" se va a: S" + trans.get_apuntado();            
            }
            data += "\n" ;                                              

        }
        
        System.out.println(data);
        
    }
    
    public ArrayList<Integer> posiciones_estado(Estado estado, ArrayList<Integer> lista_posiciones, String simbolo){
        
        // encontramos todas las posiciones que tengan ese simbolo, y unimos los siguientes 
        // que tienen en la tabla de siguientes en un array, y lo retornamos
        
        // encontrando posiciones y guardando 
        ArrayList<Integer> auxiliar = new ArrayList<>();
        ArrayList<Integer> auxiliar_2 = new ArrayList<>();
        for(int actual : lista_posiciones){
            if ( simbolo.equals(simbolo_en_tabla(actual))){
                auxiliar = unir_posiciones(auxiliar, siguientes_en_tabla(actual));
            }else{
                
                
                
                
                
                auxiliar_2.add(actual);
            }
        }
        estado.set_posiciones(auxiliar_2); // guardamos las que quedan en el nodo
        System.out.println(auxiliar);
        System.out.println(auxiliar_2);
        return auxiliar ; //retornamos las que sí coincidieron
        
    }
    
// devolverá un array con lños simbolos diferentes que encuentre    
   public ArrayList<String> simbolos_en_estado (ArrayList<Integer> lista1){
            //lista1, en la que se va a buscar e isertar
            //lista2 de la que se van a extraer los elementos
        
            ArrayList<String> auxiliar = new ArrayList<>();
        
            for (Integer num : lista1) {
                String simbolo_actual = simbolo_en_tabla(num);
                if (auxiliar.indexOf(simbolo_actual)== -1){ //no se encuentra en esa lista
                    auxiliar.add(simbolo_actual);
                }
            }
            //Collections.sort(auxiliar);
            return auxiliar;  
    }  
        
        
        
        
    
    
}
