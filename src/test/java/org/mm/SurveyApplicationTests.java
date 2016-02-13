package org.mm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import mm.survey.webapp.SurveyApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SurveyApplication.class)
@WebAppConfiguration
public class SurveyApplicationTests {

	@Test
	public void contextLoads() {
	}

}
