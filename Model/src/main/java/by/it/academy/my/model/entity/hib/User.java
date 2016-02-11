package by.it.academy.my.model.entity.hib;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role_id", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "Users")
public abstract class User extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	//@ManyToOne
	//@JoinColumn(name = "role_id")
	//private UserRole userRole;
	
	public User() {}
	
	public String getFirstName() {
		
		return this.firstName;
	}
	
	public void setFirstName(final String firstName) {
		
		this.firstName = firstName;
	}
	
	public String getLastName() {
		
		return this.lastName;
	}
	
	public void setLastName(final String lastName) {
		
		this.lastName = lastName;
	}
	
	public String getPassword() {
		
		return this.password;
	}
	
	public void setPassword(final String password) {
		
		this.password = password;
	}
	
	public String getEmail() {
		
		return this.email;
	}
	
	public void setEmail(final String email) {
		
		this.email = email;
	}
	
	/*
	public UserRole getUserRole() {
		
		return this.userRole;
	}
	*/
	
	/*
	public void setUserRole(final UserRole userRole) {
		
		this.userRole = userRole;
	}
	*/
	
	@Override
	public String toString() {
		
		return "User{" +
					this.getId() + ", " +
					this.firstName + " " + this.lastName + ", " +
						"(" + this.password + ") " +
						"<" + this.email + "> " +
					//this.userRole +
				"}";
	}
	
}
