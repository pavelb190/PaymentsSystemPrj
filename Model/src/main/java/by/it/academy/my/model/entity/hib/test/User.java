package by.it.academy.my.model.entity.hib.test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users_test")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_pswd")
	private String password;
	
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private Address address;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Order> orders = new HashSet<Order>();
	
	public User() {}
	
	public long getId() {
		
		return this.id;
	}
	
	public void setId(final long id) {
		
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public void setName(final String name) {
		
		this.name = name;
	}
	
	public String getEmail() {
		
		return this.email;
	}
	
	public void setEmail(final String email) {
		
		this.email = email;
	}
	
	public String getPassword() {
		
		return this.password;
	}
	
	public void setPassword(final String password) {
		
		this.password = password;
	}
	
	public Address getAddress() {
		
		return this.address;
	}
	
	public void setAddress(final Address address) {
		
		this.address = address;
	}
	
	public Set<Order> getOrders() {
		
		return this.orders;
	}
	
	public void setOrders(final Set<Order> orders) {
		
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		
		return "User{" +
					this.id + ", " +
						this.name + " <" + this.email + "> (" + this.password + ") " +
						this.address + ", " +
						/*
						"Address{" +
								this.address.getCountry() + ", " +
								this.address.getCity() + " (" + this.address.getPostalCode() + ")" +
							"}" +
						*/
						this.orders.size() +
				"}";
	}
	
}
