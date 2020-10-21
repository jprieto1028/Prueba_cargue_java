<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--name space para utilizar codigo java en jsp-->


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Cliente</title>
</head>
<body>
	<h1>Actualizar Cliente</h1>
	<c:set var="cliente" value="${cliente}"></c:set>

	<form action="ClienteController" method="post">
		<input type="hidden" name="opcion" value="actualizar"> <input
			type="hidden" name="id" value="${cliente.id}">
		<table border=1>
			<tr>
				<td>Nombres:</td>
				<td><input type="text" name="Nombres" size=50 value="${cliente.nombres}"></td>
			</tr>
			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="Apellidos" size=50 value="${cliente.apellidos}"></td>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td><input type="text" name="Telefono" size=50 value="${cliente.telefono}"></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><input type="text" name="Direccion" size=50 value="${cliente.direccion}"></td>
			</tr>
			
			</table>
		<input type="Submit" value=Actualizar>
	  </form>

</body>
</html>