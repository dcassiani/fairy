<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Back Office</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/style-forms.css">
<script type="text/javascript" src="js/angular-1.2.0-rc.2/angular.js"></script>
<script type="text/javascript" src="js/app2.js"></script>
<script>
	angular.module('imgScanApp');
</script>
<style type="text/css">

@media screen and (max-width: 600px){
    ul.sidenav {
        width:100%;
        height:auto;
        position:relative;
    }
    ul.sidenav li a {
        float: left;
        padding: 15px;
    }
    div.content {margin-left:0;}
}

@media screen and (max-width: 400px){
    ul.sidenav li a {
        text-align: center;
        float: none;
    }
}


#contentGrid00 {
clear:both;
width: 30%;
background-color: silver;
margin-left: 200px;
}

#mainHead{
margin-left: 10%;
margin-right: 10%;
width: 80%;
}

#logo{
background-color: olive;
width: 10%;
height: 100px;
float: left;
}

#menu{
width: 70%
}

#menu ul{
    margin: 0;
    padding: 0;
}

#menu ul li{
display: inline-block;
}

#menu ul li:hover {
    background-color: green;
}

.submenu ul{
display: none;
}

.submenu ul li{
display: block !important;
}

.submenu:HOVER ul{
display: inherit;
position: absolute;
background-color: yellow;
overflow: visible;
}


</style>

</head>
<body ng-app="imgScanApp" ng-controller="ImgScanControl">

<div id="mainHead">

	<div id="logo">
	</div>

	<div id="menu">
	    <ul>
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

<div id="contentGrid00">
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

<div id="maindFooter">

	<div id="quickLinks">
	</div>

	<div id="disclaimer">
	</div>

</div>
</body>

</html>