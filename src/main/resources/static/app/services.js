var module = angular.module('surveyApp.services',[]);

module.factory('Survey', ['$resource', function($resource){
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

module.factory('Stats', ['$resource', function($resource){
	return $resource('/survey/stats/:request/:id',
			{ id: '@id', request : '@request' },
			{
				emails: {
						method: 'GET',
						params: { request: '@request'},
						isArray : true },
				answers: {
					method: 'POST',
					params: { request: '@request'},
					isArray : true
				},
				survey: {
					method: 'POST',
					params: { request: '@request'}
				},
				csv: {
					method: 'POST',
					params: { request: '@request'},
					transformResponse: function (data, headersGetter) {
						var pdf;
				        if (data) {
				            pdf = new Blob([data], {
				                type: 'text/plain'
				            });
				        }
				        return {
				            response: saveAs(pdf, "dados.csv")
				        };
					}
				}			
			}
			);
}]);

