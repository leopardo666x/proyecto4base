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
            <div class="contenedor2">
                <div class="row">
                    <div class="card blue-grey darken-1">
                        <span class="card-title">Añadir Categoria</span>
                        
                            <form action="CategoriaServlet?accion=guardar" method="POST">
                                <div class="cat1"><label>Nombre de la Categoria</label>
                                    <input class="form-control" type="text" name="categoria" required></div>
                                <div class="cat1"><label>Descripcion de la Categoria</label>
                                    <input class="form-control" type="text" name="descripcion" required></div>
                                <button class="bwaves-effect waves-light btn" type="submit" style="margin-bottom: 20px;">Guardar</button>
                            </form>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
