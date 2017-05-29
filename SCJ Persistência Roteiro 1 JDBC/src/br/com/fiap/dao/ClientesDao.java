package br.com.fiap.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class ClientesDao extends Dao {

	public Clientes incluirCliente(Clientes cliente) throws SQLException {
		abrirConexao();

		String sql="INSERT INTO CLIENTES (NOME,EMAIL) VALUES (?,?)";
		stmt = cn.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEmail());
		stmt.execute();
		
		//Chave gerada (Identity Keys)
		rs = stmt.getGeneratedKeys();
		if (rs.next()){
			cliente.setId(rs.getInt(1));
		}
		fecharConexao();
		return cliente;
	}

	public Clientes buscarCliente(int id) throws SQLException{
		Clientes cliente = null;
		List<Pedidos> pedidos = new ArrayList<>();

		abrirConexao();

		String sql="SELECT IDPEDIDO,DATA,DESCRICAO,VALOR FROM PEDIDOS WHERE IDCLIENTE=?";
		stmt = cn.prepareStatement(sql);
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		while (rs.next()){
			pedidos.add(new Pedidos(rs.getDate("DATA"),rs.getString("DESCRICAO"), rs.getDouble("VALOR"),
					rs.getInt("IDPEDIDO"), id));
		}
				
		sql="SELECT NOME,EMAIL FROM CLIENTES WHERE IDCLIENTE=?";
		stmt = cn.prepareStatement(sql);
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if (rs.next()){
			cliente = new Clientes(rs.getString("NOME"), rs.getString("EMAIL"), pedidos);
		}

		fecharConexao();

		return cliente;
	}
	
	//Exemplo de SQL Injection
	public Clientes buscarClienteSqlInjection(String id) throws SQLException{
		Clientes cliente = null;
		List<Pedidos> pedidos = new ArrayList<>();

		abrirConexao();

		String sql="SELECT IDPEDIDO,DATA,DESCRICAO,VALOR FROM PEDIDOS WHERE IDCLIENTE="+id;
		Statement st = cn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			pedidos.add(new Pedidos(rs.getDate("DATA"),rs.getString("DESCRICAO"), rs.getDouble("VALOR"),
					rs.getInt("IDPEDIDO"), Integer.valueOf(id)));
		}

		sql="SELECT NOME,EMAIL FROM CLIENTES WHERE IDCLIENTE="+id;
		st = cn.createStatement();
		rs = st.executeQuery(sql);
		if (rs.next()){
			cliente = new Clientes(rs.getString("NOME"), rs.getString("EMAIL"), pedidos);
		}

		fecharConexao();

		return cliente;
	}

}
