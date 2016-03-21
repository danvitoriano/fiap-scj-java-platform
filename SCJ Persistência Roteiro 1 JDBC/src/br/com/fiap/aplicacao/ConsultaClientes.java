package br.com.fiap.aplicacao;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.dao.PedidosDao;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class ConsultaClientes {

	public static void main(String[] args) {
	
		try {
			
			System.out.println("Consultando Cliente ...");
			
			ClientesDao clientes = new ClientesDao();
			PedidosDao pedidos = new PedidosDao();
		
			Clientes cliente = clientes.buscarCliente(7);
			
			System.out.println("Cliente "+cliente.getNome()+" "+cliente.getEmail());
			
			for (Pedidos pedido : cliente.getPedidos()) {
				System.out.println(pedido.getDescricao()+" "+pedido.getValor()+" "+pedido.getData());
			}
			
			System.out.println("Consultando Cliente Finalizado!");
			System.out.println("Consultando Pedidos ...");
			Pedidos pedido = pedidos.buscarPedido(7);
			System.out.println(pedido.getDescricao()+" "+pedido.getValor()+" "+pedido.getData());
			System.out.println("Consultando Pedidos Finalizado!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
