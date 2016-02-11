package by.it.academy.my.domain.mysql.service.hibernate.application;

import java.io.Serializable;

import by.it.academy.my.model.entity.hib.User;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String password;
	
	public UserDto() {}
	
	public UserDto(final long id, final String password) {
		
		this.id = id;
		
		this.password = password;
	}
	
	public UserDto(User user) {
		
		this.id = user.getId();
		
		this.password = user.getPassword();
	}
	
	public long getId() {
		
		return this.id;
	}
	
	public void setId(final long id) {
		
		this.id = id;
	}
	
	public String getPassword() {
		
		return this.password;
	}
	
	public void setPassword(final String password) {
		
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		return "UserDto{" +
					this.id + ", " +
						this.password +
				"}";
	}
	
}
