package core;

import java.util.List;

import br.fiap.Cliente;
import br.fiap.Pessoa;
import br.fiap.Venda;

public class Main {

	public static void main(String[] args) {
		
		
		//Executar um grupo por vez pois o Helper abre apenas uma sessão, após o commit a sessão é terminada
		
		
		Cliente cliente = new Cliente("João","Rua da Graça");
		Venda venda = new Venda(cliente, "Relógio");

		VendaHelper helper = new VendaHelper();
		System.out.println(helper.salvarVenda(venda));
		
		//PessoasHelper helper = new PessoasHelper();
		
		//Salvar Pessoa
		//Pessoa p = new Pessoa();
		//p.setNome("Mário");
		//p.setApelido("Brós");
		//p.setEndereco("Saúde");
		         
		//System.out.println(helper.salvarPessoa(p));
		
		//Recuperar 1 Pessoa
		//Pessoa p = helper.getPessoa(1);
		//System.out.println(p.getApelido());

		// Listar Pessoas 	
		//List<Pessoa> pessoas = helper.getPessoas("Saúde");
		//for (Pessoa pessoa : pessoas) {
		//	System.out.println(pessoa.getApelido());
		//}
		
		//pessoas = helper.getPessoas("Saúde");
		//for (Pessoa pessoa : pessoas) {
		//	System.out.println(pessoa.getApelido());
		//}
		//Remover Pessoas
		//helper.removerPessoa("Sé");
	}

}
