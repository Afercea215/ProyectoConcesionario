package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import entidades.Categoria;
import entidades.Cliente;
import entidades.CocheElectrico;
import entidades.Color;
import entidades.Moto;
import entidades.Oficina;
import entidades.TipoCarnet;
import miLibreria.objetos.Persona;

public class RepositorioCocheElectrico {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<CocheElectrico> arrayListCochesElectricos() {
		
		ArrayList<CocheElectrico> lista = new ArrayList<CocheElectrico>();
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
		int nPlazas=0;
		String tipoCoche="";
		int precioDirario=0;
		
		CocheElectrico coche;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from vehiculo m join electrico e on m.MATRICULA=e.MATRICULA join coche_electrico v on e.MATRICULA=v.MATRICULA");
			
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
				nPlazas = rs.getInt("n_plazas");
				tipoCoche = rs.getString("tipo_coche");
				
				coche=new CocheElectrico(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, autonomia, tiempoRecarga, nPlazas, tipoCoche);
				
				lista.add(coche);
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
	public static ArrayList<CocheElectrico> arrayListCochesElectricosOfi(String codOfi) {
		
		ArrayList<CocheElectrico> lista = new ArrayList<CocheElectrico>();
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
		int nPlazas=0;
		String tipoCoche="";
		int precioDirario=0;
		
		CocheElectrico coche;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from vehiculo m join electrico e on m.MATRICULA=e.MATRICULA join coche_electrico v on e.MATRICULA=v.MATRICULA where ofi like ('"+codOfi+"') and alquilado like 'N'");
			
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
				nPlazas = rs.getInt("n_plazas");
				tipoCoche = rs.getString("tipo_coche");
				
				coche=new CocheElectrico(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, autonomia, tiempoRecarga, nPlazas, tipoCoche);
				
				lista.add(coche);
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
	public static CocheElectrico buscaCocheElectrico (String matricula) {
		
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
		int nPlazas=0;
		String tipoCoche="";
		int precioDirario=0;
		
		CocheElectrico coche = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from vehiculo m join electrico e on m.MATRICULA=e.MATRICULA join coche_electrico v on e.MATRICULA=v.MATRICULA where v.matricula like upper('"+matricula+"')");
			
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
				nPlazas = rs.getInt("n_plazas");
				tipoCoche = rs.getString("tipo_coche");
				
				coche=new CocheElectrico(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, autonomia, tiempoRecarga, nPlazas, tipoCoche);
				
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coche;
	}
	
	
	/**
	 * Borra el cliente que tenga el dni en la base de datos
	 * @param dni DNI del cliente
	 * @throws SQLException 
	 */
	public static void borraCocheElectrico(String matriucla) throws SQLException {
		st = AccesoADatos.getCn().createStatement();
		st.executeQuery("delete from coche_electrico where matricula like '"+matriucla+"'");
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
	public static void creaCocheElectrico(CocheElectrico coche) {
		
		int mes = coche.getFechaAlta().get(Calendar.MONTH)+1;
		int dia = coche.getFechaAlta().get(Calendar.DAY_OF_MONTH);
		int año = coche.getFechaAlta().get(Calendar.YEAR);
		
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
		if (coche.isAlquilado()) {
			alqui="T";
		}else {
			alqui="F";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("insert into VEHICULO values (upper('"+coche.getMatricula()+"'), upper('"+coche.getMarca()+"'), upper('"+coche.getModelo()+"'), upper('"+coche.getColor()+"'), '"+diaString+"/"+mesString+"/"+año+"',"+coche.getKms()+", upper('"+coche.getOficina().getCod()+"'),upper('"+coche.getCategoria().getCodigo()+"'),upper('"+alqui+"'))");
			st.executeQuery("insert into electrico values (upper('"+coche.getMatricula()+"'), "+coche.getAutonimia()+", "+coche.getTiempoRecarga()+")");
			st.executeQuery("insert into coche_electrico values (upper('"+coche.getMatricula()+"'), "+coche.getN_plazas()+", upper('"+coche.getTipo()+"'), "+coche.getPrecioDiario()+")");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void updateCocheElectrico(CocheElectrico coche) {
		
		int mes = coche.getFechaAlta().get(Calendar.MONTH)+1;
		int dia = coche.getFechaAlta().get(Calendar.DAY_OF_MONTH);
		int año = coche.getFechaAlta().get(Calendar.YEAR);
		
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
		if (coche.isAlquilado()) {
			alqui="T";
		}else {
			alqui="F";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("update coche_electrico set n_plazas="+coche.getN_plazas()+", tipo_coche=upper('"+coche.getTipo()+"') where matricula like '"+coche.getMatricula()+"'");
			st.executeQuery("update electrico set autonomia="+coche.getAutonimia()+", tiemporecarga=+"+coche.getTiempoRecarga()+" where matricula like '"+coche.getMatricula()+"'");
			st.executeQuery("update vehiculo set marca=upper('"+coche.getMarca()+"'), modelo=upper('"+coche.getModelo()+"'),color=upper('"+coche.getColor()+"'),fecha_alta='"+diaString+"/"+mesString+"/"+año+"',kms="+coche.getKms()+",ofi=upper('"+coche.getOficina().getCod()+"'),catego=upper('"+coche.getCategoria().getCodigo()+"'),alquilado=upper('"+alqui+"') where matricula like '"+coche.getMatricula()+"'");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
