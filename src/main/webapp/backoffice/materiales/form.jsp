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
<form id="formcrud" method="post">

<label for="id">Id</label>
<input type="text" name="id" disabled value="${material.id}"><br>
<label for="nombre">Nombre</label>
<input type="text" name="nombre" value="${material.nombre}"><br>
<label for="precio">Precio</label>
<input type="text" name="precio" value="${material.precio}"><br>

<button id="crear" type="button" class="btn btn-success"><a href="backoffice/materiales?op=2&search=nombre">Crear</a></button>
<button id="modificar"type="button" class="btn btn-primary"><a href="backoffice/materiales?op=2&search=nombre">Modificar</a></button>
<button id="eliminar"type="button" class="btn btn-danger"><a href="backoffice/materiales?op=13&search=nombre">Eliminar</a></button>

</form>


<jsp:include page="/templates/footer.jsp"></jsp:include>
