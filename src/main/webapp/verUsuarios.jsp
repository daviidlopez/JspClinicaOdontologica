<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp"%>
<%@include file="/components/bodyprimeraparte.jsp"%>
<h1>Ver Usuarios</h1>
 <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>usuario</th>
                                            <th>rol</th>
                                            <th style="width:210px">rol</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>usuario</th>
                                            <th>rol</th>
                                            <th style="width:210px">rol</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <% 
                                            List <Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                                            for(Usuario user: listaUsuarios) {
                                        %>
                                        <tr>
                                            <td><%= user.getId_usuario() %></td>
                                            <td><%= user.getNombreUsuario() %></td>
                                            <td><%= user.getRol() %></td>
                                            <td style="display:flex; width: 230px;">

                                            <form name="eliminar" action="SvElimUsuarios" method="POST">
                                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px;">
                                                    <i class="fas fa-trash-alt"></i>Eliminar
                                                </button>
                                                <input type="hidden" name="id" value="<%=user.getId_usuario()%>">
                                            </form>

                                            <form name="editar" action="SvEditUsuarios" method="GET">
                                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left:5px;">
                                                    <i class="fas fa-pen-alt"></i>Editar
                                                </button>
                                                <input type="hidden" name="id" value="<%=user.getId_usuario()%>">
                                            </form>

                                            </td>
                                        </tr>
                                        <%
                                            }    
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
<%@include file="/components/bodyfinal.jsp"%>
