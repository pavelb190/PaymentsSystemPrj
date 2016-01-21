package by.it.academy.my.model.entity;


public class UserRole extends Entity {
	
	private String role;
	
	public void setRole(final String role) {
		
		this.role = role;
	}
	
	public String getRole() {
		
		return this.role;
	}
	
	@Override
	public String toString() {
		
		return (this.getId() + " : " + this.getRole());
	}
}
