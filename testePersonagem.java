import java.util.Random;
public class testePersonagem{
    public static void main (String[] args){
        Personagem p = new Personagem();
        Personagem p2 = new Personagem(7, 0, 0);
        p.nome = "Nishida";
        p2.nome = "Elon Musk";
        
        var gerador = new Random();

        while(true){
            int fazer = gerador.nextInt(4);
            switch(fazer){
                default:
                    p.cacar();
                    p2.dormir();
                    break;
                case 1:
                    p.comer();
                    p2.cacar();
                    break;
                case 2:
                    p.dormir();
                    p2.comer();
                    break;
            }
            System.out.println(p);
            System.out.println(p2);
            System.out.println("*****************************");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        
    }
}
