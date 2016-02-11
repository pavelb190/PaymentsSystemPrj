package by.it.academy.my.model.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	public void setId(long id) {
		
		this.id = id;
	}
	
	public long getId() {
		
		return this.id;
	}
}