package ro.fabio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import ro.fabio.annotation.UniqueEmail;
import ro.fabio.annotation.UniqueUsername;

@Entity
@Table(name = "app_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1211390911627295153L;

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 3, message = "Numele trebuie sa fie mai mare de 3 caractere!")
	@Column(unique = true)
	@UniqueUsername(message = "Acest nume exista deja!")
	private String name;

	@Size(min = 1, message = "Adresa de email trebuie completata")
	@Email(message = "Adresa de email invalida!")
	@UniqueEmail(message = "Acest email exista deja!")
	private String email;

	@Size(min = 5, message = "Parola trebuie sa contina cel putin 5 caractere!")
	private String password;

	private boolean enabled;

	@ManyToMany
	@JoinTable
	private List<Role> roles;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
	private List<Licitatie> licitatii;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Oferta> oferte;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
