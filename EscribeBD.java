import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;


public class EscribeBD implements DAOCompra{
	private static final String URL = "jdbc:sqlite:datos/tienda.db";

	public EscribeBD (){
		createDb();
		createTable();
	}

	public void grabar(Compra c){ // Introduce todas las lineas en la base de datos

		String nombre = c.getPer().getName();
		String variable_nombre_producto = c.getCesta_producto().getNombre_producto().getNombre_producto();
        String[] lista_nombre_productos = variable_nombre_producto.split(":");
        String variable_cantidad_producto = c.getCesta_cantidad_producto().getCantidad_producto().getCantidad_producto();
        String[] lista_cantidad_productos = variable_cantidad_producto.split(":");
        String variable_precio_producto = c.getPrecio_producto().getPrecio_producto().getPrecio_producto();
        String[] lista_precio_productos = variable_precio_producto.split(":");
	       for (int x=1; x < lista_nombre_productos.length; x++){
	       int variable1 = Integer.parseInt(lista_precio_productos[x]);
	       int variable2 = Integer.parseInt(lista_cantidad_productos[x]);
	       int variable3 = variable1*variable2;
	       String variable4 = Integer.toString(variable3);
           insertDatos(nombre, lista_nombre_productos[x],lista_cantidad_productos[x], variable4 );
          }
	}


	private static void insertDatos(String nombre,String producto, String cantidad, String precio) {
		final String SQL = "INSERT INTO datos VALUES(?,?,?,?,datetime('now'))"; // fecha http://www.sqlitetutorial.net/sqlite-date/
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(SQL);) {
			ps.setString(1, nombre); 
			ps.setString(2, producto);
			ps.setString(3, cantidad);
			ps.setString(4, precio);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void createTable() {
		final String SQL = "CREATE TABLE IF NOT EXISTS datos (nombre TEXT,producto TEXT, cantidad TEXT, precio TEXT, fecha TEXT);";
        // This SQL Query is not "dynamic". Columns are static, so no need to use
        // PreparedStatement.
		try (Connection con = getConnection(); Statement statement = con.createStatement();) {
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void createDb() {
		try (Connection conn = getConnection()) {
			if (conn != null) {
				conn.getMetaData();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
	}
}
