package wumpus;

import java.io.IOException;

public class Wumpus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        IniciaCaverna inicia = new IniciaCaverna(15,15,40);
        inicia.comeca();
        
    }
    
}
