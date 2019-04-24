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


public class EscribeClienteBD  implements DAOCliente{
	private static final String URL = "jdbc:sqlite:datos/tienda.db";

	public EscribeClienteBD  (){
		createDb();
		createTable();
	}

	public void grabar(Person p){ // Introduce todas las lineas en la base de datos

		String name = p.getName();
		String second = p.getSecond();
		String dni = p.getDNI();
		String phone = p.getPhone();
		String address = p.getAddress();
		String locality = p.getLocality();
		String zip = p.getZip();
        insertDatos(name, second, dni, phone, address, locality, zip);
         
	}


	private static void insertDatos(String name, String second, String dni, String phone, String address, String locality, String zip) {
		final String SQL = "INSERT INTO clientes VALUES(?,?,?,?,?,?,?)"; 
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(SQL);) {
			ps.setString(1, name); 
			ps.setString(2, second);
			ps.setString(3, dni);
			ps.setString(4, phone);
			ps.setString(5, address);
			ps.setString(6, locality);
			ps.setString(7, zip);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void createTable() {
		final String SQL = "CREATE TABLE IF NOT EXISTS clientes (name TEXT,second TEXT, dni TEXT, phone TEXT, address TEXT, locality TEXT, zip TEXT);";
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
