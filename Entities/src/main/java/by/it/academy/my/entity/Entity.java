package by.it.academy.my.entity;

public abstract class Entity {
	
	private long id;
	
	public void setId(long id) {
		
		this.id = id;
	}
	
	public long getId() {
		
		return this.id;
	}
}