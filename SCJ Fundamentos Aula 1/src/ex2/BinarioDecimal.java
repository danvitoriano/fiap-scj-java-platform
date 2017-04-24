package ex2;
public class BinarioDecimal {

	public static void main(String[] args) {

		int valor=12;
		int quociente;
		int resto;
		String resposta = "";

		quociente = valor/2;
		resto = valor%2;
		System.out.println(resto);
		resposta = String.valueOf(resto)+resposta;

		while (quociente>0) {
			resto = quociente%2;
			quociente = quociente/2;
			resposta = String.valueOf(resto) + resposta;
			System.out.println(resto);
		}

		System.out.println(resposta);

		String bin = Integer.toString(valor, 2);  
		System.out.println(bin);
	}
}