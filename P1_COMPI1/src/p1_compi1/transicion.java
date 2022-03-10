package p1_compi1;

public class transicion {
    
    String simbolo;
    Estado apuntado;
    
    public transicion(String simbolo, Estado apuntado){
        this.simbolo = simbolo;
        this.apuntado = apuntado;
    }
    
    public String get_simbolo(){
        return simbolo;
    }
    
    public int get_apuntado(){
        return apuntado.get_id();
    }
    
    public Estado get_estado_apuntado(){
        return apuntado;
    }
}
