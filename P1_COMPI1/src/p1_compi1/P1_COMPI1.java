package p1_compi1;

import analizadores.Analizador_Lexico;
import analizadores.Analizador_sintactico;
import analizadores.TError;
import analizadores.Token;
import analizadores.conjunto;
import analizadores.RegExp;
import analizadores.cadena;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

public class P1_COMPI1 {

    public static void main(String[] args) {
        
        Integer contador = 1;
     
        /*
        try {
            Analizador_Lexico lexico = new Analizador_Lexico(
            new BufferedReader(new FileReader("./Prueba.exp"))
            );
            Analizador_sintactico sintactico = new Analizador_sintactico(lexico);
            sintactico.parse(); //funcion que nos lee
            
            System.out.println("\n\n***Conjuntos encontrados ");
            for (conjunto con : sintactico.conjuntos) {
                
                System.out.println(con.show());
            }
            
            System.out.println("\n\n***Expresiones encontradas ");
            for (RegExp con : sintactico.expresiones) {
                LinkedList<Token> expre = con.expresion;
                for (Token token_ : expre){
                System.out.print(token_.lexema.toString());
                    
                }
                System.out.println("---------------");
            }
            
            System.out.println("\n\n***Cadenas encontradas ");
            for (cadena con : sintactico.cadenas) {
                System.out.println(con.show());
            }
            
            
            
            System.out.println("\n\n***Reporte de errores encontrados ");
            for (TError errore : Analizador_Lexico.errores) {
                System.out.println(errore.show());
            }
            for (TError errore : sintactico.errores) {
                System.out.println(errore.show());
            }
            
        } catch (Exception e) {
        }*/
        
        //.{digito}."."+{digito}
        //. + {digito} . "." + {digito}
        
        
        
        
      
        LinkedList<Token> expresion = new LinkedList<>();
        Token nuevo = new Token("punto",".",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("asterisco","*",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("llave_a","{",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("id","digito",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("llave_c","}",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("o_logico","|",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("cadena","'.'",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("duda","?",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("llave_a","{",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("id","digito",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("llave_c","}",1,1);
        expresion.add(nuevo);
   

        arbol(expresion);

      
        
        /*
        ArrayList<Integer> lista1 = new ArrayList<>(); //lista en la que se va a buscar e isertar
        lista1.add(1);
        lista1.add(2);
        ArrayList<Integer> lista2 = new ArrayList<>(); //lista de la que se van a extraer los elementos
        lista2.add(125);
        lista2.add(2);
        lista2.add(9);
        lista2.add(80);
        
        System.out.println(unir_posiciones(lista1, lista2));
*/
            

        
    }
    
    public static void arbol(LinkedList<Token> expre){ 
        
        // • Paso 1 Agregando la concatenación al estado de aceptación 
        
        Integer contador = 1; //contador para el número de hoja
        
        
        // agegamos la ocncatencación al signo de aceptación
        Token nuevo = new Token("punto",".");
        expre.addFirst(nuevo);
        nuevo = new Token("aceptacion","#");
        expre.addLast(nuevo);
        
        // • Paso 2 Quitando los parentesis inneccesarios
        // acá vamos a aprovechar este recorrido para cambiar de un linkedlist a un arraylist de nodos
        // y agregamos la primeras y ultimas posiciones a las hojas
        
        ArrayList<nodo> expresion = new ArrayList<>();
        for(Token tok:expre){
            if ("llave_a".equals(tok.tipo) || "llave_c".equals(tok.tipo) ){  
            }else{
                
                nodo nuevo_nodo = new nodo(cantidad_hijos(tok), tok);  
                expresion.add(nuevo_nodo);
                
                // Primeras y ultimas posiciones de los nodos hoja
                if ("cadena".equals(nuevo_nodo.get_tipo()) || "id".equals(nuevo_nodo.get_tipo()) || "aceptacion".equals(nuevo_nodo.get_tipo())){
                    ArrayList<Integer> lista1 = new ArrayList<>(); //lista en la que se va a buscar e isertar
                    lista1.add(contador);
                    contador ++ ;
                    
                    nuevo_nodo.set_pos_p(lista1);
                    nuevo_nodo.set_pos_u(lista1);      
                }               
            }
        }
        
        
        //• Reducciones
        // Aca tambien iremos creando la cadena que imprimiremos en el dto, para el grafo 
        
        String result = "digraph structs {\n";
        result += "    node [shape=record, ];\n";
        
        
        while (expresion.size() != 1){
            for (int i = 1; i < expresion.size(); i++){
                
                if (expresion.size() == 3){
                    
                    // creando el arbol, enlazando nodos
                    nodo actual = expresion.get(0);
                    nodo derecha = expresion.get(1);
                    nodo izquierda = expresion.get(2);
                    
                    actual.set_derecha(derecha);
                    actual.set_izquierda(izquierda);
                    derecha.set_padre(actual);
                    izquierda.set_padre(actual);
                    
                    //anulable y posiciones
                    anulable(actual);
                    
                            
                            
                            
                    //Creando nodos en el grafo
                    int nombre_padre = actual.hashCode(); 
                    int nombre_derecha = derecha.hashCode(); 
                    int nombre_izquierda = izquierda.hashCode(); 
                    result += "    "+nombre_padre+" [label=\"{"+actual.get_str_anulable()+"|{"+actual.get_pos_p()+"|<here>"+actual.get_lexema()+"|"+actual.get_pos_p()+"}|}\"];\n";
                    result += "    "+nombre_derecha+" [label=\"{"+derecha.get_str_anulable()+"|{"+derecha.get_pos_p()+"|<here>"+derecha.get_lexema()+"|"+derecha.get_pos_p()+"}|}\"];\n";
                    result += "    "+nombre_izquierda+" [label=\"{"+izquierda.get_str_anulable()+"|{"+izquierda.get_pos_p()+"|<here>"+izquierda.get_lexema()+"|"+izquierda.get_pos_p()+"}|}\"];\n";                            
                            
                    // enlazando nodos en el grafo
                    result += "    "+nombre_padre+" -> "+nombre_derecha+";\n";
                    result += "    "+nombre_padre+" -> "+nombre_izquierda+";\n";

                    // sacando tokens del arraylist para continuar con las reducciones
                    expresion.remove(2);
                    expresion.remove(1);             
                    break;
                }
                
                int posicion = expresion.size() - i;
                nodo actual =  expresion.get(posicion);
                
                // buscamos que sea un operador, estos tienen el enlazable flase
                // si no solo pasamos al siguiente
                if(actual.enlazable == false){
                    
                    // Vemos la cantidad de hijos del nodo                 
                    if (actual.get_hijos() == 1){
                        if (expresion.get(expresion.size() - i + 1).enlazable == true){
                            
                            //procedemos a enlazar y a eliminar
                            actual.es_enlazable();
                            nodo hijo = expresion.get(expresion.size() - i + 1);
                            actual.set_abajo(hijo);
                            hijo.set_padre(actual);
                            
                            //anulable y posiciones
                            anulable(actual);
                            
                            
                            //Creando nodos en el grafo
                            int nombre_padre = actual.hashCode(); 
                            int nombre_hijo = hijo.hashCode(); 
                            result += "    "+nombre_padre+" [label=\"{"+actual.get_str_anulable()+"|{"+actual.get_pos_p()+"|<here>"+actual.get_lexema()+"|"+actual.get_pos_p()+"}|}\"];\n";
                            result += "    "+nombre_hijo+" [label=\"{"+hijo.get_str_anulable()+"|{"+hijo.get_pos_p()+"|<here>"+hijo.get_lexema()+"|"+hijo.get_pos_p()+"}|}\"];\n";
                            result += "    "+nombre_padre+" -> "+nombre_hijo+";\n";                            
                            
                            // sacando tokens del arraylist para continuar con las reducciones
                            expresion.remove(expresion.size() - i + 1);

                            
                            break;
                        }// si no solo pasa al siguiente
                    }
                    else{ // tiene 2 hijos
                        
                        if (expresion.get(expresion.size() - i + 1).enlazable == true && expresion.get(expresion.size() - i + 2).enlazable == true){
                            
                            //procedemos a enlazar y a eliminar
                            actual.es_enlazable();
                            nodo derecha = expresion.get(expresion.size() - i + 1);
                            nodo izquierda = expresion.get(expresion.size() - i + 2);
                            
                            actual.set_derecha(derecha);
                            actual.set_izquierda(izquierda);
                            derecha.set_padre(actual);
                            izquierda.set_padre(actual);
                            

                            //anulable y posiciones
                            anulable(actual);
                            

                            //Creando nodos en el grafo
                            int nombre_padre = actual.hashCode(); 
                            int nombre_derecha = derecha.hashCode(); 
                            int nombre_izquierda = izquierda.hashCode(); 
                            result += "    "+nombre_padre+" [label=\"{"+actual.get_str_anulable()+"|{"+actual.get_pos_p()+"|<here>"+actual.get_lexema()+"|"+actual.get_pos_p()+"}|}\"];\n";
                            result += "    "+nombre_derecha+" [label=\"{"+derecha.get_str_anulable()+"|{"+derecha.get_pos_p()+"|<here>"+derecha.get_lexema()+"|"+derecha.get_pos_p()+"}|}\"];\n";
                            result += "    "+nombre_izquierda+" [label=\"{"+izquierda.get_str_anulable()+"|{"+izquierda.get_pos_p()+"|<here>"+izquierda.get_lexema()+"|"+izquierda.get_pos_p()+"}|}\"];\n";                            
                            
                            // enlazando nodos
                            result += "    "+nombre_padre+" -> "+nombre_derecha+";\n";
                            result += "    "+nombre_padre+" -> "+nombre_izquierda+";\n";
                            
                            // sacando tokens del arraylist para continuar con las reducciones
                            int cantidad = expresion.size();
                            expresion.remove(cantidad  - i + 2);
                            expresion.remove(cantidad  - i + 1);
                            break;
                            
                        }// si no entra a ninguno solo pasa al siguiente
                    }
                }    
            }
        imprimir_lista(expresion);
        }
        result += "}";
        System.out.println(result);
    }
    
    public static void imprimir_lista(LinkedList<Token> expre){
        System.out.println("Tamaño: "+ expre.size());
        
        for(Token tok:expre){
            System.out.print(tok.lexema);
        }
        System.out.println("");
        
    }
      
    public static void imprimir_lista(ArrayList<nodo> expre){
        System.out.println("Tamaño: "+ expre.size());
        
        for(nodo node:expre){   
            System.out.print(node.get_contenido().lexema);
        }
        System.out.println("");
        
    }
    
    public static int cantidad_hijos(Token tok){ // Metodo para saber que cantidad de hijos debe tener el nodo que ceraremos a partir del token
        int cantidad = 2; 
        String tipo = tok.tipo;
        if ("mas".equals(tipo) || "asterisco".equals(tipo) || "duda".equals(tipo)){
            cantidad = 1;
        }
        return cantidad;
    }

    public static void anulable(nodo evaluado){ //metodo que guarda el atributo anulable de un nodo
        String tipo = evaluado.get_tipo();
        
        if ( "cadena".equals(tipo) || "id".equals(tipo) || "aceptacion".equals(tipo)){ //Si son hojas, es falso, y como por defecto este atributo es F, lo dejamos así
            //Anualble = F
        
        }else if("asterisco".equals(tipo) || "duda".equals(tipo)){ //Anulable = V
            evaluado.es_anulable(); 
            
        }else if("o_logico".equals(tipo)){ //Anulable = O logico entre los anulables de los hijps

            boolean derecha = evaluado.get_derecha().get_anulable();
            boolean izquierda = evaluado.get_izquierda().get_anulable();
            boolean o_logico = derecha || izquierda;
            if(o_logico){ // si o_logico es true anualble es V, si no lo es se queda F
                evaluado.es_anulable(); 
            }
            
        }else if("punto".equals(tipo)){ //Anulable = Y logico

            boolean derecha = evaluado.get_derecha().get_anulable();
            boolean izquierda = evaluado.get_izquierda().get_anulable();
            boolean y_logico = derecha && izquierda;
            if(y_logico){ // si y_logico es true anualble es V, si no lo es se queda F
                evaluado.es_anulable(); 
            }  
        }else{ // + anulable si el de abajo es anulable
            boolean abajo = evaluado.get_abajo().get_anulable();
            if(abajo){ // si el de abajo es true anualble es V, si no lo es se queda F
                evaluado.es_anulable(); 
            }
        }
    }  //Este será solo para los padres, porque las hojas ya están, porque sonF por defecto

    public static ArrayList<Integer> unir_posiciones (ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        //lista1, en la que se va a buscar e isertar
        //lista2 de la que se van a extraer los elementos

        for (Integer num : lista2) {
            if (lista1.indexOf(num)== -1){ //no se encuentra en esa lista
                lista1.add(num);
            }
        }
        //System.out.println(lista1.toString()); //podemos imprimirla de esta forma
        Collections.sort(lista1);
        return lista1;
    
        
    }

}