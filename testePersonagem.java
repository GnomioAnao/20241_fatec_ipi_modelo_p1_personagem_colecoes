import java.util.Random;
public class testePersonagem{
    public static void main (String[] args){
        Personagem p = new Personagem(0, 5, 5);
        p.nome = "Messi";
        
        var gerador = new Random();

        while(true){
            int fazer = gerador.nextInt(4);
            switch(fazer){
                default:
                    p.cacar();
                    break;
                case 1:
                    p.comer();
                    break;
                case 2:
                    p.dormir();
                    break;
            }
            System.out.println(p);
            System.out.println("*****************************");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        
    }
}
