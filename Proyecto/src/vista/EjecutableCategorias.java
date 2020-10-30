package vista;

import java.util.Scanner;

import javax.swing.JOptionPane;

import controlador.MantenimientoCategorias;
import entidades.Categoria;

public class EjecutableCategorias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MantenimientoCategorias manCat = new MantenimientoCategorias();
		String descripcion;
		String nombre;
		int opcion = 0;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"Gestion de categorias, seleccione una opcion: \n 1. Crear Categoria, 2. Eliminar Categoria, 3. Modificar Categoria, 4. Listas Categorias"));

			switch (opcion) {
			case 1: // Crear Categoria
				nombre = JOptionPane.showInputDialog("Defina nombre de la categoria");
				descripcion = JOptionPane.showInputDialog("Defina descripcion de la categoria");
				manCat.crearCategoria(new Categoria(descripcion, nombre));
				break;
			case 2: // Eliminar Categoria
				JOptionPane.showMessageDialog(null, manCat.getCategorias().get(0));
				manCat.eliminarCategoria();
				JOptionPane.showMessageDialog(null, "Categoria eliminada");
				
				break;
			case 3: // Modificar Categoria

				break;
			case 4: // Listas Categorias
				String mensajeCategoria = "";
				for (Categoria categoria : manCat.getCategorias()) {
					mensajeCategoria += categoria +"\n";
				}
				JOptionPane.showMessageDialog(null, mensajeCategoria);
				break;
			}
		} while (opcion != 0);
	}

}
