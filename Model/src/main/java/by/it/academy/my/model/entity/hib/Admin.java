package by.it.academy.my.model.entity.hib;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Admin extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		
		return "Admin{" +
				this.getId() + ", " +
					this.getFirstName() + " " + this.getLastName() +
					"(" + this.getPassword() + ") " +
					"<" + this.getEmail() + ">" +
			"}";
	}
	
}
