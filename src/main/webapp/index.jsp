<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>
<%@page errorPage="error.jsp" %>

<%
	// Scriplet < %  ...   % >
	// varias sentencias 
	String nombre = "pepe";
	String hora = "10:78";

	//Lanza adrede un NullPointerException y nos lanza una pagina de error
	//Lo hemos configurado en web.xml

String nulo=null;
nulo.length();
%>

<h2>Hello <%=nombre%></h2>
<p><%=hora%></p>

<a href="generar-mesa"> ¿Quieres Comprar una Mesa ?</a>


<jsp:include page="templates/footer.jsp"></jsp:include>