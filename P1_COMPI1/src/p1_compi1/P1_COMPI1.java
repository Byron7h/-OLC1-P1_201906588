package p1_compi1;

import analizadores.Analizador_Lexico;
import analizadores.Analizador_sintactico;
import analizadores.TError;
import analizadores.Token;
import analizadores.conjunto;
import analizadores.RegExp;
import analizadores.cadena;
import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;

public class P1_COMPI1 {

    public static void main(String[] args) {
     
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
        
        nuevo = new Token("mas","+",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("llave_a","{",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("id","digito",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("llave_c","}",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("punto",".",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("cadena","'.'",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("mas","+",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("llave_a","{",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("id","digito",1,1);
        expresion.add(nuevo);
        
        nuevo = new Token("llave_c","}",1,1);
        expresion.add(nuevo);
   

        arbol(expresion);
        
        
        
        
    }
    public static void arbol(LinkedList<Token> expre){ 
        // • Paso 1 Agregando la concatenación al estado de aceptación 
        
        Token nuevo = new Token("punto",".");
        expre.addFirst(nuevo);
        
        nuevo = new Token("aceptacion","#");
        expre.addLast(nuevo);
        
        LinkedList<Token> aux = new LinkedList<>();

        imprimir_lista(expre);
        
        // • Paso 2 Quitando los parentesis inneccesarios
        for(Token tok:expre){
            if ("llave_a".equals(tok.tipo) || "llave_c".equals(tok.tipo) ){  
            }else{
                aux.add(tok);
            }
        }
        
        expre = aux;
        imprimir_lista(expre);
        
        
        //Paso 3 reducciones, y formación del arbol
        

        

            
    }
    
    public static void imprimir_lista(LinkedList<Token> expre){
        System.out.println("Tamaño: "+ expre.size());
        
        for(Token tok:expre){
            System.out.print(tok.lexema);
        }
        System.out.println("");
        
    }
    
    public int cantidad_hijos(Token tok){ // Metodo para saber que cantidad de hijos debe tener el nodo que ceraremos a partir del token
        int cantidad = 2; 
        String tipo = tok.tipo;
        if ("mas".equals(tipo) || "asterisco".equals(tipo) || "duda".equals(tipo)){
            cantidad = 1;
        }
        return cantidad;
    }
    
}