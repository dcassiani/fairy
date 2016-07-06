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
/*
http://www.color-hex.com/color-palette/2338
	#efff72 yellow
	#ff9c15 orange
	#189eff blue
	#130606 black
	#ee009f	pink
*/

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

ul{
	list-style-type: none;
	padding-left:0;
}

li{
	padding-left:0;
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

#mainHead{
    background-color: #efff72;
    padding: 0px;
	display: table;
	box-sizing: border-box;
    position: fixed;
    width: 100%;
    height: 50px;
    box-shadow: rgba(0, 0, 0, 0.2) 0px 2px 10px; 
}

#headWrapper{
	height: 60px; 
}




#menu ul{
	display: inline-table;
    width: 190px;
}

#menu  * li{
    text-align: center;
}
	
#menu * button{
	font-style: italic;
	font-weight: bold;
	text-decoration: none;
	color: #ee009f;
    background-color: transparent;
    border-style: none;
    width: 100%;
    position: relative;
  	padding-top: 13px;
  	padding-bottom: 13px;
  	padding-left: 5px;
  	padding-right: 5px;
  	text-align: center;
}
	
#menu * button:HOVER{	
	background-color: #f7ffb8;
	cursor: pointer;
	
}

.submenu ul{
	background-color: #fdf99c;
	overflow: visible;
	position: absolute;
	padding: 0px;
	display: list-item !important;
}

.submenu ul li{
	display: block;
	border-bottom-width: 3px;
    border-bottom-color: #e3dd51;
    margin: 0px;
    border-bottom-style: double;
}

	.menuHide{
		visibility: hidden;
	}
	.menuShow{
		visibility: visible;
	}


.submenu span button {
    padding-top: 13px !important;
  	padding-bottom: 13px !important ;
  	padding-left: 35px !important;
  	padding-right: 5px !important;
  	position: relative;
  	
}
.submenu button svg {
    height: 24px;
    width: 24px;
    position: absolute;
	left: 6px;
	top: 50%;
	transform: translateY(-50%);
	fill: #fa3a66;
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
          	<button ng-click="changeClass()">{{ item.label }}</button>
          	
          	<span ng-show="item.submenu != null">
          		<br />
	          	<ul ng-class="subItemVisibility">
	          		<li ng-repeat="subitem in item.submenu">

	          				<button ng-click="linkTo(subitem.val)">
	          				<svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
								<path d="m6 19c0 1.1 0.9 2 2 2h8c1.1 0 2-0.9 2-2v-12h-12v12zm13-15h-3.5l-1-1h-5l-1 1h-3.5v2h14v-2z">
								<path fill="none" d="m0 0h24v24h-24z">
							</svg>								
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