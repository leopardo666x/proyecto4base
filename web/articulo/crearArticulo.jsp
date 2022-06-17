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
                        <div class="card-title">Añadir Articulo</div>
                        <form action="ArticuloServlet?accion=guardar" method="POST">
                            <div class="cat2"><label>Nombre del Articulo</label>
                                <input class="form-control" type="text" name="articulo" required></div>
                            <div class="cat2"><label>Descripcion del Articulo</label>
                                <input class="form-control" type="text" name="descripcion" required></div>
                            <div class="cat2"><label>Precio del Articulo</label>
                                <input class="form-control" type="number" min="0.00" step="0.01" name="precio" required></div>
                            <div class="cat2"><label>Existencias</label>
                                <input class="form-control" type="number" min="0" step="1" name="existencia" required></div>
                            <div class="cat2"><label>Stock Minimo</label>
                                <input class="form-control" type="number" min="0" step="1" name="sMinimo" required></div>
                            <div class="cat2"><label>Stock Máximo</label>
                                <input class="form-control" type="number" min="0" step="1" name="sMaximo" required></div>
                            <div class="cat2"><label>ID Categoria</label>
                                <input class="form-control" type="text" name="idcategoria" required></div>
                            <button class="bwaves-effect waves-light btn" type="submit" style="margin-bottom: 20px;">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
