<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Personas</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="script/bootstrap.min.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body>
	<section>
		<div id = "panel">
			<center>
				<a href="addPersona.jsp" type="button" class="btn btn-success">Agregar Persona</a>
				<a href="viewPersona.jsp" type="button" class="btn btn-info">Listar Personas</a>
				<a href="enviarFormulario.jsp" type="button" class="btn btn-success">Enviar formulario</a>
			</center>
		</div>
		<div id = "info" class= "container-fluid">
			<form action="enviarFormularioEmail.jsp" method = "post">
				<fieldset class="form-group">
					<legend>Ingrese los datos para el envío de email</legend>
					<div class="form-group">
						<label for="correo">Correo electrónico:</label>
						<input type="text" class="form-control" name="email">
					</div>
					<div class="form-group">
						<label for="comentario">Comentarios:</label>
						<textarea class="form-control" rows="4" cols="50" name="comentario">
						</textarea>
					</div>
					<center>
						<button type="submit" class="btn btn-primary">Enviar</button>
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