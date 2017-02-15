<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>EDIT Employee</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body class="container-fluid">
	<div class="page-header">
		<h1>Edicion del contacto ${contact.name}</h1>
	</div>	
	<form method="POST" action="/edit" class="form">
		<table>
			<tr>
				<th><label style="visibility:hidden;display: none">ID</label></th>
				<th><label>Nombre</label></th>
				<th><label>Email</label></th>
				<th><label>Direccion</label></th>
				<th><label>Telefono</label></th>
			</tr>
			<tr>
				<td><input type="text" name="id" value="${contact.id}" style="visibility:hidden;display: none"></td>
				<td><input type="text" name="name" value="${contact.name}" autofocus="autofocus" required></td>
				<td><input type="text" name="email" value="${contact.email}" required></td>
				<td><input type="text" name="address" value="${contact.address}" required></td>
				<td><input type="text" name="telephone" value="${contact.telephone}" required></td>
			</tr>
		</table>
		<br>
		<input type="submit" name="enviar" value="Editar" class="btn btn-info">
	</form>
	<button onclick="location.href='/employee'" class="btn btn-danger">Volver</button>
</body>
</html>