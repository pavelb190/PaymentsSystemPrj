package by.it.academy.my.model.entity;

import java.util.HashSet;
import java.util.Set;

public class BankAccount extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private double balance;
	
	private boolean isAvailable;
	
	private Set<CreditCard> creditCards = new HashSet<>();
	
	public void setUser(User user) {
		
		this.user = user;
	}
	
	public User getUser() {
		
		return this.user;
	}
	
	public void setBalance(final double balance) {
		
		this.balance = balance;
	}
	
	public double getBalance() {
		
		return this.balance;
	}
	
	public void setAvailable(final boolean isAvailable) {
		
		this.isAvailable = isAvailable;
	}
	
	public boolean isAvailable() {
		
		return this.isAvailable;
	}
	
	public void setCreditCards(Set<CreditCard> creditCards) {
		
		this.creditCards = creditCards;
	}
	
	public Set<CreditCard> getCreditCards() {
		
		return this.creditCards;
	}
}
