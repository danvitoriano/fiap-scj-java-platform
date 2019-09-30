package ex4;

import java.time.LocalDate;

public class TesteContas {

	public static void main(String[] args) {
		ContaPoupanca conta1 = new ContaPoupanca("João", "R. X", "1234", LocalDate.of(1981, 1, 12), LocalDate.now());
		conta1.deposita(300000);
		
		ClassificacaoClientes.POTENCIAL.isCompatible(conta1);
		ClassificacaoClientes.MEDIO.isCompatible(conta1);
		ClassificacaoClientes.BAIXO.isCompatible(conta1);

	}

}
