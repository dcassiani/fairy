<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0-rc.2/angular.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script>
	angular.module('myApp');
</script>
</head>

<body>

	<div ng-app="myApp">

		<h1>Hello {{ world }}!</h1>

		<h1 ng-controller="NameController">Hello {{ name }}!</h1>


	</div>

	<div>Fernanda & Daniel</div>

	<div>Lista de Presentes</div>

	<div>Padrinhos</div>

	<div>Data & Local</div>

	<div>
		<ul>
			<li>Confirme sua Presença</li>
			<li>GET convite/lista</li>
			<li>PUT convite/{id}/confirmacao/{status}</li>
		</ul>
	</div>

	<div>Back Office: Envio e Confirmação de Convites</div>

	<div>Back Office: Criação de Lista e Monitoração de Presentes</div>

</body>
</html>
