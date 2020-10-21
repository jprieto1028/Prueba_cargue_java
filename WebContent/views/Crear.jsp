<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente</title>

</head>
<body>
	<h1>Crear Cliente</h1>

	<form action="ClienteController" method="post">
		<input type="hidden" name="opcion" value="guardar">
		
		<table border=1>
			<tr>
				<td>Nombres:</td>
				<td><input type="text" name="Nombres" size=50></td>
			</tr>
			
			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="Apellidos" size=50></td>
			</tr>
			
			<tr>
				<td>Telefono:</td>
				<td><input type="text" name="Telefono" size=50></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><input type="text" name="Direccion" size=50></td>
			</tr>
		   <tr>
			
			<td><input type="file" onchange="cargarArchivo()" name="file"/> <input type ="submit" value= "subir archivo"></td>
			
			</tr>
		
		</table>
		<input type="Submit" value=Guardar>
	</form>

</body>
</html>  
