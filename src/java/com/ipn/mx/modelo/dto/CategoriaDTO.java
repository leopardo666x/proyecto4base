package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;

public class CategoriaDTO implements Serializable{
    private Categoria entidad;

    public CategoriaDTO() {
	this.entidad = new Categoria();
    }

    public Categoria getEntidad() {
	return entidad;
    }

    public void setEntidad(Categoria entidad) {
	this.entidad = entidad;
    }

    @Override
    public String toString() {
	return "\nID de Categoria: " + entidad.getIdCategoria()
		+ "\nNombre de la Categoria: " + entidad.getNombreCategoria()
		+ "\nDescripcion de la Categoria: " + entidad.getDescripcionCategoria();
    }
    
    
}
