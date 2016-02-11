package by.it.academy.my.model.entity.hib.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UsersOrders_test")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	private User user;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "amount")
	private double amount;
	
	public Order() {}
	
	public long getId() {
		
		return this.id;
	}
	
	public void setId(final long id) {
		
		this.id = id;
	}
	
	public User getUser() {
		
		return this.user;
	}
	
	public void setUser(final User user) {
		
		this.user = user;
	}
	
	public String getItem() {
		
		return this.item;
	}
	
	public void setItem(final String item) {
		
		this.item = item;
	}
	
	public int getCount() {
		
		return this.count;
	}
	
	public void setCount(final int count) {
		
		this.count = count;
	}
	
	public double getAmount() {
		
		return this.amount;
	}
	
	public void setAmount(final double amount) {
		
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		
		return "Order{" +
					this.id + ", " +
						this.user + " " +
						this.item + " (" + this.count + ") : " + this.amount +
				"}";
	}
	
}
