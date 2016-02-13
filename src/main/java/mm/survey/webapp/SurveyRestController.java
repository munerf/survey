package mm.survey.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.survey.webapp.model.Survey;
import mm.survey.webapp.service.SurveyService;

@RestController
@RequestMapping("/survey")
public class SurveyRestController {
	
	@Autowired
	public SurveyService surveyService;
	
	@RequestMapping(value = "/{list}", method = RequestMethod.GET)
	Survey startSurvey(@PathVariable int list){ 
		return surveyService.generateNewSurvey(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	Survey saveSurvey(@PathVariable int id, @RequestBody Survey survey){ 
		return surveyService.saveSurvey(id, survey);
	}
	
}
