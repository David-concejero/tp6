import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.ArrayList;
import java.util.ArrayList;

// https://www.youtube.com/watch?v=WmxJQiB1LyU referencia
public class LeerBD{
	Connection c = null;
	Statement stmt = null;

	LeerBD(){
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:datos/tienda.db");
			//System.out.println("¡Conectados!");
			
			}catch (Exception e){
			System.out.println("Error: " + e.getMessage());
			}

		}

	public void listaProductos(String check_nombre){
		try{
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DATOS");
			String lista_final="";
			ArrayList<String> nombres = new ArrayList<String>();

			while(rs.next() ){
				String nombre = rs.getString("NOMBRE");
				String producto = rs.getString("PRODUCTO");
				String cantidad = rs.getString("CANTIDAD");
				String precio = rs.getString("PRECIO");
				String fecha = rs.getString("fecha");
				nombres.add(nombre);
				if (nombre.equals(check_nombre)){
					lista_final=lista_final+nombre + " --> " + producto + " --> " + " cantidad comprada: " + cantidad + " precio_total: " + precio + " el dia: " + fecha + "\n";
				}
			}
			JFrame frame = new JFrame("producto asociado a clientes");
			if (nombres.contains(check_nombre)){
				JOptionPane.showMessageDialog(frame,lista_final);
			}
			else{
				JOptionPane.showMessageDialog(frame,"Ese nombre no existe en nuestra base de datos");
			}
			
		} catch (Exception e){
			System.out.println("Error: " + e.getMessage());		}
	}
	public void listaProductosAll(){
		try{
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DATOS");
			String lista_final="";

			while(rs.next() ){
				String nombre = rs.getString("NOMBRE");
				String producto = rs.getString("PRODUCTO");
				String cantidad = rs.getString("CANTIDAD");
				String precio = rs.getString("PRECIO");
				String fecha = rs.getString("fecha");
				
				lista_final=lista_final+nombre + " --> " + producto + " --> " + " cantidad comprada: " + cantidad + " precio_total: " + precio + " el dia: " + fecha + "\n";
				
			}
			JFrame frame = new JFrame("producto asociado a clientes");
			JOptionPane.showMessageDialog(frame,lista_final);
		} catch (Exception e){
			System.out.println("Error: " + e.getMessage());		}
	}

	public void listaClientes(String check_nombre){
		try{
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTES");
			String lista_final="";
			ArrayList<String> names = new ArrayList<String>();

			while(rs.next() ){
				String name = rs.getString("NAME");
				String second = rs.getString("SECOND");
				String dni = rs.getString("DNI");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				String locality = rs.getString("LOCALITY");
				String zip = rs.getString("ZIP");
				names.add(name);
				if (name.equals(check_nombre)){
					lista_final = lista_final+name + " * " + second + " * " + dni + " * " + phone + " * " + address + " * " + locality + " * " + zip + "\n";
				}
			}
			JFrame frame = new JFrame("Datos del cliente");
			if (names.contains(check_nombre)){
				JOptionPane.showMessageDialog(frame,lista_final);
			}
			else{
				JOptionPane.showMessageDialog(frame,"Ese nombre no existe en nuestra base de datos");
			}
			
		} catch (Exception e){
			System.out.println("Error: " + e.getMessage());		}
	}

	public void listaClientesAll(){
		try{
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTES");
			String lista_final="";

			while(rs.next() ){
				String name = rs.getString("NAME");
				String second = rs.getString("SECOND");
				String dni = rs.getString("DNI");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				String locality = rs.getString("LOCALITY");
				String zip = rs.getString("ZIP");
				lista_final = lista_final+name + " * " + second + " * " + dni + " * " + phone + " * " + address + " * " + locality + " * " + zip + "\n";

			}
			JFrame frame = new JFrame("Datos de los clientes");
			JOptionPane.showMessageDialog(frame,lista_final);
			
		} catch (Exception e){
			System.out.println("Error: " + e.getMessage());		}
	}


	public void cierraConexion(){
		try{
			c.close();
		}catch (Exception e){
			System.out.println("Error");	
		}
	}
}
		