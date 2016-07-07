<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Be My Princess...</title>
<link rel="shortcut icon" href="favicon.ico">
<link href="style-forms.css" rel="stylesheet" type="text/css" media="print"/>
<link rel="stylesheet" href="css/mod-core-html.css">
<link rel="stylesheet" href="css/menu-head.css">
<link rel="stylesheet" href="css/media-mobile.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="js/angular-1.2.0-rc.2/angular.js"></script>
<script type="text/javascript" src="js/fairy.js" charset="UTF-8"></script>
<script>
	angular.module('imgScanApp');
</script>
<style type="text/css">
/*
http://www.color-hex.com/color-palette/2338
	#efff72 yellow
	#ff9c15 orange
	#189eff blue
	#130606 black
	#ee009f	pink
*/


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
	    margin-left: 5px;
	    margin-right: 5px;
	    margin-bottom: 0px;
	    margin-top: 0px;
	    padding: 0;
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




</style>

</head>
<body ng-app="imgScanApp" ng-controller="ImgScanControl" ng-jq>

<div id="mainHead">

	<div id="logo">
		<button class="menu"  ng-click="changeClass()">
			<img alt="Menu" src="images/menu.svg">
		</button>
	</div>

	<div id="menu" ng-class="subItemVisibility">
		
	    <ul ng-repeat="item in menuArr">
          <li >
          	<button ng-click="item.submenu==null && linkTo(item.val)">
          		<i ng-show="item.icon != null"  class="material-icons md-24">{{ item.icon }}</i>
          		{{ item.label }}
          	</button>
          	
          	<span ng-show="item.submenu != null" class="submenu">
          		<br />
	          	<ul>
	          		<li ng-repeat="subitem in item.submenu">

	          				<button ng-click="linkTo(subitem.val)">
	          					<i ng-show="subitem.icon != null"  class="material-icons md-24">{{ subitem.icon }}</i>						
								{{ subitem.label }}
							</button>
	          		
	          		</li>
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