package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Oficina;

public class RepositorioOficina {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las oficinas de la base de datos.
	 * @return ArrayList con las oficinas
	 */
	public static ArrayList<Oficina> arrayListOficinas() {
		
		ArrayList<Oficina> lista = new ArrayList<Oficina>();
		String cod="";
		String desc="";
		String nomProv="";
		String nomLoc="";
		boolean ofiAero=false;
		String observaciones;
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
				observaciones = rs.getString("OBSERVACIONES");
				
				o=new Oficina(cod, desc, nomLoc, nomProv, ofiAero, observaciones);
				
				lista.add(o);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Busca la oficina que tenga ese codigo en la base de datos
	 * @param codigo codigo de la oficina
	 * @return Oficina
	 */
	public static Oficina buscaOficina(String codigo) {
		
		String cod="";
		String desc="";
		String nomProv="";
		String nomLoc="";
		boolean ofiAero=false;
		String observaciones;
		Oficina o = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from oficina where cod like '"+codigo+"'");
			
			while (rs.next()) {
				cod = rs.getString("COD");
				desc = rs.getString("DESCRIPCION");
				nomProv = rs.getString("NOMBREPROV");
				nomLoc = rs.getString("NOMBRELOC");
				observaciones = rs.getString("OBSERVACIONES");
				
				o=new Oficina(cod, desc, nomLoc, nomProv, ofiAero, observaciones);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	
	/**
	 * Busca las oficinas que tengan ese nombre en la base de datos
	 * @param nombre nombre de la oficina
	 * @return ArrayList
	 */
	public static ArrayList<Oficina> arrayListOficinasPorNombre(String nombre) {
		
		ArrayList<Oficina> lista = new ArrayList<Oficina>();
		String cod="";
		String desc="";
		String nomProv="";
		String nomLoc="";
		boolean ofiAero=false;
		String observaciones;
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
				observaciones = rs.getString("OBSERVACIONES");
				
				o=new Oficina(cod, desc, nomLoc, nomProv, ofiAero, observaciones);
				
				lista.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	/**
	 * Borra la oficina que tenga el codigo en la base de datos
	 * @param codigo codigo de la oficina
	 */
	public static void borraOficina(String codigo) {
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("delete from oficina where cod like '"+codigo+"'");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Crea una oficina en la base de datos
	 * @param codigo Codigo de la ofi
	 * @param nombre Nombre de la ofi
	 * @param nomProv Provincia de la ofi
	 * @param nomloc Localidad de la ofi
	 * @param ofiAero Si es una oficina de aeropuerto
	 * @param observaciones Observaciones de la oficina
	 */
	public static void creaOficina(String codigo, String nombre, String nomProv, String nomloc, boolean ofiAero, String observaciones) {
		
		String aero = "";
		
		if(ofiAero == false) {
			aero="F";
		}else aero="T";
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("insert into oficina values ("+codigo+",upper('"+nombre+"'),upper('"+nomloc+"'),upper('"+nomProv+"'),upper('"+aero+"'),upper('"+observaciones+"'))");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
