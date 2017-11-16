package wumpus;

import java.util.Random;

public class Jogo{
 Auxiliar auxiliar = new Auxiliar();
    
public void Cacadorjoga(int totalLinhas, int totalColunas, int MaximoPocos,String[][] caverna, int i, int j, Cacador cacador,boolean WumpusVive){
    String GritoWumpus = null;
    VerificaOuro(i, j,caverna,cacador);
    if(i != 0 && i != totalColunas-1 && j != 0 && j != totalColunas-1){
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
            System.out.println("caverna tudo");
            //se for o resplendor
            if("r".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");
                
                if("O".equals(caverna[i-2][j])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-2][j] = cacador.getId();
                    caverna[i-1][j]= "*";
                  //  auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i-1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j+1] = cacador.getId();
                    caverna[i-1][j]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i-1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j-1] = cacador.getId();
                    caverna[i-1][j]= "*";
                   // auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("r".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                if("O".equals(caverna[i][j-2])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i][j-2] = cacador.getId();
                    caverna[i][j-1]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j-1] = cacador.getId();
                    caverna[i][j-1]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i-1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j-1] = cacador.getId();
                    caverna[i][j-1]= "*";
                    //auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("r".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V");  

                if(i < totalLinhas-2 && "O".equals(caverna[i+2][j])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+2][j] = cacador.getId();
                    caverna[i+1][j]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j-1] = cacador.getId();
                    caverna[i+1][j]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j+1] = cacador.getId();
                    caverna[i+1][j]= "*";
                  //  auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("r".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");

                if("O".equals(caverna[i][j+2])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i][j+2] = cacador.getId();
                    caverna[i][j+1]= "*";
                    //auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j+1] = cacador.getId();
                    caverna[i][j+1]= "*";
                    //auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i-1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j+1] = cacador.getId();
                    caverna[i][j+1]= "*";
                    //auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso a posição esteja livre
             else if("*".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("*".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
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
            else if("*".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso seja brisa
            else if("b".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("b".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("b".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("b".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso seja fedor
             else if("f".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j,"V");
                
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if("f".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                         int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                         int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if("f".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if("f".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                         int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                         int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else{
                System.out.println("nenhuma possivel");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                cacador.atualizahistorico(i, j, "I");
                if("V".equals(cacador.ElementoPosicao(i, j+1))){
                     caverna[i][j+1] = "C";
                     caverna[i][j] = "*";
                }
                else if("V".equals(cacador.ElementoPosicao(i-1, j))){
                     caverna[i-1][j] = "C";
                     caverna[i][j] = "*";
                }
                else if("V".equals(cacador.ElementoPosicao(i, j-1))){
                     caverna[i][j-1] = "C";
                     caverna[i][j] = "*";
                }                
                else if("V".equals(cacador.ElementoPosicao(i+1, j))){
                     caverna[i+1][j] = "C";
                     caverna[i][j] = "*";
                }
               
            }
        }
    }
    else if(i == 0){
           if(caverna[i][j].equals("C")){
            System.out.println("caverna i = 0: " + caverna[i][j]);
            //se for o resplendor
            if(j > 0 && "r".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");

                if("O".equals(caverna[i][j-2])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i][j-2] = cacador.getId();
                    caverna[i][j-1]= "*";
                  //  auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j-1] = cacador.getId();
                    caverna[i][j-1]= "*";
                  //  auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);

            }
            else if("r".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V");  

                if("O".equals(caverna[i+2][j])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+2][j] = cacador.getId();
                    caverna[i+1][j]= "*";
                    //auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j-1] = cacador.getId();
                    caverna[i+1][j]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j+1] = cacador.getId();
                    caverna[i+1][j]= "*";
                    //auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(j < (totalColunas -1) && "r".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");

                if("O".equals(caverna[i][j+2])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i][j+2] = cacador.getId();
                    caverna[i][j+1]= "*";
                    //auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j+1] = cacador.getId();
                    caverna[i][j+1]= "*";
                  //  auxiliar.Ganhou();
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
            else if("*".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
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
            //caso seja brisa
            else if(j > 0 && "b".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("b".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if( j != (totalColunas -1) && "b".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso seja fedor
            else if(j > 0 && "f".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if("f".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if( j != (totalColunas -1) && "f".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else{
                System.out.println("nenhuma possivel");
                 int aux = cacador.getVida();
                cacador.setVida(aux-1);
                cacador.atualizahistorico(i, j, "I");
                
                if(j < totalColunas-1 && "V".equals(cacador.ElementoPosicao(i, j+1))){
                     caverna[i][j+1] = "C";
                     caverna[i][j] = "*";
                }
                else if(j > 0 && "V".equals(cacador.ElementoPosicao(i, j-1))){
                     caverna[i][j-1] = "C";
                     caverna[i][j] = "*";
                }
                else if("V".equals(cacador.ElementoPosicao(i+1, j))){
                     caverna[i+1][j] = "C";
                     caverna[i][j] = "*";
                }
              
            }
        }
    }
    else if(i == totalLinhas-1){

        if(caverna[i][j].equals("C")){
            System.out.println("caverna i = 9: " + caverna[i][j]);
            //se for o resplendor
            if("r".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                if("O".equals(caverna[i-2][j])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux + 1000);
                    cacador.setEncontrouOuro(true);
                     caverna[i-2][j] = cacador.getId();
                    caverna[i-1][j]= "*";
                   // auxiliar.Ganhou();
                }
                else if(j < (totalColunas-1) && "O".equals(caverna[i-1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux + 1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j+1] = cacador.getId();
                    caverna[i-1][j]= "*";
                   // auxiliar.Ganhou();
                }
                else if(j > 0 && "O".equals(caverna[i-1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux + 1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j-1] = cacador.getId();
                    caverna[i-1][j]= "*";
                   // auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            } 
            else if( j > 0 && "r".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1)) ){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");

                if(j > 0 && "O".equals(caverna[i][j-2])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i][j-2] = cacador.getId();
                    caverna[i][j-1]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i-1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j-1] = cacador.getId();
                    caverna[i][j-1]= "*";
                   // auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if( j < (totalColunas-1) && "r".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");

                if("O".equals(caverna[i][j+2])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux +1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i][j+2] = cacador.getId();
                    caverna[i][j+1]= "*";
                    //auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux +1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j+1] = cacador.getId();
                    caverna[i][j+1]= "*";
                    //auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }

            //caso a posição esteja livre
            else if("*".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(j > 0 && "*".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(j < (totalColunas-1) && "*".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso seja brisa
            else if("b".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(j > 0 && "b".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(j < (totalColunas-1) && "b".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso seja fedor
             else if("f".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                int aux = cacador.getVida();
                cacador.setVida(aux-1);

                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if(j > 0 && "f".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if(j < (totalColunas-1) && "f".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else{
                System.out.println("nenhuma possivel");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                cacador.atualizahistorico(i, j, "I");
                if("V".equals(cacador.ElementoPosicao(i-1, j))){
                     caverna[i-1][j] = "C";
                     caverna[i][j] = "*";
                }
                else if(j > 0 && "V".equals(cacador.ElementoPosicao(i, j-1))){
                     caverna[i][j-1] = "C";
                     caverna[i][j] = "*";
                }
                else if(j < totalColunas-1 && "V".equals(cacador.ElementoPosicao(i, j+1))){
                     caverna[i][j+1] = "C";
                     caverna[i][j] = "*";
                }
            }
        }
    }
    else if(j == 0){
        if(caverna[i][j].equals("C")){
            //se for o resplendor
            System.out.println("caverna j =0 : " + caverna[i][j]);
            if(i > 0 && "r".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){ 
               caverna[i-1][j] = cacador.getId();
               caverna[i][j]= "*";
               cacador.atualizahistorico(i-1, j, "V");
               cacador.atualizahistorico(i, j,"V");

               if(i > 0 && "O".equals(caverna[i-2][j])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-2][j] = cacador.getId();
                    caverna[i-1][j]= "*";
                   // auxiliar.Ganhou();
               }
               else if("O".equals(caverna[i-1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j+1] = cacador.getId();
                    caverna[i-1][j]= "*";
                    //auxiliar.Ganhou();
               }
               int aux = cacador.getVida();
               cacador.setVida(aux-1);
            }
            else if(i < (totalLinhas-1) && "r".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V");  

                if("O".equals(caverna[i+2][j])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+2][j] = cacador.getId();
                    caverna[i+1][j]= "*";
                    //auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j+1] = cacador.getId();
                    caverna[i+1][j]= "*";
                    //auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);

            }
            else if("r".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");


                if("O".equals(caverna[i][j+2])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux + 1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i][j+2] = cacador.getId();
                    caverna[i][j+1]= "*";
                  //  auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+ 1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j+1] = cacador.getId();
                    caverna[i][j+1]= "*";
                   // auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso a posição esteja livre
            else if( i > 0 && "*".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){  
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);

            }
            else if(i < (totalLinhas-1) && "*".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("*".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);

            }
          //caso seja brisa
            else if(i > 0 && "b".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(i < (totalLinhas-1) && "b".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("b".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso seja fedor
            else if(i > 0 && "f".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                int aux = cacador.getVida();
                cacador.setVida(aux-1);

                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if(i < (totalLinhas-1) && "f".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if("f".equals(caverna[i][j+1]) && "*".equals(cacador.ElementoPosicao(i, j+1))){
                caverna[i][j+1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j+1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else{
                System.out.println("nenhuma possivel");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                cacador.atualizahistorico(i, j, "I");
                if("V".equals(cacador.ElementoPosicao(i, j+1))){
                     caverna[i][j+1] = "C";
                     caverna[i][j] = "*";
                }
                else if(i > 0 && "V".equals(cacador.ElementoPosicao(i-1, j))){
                     caverna[i-1][j] = "C";
                     caverna[i][j] = "*";
                }
                else if(i < totalLinhas-1 && "V".equals(cacador.ElementoPosicao(i+1,j))){
                     caverna[i+1][j] = "C";
                     caverna[i][j] = "*";
                }
            }
        }
    }
    else if(j == totalColunas-1){
        //System.out.println("caverna " + caverna[i][j]);
        if(caverna[i][j].equals("C")){
            System.out.println("caverna j =9 : " + caverna[i][j]);
            //se for o resplendor
            if(i > 0 && "r".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                if("O".equals(caverna[i-2][j])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-2][j] = cacador.getId();
                    caverna[i-1][j]= "*";
                    //auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i-1][j+1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j+1] = cacador.getId();
                    caverna[i-1][j]= "*";
                    //auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("r".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");

                if("O".equals(caverna[i][j-2])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i][j-2] = cacador.getId();
                    caverna[i][j-1]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j-1] = cacador.getId();
                    caverna[i][j-1]= "*";
                   // auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i-1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i-1][j-1] = cacador.getId();
                    caverna[i][j]= "*";
                   // auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(i < (totalColunas-1) && "r".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 

                if("O".equals(caverna[i+2][j])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+2][j] = cacador.getId();
                    caverna[i+1][j]= "*";
                    //auxiliar.Ganhou();
                }
                else if("O".equals(caverna[i+1][j-1])){
                    int aux = cacador.getVida();
                    cacador.setVida(aux+1000);
                    cacador.setEncontrouOuro(true);
                    caverna[i+1][j-1] = cacador.getId();
                    caverna[i+1][j]= "*";
                    //auxiliar.Ganhou();
                }
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }


            //caso a posição esteja livre
            else if(i > 0 && "*".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("*".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(i < (totalColunas-1) && "*".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V");  
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }                 

           //caso seja brisa
            else if(i > 0 && "b".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if("b".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            else if(i < (totalColunas-1) && "b".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
            }
            //caso seja fedor
             else if(i > 0 && "f".equals(caverna[i-1][j]) && "*".equals(cacador.ElementoPosicao(i-1, j))){      
                caverna[i-1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i-1, j, "V");
                cacador.atualizahistorico(i, j,"V");

                int aux = cacador.getVida();
                cacador.setVida(aux-1);

                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if("f".equals(caverna[i][j-1]) && "*".equals(cacador.ElementoPosicao(i, j-1))){
                caverna[i][j-1] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i, j-1, "V");
                cacador.atualizahistorico(i, j,"V");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("GgGgGgGgGgGgGgGgGgGgGgGgGg");
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else if(i < (totalColunas-1) && "f".equals(caverna[i+1][j]) && "*".equals(cacador.ElementoPosicao(i+1, j))){
                caverna[i+1][j] = cacador.getId();
                caverna[i][j]= "*";
                cacador.atualizahistorico(i+1, j, "V");
                cacador.atualizahistorico(i, j,"V"); 
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                if(cacador.isFlecha() == true){
                    GritoWumpus = atiraflecha(caverna);
                    System.out.println("Grito " + GritoWumpus);
                    if(GritoWumpus.equals("GgGgG")){
                        System.out.println("Cacador acertou a flecha e matou o wumpus!");
                        for(int k = 0; k < totalLinhas; k++){
                            for(int l = 0; l < totalColunas; l++){
                                if("W".equals(caverna[k][l])){
                                    caverna[k][l] = "*";
                                }
                                else if("f".equals(caverna[k][l])){
                                     caverna[k][l] = "*";
                                }
                            }
                        }
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        WumpusVive = false;
                    }
                    else if(GritoWumpus.equals("shSHsh")){
                        int aux1;
                        aux1 = cacador.getVida();
                        cacador.setVida(aux1-10);
                        System.out.println("Caçador errou a flecha!");
                    }
                    cacador.setFlecha(false);
                }
            }
            else{
                System.out.println("Nenhuma posicao foi po");
                int aux = cacador.getVida();
                cacador.setVida(aux-1);
                cacador.atualizahistorico(i, j, "I");
                if(i > 0 && "V".equals(cacador.ElementoPosicao(i-1, j))){
                     caverna[i-1][j] = "C";
                     caverna[i][j] = "*";
                }
                if("V".equals(cacador.ElementoPosicao(i, j-1))){
                     caverna[i][j-1] = "C";
                     caverna[i][j] = "*";
                }
                else if(i < totalLinhas-1 && "V".equals(cacador.ElementoPosicao(i+1,j))){
                     caverna[i+1][j] = "C";
                     caverna[i][j] = "*";
                }                
            }
        }
    }        
      caverna = ColocaAvisos(caverna);        
  }
public String[][] ColocaAvisos(String[][] caverna){
    int totalLinhas = 15;
    int totalColunas = 15;
    
    for(int i = 0; i < totalLinhas; i++){
       for(int j = 0; j < totalColunas; j++){
            if(i != 0 && j != totalColunas-1 && i != totalLinhas-1 && j != 0){
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
                if("P".equals(caverna[i][j])){
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
                  else if(j == totalColunas-1)
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
                  else if(j == totalColunas-1)
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
                else if(j == totalColunas-1)
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
                  else if(j == totalColunas-1)
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
                  else if(j == totalColunas-1)
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
                  else if(j == totalColunas-1)
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
                  else if(i == totalLinhas-1)
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
                  else if(i == totalLinhas-1)
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
                  else if(i == totalLinhas-1)
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
                  else if(i == totalLinhas-1)
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
                  else if(i == totalLinhas-1)
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
                  else if(i == totalLinhas-1)
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
    
    return caverna;
}
public String atiraflecha(String[][] caverna){
    System.out.println("direcao");
    int direcao;
    String Grito = null;
    int LinhaC = 0, ColunaC = 0, LinhaW = 0, ColunaW = 0;
    auxiliar.impressao(10, 10, caverna);
    Random gerador = new Random();
	  
    direcao = 1 + gerador.nextInt(3);
    
    
    for(int i =0;i < 10; i++){
        for(int j = 0; j < 10; j++){
            if("C".equals(caverna[i][j])){
                LinhaC = i;
                ColunaC = j;
            }
            else if("W".equals(caverna[i][j])){
                LinhaW = i;
                ColunaW = j;
            }
        }
    }
    System.out.println("dir: " + direcao);
    /*
     1 = (i-1)
     2 = (j-1)
     3 = (j+1)
     4 = (i+1)
      */
     switch (direcao) {
         case 1:
             if(LinhaC > 0 && (LinhaC-1) == LinhaW && ColunaC == ColunaW){
                Grito = "GgGgG";
             }else{
                Grito = "shSHsh";
             }
             break;
         case 2:
             if(ColunaC > 0 && LinhaC == LinhaW && (ColunaC-1)== ColunaW){
                Grito = "GgGgG";  
             }else{
                Grito = "shSHsh";
             }
             break;
         case 3:
             if(ColunaC < 14 && LinhaC == LinhaW && (ColunaC+1) == ColunaW){
                Grito = "GgGgG"; 
             }else{
                Grito = "shSHsh";
             }
             break;
         case 4:
             if(LinhaC < 14 && (LinhaC+1) == LinhaW && ColunaC == ColunaW){
                Grito = "GgGgG"; 
             }else{
                Grito = "shSHsh";
             }
             break;
         default:
             Grito = "shSHsh";
             break;
     }
     return Grito;
}
public void Wumpusjoga(int totalLinhas, int totalColunas,String[][] caverna, int i, int j , Cacador cacador, String[][] CopiaCaverna){
    
    int direcao;
    Random gerador = new Random();
	  
    direcao = 1 + gerador.nextInt(3);
    System.out.println("direcao: " + direcao);
    /*
     1 = (i-1)
     2 = (j-1)
     3 = (j+1)
     4 = (i+1)
      */
    for(int l = 0; l < totalLinhas; l ++){
        for(int k = 0 ; k < totalColunas; k++){
            if("f".equals(caverna[l][k])){
              caverna[l][k] = "*";   
            }
        }
    }
    if(i > 0 && i < totalLinhas-1 && j > 0 && j < totalColunas-1){
        switch (direcao) {
        case 1:
            System.out.println("if 1, case 1");
            if("C".equals(caverna[i-1][j])){
                int aux;
                aux= cacador.getVida();
                cacador.setVida(aux-1000);
                TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                perdeu.setVisible(true);
                auxiliar.Perdeu("devorado");
            }else{
                caverna[i][j]= "*";
                caverna[i-1][j] = "W";
            }
            break;
        case 2:
            System.out.println("if 1, case 2");
            if("C".equals(caverna[i][j-1])){
                int aux;
                aux= cacador.getVida();
                cacador.setVida(aux-1000);
                TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                perdeu.setVisible(true);
                auxiliar.Perdeu("devorado");
            }else{
                caverna[i][j]= "*";
                caverna[i][j-1] = "W";
            }
            break;
        case 3:
            System.out.println("if 1, case 3");
            if("C".equals(caverna[i][j+1])){
                int aux;
                aux= cacador.getVida();
                cacador.setVida(aux-1000);
                TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                perdeu.setVisible(true);
                auxiliar.Perdeu("devorado");
            }else{
                caverna[i][j]= "*";
                caverna[i][j+1] = "W";
            }
            break;
        case 4:
            System.out.println("if 1, case 4");
            if("C".equals(caverna[i+1][j])){
                int aux;
                aux= cacador.getVida();
                cacador.setVida(aux-1000);
                TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                perdeu.setVisible(true);
                auxiliar.Perdeu("devorado");
            }else{
                caverna[i][j]= "*";
                caverna[i+1][j] = "W";
            }
            break;
        default:
            System.out.println("if 1, default");
            NenhumaDirecao(i,j,caverna,cacador);
            break;
     }
    }
    else if(i == 0){
        switch (direcao) {
       case 2:
           System.out.println("if 2, case 2");
           if(j > 0 ){
            if("C".equals(caverna[i][j-1])){
                 int aux;
                 aux= cacador.getVida();
                 cacador.setVida(aux-1000);
                 TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                 perdeu.setVisible(true);
                 auxiliar.Perdeu("devorado");
             }else{
                 caverna[i][j]= "*";
                 caverna[i][j-1] = "W";
             }
           }
           break;
       case 3:
           System.out.println("if 2, case 3");
           if(j < totalColunas-1){
            if("C".equals(caverna[i][j+1])){
                 int aux;
                 aux= cacador.getVida();
                 cacador.setVida(aux-1000);
                 TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                 perdeu.setVisible(true);
                 auxiliar.Perdeu("devorado");
             }else{
                 caverna[i][j]= "*";
                 caverna[i][j+1] = "W";
             }
           }
           break;
       case 4:
           System.out.println("if 2, case 4");
            if("C".equals(caverna[i+1][j])){
                int aux;
                aux= cacador.getVida();
                cacador.setVida(aux-1000);
                TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                perdeu.setVisible(true);
                auxiliar.Perdeu("devorado");
            }else{
                caverna[i][j]= "*";
                caverna[i+1][j] = "W";
            }   
           break;
       default:
           System.out.println("if 2, def");
           NenhumaDirecao(i,j,caverna, cacador);
           break;
     }
    }   
    else if(i == 14){
        switch (direcao) {
       case 1:
           System.out.println("if 3, case 1");
           if("C".equals(caverna[i-1][j])){
                int aux;
                aux= cacador.getVida();
                cacador.setVida(aux-1000);
                TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                perdeu.setVisible(true);
                auxiliar.Perdeu("devorado");
            }else{
                caverna[i][j]= "*";
                caverna[i-1][j] = "W";
            }
           break;
       case 2:
           System.out.println("if 3, case 2");
           if(j > 0){
            if("C".equals(caverna[i][j-1])){
                 int aux;
                 aux= cacador.getVida();
                 cacador.setVida(aux-1000);
                 auxiliar.Perdeu("devorado");
             }else{
                 caverna[i][j]= "*";
                 caverna[i][j-1] = "W";
             }
           }
           break;
       case 3:
           System.out.println("if 3, case 3");
           if(j < totalColunas-1){
            if("C".equals(caverna[i][j+1])){
                int aux;
                aux= cacador.getVida();
                cacador.setVida(aux-1000);
                TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                perdeu.setVisible(true);
                auxiliar.Perdeu("devorado");
            }else{
                caverna[i][j]= "*";
                caverna[i][j+1] = "W";
            }   
           }
           break;
       default:
           System.out.println("if 3,def");
           NenhumaDirecao(i,j,caverna, cacador);
           break;
     }
    }
    else if(j == 0){
        switch (direcao) {
       case 1:
           System.out.println("if 4, case 1");
           if(i > 0){
            if("C".equals(caverna[i-1][j])){
                 int aux;
                 aux= cacador.getVida();
                 cacador.setVida(aux-1000);
                 TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                 perdeu.setVisible(true);
                 auxiliar.Perdeu("devorado");
             }else{
                 caverna[i][j]= "*";
                 caverna[i-1][j] = "W";
             }
           }
           break;
       case 3:
           System.out.println("if 4, case 3");
            if("C".equals(caverna[i][j+1])){
                 int aux;
                 aux= cacador.getVida();
                 cacador.setVida(aux-1000);
                 TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                 perdeu.setVisible(true);
                 auxiliar.Perdeu("devorado");
             }else{
                 caverna[i][j]= "*";
                 caverna[i][j+1] = "W";
             }
           break;
       case 4:
           System.out.println("if 4, case 4");
           if(i < totalLinhas-1){
            if("C".equals(caverna[i+1][j])){
                 int aux;
                 aux= cacador.getVida();
                 cacador.setVida(aux-1000);
                 TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                 perdeu.setVisible(true);
                 auxiliar.Perdeu("devorado");
             }else{
                 caverna[i][j]= "*";
                 caverna[i+1][j] = "W";
             }
           }
           break;
       default:
           System.out.println("if 4, def");
           NenhumaDirecao(i,j,caverna, cacador);
           break;
     }
    }
    else if(j == 14){
        switch (direcao) {
       case 1:
           System.out.println("if 5, case 1");
           if(i > 0){
            if("C".equals(caverna[i-1][j])){
                 int aux;
                 aux= cacador.getVida();
                 cacador.setVida(aux-1000);
                 TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                 perdeu.setVisible(true);
                 auxiliar.Perdeu("devorado");
             }else{
                 caverna[i][j]= "*";
                 caverna[i-1][j] = "W";
             }
           }
           break;
       case 2:
           System.out.println("if 5, case 2");
           if("C".equals(caverna[i][j-1])){
                int aux;
                aux= cacador.getVida();
                cacador.setVida(aux-1000);
                TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                perdeu.setVisible(true);
                auxiliar.Perdeu("devorado");
            }else{
                caverna[i][j]= "*";
                caverna[i][j-1] = "W";
            }
           break;
       case 4:
           System.out.println("if 5, case 4");
           
           if(i < totalLinhas-1){
            if("C".equals(caverna[i+1][j])){
                 int aux;
                 aux= cacador.getVida();
                 cacador.setVida(aux-1000);
                 TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
                 perdeu.setVisible(true);
                 auxiliar.Perdeu("devorado");
             }else{
                 caverna[i][j]= "*";
                 caverna[i+1][j] = "W";
             }
           }
           break;
       default:
           System.out.println("if 5,def");
           NenhumaDirecao(i,j,caverna,cacador);
           break;
     }
    }
    for(int s = 0; s < totalLinhas; s++){
        for(int e = 0; e < totalColunas; e++){
            if("P".equals(CopiaCaverna[s][e]) && !"P".equals(caverna[s][e]) && !"C".equals(caverna[s][e]) && !"W".equals(caverna[s][e])){
                caverna[s][e] = "P";
            }
            else if("O".equals(CopiaCaverna[s][e]) && !"O".equals(caverna[s][e]) && !"C".equals(caverna[s][e]) && !"W".equals(caverna[s][e])){
                caverna[s][e] = "O";
            }
        }
    }
    caverna = ColocaAvisos(caverna);
}
public void NenhumaDirecao(int i, int j , String[][] caverna, Cacador cacador){
    if(i == 0){
        if("C".equals(caverna[i+1][j])){
            int aux;
            aux= cacador.getVida();
            cacador.setVida(aux-1000);
            TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
            perdeu.setVisible(true);
            auxiliar.Perdeu("devorado");
        }else{
            caverna[i][j]= "*";
            caverna[i+1][j] = "W";
        }
    }else if(i == 14){
        if("C".equals(caverna[i-1][j])){
            int aux;
            aux= cacador.getVida();
            cacador.setVida(aux-1000);
            TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
            perdeu.setVisible(true);
            auxiliar.Perdeu("devorado");
        }else{
            caverna[i][j]= "*";
            caverna[i-1][j] = "W";;
        }
    }else if(j == 0){
        if("C".equals(caverna[i][j+1])){
            int aux;
            aux= cacador.getVida();
            cacador.setVida(aux-1000);
            TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
            perdeu.setVisible(true);
            auxiliar.Perdeu("devorado");
        }else{
            caverna[i][j]= "*";
            caverna[i][j+1] = "W";
        }
    }else if(j == 14){
        if("C".equals(caverna[i][j-1])){
            int aux;
            aux= cacador.getVida();
            cacador.setVida(aux-1000);
            TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
            perdeu.setVisible(true);
            auxiliar.Perdeu("devorado");
        }else{
            caverna[i][j]= "*";
            caverna[i][j-1] = "W";
        }
        
    }else{
         if("C".equals(caverna[i-1][j])){
            int aux;
            aux= cacador.getVida();
            cacador.setVida(aux-1000);
            TelaCacadorDevorado perdeu = new TelaCacadorDevorado();
            perdeu.setVisible(true);
            auxiliar.Perdeu("devorado");
        }else{
            caverna[i][j]= "*";
            caverna[i-1][j] = "W";
        }
    }
    
}
public void VerificaOuro(int i, int j, String[][] caverna, Cacador cacador){
    
    if(i == 0){
        if("O".equals(caverna[i+1][j])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i+1][j] = cacador.getId();
            caverna[i][j]= "*";    
        }else if(j > 0 && "O".equals(caverna[i][j-1])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i][j-1] = cacador.getId();
            caverna[i][j]= "*";    
        }else if(j < 14 && "O".equals(caverna[i][j+1])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i][j+1] = cacador.getId();
            caverna[i][j]= "*";    
        }
        
    }else if(i == 14){
        if("O".equals(caverna[i-1][j])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i-1][j] = cacador.getId();
            caverna[i][j]= "*";    
        }else if(j > 0 && "O".equals(caverna[i][j-1])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i][j-1] = cacador.getId();
            caverna[i][j]= "*";    
        }else if(j < 14 && "O".equals(caverna[i][j+1])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i][j+1] = cacador.getId();
            caverna[i][j]= "*";    
        }
    }else if(j == 0){
        if("O".equals(caverna[i][j+1])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i][j+1] = cacador.getId();
            caverna[i][j]= "*";    
        }else if(i > 0 && "O".equals(caverna[i-1][j])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i-1][j] = cacador.getId();
            caverna[i][j]= "*";    
        }else if(i < 14 && "O".equals(caverna[i+1][j])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i+1][j] = cacador.getId();
            caverna[i][j]= "*";    
        }
    }else if(j == 14){
        if("O".equals(caverna[i][j-1])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i][j-1] = cacador.getId();
            caverna[i][j]= "*";    
        }else if(i > 0 && "O".equals(caverna[i-1][j])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i-1][j] = cacador.getId();
            caverna[i][j]= "*";    
        }else if(i < 14 && "O".equals(caverna[i+1][j])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i+1][j] = cacador.getId();
            caverna[i][j]= "*";    
        }
        
    }else{
        if("O".equals(caverna[i-1][j])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i-1][j] = cacador.getId();
            caverna[i][j]= "*";    
        }
        else if("O".equals(caverna[i+1][j])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i+1][j] = cacador.getId();
            caverna[i][j]= "*";    
        }else if("O".equals(caverna[i][j-1])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i][j-1] = cacador.getId();
            caverna[i][j]= "*";    
        }else if("O".equals(caverna[i][j+1])){
            int aux = cacador.getVida();
            cacador.setVida(aux+1000);
            cacador.setEncontrouOuro(true);
            caverna[i][j+1] = cacador.getId();
            caverna[i][j]= "*";    
        }
    }

 }
}
