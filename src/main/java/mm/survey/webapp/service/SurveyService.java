package mm.survey.webapp.service;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mm.survey.webapp.model.Question;
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
		Set<Question> questions = questionRepository.findByList(list);
		survey.setQuestions(questions);
		survey.setStartDate(LocalDateTime.now());
		repository.saveAndFlush(survey);
		
		return survey;
	}

	public Survey saveSurvey(int id, Survey survey) {
		return repository.saveAndFlush(survey);
	}
	
	
}