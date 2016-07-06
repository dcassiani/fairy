<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Be My Princess...</title>
<link rel="shortcut icon" href="favicon.ico">
<link href="styles.css" rel="stylesheet" type="text/css" media="print"/>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/style-forms.css">
<script type="text/javascript" src="js/angular-1.2.0-rc.2/angular.js"></script>
<script type="text/javascript" src="js/fairy.js" charset="UTF-8"></script>
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

@media (min-width: 600px) {
	#contentBox {
		width: 250px;
		margin-left: auto;
		margin-right: auto;
	}
	#logo{
		display:none;
	}
	#menu{
		background-color: #fb0;
	    margin-left: 5px;
	    margin-right: 5px;
	    margin-bottom: 0px;
	    margin-top: 0px;
	    padding: 0;
	}
 

	#menu ul li:hover {
	    background-color: #cc9500;
	}


}

@media (max-width: 600px) {
  #contentBox {
    width: 200px;
    margin-left: auto;
    margin-right: auto;
  }
  #menu{
    width: 90%;
    position: fixed;
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



.submenu ul{
	background-color: #ffcf4d;
	overflow: visible;
	position: absolute;
}
.submenu ul li{
	display: block;
}

	.menuHide{
		visibility: hidden;
	}
	.menuShow{
		visibility: visible;
	}

ul{
	list-style-type: none;
	display: inline-block;
}

</style>

</head>
<body ng-app="imgScanApp" ng-controller="ImgScanControl" ng-jq>

<div id="mainHead">

	<div id="logo">
		<button class="menu"  ng-click="changeClass()">
			<img alt="Menu" src="images/menu.svg">
		</button>
	</div>

	<div id="menu">
		
	    <ul ng-repeat="item in menuArr">
          <li  class="submenu">
          	<a  ng-click="changeClass()" href="{{ item.val }}">{{ item.label }}</a>
          	<span ng-show="item.submenu != null">
          		<br />
	          	<ul ng-class="subItemVisibility">
	          		<li ng-repeat="subitem in item.submenu"><a href="{{ subitem.val }}">{{ subitem.label }}</a>
	          	</ul>
          	</span>
          </li>
        </ul>

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