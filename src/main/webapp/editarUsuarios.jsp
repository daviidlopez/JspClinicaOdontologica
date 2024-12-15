<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/bodyprimeraparte.jsp"%>
<h1>Editar Usuario</h1>
<% 
    Usuario usuario = (Usuario) request.getSession().getAttribute("editarUsuario");
%>
<form class="user" action="SvEditUsuarios" method="POST">
        <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusuario" name="nombreusuario"
                   value="<%=usuario.getNombreUsuario()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                value="<%=usuario.getContrasenia()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                value="<%=usuario.getRol()%>">
        </div>
         
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Editar Usuario
    </button>
</form>
<%@include file="/components/bodyfinal.jsp"%>