package pessoal.meuPacote;

public class ContaSalario extends Conta{



	@Override
	public void saque(double valor) {
		saldo-=valor+0.03*valor;
	}



	@Override
	public void exibirTributo() {
		// TODO Auto-generated method stub
		
	}
}


