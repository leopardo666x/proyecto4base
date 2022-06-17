<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica Cuatro</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link rel="stylesheet" href="https://dl.dropbox.com/s/mwq3xn1u03e68jj/extra-categoria.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    </head>
    <body>
        <nav>
            <div class="navbar-fixed">
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
            <div class="row">
                <div class="alert alert-<c:out value="${tipo}"/> alert-dismissible fade show" role="alert">
                    <c:out value="${msg}"/>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
        </div>
            </c:if>  
            <div class="contenedor">
                <div class="espacio">
                    <h2 class="text-center">Lista de categorias</h2>
                    <a class="waves-effect waves-light btn" href="CategoriaServlet?accion=nuevo">Añadir Categoria</a>
                
                    <a class="waves-effect waves-light btn" href="CategoriaServlet?accion=contar">Ver Numero de Articulos por Categoria</a>
        
                    <a class="waves-effect waves-light btn" href="CategoriaServlet?accion=reportar">Generar Reporte</a>
                    
                    <a class="waves-effect waves-light btn" href="CategoriaServlet?accion=graficar">Generar Gráfica</a>
                
                <table class="responsive-table" >
                    <tr>
                        <th>ID Categoria</th>
                        <th>Nombre Categoria</th>
                        <th>Descripción Categoria</th>
                        <th>Eliminar</th>
                        <th>Actualizar</th>
                    </tr>
                    <c:forEach items="${categorias}" var="categoria">
                        <tr>
                            <td>
                                <a class="waves-effect waves-light btn" href="CategoriaServlet?accion=ver&id=${categoria.entidad.idCategoria}"><c:out value="${categoria.entidad.idCategoria}"/></a>
                            </td>
                            <td>
                                <c:out value="${categoria.entidad.nombreCategoria}"/>
                            </td>
                            <td>
                                <c:out value="${categoria.entidad.descripcionCategoria}"/>
                            </td>
                            <td>
                                <a class="waves-effect waves-light btn" href="CategoriaServlet?accion=eliminar&id=${categoria.entidad.idCategoria}"> <i class="material-icons">clear</i></a>
                            </td>
                            <td>
                                <a class="waves-effect waves-light btn" href="CategoriaServlet?accion=editar&id=${categoria.entidad.idCategoria}"> <i class="material-icons">create</i></a>
                            </td>
                        </tr>
                        

                    </c:forEach>
                </table>
            </div>
            </div>

</body>
</html>
