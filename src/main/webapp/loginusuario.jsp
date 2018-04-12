<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<div id="login">

  <form class="form-signin" action="login-user" method="post">     


  <div class="form-label-group">
  <label for="password">Id</label>
        <input type="password" 
               name="id" 
               class="form-control" 
               placeholder="Id" required>
               
        
      </div>
      
      <div class="form-label-group">
          <label for="usuario">Nombre Usuario</label>
        <input type="text" class="form-control"
               name="usuario" 
               placeholder="Nombre Usuario" 
               required autofocus>
               
    
      </div>

    
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
    </form>

</div>
<jsp:include page="templates/footer.jsp"></jsp:include>