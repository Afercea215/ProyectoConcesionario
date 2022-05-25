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

public class RepositorioCliente {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<Cliente> arrayListClientes() {
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		String ap1="";
		String ap2="";
		String nombre="";
		GregorianCalendar fechaNac=null;
		String dni="";
		TipoCarnet carnetConducir = null;
		String nTarjetaCliente = null;
		Cliente cliente = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select p.dni, nombre, ap1, ap2, f_nac, carnetconducir, ntarjetacliente2 from persona p join cliente2 c on p.dni=c.dni");
			
			while (rs.next()) {
				dni = rs.getString("DNI");
				ap1 = rs.getString("AP1");
				ap2 = rs.getString("ap2");
				nombre = rs.getString("NOMBRE");
				fechaNac = new GregorianCalendar(rs.getDate("F_NAC").getYear(),rs.getDate("F_NAC").getMonth() , rs.getDate("F_NAC").getDay());
				
				carnetConducir = RepositorioTipoCarnet.buscaTipoCarnet(rs.getString("CARNETCONDUCIR"));
				nTarjetaCliente = rs.getString("NTARJETACLIENTE2");
 
				cliente=new Cliente(ap1, ap2, nombre, fechaNac, dni, carnetConducir, nTarjetaCliente);
				
				lista.add(cliente);
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
	public static Cliente buscaCliente(String dni) {
		
		String ap1="";
		String ap2="";
		String nombre="";
		GregorianCalendar fechaNac=null;
		TipoCarnet carnetConducir = null;
		String nTarjetaCliente = null;
		Cliente cliente = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select p.dni, nombre, ap1, ap2, f_nac, carnetconducir, ntarjetacliente2 from persona p join cliente2 c on p.dni=c.dni where p.dni like upper('"+dni+"')");
			
			while (rs.next()) {
				dni = rs.getString("DNI");
				ap1 = rs.getString("AP1");
				ap2 = rs.getString("ap2");
				nombre = rs.getString("NOMBRE");
				fechaNac = new GregorianCalendar(rs.getDate("F_NAC").getYear(),rs.getDate("F_NAC").getMonth() , rs.getDate("F_NAC").getDay());
				
				carnetConducir = RepositorioTipoCarnet.buscaTipoCarnet(rs.getString("CARNETCONDUCIR"));
				nTarjetaCliente = rs.getString("NTARJETACLIENTE2");
 
				cliente=new Cliente(ap1, ap2, nombre, fechaNac, dni, carnetConducir, nTarjetaCliente);
							
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}
	
	
	/**
	 * Borra el cliente que tenga el dni en la base de datos
	 * @param dni DNI del cliente
	 * @throws SQLException 
	 */
	public static void borraCliente(String dni) throws SQLException {
		st = AccesoADatos.getCn().createStatement();
		st.executeQuery("delete from cliente2 where dni like '"+dni+"'");
		st.executeQuery("delete from persona where dni like '"+dni+"'");
		st.executeQuery("commit");
	}
	
	/**
	 * Crea el cliente en la base de datos
	 * @param dni DNI del cliente
	 * @param ap1 Primer apellido del cliente
	 * @param ap2 Segundo apellido del cliente
	 * @param nombre Nombre del cliente
	 * @param fechaNac GregarianCalendar fecha del cliente
	 * @param carnetConducir TipoCarnet del cliente
	 * @param nTarjetaCliente Numero del cliente
	 */
	public static void creaCliente(Cliente c) {
		
		int mes = c.getFechaNac().get(Calendar.MONTH)+1;
		int dia = c.getFechaNac().get(Calendar.DAY_OF_MONTH);
		int año = c.getFechaNac().get(Calendar.YEAR)+1900;
		
		String mesString="";
		if (mes<10) {
			mesString="0"+mes;
		}else {
			mesString=mes+"";
		}
		
		String diaString="";
		if (dia<10) {
			diaString="0"+dia;
		}else {
			diaString=dia+"";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("insert into persona values (upper('"+c.getDni()+"'),upper('"+c.getNombre()+"'),upper('"+c.getAp1()+"'),upper('"+c.getAp2()+"'),'"+diaString+"/"+mesString+"/"+año+"')");
			st.executeQuery("insert into cliente2 values (upper('"+c.getDni()+"'),upper('"+c.getCarnetConducir().getNombre()+"'),upper('"+c.getnTarjetaCliente()+"'))");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void updateCliente(Cliente c) {
		
		int mes = c.getFechaNac().get(Calendar.MONTH)+1;
		int dia = c.getFechaNac().get(Calendar.DAY_OF_MONTH);
		int año = c.getFechaNac().get(Calendar.YEAR);
		
		String mesString="";
		if (mes<10) {
			mesString="0"+mes;
		}else {
			mesString=mes+"";
		}
		
		String diaString="";
		if (dia<10) {
			diaString="0"+dia;
		}else {
			diaString=dia+"";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("update persona set nombre=upper('"+c.getNombre()+"'), ap1=upper('"+c.getAp1()+"'), ap2=upper('"+c.getAp2()+"'), f_nac='"+diaString+"/"+mesString+"/"+año+"' where dni like upper('"+c.getDni()+"')");
			st.executeQuery("update cliente2 set carnetconducir=upper('"+c.getCarnetConducir().getNombre()+"'), NTARJETACLIENTE2='"+c.getnTarjetaCliente()+"' where dni like upper('"+c.getDni()+"')");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
