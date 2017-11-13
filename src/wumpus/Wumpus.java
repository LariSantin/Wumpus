package wumpus;

import java.io.IOException;


public class Wumpus { 
    
    public static void main(String[] args) throws IOException {
        
        IniciaCaverna inicia= new IniciaCaverna(10,10,20);
       
        inicia.ComecaJogo();
    }
}
