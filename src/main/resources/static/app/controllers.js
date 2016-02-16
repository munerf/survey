angular.module('surveyApp.controllers', []).controller('SurveyController', function($scope, Survey) {
	
	$scope.survey = {};
	
	$scope.currentQuestion = {};
	$scope.currentQuestionIndex = 0;
	$scope.participant = {};
	
	$scope.selected = {
			answer : {},
			fst : false,
			snd : false,
			selectedAnswer : -1
	};
	
	$scope.start = function() {
		Survey.start({id: $scope.selected.list}, function(result){
			$scope.survey = result ? result : {};
			$scope.survey.questions = $scope.survey.questions.slice(0,10);
			$scope.numberOfQuestions = $scope.survey.questions.length;
			$scope.currentQuestion = $scope.survey ? $scope.survey.questions[$scope.currentQuestionIndex] : {};
			$scope.survey.answers = [];	
			
		});
	}
	
	$scope.nextQuestion = function(){
	
		console.log("current question index " + $scope.currentQuestionIndex);
		console.log("current question" + $scope.currentQuestion);

		$scope.currentQuestionIndex++;
		$scope.currentQuestion = $scope.survey.questions[$scope.currentQuestionIndex];

		var answer = {
				question: $scope.currentQuestion, 
				answer: $scope.selected.selectedAnswer, 
				firstOptionUnknown : $scope.selected.fst, 
				secondOptionUnknown : $scope.selected.snd
				};
		
		$scope.survey.answers.push(answer);
		console.log($scope.survey.answers);
		
		$scope.selected.fst = false;
		$scope.selected.snd = false;
		$scope.selected.selectedAnswer = -1;

	}
	
	$scope.save = function(survey){
		survey.participant = $scope.participant;
		survey.$update();
		console.log(survey);
	}
	
});

