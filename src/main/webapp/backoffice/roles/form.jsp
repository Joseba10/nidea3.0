<%@page import="com.ipartek.formacion.nidea.controller.backoffice.RolController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<div class="container">
	<div class="form-group">
		<button type="button" class="btn btn-primary"><a href="backoffice/rol">Volver</a></button>
	</div>

	<form action="backoffice/rol" method="post">
	
		<div class="form-group row">
			<label for="id">Id</label>
			<div class="col-sm-2">
				<input type="text" name="id" readonly value="${rol.id}">
			</div>
		</div>
		<div class="form-group">
			<label for="nombre">Nombre</label>
			<div class="col-sm-5">
				<input type="text" name="nombre" value="${rol.nombre}">
			</div>
			
		</div>
		
	
		<c:if test="${rol.id==-1 }">
			<div class="form-group row">
				<input type="hidden" name="op" value="<%=RolController.OP_GUARDAR%>">
				<button id="crear" type="submit" class="btn btn-success btn-lg btn-block">Crear</a></button>
			</div>
		</c:if>
	
		<c:if test="${rol.id>-1 }">
			<div class="form-group row">
			    <div class="col-sm-6">
				<input type="hidden" name="op" value="<%=RolController.OP_GUARDAR%>">
				<button id="modificar"type="submit" class="btn btn-primary btn-lg btn-block">Modificar</button>
				</div>
				 <div class="col-sm-6">	
				<a  data-toggle="modal" data-target="#exampleModal" href="#exampleModal"class="btn btn-danger btn-lg btn-block">Eliminar</a>
			</div>
			</div>
		</c:if>
	
	
	</form>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Borrar</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Desea borrar el rol ${rol.nombre}
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
       <a href="backoffice/rol?id=${rol.id}&op=<%=RolController.OP_ELIMINAR %>" class="btn btn-danger btn-lg btn-block">Eliminar</a>
      </div>
    </div>
  </div>
</div>

</div>





<jsp:include page="/templates/footer.jsp"></jsp:include>
