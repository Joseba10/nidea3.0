<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<div class="container">
	<div class="form-group">
		<button type="button" class="btn btn-primary"><a href="backoffice/materiales">Volver</a></button>
	</div>

	<form action="backoffice/materiales" method="post">
	
		<div class="form-group row">
			<label for="id">Id</label>
			<div class="col-sm-2">
				<input type="text" name="id" readonly value="${material.id}">
			</div>
		</div>
		<div class="form-group">
			<label for="nombre">Nombre</label>
			<div class="col-sm-5">
				<input type="text" name="nombre" value="${material.nombre}">
			</div>
			
		</div>
		<div class="form-group">
			<label for="precio">Precio</label>
			<input type="text" name="precio" value="${material.precio}">
		</div>
	
	
		<c:if test="${material.id==-1 }">
			<div class="form-group row">
				<input type="hidden" name="op" value="<%=MaterialesController.OP_GUARDAR%>">
				<button id="crear" type="submit" class="btn btn-success btn-lg btn-block">Crear</a></button>
			</div>
		</c:if>
	
		<c:if test="${material.id>-1 }">
			<div class="form-group row">
			    <div class="col-sm-6">
				<input type="hidden" name="op" value="<%=MaterialesController.OP_GUARDAR%>">
				<button id="modificar"type="submit" class="btn btn-primary btn-lg btn-block">Modificar</button>
				</div>
				 <div class="col-sm-6">	
				<a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesController.OP_ELIMINAR %>" class="btn btn-danger btn-lg btn-block">Eliminar</a>
			</div>
			</div>
		</c:if>
	
	
	</form>

</div>





<jsp:include page="/templates/footer.jsp"></jsp:include>
