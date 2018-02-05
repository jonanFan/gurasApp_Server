package bl.json;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestJSON {
	
	@XmlElement
	private String questionES;
	@XmlElement
	private String questionEU;
	@XmlElement
	private List<String> answerES;
	@XmlElement
	private List<String> answerEU;
	@XmlElement
	private int correctAnswer;
	@XmlElement
	private String adviceEU;
	@XmlElement
	private String adviceES;
	
	public TestJSON() {
		
	}
	
	public TestJSON(String questionES, String questionEU, List<String> answerES, List<String> answerEU, int correctAnswer,
			String adviceES, String adviceEU) {
		super();
		this.questionEU = questionEU;
		this.questionES = questionES;
		this.answerES = answerES;
		this.answerEU = answerEU;
		this.correctAnswer = correctAnswer;
		this.adviceES = adviceES;
		this.adviceEU = adviceEU;

	}
	public String getQuestionES() {
		return questionES;
	}
	public void setQuestionES(String questionES) {
		this.questionES = questionES;
	}
	public String getQuestionEU() {
		return questionEU;
	}
	public void setQuestionEU(String questionEU) {
		this.questionEU = questionEU;
	}
	public List<String> getAnswerES() {
		return answerES;
	}
	public void setAnswerES(List<String> answerES) {
		this.answerES = answerES;
	}
	public List<String> getAnswerEU() {
		return answerEU;
	}
	public void setAnswerEU(List<String> answerEU) {
		this.answerEU = answerEU;
	}
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getAdviceES() {
		return adviceES;
	}
	public void setAdviceES(String adviceES) {
		this.adviceES = adviceES;
	}
	public String getAdviceEU() {
		return adviceEU;
	}
	public void setAdviceEU(String adviceEU) {
		this.adviceEU = adviceEU;
	}

	
}
