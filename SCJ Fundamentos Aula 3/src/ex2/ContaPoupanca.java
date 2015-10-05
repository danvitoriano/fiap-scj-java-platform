package ex2;
public class ContaPoupanca extends ContaBancaria {
	
	public ContaPoupanca(String nomeCliente, String endCliente, String cpfCliente) {
		super(nomeCliente, endCliente, cpfCliente);
	}

	private int diaAniversario;

	public void saque(double valor) throws SaldoInsuficiente{
		
		if (saldo-(valor-0.10)<0){
			throw new SaldoInsuficiente("Saldo Insuficiente para o Saque.");
		}
		saldo-=valor-0.10;
	}
	

	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		ContaPoupanca conta= (ContaPoupanca) obj;
		return (conta.cpfCliente.equals(this.cpfCliente));
	}
}
