angular.module('surveyApp', ['ui.bootstrap','ui.router','ngResource','surveyApp.controllers', 'surveyApp.services'])

.config(function($stateProvider, $urlRouterProvider) {
	
	$stateProvider
	
		.state('survey', {
			url : '/survey',
	        templateUrl : 'views/setup.html'
	    })

        .state('survey.participant', {
        	url : '/participant',
            templateUrl : 'views/participant.html'
        })

        .state('survey.question', {
        	url : '	/question',
            templateUrl : 'views/question.html'
        })
        
         .state('survey.end', {
        	url : '/end',
            templateUrl : 'views/thankyou.html'
        })
        
          .state('survey.endblock', {
        	url : '/endblock',
            templateUrl : 'views/endblock.html'
        })
        
        ;
	$urlRouterProvider.otherwise('/survey');

})
;