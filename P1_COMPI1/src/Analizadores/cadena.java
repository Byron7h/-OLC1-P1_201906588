
package analizadores;

public class cadena {
        String id, cadena;
        String valida = "No aceptada";
    
    public cadena (String id, String cadena) {
        this.id = id; // id de la expresion regular con la que se quiere valuar la cadena
        this.cadena = cadena; // cadena
    }
    
    public String get_valida(){
        return valida;   
    }
    
    public void cadena_aceptada(){
        this.valida = "Aceptada";
    }
    

    public String show() { //retorna una cadena de informacion 
                            // Acá ya podemos colocarle código html, 
        String data = "";
        data += "\nid:" + id;
        data += "\ncadena:" + cadena;
        return data;
    }  
    
}
