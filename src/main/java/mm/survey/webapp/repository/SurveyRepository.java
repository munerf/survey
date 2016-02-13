package mm.survey.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import mm.survey.webapp.model.Survey;

@Component
public interface SurveyRepository extends JpaRepository<Survey, Long>{

}
