package br.com.fiap.programa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;
import br.com.fiap.helper.Helper;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SCJ Persistência Exercício 1");

		EntityManager em = emf.createEntityManager();
		incluirCliente(em);
		em = emf.createEntityManager();
		listarClientes(em);
		buscarCliente(em, 1);
		em.close();
		System.exit(1);
	}
	
	
	private static void incluirCliente(EntityManager em){ 
		Helper dao = new Helper(em);
		Clientes cliente = new Clientes();
		cliente.setEmail("jose.luis@empresa.com.br");
		cliente.setNome("José Luís");
		
		Pedidos pedido = new Pedidos();
		pedido.setCliente(cliente);
		pedido.setData(new Date());
		pedido.setDescricao("Materiais Diversos");
		pedido.setValor(20000);
		
		cliente.getPedidos().add(pedido);
		
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MINUTE, -10);
		
		Pedidos pedido2 = new Pedidos();
		pedido2.setCliente(cliente);
		pedido2.setData(cal.getTime());
		pedido2.setDescricao("Materiais Impressão");
		pedido2.setValor(44000);	
		
		cliente.getPedidos().add(pedido2);
		
		try {
			dao.salvar(cliente);
			System.out.println("Cliente OK"); 
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void listarClientes(EntityManager em){ 
		Helper dao = new Helper(em);
		List<Clientes> clientes = dao.listarClientes(); 
		for (Clientes cliente : clientes) {
			System.out.println(cliente.getNome() + ": " + cliente.getEmail());
		}
	}

	private static void buscarCliente(EntityManager em, Integer idCliente){ 
		Helper dao = new Helper(em);
		Clientes f = dao.buscarCliente(idCliente); 
		System.out.println(f.getNome() + ": " + f.getEmail());
	} 

}