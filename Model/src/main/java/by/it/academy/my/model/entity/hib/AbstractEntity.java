package by.it.academy.my.model.entity.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<PK extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private PK id;
	
	public AbstractEntity() {}
	
	public PK getId() {
		
		return this.id;
	}
	
	public void setId(final PK id) {
		
		this.id = id;
	}
	
	@Override
	public String toString() {
		
		return "{" + this.id + "}";
	}
	
}
