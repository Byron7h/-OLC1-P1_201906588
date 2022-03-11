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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Comparator;

public class P1_COMPI1 {
    
    static ArrayList<Automata> Automatas = new ArrayList<>();
    static LinkedList<conjunto> Conjuntos = new LinkedList<>();
    

    public static void main(String[] args) {
        
        
     
        
        try {
            Analizador_Lexico lexico = new Analizador_Lexico(
            new BufferedReader(new FileReader("./Prueba.exp"))
            );
            Analizador_sintactico sintactico = new Analizador_sintactico(lexico);
            sintactico.parse(); //funcion que nos lee
            
            
            
            if ( Analizador_Lexico.errores.isEmpty()  && Analizador_sintactico.errores.isEmpty()){ //hacemos todo el proceso
                System.out.println("No se encontraron errores");
                for (RegExp con : sintactico.expresiones) {
                    LinkedList<Token> expre = con.expresion;
                    String id = con.get_id();    
                    arbol(id,expre);

                }
            
                reporte();
            }else{

                System.out.println("Se encontraron errores en el archivo de entrada");
                reporte_errores(Analizador_Lexico.errores,Analizador_sintactico.errores );
            }

            
            
            //System.out.println("\n\n***Conjuntos encontrados ");
            
            //Conjuntos = sintactico.conjuntos;
            //for (conjunto con : sintactico.conjuntos) {
                
                //System.out.println(con.show());
            //}
            
/*
            
            System.out.println("\n\n***Cadenas encontradas ");
            for (cadena con : sintactico.cadenas) {
                //buscamos el id de la exp regular en los id de los automatas genrados
                String identificador = con.get_id();
                String cadena_1 = con.get_cadena();
                //System.out.println(cadena_1);
                //System.out.println(cadena_1);
                cadena_1 = cadena_1.substring(1,cadena_1.length()-1 );
                //System.out.println(cadena_1);
                //System.out.println(cadena_1);
                
                
                
                for (Automata automata: Automatas){
                    if(automata.get_id().equals(identificador)){
                        ArrayList<Estado> nuevo = automata.get_tabla_estados().finales; 
                        for (Estado fina:nuevo){
                            if (fina.get_id()==0){
                                char[] conjunto = cadena_1.toCharArray();
                                //System.out.println(conjunto);

                                //validar_cadena( fina, conjunto , con );
                                break;
                            }
                        }
                        break;
                    }
                }

            }
            
        */ 
            

            
        } catch (Exception e) {
        }

        
    }
    
