<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<script>

setTimeout(function(){location.reaload(1);},5000)


</script>

<!--

//-->
</script>
<h1>Ya estas logeado en el frontoffice</h1>

<ul>
	<c:forEach var="usuario" items="${applicationScope.usuarios_conectados}">
		<li>${usuario.key} - ${usuario.value}</li>
	</c:forEach>
</ul>
