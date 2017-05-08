package br.com.fiap.aplicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.dao.PedidosDao;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class CadastroClientes {

	public static void main(String[] args) {
	
		try {
			
			System.out.println("Cadastrando Cliente ...");
			
			ClientesDao clientes = new ClientesDao();
			PedidosDao pedidos = new PedidosDao();
			
			List<Pedidos> pedidosCliente = new ArrayList<>();
			
			Clientes cliente = new Clientes("João", "j@jose.com", pedidosCliente);
			cliente=clientes.incluirCliente(cliente);
			
			pedidosCliente.add(new Pedidos(new Date(),"Materiais Gerais", 2000,cliente.getId()));
			pedidosCliente.add(new Pedidos(new Date(),"Materiais Papelaria", 4520,cliente.getId()));
			
			for (Pedidos pedido : pedidosCliente) {
				pedido=pedidos.incluirPedido(pedido);
			}
			
			System.out.println("Cadastrando Cliente Finalizado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
