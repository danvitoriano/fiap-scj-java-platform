package pessoal.meuPacote;
public class MainRunnable {
	public static void main(String[] args) {
		RunnableExemplo runnableExemplo=new RunnableExemplo();
		Thread thread=new Thread(runnableExemplo);
		thread.start();
	}
}