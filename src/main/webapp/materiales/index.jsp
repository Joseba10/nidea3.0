<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>


<h1>BackOffice</h1>

	<%// Sustituye al Arraylist<Material> lista= (ArrayList<Material>)request.getAttribute("materiales")
	  // Mejor usamos EL => Expresion Lenguage => ${}
	  //Podemos usar cualquier expresion,si no hay expresion pinta la variable
%>

<ol>
<c:forEach items="${materiales}" var="material">


<c:choose> 
		
		<c:when test = "${(material.precio >= 6.0) && (material.precio <= 24)}">
	
 	<li class="text-primary">${material.nombre} - ${material.precio} &euro;</li>
		 </c:when>
       
   <c:when test = "${material.precio >= 25.0}">
 <li class="text-danger">${material.nombre} - ${material.precio} &euro;</li>
		 </c:when>
		  <c:otherwise></c:otherwise>
		 </c:choose>
	
		</c:forEach>
</ol>






<jsp:include page="/templates/footer.jsp"></jsp:include>