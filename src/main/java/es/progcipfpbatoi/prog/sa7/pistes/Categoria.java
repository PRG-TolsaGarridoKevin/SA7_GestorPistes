package es.progcipfpbatoi.prog.sa7.pistes;
public enum Categoria {
    GOVERN, TECNOLOGIA, MISTERI, CORRUPCIO;
    
    
    //pasar de string a categoria //2 switch
   
    /*public static Categoria fromString(String string){
        
    };*/

    @Override
    public String toString() {
        return "Categoria = " + name();
    }

   
    
}
