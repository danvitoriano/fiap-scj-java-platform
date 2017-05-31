package br.com.fiap.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class NFEntity {

	@OneToMany(cascade=CascadeType.ALL, mappedBy="nf")
	@JoinColumn(name="COD_NF")
	private Collection<NFItemEntity> itens;
}
