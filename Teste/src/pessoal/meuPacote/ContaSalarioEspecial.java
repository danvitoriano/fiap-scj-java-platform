package pessoal.meuPacote;

public class ContaSalarioEspecial extends ContaSalario{



	@Override
	public void saque(double valor) {
		saldo-=valor+0.03*valor;
	}

	
}


