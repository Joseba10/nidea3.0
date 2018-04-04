<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario</title>
</head>
<body>



<button type="button" class="btn btn-primary"><a href="backoffice/materiales">Volver</a></button>
<form method="post">

<label for="id">Id</label>
<input type="text" name="id">
<label for="nombre">Nombre</label>
<input type="text" name="nombre">
<label for="precio">Precio</label>
<input type="text" name="precio">

<button type="button" class="btn btn-success">Crear</button>
<button type="button" class="btn btn-primary">Modificar</button>
<button type="button" class="btn btn-danger">Eliminar</button>

</form>


</body>
</html>