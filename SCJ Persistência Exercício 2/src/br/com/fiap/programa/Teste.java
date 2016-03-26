package br.com.fiap.programa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class Teste {

	public static void main(String[] args) {
		incluirCliente();
		listarClientes();
		buscarCliente(1);
		System.exit(1);
	}
	
	
	private static void incluirCliente(){ 

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
			GenericDao<Clientes> dao = new GenericDao<>(Clientes.class);
			dao.adicionar(cliente);
			System.out.println("Cliente OK");
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void listarClientes(){ 
		GenericDao<Clientes> dao = new GenericDao<>(Clientes.class);
		List<Clientes> clientes = dao.listar(); 
		for (Clientes cliente : clientes) {
			System.out.println(cliente.getNome() + ": " + cliente.getEmail());
		}
	}

	private static void buscarCliente(Integer idCliente){ 
		GenericDao<Clientes> dao = new GenericDao<>(Clientes.class);
		Clientes f = dao.buscar(idCliente); 
		System.out.println(f.getNome() + ": " + f.getEmail());
	} 

}