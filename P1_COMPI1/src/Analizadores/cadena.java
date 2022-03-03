
package analizadores;

public class cadena {
        String id, cadena;
    
    public cadena (String id, String cadena) {
        this.id = id; // id de la expresion regular con la que se quiere valuar la cadena
        this.cadena = cadena; // cadena
    }

    public String show() { //retorna una cadena de informacion 
                            // Acá ya podemos colocarle código html, 
        String data = "";
        data += "\nid:" + id;
        data += "\ncadena:" + cadena;
        return data;
    }  
    
}
