package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Color;
import entidades.Empleado;
import entidades.Oficina;
import entidades.TipoCarnet;
import gui.FormuEmpleados;
import miLibreria.objetos.Persona;

public class RepositorioTipoVehiculo {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<String> arrayListTipoVehiculo() {
		
		ArrayList<String> lista = new ArrayList<String>();
		String nombre="";

		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from tipo_vehiculo");
			
			while (rs.next()) {
				nombre = rs.getString("nombre");
 
				lista.add(nombre);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Busca la cliente que tenga ese dni en la base de datos
	 * @param dni dni del cliente
	 * @return Cliente
	 */
	public static String buscaTipoVehiculo(String nombre) {
		
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from tipo_vehiculo where nombre like upper('"+nombre+"')");
			
			while (rs.next()) {
 
				nombre=rs.getString("nombre");
							
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre;

	}
	
	
//	/**
//	 * Borra el cliente que tenga el dni en la base de datos
//	 * @param dni DNI del cliente
//	 * @throws SQLException 
//	 */
//	public static void borraEmpleado(String dni) throws SQLException {
//		st = AccesoADatos.getCn().createStatement();
//		st.executeQuery("delete from empleado where dni like '"+dni+"'");
//		st.executeQuery("delete from persona where dni like '"+dni+"'");
//		st.executeQuery("commit");
//	}
//	
//	/**
//	 * Crea el cliente en la base de datos
//	 * @param dni DNI del cliente
//	 * @param ap1 Primer apellido del cliente
//	 * @param ap2 Segundo apellido del cliente
//	 * @param nombre Nombre del cliente
//	 * @param fechaNac GregarianCalendar fecha del cliente
//	 * @param carnetConducir TipoCarnet del cliente
//	 * @param nTarjetaCliente Numero del cliente
//	 */
//	public static void creaEmpleado(Empleado e, FormuEmpleados formu) {
//		
//		int mes = e.getFechaNac().get(Calendar.MONTH)+1;
//		int dia = e.getFechaNac().get(Calendar.DAY_OF_MONTH);
//		int año = e.getFechaNac().get(Calendar.YEAR)+1900;
//		
//		int mes2 = e.getFechaAlta().get(Calendar.MONTH)+1;
//		int dia2 = e.getFechaAlta().get(Calendar.DAY_OF_MONTH);
//		int año2 = e.getFechaAlta().get(Calendar.YEAR)+1900;
//		
//		String mesString="";
//		if (mes<10) {
//			mesString="0"+mes;
//		}else {
//			mesString=mes+"";
//		}
//		
//		String diaString="";
//		if (dia<10) {
//			diaString="0"+dia;
//		}else {
//			diaString=dia+"";
//		}
//		
//		String mesString2="";
//		if (mes2<10) {
//			mesString2="0"+mes2;
//		}else {
//			mesString2=mes2+"";
//		}
//		
//		String diaString2="";
//		if (dia2<10) {
//			diaString2="0"+dia2;
//		}else {
//			diaString2=dia2+"";
//		}
//		
//		try {
//			st = AccesoADatos.getCn().createStatement();
//			
//			if (!formu.getTfAp2().getText().equals("")) {
//				st.executeQuery("insert into persona (dni, nombre, ap1, f_nac) values (upper('"+e.getDni()+"'),upper('"+e.getNombre()+"'),upper('"+e.getAp1()+"'),upper('"+(e.getAp2())+"'),'"+diaString+"/"+mesString+"/"+año+"')");
//			} else {
//				st.executeQuery("insert into persona values (upper('"+e.getDni()+"'),upper('"+e.getNombre()+"'),upper('"+e.getAp1()+"'),upper('"+(e.getAp2())+"'),'"+diaString+"/"+mesString+"/"+año+"')");
//			}
//			st.executeQuery("insert into empleado values (upper('"+e.getDni()+"'),upper('"+diaString2+"/"+mesString2+"/"+año2+"'),upper('"+e.getOficina().getCod()+"'))");
//			st.executeQuery("commit");
//		} catch (SQLException ex) {
//			// TODO Auto-generated catch block
//			ex.printStackTrace();
//		}
//	}
//	
//	
//	public static void updateEmpleado(Empleado e) {
//		
//		int mes = e.getFechaNac().get(Calendar.MONTH)+1;
//		int dia = e.getFechaNac().get(Calendar.DAY_OF_MONTH);
//		int año = e.getFechaNac().get(Calendar.YEAR)+1900;
//		
//		int mes2 = e.getFechaAlta().get(Calendar.MONTH)+1;
//		int dia2 = e.getFechaAlta().get(Calendar.DAY_OF_MONTH);
//		int año2 = e.getFechaAlta().get(Calendar.YEAR)+1900;
//		
//		String mesString="";
//		if (mes<10) {
//			mesString="0"+mes;
//		}else {
//			mesString=mes+"";
//		}
//		
//		String diaString="";
//		if (dia<10) {
//			diaString="0"+dia;
//		}else {
//			diaString=dia+"";
//		}
//		
//		String mesString2="";
//		if (mes2<10) {
//			mesString2="0"+mes2;
//		}else {
//			mesString2=mes2+"";
//		}
//		
//		String diaString2="";
//		if (dia2<10) {
//			diaString2="0"+dia2;
//		}else {
//			diaString2=dia2+"";
//		}
//		
//		try {
//			st = AccesoADatos.getCn().createStatement();
//			st.executeQuery("update persona set nombre=upper('"+e.getNombre()+"'), ap1=upper('"+e.getAp1()+"'), ap2=upper('"+e.getAp2()+"'), f_nac='"+diaString+"/"+mesString+"/"+año+"' where dni like upper('"+e.getDni()+"')");
//			st.executeQuery("update empleado set f_alta='"+diaString2+"/"+mesString2+"/"+año2+"', CODOFI='"+e.getOficina().getCod()+"' where dni like upper('"+e.getDni()+"')");
//			st.executeQuery("commit");
//		} catch (SQLException ex) {
//			// TODO Auto-generated catch block
//			ex.printStackTrace();
//		}
//	}
}
