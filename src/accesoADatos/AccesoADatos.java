package accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.*;

public class AccesoADatos {
	
	private static Connection cn = abreConexion();
	private static Statement st=null;
	
	static Connection getCn() {
		return cn;
	}

	public static Statement getSt() {
		return st;
	}

	public static void setCn(Connection cn) {
		AccesoADatos.cn = cn;
	}

	public static void setSt(Statement st) {
		AccesoADatos.st = st;
	}

	public static Connection abreConexion() {
		
		try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "usuario", "usuario");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
	public static ArrayList<String> arrayListNombreProv() {
		
		ArrayList<String> nomProv = new ArrayList<String>();
		try {
			st = cn.createStatement();
			ResultSet rs = st.executeQuery("select nombre from provincia");
			
			while (rs.next()) {
				nomProv.add(rs.getString("NOMBRE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomProv;
	}
	
	public static ArrayList<String> arrayListNombreLocDeProv(String prov) {
		
		ArrayList<String> nomLoc = new ArrayList<String>();
		try {
			st = cn.createStatement();
			ResultSet rs = st.executeQuery("select nombreloc from localidad where nombreprov like upper('"+prov+"')");
			
			while (rs.next()) {
				nomLoc.add(rs.getString("NOMBRELOC"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomLoc;
	}
	
	public static void realizaImprimeConsulta(String consulta) {
		
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
