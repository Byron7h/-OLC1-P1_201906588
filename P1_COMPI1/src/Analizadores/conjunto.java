package analizadores;

public class conjunto {
    
    String tipo, id, contenido;
    
    public conjunto (String tipo, String id, String contenido) {
        this.tipo = tipo;
        this.id = id;
        this.contenido = contenido;
    }

    public String show() { //retorna una cadena de informacion 
                            // Acá ya podemos colocarle código html, 
        String data = "";
        data += "\ntipo:" + tipo;
        data += "\nid:" + id;
        data += "\ncontenido:" + contenido;
        return data;
    }  
}
