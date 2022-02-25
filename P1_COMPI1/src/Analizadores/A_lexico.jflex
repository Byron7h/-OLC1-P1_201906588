
// Acá vamos a poner sobre que reglas quiero analizar
// la mayoria de estos parámetros se repiten de poyecto a proyecto
// en algunos puede que cambie el ignorecase, apra más info de estos ver la documentacion



package Analizadores;
import java_cup.runtime.+; // lebreía que vamos a descargar

%% //divisor de partes del doc --------------------------------------------------
%public // es publico
%class Analizador_Lexico  //así se va a llamr la clase a la que se va a retornar, es la clase que va a generar
%cupsym Simbolos  // quiero que la clase que reornes se llame Simbolos
%cup    // para enlazarlo con el otro archivo
%char
%column    // lleva conteo de columnas
%full
%ignorecase  // este es para decirle que ignore si es mayuscula o minuscula
%line      // lleva conteo de filas
%unicode
letra = [a-zA-Z]
id = {letra}+

// Expresiones regulares
// usamos las llaves para hacer referencia a otras expresiones regulares y corchetes para conjuntos

letra = [a-zA-Z] //Encerrada en corchetes --> conjunto
id = {letra}+





//aquí estarian los estados


%%

// Nuestro estado inicial es <YYINITIAL> 
// Simbolos que vamos a reconocer
// Va a estar entre comillas el símboloq ue quiero reconocer
// si está en el estado inical, y reconoce lo que está entre comillas, que haga lo siguiente, esto último entre llaves
//       con código en java
//yytex es una palabra reservada del analizador lexico para referenciar al lexema(lo que le pedimos reconocer entre comillas)
//      así es como jalo el lexema
//Simbolos es el que dijimos arriba  Simbolos.El_nombre_que_queremos_que_se_reconozca
//      también le decimos que nos extarga la linea y la colimna con las palabras
//      recervadas yycolumn y yyline; además de yytex, que es el lexema



<YYINITIAL> "," {
System.out.println("Reconocio token:<coma> lexema:"+yytext());
return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
}
<YYINITIAL> {id} {
System.out.println("Reconocio token:<id> lexema:"+yytext());
return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
}


[\t\r\n\f] { /* Espacios en blanco, tabulaciones, y retorno de carro se ignoran */ }
            // Para este caso la instruccion que le damos es que nos haga un comentario en java, que es como si no hiciera nada al encontrarlos 

  // El punto en jflex es cualquier otra cosa, cualquer otra cosa que no sea 
    // lo que definimos, es un error llexico


. { System.out.println("Error Lexico : "+yytext()+
   "Linea"+yyline+" Columna "+yycolumn);
}