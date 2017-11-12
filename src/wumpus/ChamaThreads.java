package wumpus;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChamaThreads {

    int totalLinhas;
    int totalColunas;
    int MaximoPocos;
    String[][] caverna;

    public ChamaThreads(int totalLinhas, int totalColunas, int MaximoPocos) {
        this.totalLinhas = totalLinhas;
        this.totalColunas = totalColunas;
        this.MaximoPocos = MaximoPocos;
        this.caverna = new String[totalLinhas][totalColunas];
        this.caverna = Inicia();
    }
    
    
    
    public void ChamaT(){ 
           
       ThreadCacador Cacador = new ThreadCacador(totalLinhas,totalColunas, MaximoPocos, caverna, 300);
       try { 
           Thread.sleep(400);
       } catch (InterruptedException ex) {
           Logger.getLogger(ThreadCacador.class.getName()).log(Level.SEVERE, null, ex);
       }
       ThreadWumpus Wumpus = new ThreadWumpus(totalLinhas,totalColunas,500,caverna);
        try { 
           Thread.sleep(500);
       } catch (InterruptedException ex) {
           Logger.getLogger(ThreadCacador.class.getName()).log(Level.SEVERE, null, ex);
       }
     
    }

   public String[][] Inicia(){
        Cacador cacador = new Cacador();
        int numeroPocos = 0;
        int linhaPocos = 0, colunaPocos = 0,linhaOuro = 0, colunaOuro = 0,linhaWumpus = 0, colunaWumpus = 0;
        boolean ouro = true, wumpus = true;
       
        Random gerador = new Random();
	  
        numeroPocos = 1 + gerador.nextInt(MaximoPocos);
        System.out.println("numero: " + numeroPocos);
        System.out.println("numeroLinhas " + totalLinhas);
        System.out.println("numeroLinhas " + totalColunas);
        for(int i = 0; i < totalLinhas; i++) //inicializa matriz
        {
            for(int j = 0; j < totalColunas; j++)
            {
                //System.out.println("[" + i + "] ["+ j +"]");
                caverna[i][j] = "*";
            }
        }
       
        for(int i = 0; i < totalLinhas; i++)
        {
            for(int j = 0; j < totalColunas; j++)
            {
               if(numeroPocos != 0)
                {
                    linhaPocos = gerador.nextInt(totalLinhas);
                    colunaPocos = gerador.nextInt(totalColunas);
                    if(!"W".equals(caverna[linhaPocos][colunaPocos]) && (linhaPocos != 3 && colunaPocos != 0) && !"P".equals(caverna[linhaPocos][colunaPocos]) && !"O".equals(caverna[linhaPocos][colunaPocos]))
                    {
                     // System.out.println("linha: " + linhaPocos + " colunaPocos: " + colunaPocos);
                      caverna[linhaPocos][colunaPocos]= "P";
                      numeroPocos--;                      
                    }
                }          
               
            }
        }
        for(int i = 0; i < totalLinhas; i++)
        {
            for(int j = 0; j < totalColunas; j++)
            {
              linhaOuro = gerador.nextInt(totalLinhas);
              colunaOuro = gerador.nextInt(totalColunas);

               if(ouro == true)
               {
                if((linhaOuro != 3 && colunaOuro != 0) && !"P".equals(caverna[linhaOuro][colunaOuro]) && !"W".equals(caverna[linhaOuro][colunaOuro]))
                {
                  //System.out.println("linhaOuro: " + linhaOuro + " colunaOuro: " + colunaOuro);
                  caverna[linhaOuro][colunaOuro]= "O";
                  ouro = false;
                }
               }
               linhaWumpus = gerador.nextInt(totalLinhas);
               colunaWumpus = gerador.nextInt(totalColunas);
               if(wumpus == true)
               {
                if((linhaWumpus != 3 && colunaWumpus != 0) && !"P".equals(caverna[linhaWumpus][colunaWumpus]) && !"O".equals(caverna[linhaWumpus][colunaWumpus]))
                {
                  //System.out.println("linhawumpus: " + linhaWumpus + " colunaWumpus: " + colunaWumpus);
                  caverna[linhaWumpus][colunaWumpus]= "W";
                  wumpus = false;
                }
                }
            }
        }
        caverna[9][0] = cacador.id;
        
        
       for(int i = 0; i < totalLinhas; i++)
        {
            for(int j = 0; j < totalColunas; j++)
            {
                if(i != 0 && j != 9 && i != 9 && j != 0)
                {

                   if("P".equals(caverna[i][j]))
                   {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        }
                       //;;;;;;;;;;;;;;;;;;;;;;;;;;;
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "b";
                        }
                       //´´´´´´´´´´´´´´´´´´
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "b";
                        }
                        //==============================
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "b";
                        }
                   }
                   //caso seja o wumpus
                   if("W".equals(caverna[i][j]))
                   {
                       if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "f";
                        }
                        
                       //;;;;;;;;;;;;;;;;;;;;;;;;;;;
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "f";
                        }
                        
                       //´´´´´´´´´´´´´´´´´´
                       if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "f";
                        }
                        
                        //==============================
                       if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "f";
                        }
                   }
                   //se for ouro
                   if("O".equals(caverna[i][j]))
                   {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "r";
                        }
                        
                       //;;;;;;;;;;;;;;;;;;;;;;;;;;;
                       if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "r";
                        }
                        
                       //´´´´´´´´´´´´´´´´´´
                       if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "r";
                        }
                        
                        //==============================
                       if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "r";
                        }
                        
                   }
                }
                //------------------------------------------------------------------------------------------
                else if(i == 0){
                    
                    if("P".equals(caverna[i][j]))
                    {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        }
                      if(j == 0)
                      {
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "b";
                        }
                      }
                      if(j == 9)
                      {
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "b";
                        }
                      }else{
                         if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "b";
                        }
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "b";
                        } 
                      }
                        //==============================
                        
                   }
                   //caso seja o wumpus
                   if("W".equals(caverna[i][j]))
                   {
                       if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "f";
                        }
                      if(j == 0)
                      {
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "f";
                        }
                      }
                      if(j == 9)
                      {
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "f";
                        }
                      }else{
                         if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "f";
                        }
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "f";
                        } 
                      }                       
                   }
                   //se for ouro
                   if("O".equals(caverna[i][j]))
                   {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "r";
                        }
                      if(j == 0)
                      {
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "r";
                        }
                      }
                      if(j == 9)
                      {
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "r";
                        }
                      }else{
                         if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "r";
                        }
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "r";
                        } 
                      }       
                  }
                }
                   //---------------------------------------------------------------------------------------
                else if(i == 9){
                    if("P".equals(caverna[i][j]))
                    {
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "b";
                        }
                      if(j == 0)
                      {
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "b";
                        }
                      }
                      if(j == 9)
                      {
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "b";
                        }
                      }else{
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "b";
                        }
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "b";
                        }
                      }
                    }
                   //caso seja o wumpus
                   if("W".equals(caverna[i][j]))
                   {
                       if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "f";
                        }
                      if(j == 0)
                      {
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "b";
                        }
                      }
                      if(j == 9)
                      {
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "f";
                        }
                      }else{
                         if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "f";
                        }
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "f";
                        } 
                      }
                   }
                   //se for ouro
                   if("O".equals(caverna[i][j]))
                   {
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "r";
                        }
                      if(j == 0)
                      {
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "r";
                        }
                      }
                      if(j == 9)
                      {
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "r";
                        }
                      }else{
                         if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "r";
                        }
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "r";
                        } 
                      }
                        //==============================
                   }
                }
                else if(j == 0)
                {
                    if("P".equals(caverna[i][j]))
                    {
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "b";
                        }
                      if(i == 0)
                      {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        }
                      }
                      if(i == 9)
                      {
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "b";
                        }
                      }else{
                         if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "b";
                        }
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        } 
                      }   
                   }
                   //caso seja o wumpus
                   if("W".equals(caverna[i][j]))
                   {
                       if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "f";
                        }
                      if(i == 0)
                      {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        }
                      }
                      if(i == 9)
                      {
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "f";
                        }
                      }else{
                         if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "f";
                        }
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "f";
                        } 
                      }
                   }
                   //se for ouro
                   if("O".equals(caverna[i][j]))
                   {
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "r";
                        }
                      if(i == 0)
                      {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "r";
                        }
                      }
                      if(i == 9)
                      {
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "r";
                        }
                      }else{
                         if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "r";
                        }
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "r";
                        } 
                      }
                   }
                }
                else if( j == 9)
                {
                   if("P".equals(caverna[i][j]))
                    {
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "b";
                        }
                      if(i == 0)
                      {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        }
                      }
                      if(i == 9)
                      {
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "b";
                        }
                      }else{
                         if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "b";
                        }
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        } 
                      }    
                   }
                   //caso seja o wumpus
                   if("W".equals(caverna[i][j]))
                   {
                       if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "f";
                        }
                      if(i == 0)
                      {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        }
                      }
                      if(i == 9)
                      {
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "f";
                        }
                      }else{
                         if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "f";
                        }
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "f";
                        } 
                      }
                        //==============================
                        
                   }
                   //se for ouro
                   if("O".equals(caverna[i][j]))
                   {
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "r";
                        }
                      if(i == 0)
                      {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "r";
                        }
                      }
                      if(i == 9)
                      {
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "r";
                        }
                      }else{
                         if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "r";
                        }
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "r";
                        } 
                       }  
                   }
              }
            }
         }
       System.out.println("─────────────────");
       System.out.println("  BEM-VINDO A CAVERNA!");
       System.out.println("─────────────────");

      return caverna;
  }     
}
