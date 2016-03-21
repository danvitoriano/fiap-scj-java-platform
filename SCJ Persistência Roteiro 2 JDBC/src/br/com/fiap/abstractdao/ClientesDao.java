package br.com.fiap.abstractdao;

import br.com.fiap.entity.Clientes;

public interface ClientesDao {
	void inserirCliente(Clientes cliente) throws Exception;
	Clientes buscarCliente(int id) throws Exception;
}