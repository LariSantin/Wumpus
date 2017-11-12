package wumpus;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadCacador implements Runnable{
   int totalLinhas;
    int totalColunas;
    int MaximoPocos;
    int tempo;
    String[][] caverna;

    public ThreadCacador(int totalLinhas, int totalColunas, int MaximoPocos, String[][] caverna,int tempo) {
        this.totalLinhas = totalLinhas;
        this.totalColunas = totalColunas;
        this.MaximoPocos = MaximoPocos;
        this.caverna = caverna;
        this.tempo = tempo;
        Thread t = new Thread(this);
        t.start();
    }

    
  @Override
  public void run(){
    Auxiliar auxiliar = new Auxiliar();
    
//              for(int i = 0; i < totalLinhas; i++){
//                   for(int j = 0; j < totalColunas; j++){
//                       System.out.print(caverna[i][j] + " | ");  
//                   }
//                   System.out.println("");
//              } 
              
       Cacador cacador = new Cacador(); 
       boolean EncontrouOuro = false;
       int i = 0,j = 0;
       auxiliar.impressao(totalLinhas,totalColunas,caverna);
       while(cacador.getVida() > 0 && EncontrouOuro == false){
           
          //  auxiliar.impressao(totalLinhas,totalColunas,caverna);
           if(j >= totalColunas)
            {
              i++;  
              j = 0;
            } 
           if(i >= totalLinhas)
           {
               i = 0;
              auxiliar.impressao(totalLinhas,totalColunas,caverna);
               System.out.println("vida: " + cacador.getVida());
             //  EncontrouOuro = true;
             
           }
            if(i != 0 && i != 9 && j != 0 && j != 9){
                /*A ordem de precedencia:::::::
                se for um resplendor entra
                se for livre
                se for brisa
                e fedor
                Não entra se for poço e nem o wumpus
                Caso esteja no fedor dispara a flecha aleatoria
                ::::::::::::::::
               */
                if(caverna[i][j].equals("C")){
                    System.out.println("caverna tudo: " + caverna[i][j]);
                    //se for o resplendor
                    if("r".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                        caverna[i-1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i-1, j, "r");
                        cacador.atualizahistorico(i, j,"V");
                        if("O".equals(caverna[i-2][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("r".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j-1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        if("O".equals(caverna[i][j-2])){
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("r".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                     
                        if("O".equals(caverna[i][j+2])){
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("r".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "r");
                        cacador.atualizahistorico(i, j,"V");  
                       
                        if("O".equals(caverna[i+2][j])){
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                   
                    //caso a posição esteja livre
                    else if("b".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                        caverna[i-1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i-1, j, "b");
                        cacador.atualizahistorico(i, j,"V");
                        
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("b".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j-1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("*".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("*".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "r");
                        cacador.atualizahistorico(i, j,"V"); 
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    //caso seja brisa
                     else if("*".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                        caverna[i-1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i-1, j, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("*".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j-1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("*".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("*".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "r");
                        cacador.atualizahistorico(i, j,"V"); 
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                 //  auxiliar.impressao(totalLinhas,totalColunas,caverna);
                }
            }
            if(i == 0){
                   if(caverna[i][j].equals("C")){
                    System.out.println("caverna i = 0: " + caverna[i][j]);
                    //se for o resplendor
                    if(j > 0 && "r".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j-1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                        if("O".equals(caverna[i][j-2])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        if("O".equals(caverna[i+1][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                        
                    }
                    else if(j < (totalColunas -1) && "r".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                        if("O".equals(caverna[i][j+2])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        if("O".equals(caverna[i+1][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("r".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "r");
                        cacador.atualizahistorico(i, j,"V");  
                        
                        if("O".equals(caverna[i+2][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    //caso a posição esteja livre
                    else if(j > 0 && "*".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j-1, "V");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                     else if( j != (totalColunas -1) && "*".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "V");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("*".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "V");
                        cacador.atualizahistorico(i, j,"V");   
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                   
                 //   auxiliar.impressao(totalLinhas,totalColunas,caverna);
                }
            }
            if(i == 9){
               
                if(caverna[i][j].equals("C")){
                    System.out.println("caverna i = 9: " + caverna[i][j]);
                    //se for o resplendor
                    if("r".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                        caverna[i-1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i-1, j, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                        if("O".equals(caverna[i-2][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux + 1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    } 
                    else if( j > 0 && "r".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1)) ){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j-1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                        if("O".equals(caverna[i][j-2])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if( j < (totalColunas-1) && "r".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                         if("O".equals(caverna[i][j+2])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux +1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    
                    //caso a posição esteja livre
                    else if("*".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                        caverna[i-1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i-1, j, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if(j > 0 && "*".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                   else if(j < (totalColunas-1) && "*".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                  //    auxiliar.impressao(totalLinhas,totalColunas,caverna);
                }
            }
            if(j == 0){
                if(caverna[i][j].equals("C")){
                    //se for o resplendor
                    System.out.println("caverna j =0 : " + caverna[i][j]);
                    if(i > 0 && "r".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){ 
                       System.out.println("entrou 3");
                       caverna[i-1][j] = cacador.getId();
                       caverna[i][j]= "*";
                       cacador.atualizahistorico(i-1, j, "r");
                       cacador.atualizahistorico(i, j,"V");
                       
                       if("O".equals(caverna[i-2][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                       }
                       int aux = cacador.getVida();
                       cacador.setVida(aux-1);
                    }
                    else if("r".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        System.out.println("entrou 2");
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                        
                        if("O".equals(caverna[i][j+2])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux + 1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+ 1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if(i < (totalLinhas-1) && "r".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        System.out.println("entrou");
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "r");
                        cacador.atualizahistorico(i, j,"V");  
                        
                        if("O".equals(caverna[i+2][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                        
                    }
                    
                    
                    //caso a posição esteja livre
                    else if( i > 0 && "*".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){  
                        System.out.println("entrou 6");
                        caverna[i-1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i-1, j, "V");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                       
                    }
                    else if("*".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        System.out.println("entrou 5");
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "V");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                        
                    }
                    else if(i < (totalLinhas-1) && "*".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        System.out.println("entrou 4");
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "V");
                        cacador.atualizahistorico(i, j,"V"); 
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                  //  auxiliar.impressao(totalLinhas,totalColunas,caverna);
                }
            }
           else if(j == 9){
                //System.out.println("caverna " + caverna[i][j]);
                if(caverna[i][j].equals("C")){
                    System.out.println("caverna j =9 : " + caverna[i][j]);
                    //se for o resplendor
                    if(i > 0 && "r".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                        caverna[i-1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i-1, j, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                        if("O".equals(caverna[i-1][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("r".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j-1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        
                        if("O".equals(caverna[i][j-1])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                           auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if(i < (totalColunas-1) && "r".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "r");
                        cacador.atualizahistorico(i, j,"V"); 
                        
                        if("O".equals(caverna[i+1][j])){
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            EncontrouOuro = true;
                            auxiliar.Ganhou();
                        }
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                  
                    
                    //caso a posição esteja livre
                    else if(i > 0 && "*".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                        caverna[i-1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i-1, j, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("*".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                        caverna[i][j-1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j-1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if(i < (totalColunas-1) && "*".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                        caverna[i+1][j] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i+1, j, "r");
                        cacador.atualizahistorico(i, j,"V");  
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }                 
                   
                    //  auxiliar.impressao(totalLinhas,totalColunas,caverna);
                }
            }
           j++;
           
      }
   
        
        System.out.println("historico");
        cacador.imprimeHist();
        
    }
       
}
