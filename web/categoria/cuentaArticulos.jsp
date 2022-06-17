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
            <div class="contenedor3">
                <div class="row">
                         <div class="card blue-grey darken-1">
                            <table class="highlight centered">
                                <tr>
                                    <th>Categoria</th>
                                    <th>Numero de Articulos</th>
                                </tr>
                                <c:forEach items="${cuentas}" var="cuenta">
                                    <tr>
                                        <td>
                                            <c:out value="${cuenta.nombreCategoria}"/>
                                        </td>
                                        <td>
                                            <c:out value="${cuenta.numeroArticulos}"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

    </body>
</html>
