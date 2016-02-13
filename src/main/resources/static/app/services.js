angular.module('surveyApp.services',[]).factory('Survey', ['$resource', function($resource){
	return $resource('/survey/:id',
	{ id: '@id' },
	{
		start: {
			method: 'GET',
			params: { id: '@id'},
			isArray : false
		},
		update: {
			method : 'PUT'
		}
	});
}]);
