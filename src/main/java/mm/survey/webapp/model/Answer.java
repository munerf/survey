package mm.survey.webapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue
	private Long id;
	
	private boolean firstOptionUnknown;
	private boolean secondOptionUnknown;
	
	@ManyToOne
	private Question question;

	private String answer;
	
	public boolean isFirstOptionUnknown() {
		return firstOptionUnknown;
	}
 
	public void setFirstOptionUnknown(boolean firstOptionUnknown) {
		this.firstOptionUnknown = firstOptionUnknown;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isSecondOptionUnknown() {
		return secondOptionUnknown;
	}

	public void setSecondOptionUnknown(boolean secondOptionUnknown) {
		this.secondOptionUnknown = secondOptionUnknown;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", question=" + question + "]";
	}
	
	
}
