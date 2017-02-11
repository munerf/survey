angular
//	.module('surveyApp', ['ui.bootstrap','ui.router','ngResource','surveyApp.controllers', 'surveyApp.services'])
	.module('surveyApp', ['ngResource','ui.router', 'surveyApp.controllers', 'surveyApp.services', 'ui.bootstrap'])


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
        
        .state('survey.setup1', {
	        url: "/setup/:listId",
	        templateUrl: 'views/participant.html',
	        controller: function($scope, $stateParams){
	        	$scope.selected.list = $stateParams.listId;
	        }
    })

        .state('survey.participant', {
        	url : '/participant',
            templateUrl : 'views/participant.html'
        })
        
         .state('survey.instructions', {
        	url : '/instructions',
            templateUrl : 'views/instructions.html'
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
        .state('stats', {
			url : '/stats',
	        templateUrl : 'views/stats.html',
	        controller : 'StatsController'
	    })
        ;
	$urlRouterProvider.otherwise('/survey/setup');

})
;