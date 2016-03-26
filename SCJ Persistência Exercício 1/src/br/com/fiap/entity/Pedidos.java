package br.com.fiap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="PEDIDOS", catalog="DBExercicio1", uniqueConstraints =
{
		@UniqueConstraint(columnNames="IDPEDIDO")
})

public class Pedidos {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="IDPEDIDO", unique=true, nullable=false) 
	private int idCliente;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "IDCLIENTE") 
	private Clientes cliente;
	@Column(name="DATA", unique=true, nullable=false, length=45) 
	private Date data;
	@Column(name="DESCRICAO", unique=true, nullable=false, length=45) 
	private String descricao;
	@Column(name="VALOR", unique=true, nullable=false) 
	private double valor;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	
}
