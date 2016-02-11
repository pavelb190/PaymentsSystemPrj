package by.it.academy.my.model.entity.hib;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CreditCards")
public class CreditCard extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private BankAccount bankAccount;
	
	public CreditCard() {}
	
	public BankAccount getBankAccount() {
		
		return this.bankAccount;
	}
	
	public void setBankAccount(final BankAccount bankAccount) {
		
		this.bankAccount = bankAccount;
	}
	
	@Override
	public String toString() {
		
		return "CreditCard{" +
					this.getId() + ", " +
						this.bankAccount +
				"}";
	}
	
}
