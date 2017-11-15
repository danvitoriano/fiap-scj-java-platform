package br.com.fiap.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fiap.entity.Pedidos;

public class PedidosDao extends Dao {
	
	public Pedidos incluirPedido(Pedidos pedido) throws SQLException {
		abrirConexao();
		
		String sql="INSERT INTO PEDIDOS (IDCLIENTE,DATA,DESCRICAO,VALOR) VALUES (?,?,?,?)";
		stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, pedido.getIdCliente());
		stmt.setDate(2, new Date(pedido.getData().getTime()));
		stmt.setString(3, pedido.getDescricao());
		stmt.setDouble(4, pedido.getValor());
		stmt.execute();
		
		//Chave gerada (Identity Keys)
		rs = stmt.getGeneratedKeys();
		if (rs.next()){
			pedido.setId(rs.getInt(1));
		}
		fecharConexao();
		return pedido;
	}
	
	public Pedidos buscarPedido(int id) throws SQLException{
		Pedidos pedido = null;
		abrirConexao();
		
		String sql="SELECT IDCLIENTE,DATA,DESCRICAO,VALOR FROM PEDIDOS WHERE IDPEDIDO=?";
		stmt = cn.prepareStatement(sql);
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if (rs.next()){
			pedido=new Pedidos(rs.getDate("DATA"),rs.getString("DESCRICAO"), rs.getDouble("VALOR"),
					id, rs.getInt("IDCLIENTE"));
		}
		
		fecharConexao();
		return pedido;
	}

}
