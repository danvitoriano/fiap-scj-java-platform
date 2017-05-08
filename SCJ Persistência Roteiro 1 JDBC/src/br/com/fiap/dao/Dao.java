package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	private String url="jdbc:mysql://localhost:3307/vendas";
	
	protected void abrirConexao() throws SQLException{
		cn = DriverManager.getConnection(url,"root","root");
	}
	
	protected void fecharConexao() throws SQLException{
		cn.close();
		if (stmt != null) stmt.close();
	}
	
	

}
