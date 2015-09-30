package pessoal.meuPacote;

public abstract class Conta implements Tributacao{

	protected double saldo;
	protected Cliente cliente;

	public abstract void saque(double valor);
	
	public void exibirSaldo(){
		System.out.println(saldo);
	}

}
