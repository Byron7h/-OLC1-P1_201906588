package p1_compi1;
import analizadores.Analizador_Lexico;
import analizadores.Analizador_sintactico;

import java.io.BufferedReader;
import java.io.FileReader;

public class P1_COMPI1 {

    public static void main(String[] args) {
     
        try {
            Analizador_Lexico lexico = new Analizador_Lexico(
            new BufferedReader(new FileReader("./Entrada.txt"))
            );
            Analizador_sintactico sintactico = new Analizador_sintactico(lexico);
            sintactico.parse(); //funcion que nos lee
        } catch (Exception e) {
        }
    }
    
}
