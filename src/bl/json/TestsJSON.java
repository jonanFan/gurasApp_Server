package bl.json;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class TestsJSON {
	
	@XmlElement	
	private int total;
	
	@XmlElement(name="test")
	private List<TestJSON> tests;
	
	
	public TestsJSON()
	{
		
	}


	public TestsJSON(int total, List<TestJSON> tests) {
		super();
		this.total = total;
		this.tests = tests;
	}

	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public List<TestJSON> getTests() {
		return tests;
	}


	public void setTests(List<TestJSON> tests) {
		this.tests = tests;
	}

	
}
