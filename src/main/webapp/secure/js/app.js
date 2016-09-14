var adminApp = angular.module('adminApp', []); 

adminApp.controller('adminControl',  ['$scope', '$http', function($scope, $http){
		
	$scope.linkTo = function (hrefSrc) {
		alert(hrefSrc)
	};

	$scope.t = { templateType:'name', qtImg:1, qtText:1, layoutInclude:'jsp'};

	
	$scope.saveData = function () {
		var t = $scope.t;
		$http({
			method:'POST', 
			url:'admin/adm/template/new', 
			data: JSON.stringify(t)
		})
			.success(function (data){
				id = angular.fromJson(data);
				alert('ok ' +id);
				$scope.loadTemplateOptions();
			});
		
	};


	$scope.loadTemplateOptions = function () { 
		$http({
		method:'GET', 
		url:'admin/adm/template/options', 
		cache: false
	})
		.success(function (data, status, headers, config){
			$scope.templateArr = angular.fromJson(data);
			$scope.templateFilter = $scope.templateArr[0].value;
		});
	
	};
	
	$scope.loadTemplateOptions();
}]);


