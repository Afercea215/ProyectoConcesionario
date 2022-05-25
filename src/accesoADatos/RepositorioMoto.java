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
import entidades.Moto;
import entidades.Oficina;
import entidades.TipoCarnet;
import miLibreria.objetos.Persona;

public class RepositorioMoto {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<Moto> arrayListMotos() {
		
		ArrayList<Moto> lista = new ArrayList<Moto>();
		String matricula="";
		String marca="";
		String modelo="";
		Color color=null;
		GregorianCalendar fechaAlta=null;
		int kms=0;
		Oficina ofi= null;
		Categoria cat = null;
		boolean alquilado;
		int autonomia=0;
		int tiempoRecarga=0;
		int cilindrada=0;
		TipoCarnet carnet = null;
		int precioDirario=0;
		
		Moto moto;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from vehiculo m join electrico e on m.MATRICULA=e.MATRICULA join moto v on e.MATRICULA=v.MATRICULA");
			
			while (rs.next()) {
				matricula = rs.getString("matricula");
				marca = rs.getString("marca");
				modelo = rs.getString("modelo");
				color = new Color(rs.getString("color"));
				fechaAlta = new GregorianCalendar(rs.getDate("FECHA_ALTA").getYear(),rs.getDate("FECHA_ALTA").getMonth() , rs.getDate("FECHA_ALTA").getDay());
				kms = rs.getInt("kms");
				ofi = RepositorioOficina.buscaOficina(rs.getString("ofi"));
				cat = RepositorioCategoria.buscaCategoria(rs.getString("categO"));
				if (rs.getString("alquilado").equals("T")) {
					alquilado=true;
				}else alquilado=false;
				
				autonomia = rs.getInt("autonomia");
				tiempoRecarga = rs.getInt("tiemporecarga");
				cilindrada = rs.getInt("cIlindrada");
				carnet= RepositorioTipoCarnet.buscaTipoCarnet(rs.getString("TIPOCARNET"));
				
				moto=new Moto(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, autonomia, tiempoRecarga, cilindrada, carnet);
				
				lista.add(moto);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<Moto> arrayListMotosOfi(String codOfi) {
		
		ArrayList<Moto> lista = new ArrayList<Moto>();
		String matricula="";
		String marca="";
		String modelo="";
		Color color=null;
		GregorianCalendar fechaAlta=null;
		int kms=0;
		Oficina ofi= null;
		Categoria cat = null;
		boolean alquilado;
		int autonomia=0;
		int tiempoRecarga=0;
		int cilindrada=0;
		TipoCarnet carnet = null;
		int precioDirario=0;
		
		Moto moto;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from vehiculo m join electrico e on m.MATRICULA=e.MATRICULA join moto v on e.MATRICULA=v.MATRICULA where ofi like upper('"+codOfi+"') and alquilado like 'F'");
			
			while (rs.next()) {
				matricula = rs.getString("matricula");
				marca = rs.getString("marca");
				modelo = rs.getString("modelo");
				color = new Color(rs.getString("color"));
				fechaAlta = new GregorianCalendar(rs.getDate("FECHA_ALTA").getYear(),rs.getDate("FECHA_ALTA").getMonth() , rs.getDate("FECHA_ALTA").getDay());
				kms = rs.getInt("kms");
				ofi = RepositorioOficina.buscaOficina(rs.getString("ofi"));
				cat = RepositorioCategoria.buscaCategoria(rs.getString("categO"));
				if (rs.getString("alquilado").equals("T")) {
					alquilado=true;
				}else alquilado=false;
				
				autonomia = rs.getInt("autonomia");
				tiempoRecarga = rs.getInt("tiemporecarga");
				cilindrada = rs.getInt("cIlindrada");
				carnet= RepositorioTipoCarnet.buscaTipoCarnet(rs.getString("TIPOCARNET"));
				
				moto=new Moto(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, autonomia, tiempoRecarga, cilindrada, carnet);
				
				lista.add(moto);
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
	public static Moto buscaMoto(String matricula) {
		
		String marca="";
		String modelo="";
		Color color=null;
		GregorianCalendar fechaAlta=null;
		int kms=0;
		Oficina ofi= null;
		Categoria cat = null;
		boolean alquilado;
		int autonomia=0;
		int tiempoRecarga=0;
		int cilindrada=0;
		TipoCarnet carnet = null;
		int precioDirario=0;
		
		Moto moto = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from vehiculo m join electrico e on m.MATRICULA=e.MATRICULA join moto v on e.MATRICULA=v.MATRICULA WHERE E.MATRICULA LIKE '"+matricula+"'");
			
			while (rs.next()) {
				matricula = rs.getString("matricula");
				marca = rs.getString("marca");
				modelo = rs.getString("modelo");
				color = new Color(rs.getString("color"));
				fechaAlta = new GregorianCalendar(rs.getDate("FECHA_ALTA").getYear(),rs.getDate("FECHA_ALTA").getMonth() , rs.getDate("FECHA_ALTA").getDay());
				kms = rs.getInt("kms");
				ofi = RepositorioOficina.buscaOficina(rs.getString("ofi"));
				cat = RepositorioCategoria.buscaCategoria(rs.getString("categO"));
				if (rs.getString("alquilado").equals("T")) {
					alquilado=true;
				}else alquilado=false;
				
				autonomia = rs.getInt("autonomia");
				tiempoRecarga = rs.getInt("tiemporecarga");
				cilindrada = rs.getInt("cIlindrada");
				carnet= RepositorioTipoCarnet.buscaTipoCarnet(rs.getString("TIPOCARNET"));
				
				moto=new Moto(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, autonomia, tiempoRecarga, cilindrada, carnet);
					
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moto;
	}
	
	
	/**
	 * Borra el cliente que tenga el dni en la base de datos
	 * @param dni DNI del cliente
	 * @throws SQLException 
	 */
	public static void borraMoto(String matriucla) throws SQLException {
		st = AccesoADatos.getCn().createStatement();
		st.executeQuery("delete from moto where matricula like '"+matriucla+"'");
		st.executeQuery("delete from electrico where matricula like '"+matriucla+"'");
		st.executeQuery("delete from vehiculo where matricula like '"+matriucla+"'");
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
	public static void creaMoto(Moto m) {
		
		int mes = m.getFechaAlta().get(Calendar.MONTH)+1;
		int dia = m.getFechaAlta().get(Calendar.DAY_OF_MONTH);
		int año = m.getFechaAlta().get(Calendar.YEAR);
		
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
		
		String alqui="";
		if (m.isAlquilado()) {
			alqui="T";
		}else {
			alqui="F";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("insert into VEHICULO values (upper('"+m.getMatricula()+"'), upper('"+m.getMarca()+"'), upper('"+m.getModelo()+"'), upper('"+m.getColor()+"'), '"+diaString+"/"+mesString+"/"+año+"',"+m.getKms()+", upper('"+m.getOficina().getCod()+"'),upper('"+m.getCategoria().getCodigo()+"'),upper('"+alqui+"'))");
			st.executeQuery("insert into electrico values (upper('"+m.getMatricula()+"'), "+m.getAutonimia()+", "+m.getTiempoRecarga()+")");
			st.executeQuery("insert into moto values (upper('"+m.getMatricula()+"'), "+m.getCilindrada()+", upper('"+m.getCarnetRequerido().getNombre()+"'), "+m.getPrecioDiario()+")");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void updateMoto(Moto m) {
		
		int mes = m.getFechaAlta().get(Calendar.MONTH)+1;
		int dia = m.getFechaAlta().get(Calendar.DAY_OF_MONTH);
		int año = m.getFechaAlta().get(Calendar.YEAR);
		
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
		
		String alqui="";
		if (m.isAlquilado()) {
			alqui="T";
		}else {
			alqui="F";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("update moto set cilindrada="+m.getCilindrada()+", tipocarnet=upper('"+m.getCarnetRequerido().getNombre()+"') where matricula like '"+m.getMatricula()+"'");
			st.executeQuery("update electrico set autonomia="+m.getAutonimia()+", tiemporecarga=+"+m.getTiempoRecarga()+" where matricula like '"+m.getMatricula()+"'");
			st.executeQuery("update vehiulo set marca=upper('"+m.getMarca()+"'), modelo=upper('"+m.getModelo()+"'),color=upper('"+m.getColor()+"'),fecha_alta='"+diaString+"/"+mesString+"/"+año+"',kms="+m.getKms()+",ofi=upper('"+m.getOficina().getCod()+"'),catego=upper('"+m.getCategoria().getCodigo()+"'),alquilado=upper('"+alqui+"') where matricula like '"+m.getMatricula()+"'");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
