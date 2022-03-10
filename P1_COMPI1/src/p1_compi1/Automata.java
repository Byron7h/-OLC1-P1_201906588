package p1_compi1;


public class Automata { // objeto con el nombre yla tabla de estados de una expresion regular
    
        String id;
        Tabla_siguientes tabla;
        Tabla_estados tabla_2;
        
        public Automata(String id,Tabla_siguientes tabla, Tabla_estados tabla_2){           
            this.id = id;
            this.tabla = tabla;
            this.tabla_2 = tabla_2;

        }
        
        public String get_id(){
            return id;
        };
        
        public Tabla_siguientes get_tabla_siguientes(){
            return tabla;
        };
    
        public Tabla_estados get_tabla_estados(){
            return tabla_2;
        };
    
}
