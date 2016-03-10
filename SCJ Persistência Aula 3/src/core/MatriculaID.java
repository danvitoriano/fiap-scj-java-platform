package core;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MatriculaID implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManyToOne 
    @JoinColumn(name="COD_ALUNO")
    private Aluno aluno;
    @ManyToOne 
    @JoinColumn(name="COD_CURSO")
    private Curso curso;
    public MatriculaID(){ }
    public MatriculaID(Aluno aluno, Curso curso){
        this.aluno = aluno;
        this.curso = curso;
    }
    // get e set
    @Override 
    public boolean equals(Object arg0) {
        return super.equals(arg0);
    }
    @Override 
    public int hashCode() {
        return super.hashCode();
    }
}

