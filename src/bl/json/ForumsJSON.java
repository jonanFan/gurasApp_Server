package bl.json;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ForumsJSON {
	@XmlElement	
	private int total;
	
	@XmlElement(name="forum")
	private List<ForumJSON> forums;
	
	public ForumsJSON()
	{
		
	}

	public ForumsJSON(int total, List<ForumJSON> forums) {
		super();
		this.total = total;
		this.forums = forums;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<ForumJSON> getForums() {
		return forums;
	}

	public void setForums(List<ForumJSON> forums) {
		this.forums = forums;
	}

}
