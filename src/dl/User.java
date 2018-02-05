package dl;
// Generated 22-oct-2017 13:17:01 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT s FROM User s"),
	@NamedQuery(name="User.findLogin", query="SELECT s FROM User s WHERE s.login= :login"),
	@NamedQuery(name="User.findEmail", query="SELECT s FROM User s WHERE s.email= :email"),
	@NamedQuery(name="User.findAllLoginPrefix", query="SELECT s FROM User s WHERE s.login LIKE :loginPrefix")	
})
@Table(name = "User")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String login;
	private String name;
	private String email;
	private String password;
	private Set<Forum> forums = new HashSet<Forum>(0);

	public User() {
	}

	public User(String login, String name, String email, String password) {
		this.login = login;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(String login, String name, String email, String password, Set<Forum> forums) {
		this.login = login;
		this.name = name;
		this.email = email;
		this.password = password;
		this.forums = forums;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "login", nullable = false)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
	public Set<Forum> getForums() {
		return this.forums;
	}

	public void setForums(Set<Forum> forums) {
		this.forums = forums;
	}

}