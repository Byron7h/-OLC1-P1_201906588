
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizadores;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Analizador_sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Simbolos.class;
}

  /** Default constructor. */
  @Deprecated
  public Analizador_sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Analizador_sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Analizador_sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\032\000\002\002\004\000\002\002\005\000\002\002" +
    "\011\000\002\002\007\000\002\002\004\000\002\002\007" +
    "\000\002\002\004\000\002\002\004\000\002\002\006\000" +
    "\002\002\003\000\002\002\003\000\002\002\003\000\002" +
    "\003\005\000\002\003\005\000\002\003\004\000\002\003" +
    "\004\000\002\003\004\000\002\003\005\000\002\003\003" +
    "\000\002\005\003\000\002\005\003\000\002\004\005\000" +
    "\002\004\003\000\002\006\003\000\002\006\003\000\002" +
    "\006\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\064\000\016\004\010\005\012\006\005\007\007\012" +
    "\011\015\004\001\002\000\016\004\010\005\012\006\005" +
    "\007\007\012\011\015\004\001\002\000\022\002\ufff8\004" +
    "\010\005\012\006\005\007\007\012\011\015\004\016\ufff8" +
    "\001\002\000\004\002\063\001\002\000\022\002\ufff7\004" +
    "\010\005\012\006\005\007\007\012\011\015\004\016\ufff7" +
    "\001\002\000\004\020\044\001\002\000\006\011\015\020" +
    "\014\001\002\000\022\002\ufff6\004\010\005\012\006\005" +
    "\007\007\012\011\015\004\016\ufff6\001\002\000\006\002" +
    "\ufffd\016\ufffd\001\002\000\004\010\041\001\002\000\020" +
    "\010\020\015\024\017\017\021\021\022\016\023\022\024" +
    "\023\001\002\000\020\010\020\015\024\017\017\021\021" +
    "\022\016\023\022\024\023\001\002\000\020\010\020\015" +
    "\024\017\017\021\021\022\016\023\022\024\023\001\002" +
    "\000\022\010\uffef\014\uffef\015\uffef\017\uffef\021\uffef\022" +
    "\uffef\023\uffef\024\uffef\001\002\000\020\010\020\015\024" +
    "\017\017\021\021\022\016\023\022\024\023\001\002\000" +
    "\020\010\020\015\024\017\017\021\021\022\016\023\022" +
    "\024\023\001\002\000\020\010\020\015\024\017\017\021" +
    "\021\022\016\023\022\024\023\001\002\000\004\012\030" +
    "\001\002\000\004\014\026\001\002\000\016\004\010\005" +
    "\012\006\005\007\007\012\011\015\004\001\002\000\006" +
    "\002\ufffe\016\ufffe\001\002\000\004\016\031\001\002\000" +
    "\022\010\ufff0\014\ufff0\015\ufff0\017\ufff0\021\ufff0\022\ufff0" +
    "\023\ufff0\024\ufff0\001\002\000\022\010\ufff1\014\ufff1\015" +
    "\ufff1\017\ufff1\021\ufff1\022\ufff1\023\ufff1\024\ufff1\001\002" +
    "\000\022\010\ufff2\014\ufff2\015\ufff2\017\ufff2\021\ufff2\022" +
    "\ufff2\023\ufff2\024\ufff2\001\002\000\022\010\ufff3\014\ufff3" +
    "\015\ufff3\017\ufff3\021\ufff3\022\ufff3\023\ufff3\024\ufff3\001" +
    "\002\000\020\010\020\015\024\017\017\021\021\022\016" +
    "\023\022\024\023\001\002\000\022\010\ufff5\014\ufff5\015" +
    "\ufff5\017\ufff5\021\ufff5\022\ufff5\023\ufff5\024\ufff5\001\002" +
    "\000\020\010\020\015\024\017\017\021\021\022\016\023" +
    "\022\024\023\001\002\000\022\010\ufff4\014\ufff4\015\ufff4" +
    "\017\ufff4\021\ufff4\022\ufff4\023\ufff4\024\ufff4\001\002\000" +
    "\004\014\042\001\002\000\022\002\ufff9\004\010\005\012" +
    "\006\005\007\007\012\011\015\004\016\ufff9\001\002\000" +
    "\006\002\ufffc\016\ufffc\001\002\000\004\012\045\001\002" +
    "\000\004\011\046\001\002\000\012\010\053\013\052\026" +
    "\051\027\047\001\002\000\006\014\uffe8\025\uffe8\001\002" +
    "\000\006\014\uffed\025\060\001\002\000\006\014\uffe9\025" +
    "\uffe9\001\002\000\004\014\uffee\001\002\000\006\014\uffea" +
    "\025\uffea\001\002\000\006\014\uffeb\025\uffeb\001\002\000" +
    "\004\014\056\001\002\000\016\004\010\005\012\006\005" +
    "\007\007\012\011\015\004\001\002\000\006\002\uffff\016" +
    "\uffff\001\002\000\010\010\053\026\051\027\047\001\002" +
    "\000\006\014\uffec\025\uffec\001\002\000\006\002\ufffa\016" +
    "\ufffa\001\002\000\004\002\001\001\002\000\006\002\ufffb" +
    "\016\ufffb\001\002\000\004\016\066\001\002\000\006\002" +
    "\000\016\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\064\000\004\002\005\001\001\000\004\002\064\001" +
    "\001\000\004\002\063\001\001\000\002\001\001\000\004" +
    "\002\061\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\002\012\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\003\024\001\001\000\004\003\036\001\001\000" +
    "\004\003\034\001\001\000\002\001\001\000\004\003\033" +
    "\001\001\000\004\003\032\001\001\000\004\003\031\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\002\026" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\003\035\001\001\000\002\001\001\000\004\003" +
    "\037\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\002\042\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\004\047\005\054\006\053\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\002\056\001\001\000\002\001\001\000" +
    "\004\006\060\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Analizador_sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Analizador_sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Analizador_sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}





    
    // listas que nos van a servir
    public static LinkedList<conjunto> conjuntos = new LinkedList<conjunto>(); 
    public static LinkedList<RegExp> expresiones = new LinkedList<RegExp>(); 
    public static LinkedList<cadena> cadenas = new LinkedList<cadena>(); 
    public static LinkedList<TError> errores = new LinkedList<TError>();

    

    // esta función nata de la herramienta, manda a llamar todos los errores sintacticos
    // necesita un objeto simbolo
   
    public void syntax_error(Symbol s)
    {        

        //obtenemos los valores de los parámetros del objeto s
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
      
        System.out.println("!!!!!!! Error Sintactico Recuperado !!!!!!!");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);

        // error de tipo sintáctico
        TError tmp = new TError("Sintactico",lexema,"Caracter no esperado",fila,columna);
        errores.add(tmp);
        
    }


    //Metodo al que se llama en el momento en que ya no es posible una recuperacion de errores, se reporta y termina el análisis
    // en caso de que se pueda recurer este no saldrá
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        System.out.println("!!!!!!! Error Sintactico, Panic Mode !!!!!!! ");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);
        
        TError tmp = new TError("Sintactico",lexema, "Caracter no esperado",fila,columna);
        errores.add(tmp);   
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Analizador_sintactico$actions {
  private final Analizador_sintactico parser;

  /** Constructor */
  CUP$Analizador_sintactico$actions(Analizador_sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Analizador_sintactico$do_action_part00000000(
    int                        CUP$Analizador_sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Analizador_sintactico$parser,
    java.util.Stack            CUP$Analizador_sintactico$stack,
    int                        CUP$Analizador_sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Analizador_sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Analizador_sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Analizador_sintactico$parser.done_parsing();
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= llave_a INICIO llave_c 
            {
              Object RESULT =null;
		System.out.println("Fin de analisis de entrada");
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INICIO ::= palabra_reservada dos_puntos id asignacion C punto_y_coma INICIO 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).value;
		int kleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).left;
		int kright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).right;
		Object k = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).value;
		
                                        conjunto nuevo = new conjunto("cadena", a.toString(), k.toString());
                                        conjuntos.add(nuevo);
                                        
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-6)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INICIO ::= id asignacion E punto_y_coma INICIO 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-3)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).value;
		

                                        // tenemos una lista con los tokens guardados, vamos a intentar sacar al exp reg sabiendo el
                                         //   número de fila y columna del token anterior y posterior a esta
                                        
                                        // acá vamos a extraer los valores de las variables que nos genera el .cup (Archivo Analizador_sintactico. java linea 291 aprox)  
 
                                        int fila = dright;
                                        int col_anterior = dleft;
                                        int col_posterior = eleft;
                                        LinkedList<Token> expre = new LinkedList<Token>(); // Lista te los tokens que conforman una expresion regular

                                        
                                        for (Token tok : Analizador_Lexico.tokens) {
                                            if (tok.linea == fila && tok.columna>col_anterior && tok.columna<col_posterior){
                                                expre.add(tok);
                                            }
                                        }
                                        RegExp nuevo = new RegExp(c.toString(), expre);
                                        expresiones.add(nuevo);
                                            


                                        
                                        //System.out.println(d.value());
                                        //expre = new LinkedList<String>();
                                        //RegExp nuevo = new RegExp(c.toString(), d.toString());
                                        //expresiones.add(nuevo);
                                        
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INICIO ::= delimitadores INICIO 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INICIO ::= id dos_puntos cadena punto_y_coma INICIO 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).value;
		
                                        cadena nuevo = new cadena(c.toString(), d.toString());
                                        cadenas.add(nuevo);
                                        
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // INICIO ::= comentario_unilinea INICIO 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // INICIO ::= comentario_multilinea INICIO 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // INICIO ::= id dos_puntos cadena punto_y_coma 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-3)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-3)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-3)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).value;
		
                                        cadena nuevo = new cadena(c.toString(), d.toString());
                                        cadenas.add(nuevo);
                                        
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // INICIO ::= comentario_unilinea 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // INICIO ::= comentario_multilinea 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // INICIO ::= delimitadores 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // E ::= punto E E 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // E ::= o_logico E E 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // E ::= asterisco E 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // E ::= mas E 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // E ::= duda E 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // E ::= llave_a id llave_c 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // E ::= cadena 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // C ::= conjunto 
            {
              Object RESULT =null;
		int jleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).left;
		int jright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).right;
		Object j = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.peek()).value;
		  RESULT = j ;  
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("C",3, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // C ::= A 
            {
              Object RESULT =null;
		int hleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).left;
		int hright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).right;
		Object h = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.peek()).value;
		  RESULT = h ; 
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("C",3, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // A ::= A coma BLOQUE 
            {
              Object RESULT =null;
		int hleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).left;
		int hright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).right;
		Object h = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).right;
		Object f = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).value;
		int qleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).left;
		int qright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).right;
		Object q = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.peek()).value;
		  RESULT = h.toString()+f.toString()+q.toString() ;
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // A ::= BLOQUE 
            {
              Object RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.peek()).value;
		  RESULT = s ; 
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("A",2, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // BLOQUE ::= cadena 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.peek()).value;
		  RESULT = c;  
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("BLOQUE",4, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // BLOQUE ::= letra 
            {
              Object RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).right;
		Object l = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.peek()).value;
		  RESULT = l;  
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("BLOQUE",4, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // BLOQUE ::= digito 
            {
              Object RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.peek()).value;
		  RESULT = d;  
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("BLOQUE",4, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Analizador_sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Analizador_sintactico$do_action(
    int                        CUP$Analizador_sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Analizador_sintactico$parser,
    java.util.Stack            CUP$Analizador_sintactico$stack,
    int                        CUP$Analizador_sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Analizador_sintactico$do_action_part00000000(
                               CUP$Analizador_sintactico$act_num,
                               CUP$Analizador_sintactico$parser,
                               CUP$Analizador_sintactico$stack,
                               CUP$Analizador_sintactico$top);
    }
}

}
