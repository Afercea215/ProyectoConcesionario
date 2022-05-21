package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import entidades.Cliente;
import entidades.Empleado;
import entidades.Alquiler;
import entidades.Oficina;
import entidades.TipoCarnet;
import entidades.Vehiculo;
import gui.FormuAlquiler;
import miLibreria.objetos.Persona;

public class RepositorioAlquiler {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<Alquiler> arrayListAlquiler() {
		
		ArrayList<Alquiler> lista = new ArrayList<Alquiler>();
		String id="";
		Vehiculo vehiculo=null;
		Cliente cli=null;
		Oficina ofiAlquiler=null;
		Empleado emple=null;
		GregorianCalendar fechaIni=null;
		Oficina ofiDevolucion=null;
		GregorianCalendar fechaFin=null;
		Double precioPrevisto=0.00;
		Alquiler Alquiler = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select ID, VEHICULO, empleado, CLIENTE2, TO_CHAR(FECHAINIALQUILER,'DD-MM-YYYY'), OFICINAALQUILER, OFICINADEVOLUCION, TO_CHAR(FECHAFINPREVISTA, 'DD-MM-YYYY'), PRECIO_PREVISTO from ALQUILER");
			
			while (rs.next()) {
				id = rs.getString("id");
				cli = RepositorioCliente.buscaCliente(rs.getString("CLIENTE2"));
				ofiAlquiler = RepositorioOficina.buscaOficina(rs.getString("OFICINAALQUILER"));
				ofiDevolucion = RepositorioOficina.buscaOficina(rs.getString("OFICINAdevolucion"));
				emple = RepositorioEmpleado.buscaEmpleado(rs.getString("EMPLEADO"));
				
				
				System.out.println(rs.getString("TO_CHAR(FECHAINIALQUILER,'DD-MM-YYYY')"));
				
				fechaIni = AccesoADatos.convierteStringFecha(rs.getString("TO_CHAR(FECHAINIALQUILER,'DD-MM-YYYY')"));
				fechaFin = AccesoADatos.convierteStringFecha(rs.getString("TO_CHAR(FECHAFINPREVISTA,'DD-MM-YYYY')"));
				
				if (RepositorioCocheCombustion.buscaCocheCombustion(rs.getString("vehiculo"))!=null) {
					vehiculo =  RepositorioCocheCombustion.buscaCocheCombustion(rs.getString("vehiculo"));
				} 
				
				if (RepositorioCocheElectrico.buscaCocheElectrico(rs.getString("vehiculo"))!=null) {
					vehiculo =  RepositorioCocheElectrico.buscaCocheElectrico(rs.getString("vehiculo"));
				}
				
				if (RepositorioMoto.buscaMoto(rs.getString("vehiculo"))!=null) {
					vehiculo =  RepositorioMoto.buscaMoto(rs.getString("vehiculo"));
				} 
				
				if (RepositorioFurgoneta.buscaFurgoneta(rs.getString("vehiculo"))!=null) {
					vehiculo =  RepositorioFurgoneta.buscaFurgoneta(rs.getString("vehiculo"));
				} 
				
				ofiAlquiler = RepositorioOficina.buscaOficina(rs.getString("OFICINADEVOLUCION"));
				precioPrevisto = rs.getDouble("PRECIO_PREVISTO");
				
				Alquiler=new Alquiler(id, vehiculo, emple, cli, fechaIni, ofiAlquiler, ofiDevolucion, fechaFin, precioPrevisto);
				
				lista.add(Alquiler);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Busca la cliente que tenga ese id en la base de datos
	 * @param id id del cliente
	 * @return Cliente
	 */
	public static Alquiler buscaAlquiler(String id) {
		
		ArrayList<Alquiler> lista = new ArrayList<Alquiler>();
		Vehiculo vehiculo=null;
		Cliente cli=null;
		Oficina ofiAlquiler=null;
		Empleado emple=null;
		GregorianCalendar fechaIni=null;
		Oficina ofiDevolucion=null;
		GregorianCalendar fechaFin=null;
		Double precioPrevisto=0.00;
		Alquiler alquiler = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from alquiler where id LIKE '"+id+"'");
			
			while (rs.next()) {
				cli = RepositorioCliente.buscaCliente(rs.getString("CLIENTE2"));
				ofiAlquiler = RepositorioOficina.buscaOficina(rs.getString("OFICINAALQUILER"));
				emple = RepositorioEmpleado.buscaEmpleado(rs.getString("EMPLEADO"));
				fechaIni = new GregorianCalendar(rs.getDate("FECHAINIALQUILER").getYear(),rs.getDate("FECHAINIALQUILER").getMonth() , rs.getDate("FECHAINIALQUILER").getDay());
				fechaFin = new GregorianCalendar(rs.getDate("FECHAFINPREVISTA").getYear(),rs.getDate("FECHAFINPREVISTA").getMonth() , rs.getDate("FECHAFINPREVISTA").getDay());
				
				ofiAlquiler = RepositorioOficina.buscaOficina(rs.getString("OFICINADEVOLUCION"));
				precioPrevisto = rs.getDouble("PRECIO_PREVISTO");
				
				alquiler=new Alquiler(id, vehiculo, emple, cli, fechaIni, ofiAlquiler, ofiDevolucion, fechaFin, precioPrevisto);
				
							
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alquiler;
	}
	
	
	/**
	 * Borra el cliente que tenga el id en la base de datos
	 * @param id id del cliente
	 * @throws SQLException 
	 */
	public static void borraAlquiler(String id) throws SQLException {
		st = AccesoADatos.getCn().createStatement();
		st.executeQuery("delete from Alquiler where id like '"+id+"'");
		st.executeQuery("commit");
	}
	
	/**
	 * Crea el cliente en la base de datos
	 * @param id id del cliente
	 * @param ap1 Primer apellido del cliente
	 * @param ap2 Segundo apellido del cliente
	 * @param nombre Nombre del cliente
	 * @param fechaNac GregarianCalendar fecha del cliente
	 * @param carnetConducir TipoCarnet del cliente
	 * @param nTarjetaCliente Numero del cliente
	 */
	public static void creaAlquiler(Alquiler a) {
		
		int mes = a.getFechaIniAlquiler().get(Calendar.MONTH);
		int dia = a.getFechaIniAlquiler().get(Calendar.DAY_OF_MONTH);
		int año = a.getFechaIniAlquiler().get(Calendar.YEAR);
		
		int mes2 = a.getFechaFinPrevista().get(Calendar.MONTH);
		int dia2 = a.getFechaFinPrevista().get(Calendar.DAY_OF_MONTH);
		int año2 = a.getFechaFinPrevista().get(Calendar.YEAR);
		
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
		
		String mesString2="";
		if (mes2<10) {
			mesString2="0"+mes2;
		}else {
			mesString2=mes2+"";
		}
		
		String diaString2="";
		if (dia2<10) {
			diaString2="0"+dia2;
		}else {
			diaString2=dia2+"";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			
			st.executeQuery("insert into Alquiler values (upper('"+a.getId()+"'), upper('"+a.getVehiculo().getMatricula()+"'), upper('"+a.getEmpleado().getDni()+"'), upper('"+a.getCliente().getDni()+"'), upper('"+diaString+"/"+mesString+"/"+año+"'),upper('"+a.getOficinaAlquiler().getCod()+"'), upper('"+a.getOficinaDevolucion().getCod()+"'), upper('"+diaString2+"/"+mesString2+"/"+año2+"'), "+a.getAlquilerPrevisto()+")");
			st.executeQuery("commit");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	
	public static void updateAlquiler(Alquiler a) {
		
		int mes = a.getFechaIniAlquiler().get(Calendar.MONTH)+1;
		int dia = a.getFechaIniAlquiler().get(Calendar.DAY_OF_MONTH);
		int año = a.getFechaIniAlquiler().get(Calendar.YEAR)+1900;
		
		int mes2 = a.getFechaFinPrevista().get(Calendar.MONTH)+1;
		int dia2 = a.getFechaFinPrevista().get(Calendar.DAY_OF_MONTH);
		int año2 = a.getFechaFinPrevista().get(Calendar.YEAR)+1900;
		
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
		
		String mesString2="";
		if (mes2<10) {
			mesString2="0"+mes2;
		}else {
			mesString2=mes2+"";
		}
		
		String diaString2="";
		if (dia2<10) {
			diaString2="0"+dia2;
		}else {
			diaString2=dia2+"";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("update Alquiler set id='"+a.getId()+"', vehiculo=UPPER('"+a.getVehiculo().getMatricula()+"'), empleado=UPPER('"+a.getEmpleado().getDni()+"'), CLIENTE2=UPPER('"+a.getCliente().getDni()+"'), fechainialquiler='"+diaString+"/"+mesString+"/"+año+"', oficinaalquiler='"+a.getOficinaAlquiler().getCod()+"' , oficinadevolucion='"+a.getOficinaDevolucion().getCod()+"',fechafinprevista='"+diaString2+"/"+mesString2+"/"+año2+"', precio_previsto="+a.getAlquilerPrevisto()+" where id like upper('"+a.getId()+"')");
			st.executeQuery("commit");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}
