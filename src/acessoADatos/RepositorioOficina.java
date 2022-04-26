package acessoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Oficina;

public class RepositorioOficina {
	
	private static Statement st=null;

	public static ArrayList<Oficina> arrayListOficinas() {
		
		ArrayList<Oficina> lista = new ArrayList<Oficina>();
		String cod="";
		String desc="";
		String nomProv="";
		String nomLoc="";
		boolean ofiAero=false;
		Oficina o = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from oficina");
			
			while (rs.next()) {
				cod = rs.getString("COD");
				desc = rs.getString("DESCRIPCION");
				nomProv = rs.getString("NOMBREPROV");
				nomLoc = rs.getString("NOMBRELOC");
				ofiAero = rs.getBoolean("OFIAEROPUERTO");
				
				o=new Oficina(cod, desc, nomLoc, nomProv, ofiAero);
				
				lista.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public static Oficina buscaOficina(String codigo) {
		
		String cod="";
		String desc="";
		String nomProv="";
		String nomLoc="";
		boolean ofiAero=false;
		Oficina o = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from oficina where cod like '"+codigo+"'");
			
			while (rs.next()) {
				cod = rs.getString("COD");
				desc = rs.getString("DESCRIPCION");
				nomProv = rs.getString("NOMBREPROV");
				nomLoc = rs.getString("NOMBRELOC");
				ofiAero = rs.getBoolean("OFIAEROPUERTO");
				
				o=new Oficina(cod, desc, nomLoc, nomProv, ofiAero);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	public static ArrayList<Oficina> arrayListOficinasPorNombre(String nombre) {
		
		ArrayList<Oficina> lista = new ArrayList<Oficina>();
		String cod="";
		String desc="";
		String nomProv="";
		String nomLoc="";
		boolean ofiAero=false;
		Oficina o = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from oficina where descripcion like upper('%"+nombre+"%') ");
			
			while (rs.next()) {
				cod = rs.getString("COD");
				desc = rs.getString("DESCRIPCION");
				nomProv = rs.getString("NOMBREPROV");
				nomLoc = rs.getString("NOMBRELOC");
				ofiAero = rs.getBoolean("OFIAEROPUERTO");
				
				o=new Oficina(cod, desc, nomLoc, nomProv, ofiAero);
				
				lista.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	
	
	public static void borraOficina(String codigo) {
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("delete from oficina where cod like '"+codigo+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void creaOficina(String codigo, String nombre, String nomProv, String nomloc, boolean ofiAero) {
		
		String aero = "";
		
		if(ofiAero == false) {
			aero="F";
		}else aero="T";
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("insert into oficina values (upper('"+codigo+"'),upper('"+nombre+"'),upper('"+nomloc+"'),upper('"+nomProv+"'),'upper("+aero+"'))");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
