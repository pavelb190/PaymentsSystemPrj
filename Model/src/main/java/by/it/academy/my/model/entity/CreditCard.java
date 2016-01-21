package by.it.academy.my.model.entity;

public class CreditCard extends Entity {
	
	private long accountId;
	
	public void setBankAccountId(final long id) {
		
		this.accountId = id;
	}
	
	public long getBankAccountId() {
		
		return this.accountId;
	}
}
