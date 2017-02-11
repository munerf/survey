var module = angular.module('surveyApp.controllers', []);

module
	.controller('SurveyController',['$scope', '$state', '$stateParams','$timeout', 'Survey', function($scope, $state, $stateParams, $timeout, Survey) {

	$scope.survey = {};
	
	$scope.currentQuestion = {};
	$scope.currentQuestionIndex = 0;
	$scope.participant = {};
	$scope.currentBlockQuestion = 0;
	$scope.survey.startDate = undefined;
	$scope.survey.endDate = undefined;
	
	$scope.selected = {
			answer : {},
			fst : false,
			snd : false,
			selectedAnswer : -1
	};
	
	$scope.start = function() {
		Survey.start({id: $scope.selected.list}, function(result){
			$scope.survey = result ? result : {};
			$scope.survey.startDate = Date.now();
			//$scope.survey.questions = $scope.survey.questions.slice(0,15);
			$scope.numberOfQuestions = $scope.survey.questions.length;
			$scope.questionsPerBlock = $scope.numberOfQuestions / 3;
			$scope.currentQuestion = $scope.survey ? $scope.survey.questions[$scope.currentQuestionIndex] : {};
			$scope.survey.answers = [];	
			
		});
	}
	
	$scope.nextQuestion = function(){
		console.log("current question index " + $scope.currentQuestionIndex);
		console.log("current question" + $scope.currentQuestion);
		console.log("current question block" + $scope.currentQuestion.block);
		console.log("number of questions" + $scope.numberOfQuestions);

		var answer = {
				question: $scope.currentQuestion, 
				answer: $scope.selected.selectedAnswer, 
				firstOptionUnknown : $scope.selected.fst, 
				secondOptionUnknown : $scope.selected.snd
		};

		$scope.currentBlockQuestion++;
		$scope.currentQuestionIndex++;
		$scope.currentQuestion = $scope.survey.questions[$scope.currentQuestionIndex];

		
		$scope.survey.answers.push(answer);
		console.log($scope.survey.answers);
		
		$scope.selected.fst = false;
		$scope.selected.snd = false;
		$scope.selected.selectedAnswer = -1;
		
		// check if current block has ended
		var endFirstBlock = ($scope.numberOfQuestions / 3);
		var endSecondBlock = (endFirstBlock * 2) ;
		
		console.log("end of first block", endFirstBlock);
		console.log("end of snd block", endSecondBlock);


		if($scope.currentQuestionIndex == endFirstBlock || $scope.currentQuestionIndex == endSecondBlock ){
			$scope.currentBlockQuestion = 0;
			$state.go('survey.endblock');
			
			$timeout(function(){
				$state.go('survey.question')
			}, 3000);
		}

	}
	
	$scope.save = function(survey){
		
		var answer = {
				question: $scope.currentQuestion, 
				answer: $scope.selected.selectedAnswer, 
				firstOptionUnknown : $scope.selected.fst, 
				secondOptionUnknown : $scope.selected.snd
		};
		
		$scope.survey.answers.push(answer);
		$scope.survey.endDate = Date.now();
		
		survey.participant = $scope.participant;
		survey.$update();
		console.log(survey);
	}

}]);



module.controller('StatsController',['$scope', '$state', 'Stats', function($scope, $state, Stats) {
	$scope.selected = {};
	$scope.emails = Stats.emails({request: 'emails'});
	$scope.survey = {};
	
//	$scope.getSurvey = function(){
//		Stats.answers({request: 'answers'}, $scope.selected.email);
//	}
	
	$scope.getSurvey = function(){
		$scope.survey = Stats.survey({request: 'survey'}, $scope.selected.email);
	}
	
	$scope.getSurveyCSV = function(){
		$scope.csv = Stats.csv({request: 'csv'}, $scope.selected.email);
	}
	
}]);
