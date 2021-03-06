package dl;
// Generated 22-oct-2017 13:17:01 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Test generated by hbm2java
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Test.findAll", query="SELECT s FROM Test s")
})
@Table(name = "Test")
public class Test implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String questionES;
	private String answer1ES;
	private String answer2ES;
	private String answer3ES;
	private String answer4ES;
	private String questionEU;
	private String answer1EU;
	private String answer2EU;
	private String answer3EU;
	private String answer4EU;
	private int correctAnswer;
	private String adviceES;
	private String adviceEU;


	public Test() {
	}

	public Test(String questionES, String questionEU, String answer1ES, String answer2ES, String answer3ES, String answer4ES,
			String answer1EU, String answer2EU, String answer3EU, String answer4EU, int correctAnswer,	String adviceES, String adviceEU) {
		this.questionES = questionES;
		this.questionEU = questionEU;
		this.answer1EU = answer1EU;
		this.answer2EU = answer2EU;
		this.answer3EU = answer3EU;
		this.answer4EU = answer4EU;
		this.answer1ES = answer1ES;
		this.answer2ES = answer2ES;
		this.answer3ES = answer3ES;
		this.answer4ES = answer4ES;
		this.correctAnswer = correctAnswer;
		this.adviceEU = adviceEU;
		this.adviceES = adviceES;

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

	@Column(name = "questionES", nullable = false, length = 300)
	public String getQuestionES() {
		return this.questionES;
	}

	public void setQuestionES(String questionES) {
		this.questionES = questionES;
	}
	
	@Column(name = "questionEU", nullable = false, length = 300)
	public String getQuestionEU() {
		return this.questionEU;
	}

	public void setQuestionEU(String questionEU) {
		this.questionEU = questionEU;
	}

	@Column(name = "answer1EU", nullable = false, length = 300)
	public String getAnswer1EU() {
		return this.answer1EU;
	}

	public void setAnswer1EU(String answer1EU) {
		this.answer1EU = answer1EU;
	}

	@Column(name = "answer2EU", nullable = false, length = 300)
	public String getAnswer2EU() {
		return this.answer2EU;
	}

	public void setAnswer2EU(String answer2EU) {
		this.answer2EU = answer2EU;
	}

	@Column(name = "answer3EU", nullable = false, length = 300)
	public String getAnswer3EU() {
		return this.answer3EU;
	}

	public void setAnswer3EU(String answer3EU) {
		this.answer3EU = answer3EU;
	}

	@Column(name = "answer4EU", nullable = false, length = 300)
	public String getAnswer4EU() {
		return this.answer4EU;
	}

	public void setAnswer4EU(String answer4EU) {
		this.answer4EU = answer4EU;
	}
	
	@Column(name = "answer1ES", nullable = false, length = 300)
	public String getAnswer1ES() {
		return this.answer1ES;
	}

	public void setAnswer1ES(String answer1ES) {
		this.answer1ES = answer1ES;
	}

	@Column(name = "answer2ES", nullable = false, length = 300)
	public String getAnswer2ES() {
		return this.answer2ES;
	}

	public void setAnswer2ES(String answer2ES) {
		this.answer2ES = answer2ES;
	}

	@Column(name = "answer3ES", nullable = false, length = 300)
	public String getAnswer3ES() {
		return this.answer3ES;
	}

	public void setAnswer3ES(String answer3ES) {
		this.answer3ES = answer3ES;
	}

	@Column(name = "answer4ES", nullable = false, length = 300)
	public String getAnswer4ES() {
		return this.answer4ES;
	}

	public void setAnswer4ES(String answer4ES) {
		this.answer4ES = answer4ES;
	}

	@Column(name = "correctAnswer", nullable = false)
	public int getCorrectAnswer() {
		return this.correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Column(name = "adviceES", nullable = true, length = 300)
	public String getAdviceES() {
		return this.adviceES;
	}

	public void setAdviceES(String adviceES) {
		this.adviceES = adviceES;
	}
	
	@Column(name = "adviceEU", nullable = true, length = 300)
	public String getAdviceEU() {
		return this.adviceEU;
	}

	public void setAdviceEU(String adviceEU) {
		this.adviceEU = adviceEU;
	}

}
