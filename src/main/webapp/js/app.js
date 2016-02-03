// invocado pelo angular.module('myApp') e pelo próprio .run()
angular.module('InvitationApp', []) // declaração do modulo myApp
	.controller('InvitationController',
		function($scope) {
			$scope.name = 'name';
		}
	);

angular.module('InvitationApp') // uso da instância do módulo myApp
	.run(function($rootScope,$http) {
		memoriesService = $http({
			method: 'GET',
			url: 'fairy/memorias/2'
		});
		memoriesService.then(function(resp){
			//sucesso
			$rootScope.json = resp;
			alert('sucesso' + resp);
		}, function(resp){
			//erro
			alert('erro' + resp);
		});
	});

