<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Back Office</title>
<link rel="shortcut icon" href="favicon.ico">
<link href="styles.css" rel="stylesheet" type="text/css" media="print"/>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/style-forms.css">
<script type="text/javascript" src="js/angular-1.2.0-rc.2/angular.js"></script>
<script type="text/javascript" src="js/app2.js"></script>
<script>
	angular.module('imgScanApp');
</script>
<style type="text/css">

body {
    direction: ltr;
    font-family: 'Roboto','Droid Sans',arial,sans-serif;
    font-size: 15px;
    margin: 0;
    min-width: 300px;
    overflow-x: hidden;
    overflow-y: auto;
    padding: 0;
}

@media (min-width: 575px) {
  #contentBox {
    width: 250px;
    margin-left: auto;
    margin-right: auto;
  }
}

@media (max-width: 575px) {
  #contentBox {
    width: 200px;
    margin-left: auto;
    margin-right: auto;
  }
}

#contentGrid00 {
text-align: center;
background-color: white;
}

#contentBox {
display: inline-block;
background-color: rgb(207, 216, 220);
box-shadow: 5px 5px 3px rgba(0, 0, 0, 0.2); 
margin: 8px;
}


#mainHead{
    background-color: #fb0;
    padding: 0px;
	display: table;
	box-sizing: border-box;
    position: fixed;
    width: 100%;
    font: 13px/27px Arial,sans-serif;
    direction: ltr;
    height: 50px;
    box-shadow: rgba(0, 0, 0, 0.2) 0px 2px 10px; 
}

#headWrapper{
	height: 60px; 
}

button.menu {
    background-color: transparent;
    border-style: none;
    height: 50px;
    width: 34px;
}
button img {
    height: 24px;
    width: 24px;
}

button.menu:ACTIVE{	
	background-color: rgba(255, 255, 255, 0.2)
}




#menu{
	position: absolute;
	background-color: #fb0;
    width: 20%;
    margin-left: 5px;
    margin-right: 5px;
    margin-bottom: 0px;
    margin-top: 0px;
    padding: 0;
}
.menuHide{
	display:none;
}
.menuShow{
	display:inline-block;
}




#menu ul li{
 display: block;
}
#menu ul li:hover {
    background-color: #cc9500;
}




.submenu ul{
	display: none;
}
.submenu:HOVER ul{
	display: inherit;
	position: absolute;
	background-color: #ffcf4d;
	overflow: visible;
	width: 70%;
}
.submenu ul li{
	display: block !important;
}


</style>

</head>
<body ng-app="imgScanApp" ng-controller="ImgScanControl">

<div id="mainHead">

	<div id="logo">
		<button class="menu"  ng-click="changeClass()">
			<img alt="Menu" src="images/menu.svg">
		</button>
	</div>

	<div id="menu" ng-class="class">
		
	    <ul >
	    	<li>home</li>
	    	<li>book vacation homes</li>
	    	<li>add rented car </li>
	    	<li  class="submenu">add house keeping
	    		<ul>
	    			<li>house keep</li>
	    			<li>garden</li>
	    			<li>clothes cleaning</li>
	    		</ul>
	    	</li>
	    	<li class="submenu">add vacation specials
    			<ul>
	    			<li>park tickets</li>
	    			<li>shows tickets</li>
	    			<li>restaurant reserves</li>
	    			<li>pre-shopping delivery</li>
	    			<li>personal trainer</li>
	    			<li>medical needs</li>
	    		</ul>
	    	</li>
	    	<li class="submenu">addons for special ocasions
    			<ul>
	    			<li>honeymoon decoration</li>
	    			<li>birthday</li>
	    			<li>breakfast pastries</li>
	    			<li>pre-shopping delivery</li>
	    		</ul>
	    	</li>
	     	<li>vacation tips</li>
	    	<li>contact us</li>
	    </ul>
	    <ul>
	    	<li>login/out</li>
	    	<li>vacation planner</li>
	    	<li>ask the concierge</li>
	    	<li>online chat</li>
	    </ul>

	</div>

</div>
<div id="headWrapper"></div>

<div id="contentGrid00">
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div><div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div><div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
	<div id="contentBox">
	 			<select name="selItens" ng-model="filterPaging" 
					ng-options="pagin.val as pagin.label for pagin in pagingArr" >
			  </select>
			  <select name="selProds" ng-model="prodFilter" ng-change="loadData()"
					ng-options="prod.value as prod.label for prod in prodArr" >
			  </select>
	
	
			 <p>Nome: <span ng-bind="convidado.name"></span>
			 <br>Idade: <span ng-bind="convidado.age"></span>
			 <br>Pais: <span ng-bind="convidado.country"></span>
			 <br>Path: <span ng-bind="convidado.picturePath"></span></p>
	</div>
</div>

<div id="maindFooter">

	<div id="quickLinks">
	</div>

	<div id="disclaimer">
	</div>

</div>
</body>

</html>