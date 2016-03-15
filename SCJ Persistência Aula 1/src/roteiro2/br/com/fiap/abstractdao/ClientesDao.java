package roteiro2.br.com.fiap.abstractdao;

import roteiro1.br.com.fiap.entity.Clientes;

public interface ClientesDao {
	void inserirCliente(Clientes cliente) throws Exception;
	Clientes buscarCliente(int id) throws Exception;
}