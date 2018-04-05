<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesController"%>

<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>


<h1>BackOffice</h1>

	<%// Sustituye al Arraylist<Material> lista= (ArrayList<Material>)request.getAttribute("materiales")
	  // Mejor usamos EL => Expresion Lenguage => ${}
	  //Podemos usar cualquier expresion,si no hay expresion pinta la variable
%>

<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
     			<th>Id</th>
                <th>Material</th>
                <th>Precio</th>
              
            </tr>
        </thead>
        <tfoot>
           
        <tbody>

<c:forEach items="${materiales}" var="material">


<c:choose> 
		
		<c:when test = "${(material.precio >= 6.0) && (material.precio <= 24)}">
	           <tr>
	<td class="text-primary">${material.id} </td>
 	<td class="text-primary">${material.nombre} </td>
 	<td class="text-primary"> ${material.precio} &euro;</td>
 	</tr>
		 </c:when>
       
   <c:when test = "${material.precio >= 25.0}">
   <tr>
   	<td class="text-primary">${material.id} </td>
 	<td class="text-danger">${material.nombre} </td> 
 	<td class="text-danger"> ${material.precio} &euro;</td>
 	   </tr>
		 </c:when>
		  <c:otherwise></c:otherwise>
		 </c:choose>

		</c:forEach>
		
		
		     </tbody>
    </table>






<jsp:include page="/templates/footer.jsp"></jsp:include>