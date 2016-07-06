// invocado pelo angular.module('imgScanApp') e pelo próprio .run()
var imgScanApp = angular.module('imgScanApp', []); // declaração do modulo myApp

imgScanApp.controller('ImgScanControl',  ['$scope', '$http', function($scope, $http){

	$scope.submenuCelebArr = [ 
		                 { label: 'Local da Cerimônia', val: '#' },  
		           		 { label: 'Confirmar Presença', val: '#' } 
		               ];
	$scope.submenuTalesArr = [ 
	 		                 { label: 'Primeiro Beijo', val: '#' }, 
	 		                 { label: 'Sapatinho de Cristal', val: '#' }, 
	 		                 { label: 'Amados Pais', val: '#' },  
	 		                 { label: 'Padrinhos', val: '#' },  
	 		           		 { label: 'Doces Lembranças', val: '#' } 
	 		               ];
	
	$scope.menuArr = [ 
	                 { label: 'Início', val: '#' }, 
	                 { label: 'Celebração', val: '#' , submenu: $scope.submenuCelebArr},  
	           		 { label: 'Conto de Fadas', val: '#' , submenu: $scope.submenuTalesArr}, 
	           		 { label: 'Presentes', val: '#' }
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


