package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.ArticuloDAO;
import com.ipn.mx.modelo.dto.ArticuloDTO;
/*import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;*/
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class ArticuloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	String accion = request.getParameter("accion");
	switch (accion) {
	    case "listarArticulos":
		listarArticulos(request, response);
		break;
	    case "ver":
		verArticulo(request, response);
		break;
	    case "nuevo":
		crearArticulo(request,response);
		break;
	    case "guardar":
		guardarArticulo(request,response);
		break;
	    case "editar":
		editarArticulo(request,response);
		break;
	    case "actualizar":
		actualizarArticulo(request,response);
		break;
	    case "eliminar":
		eliminarArticulo(request,response);
		break;
	    case "reportar":
		generarReporte(request,response);
		break;
	    default:
		break;
	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

    private void listarArticulos(HttpServletRequest request, HttpServletResponse response) {
	try {
	    ArticuloDAO dao = new ArticuloDAO();
	    ArrayList<ArticuloDTO> articulos = dao.selectAll();
	    request.setAttribute("articulos", articulos);
	    RequestDispatcher rd = request.getRequestDispatcher("/articulo/listadoArticulo.jsp");
	    rd.forward(request, response);
	} catch (SQLException | ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    private void verArticulo(HttpServletRequest request, HttpServletResponse response) {
	try {
	    ArticuloDAO dao = new ArticuloDAO();
	    ArticuloDTO dto1 = new ArticuloDTO();
	    String id = request.getParameter("id");
	    int idArticulo = Integer.parseInt(id);
	    dto1.getEntidad().setIdArticulo(idArticulo);
	    ArticuloDTO dto2 = dao.select(dto1);
	    request.setAttribute("articulo", dto2);
	    RequestDispatcher rd = request.getRequestDispatcher("/articulo/verArticulo.jsp");
	    rd.forward(request, response);
	} catch (SQLException | ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void crearArticulo(HttpServletRequest request, HttpServletResponse response) {
	try {
	    RequestDispatcher rd = request.getRequestDispatcher("/articulo/crearArticulo.jsp");
	    rd.forward(request, response);
	} catch (ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    private void guardarArticulo(HttpServletRequest request, HttpServletResponse response) {
	try {
	    ArticuloDAO dao = new ArticuloDAO();
	    ArticuloDTO dto = new ArticuloDTO();
	    String nombreArticulo = request.getParameter("articulo");
	    String descripcionArticulo = request.getParameter("descripcion");
	    String precio = request.getParameter("precio");
	    float precioUnitario = Float.parseFloat(precio);
	    String existencia = request.getParameter("existencia");
	    int existencias = Integer.parseInt(existencia);
	    String sMinimo = request.getParameter("sMinimo");
	    int stockMinimo = Integer.parseInt(sMinimo);
	    String sMaximo = request.getParameter("sMaximo");
	    int stockMaximo = Integer.parseInt(sMaximo);
	    String idcategoria = request.getParameter("idcategoria");
	    int idCategoria = Integer.parseInt(idcategoria);
	    dto.getEntidad().setNombreArticulo(nombreArticulo);
	    dto.getEntidad().setDescripcionArticulo(descripcionArticulo);
	    dto.getEntidad().setPrecioUnitario(precioUnitario);
	    dto.getEntidad().setExitencias(existencias);
	    dto.getEntidad().setStockMinimo(stockMinimo);
	    dto.getEntidad().setStockMaximo(stockMaximo);
	    dto.getEntidad().setIdCategoria(idCategoria);
	    dao.create(dto);
	    request.setAttribute("msg", "Articulo Añadido Correctamente");
	    request.setAttribute("tipo", "success");
	    listarArticulos(request, response);
	} catch (SQLException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void editarArticulo(HttpServletRequest request, HttpServletResponse response) {
	try {
	    ArticuloDAO dao = new ArticuloDAO();
	    ArticuloDTO dto1 = new ArticuloDTO();
	    String id = request.getParameter("id");
	    int idArticulo = Integer.parseInt(id);
	    dto1.getEntidad().setIdArticulo(idArticulo);
	    ArticuloDTO dto2 = dao.select(dto1);
	    request.setAttribute("articulo", dto2);
	    RequestDispatcher rd = request.getRequestDispatcher("/articulo/editarArticulo.jsp");
	    rd.forward(request, response);
	} catch (SQLException | ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void actualizarArticulo(HttpServletRequest request, HttpServletResponse response) {
	try {
	    ArticuloDAO dao = new ArticuloDAO();
	    ArticuloDTO dto = new ArticuloDTO();
	    String idarticulo = request.getParameter("idarticulo");
	    int idArticulo = Integer.parseInt(idarticulo);
	    String nombreArticulo = request.getParameter("articulo");
	    String descripcionArticulo = request.getParameter("descripcion");
	    String precio = request.getParameter("precio");
	    float precioUnitario = Float.parseFloat(precio);
	    String existencia = request.getParameter("existencia");
	    int existencias = Integer.parseInt(existencia);
	    String sMinimo = request.getParameter("sMinimo");
	    int stockMinimo = Integer.parseInt(sMinimo);
	    String sMaximo = request.getParameter("sMaximo");
	    int stockMaximo = Integer.parseInt(sMaximo);
	    String idcategoria = request.getParameter("idcategoria");
	    int idCategoria = Integer.parseInt(idcategoria);
	    dto.getEntidad().setIdArticulo(idArticulo);
	    dto.getEntidad().setNombreArticulo(nombreArticulo);
	    dto.getEntidad().setDescripcionArticulo(descripcionArticulo);
	    dto.getEntidad().setPrecioUnitario(precioUnitario);
	    dto.getEntidad().setExitencias(existencias);
	    dto.getEntidad().setStockMinimo(stockMinimo);
	    dto.getEntidad().setStockMaximo(stockMaximo);
	    dto.getEntidad().setIdCategoria(idCategoria);
	    dao.update(dto);
	    request.setAttribute("msg", "Articulo Actualizado Correctamente");
	    request.setAttribute("tipo", "success");
	    listarArticulos(request, response);
	} catch (SQLException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void eliminarArticulo(HttpServletRequest request, HttpServletResponse response) {
	try {
	    ArticuloDAO dao = new ArticuloDAO();
	    ArticuloDTO dto = new ArticuloDTO();
	    String id = request.getParameter("id");
	    int idArticulo = Integer.parseInt(id);
	    dto.getEntidad().setIdArticulo(idArticulo);
	    dao.delete(dto);
	    request.setAttribute("msg", "Articulo Eliminado Correctamente");
	    request.setAttribute("tipo", "danger");
	    listarArticulos(request, response);
	} catch (SQLException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    private void generarReporte(HttpServletRequest request, HttpServletResponse response) {
	try {
	    ServletOutputStream sos = null;
	    ArticuloDAO dao = new ArticuloDAO();
	    sos = response.getOutputStream();
	    File reporte;
	    byte[] b;
	    Map parameter = new HashMap();
	    
	    reporte = new File(getServletConfig().getServletContext().getRealPath("/reportes/ReporteArticulos.jasper"));
	    b = JasperRunManager.runReportToPdf(reporte.getPath(), parameter, dao.getConnection());
	    
	    response.setContentType("application/pdf");
	    response.setContentLength(b.length);
	    sos.write(b,0,b.length);
	    sos.flush();
	    sos.close();
	} catch (IOException | JRException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }


}
