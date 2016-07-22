var imgScanApp = angular.module('imgScanApp', []); 

imgScanApp.controller('ImgScanControl',  ['$scope', '$http', function($scope, $http){
		
	$scope.linkTo = function (hrefSrc) {
		alert(hrefSrc)
	};

	$http({
		method:'GET', 
		url:'service/menu/main', 
		cache: false
	})
		.success(function (data, status, headers, config){
			$scope.menuArr = angular.fromJson(data);

		});
	
	$http({
		method:'GET', 
		url:'service/person/lista', 
		cache: false
	})
		.success(function (data, status, headers, config){
			$scope.prodArr = angular.fromJson(data);
			$scope.prodFilter = $scope.prodArr[0].value;
		});
	
	
	
	  $scope.subItemVisibility = "menuHide";
	  $scope.changeClass = function(){
		  var aux = this.subItemVisibility;

		  angular.forEach(angular.element(document).find("ul"), function(ele) {
							  if (ele.className  == "menuShow")
								  ele.className = "menuHide";
							});
		
	    if (aux === "menuHide")
	      this.subItemVisibility = "menuShow";
	    else
	      this.subItemVisibility = "menuHide";
	  };
	  
	  

}]);


