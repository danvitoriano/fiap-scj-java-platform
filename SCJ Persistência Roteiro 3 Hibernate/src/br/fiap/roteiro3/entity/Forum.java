package br.fiap.roteiro3.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="FORUM") 
public class Forum implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDFORUM")
	private int id;

	@Column(name = "ASSUNTO", length = 45) 
	private String assunto;

	@Column(name = "DESCRICAO", length = 45) 
	private String descricao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "forum", orphanRemoval = true) 
	@Column(name = "IDUSUARIO")
	private List<Usuario> usuarios;

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

	public List<Usuario> getUsuarios() { 
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios; 
	}
}