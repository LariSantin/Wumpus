package wumpus;

public class Auxiliar {
    String aux;
    
 public void Ganhou(){
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("       O CAÇADOR ENCONTROU O OURO! ");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
          
    }
    public void Perdeu(String status){
     if("devorado".equals(status)){
         System.out.println("═════════════════════════");
         System.out.println("   O CAÇADOR FOI DEVORADO PELO WUMPUS");
         System.out.println("═════════════════════════");
     }   
     else{
         System.out.println("═════════════════════════");
         System.out.println("     O CAÇADOR CAIU EM UM BURACO   ");
         System.out.println("═════════════════════════");
     }
    }

 public void impressao(int totalLinhas,int totalColunas,String[][] caverna){
        
        System.out.println("Caverna:");
        for(int i = 0; i < totalLinhas; i++)
        {
            System.out.print("|");
            for(int j = 0; j < totalColunas; j++)
            {
                if("*".equals(caverna[i][j]))
                {
                     System.out.print(" " + " | ");
                }
                else{
                     System.out.print(caverna[i][j] + " | ");
                }
            }
            System.out.println("");            
        }
    }

}