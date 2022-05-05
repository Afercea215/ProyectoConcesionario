package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import entidades.Cliente;
import entidades.Oficina;
import entidades.TipoCarnet;
import miLibreria.objetos.Persona;

public class RepositorioTipoCarnet {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las tipos de clientes de la base de datos.
	 * @return ArrayList con los tipos de clientes
	 */
	public static ArrayList<TipoCarnet> arrayListTipoCarnets() {
		
		ArrayList<TipoCarnet> lista = new ArrayList<TipoCarnet>();

		String nombre="";
		String descrip="";
		TipoCarnet carnet = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from tipoCarnet");
			
			while (rs.next()) {
				nombre = rs.getString("NOMBRE");
				descrip = rs.getString("DESCRIP");
				
				carnet=new TipoCarnet(nombre, descrip);
				
				lista.add(carnet);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Busca el tipo de carnet que tenga ese nombre en la base de datos
	 * @param nombre nombre del tipoCarnet
	 * @return TipoCarnet
	 */
	public static TipoCarnet buscaTipoCarnet(String nombre) {
		
		String descrip="";
		TipoCarnet carnetConducir = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from tipocarnet where nombre like upper('"+nombre+"')");
			
			while (rs.next()) {
				descrip = rs.getString("descrip");
				
				carnetConducir=new TipoCarnet(nombre,descrip);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carnetConducir;
	}
	
	
	/**
	 * Busca los tipo carnet que tengan ese nombre en la base de datos
	 * @param nombre nombre del cliente
	 * @return ArrayList
	 */
	public static ArrayList<TipoCarnet> arrayListTipoCarnetPorNombre(String nombre) {
		
		ArrayList<TipoCarnet> lista = new ArrayList<TipoCarnet>();
		String descrip="";
		TipoCarnet carnetConducir = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from tipocarnet where nombre like upper('%"+nombre+"%') ");
			
			while (rs.next()) {
				descrip = rs.getString("descrip");
					
				carnetConducir=new TipoCarnet(nombre,descrip);
				lista.add(carnetConducir);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	/**
	 * Borra tipo carnet que tenga el nombre en la base de datos
	 * @param nombre Nombre del TipoCarnet
	 */
	public static void borraCliente(String nombre) {
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("delete from tipocarnet where nombre like '"+nombre+"'");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Crear el tipo de carnet en la base de datos
	 * @param nombre nombre tipo carnet
	 * @param descrip descripcion tipo carnet
	 */
	public static void creaTipoCarnet(String nombre,String descrip) {
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("insert into tipoCarnet values (upper('"+nombre+"'),upper('"+descrip+"'))");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
