
package analizadores;

public class Token {

    public String tipo, lexema;
    int linea, columna;
    

    public Token(String tipo, String lexema, int linea, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        
        if ( "cadena".equals(tipo) ){         
            int tamano = lexema.length();
            String nueva = lexema.substring(1,tamano-1);
            this.lexema = "'"+nueva+"'";
        }
        
    }

    public Token(String tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
        
    }
    
    public String show() { //retorna una cadena de informacion 
                            // Acá ya podemos colocarle código html, para los reportes
        String data = "";
        data += "\ntipo:" + tipo;
        data += "\nlexema:" + lexema;
        data += "\nlinea:" + String.valueOf(linea);
        data += "\ncolumna:" + String.valueOf(columna);
        return data;
    }
    
}
