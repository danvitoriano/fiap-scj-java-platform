package core;

import java.util.Collection;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class CursoEntity {

	@ManyToMany 
	@JoinTable(name="TAB_ALUNO_CURSO",joinColumns=@JoinColumn(name="COD_CURSO"),
	inverseJoinColumns=@JoinColumn(name="COD_ALUNO"))
	private Collection<AlunoEntity> alunos;

}
