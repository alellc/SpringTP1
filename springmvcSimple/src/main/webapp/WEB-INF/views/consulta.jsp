<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Employees</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<table class="table">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Direccion</th>
			<th>Email</th>
			<th>Telefono</th>
		</tr>
		<c:forEach var = "item" items="${list}" varStatus="loop">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.email}</td>
				<td>${item.address}</td>
				<td>${item.telephone}</td>
				<td>
					<button onclick="location.href='/edit/${item.id}/${item.name}/${item.email}/${item.address}/${item.telephone}'" class="btn btn-info">Editar</button>
					<button onclick="location.href='/show/${item.id}'" class="btn btn-info">Mostrar</button>
					<button onclick="location.href='/eliminar/${item.id}'" class="btn btn-danger">Borrar</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<button onclick="location.href='/add'" class="btn btn-warning" style="margin-left: 25%;">add Contacto</button>
</body>
</html>