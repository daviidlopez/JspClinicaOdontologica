<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/bodyprimeraparte.jsp"%>
<h1>Alta Usuarios</h1>
<form class="user" action="SvUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusuario" name="nombreusuario"
                placeholder="nombre usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                placeholder="contraseña">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                placeholder="rol">
        </div>
         
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Crear Usuario
    </button>
</form>
<%@include file="/components/bodyfinal.jsp"%>
