package mm.survey.webapp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mm.survey.webapp.model.Answer;
import mm.survey.webapp.model.Question;
import mm.survey.webapp.model.Survey; 
import mm.survey.webapp.repository.SurveyRepository;
 
@SpringBootApplication
public class SurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner(QuestionRepository qr){
//		
//		return args -> {
//			qr.save(new Question("a","b"));
//			qr.save(new Question("c","d"));
//			qr.save(new Question("e","f"));
//			qr.save(new Question("g","h"));
//			qr.save(new Question("i","j"));
//			qr.save(new Question("k","l"));
//			
//			qr.findAll().forEach(System.out::println);
//		}; 
//		
//	}
	
//	
//	@Bean
//	CommandLineRunner runner(SurveyRepository sr){
//		
//		return args -> {
//			Question q1 = new Question("1","1");
//			Question q2 = new Question("2","2");
//			
//			Set<Question> questions = new HashSet<Question>();
//			
//			questions.add(q1);
//			questions.add(q2);
//			
//			Set<Answer> answers = new HashSet<Answer>();
//			Answer a1 = new Answer();
//			a1.setQuestion(q1);
//			
//			Answer a2 = new Answer();
//			a2.setQuestion(q2);
//			
//			answers.add(a1);
//			answers.add(a2);
//			Survey survey = new Survey();
//			survey.setQuestions(questions);
//			survey.setAnswers(answers);
//			sr.save(survey);
//			
//			sr.findAll().forEach(System.out::println);
//			
//			
//		}; 
//		
//	}

}
