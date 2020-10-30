package controller;

import java.util.ArrayList;
import java.util.List;


import model.Categoria;

public class MantenimientoCategorias {

	private List<Categoria> categorias;
	private Categoria categoria;

	// Constructor
	public MantenimientoCategorias() {

		this.categorias = new ArrayList<Categoria>();
		this.categoria = new Categoria();
	}

	// Metodos Publicos
	public void crearCategoria() {
		this.categorias.add(this.categoria);
		this.categoria = new Categoria();
	}

	public void eliminarCategoria(Categoria categoria) {
		this.categorias.remove(categoria);
	}

	public void modificarCategoria() {
	
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
