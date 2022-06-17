package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ArticuloDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticuloDAO {
    private static final String SQL_CREATE = "{CALL CreateArticulo(?,?,?,?,?,?,?)}";
    private static final String SQL_UPDATE = "{CALL UpdateArticulo(?,?,?,?,?,?,?,?)}";
    private static final String SQL_DELETE = "{CALL DeleteArticulo(?)}";
    private static final String SQL_READ = "{CALL SelectOneArticulo(?)}";
    private static final String SQL_READ_ALL = "{CALL SelectAllArticulo()}";
    private Connection conn;

    public ArticuloDAO() {
    }
    
    public Connection getConnection(){
	String url = "jdbc:mysql://ukbzhzywymwmys3t:AcGs1HiL6BxniaRl8XDN@bdi4d5q7akcgurk3iep5-mysql.services.clever-cloud.com:3306/bdi4d5q7akcgurk3iep5";
	String usuario = "ukbzhzywymwmys3t";
	String password = "AcGs1HiL6BxniaRl8XDN";
	String driverDB = "com.mysql.cj.jdbc.Driver";
	try {
	    Class.forName(driverDB);
	    conn = DriverManager.getConnection(url, usuario, password);
	} catch (ClassNotFoundException | SQLException ex) {
	    Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return conn;
    }
    
    public void create(ArticuloDTO dto) throws SQLException{
	getConnection();
	CallableStatement cs = null;
	try{
	    cs = conn.prepareCall(SQL_CREATE);
	    cs.setString(1, dto.getEntidad().getNombreArticulo());
	    cs.setString(2, dto.getEntidad().getDescripcionArticulo());
	    cs.setFloat(3, dto.getEntidad().getPrecioUnitario());
	    cs.setInt(4, dto.getEntidad().getExitencias());
	    cs.setInt(5, dto.getEntidad().getStockMinimo());
	    cs.setInt(6, dto.getEntidad().getStockMaximo());
	    cs.setInt(7, dto.getEntidad().getIdCategoria());
	    cs.executeUpdate();
	}
	finally{
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
    }
    
    public void update(ArticuloDTO dto) throws SQLException{
	getConnection();
	CallableStatement cs = null;
	try{
	    cs = conn.prepareCall(SQL_UPDATE);
	    cs.setInt(1, dto.getEntidad().getIdArticulo());
	    cs.setString(2, dto.getEntidad().getNombreArticulo());
	    cs.setString(3, dto.getEntidad().getDescripcionArticulo());
	    cs.setFloat(4, dto.getEntidad().getPrecioUnitario());
	    cs.setInt(5, dto.getEntidad().getExitencias());
	    cs.setInt(6, dto.getEntidad().getStockMinimo());
	    cs.setInt(7, dto.getEntidad().getStockMaximo());
	    cs.setInt(8, dto.getEntidad().getIdCategoria());
	    cs.executeUpdate();
	}
	finally{
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
    }
    
    public void delete(ArticuloDTO dto) throws SQLException{
	getConnection();
	CallableStatement cs = null;
	try{
	    cs = conn.prepareCall(SQL_DELETE);
	    cs.setInt(1, dto.getEntidad().getIdArticulo());
	    cs.executeUpdate();
	}
	finally{
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
    }
    
    public ArticuloDTO select(ArticuloDTO dto) throws SQLException{
	getConnection();
	CallableStatement cs = null;
	ResultSet rs = null;
	ArticuloDTO result = null;
	try{
	    cs = conn.prepareCall(SQL_READ);
	    cs.setInt(1, dto.getEntidad().getIdArticulo());
	    rs = cs.executeQuery();
	    if(rs.next()){
		result = new ArticuloDTO();
		result.getEntidad().setIdArticulo(rs.getInt(1));
		result.getEntidad().setNombreArticulo(rs.getString(2));
		result.getEntidad().setDescripcionArticulo(rs.getString(3));
		result.getEntidad().setPrecioUnitario(rs.getFloat(4));
		result.getEntidad().setExitencias(rs.getInt(5));
		result.getEntidad().setStockMinimo(rs.getInt(6));
		result.getEntidad().setStockMaximo(rs.getInt(7));
		result.getEntidad().setIdCategoria(rs.getInt(8));
	    }
	}
	finally{
	    if(rs != null) rs.close();
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
	return result;
    }
    
    public ArrayList<ArticuloDTO> selectAll() throws SQLException{
	ArrayList<ArticuloDTO> articulos = new ArrayList<>();
	getConnection();
	CallableStatement cs = null;
	ResultSet rs = null;
	try{
	    cs = conn.prepareCall(SQL_READ_ALL);
	    rs = cs.executeQuery();
	    while(rs.next()){
		ArticuloDTO dto = new ArticuloDTO();
		dto.getEntidad().setIdArticulo(rs.getInt(1));
		dto.getEntidad().setNombreArticulo(rs.getString(2));
		dto.getEntidad().setDescripcionArticulo(rs.getString(3));
		dto.getEntidad().setPrecioUnitario(rs.getFloat(4));
		dto.getEntidad().setExitencias(rs.getInt(5));
		dto.getEntidad().setStockMinimo(rs.getInt(6));
		dto.getEntidad().setStockMaximo(rs.getInt(7));
		dto.getEntidad().setIdCategoria(rs.getInt(8));
		articulos.add(dto);
	    }
	}
	finally{
	    if(rs != null) rs.close();
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
	return articulos;
    }
}
