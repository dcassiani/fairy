// invocado pelo angular.module('imgScanApp') e pelo próprio .run()
var imgScanApp = angular.module('imgScanApp', []); // declaração do modulo myApp

imgScanApp.controller('ImgScanControl',  ['$scope', '$http', function($scope, $http){

	$scope.pagingArr = [ 
         { label: '15', val: '15' },  
		 { label: '50', val: '50' }, 
		 { label: '100', val: '100' }, 
		 { label: '500', val: '500' }, 
		 { label: 'Todos', val: '999999999' }
    ];
	$scope.filterPaging = $scope.pagingArr[0].val;

	$scope.loadData = function () {
		var target = $scope.prodFilter;
//		var tipo = $scope.tipoList;
		$http({
			method:'GET', 
			url:'service/person/'+target, 
			cache: false
		})
			.success(function (data){
				$scope.convidado = angular.fromJson(data);
			});
		
	};
	

	$http({
		method:'GET', 
		url:'service/person/lista', 
		cache: false
	})
		.success(function (data, status, headers, config){
			$scope.prodArr = angular.fromJson(data);
			
			$scope.prodFilter = $scope.prodArr[0].value;
			
			$scope.loadData();
			// initial Load
//			$scope.tipoList = $scope.tipoArr[0].val;
//			$scope.filtroImg = $scope.imgArr[0].val;
		});
	
	
	
	  $scope.class = "menuHide";
	  $scope.changeClass = function(){
	    if ($scope.class === "menuHide")
	      $scope.class = "menuShow";
	    else
	      $scope.class = "menuHide";
	  };

}]);


