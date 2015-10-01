public class BinarioDecimal {

	public static void main(String[] args) {

		int valor=12;
		int quociente;
		int resto;
		
		quociente=valor/2;
		resto=valor%2;
		System.out.println(resto);
		String respost="";
		while (quociente>0){
			resto=quociente%2;
			quociente=quociente/2;
			respost=String.valueOf(resto)+respost;
			System.out.println(resto);
		}
		respost=String.valueOf(resto)+respost;
		System.out.println(respost);
		
		 String bin = Integer.toString(valor, 2);  
		 System.out.println(bin);
	}
}