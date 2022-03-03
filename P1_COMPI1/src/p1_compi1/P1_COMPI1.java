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
        }
    }
    
}