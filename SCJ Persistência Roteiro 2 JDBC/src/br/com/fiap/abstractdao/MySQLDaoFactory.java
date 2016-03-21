package br.com.fiap.abstractdao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDaoFactory extends DaoFactory{
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:8889/persistencia_aula1";

	public static Connection criarConexao() throws Exception{ 
		return DriverManager.getConnection(URL,"root","root");
	}

	@Override
	public ClientesDao getClientesDao() {
		return new MySQLClientesDao();
	}

	@Override
	public PedidosDao getPedidosDao() {
		return new MySQLPedidosDao();
	}
}