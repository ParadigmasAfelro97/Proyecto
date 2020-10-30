package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Categoria;

public class MantenimientoCategorias {

	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Categoria> categorias;
	private Categoria categoria;
	private String palabraClave;

	// Constructor
	public MantenimientoCategorias() {
		this.emf = Persistence.createEntityManagerFactory("Proyecto");
		this.em = this.emf.createEntityManager();
		this.categorias = consultarCategorias();
		this.categoria = new Categoria();
	}

	// Metodos Privados
	private List<Categoria> consultarCategorias() {
		String jpql = " SELECT cat FROM Categoria cat ";
		Query query = this.em.createQuery(jpql);
		List<Categoria> categorias = query.getResultList();
		return categorias;
	}

	// Metodos Publicos
	public void crearCategoria(Categoria categoria) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(categoria);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.categoria = new Categoria();
			this.categorias = consultarCategorias();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void eliminarCategoria() {
		this.categoria = this.categorias.get(0);
		if (this.categoria != null) {
			try {
				
				this.em.getTransaction().begin();
				this.em.remove(categoria);
				this.em.getTransaction().commit();
				this.em = this.emf.createEntityManager();
				this.categoria = new Categoria();
				this.categorias = consultarCategorias();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}

	//Metodo de ejemplo.
	public void modificarCategoria(Categoria categoria) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(categoria);
			this.em.getTransaction().commit();
			this.categoria = new Categoria();
			this.categorias = consultarCategorias();
		} catch (Exception e) {
			System.out.println(e);
		}
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
