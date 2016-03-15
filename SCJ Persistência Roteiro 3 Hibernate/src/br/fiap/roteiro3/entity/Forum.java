package br.fiap.roteiro3.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FORUM", schema = "forum") 
public class Forum implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id
	@Column(name = "IDFORUM")
	private int id;

	@Column(name = "ASSUNTO", length = 45) 
	private String assunto;

	@Column(name = "DESCRICAO", length = 45) 
	private String descricao;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forum") 
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public int getId() { return id;
	}

	public void setId(int id) {
		this.id = id; 
	}

	public String getAssunto() { return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto; 
	}

	public String getDescricao() { return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao; 
	}

	public Set<Usuario> getUsuarios() { 
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios; 
	}
}