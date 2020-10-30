package model;



public class Categoria {

	private int codigo;

	private String descripcion;

	private String nombre;

	public Categoria(String nombre, String descripcion) {
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public Categoria() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", descripcion=" + descripcion + ", nombre=" + nombre + "]";
	}
	
	

}