import java.util.Random;
public class testePersonagem{
    public static void main (String[] args){
        Personagem p = new Personagem();
        Personagem p2 = new Personagem(7, 0, 0);
        p.nome = "Elon Musk";
        p2.nome = "Alexandre de Morais";
        
        var gerador = new Random();

        while(p.energia > 0 || p2.energia > 0){
            int fazer = gerador.nextInt(3);
            if(p.energia > 0){
                switch(fazer){
                    default:
                        p.cacar(p2);
                        break;
                    case 1:
                        p.comer();
                        break;
                    case 2:
                        p.dormir();
                        break;
                }
            System.out.println("\n" + p);

            }
            if(p2.energia > 0){
                switch(fazer){
                    default:
                        p2.dormir();
                        break;
                    case 1:
                        p2.cacar(p);
                        break;
                    case 2:
                        p2.comer();
                        break;
                }
            System.out.println("\n" + p2);
            }
        //     try {
        //       //  Thread.sleep(5000);
        //    // } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
            int ataque = gerador.nextInt(2);
            if(p.energia > 0 && p2.energia > 0){
                if(ataque == 0){
                    p.atacar(p2);
                    System.out.printf("\n \n%s atacou %s", p.nome, p2.nome);
                }

                if(ataque == 1){
                    p2.atacar(p);
                    System.out.printf("\n \n%s atacou %s", p2.nome, p.nome);
                }
            }
            System.out.println("\n*****************************");

            
        }
        
    }
}
