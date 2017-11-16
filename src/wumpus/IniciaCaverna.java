package wumpus;

import java.io.IOException;
import java.util.Random;

public class IniciaCaverna {
     int totalLinhas;
     int totalColunas;
     int MaximoPocos;
     String[][] caverna;
     String[][] CopiaCaverna;
     Cacador cacador = new Cacador();

     public void novoJogo() throws IOException{
        Caverna cavernaTela = new Caverna();
        cavernaTela.setVisible(false);
        comeca();
     }
    public IniciaCaverna(int totalLinhas, int totalColunas, int MaximoPocos) {
        this.totalLinhas = totalLinhas;
        this.totalColunas = totalColunas;
        this.MaximoPocos = MaximoPocos;
        this.caverna = new String[totalLinhas][totalColunas];
        this.CopiaCaverna = new String[totalLinhas][totalColunas];
        this.caverna = Inicia();
    }
     public void comeca() throws IOException{
        Caverna cavernaTela = new Caverna();
        cavernaTela.Distribui(caverna);
        cavernaTela.setVisible(true);
        
        boolean QuemAnda = true, WumpusVive = true;
        int  LinhaCac = 0, ColunaCac = 0, LinhaW = 0, ColunaW = 0;
        Jogo jogo = new Jogo();
        Auxiliar aux = new Auxiliar();

       for(int s = 0; s < totalLinhas; s++){
        for(int e = 0; e < totalColunas; e++){
            CopiaCaverna[s][e] = caverna[s][e];
        }
       }
        //true == cacador
        //false == wumpus  
       while(cacador.getVida() > 0 && cacador.isEncontrouOuro() == false){
            for(int i = 0; i < totalLinhas; i++){
                for(int j = 0; j < totalColunas; j++){
                    if("C".equals(caverna[i][j])){
                        LinhaCac = i;
                        ColunaCac = j;
                    }
                    else if("W".equals(caverna[i][j])){
                        LinhaW = i;
                        ColunaW = j;
                    }
                    }
           }
            if(QuemAnda ==  true){

            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("Caçador");
            jogo.Cacadorjoga(totalLinhas, totalColunas, MaximoPocos, caverna, LinhaCac, ColunaCac, cacador, WumpusVive);
            aux.impressao(totalLinhas, totalColunas, caverna);
            QuemAnda = false;
            System.out.println("Vida do Caçador:");
            System.out.println(cacador.getVida());
            System.out.println("");
//            System.out.println("Pressione enter..");
//            System.in.read();
            cavernaTela.Distribui(caverna);
            cavernaTela.setVisible(true);
            try {
                Thread.sleep(900);// pausa de 2000 milisegundos
              }catch (InterruptedException e) {
                e.printStackTrace(); 
}
          }   
          else if(QuemAnda == false && WumpusVive == true){
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
            System.out.println("Wumpus");
            //se wumpus ta vivo=--------------------------
            jogo.Wumpusjoga(totalLinhas, totalColunas, caverna, LinhaW, ColunaW, cacador, CopiaCaverna);
            aux.impressao(totalLinhas, totalColunas, caverna);
            QuemAnda = true;
//            System.out.println("Pressione enter..");
//           System.in.read();
            cavernaTela.Distribui(caverna);
            cavernaTela.setVisible(true);
            try {
                Thread.sleep(900);// pausa de 2000 milisegundos
            }catch (InterruptedException e) {
                e.printStackTrace(); 
              }
              }
            if(cacador.isEncontrouOuro() == true){
             cavernaTela.setVisible(false);
             TelaCacadorGanhou ganhou = new TelaCacadorGanhou();
             ganhou.setVisible(true);
             aux.Ganhou();
          }
         }
     }
       public String[][] Inicia(){
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
        caverna[14][0] = cacador.getId();
        
        
       for(int i = 0; i < totalLinhas; i++)
        {
            for(int j = 0; j < totalColunas; j++)
            {
                if(i != 0 && j != totalColunas-1 && i != totalColunas-1 && j != 0)
                {
                    //se for ouro
                    if("O".equals(caverna[i][j]))
                    {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "r";
                        }
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "r";
                        }
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "r";
                        }
                        if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "r";
                        }
                    }
                    //caso seja o wumpus
                    if("W".equals(caverna[i][j]))
                    {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "f";
                        }
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "f";
                        }
                        if("*".equals(caverna[i][j+1]))
                        {
                          caverna[i][j+1]= "f";
                        }
                       if("*".equals(caverna[i][j-1]))
                        {
                          caverna[i][j-1]= "f";
                        }
                   }
                   if("P".equals(caverna[i][j]))
                   {
                        if("*".equals(caverna[i+1][j]))
                        {
                          caverna[i+1][j]= "b";
                        }
                        if("*".equals(caverna[i-1][j]))
                        {
                          caverna[i-1][j]= "b";
                        }
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
                //------------------------------------------------------------------------------------------
                else if(i == 0){
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
                      if(j == totalColunas-1)
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
                      if(j == totalColunas-1)
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
                      if(j == totalColunas-1)
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
                }
                   //---------------------------------------------------------------------------------------
                else if(i == totalLinhas-1){
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
                      if(j == totalColunas-1)
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
                      if(j == totalColunas-1)
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
                      if(j == totalColunas-1)
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
                }
                else if(j == 0)
                {
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
                      if(i == totalLinhas-1)
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
                      if(i == totalLinhas-1)
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
                      if(i == totalLinhas-1)
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
                }
                else if( j == totalColunas-1)
                {
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
                      if(i == totalLinhas-1)
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
                      if(i == totalLinhas-1)
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
                      if(i == totalLinhas-1)
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
              }
            }
         }
       System.out.println("─────────────────");
       System.out.println("  BEM-VINDO A CAVERNA!");
       System.out.println("─────────────────");

      return caverna;
  }  
}
