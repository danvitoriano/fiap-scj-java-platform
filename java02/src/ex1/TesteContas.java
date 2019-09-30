package ex1;

public class TesteContas {

	public static void main(String[] args) {
		
		ContaEspecial conta = new ContaEspecial();
		conta.deposita(100);
		System.out.println(conta.getSaldo());
		conta.saque(10);
		System.out.println(conta.getSaldo());

	}

}
