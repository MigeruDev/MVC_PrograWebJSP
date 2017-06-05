<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Personas</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/viewPersona.css">	
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
				<a href="#" type="button" class="btn btn-info">Listar Personas</a>
			</center>					
		</div>
		<div id="info" class="container-fluid">
			<%@page import="Model.DAO.PersonaDAO, Model.VO.*,java.util.*"%>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			
			<%
			List<PersonaVO> list = PersonaDAO.getAllRecords();
			request.setAttribute("list", list);
			%>
			<!-- librerías para generar reportes -->
			<script type="text/javascript" src="librerias/1.js"></script>
			<script type="text/javascript" src="librerias/2.js"></script>
			<script type="text/javascript" src="librerias/3.js"></script>
			<script type="text/javascript" src="librerias/4.js"></script>
			<script type="text/javascript" src="librerias/5.js"></script>
			<script type="text/javascript" src="librerias/6.js"></script>
			<script type="text/javascript" src="librerias/7.js"></script>
			<script type="text/javascript" src="librerias/8.js"></script>
			<script type="text/javascript" src="librerias/9.js"></script>


			<script type="text/javascript">$(document).ready(function() {
				$('#tablaPersonas').DataTable( {
					dom: 'Bfrtip',
					buttons: [
					'copy', 'excel', 'pdf', 'print'
					]
				} );
			} );</script>

			<!-- Fin de código para generar reportes -->
			<table class="table table-striped" id="tablaPersonas">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Edad</th>
						<th class="text-center">Modificar</th>
						<th class="text-center">Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="persona">
					<tr>
						<td>${persona.getId()}</td>
						<td>${persona.getNombre()}</td>
						<td>${persona.getApellido()}</td>
						<td>${persona.getEdad()}</td>
						<td class="text-center">
							<a class='btn btn-info btn-xs' href="editPersona.jsp?id=${persona.getId()}"><span class="glyphicon glyphicon-edit"></span></a>
						</td>
						<td class="text-center">
							<a class='btn btn-danger btn-xs' href="deletePersonaDB.jsp?id=${persona.getId()}"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>


	</div>
</section>
<footer>
	<p>© 2017<a style="color:#0a93a6; 
		text-decoration:none;" href="#" > Jaramillo & Macías</a>, All rights reserved 2017-2018.</p>
	</footer>
</body>
</html>