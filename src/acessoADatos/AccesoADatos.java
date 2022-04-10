package acessoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoADatos {
	
	private static Connection cn = abreConexion();
	private static Statement st=null;
		
	public static Connection abreConexion() {
		
		try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "usuario", "usuario");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
	public static void realizaConsulta(String consulta) {
		
		try {
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while (rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
