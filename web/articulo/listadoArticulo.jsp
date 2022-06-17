<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica Cuatro</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link rel="stylesheet" href="https://dl.dropbox.com/s/o0v8x28mt2zvvsr/extra-articulo.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    </head>
    <body>
        <nav>
            <div class="navbar-fixed transparent">
            <div class="nav-wrapper">
              <a class="brand-logo right">Práctica 4</a>
              <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li><a class="waves-effect waves-light btn" href="index.jsp">Indice </a></li>
                <li><a class="waves-effect waves-light btn" href="CategoriaServlet?accion=listarCategorias">Lista de Categorias</a></li>
                <li><a class="waves-effect waves-light btn" href="ArticuloServlet?accion=listarArticulos">Lista de Articulos</a></li>
              </ul>
            </div>
          </nav>
          
        <div class="container">
            <c:if test="${msg != null}">
            <div class="row pt-2">
                <div class="alert alert-<c:out value="${tipo}"/> alert-dismissible fade show" role="alert">
                    <c:out value="${msg}"/>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </div>
            </c:if>
            <div class="contenedor">
                <div class="espacio" style="text-align: center;margin-left: -40px;">
                    <h2 class="text-center">Articulo</h2>
                    <a class="waves-effect waves-light btn" href="ArticuloServlet?accion=nuevo">Añadir Articulo</a>
                       <a class="waves-effect waves-light btn" href="ArticuloServlet?accion=reportar">Generar Reporte</a>
                
                <table class="responsive-table"
                    <tr>
                        <th>ID Articulo</th>
                        <th>Nombre Articulo</th>
                        <th>Descripción Articulo</th>
                        <th>Precio Unitario</th>
                        <th>Existencias</th>
                        <th>Stock Minimo</th>
                        <th>Stock Maximo</th>
                        <th>ID Categoria</th>
                        <th>Eliminar</th>
                        <th>Actualizar</th>
                    </tr>
                    <c:forEach items="${articulos}" var="articulo">
                        <tr>
                            <td>
                                <a class="waves-effect waves-light btn" href="ArticuloServlet?accion=ver&id=${articulo.entidad.idArticulo}"><c:out value="${articulo.entidad.idArticulo}"/></a>
                            </td>
                            <td>
                                <c:out value="${articulo.entidad.nombreArticulo}"/>
                            </td>
                            <td>
                                <c:out value="${articulo.entidad.descripcionArticulo}"/>
                            </td>
                            <td>
                                <c:out value="${articulo.entidad.precioUnitario}"/>
                            </td>
                            <td>
                                <c:out value="${articulo.entidad.exitencias}"/>
                            </td>
                            <td>
                                <c:out value="${articulo.entidad.stockMinimo}"/>
                            </td>
                            <td>
                                <c:out value="${articulo.entidad.stockMaximo}"/>
                            </td>
                            <td>
                                <c:out value="${articulo.entidad.idCategoria}"/>
                            </td>
                            <td>
                                <a class="waves-effect waves-light btn" href="ArticuloServlet?accion=eliminar&id=${articulo.entidad.idArticulo}"><i class="material-icons">clear</i></a>
                            </td>
                            <td>
                                <a class="waves-effect waves-light btn" href="ArticuloServlet?accion=editar&id=${articulo.entidad.idArticulo}"><i class="material-icons">create</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                </div>
            </div>
</body>
</html>
