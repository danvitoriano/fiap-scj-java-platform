package br.com.fiap.programa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Item;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.StatusCliente;
import br.com.fiap.helper.VendasHelper;
import br.com.fiap.pk.PedidosPK;

public class TestaAplicacao {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SCJ Persistência Aula 5 JPA");
		EntityManager em = emf.createEntityManager();
		VendasHelper dao = new VendasHelper(em);

		try {
			//Definindo o cliente
			Cliente cliente = new Cliente(); 
			cliente.setId(10); 
			cliente.setStatus(StatusCliente.ATIVO);
			cliente.setEmpresa("Fiap");
			
			//Definindo o Endereco
			Endereco endereco = new Endereco(); 
			endereco.setRua("Lins de Vasconcelos");
			endereco.setCidade("São Paulo"); 
			endereco.setCep("01538-001");
			endereco.setCliente(cliente);
			
			//Defnindo o pedido
			PedidosPK pkpedido = new PedidosPK(); 
			pkpedido.setCodigo(100); 
			pkpedido.setCategoria("Livros");
			
			Pedido pedido = new Pedido(); 
			pedido.setDataPedido(new Date()); 
			pedido.setPedidoPK(pkpedido); 
			pedido.setCliente(cliente);
			
			//Definindo dois itens
			Item item1 = new Item();
			item1.setQuantidade(2);
			item1.setPedido(pedido);
			
			Item item2 = new Item(); 
			item2.setQuantidade(3);
			item2.setPedido(pedido);
			
			//Fazendo as associacÌ§oÌƒes
			pedido.getItens().add(item1); 
			pedido.getItens().add(item2);
			
			cliente.getEnderecos().add(endereco); 
			cliente.getPedidos().add(pedido);
			
			dao.salvar(cliente);
			
			
			System.out.println("Cliente incluído com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}
	}
}