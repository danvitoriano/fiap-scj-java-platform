package br.com.fiap.abstractdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class MySQLClientesDao implements ClientesDao{

	Connection cn = null;
	PreparedStatement stmt;
	ResultSet rs = null;

	@Override
	public Clientes inserirCliente(Clientes cliente) throws Exception{

		try {
			cn = MySQLDaoFactory.criarConexao();
			stmt = cn.prepareStatement("INSERT INTO CLIENTES (ID, NOME, EMAIL) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome()); 
			stmt.setString(2, cliente.getEmail());
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			while (rs.next()){
				cliente.setId(rs.getInt(1));
			}
		} catch (Exception e) { 
			throw e;
		} finally { 
			cn.close();
			if (stmt != null) stmt.close();
		} 
		return cliente;
	}
	
	@Override
	public Clientes buscarCliente(int id) throws Exception{ 

		Clientes cliente = null;
		List<Pedidos> pedidos = new ArrayList<>();

		try {
			cn=MySQLDaoFactory.criarConexao();
			String sql="SELECT ID,DATA,DESCRICAO,VALOR FROM PEDIDOS WHERE ID_CLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()){
				pedidos.add(new Pedidos(rs.getDate("DATA"),rs.getString("DESCRICAO"), rs.getDouble("VALOR"),
						rs.getInt("ID"), id));
			}

			sql="SELECT NOME,EMAIL FROM CLIENTES WHERE ID=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()){
				cliente = new Clientes(rs.getString("NOME"), rs.getString("EMAIL"), pedidos);
			}

		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			stmt.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}

		return cliente;

	} 
}