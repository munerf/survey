package mm.survey.webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstChoice;

	private String secondChoice;
	
	private int list;
	
	public int getList() {
		return list; 
	}

	public void setList(int list) {
		this.list = list;
	}

	public Question() {
		super();
	}

	public Question(String firstChoice, String secondChoice) {
		super();
		this.firstChoice = firstChoice;
		this.secondChoice = secondChoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstChoice() {
		return firstChoice;
	}
	
	public void setFirstChoice(String firstChoice) {
		this.firstChoice = firstChoice;
	}
	
	public String getSecondChoice() {
		return secondChoice;
	}
	
	public void setSecondChoice(String secondChoice) {
		this.secondChoice = secondChoice;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", firstChoice=" + firstChoice + ", secondChoice=" + secondChoice + "]";
	}
	
}
