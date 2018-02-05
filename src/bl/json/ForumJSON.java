package bl.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ForumJSON {
	
	@XmlElement
	private String login; //NO TENGO MUY CLARO QUE ESTO DEBA ESTAR AQUI...
							//IGUAL MEJOR OTRO JSON QUE TENGA COMO MIEMBRO ESTA CLASE Y EL STRING LOGIN ¿?
	@XmlElement
	private String title;
	@XmlElement
	private String question;
	@XmlElement
	private String answer;
	@XmlElement
	private String teacher;
	@XmlElement
	private int date;
	
	public ForumJSON() {
		
	}
	
	public ForumJSON(String login, String title, String question, String answer, String teacher, int date) {
		super();
		this.login = login;
		this.question = question;
		this.answer = answer;
		this.title = title;
		this.teacher = teacher;
		this.date = date;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	

}
