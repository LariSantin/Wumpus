package wumpus;

public class Cacador {
    String id;
    String[][] historico = new String[10][10];
    int vida;
    boolean flecha;
    
    /*SISTEMA DE PONTOS:::::::::::::
    +1000 se pegar o ouro
    -1000 se cair no buraco ou ser comido pelo wumpus 
    -20 pela flecha
    -1 por cada ação executada
    
    ---inf:
    a flecha é atirada de maneira aleatoria quando o caçador está em uma celula 
    que tem fedor, assim pode errar ou acerta o wumpus
    Caso acerte o wumpus emite um grito (GGGGGGG)
    */

    public Cacador() {
        this.id = "C";
        this.vida = 1000;
        this.flecha = true;
        iniciaHistorico();
    }

    public boolean isFlecha() {
        return flecha;
    }

    public void setFlecha(boolean flecha) {
        this.flecha = flecha;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void iniciaHistorico(){
       for(int i = 0; i < 10; i++){
           for(int j = 0; j < 10; j++){
               this.historico[i][j] = "*";
           }
       }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void atualizahistorico(int linha,int coluna, String elemento)
    {
        this.historico[linha][coluna]= elemento;

    }
    
    public String ElementoPosicao(int i, int j){
        return this.historico[i][j];        
    }
    
    
    public void imprimeHist(){
        for(int i = 0; i < 10; i++){
           for(int j = 0; j < 10; j++){
               System.out.print(this.historico[i][j] +" | ");
           }
            System.out.println("");
       }
    }  
}

