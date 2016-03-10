package core;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class NFItemEntity {
	@ManyToOne 
	@JoinColumn(name="COD_NF")
	private NFEntity nf;

}
