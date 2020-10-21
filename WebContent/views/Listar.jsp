<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!--name space para utilizar codigo java en jsp-->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar clientes</title>
</head>
<body>
	<h1>Listar cliente</h1>

	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nombres</td>
			<td>Apellidos</td>
			<td>Telefono</td>
			<td>Direccion</td>
			<td>Accion</td>
		</tr>
<!--jstl para recorrer la lista utilizando un foreach y evitar los scriplets  de incrustacion de java item con el nombre de la lista desde el controller y var igual a lo que se desea cargar en este caso producto  -->
	<c:forEach var="cliente" items="${lista}">
	<tr>
			<!--se imprime del paquete model producto llamando a cada elemento de alli con la etiqueta out y el valor correspondientes -->
			
			<td> <a href="ClienteController?opcion=meditar&Id=<c:out value="${cliente.id}"></c:out>"><c:out value="${cliente.id}"></c:out></a></td>
			<td><c:out value="${cliente.nombres}"></c:out> </td>
			<td><c:out value="${cliente.apellidos}"></c:out> </td>
			<td><c:out value="${cliente.telefono}"></c:out> </td>
			<td><c:out value="${cliente.direccion}"></c:out> </td>
			
		   <td>  <a href="ClienteController?opcion=eliminar&Id=<c:out value="${cliente.id}"></c:out>">eliminar</a></td>
		</tr>
		</c:forEach>
	</table>

