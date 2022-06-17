package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

public class Articulo implements Serializable{
    private int idArticulo;
    private String nombreArticulo;
    private String descripcionArticulo;
    private float precioUnitario;
    private int exitencias;
    private int stockMinimo;
    private int stockMaximo;
    private int idCategoria;

    public Articulo() {
    }

    public int getIdArticulo() {
	return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
	this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
	return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
	this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcionArticulo() {
	return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
	this.descripcionArticulo = descripcionArticulo;
    }

    public float getPrecioUnitario() {
	return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
	this.precioUnitario = precioUnitario;
    }

    public int getExitencias() {
	return exitencias;
    }

    public void setExitencias(int exitencias) {
	this.exitencias = exitencias;
    }

    public int getStockMinimo() {
	return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
	this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
	return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
	this.stockMaximo = stockMaximo;
    }

    public int getIdCategoria() {
	return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
	this.idCategoria = idCategoria;
    }
    
    
}
