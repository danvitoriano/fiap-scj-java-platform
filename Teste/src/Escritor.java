public class Escritor extends Thread {
  private String nome;  
  public Escritor(String nome, int prioridade) {
    this.nome = nome;
    this.setPriority(prioridade);   
  }  
  public void run() {
    int i = 0;
    
    while(i++ < 5) {
      System.out.println(nome + " prioridade: "  + this.getPriority());
      yield();
    }
  }
}
