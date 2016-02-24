package roteiro.br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	private String url="jdbc:mysql://localhost:8889/persistencia_aula1";
	
	protected void abrirConexao() throws SQLException{
		cn = DriverManager.getConnection(url,"root","root");
	}
	
	protected void fecharConexao() throws SQLException{
		cn.close();
		if (stmt != null) stmt.close();
	}
	
	

}
