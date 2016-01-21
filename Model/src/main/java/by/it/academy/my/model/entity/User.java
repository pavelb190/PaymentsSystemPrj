package by.it.academy.my.model.entity;


public class User extends Entity {
	
	private String firstName;
	private String lastName;
	
	private String email;
	
	private UserRole userRole;
	
	private String password;
	
	public void setFirstName(final String firstName) {
		
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		
		return this.firstName;
	}
	
	public void setLastName(final String lastName) {
		
		this.lastName = lastName;
	}
	
	public String getLastName() {
		
		return this.lastName;
	}
	
	public void setEmail(final String email) {
		
		this.email = email;
	}
	
	public String getEmail() {
		
		return this.email;
	}
	
	public void setUserRole(final UserRole userRole) {
		
		this.userRole = userRole;
	}
	
	public UserRole getUserRole() {
		
		return this.userRole;
	}
	
	public void setPassword(final String password) {
		
		this.password = password;
	}
	
	public String getPassword() {
		
		return this.password;
	}
	
	@Override
	public String toString() {
		
		return (this.getId() + ": "
				+ this.getFirstName() + " " + this.getLastName()
				+ " (" + this.getEmail() + ") "
				+ " [" + this.getUserRole() + "]"
				+ " <" + this.getPassword() + ">"
			);
	}
	
}
