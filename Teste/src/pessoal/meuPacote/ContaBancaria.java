package pessoal.meuPacote;

public class ContaBancaria {

	protected double saldo;
	
	private String nomeCliente;
	private String endCliente;
	private String cpfCliente;

	public ContaBancaria(){
		
	}
	public ContaBancaria(double saldo, String nomeCliente, String endCliente, String cpfCliente) {
		super();
		this.saldo = saldo;
		this.nomeCliente = nomeCliente;
		this.endCliente = endCliente;
		this.cpfCliente = cpfCliente;
	}

	public void saque(double valor){
		saldo-=valor;
	}
	
	public void deposita(double valor){
		saldo+=valor;
	}

}
