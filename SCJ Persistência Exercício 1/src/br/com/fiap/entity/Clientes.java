package br.com.fiap.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CLIENTES", catalog="DBExercicio1", uniqueConstraints =
{
		@UniqueConstraint(columnNames="IDCLIENTE")
})

public class Clientes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="IDCLIENTE", unique=true, nullable=false) 
	private int idCliente;
	@Column(name="NOME", unique=true, nullable=false, length=45) 
	private String nome;
	@Column(name="EMAIL", unique=true, nullable=false, length=45) 
	private String email;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Pedidos> pedidos = new HashSet<Pedidos>();
		
	public Set<Pedidos> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Set<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
