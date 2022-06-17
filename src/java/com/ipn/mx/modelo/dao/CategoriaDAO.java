package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.entidades.ArticuloXCategoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO {
    private static final String SQL_CREATE = "{CALL CreateCategoria(?,?)}";
    private static final String SQL_UPDATE = "{CALL UpdateCategoria(?,?,?)}";
    private static final String SQL_DELETE = "{CALL DeleteCategoria(?)}";
    private static final String SQL_READ = "{CALL SelectOneCategoria(?)}";
    private static final String SQL_READ_ALL = "{CALL SelectAllCategoria()}";
    private static final String SQL_COUNT = "{CALL ArticulosXCategoria()}";
    private Connection conn;

    public CategoriaDAO() {
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
    
    public void create(CategoriaDTO dto) throws SQLException{
	getConnection();
	CallableStatement cs = null;
	try{
	    cs = conn.prepareCall(SQL_CREATE);
	    cs.setString(1, dto.getEntidad().getNombreCategoria());
	    cs.setString(2, dto.getEntidad().getDescripcionCategoria());
	    cs.executeUpdate();
	}
	finally{
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
    }
    
    public void update(CategoriaDTO dto) throws SQLException{
	getConnection();
	CallableStatement cs = null;
	try{
	    cs = conn.prepareCall(SQL_UPDATE);
	    cs.setInt(1, dto.getEntidad().getIdCategoria());
	    cs.setString(2, dto.getEntidad().getNombreCategoria());
	    cs.setString(3, dto.getEntidad().getDescripcionCategoria());
	    cs.executeUpdate();
	}
	finally{
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
    }
    
    public void delete(CategoriaDTO dto) throws SQLException{
	getConnection();
	CallableStatement cs = null;
	try{
	    cs = conn.prepareCall(SQL_DELETE);
	    cs.setInt(1, dto.getEntidad().getIdCategoria());
	    cs.executeUpdate();
	}
	finally{
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
    }
    
    public CategoriaDTO select(CategoriaDTO dto) throws SQLException{
	getConnection();
	CallableStatement cs = null;
	ResultSet rs = null;
	CategoriaDTO result = null;
	try{
	    cs = conn.prepareCall(SQL_READ);
	    cs.setInt(1, dto.getEntidad().getIdCategoria());
	    rs = cs.executeQuery();
	    if(rs.next()){
		result = new CategoriaDTO();
		result.getEntidad().setIdCategoria(rs.getInt(1));
		result.getEntidad().setNombreCategoria(rs.getString(2));
		result.getEntidad().setDescripcionCategoria(rs.getString(3));
	    }
	}
	finally{
	    if(rs != null) rs.close();
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
	return result;
    }
    
    public ArrayList<CategoriaDTO> selectAll() throws SQLException{
	ArrayList<CategoriaDTO> categorias = new ArrayList<>();
	getConnection();
	CallableStatement cs = null;
	ResultSet rs = null;
	try{
	    cs = conn.prepareCall(SQL_READ_ALL);
	    rs = cs.executeQuery();
	    while(rs.next()){
		CategoriaDTO dto = new CategoriaDTO();
		dto.getEntidad().setIdCategoria(rs.getInt(1));
		dto.getEntidad().setNombreCategoria(rs.getString(2));
		dto.getEntidad().setDescripcionCategoria(rs.getString(3));
		categorias.add(dto);
	    }
	}
	finally{
	    if(rs != null) rs.close();
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
	return categorias;
    }
    
    public ArrayList<ArticuloXCategoria> countArticulos() throws SQLException{
	getConnection();
	ArrayList<ArticuloXCategoria> cuentas = new ArrayList<>();
	CallableStatement cs = null;
	ResultSet rs = null;
	try{
	    cs = conn.prepareCall(SQL_COUNT);
	    rs = cs.executeQuery();
	    while(rs.next()){
		ArticuloXCategoria axc = new ArticuloXCategoria();
		axc.setNombreCategoria(rs.getString(1));
		axc.setNumeroArticulos(rs.getInt(2));
		cuentas.add(axc);
	    }
	}
	finally{
	    if(rs != null) rs.close();
	    if(cs != null) cs.close();
	    if(conn != null) conn.close();
	}
	return cuentas;
    }
    
}
