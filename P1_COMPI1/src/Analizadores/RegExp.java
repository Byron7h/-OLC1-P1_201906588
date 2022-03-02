
package analizadores;

public class RegExp {
    
    String id, expresion;
    
    public RegExp(String id, String expresion){
        this.id= id;
        this.expresion = expresion;
    }
    
    public String show() { //retorna una cadena de informacion 
                            // Acá ya podemos colocarle código html, 
        String data = "";
        data += "\nid:" + id;
        data += "\nExpresión:" + expresion;
        return data;
    }
    
    
}
