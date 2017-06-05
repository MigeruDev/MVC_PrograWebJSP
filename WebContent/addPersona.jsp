<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Personas</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/addPersona.css">	
	<script type="text/javascript" src="script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="script/bootstrap.min.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body>
	<header>
		<h1>BIENVENIDO A LA INTERFAZ DE ADMINISTRADOR. V.1.5</h1>	
	</header>
	<section>
		<div id="panel">
			<center>
				<a href="addPersona.jsp" type="button" class="btn btn-success">Agregar Persona</a>
				<a href="viewPersona.jsp" type="viewPersona.jsp" class="btn btn-info">Listar Personas</a>
			</center>					
		</div>
		<div id="info" class="container-fluid">
			<form action="addPersonaDB.jsp" method="post">
				<fieldset class="form-group">
					<legend>Ingrese los datos de la Persona</legend>
					<div class="form-group">
						<label for="id">Id:</label>
						<input type="text" class="form-control" name="id">
					</div>
					<div class="form-group">
						<label for="nombre">Nombre:</label>
						<input type="text" class="form-control" name="nombre">
					</div>
					<div class="form-group">
						<label for="apellido">Apellido:</label>
						<input type="text" class="form-control" name="apellido">
					</div>
					<div class="form-group">
						<label for="edad">Edad:</label>
						<input type="number" class="form-control" name="edad">
					</div>
					<center>
						<button type="submit" class="btn btn-primary">Agregar</button>
					</center>
				</fieldset>
			</form>
		</div>
	</section>
	<footer>
		<p>© 2017<a style="color:#0a93a6; 
		text-decoration:none;" href="#" > Jaramillo & Macías</a>, All rights reserved 2017-2018.</p>
	</footer>
</body>
</html>