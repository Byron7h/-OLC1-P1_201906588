package analizadores;
public class TError {

    public String tipo, lexema, descripcion;
    public int linea, columna;

    public TError(String tipo, String lexema, String descripcion, int linea, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.descripcion = descripcion;
        this.linea = linea+1;
        this.columna = columna+1;
    }

    public String show() { //retorna una cadena de informacion 
                            // Acá ya podemos colocarle código html, 
        String data = "";
        data += "\ntipo:" + tipo;
        data += "\nlexema:" + lexema;
        data += "\ndescripcion:" + descripcion;
        data += "\nlinea:" + String.valueOf(linea);
        data += "\ncolumna:" + String.valueOf(columna);
        return data;
    }

}
