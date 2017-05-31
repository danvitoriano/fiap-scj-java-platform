package br.com.fiap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="MATRICULA")
public class Matricula {
    @EmbeddedId 
    private MatriculaId id;

    @Temporal(value=TemporalType.DATE)
    @Column(name="DATA_MATRICULA")
    private Date data;
    
    @OneToOne 
	@JoinColumn(name="COD_ALUNO")
	private Aluno aluno;

	public MatriculaId getId() {
		return id;
	}

	public void setId(MatriculaId id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
    
    
}
