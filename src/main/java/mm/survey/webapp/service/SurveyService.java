package mm.survey.webapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mm.survey.webapp.model.Answer;
import mm.survey.webapp.model.Participant;
import mm.survey.webapp.model.Question;
import mm.survey.webapp.model.Stats;
import mm.survey.webapp.model.Survey;
import mm.survey.webapp.repository.QuestionRepository;
import mm.survey.webapp.repository.SurveyRepository;

@Component
public class SurveyService {

	@Autowired
	SurveyRepository repository;

	@Autowired
	QuestionRepository questionRepository;
	
	public Survey generateNewSurvey(int list){
		Survey survey = new Survey();
		Set<Question> questions = questionRepository.findByListOrderById(list);
		survey.setQuestions(questions);
		//survey.setStartDate(LocalDateTime.now());
		repository.saveAndFlush(survey);
		return survey;
	}

	public Survey saveSurvey(int id, Survey survey) {
		//survey.setEndDate(LocalDateTime.now());
		avoidDuplicateParticipants(survey.getParticipant().getEmail());
		return repository.saveAndFlush(survey);
	}
	
	public void avoidDuplicateParticipants(String email) {
		Survey survey = repository.findByParticipantEmail(email);
		if(survey != null){
			Participant participant = survey.getParticipant();
			String existingParticipantEmail = participant.getEmail();
			participant.setEmail(existingParticipantEmail + LocalDateTime.now());
		}
	}
	
	public List<Survey> getSurvey(){
		return repository.findAll();
	}
	
	public Stats generateSurveyStats(){
		long total = repository.count();
		
		List<String> emails = repository.findAll().stream()
										.map(survey -> Long.toString(survey.getId()))
										.collect(Collectors.toList());
		
		Stats stats = new Stats();
		stats.setTotal((int) total);
		stats.setEmails(emails);
		
		return stats;
	}

	public List<String> getParticipantsEmails() {
		
		List<String> emails = new ArrayList<String>();
		List<Survey> surveys = repository.findAll();
		
		for (Survey survey : surveys) {
			if(survey.getParticipant() != null){
				emails.add(survey.getParticipant().getEmail());
			}
		}
		
		return emails;
	}

	public List<Answer> getAnswersByEmail(String email) {
		Survey survey = repository.findByParticipantEmail(email);
		List<Answer> answers = survey.getAnswers();
		
		Comparator<Answer> byId =
				(Answer o1, Answer o2)->o1.getQuestion().getId().compareTo(o2.getQuestion().getId());
		answers.sort(byId);
		//Survey survey = repository.findAll().stream().map(survey)
		return answers;
	}
	
	public Survey getSurveyByEmail(String email) {
		Survey survey = repository.findByParticipantEmail(email);
		//List<Answer> answers = survey.getAnswers();
		
//		Comparator<Answer> byId =
//				(Answer o1, Answer o2)->o1.getQuestion().getId().compareTo(o2.getQuestion().getId());
//		answers.sort(byId);
		//Survey survey = repository.findAll().stream().map(survey)
		return survey;
	}
	
}
