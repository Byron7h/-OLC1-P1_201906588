
package analizadores;

public class Token {
    
    String tipo, lexema;
    int linea, columna;
    

    public Token(String tipo, String lexema, int linea, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea = linea+1;
        this.columna = columna+1;
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
