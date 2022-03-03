
package analizadores;

import java.util.LinkedList;
public class RegExp {
    
    String id;
    public LinkedList <Token> expresion ;
    
    public RegExp(String id, LinkedList <Token> expresion){
        this.id= id;
        this.expresion = expresion;
    }
    /*
    public String show() { //retorna una cadena de informacion 
                            // Acá ya podemos colocarle código html, 
        String data = "";
        data += "\nid:" + id;
        data += "\nExpresión:" + expresion;
        return data;
    }
    
    */
}
