angular
//	.module('surveyApp', ['ui.bootstrap','ui.router','ngResource','surveyApp.controllers', 'surveyApp.services'])
	.module('surveyApp', ['ngResource','ui.router', 'surveyApp.controllers', 'surveyApp.services'])


.config(function($stateProvider, $urlRouterProvider) {
	
	$stateProvider
	
		.state('survey', {
			url : '/survey',
	        templateUrl : 'views/survey.html',
	        controller : 'SurveyController'
	    })
	    
	     .state('survey.setup', {
        	url : '/setup',
            templateUrl : 'views/setup.html'
        })

        .state('survey.participant', {
        	url : '/participant',
            templateUrl : 'views/participant.html'
        })

        .state('survey.question', {
        	url : '/question',
            templateUrl : 'views/question.html'
        })
        .state('survey.endblock', {
        	url : '/endblock',
        	templateUrl : 'views/endblock.html'
        })
         .state('survey.end', {
        	url : '/end',
            templateUrl : 'views/thankyou.html'
        })
        ;
	$urlRouterProvider.otherwise('/survey/setup');

})
;