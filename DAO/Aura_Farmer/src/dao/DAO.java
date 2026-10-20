package dao;
import principal.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	private String user = "root";
	private String psw = "admin";
	private String path = "jdbc:mysql://localhost:3306/sic_seben";



	public void agregar() {
		String sql = "INSERT INTO `aura`(`id`, `dni_verity`,`nombreuwu`)VALUES(2, '49998007', 'wewa');";
		Connection conexion = null;
		try {
			conexion = conectar();
			Statement stmt = conexion.createStatement();
			int filas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();

			
			                                                                                       
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//while rs.next va a recorrer todo dependiebdo de lo q le mande
		public ArrayList<String> consultar() {
			Connection c = null;
			ArrayList<String> solucion = new ArrayList<String>();
			try {
				c = conectar();
				String sql = "SELECT";
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String nombre = rs.getString("nombreuwu");
					solucion.add(nombre);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				
			}
			try {
				c.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} return solucion;
		} 
		
//		DATABASE -> REVERSE ENGINEER -> GENERA DER
		// forward engineer -> next -> elegir tabla ->
		
	public void eliminar(int id) {
		String sql = "DELETE FROM `sic_seben`.`aura`WHERE aura.id = 3;";
		try (Connection conexion = DriverManager.getConnection(path, user, psw);)
		   {
			PreparedStatement stmt =  conexion.prepareStatement(sql);
			stmt.setInt(1, id);
			//conexion = conectar();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} 
	}
	
	public void agregarPersonaPorParametro(Persona p)  {
		Connection c = null;
		String SQL = "INSERT INTO personas (nombreuwu, dni_verity) VALUES (?, ?);";
		try {
			c = conectar();
			PreparedStatement stmt = c.prepareStatement(SQL);
			//stmt.setString(0,  p.getNombre);
			//stmt.setFloat(1, p.getSecretos);
			int filas = stmt.executeUpdate();
			c.close();
			System.out.println("entró");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("entró al catch");
		}
	}
	//cosas importantes al parametrizar = índices, el excecuteUpdate va sin parametros dentro del paréntesis
	public void actualizacion() {
		String sql = "UPDATE aura SET id = 1, dni_verity = 23456789, nombreuwu = 'minikick';";
		try (Connection conexion = DriverManager.getConnection(path, user, psw);)
		   {
			PreparedStatement stmt =  conexion.prepareStatement(sql);
			stmt.setString(1, "verity");
			stmt.setInt(1, 67);
			stmt.setInt(1, 6712);
			int fila = stmt.executeUpdate();
			//conexion = conectar();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} 
	}

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(path, user, psw);
			Statement stmt = conexion.createStatement();
			System.out.println("Se conectó");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
}
