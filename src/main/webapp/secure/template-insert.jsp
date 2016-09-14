<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Secure Administration</title>
<script type="text/javascript" src="../js/angular-1.2.0-rc.2/angular.js"></script>
<script type="text/javascript" src="js/app.js" charset="UTF-8"></script>
<script>
	angular.module('adminApp');
</script>

</head>
<body ng-app="adminApp" ng-controller="adminControl" ng-jq>

<table>
	<tr>
		<td>Templates no DB: </td>
		<td><select name="selTemplates" ng-model="templateFilter" 
			ng-options="template.value as template.label for template in templateArr" >
			</select>
		</td>
	</tr>
</table>

<form>
	<table>
	<tr>
		<td>Template Type NAME: </td>
		<td>
			<input type="text" ng-model="t.templateType"/>
		</td>
	</tr>
	<tr>
		<td>Imagens: </td>
		<td>
			<input type="text" ng-model="t.qtImg"/>	
		</td>
	</tr>
	<tr>
		<td>Textos: </td>
		<td>
			<input type="text" ng-model="t.qtText"/>	
		</td>
	</tr>
	<tr>
		<td>Main JSP include: </td>
		<td>
			<input type="text"  ng-model="t.layoutInclude"/>	
		</td>
	</tr>
	</table>
	<input type="button" value="save" ng-click="saveData()"/>
</form>	
</body>
</html>