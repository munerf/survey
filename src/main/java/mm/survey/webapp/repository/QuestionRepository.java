package mm.survey.webapp.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import mm.survey.webapp.model.Question;

@Component
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	Set<Question> findByList(int list);
	
}