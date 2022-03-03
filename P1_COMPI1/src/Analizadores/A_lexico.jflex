package analizadores;
import java_cup.runtime.*; 
import java.util.LinkedList;

%% 
%{
    public static LinkedList<TError> errores = new LinkedList<TError>();
    public static LinkedList<Token> tokens = new LinkedList<Token>(); 
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

palabra_reservada = "CONJ"
delimitadores = ["%%"]+
comentario_unilinea = ["//"]+[^\n]*[\n]
comentario_multilinea = "<!"[^"!>"]*"!>"
cadena = [\"][^\n\"]*[\"] | [\'][^\n\']*[\']
asignacion = "->"
conjunto_1 = ({letra}"~"{letra}|{numero}"~"{numero})
conjunto_2 = ({numero}(","{numero})*|{letra}(","{letra})*)
conjunto_3 = [^\n\"]"~"[^\n\"]
id = {letra}({letra}|_|{numero})*


%%
<YYINITIAL> ","     {
                    System.out.println("Reconocio token:<coma> lexema:"+yytext());
                    return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
                    }
<YYINITIAL> ";"     {
                    System.out.println("Reconocio token:<punto_y_coma> lexema:"+yytext());
                    Token tmp= new Token("punto_y_coma", yytext().toString(), yyline, yycolumn );
                    tokens.add(tmp); 
                    return new Symbol(Simbolos.punto_y_coma, yycolumn, yyline, yytext());

                    }
<YYINITIAL> "{"     {
                    System.out.println("Reconocio token:<llave_a> lexema:"+yytext());
                    Token tmp= new Token("llave_a", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    return new Symbol(Simbolos.llave_a, yycolumn, yyline, yytext());
                    
                    }
<YYINITIAL> "}"     {
                    System.out.println("Reconocio token:<llave_c> lexema:"+yytext());
                    Token tmp= new Token("llave_c", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    return new Symbol(Simbolos.llave_c, yycolumn, yyline, yytext());
                    
                    }
<YYINITIAL> "."     {
                    System.out.println("Reconocio token:<punto> lexema:"+yytext());
                    Token tmp= new Token("punto", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    return new Symbol(Simbolos.punto, yycolumn, yyline, yytext());
                    
                    }
<YYINITIAL> "*"     {
                    System.out.println("Reconocio token:<asterisco> lexema:"+yytext());
                    Token tmp= new Token("asterisco", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    return new Symbol(Simbolos.asterisco, yycolumn, yyline, yytext());

                    }

<YYINITIAL> ":"     {
                    System.out.println("Reconocio token:<dos_puntos> lexema:"+yytext());
                    return new Symbol(Simbolos.dos_puntos, yycolumn, yyline, yytext());
                    }

<YYINITIAL> "|"     {
                    System.out.println("Reconocio token:<o_logico> lexema:"+yytext());
                    Token tmp= new Token("o_logico", yytext(), yyline, yycolumn );
                    tokens.add(tmp);
                    return new Symbol(Simbolos.o_logico, yycolumn, yyline, yytext());
 
                    }

<YYINITIAL> "+"     {
                    System.out.println("Reconocio token:<mas> lexema:"+yytext());
                    Token tmp= new Token("mas", yytext(), yyline, yycolumn );
                    tokens.add(tmp);
                    return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());
 
                    }

<YYINITIAL> "?"     {
                    System.out.println("Reconocio token:<duda> lexema:"+yytext());
                    Token tmp= new Token("duda", yytext(), yyline, yycolumn );
                    tokens.add(tmp);
                    return new Symbol(Simbolos.duda, yycolumn, yyline, yytext());
 
                    }


<YYINITIAL> {palabra_reservada}    {
                    System.out.println("Reconocio token:<palabra_reservada> lexema:"+yytext());
                    return new Symbol(Simbolos.palabra_reservada, yycolumn, yyline, yytext());
                    }

<YYINITIAL> {delimitadores}    {
                    System.out.println("Reconocio token:<delimitadores> lexema:"+yytext());
                    return new Symbol(Simbolos.delimitadores, yycolumn, yyline, yytext());
                    }

<YYINITIAL> {comentario_unilinea}    {
                    System.out.println("Reconocio token:<comentario_unilinea> lexema:"+yytext());
                    return new Symbol(Simbolos.comentario_unilinea, yycolumn, yyline, yytext());
                    }

<YYINITIAL> {comentario_multilinea}    {
                    System.out.println("Reconocio token:<comentario_multilinea> lexema:"+yytext());
                    return new Symbol(Simbolos.comentario_multilinea, yycolumn, yyline, yytext());
                    }

<YYINITIAL> {cadena}    {
                    System.out.println("Reconocio token:<cadena> lexema:"+yytext());
                    Token tmp= new Token("cadena", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    return new Symbol(Simbolos.cadena, yycolumn, yyline, yytext());

                    }

<YYINITIAL> {asignacion}    {
                    System.out.println("Reconocio token:<asignacion> lexema:"+yytext());
                    Token tmp = new Token("asignacion", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    return new Symbol(Simbolos.asignacion, yycolumn, yyline, yytext());

                    }

<YYINITIAL> {conjunto_1}    {
                    System.out.println("Reconocio token:<conjunto1> lexema:"+yytext());
                    return new Symbol(Simbolos.conjunto, yycolumn, yyline, yytext());
                    }


<YYINITIAL> {conjunto_2}    {
                    System.out.println("Reconocio token:<conjunto2> lexema:"+yytext());
                    return new Symbol(Simbolos.conjunto, yycolumn, yyline, yytext());
                    }

<YYINITIAL> {conjunto_3}    {
                    System.out.println("Reconocio token:<conjunto3> lexema:"+yytext()); 
                    return new Symbol(Simbolos.conjunto, yycolumn, yyline, yytext());

                    }


<YYINITIAL> {id}    {
                    System.out.println("Reconocio token:<id> lexema:"+yytext());
                    Token tmp = new Token("id", yytext(), yyline, yycolumn );
                    tokens.add(tmp); 
                    return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                    }














[ \t\r\n\f]      { /* Espacios en blanco, tabulaciones, y retorno de carro se ignoran (el espacio antes del \t, se deja) */ }
            

.                {  
                     System.out.println("Reconocio token:<error> lexema:"+yytext());
                    /*tipo, lexema, descripcion, fila, columna; lo agtegamos a la lista de errores*/
                    TError tmp= new TError("Lexico", yytext(),"Caracter no reconocido", yyline, yycolumn );
                    errores.add(tmp);           
}
