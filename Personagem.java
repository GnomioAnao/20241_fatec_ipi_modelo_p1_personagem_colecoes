import java.util.Random;

public class Personagem{
  //variáveis de instância(objeto)
  String nome;
  int energia;
  private int fome;
  private int sono;
  String itens[] = {"energetico", "agua", "javali selvagem", "amora", "batata frita"}; 
  VetorDinamico mochila = new VetorDinamico();

  void adicionarItem(){
    var gerador = new Random();
    mochila.adicionar(itens[gerador.nextInt(5)]);

  }
  //esse é o construtor padrão
  //criado automaticamente pelo compilador, ainda que não seja escrito explicitamente
  Personagem(){
    nome = null;
    energia = 10;
    fome = 0;
    sono = 0;
    for(int i = 0; i <=3; i++){
        adicionarItem();
    }
  }

  //construtor personalizado
  //o que viabiliza a sua existência é a sobrecarga de construtores
  Personagem(int energia, int fome, int sono){
    if (energia >= 0 && energia <= 10)
      this.energia = energia;
    if (fome >= 0 && fome <= 10)
      this.fome = fome;
    if (sono >= 0 && sono <= 10)
      this.sono = sono;
    for(int i = 0; i <=3; i++){
      adicionarItem();
    }
  }


  void cacar(Personagem inimigo){
    if(energia >= 2){
      System.out.printf("\n%s esta cacando...\n", nome);
      energia -= 2; // energia = energia - 2;
    }
    else{
      System.out.printf("\n%s sem energia para cacar...\n", nome);
    }
    if(energia <= 0){
      System.out.printf("\n%s morreu por falta de energia", nome);
      if(inimigo.energia > 0){
      System.out.printf("\n%s foi o campeao do embate pelo X", inimigo.nome);
      }
    }
    fome = Math.min(fome + 1, 10);
    //resolver com o ternário
    sono = sono < 10 ? sono + 1 : sono;
  }

  void comer() {
    //se tiver fome
      //comer e reduzir o valor de fome de 1
      //aumentar o valor de energia de 1
    //caso contrario
      //so vai avisar que esta sem fome
      switch(fome){
        case 0:
          System.out.printf("\n%s sem fome....\n", nome);
          break;
          default:
          energia = (energia == 10 ? energia : energia + 1);
          if(!mochila.estaVazio()){
            System.out.printf("\n%s comendo...\n", nome);
            --fome;
            energia = (energia == 10 ? energia : energia + 1);
            mochila.removerNoFinal();
          }

      }
      
      if(fome >= 10){
        System.out.printf("\n%s morreu de fome", nome);
      }
  }

  void dormir(){
    if(sono >= 2){
      System.out.printf("\n%s esta dormindo...\n", nome);
      sono -= 1;
      energia = Math.min(energia + 1, 10);
    }
    else{
      System.out.printf("\n%s sem sono...\n", nome);
    }
    if(sono >= 10){
      System.out.printf("\n%s morreu de cansaco", nome);
  
    }
  }
  void perderEnergia(){
    energia--;
  }
  void atacar(Personagem inimigo){
    inimigo.perderEnergia();
  }

  public String toString(){
    StringBuilder sb = new StringBuilder(" ");
    sb.append( 
    String.format(
      "%s: (e:%d, f:%d, s:%d)",
      nome, energia, fome, sono
      
      )
    );
    sb.append("\n\n");
    sb.append(mochila.tamanho() > 0 ? "inventario : " : "");
    sb.append("\n");
    for(int i = 0; i < mochila.tamanho(); i++){
      sb.append(String.format("/%s/", mochila.getElementos()[i]));
    }
    return sb.toString();
  }
}