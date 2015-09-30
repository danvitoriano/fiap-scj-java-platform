
public class TesteThread extends Thread {

	public void run(){
		int i=0;
		while(true){
			System.out.println(i++);
			//try {
				//sleep(1000);
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
		}
	}
	
}
