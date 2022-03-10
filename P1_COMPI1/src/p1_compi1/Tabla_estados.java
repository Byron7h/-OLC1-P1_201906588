
package p1_compi1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usuario
 */
public class Tabla_estados {
    
        ArrayList<Estado> pendientes = new ArrayList<>(); // lista de estados
        public ArrayList<Estado> finales = new ArrayList<>(); // lista de estados
    
        Tabla_siguientes tabla ;
        int contador = 0;
        
        // va apedir una raiz y la tabla de estados
        public Tabla_estados(ArrayList<Integer> raiz, Tabla_siguientes tabla){
            
            this.tabla = tabla;
            Estado nuevo = new Estado (contador, raiz); // Nuestro estado inicial
            pendientes.add(nuevo);
            contador = contador +1;
            generar_tabla(pendientes.get(0));
            
            
        }
        
        
        public void generar_tabla(Estado primero){
            //1 identificar raiz

            //System.out.println("RAIZ -> "+primero.get_posiciones());
            /*
            for ( int num : primero.get_posiciones()){                
                System.out.println("    "+num+" -> " + simbolo_en_tabla(num) +" -> " + siguientes_en_tabla(num));
            }
            */
            ArrayList<String> simbolos = simbolos_en_estado(primero.get_posiciones());
            ArrayList<Integer> posiciones = primero.get_posiciones();
            //System.out.println("Simbolos de estado "+ simbolos);
            for (String simbolo: simbolos){  //acá va a desarrollarse todo el proceso 
                 
                 if ("#".equals(simbolo)){
                     primero.estado_aceptacion();
                 }else{
                    ArrayList<Integer> posiciones_estado = new ArrayList<>();
                    for (int i = 0; i < posiciones.size(); i++){
                        if( simbolo.equals(simbolo_en_tabla(posiciones.get(i)))){
                            ArrayList<Integer> auxiliar = unir_posiciones(posiciones_estado, siguientes_en_tabla(posiciones.get(i)));
                            posiciones_estado = auxiliar;
                        } 
                    }
                    // acá ya tenemos juntas todas las siguientes posiciones del mismo simbolo en este estado  
                    //System.out.println(posiciones_estado);
                
                    //ahora vemos si ya tenemos un estado con esas posiciones guardado
                    Estado siguiente_estado = new Estado(contador, posiciones_estado);
                    boolean encontrado = false;
                
                    // buscamos si este estado ya existe
                    for (Estado estado_actual : finales){ // si encuentra uno que ya esté guardado lo regresará
                        ArrayList<Integer> uno = estado_actual.get_posiciones();
                        Collections.sort(uno);
                        String s_uno = uno.toString();
                        
                        ArrayList<Integer> dos = posiciones_estado;
                        Collections.sort(dos);
                        String s_dos = dos.toString();

                        if (s_uno.equals(s_dos)){
                            //System.out.println("Encotró u estado igual");
                            siguiente_estado = estado_actual; 
                            encontrado = true;
                            break;
                        }
                    }

                    for (Estado estado_actual : pendientes){ // si encuentra uno que ya esté guardado lo regresará
                        ArrayList<Integer> uno = estado_actual.get_posiciones();
                        Collections.sort(uno);
                        String s_uno = uno.toString();
                        
                        ArrayList<Integer> dos = posiciones_estado;
                        Collections.sort(dos);
                        String s_dos = dos.toString();
                        if (s_uno.equals(s_dos)){
                            //System.out.println("Encotró u estado igual");
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
                        contador ++; 
                        transicion nueva = new transicion(simbolo, siguiente_estado);
                        primero.set_transicion(nueva);                       
                    }
                 }
            }
            //System.out.println("Lega hasta el final");
            finales.add(primero);
            pendientes.remove(primero);
            //imprimir();
            if(pendientes.size() > 0){
                if(pendientes.get(0).get_posiciones().isEmpty()){
                    //System.out.println("Posiciones sigueintes vacias");
                }else{
                    generar_tabla(pendientes.get(0));
                }
            }else{
                //System.out.println("Por fin terminó este suplicio");
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
            if(actual.get_aceptacion()){
                data += "*";
            }
            data += "S" + actual.get_id()+"\n";
            ArrayList<transicion> transiciones = actual.get_transiciones();
            for (transicion trans : transiciones){
                data += "   Con " + trans.get_simbolo() +" se va a: S" + trans.get_apuntado();            
            }
            data += "\n" ;                                              

        }
        
        System.out.println(data);
        
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
        
    public void generar_grafo(){
                                    // Acá ya podemos colocarle código html, para los reportes
        String data = "digraph finite_state_machine {\n" +
"           fontname=\"Helvetica,Arial,sans-serif\"\n" +
"           node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
"           edge [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
"           rankdir=LR;";

        
        for (Estado actual : finales) {
            if(actual.get_aceptacion()){ //estados de aceptacion
                data += "    node [shape = doublecircle]; "+actual.get_id()+";\n";
            }                                            
        }
        data += "    node [shape = circle];";
        for (Estado actual : finales) {
            ArrayList<transicion> transiciones = actual.get_transiciones();
            for (transicion trans : transiciones){
                data += "   "+actual.get_id() + " -> " + trans.get_apuntado() +" [label = \""+trans.get_simbolo()+"\"];\n";
 
            }
            data += "\n" ;                                              

        }
        data += "}" ; 
        System.out.println(data);
        
        
        
    
    
    }    
        
        
    
    
}
