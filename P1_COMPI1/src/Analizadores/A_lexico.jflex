package analizadores;
import java_cup.runtime.*; 
import java.util.LinkedList;

%% 
%{
    public static LinkedList<TError> errores = new LinkedList<TError>(); 
    public static LinkedList<Token> tokens = new LinkedList<TError>(); 
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

// Acá vamos a poner todos nuestras Exp_Reg
// Los operadores sueltos los colocamos directamente en los estados

letra = [a-zA-Z]
numero = [0-9]

palabra_reservada = CONJ
delimitadores = ["%%"]+
comentario_unilinea = ["//"]+[^\n]*[\n]
comentario_multilinea = "<!"[^"!>"]*"!>"
cadena = [\"][^\n\"]*[\"] | [\'][^\n\']*[\']
asignacion = "->"
conjunto_1 = {letra}"~"{letra}|{numero}"~"{numero}
conjunto_2 = {numero}[","[numero]]*|{letra}[","[letra]]*
conjunto_3 = [^\n\"]"~"[^\n\"]
id = {letra}[letra|_|numero]*


%%

<YYINITIAL> ";"{    Token tmp= new Token("punto_y_coma", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                }
            ":"{    Token tmp= new Token("dos_puntos", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                }
            "{"{    Token tmp= new Token("llave_a", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                }
            "}"{     Token tmp= new Token("llave_c", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                }
            "."{     Token tmp= new Token("punto", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                }
            "*"{     Token tmp= new Token("asterisco", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                }


<YYINITIAL> {palabra_reservada} {
                    Token tmp= new Token("palabra_reservada", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }

{delimitadores} {
                    Token tmp= new Token("delimitadores", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }
{comentario_unilinea} {
                    Token tmp= new Token("comentario_unilinea", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }
{cadena} {
                    Token tmp= new Token("cadena", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }
{asignacion} {
                    Token tmp= new Token("asignacion", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }
{conjunto_1} {
                    Token tmp= new Token("conjunto", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }
{conjunto_2} {
                    Token tmp= new Token("conjunto", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }
{conjunto_3} {
                    Token tmp= new Token("conjunto", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }
{id} {
                    Token tmp= new Token("id", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    //System.out.println("Reconocio token:<id> lexema:"+yytext());
                    //return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                }


[ \t\r\n\f]      { /* Espacios en blanco, tabulaciones, y retorno de carro se ignoran (el espacio antes del \t, se deja) */ }
            

.                {  
                    /*tipo, lexema, descripcion, fila, columna; lo agtegamos a la lista de errores*/
                    TError tmp= new TError("Lexico", yytext(),"Caracter no reconocido", yyline, yycolumn );
                    errores.add(tmp);           
  }


