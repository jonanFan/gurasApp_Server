package bl.json;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class UsersJSON {
	@XmlElement	
	private int total;
	
	@XmlElement(name="user")
	private List<UserJSON> users;
	
	
	public UsersJSON()
	{
		
	}

	public UsersJSON(int total, List<UserJSON> users) {
		super();
		this.total = total;
		this.users = users;
	}

	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public List<UserJSON> getUsers() {
		return users;
	}


	public void setUsers(List<UserJSON> users) {
		this.users = users;
	}

	
}
