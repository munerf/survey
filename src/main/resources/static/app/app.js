angular.module('surveyApp', ['ui.router','ngResource','surveyApp.controllers', 'surveyApp.services'])

.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/setup');
	
	$stateProvider
	
		.state('setup', {
			url : '/setup',
	        templateUrl : 'views/setup.html'
	    })

        .state('participant', {
        	url : '/participant',
            templateUrl : 'views/participant.html'
        })

        .state('survey', {
        	url : '/survey',
            templateUrl : 'views/question.html'
        })
        
         .state('end', {
        	url : '/end',
            templateUrl : 'views/thankyou.html'
        })
        
        ;
})
;