package core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
//MYSQL NÃO TEM GERADORES
//@SequenceGenerator(name="cliente", sequenceName="SEQ_CLIENTE",  allocationSize=1)
@Table(name="TAB_CLIENTE")
public class ClienteEntity {
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COD_CLIENTE")
	private int id;
	@Column(name="NOM_CLIENTE", nullable=false)
	@Transient 
	private int chaveAcesso;
	@Temporal(value=TemporalType.DATE)
	private Date dataNascimento;
	private String nome;
	// métodos get e set
} 
