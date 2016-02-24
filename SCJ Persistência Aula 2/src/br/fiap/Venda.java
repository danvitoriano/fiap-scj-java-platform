package br.fiap;

import java.io.Serializable;

public class Venda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6069282091275299231L;
	private Cliente cliente;
	private String produto;
	private int id;
	
	
	
	public Venda() {
		super();
	}
	public Venda(Cliente cliente, String produto) {
		super();
		this.cliente = cliente;
		this.produto = produto;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	
	
}
