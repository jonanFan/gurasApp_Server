package bl.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserJSON {
	
	@XmlElement
	private String login;
	@XmlElement
	private String name;
	@XmlElement
	private String email;
	@XmlElement
	private String password;
	
	public UserJSON() {
		
	}
	
	public UserJSON(String login, String name, String email, String password) {
		this.login = login;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
