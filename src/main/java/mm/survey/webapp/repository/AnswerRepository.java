package mm.survey.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import mm.survey.webapp.model.Answer;

@Component
public interface AnswerRepository extends JpaRepository<Answer, Long>{
	
}
