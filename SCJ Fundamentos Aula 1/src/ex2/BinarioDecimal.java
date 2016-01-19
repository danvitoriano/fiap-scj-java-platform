package ex2;
public class BinarioDecimal {

	public static void main(String[] args) {

		int valor=12;
		int quociente;
		int resto;
		String respost="";
		
		quociente=valor/2;
		resto=valor%2;
		System.out.println(resto);
		respost=String.valueOf(resto)+respost;
		
		while (quociente>0){
			resto=quociente%2;
			quociente=quociente/2;
			respost=String.valueOf(resto)+respost;
			System.out.println(resto);
		}

		System.out.println(respost);
		
		 String bin = Integer.toString(valor, 2);  
		 System.out.println(bin);
	}
}