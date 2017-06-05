package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

@Table(name = "FUNCIONARIO", catalog = "DBTarefa", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CODIGO_FUNCIONARIO") })

@NamedQuery(name = "Funcionario.findAll", query = "select f from Funcionario f", hints = {
		@QueryHint(name = "org.hibernate.cacheable", value = "true") })

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="func")

public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "CODIGO_FUNCIONARIO", unique = true, nullable = false, length = 10)
	private String matricula;

	@Column(name = "NOME_FUNCIONARIO", unique = true, nullable = false, length = 45)
	private String nome;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "FUNCIONARIO_TAREFA", catalog = "DBTarefa",

			joinColumns = {
					@JoinColumn(name = "FUNCIONARIO_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
							@JoinColumn(name = "TAREFA_ID", nullable = false, updatable = false) })

	private Set<Tarefa> tarefas = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(Set<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}