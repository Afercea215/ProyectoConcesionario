/**
 * 
 */
package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import entidades.Alquiler;
import entidades.Cliente;
import entidades.Empleado;
import entidades.Oficina;
import entidades.TipoCarnet;
import entidades.Vehiculo;
import gui.FormuAlquiler;
import miLibreria.objetos.Persona;

public class RepositorioAlquiler {
	
	private static Statement st=null;

	/**
	 * Lista de todos los alquileres
	 * @return List
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
		Alquiler alquiler = null;
		boolean finalizado=false;
		String finaString="";
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select ID, VEHICULO, empleado, CLIENTE2, TO_CHAR(FECHAINIALQUILER,'DD-MM-YYYY'), OFICINAALQUILER, OFICINADEVOLUCION, TO_CHAR(FECHAFINPREVISTA, 'DD-MM-YYYY'), PRECIO_PREVISTO, finalizado from ALQUILER");
			
			while (rs.next()) {
				id = rs.getString("id");
					
				finaString=rs.getString("finalizado");
				if (finaString.equalsIgnoreCase("s")) {
					finalizado=true;
				}
				cli = RepositorioCliente.buscaCliente(rs.getString("CLIENTE2"));
				ofiAlquiler = RepositorioOficina.buscaOficina(rs.getString("OFICINAALQUILER"));
				ofiDevolucion = RepositorioOficina.buscaOficina(rs.getString("OFICINAdevolucion"));
				emple = RepositorioEmpleado.buscaEmpleado(rs.getString("EMPLEADO"));
				
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
				
				precioPrevisto = rs.getDouble("PRECIO_PREVISTO");
				alquiler=new Alquiler(id, vehiculo, emple, cli, fechaIni, ofiAlquiler, ofiDevolucion, fechaFin, precioPrevisto, finalizado);
				
				lista.add(alquiler);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Lista de los alquileres que no estan completados
	 * @return Lista
	 */
	public static ArrayList<Alquiler> arrayListAlquilerNoCompletos() {
		
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
		Alquiler alquiler = null;
		boolean finalizado=false;
		String finaString="";
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select ID, VEHICULO, empleado, CLIENTE2, TO_CHAR(FECHAINIALQUILER,'DD-MM-YYYY'), OFICINAALQUILER, OFICINADEVOLUCION, TO_CHAR(FECHAFINPREVISTA, 'DD-MM-YYYY'), PRECIO_PREVISTO, finalizado from ALQUILER where finalizado like 'N'");
			
			while (rs.next()) {
				id = rs.getString("id");
					
				finaString=rs.getString("finalizado");
				if (finaString.equalsIgnoreCase("s")) {
					finalizado=true;
				}
				cli = RepositorioCliente.buscaCliente(rs.getString("CLIENTE2"));
				ofiAlquiler = RepositorioOficina.buscaOficina(rs.getString("OFICINAALQUILER"));
				ofiDevolucion = RepositorioOficina.buscaOficina(rs.getString("OFICINAdevolucion"));
				emple = RepositorioEmpleado.buscaEmpleado(rs.getString("EMPLEADO"));
				
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
				
				precioPrevisto = rs.getDouble("PRECIO_PREVISTO");
				alquiler=new Alquiler(id, vehiculo, emple, cli, fechaIni, ofiAlquiler, ofiDevolucion, fechaFin, precioPrevisto, finalizado);
				
				lista.add(alquiler);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Busca un alquiler
	 * @param id Codigo del alquiler
	 * @return Alquiler
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
		boolean finalizado=false;
		String finaString="";
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select ID, VEHICULO, empleado, CLIENTE2, TO_CHAR(FECHAINIALQUILER,'DD-MM-YYYY'), OFICINAALQUILER, OFICINADEVOLUCION, TO_CHAR(FECHAFINPREVISTA, 'DD-MM-YYYY'), PRECIO_PREVISTO, finalizado from ALQUILER where id like upper('"+id+"')");
			
			while (rs.next()) {
				id = rs.getString("id");
				cli = RepositorioCliente.buscaCliente(rs.getString("CLIENTE2"));
				if (cli!=null){
					
					finaString=rs.getString("finalizado");
					if (finaString.equalsIgnoreCase("s")) {
						finalizado=true;
					}else finalizado=false;
					
					
					ofiAlquiler = RepositorioOficina.buscaOficina(rs.getString("OFICINAALQUILER"));
					ofiDevolucion = RepositorioOficina.buscaOficina(rs.getString("OFICINAdevolucion"));
					emple = RepositorioEmpleado.buscaEmpleado(rs.getString("EMPLEADO"));
					
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
					
					precioPrevisto = rs.getDouble("PRECIO_PREVISTO");
					
					alquiler=new Alquiler(id, vehiculo, emple, cli, fechaIni, ofiAlquiler, ofiDevolucion, fechaFin, precioPrevisto, finalizado);
				} else break;
				
				
			}
			return alquiler;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alquiler;
	}
	
	
	/**
	 * Borra un alquilers
	 * @param id Codigo del alquiler
	 * @throws SQLException
	 */
	public static void borraAlquiler(String id) throws SQLException {
		st = AccesoADatos.getCn().createStatement();
		st.executeQuery("delete from Alquiler where id like '"+id+"'");
		st.executeQuery("commit");
	}
	

	/**
	 * Crea un alquiler en la base de datos
	 * @param a Alquiler que quieres subir a la DB
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
		
		String finalizado="";
		if (a.isFinalizado()) {
			finalizado="s";
		} else finalizado="n";
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("insert into Alquiler values (upper('"+a.getId()+"'), upper('"+a.getVehiculo().getMatricula()+"'), upper('"+a.getEmpleado().getDni()+"'), upper('"+a.getCliente().getDni()+"'), upper('"+diaString+"/"+mesString+"/"+año+"'),upper('"+a.getOficinaAlquiler().getCod()+"'), upper('"+a.getOficinaDevolucion().getCod()+"'), upper('"+diaString2+"/"+mesString2+"/"+año2+"'), "+a.getAlquilerPrevisto()+", upper('"+finalizado+"'))");
			st.executeQuery("update vehiculo set alquilado='T' WHERE MATRICULA LIKE '"+a.getVehiculo().getMatricula()+"'");
			st.executeQuery("commit");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Actualiza el alquiler que pases por parametro 
	 * @param a Alquiler
	 */
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
		
		String finalizado="";
		if (a.isFinalizado()) {
			finalizado="s";
		} else finalizado="n";
		
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("update Alquiler set id='"+a.getId()+"', vehiculo=UPPER('"+a.getVehiculo().getMatricula()+"'), empleado=UPPER('"+a.getEmpleado().getDni()+"'), CLIENTE2=UPPER('"+a.getCliente().getDni()+"'), fechainialquiler='"+diaString+"/"+mesString+"/"+año+"', oficinaalquiler='"+a.getOficinaAlquiler().getCod()+"' , oficinadevolucion='"+a.getOficinaDevolucion().getCod()+"',fechafinprevista='"+diaString2+"/"+mesString2+"/"+año2+"', precio_previsto="+a.getAlquilerPrevisto()+", finalizado=upper('"+finalizado+"') where id like upper('"+a.getId()+"')");
			st.executeQuery("commit");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}
