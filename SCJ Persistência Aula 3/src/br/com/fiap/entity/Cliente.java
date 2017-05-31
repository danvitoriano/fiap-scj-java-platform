package br.com.fiap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


//MYSQL NÃO TEM GERADORES
//@SequenceGenerator(name="cliente", sequenceName="SEQ_CLIENTE",  allocationSize=1)
@Entity
@Table(name="TAB_CLIENTE")
public class Cliente {
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_CLIENTE")
	private int id;
	
	@Transient 
	private int chaveAcesso;
	
	@Temporal(value=TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="NOM_CLIENTE", nullable=false)
	private String nome;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getChaveAcesso() {
		return chaveAcesso;
	}
	
	public void setChaveAcesso(int chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	
} 
