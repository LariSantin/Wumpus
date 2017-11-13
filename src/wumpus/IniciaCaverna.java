package wumpus;

import java.util.Random;
import java.io.IOException;

public class IniciaCaverna {
    Cacador cacador = new Cacador();
    int totalLinhas;
    int totalColunas;
    int MaximoPocos;
    String[][] caverna;
    String Ouro;

    public IniciaCaverna(int totalLinhas, int totalColunas, int MaximoPocos) {
        this.totalLinhas = totalLinhas;
        this.totalColunas = totalColunas;
        this.MaximoPocos = MaximoPocos;
        this.caverna = new String[totalLinhas][totalColunas];
        this.caverna = Inicia();
    }

    public String getOuro() {
        return Ouro;
    }

    public void setOuro(String Ouro) {
        this.Ouro = Ouro;
    }
    
    
    public void ComecaJogo() throws IOException{ 
       Auxiliar auxiliar = new Auxiliar();
       Jogo jogo = new Jogo();
       auxiliar.impressao(totalLinhas, totalColunas, caverna);
       int  LinhaCac = 0, ColunaCac = 0;
       boolean QuemAnda = true;
       //true == cacador
       //false == wumpus
       
       while(cacador.getVida() > 0 && cacador.isEncontrouOuro() == false){
        for(int i = 0; i < totalLinhas; i++){
               for(int j = 0; j < totalColunas; j++){
                   if("C".equals(caverna[i][j])){
                       LinhaCac = i;
                       ColunaCac = j;
                   }
               }
           } 
       
        jogo.Cacadorjoga(totalLinhas, totalColunas, MaximoPocos, caverna, LinhaCac,ColunaCac,cacador);
        auxiliar.impressao(totalLinhas, totalColunas, caverna);
        System.out.println("Pressione enter..");
        System.in.read();

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
