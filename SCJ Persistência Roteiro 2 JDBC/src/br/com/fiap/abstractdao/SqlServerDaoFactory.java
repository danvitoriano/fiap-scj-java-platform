package br.com.fiap.abstractdao;

public class SqlServerDaoFactory extends DaoFactory{
	@Override
	public ClientesDao getClientesDao() {
		return null;
	}
	
	@Override
	public PedidosDao getPedidosDao() {
		return null;
	}
}