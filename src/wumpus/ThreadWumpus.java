package wumpus;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadWumpus implements Runnable{
    int totalLinhas;
    int totalColunas;
    int tempo;
    String[][] caverna;

    public ThreadWumpus(int totalLinhas, int totalColunas, int tempo, String[][] caverna) {
        this.totalLinhas = totalLinhas;
        this.totalColunas = totalColunas;
        this.tempo = tempo;
        this.caverna = caverna;
        Thread t = new Thread(this);
        t.start();
    }
    
    @Override
  public void run(){
     System.out.println("WUMPUS----------------------------------");
     for(int i = 0; i < totalLinhas; i++){
         for(int j = 0; j < totalColunas; j++){
             System.out.print(caverna[i][j] + " | ");
         }
         System.out.println("");       
     }
  } 
}
