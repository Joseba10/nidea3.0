<%@page import="com.ipartek.formacion.nidea.controller.backoffice.RolController"%>

<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>


<h1>BackOffice</h1>

Buscador
<form action="backoffice/rol" method="get">
<input type="hidden" name="op" value="<%=RolController.OP_BUSQUEDA%>">
<input type="text" name="search" required placeholder="Nombre del Rol">
<input type="submit" value="Buscar">

<button type="button" class="btn btn-success"><a href="backoffice/rol?op=<%=RolController.OP_MOSTRAR_FORMULARIO%>">Crear Nuevo Rol</a></button>

</form>


	<%// Sustituye al Arraylist<Rol> lista= (ArrayList<Material>)request.getAttribute("materiales")
	  // Mejor usamos EL => Expresion Lenguage => ${}
	  //Podemos usar cualquier expresion,si no hay expresion pinta la variable
%>

<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
     			<th>Id</th>
                <th>Nombre</th>
        
              
            </tr>
        </thead>
        <tfoot>
           
        <tbody>

<c:forEach items="${rol}" var="roles">


	
				<tr>
					<td>${roles.id} </td>
					 <td> ${roles.nombre};</td>
				 </tr>
		
	</c:forEach>
				
		
		     </tbody>
    </table>





<jsp:include page="/templates/footer.jsp"></jsp:include>