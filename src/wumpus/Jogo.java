package wumpus;

public class Jogo{
 // Cacador cacador = new Cacador();
    
   public void Cacadorjoga(int totalLinhas, int totalColunas, int MaximoPocos,String[][] caverna, int i, int j, Cacador cacador){
       Auxiliar auxiliar = new Auxiliar();

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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                    //caso seja brisa
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
                    else if("b".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                        caverna[i][j+1] = cacador.getId();
                        caverna[i][j]= "*";
                        cacador.atualizahistorico(i, j+1, "r");
                        cacador.atualizahistorico(i, j,"V");
                        int aux = cacador.getVida();
                        cacador.setVida(aux-1);
                    }
                    else if("b".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux + 1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if(j < (totalColunas-1) && "O".equals(caverna[i-1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux + 1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if(j > 0 && "O".equals(caverna[i-1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux + 1000);
                            cacador.setEncontrouOuro(true);
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
                        
                        if(j > 0 && "O".equals(caverna[i][j-2])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux +1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux +1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux +1000);
                            cacador.setEncontrouOuro(true);
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
                       
                       if(i > 0 && "O".equals(caverna[i-2][j])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                       }
                       else if("O".equals(caverna[i-1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                       }
                       else if("O".equals(caverna[i-1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux + 1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+ 1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+ 1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                        
                        if("O".equals(caverna[i-2][j])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j+1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i+1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
                            auxiliar.Ganhou();
                        }
                        else if("O".equals(caverna[i-1][j-1])){
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
                            auxiliar.impressao(totalLinhas, totalColunas, caverna);
                            int aux = cacador.getVida();
                            cacador.setVida(aux+1000);
                            cacador.setEncontrouOuro(true);
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
      //  System.out.println("historico");
       // cacador.imprimeHist();
        
  }
}
