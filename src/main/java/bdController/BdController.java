package bdController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class BdController {

	private static Connection connection = null;

	public static void connect() {
		String hostname = "pablomerinas.com";
		String database = "u331830226_users";
		String username = "u331830226_admin";
		String password = "Admin1234";

		String url = "jdbc:mysql://" + hostname + "/" + database;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
//			if (connection != null)
//				System.out.println("Conexión exitosa");
//			else {
//				System.out.println("Conexión fallida");
//			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean addProducto(Producto producto) {
		PreparedStatement preparedStatement = null;
		boolean isAdded = false;

		connect();
		try {
			String sql = "INSERT INTO productos (nombre, descripcion, peso, stock) VALUES (?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(2, producto.getDescripcion());
			preparedStatement.setDouble(3, producto.getPeso());
			preparedStatement.setInt(4, producto.getStock());

			preparedStatement.executeUpdate();
			System.out.println("Usuario añadido correctamente"); // Lo uso para comprobar
			isAdded = true;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		disconnect();

		return isAdded;
	}

	public static List<Producto> getProductList() {
		List<Producto> productList = new ArrayList<>();

		connect();
		try {
			String sql = "SELECT * FROM productos"; // Consulta SQL para seleccionar todos los usuarios
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// Obtener datos de cada fila del resultado y crear objetos User
				String nombre = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				Double peso = resultSet.getDouble("peso");
				Integer stock = resultSet.getInt("stock");

				Producto producto = new Producto(nombre, descripcion, peso, stock);

				productList.add(producto);
			}

			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();

		return productList;
	}

	public static boolean deleteProduct(String nombre) {
		boolean isDeleted = false;

		connect();
		try {
			String sql = "DELETE FROM productos WHERE nombre = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nombre);

			int rowsDeleted = preparedStatement.executeUpdate();

			if (rowsDeleted > 0) {
				isDeleted = true;
			}

			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();

		return isDeleted;
	}

	public static boolean modifyProduct(String namePreProduct, Producto product) {
		boolean isModified = false;

		connect();
		try {
			String sql = "UPDATE productos SET nombre = ?, descripcion = ?,peso = ?, stock = ?  WHERE nombre = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, product.getNombre());
			preparedStatement.setString(2, product.getDescripcion());
			preparedStatement.setDouble(3, product.getPeso());
			preparedStatement.setInt(4, product.getStock());
			preparedStatement.setString(5, namePreProduct);

			int rowsUpdated = preparedStatement.executeUpdate();

			if (rowsUpdated > 0) {
				isModified = true;
			}

			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();

		return isModified;
	}

	public static Producto getProducto(String nombre) {
		Producto producto = null;

		connect();
		try {
			String sql = "SELECT * FROM productos WHERE nombre = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nombre);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				producto = new Producto();
				producto.setNombre(resultSet.getString("nombre"));
				producto.setDescripcion(resultSet.getString("descripcion"));
				producto.setPeso(resultSet.getDouble("peso"));
				producto.setStock(resultSet.getInt("stock"));
			}

			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();

		return producto;
	}

	public static void disconnect() {
		if (connection != null)
			try {
				connection.close();
//				System.out.println("Desconxion exitosa");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}