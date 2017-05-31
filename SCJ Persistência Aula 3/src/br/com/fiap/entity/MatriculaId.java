package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatriculaId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_MATRICULA", nullable = false)
	private int id;

	@Column(name = "CAMPUS", nullable = false)
	private String campus;

	public MatriculaId() {
	}

	public MatriculaId(int id, String campus) {
		super();
		this.id = id;
		this.campus = campus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCampus() {
		return campus;
	}
	
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	@Override 
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
	
	@Override 
	public int hashCode() {
		return super.hashCode();
	}
}

