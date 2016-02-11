package by.it.academy.my.model.entity.hib;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("2")
public class Client extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	/*
	@JoinTable(
			name = "BankAccounts",
			joinColumns = { @JoinColumn(name = "id") },
			inverseJoinColumns = { @JoinColumn(name = "user_id") }
		)
	*/
	private Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
	
	public Set<BankAccount> getBankAccounts() {
		
		return this.bankAccounts;
	}
	
	public void setBankAccounts(final Set<BankAccount> bankAccounts) {
		
		this.bankAccounts = bankAccounts;
	}
	
	@Override
	public String toString() {
		
		return "Client{" +
					this.getId() + ", " +
						this.getFirstName() + " " + this.getLastName() +
						"(" + this.getPassword() + ") " +
						"<" + this.getEmail() + "> " +
							"BankAccounts(" + this.bankAccounts.size() + ")" +
				"}";
	}
}
