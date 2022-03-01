package analizadores;
import java_cup.runtime.*; 
import java.util.LinkedList;

%% 
%{
    public static LinkedList<TError> errores = new LinkedList<TError>(); 
%}


%public 
%class Analizador_Lexico  
%cupsym Simbolos 
%cup 
%char
%column
%full
%ignorecase 
%line 
%unicode

letra = [a-zA-Z]
id = {letra}+

%%

<YYINITIAL> "," {
                    System.out.println("Reconocio token:<coma> lexema:"+yytext());
                    return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
                }
<YYINITIAL> {id} {
                    System.out.println("Reconocio token:<id> lexema:"+yytext());
                    return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }

[ \t\r\n\f]      { /* Espacios en blanco, tabulaciones, y retorno de carro se ignoran (el espacio antes del \t, se deja) */ }
            

.                {  
                    /*tipo, lexema, descripcion, fila, columna; lo agtegamos a la lista de errores*/
                    TError tmp= new TError("Lexico", yytext(),"Caracter no reconocido", yyline, yycolumn );
                    errores.add(tmp);           
  }

