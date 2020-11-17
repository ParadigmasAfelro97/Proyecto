package controller;

import java.sql.*;

public class Conexion {

    // Ruta de nuestra base de datos
    private String servidor = "jdbc:mysql://localhost:3306/db-citas";

    // Nombre de usuario de mysql
    private String username = "root";

    // Clave de usuario de mysql
    private String password = "";

    // Nuestra librer�a mysql
    private String driver = "com.mysql.jdbc.Driver";

    // Objeto del tipo Connection para crear la conexi�n
    private Connection con;

    public Conexion()
    {
        try {
            // Cargar drivers de MySQL
            Class.forName(driver);

            // Establecer la conexion con la base de datos
            con = DriverManager.getConnection(servidor, username, password);

            System.out.println("Conexi�n realizada a la base de datos con �xito.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error!, conexi�n fallida a la base de datos.");
        }
    }

    public Connection getConnection() {
        return con; // Retorno el objeto Connection
    }
   }