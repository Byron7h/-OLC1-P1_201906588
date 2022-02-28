package p1_compi1;
import analizadores.Analizador_Lexico;
import analizadores.Analizador_sintactico;
import analizadores.TError;
import java.io.BufferedReader;
import java.io.FileReader;

public class P1_COMPI1 {

    public static void main(String[] args) {
     
        try {
            Analizador_Lexico lexico = new Analizador_Lexico(
            new BufferedReader(new FileReader("./Prueba.exp"))
            );
            
            for (Token tok : Analizador_Lexico.tokens) {
                System.out.println(tok.show());
            }
            
            //Analizador_sintactico sintactico = new Analizador_sintactico(lexico);
            //sintactico.parse(); //funcion que nos lee, acá se van a guardar los datos
            
            //Mensaje en consola con los errores
            System.out.println("\n\n***Reporte de errores encontrados ");
            // lo va a traer de nuestro linked list que creamos en el analizadir        
            for (TError errore : Analizador_Lexico.errores) {
                System.out.println(errore.show());
            }
            //for (TError errore : sintactico.errores) {
            //    System.out.println(errore.show());
            //}
            
        } catch (Exception e) {
        }
    }
    
}
