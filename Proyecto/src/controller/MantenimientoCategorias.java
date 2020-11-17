package controller;

import java.sql.*;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

import model.Categoria;

public class MantenimientoCategorias {

	private List<Categoria> categorias;
	private Categoria categoria;

	// Constructor
	public MantenimientoCategorias() {

		this.categorias = new ArrayList<Categoria>();
		this.categoria = new Categoria();
		crearCategoria();
	}

	// Metodos Publicos
	public void crearCategoria() {
		this.categorias.add(this.categoria);
		this.categoria = new Categoria();

		try {
			// create a mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/db-citas";
			Class.forName(myDriver);
			Connection conn = crearConexion("localhost", "3306","root", "", "db-citas", true);

			// create a sql date object so we can use it in our INSERT statement

			// the mysql insert statement
			// String query = " insert into cita (idcita, estado_cita_idcita,
			// usuario_idusuario, descripcion, medico_id_medico,"
			// + "persona_idpersona)"
			// + " values (?, ?, ?, ?, ?, ?)";

			/*
			 * create the mysql insert preparedstatement PreparedStatement preparedStmt =
			 * (PreparedStatement) conn.prepareStatement(query); preparedStmt.setInt (1, 1);
			 * preparedStmt.setInt (2, 2); preparedStmt.setInt (3, 3);
			 * preparedStmt.setString(4, "String"); preparedStmt.setInt(5, 5);
			 * preparedStmt.setInt(5, 6);
			 */

			String query = "insert into cita (idcita, estado_cita_idcita," + 
					"usuario_idusuario, descripcion, medico_id_medico," +
					"persona_idpersona)"
					+ "values (?, ?, ?, ?, ?, ?) ";
					
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt (1, 4);
			preparedStmt.setInt (2, 1); 
			preparedStmt.setInt (3, 1);
			preparedStmt.setString(4, "String"); 
			preparedStmt.setInt(5, 1);
			preparedStmt.setInt(6, 1);
			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
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

	private Connection crearConexion(String host, String port, String user, String password, String database,
			boolean isAutoCommit) {
		try {
			Connection conn;
			// Se realiza la conexión a la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			if (database != null && !database.equals("")) {
				conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user,
						password);
			} else {
				conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port, user, password);
			}
			conn.setAutoCommit(isAutoCommit);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Connection exception: [" + e.toString() + "]");
			return null;
		}
	}

	public static void main(String []args) {
		// TODO Auto-generated method stub
		MantenimientoCategorias m = new MantenimientoCategorias();
		m.crearCategoria();
	}
}