    public static void arbol(String id,LinkedList<Token> expre){ 
        
        // • Paso 1 Agregando la concatenación al estado de aceptación 
        
        Integer contador = 1; //contador para el número de hoja
        Tabla_siguientes tabla = new Tabla_siguientes();
        
        ArrayList<Integer> raiz = new ArrayList<>(); // Lista para guardar la primera posicion de la raiz del atbol, para la tabla de siguientes
        
        
        
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
                // Y agregar sus simbolos a la tabla de siguientes
                if ("cadena".equals(nuevo_nodo.get_tipo()) || "id".equals(nuevo_nodo.get_tipo()) || "aceptacion".equals(nuevo_nodo.get_tipo())){
                    ArrayList<Integer> lista1 = new ArrayList<>(); //lista en la que se va a buscar e isertar
                    lista1.add(contador);
                    
                    nuevo_nodo.set_pos_p(lista1);
                    nuevo_nodo.set_pos_u(lista1); 
                    tabla.agregar(nuevo_nodo.get_lexema(),contador); //simbolo, id(numero)
                    
                    contador ++ ;
                }               
            }
        }
        
        
        //• Reducciones
        // Aca tambien iremos creando la cadena que imprimiremos en el dto, para el grafo 
        
        String result = "digraph structs {\n";
        result += "    fontname=\"Helvetica,Arial,sans-serif\"\n"+
                  "    node [shape=record, fontname=\"Helvetica,Arial,sans-serif\" ];\n    edge [dir = none]\n";
        
        
        while (expresion.size() != 1){
            for (int i = 1; i < expresion.size(); i++){
                
                if (expresion.size() == 3){ // última iteración
                    
                    // creando el arbol, enlazando nodos
                    nodo actual = expresion.get(0);
                    nodo derecha = expresion.get(2);
                    nodo izquierda = expresion.get(1);
                    
                    actual.set_derecha(derecha);
                    actual.set_izquierda(izquierda);
                    derecha.set_padre(actual);
                    izquierda.set_padre(actual);
                    
                    //anulable y posiciones
                    anulable(actual);
                    primeras_y_ultimas_posiciones(actual);
                    
                            
                            
                            
                    //Creando nodos en el grafo
                    int nombre_padre = actual.hashCode(); 
                    int nombre_derecha = derecha.hashCode(); 
                    int nombre_izquierda = izquierda.hashCode(); 
                    
                    result += "    "+nombre_padre+" [label=\"{"+actual.get_str_anulable()+"|{"+actual.get_pos_p()+"|<here>"+actual.get_lexema()+"|"+actual.get_pos_u()+"}}\"];\n";
                    
                    if ("id".equals(derecha.get_tipo()) ||"cadena".equals(derecha.get_tipo()) ||"aceptacion".equals(derecha.get_tipo())){
                        result += "    "+nombre_derecha+" [label=\"{"+derecha.get_str_anulable()+"|{"+derecha.get_pos_p()+"|<here>"+derecha.get_lexema()+"|"+derecha.get_pos_u()+"}}\"];\n";
                    }
                    if ("id".equals(izquierda.get_tipo()) ||"cadena".equals(izquierda.get_tipo()) ||"aceptacion".equals(izquierda.get_tipo())){
                        result += "    "+nombre_izquierda+" [label=\"{"+izquierda.get_str_anulable()+"|{"+izquierda.get_pos_p()+"|<here>"+izquierda.get_lexema()+"|"+izquierda.get_pos_u()+"}}\"];\n";
                    }

       
                    // enlazando nodos en el grafo
                    
                    result += "    "+nombre_padre+" -> "+nombre_izquierda+";\n";
                    result += "    "+nombre_padre+" -> "+nombre_derecha+";\n";
                    

                    // sacando tokens del arraylist para continuar con las reducciones
                    expresion.remove(2);
                    expresion.remove(1);      
                    
                                                //Llenando tabla de siguientes
                    if ("punto".equals(actual.get_tipo())){
                        tabla.agregar_siguientes(izquierda.get_pos_u(), derecha.get_pos_p());
                    }
                    
                    
                    // Guardando la primera posicion de la raiz
                    raiz = actual.get_pos_p();
                    
                    break;
                }
                
                int posicion = expresion.size() - i;
                nodo actual =  expresion.get(posicion);
                
                // buscamos que sea un operador, estos tienen el enlazable flase
                // si no solo pasamos al siguiente
                if(actual.enlazable == false){
                    
                    // Vemos la cantidad de hijos del nodo                 
                    if (actual.get_hijos() == 1){ //* + ?
                        if (expresion.get(expresion.size() - i + 1).enlazable == true){
                            
                            //procedemos a enlazar y a eliminar
                            actual.es_enlazable();
                            nodo hijo = expresion.get(expresion.size() - i + 1);
                            actual.set_abajo(hijo);
                            hijo.set_padre(actual);
                            
                            //anulable y posiciones
                            anulable(actual);
                            primeras_y_ultimas_posiciones(actual);
                            
                            //Creando nodos en el grafo
                            int nombre_padre = actual.hashCode(); 
                            int nombre_hijo = hijo.hashCode(); 
                            result += "    "+nombre_padre+" [label=\"{"+actual.get_str_anulable()+"|{"+actual.get_pos_p()+"|<here>"+actual.get_lexema()+"|"+actual.get_pos_u()+"}}\"];\n";
                            
                            // si es una hoja se crea el nodo, ya que no existe, pero si no lo es solo se enlaza
                            if ("id".equals(hijo.get_tipo()) ||"cadena".equals(hijo.get_tipo()) ||"aceptacion".equals(hijo.get_tipo())){
                                    result += "    "+nombre_hijo+" [label=\"{"+hijo.get_str_anulable()+"|{"+hijo.get_pos_p()+"|<here>"+hijo.get_lexema()+"|"+hijo.get_pos_u()+"}}\"];\n";
                            }
                            
                            //enlazando nodos en elgrafo
                            result += "    "+nombre_padre+" -> "+nombre_hijo+";\n";                            
                            
                            
                            // sacando tokens del arraylist para continuar con las reducciones
                            expresion.remove(expresion.size() - i + 1);
                            
                            //Llenando tabla de siguientes
                            if ("asterisco".equals(actual.get_tipo()) || "mas".equals(actual.get_tipo())){
                                tabla.agregar_siguientes(actual.get_pos_u(), actual.get_pos_p());
                            }
                            

                            
                            break;
                        }// si no solo pasa al siguiente
                    }
                    else{ // tiene 2 hijos
                        
                        if (expresion.get(expresion.size() - i + 1).enlazable == true && expresion.get(expresion.size() - i + 2).enlazable == true){
                            
                            //procedemos a enlazar y a eliminar
                            actual.es_enlazable();
                            nodo izquierda = expresion.get(expresion.size() - i + 1); // izquierda porqu e este es e primero que viene en la exp regular
                            nodo derecha = expresion.get(expresion.size() - i + 2);
                            
                            actual.set_derecha(derecha);
                            actual.set_izquierda(izquierda);
                            derecha.set_padre(actual);
                            izquierda.set_padre(actual);
                            

                            //anulable y posiciones
                            anulable(actual);
                            primeras_y_ultimas_posiciones(actual);

                            //Creando nodos en el grafo
                            int nombre_padre = actual.hashCode(); 
                            int nombre_derecha = derecha.hashCode(); 
                            int nombre_izquierda = izquierda.hashCode(); 
                            result += "    "+nombre_padre+" [label=\"{"+actual.get_str_anulable()+"|{"+actual.get_pos_p()+"|<here>"+actual.get_lexema()+"|"+actual.get_pos_u()+"}}\"];\n";
                            
                            if ("id".equals(derecha.get_tipo()) ||"cadena".equals(derecha.get_tipo()) ||"aceptacion".equals(derecha.get_tipo())){
                                    result += "    "+nombre_derecha+" [label=\"{"+derecha.get_str_anulable()+"|{"+derecha.get_pos_p()+"|<here>"+derecha.get_lexema()+"|"+derecha.get_pos_u()+"}}\"];\n";
                            }
                            if ("id".equals(izquierda.get_tipo()) ||"cadena".equals(izquierda.get_tipo()) ||"aceptacion".equals(izquierda.get_tipo())){
                                    result += "    "+nombre_izquierda+" [label=\"{"+izquierda.get_str_anulable()+"|{"+izquierda.get_pos_p()+"|<here>"+izquierda.get_lexema()+"|"+izquierda.get_pos_u()+"}}\"];\n";
                            }

 
                            // enlazando nodos en el grafo
                            result += "    "+nombre_padre+" -> "+nombre_izquierda+";\n";
                            result += "    "+nombre_padre+" -> "+nombre_derecha+";\n";
                            
                            //Creando subgrafo para que se ordene en orden, los nodos van como una cola
                            result += "    subgraph cluster_"+nombre_padre+" {\n"
                                    + "      color = white;\n"
                                    + "      "+nombre_izquierda+"; "+nombre_derecha+"; }\n";

                            
                            
                            //Llenando tabla de siguientes
                            if ("punto".equals(actual.get_tipo())){
                                tabla.agregar_siguientes(izquierda.get_pos_u(), derecha.get_pos_p());
                            }
                            
                            
                            // sacando tokens del arraylist para continuar con las reducciones
                            int cantidad = expresion.size();
                            expresion.remove(cantidad  - i + 2);
                            expresion.remove(cantidad  - i + 1);
                            break;
                            
                        }// si no entra a ninguno solo pasa al siguiente
                    }
                }    
            }
        //imprimir_lista(expresion);
        }
        result += "}";
        //System.out.println(result); 
        
        GenerarImagen("arbol_"+id, result);
        
        
        //tabla.imprimir();
        Tabla_estados tabla_2 = new Tabla_estados(raiz, tabla);
        //tabla_2.imprimir();
        
        GenerarImagen("automata_"+id, tabla_2.generar_grafo());
        Automata nuevo_automata = new Automata(id,tabla,tabla_2);
        Automatas.add(nuevo_automata);
 
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
    
    public static void primeras_y_ultimas_posiciones(nodo enlazado){
        
        if ("asterisco".equals(enlazado.get_tipo()) || "duda".equals(enlazado.get_tipo()) || "mas".equals(enlazado.get_tipo())){
            enlazado.set_pos_p(enlazado.get_abajo().get_pos_p());
            enlazado.set_pos_u(enlazado.get_abajo().get_pos_u());
            
        }else if("o_logico".equals(enlazado.get_tipo())){ //union de las primeras y ultimas posiciones de sus hijos
            ArrayList<Integer> primeras = unir_posiciones(enlazado.get_derecha().get_pos_p(),enlazado.get_izquierda().get_pos_p());
            ArrayList<Integer> ultimas = unir_posiciones(enlazado.get_derecha().get_pos_u(),enlazado.get_izquierda().get_pos_u());
            enlazado.set_pos_p(primeras);
            enlazado.set_pos_u(ultimas);

        }else{ // si es concatencacion
            
            //primeras 
            if (enlazado.get_izquierda().get_anulable() == true){ // se unen
                ArrayList<Integer> primeras = unir_posiciones(enlazado.get_derecha().get_pos_p(),enlazado.get_izquierda().get_pos_p());
                enlazado.set_pos_p(primeras);
                
            }else{ // 
                enlazado.set_pos_p(enlazado.get_izquierda().get_pos_p());
            }
            
            
            // ultimas
            if (enlazado.get_derecha().get_anulable() == true){ // se unen
                ArrayList<Integer> ultimas = unir_posiciones(enlazado.get_derecha().get_pos_u(),enlazado.get_izquierda().get_pos_u());
                enlazado.set_pos_u(ultimas);
                
            }else{ // 
                enlazado.set_pos_u(enlazado.get_derecha().get_pos_u());
            }
            
            
            
        }
        
    }
    
    public static String cadenas (String cadena){
        // Vamos a recibir un String "x"
        // y vamos aretornar un string 'x'
        
        int tamano = cadena.length();
        String nueva = cadena.substring(1,tamano-1);

        return "'"+nueva+"'";
    } 
    
    public static void validar_cadena( Estado actual, char[] cadena_ , cadena procesada ){
        
        System.out.println(         cadena_);
        System.out.println(actual.get_id());
        
        Estado estado = actual;
        int posicion = 0;
        int tamano_cadena = cadena_.length;
        boolean entro = false;
        
        while (posicion+1 <tamano_cadena){

            ArrayList<transicion> transiciones = actual.get_transiciones();
            for (transicion trans_actual : transiciones){
                
                String simbolo = trans_actual.get_simbolo();
                System.out.println("simbol "+simbolo);
                // pueden venir o una cadena o un identicadores o cadenas
 
                if (simbolo.endsWith("'")){ // • camino para una cadena
                    System.out.println("entro a cadena");
                    
                    String au = simbolo.substring(1,simbolo.length()-1);
                    System.out.println(simbolo +" "+au);                  
                    char[] simbol = au.toCharArray();
                    
                    if (cadena_.length  >= simbol.length){ // para poder ingresar el simbolo debe ser de igual o menor tañano                       
                        boolean es_igual = true;                      
                        for (int i = 0; i<simbol.length; i++){ //verificamos que sea igual
                            if (simbol[i]!=cadena_[i]){
                                es_igual = false;
                                break;
                            }
                        }                      
                        if (es_igual){
                            posicion = posicion + simbol.length; //avanzamos
                            entro = true;
                            if ( posicion+1 == tamano_cadena && estado.get_aceptacion()){
                                procesada.cadena_aceptada();
                                System.out.println("cadena: " + procesada.get_cadena() +" es " + procesada.get_valida() );
                                break;
                            }else if(posicion+1 == tamano_cadena && estado.get_aceptacion()== false){
                                 System.out.println("cadena 1 : " + procesada.get_cadena() +" es " + procesada.get_valida() );
                                 posicion = tamano_cadena; //para que salga del while
                                 break;                               
                            }else{
                                estado = trans_actual.get_estado_apuntado();
                                break;
                            }
                        }      
                    }  
                    
                }else{ // es un identificador, un conjunto, ahora hay que identificar si se trata de un intérvalo o una lsita
                    System.out.println("entro a id");
                    // encontramos su contenido
                    String contenido = "";
                    for ( conjunto conjunto_actual : Conjuntos){
                        if(simbolo.equals(conjunto_actual.get_id())){
                            contenido = conjunto_actual.get_contenido();
                            break;
                        } 
                    }
                    
                    // • Conjunto intervalo 
                    if (contenido.contains("~")){
                        
                        //convirtiendo la cadena en un array de chars
                        char[] Caracteres = contenido.toCharArray();
                        int mayor = Caracteres[2];
                        int menor = Caracteres[0];
                        int evaluado = cadena_[posicion];
                        
                        if (evaluado>= menor && evaluado>= mayor){ // es que pertenece a este conjunto
                            posicion ++; //avanzamos una posicion en la entrada
                            entro = true;
                            if ( posicion + 1 == tamano_cadena && estado.get_aceptacion()){
                                    procesada.cadena_aceptada();
                                    System.out.println("cadena: " + procesada.get_cadena() +" es " + procesada.get_valida() );
                                    break;
                            }else if(posicion + 1 == tamano_cadena && estado.get_aceptacion()== false){
                                    System.out.println("cadena 2 : " + procesada.get_cadena() +" es " + procesada.get_valida() );
                                    posicion = tamano_cadena; //para que salga del while
                                    break;
                                    
                            }else{
                                estado = trans_actual.get_estado_apuntado();
                                break;
                            }
                        }

                    }else{ // conjuntos lista, acá no vamos a poder validar cadenas, solo simbolos sueltos
                        
                        //convirtiendo la lista en un array
                        String[] lista = contenido.split(",");
                        char aux = cadena_[0];
                        
                        for(int i = 0; i< lista.length; i++){
                            if(lista[i].contains("'")){
                                 // se ignora
                            }else{ //vemos si lo contiene
                                if(lista[i].charAt(0)==aux){
                                    posicion ++; //avanzamos en la entrada
                                    entro = true;
                                    //entro = true;
                                    //actual = trans_actual.get_estado_apuntado();

                                    if ( posicion+1 == tamano_cadena && estado.get_aceptacion()){
                                        procesada.cadena_aceptada();
                                        System.out.println("cadena: " + procesada.get_cadena() +" es " + procesada.get_valida() );
                                        break;
                                        
                                    }else if(posicion+1 == tamano_cadena && estado.get_aceptacion()== false){
                                        System.out.println("cadena 3 : " + procesada.get_cadena() +" es " + procesada.get_valida() );
                                        posicion = tamano_cadena; //para que salga del while
                                        break;
                                    }else {
                                        estado = trans_actual.get_estado_apuntado();
                                        break;
                                    }
                                    
                                }
                             
                            } 
                        }
                    }
                }        
            }
            
            //entro vuelve a iterar, porque estamos seguros que no es aceptacion, si no estó a ningun estado 
            //quiere decir que o ya no hay transiciones o que no entró a ninguna
            
            if("Aceptada".equals(procesada.get_valida())){ // es que se aceptó, salgrá del while
            
            
            }else if(entro) { // si no es aceptada, pero sí entro, no pasa nada, va a entrar de nuevo al while si nuestras validaciones lo permiten
                
            
            }else{  //no entro a ningun estado, ya sea por que ya no tenía transiciones o porque no podía irse por ninguna, cadena no valida
                System.out.println("cadena 4 : " + procesada.get_cadena() +" es " + procesada.get_valida() );
                posicion = tamano_cadena; //para que salga del while                      
            }
        } 
    }  
    
    public static void GenerarImagen(String nombre, String txtDTO) {
        try {
            // creamos un nuevo archivo txt
            String contenido = txtDTO;
            File file = new File("C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Compi 1\\P1\\-OLC1-PROYECTO_1_201906588\\P1_COMPI1\\imagenes\\"+nombre + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            
            // Le escribimos nuestro codigo dto
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();

            //---------Compilar el dto
            
            // ruta de dot.exe, mi equipo -> archivos del programa -> graphviz -> bin ->dot

            String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            String fileIn = file.getCanonicalPath(); //esto es para obtener la ruta
            String fileOU = fileIn.replace(".txt", ".jpg"); // salida de imagen
            String tParam = "-Tjpg";
            String tOparam = "-o";

            String[] cmd = new String[5]; // cadena de cadenas 
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileIn;
            cmd[3] = tOparam;
            cmd[4] = fileOU;

            Runtime rt = Runtime.getRuntime(); //herramienta para ejecutar comandos
            rt.exec(cmd);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
    public static void reporte(){
        
        for (Automata actual:Automatas){
            String nombre = actual.get_id();
            Tabla_siguientes t_siguientes = actual.get_tabla_siguientes();
            Tabla_estados t_estados = actual.get_tabla_estados();
        
            
            try{
                
            String ruta = "C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Compi 1\\P1\\-OLC1-PROYECTO_1_201906588\\P1_COMPI1\\reportes\\Reporte_"+nombre+".html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            
            
            //empezamos a escribir nuestro html
            writer.println("<link href=\"Reporte_muestra.css\" rel=\"stylesheet\">");
            writer.println("<body>");
            writer.println("    <div id=\"wrapper\">");
            writer.println("    <h1>"+nombre+"</h1>");
            writer.println("    <br>");
            writer.println("    <br>");
            
            writer.println("    <h2>• Árbol generado</h2>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <img src=\"C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Compi 1\\P1\\-OLC1-PROYECTO_1_201906588\\P1_COMPI1\\imagenes\\arbol_"+nombre+".jpg\">>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            
            writer.println("    <h2>• Tabla de siguientes</h2>");
            writer.println("    <table id=\"keywords\" cellspacing=\"0\" cellpadding=\"0\">");
            writer.println("        <thead>");
            writer.println("        <tr>");
            writer.println("            <th><span>Símbolo</span></th>");
            writer.println("            <th><span>Número</span></th>");
            writer.println("            <th><span>Siguientes</span></th>");

            writer.println("        </tr>");
            writer.println("        </thead>");
            writer.println("        <tbody>");
            
            for (nodo_tabla_siguientes ac : t_siguientes.simbolos) { 
                writer.println("            <tr>");
                writer.println("                <td>"+ac.get_simbolo()+"</td>");
                writer.println("                <td>"+ac.get_id()+"</td>");
                writer.println("                <td>"+ac.get_lista_siguientes()+"</td>");   
                writer.println("            </tr>");
            }
            
            writer.println("        </tbody>");
            writer.println("    </table>");
            
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            
            writer.println("    <h2>• Tabla de estados</h2>");
            writer.println("    <table id=\"keywords\" cellspacing=\"0\" cellpadding=\"0\">");
            writer.println("        <thead>");
            writer.println("        <tr>");
            writer.println("            <th><span>Estado</span></th>");
            writer.println("            <th><span>Transiciones</span></th>");
            writer.println("        </tr>");
            writer.println("        </thead>");
            writer.println("        <tbody>");
            
            for (Estado act : t_estados.finales) {
                
                writer.println("            <tr>");
                writer.println("                <td>S"+act.get_id()+"</td>"); 
                writer.println("                <td>");  
 
                ArrayList<transicion> transiciones = act.get_transiciones();
                for (transicion trans : transiciones){
                    writer.println("                    <p> Con " + trans.get_simbolo() +" se va a S"+trans.get_apuntado()+" </p>");           
                }
                writer.println("                </td>");  
                writer.println("            </tr>");
              
                
            }    

            writer.println("        </tbody>");
            writer.println("    </table>");
            
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            
            writer.println("    <h2>• Autómata</h2>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <br>");
            writer.println("    <img src=\"C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Compi 1\\P1\\-OLC1-PROYECTO_1_201906588\\P1_COMPI1\\imagenes\\automata_"+nombre+".jpg\">>");

            writer.println("</BODY>");
            writer.println("</HTML>");
            writer.close();
            
            }catch (Exception e) {
            e.printStackTrace();
            }
            
  
            
            
        
        
        }
    
    
    }
    
    public static void reporte_errores(LinkedList<TError> lexico , LinkedList<TError> sintactico){

            int contador = 1;
            
            try{
                
            String ruta = "C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Compi 1\\P1\\-OLC1-PROYECTO_1_201906588\\P1_COMPI1\\errores\\Reporte_errores.html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            
            writer.println("<link href=\"Reporte_muestra.css\" rel=\"stylesheet\">");
            writer.println("<body>");
            writer.println("    <div id=\"wrapper\">");

            writer.println("    <h2> Reporte de errores </h2>");
            writer.println("    <table id=\"keywords\" cellspacing=\"0\" cellpadding=\"0\">");
            writer.println("        <thead>");
            writer.println("        <tr>");
            
            writer.println("            <th><span>#</span></th>");
            writer.println("            <th><span>Tipo</span></th>");
            writer.println("            <th><span>Descripcion</span></th>");
            writer.println("            <th><span>Lexema</span></th>");
            writer.println("            <th><span>Fila</span></th>");
            writer.println("            <th><span>Columna</span></th>");

            writer.println("        </tr>");
            writer.println("        </thead>");
            writer.println("        <tbody>");
            
            for (TError error : lexico) { 
                writer.println("            <tr>");
                writer.println("                <td>"+contador+"</td>");
                writer.println("                <td>Lexico</td>");
                writer.println("                <td>"+error.descripcion+"</td>");  
                writer.println("                <td>"+error.lexema+"</td>");
                writer.println("                <td>"+error.linea+"</td>");
                writer.println("                <td>"+error.columna+"</td>"); 
                writer.println("            </tr>");
                contador++;
            }
            
            for (TError error : sintactico) { 
                writer.println("            <tr>");
                writer.println("                <td>"+contador+"</td>");
                writer.println("                <td>Sintáctico</td>");
                writer.println("                <td>"+error.descripcion+"</td>");  
                writer.println("                <td>"+error.lexema+"</td>");
                writer.println("                <td>"+error.linea+"</td>");
                writer.println("                <td>"+error.columna+"</td>"); 
                writer.println("            </tr>");
                contador++;
            }
            
            
            
            
            writer.println("        </tbody>");
            writer.println("    </table>");
            
      
            writer.println("</BODY>");
            writer.println("</HTML>");
            writer.close();
            
            }catch (Exception e) {
            e.printStackTrace();
            }

    }
}