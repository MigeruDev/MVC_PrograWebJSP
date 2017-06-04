<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<title>Personas</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">	
	<script type="text/javascript" src="script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="script/bootstrap.min.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body>
	<header>
		<div class="container">
			<div class="imgwrapper">
				<img src="img/ucuenca.png" class="img-responsive">
			</div>
		</div>		
	</header>
	<section>
		<div class="container">
			<form action="ControllerServlet" method="post">
				<fieldset class="form-group">
					<legend>Inicio de Sesión</legend>
					<div class="form-group">
						<label for="cuenta">Cuenta:</label>
						<input type="text" class="form-control" name="cuenta">
					</div>
					<div class="form-group">
						<label for="pwd">Contraseña:</label>
						<input type="password" class="form-control" name="pwd">
					</div>
					<center>
						<button type="submit" class="btn btn-primary">Aceptar</button>
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
