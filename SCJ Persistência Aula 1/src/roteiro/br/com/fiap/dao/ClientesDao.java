package roteiro.br.com.fiap.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import roteiro.br.com.fiap.entity.Clientes;
import roteiro.br.com.fiap.entity.Pedidos;

public class ClientesDao extends Dao {

	public Clientes incluirCliente(Clientes cliente) throws SQLException {
		abrirConexao();

		String sql="INSERT INTO CLIENTES (NOME,EMAIL) VALUES (?,?)";
		stmt = cn.prepareStatement(sql);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEmail());
		stmt.execute();
		
		sql="SELECT LAST_INSERT_ID()";
		stmt = cn.prepareStatement(sql);
		rs = stmt.executeQuery();
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

		fecharConexao();

		return cliente;
	}

}
