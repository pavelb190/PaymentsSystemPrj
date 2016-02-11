package by.it.academy.my.model.entity.hib;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BankAccounts")
public class BankAccount extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Client client;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "is_available")
	private boolean available;
	
	@OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CreditCard> creditCards = new HashSet<CreditCard>();
	
	public BankAccount() {}
	
	public Client getClient() {
		
		return this.client;
	}
	
	public void setClient(final Client client) {
		
		this.client = client;
	}
	
	public double getBalance() {
		
		return this.balance;
	}
	
	public void setBalance(final double balance) {
		
		this.balance = balance;
	}
	
	public boolean isAvailable() {
		
		return this.available;
	}
	
	public void setAvailable(final boolean available) {
		
		this.available = available;
	}
	
	public Set<CreditCard> getCreditCards() {
		
		return this.creditCards;
	}
	
	public void setCreditCards(final Set<CreditCard> creditCards) {
		
		this.creditCards = creditCards;
	}
	
	@Override
	public String toString() {
		
		return "BankAccount{" +
					this.getId() + " " +
						this.client + " " +
							this.balance + " " + this.available + ", " +
							"CreditCards(" + this.creditCards.size() + ")" +
				"}";
	}
	
}
