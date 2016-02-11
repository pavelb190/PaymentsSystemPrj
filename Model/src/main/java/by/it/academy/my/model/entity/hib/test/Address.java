package by.it.academy.my.model.entity.hib.test;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UsersAddress_test")
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	private User user;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	public Address() {}
	
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
	
	public String getCountry() {
		
		return this.country;
	}
	
	public void setCountry(final String country) {
		
		this.country = country;
	}
	
	public String getCity() {
		
		return this.city;
	}
	
	public void setCity(final String city) {
		
		this.city = city;
	}
	
	public String getPostalCode() {
		
		return this.postalCode;
	}
	
	public void setPostalCode(final String postalCode) {
		
		this.postalCode = postalCode;
	}
	
	@Override
	public String toString() {
		
		return "Address{" +
					this.id + ", " +
						"User{" +
							this.user.getName() + ", " + this.user.getEmail() +
						"} " +
						this.country + " " + this.city + " (" + this.postalCode + ")" +
				"}";
	}
	
}
