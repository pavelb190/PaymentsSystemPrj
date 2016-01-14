package by.it.academy.my.entity.application;

import by.it.academy.my.entity.Entity;

public class User extends Entity {
	
	private String name;
	private String password;
	
	public void setName(final String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public void setPassword(final String password) {
		
		this.password = password;
	}
	
	public String getPassword() {
		
		return this.password;
	}
}
