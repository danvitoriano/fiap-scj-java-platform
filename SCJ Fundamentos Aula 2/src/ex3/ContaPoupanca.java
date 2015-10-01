package ex3;
public class ContaPoupanca extends ContaBancaria {
	
	public ContaPoupanca(double saldo, String nomeCliente, String endCliente, String cpfCliente) {
		super(saldo, nomeCliente, endCliente, cpfCliente);
	}

	private int diaAniversario;

	public void saque(double valor){
		saldo-=valor-0.10;
	}
}
