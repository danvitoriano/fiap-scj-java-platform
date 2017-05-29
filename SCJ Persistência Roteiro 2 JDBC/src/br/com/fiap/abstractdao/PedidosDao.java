package br.com.fiap.abstractdao;

import java.util.List;

import br.com.fiap.entity.Pedidos;

public interface PedidosDao {
	Pedidos incluirPedido(Pedidos pedido) throws Exception; 
	List<Pedidos> listarPedidos(int idCliente) throws Exception;
}