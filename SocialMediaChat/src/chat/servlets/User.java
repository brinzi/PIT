package chat.servlets;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// PersistentValues
	@Id
	@GeneratedValue
	Long id;
	private String name;
	private String password;
	private String email;

	public User() {

	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

}
