package mm.survey.webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mm.survey.webapp.model.Answer;
import mm.survey.webapp.model.Stats;
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
	
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	Stats surveyStats(){ 
		return surveyService.generateSurveyStats();
	}
	
//	@RequestMapping(value = "/stats", method = RequestMethod.GET)
//	List<Answer> surveyStats(){ 
//		return surveyService.generateSurveyStats();
//	}

	@RequestMapping(value = "/stats/emails", method = RequestMethod.GET)
	List<String> participants(){ 
		return surveyService.getParticipantsEmails();
	}
	
	@RequestMapping(value = "/stats/answers", method = RequestMethod.POST)
	List<Answer> answers(@RequestBody String email){ 
		return surveyService.getAnswersByEmail(email);
	}
	
	@RequestMapping(value = "/stats/survey", method = RequestMethod.POST)
	Survey survey(@RequestBody String email){ 
		return surveyService.getSurveyByEmail(email);
	}
	
	@RequestMapping(value = "/stats/csv", method = RequestMethod.POST, headers="Accept=*/*", produces = "application/pdf")
	public void csv(@RequestBody String email, HttpServletResponse response) throws IOException{ 
		
		response.setContentType("application/pdf; charset=utf-8");
		response.addHeader("Content-Disposition", "attachment;filename=data.csv");

		String myString = "Hello";
	    ServletOutputStream out = response.getOutputStream();
	    out.println(myString);
	    out.flush();
	    out.close();
	}
	
}
