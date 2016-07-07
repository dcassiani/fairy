// invocado pelo angular.module('imgScanApp') e pelo próprio .run()
var imgScanApp = angular.module('imgScanApp', []); // declaração do modulo myApp

imgScanApp.controller('ImgScanControl',  ['$scope', '$http', function($scope, $http){

	$scope.submenuCelebArr = [ 
		                 { label: 'Local da Cerimônia', val: '#' ,icon:'room'},  
		           		 { label: 'Confirmar Presença', val: '#' ,icon:'assignment turned in'} 
		               ];
	$scope.submenuTalesArr = [ 
	 		                 { label: 'Primeiro Beijo', val: '#' ,icon:'favorite_border'}, 
	 		                 { label: 'Sapatinho de Cristal', val: '#' ,icon:'loyalty'}, 
	 		                 { label: 'Amados Pais', val: '#' ,icon:'account_circle'},  
	 		                 { label: 'Padrinhos', val: '#' ,icon:'face'},  
	 		           		 { label: 'Doces Lembranças', val: '#' ,icon:'class'} 
	 		               ];
	
	$scope.menuArr = [ 
	                 { label: 'Era uma vez...', val: '#' ,icon:'favorite'}, 
	                 { label: 'Celebração', val: '#' , submenu: $scope.submenuCelebArr, icon:'account_balance'},  
	           		 { label: 'Conto de Fadas', val: '#' , submenu: $scope.submenuTalesArr , icon:'local_movies'}, 
	           		 { label: 'Presentes', val: '#' , icon:'card_giftcard'}
	               ];

	
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
	
		
	$scope.linkTo = function (hrefSrc) {
		alert(hrefSrc)
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


