package mm.survey.webapp.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Survey { 
	
	@Id
	@GeneratedValue 
	private Long id; 
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Question> questions;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Answer> answers;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime startDate;

	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime endDate;

	@OneToOne(cascade=CascadeType.ALL)
	private Participant participant;
	
	private int list;
 
	public int getList() {
		return list;
	}

	public void setList(int list) {
		this.list = list;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	} 

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", questions=" + questions + ", answers=" + answers + "]";
	}


		
}
