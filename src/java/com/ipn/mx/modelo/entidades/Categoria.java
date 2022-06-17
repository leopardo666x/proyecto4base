package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

public class Categoria implements Serializable{
    private int idCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;

    public Categoria() {
    }

    public int getIdCategoria() {
	return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
	this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
	return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
	this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
	return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
	this.descripcionCategoria = descripcionCategoria;
    }
    
    
}
