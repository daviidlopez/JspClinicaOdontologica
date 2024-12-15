<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/bodyprimeraparte.jsp"%>
<form class="user">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                placeholder="First Name">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="exampleLastName"
                placeholder="Last Name">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni"
                placeholder="dni">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="number" class="form-control form-control-user" id="telefono"
                placeholder="telefono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion"
                placeholder="direccion">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="fechanac"
                placeholder="Fecha nac">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad"
                placeholder="especialidad">
        </div>
         
    </div>
    <a href="#" class="btn btn-primary btn-user btn-block">
        Crear odontólogo
    </a>
</form>
<%@include file="/components/bodyfinal.jsp"%>
