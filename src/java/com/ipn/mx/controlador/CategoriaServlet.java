package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.entidades.ArticuloXCategoria;
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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class CategoriaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	String accion = request.getParameter("accion");
	switch (accion) {
	    case "listarCategorias":
		listarCategorias(request, response);
		break;
	    case "ver":
		verCategoria(request, response);
		break;
	    case "nuevo":
		crearCategoria(request,response);
		break;
	    case "guardar":
		guardarCategoria(request,response);
		break;
	    case "editar":
		editarCategoria(request,response);
		break;
	    case "actualizar":
		actualizarCategoria(request,response);
		break;
	    case "eliminar":
		eliminarCategoria(request,response);
		break;
	    case "reportar":
		generarReporte(request,response);
		break;
	    case "contar":
		contarArticulos(request,response);
		break;
	    case "graficar":
		mostrarGrafica(request, response);
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

    private void listarCategorias(HttpServletRequest request, HttpServletResponse response) {
	try {
	    CategoriaDAO dao = new CategoriaDAO();
	    ArrayList<CategoriaDTO> categorias = dao.selectAll();
	    request.setAttribute("categorias", categorias);
	    RequestDispatcher rd = request.getRequestDispatcher("/categoria/listadoCategorias.jsp");
	    rd.forward(request, response);
	} catch (SQLException | ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void verCategoria(HttpServletRequest request, HttpServletResponse response) {
	try {
	    CategoriaDAO dao = new CategoriaDAO();
	    CategoriaDTO dto1 = new CategoriaDTO();
	    String id = request.getParameter("id");
	    int idCategoria = Integer.parseInt(id);
	    dto1.getEntidad().setIdCategoria(idCategoria);
	    CategoriaDTO dto2 = dao.select(dto1);
	    request.setAttribute("categoria", dto2);
	    RequestDispatcher rd = request.getRequestDispatcher("/categoria/verCategoria.jsp");
	    rd.forward(request, response);
	} catch (SQLException | ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void crearCategoria(HttpServletRequest request, HttpServletResponse response) {
	try {
	    RequestDispatcher rd = request.getRequestDispatcher("/categoria/crearCategoria.jsp");
	    rd.forward(request, response);
	} catch (ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void guardarCategoria(HttpServletRequest request, HttpServletResponse response) {
	try {
	    CategoriaDAO dao = new CategoriaDAO();
	    CategoriaDTO dto = new CategoriaDTO();
	    String nombreCategoria = request.getParameter("categoria");
	    String descripcionCategoria = request.getParameter("descripcion");
	    dto.getEntidad().setNombreCategoria(nombreCategoria);
	    dto.getEntidad().setDescripcionCategoria(descripcionCategoria);
	    dao.create(dto);
	    request.setAttribute("msg", "Categoria Añadida Correctamente");
	    request.setAttribute("tipo", "success");
	    listarCategorias(request, response);
	} catch (SQLException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void editarCategoria(HttpServletRequest request, HttpServletResponse response) {
	try {
	    CategoriaDAO dao = new CategoriaDAO();
	    CategoriaDTO dto1 = new CategoriaDTO();
	    String id = request.getParameter("id");
	    int idCategoria = Integer.parseInt(id);
	    dto1.getEntidad().setIdCategoria(idCategoria);
	    CategoriaDTO dto2 = dao.select(dto1);
	    request.setAttribute("categoria", dto2);
	    RequestDispatcher rd = request.getRequestDispatcher("/categoria/editarCategoria.jsp");
	    rd.forward(request, response);
	} catch (SQLException | ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void actualizarCategoria(HttpServletRequest request, HttpServletResponse response) {
	try {
	    CategoriaDAO dao = new CategoriaDAO();
	    CategoriaDTO dto = new CategoriaDTO();
	    String id = request.getParameter("idcategoria");
	    int idCategoria = Integer.parseInt(id);
	    String nombreCategoria = request.getParameter("categoria");
	    String descripcionCategoria = request.getParameter("descripcion");
	    dto.getEntidad().setIdCategoria(idCategoria);
	    dto.getEntidad().setNombreCategoria(nombreCategoria);
	    dto.getEntidad().setDescripcionCategoria(descripcionCategoria);
	    dao.update(dto);
	    request.setAttribute("msg", "Categoria Actualizada Correctamente");
	    request.setAttribute("tipo", "success");
	    listarCategorias(request, response);
	} catch (SQLException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) {
	try {
	    CategoriaDAO dao = new CategoriaDAO();
	    CategoriaDTO dto = new CategoriaDTO();
	    String id = request.getParameter("id");
	    int idCategoria = Integer.parseInt(id);
	    dto.getEntidad().setIdCategoria(idCategoria);
	    dao.delete(dto);
	    request.setAttribute("msg", "Categoria Eliminada Correctamente");
	    request.setAttribute("tipo", "danger");
	    listarCategorias(request, response);
	} catch (SQLException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void generarReporte(HttpServletRequest request, HttpServletResponse response) {
	try {
	    ServletOutputStream sos = null;
	    CategoriaDAO dao = new CategoriaDAO();
	    sos = response.getOutputStream();
	    File reporte;
	    byte[] b;
	    Map parameter = new HashMap();
	    
	    reporte = new File(getServletConfig().getServletContext().getRealPath("/reportes/ReporteCategorias.jasper"));
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

    private void contarArticulos(HttpServletRequest request, HttpServletResponse response) {
	try {
	    CategoriaDAO dao = new CategoriaDAO();
	    ArrayList<ArticuloXCategoria> cuentas = dao.countArticulos();
	request.setAttribute("cuentas", cuentas);
	    RequestDispatcher rd = request.getRequestDispatcher("/categoria/cuentaArticulos.jsp");
	    rd.forward(request, response);
	} catch (SQLException | ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void mostrarGrafica(HttpServletRequest request, HttpServletResponse response) {
	CategoriaDAO dao = new CategoriaDAO();
	ArrayList<ArticuloXCategoria> cuentas;
	try {
	    cuentas = dao.countArticulos();
	    DefaultPieDataset pie = new DefaultPieDataset();
	    for(ArticuloXCategoria cuenta: cuentas){
		pie.setValue(cuenta.getNombreCategoria(), cuenta.getNumeroArticulos());
	    }
	    JFreeChart chart = ChartFactory.createPieChart("Articulos por Categoria", pie, true, true, Locale.getDefault());
	    String archivo = getServletConfig().getServletContext().getRealPath("/grafica.png");
	    ChartUtils.saveChartAsPNG(new File(archivo), chart, 800, 600);
	    RequestDispatcher rd = request.getRequestDispatcher("/categoria/grafica.jsp");
	    rd.forward(request, response);
	} catch (SQLException | ServletException | IOException ex) {
	    Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
	
    }

}
