// invocado pelo angular.module('myApp') e pelo próprio .run()
angular.module('myApp', []) // declaração do modulo myApp
	.controller('NameController',
		function($scope) {
			$scope.name = "Ari";
		}
	);

angular.module('myApp') // uso da instância do módulo myApp
	.run(function($rootScope) {
		$rootScope.world = "World";
	});


// invocado pelo ng-controller="ClockController"		
function ClockController($scope) {
	
	$scope.clock = new Date();
	
	var updateClock = function() {
		$scope.clock = new Date();
	};
	
	setInterval(function() {
		$scope.$apply(updateClock);
	}, 1000);

	updateClock();

};