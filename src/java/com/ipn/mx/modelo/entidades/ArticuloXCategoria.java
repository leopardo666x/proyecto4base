package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

public class ArticuloXCategoria implements Serializable{
    private String nombreCategoria;
    private int numeroArticulos;

    public ArticuloXCategoria() {
    }

    public String getNombreCategoria() {
	return nombreCategoria;
    }

    public void setNombreCategoria(String Categoria) {
	this.nombreCategoria = Categoria;
    }

    public int getNumeroArticulos() {
	return numeroArticulos;
    }

    public void setNumeroArticulos(int numeroArticulos) {
	this.numeroArticulos = numeroArticulos;
    }
    
}
