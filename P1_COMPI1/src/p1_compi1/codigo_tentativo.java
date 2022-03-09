/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_compi1;

/**
 *
 * @author usuario
 */
public class codigo_tentativo {
    
    /*
    
package p1_compi1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usuario
 *//*
public class Tabla_estados {
    
    
    
        ArrayList<Estado> pendientes= new ArrayList<>(); // lista de estados
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
            int conteo = 1;
            while (!pendientes.isEmpty()){
                //System.out.println("entro a generar tablas");
                 // nos va a servir para ponerle nombre a los estados 
                Estado actual = pendientes.get(0);
                while (actual.get_posiciones().size()>0){
                    ArrayList<Integer> lista_posiciones = actual.get_posiciones(); //obtenemos la lista de posiciones del estado que estamos tratando, en la primera iteración serían las primeras posiciones de la raiz
                    int primera_pos = lista_posiciones.get(0); //primera posción de la lista
                    String simbolo = simbolo_en_tabla(primera_pos); // obtenemos el simbolo de nuestra primera posicion
                    
                   if ("#".equals(simbolo)){
                       actual.estado_aceptacion();
                       lista_posiciones.clear();
                        finales.add(actual);
                        System.out.println("se acabaron las posiciones en el nodo");
                        pendientes.clear());
                        ArrayList<Integer> prueba = new ArrayList<>();
                        Estado nuevo_2 =  new Estado (conteo + 1, prueba);
                        pendientes.add(nuevo_2);
                        
                        
                        
                        
                   
                   }else{
                   
                    
                    
                    // acá vamos a enviar nuestra lista de posiciones del nodo y el simbolo del cual queremos obtener sus siguientes
                    ArrayList<Integer> auxiliar = posiciones_estado(actual,lista_posiciones, simbolo);
                    
                    // En este punto las posiciones de nuestro nuevo estado están en auxiliar
                    // vamos a comparar con las posiciones de los nodos finales, para ver si ya hay algún estado con esas posiciones 
                    boolean existe = false;
                    Estado apuntado =  new Estado (conteo, auxiliar);
                    
                    for(Estado estado_actual : finales){
                        if (auxiliar == estado_actual.get_posiciones()){
                            existe = true;
                            apuntado = estado_actual;
                        }
                    }
                    
                    //System.out.println(existe);
                    
                    // Si no se encontró un estado igual, creamos el nuevo estado, apuntamos hacia él y aumentamos el contador
                    if (existe != true){            
                        conteo ++ ;
                        pendientes.add(apuntado);
                        System.out.println("nuevo estado");

                    }
                    
                    // Creando y guardando transiciones
                    transicion nueva = new transicion(simbolo, apuntado);
                    actual.add_transicion(nueva);   
                    
                    
                    
                    // Verificando si quedan posicionoes en este nodo, si ya se quedó vacia lo sacamos de pendientes y lo agregamos a finales
                    if (actual.get_posiciones().size() == 0){
                        finales.add(actual);
                        System.out.println("se acabaron las posiciones en el nodo");
                        pendientes.remove(0);
                    }
                    
                    }
                    
                   System.out.println("Finales: " + finales.size());
                   System.out.println("Pendientes: " + pendientes.size());
                }
                
                imprimir();
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
        
        
        
        
        
        
    
    
}

    */
    
    /*
    
    
    
    
    
package p1_compi1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usuario
 */
    
    /*
public class Tabla_estados {
    
        ArrayList<Estado> pendientes= new ArrayList<>(); // lista de estados
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
            int conteo = 1;
            while (!pendientes.isEmpty()){
                //System.out.println("entro a generar tablas");
                 // nos va a servir para ponerle nombre a los estados 
                Estado actual = pendientes.get(0);
                while (actual.get_posiciones().size()>0){
                    ArrayList<Integer> lista_posiciones = actual.get_posiciones(); //obtenemos la lista de posiciones del estado que estamos tratando, en la primera iteración serían las primeras posiciones de la raiz
                    int primera_pos = lista_posiciones.get(0); //primera posción de la lista
                    String simbolo = simbolo_en_tabla(primera_pos); // obtenemos el simbolo de nuestra primera posicion
                    
                    
                    
                    // acá vamos a enviar nuestra lista de posiciones del nodo y el simbolo del cual queremos obtener sus siguientes
                    ArrayList<Integer> auxiliar = posiciones_estado(actual,lista_posiciones, simbolo);
                    
                    // En este punto las posiciones de nuestro nuevo estado están en auxiliar
                    // vamos a comparar con las posiciones de los nodos finales, para ver si ya hay algún estado con esas posiciones 
                    boolean existe = false;
                    
                    
                    if (auxiliar.isEmpty()){
                        finales.add(actual);
                        System.out.println("se acabaron las posiciones en el nodo");
                        pendientes.clear();
                        System.out.println("Queda estos pendientwea" + pendientes.size());

                            
                    }else{                    
                        Estado apuntado =  new Estado (conteo, auxiliar);
                    
                        for(Estado estado_actual : finales){
                            if (auxiliar == estado_actual.get_posiciones()){
                                existe = true;
                                apuntado = estado_actual;
                            }
                        }
                    
                        //System.out.println(existe);
                    
                        // Si no se encontró un estado igual, creamos el nuevo estado, apuntamos hacia él y aumentamos el contador
                        if (existe != true){            
                            conteo ++ ;
                            pendientes.add(apuntado);
                            System.out.println("nuevo estado");

                        }
                    
                        // Creando y guardando transiciones
                        transicion nueva = new transicion(simbolo, apuntado);
                        actual.add_transicion(nueva);   
                    
                        // Verificando si quedan posicionoes en este nodo, si ya se quedó vacia lo sacamos de pendientes y lo agregamos a finales
                        if (actual.get_posiciones().size() == 0){
                            finales.add(actual);
                            System.out.println("se acabaron las posiciones en el nodo");
                            pendientes.remove(0);
                        }
                    
                    }
                    
                   System.out.println("Finales: " + finales.size());
                   System.out.println("Pendientes: " + pendientes.size());
                }               
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
        
        
        
        
        
        
    
    
}

    
    
    
    */
    
    
    
    
    
    
    
}
