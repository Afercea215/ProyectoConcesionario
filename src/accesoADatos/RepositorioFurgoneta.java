package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Furgoneta;
import entidades.Color;
import entidades.Moto;
import entidades.NivelEmision;
import entidades.Oficina;
import entidades.TipoCarnet;
import miLibreria.objetos.Persona;

public class RepositorioFurgoneta {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<Furgoneta> arrayListfurgosCombustion() {
		
		ArrayList<Furgoneta> lista = new ArrayList<Furgoneta>();
		String matricula="";
		String marca="";
		String modelo="";
		Color color=null;
		GregorianCalendar fechaAlta=null;
		int kms=0;
		Oficina ofi= null;
		Categoria cat = null;
		boolean alquilado;
		
		int consumo=0;
		int potencia=0;
		NivelEmision nivelEmision=null;
		
		int capacidadCarga=0;
		TipoCarnet tipoCarnet=null;
		
		int precioDirario=0;
		
		Furgoneta furgo;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from vehiculo m join combustion e on m.MATRICULA=e.MATRICULA join furgoneta v on e.MATRICULA=v.MATRICULA");
			
			while (rs.next()) {
				matricula = rs.getString("matricula");
				marca = rs.getString("marca");
				modelo = rs.getString("modelo");
				color = new Color(rs.getString("color"));
				fechaAlta = new GregorianCalendar(rs.getDate("FECHA_ALTA").getYear(),rs.getDate("FECHA_ALTA").getMonth() , rs.getDate("FECHA_ALTA").getDay());
				kms = rs.getInt("kms");
				ofi = RepositorioOficina.buscaOficina(rs.getString("ofi"));
				cat = RepositorioCategoria.buscaCategoria(rs.getString("categO"));
				if (rs.getString("alquilado").equals("s")) {
					alquilado=true;
				}else alquilado=false;
				
				consumo = rs.getInt("consumo");
				potencia = rs.getInt("potencia");
				nivelEmision = RepositorioNivelEmision.buscaNivelEmision(rs.getString("n_emision"));
				
				capacidadCarga = rs.getInt("capacidadcarga");
				tipoCarnet = RepositorioTipoCarnet.buscaTipoCarnet(rs.getString("tipocarnet"));
				
				furgo=new Furgoneta(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, consumo, potencia, nivelEmision, capacidadCarga, tipoCarnet);
				
				lista.add(furgo);
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
	public static Furgoneta buscaFurgoneta (String matricula) {
		
		String marca="";
		String modelo="";
		Color color=null;
		GregorianCalendar fechaAlta=null;
		int kms=0;
		Oficina ofi= null;
		Categoria cat = null;
		boolean alquilado;
		int consumo=0;
		int potencia=0;
		NivelEmision nivelEmision=null;
		
		
		int capacidadCarga=0;
		TipoCarnet tipoCarnet=null;
		
		int precioDirario=0;
		
		Furgoneta furgo = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
 			ResultSet rs = st.executeQuery("select * from vehiculo m join combustion e on m.MATRICULA=e.MATRICULA join furgoneta v on e.MATRICULA=v.MATRICULA where v.matricula like upper('"+matricula+"')");
			
			while (rs.next()) {
				matricula = rs.getString("matricula");
				marca = rs.getString("marca");
				modelo = rs.getString("modelo");
				color = new Color(rs.getString("color"));
				fechaAlta = new GregorianCalendar(rs.getDate("FECHA_ALTA").getYear(),rs.getDate("FECHA_ALTA").getMonth() , rs.getDate("FECHA_ALTA").getDay());
				kms = rs.getInt("kms");
				ofi = RepositorioOficina.buscaOficina(rs.getString("ofi"));
				cat = RepositorioCategoria.buscaCategoria(rs.getString("categO"));
				if (rs.getString("alquilado").equals("s")) {
					alquilado=true;
				}else alquilado=false;
				
				consumo = rs.getInt("consumo");
				potencia = rs.getInt("potencia");
				nivelEmision = RepositorioNivelEmision.buscaNivelEmision(rs.getString("n_emision"));
				
				capacidadCarga = rs.getInt("capacidadcarga");
				tipoCarnet = RepositorioTipoCarnet.buscaTipoCarnet(rs.getString("tipocarnet"));
				
				furgo=new Furgoneta(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, consumo, potencia, nivelEmision, capacidadCarga, tipoCarnet);				
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return furgo;
	}
	
	
	/**
	 * Borra el cliente que tenga el dni en la base de datos
	 * @param dni DNI del cliente
	 * @throws SQLException 
	 */
	public static void borraFurgoneta(String matriucla) throws SQLException {
		st = AccesoADatos.getCn().createStatement();
		st.executeQuery("delete from furgoneta where matricula like '"+matriucla+"'");
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
	public static void creaFurgoneta (Furgoneta furgo) {
		
		int mes = furgo.getFechaAlta().get(Calendar.MONTH)+1;
		int dia = furgo.getFechaAlta().get(Calendar.DAY_OF_MONTH);
		int año = furgo.getFechaAlta().get(Calendar.YEAR);
		
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
		if (furgo.isAlquilado()) {
			alqui="T";
		}else {
			alqui="F";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("insert into VEHICULO values (upper('"+furgo.getMatricula()+"'), upper('"+furgo.getMarca()+"'), upper('"+furgo.getModelo()+"'), upper('"+furgo.getColor()+"'), '"+diaString+"/"+mesString+"/"+año+"',"+furgo.getKms()+", upper('"+furgo.getOficina().getCod()+"'),upper('"+furgo.getCategoria().getCodigo()+"'),upper('"+alqui+"'))");
			st.executeQuery("insert into combustion values (upper('"+furgo.getMatricula()+"'), "+furgo.getConsumo()+", "+furgo.getPotencia()+", '"+furgo.getNivelEmison().getLetra()+"')");
			st.executeQuery("insert into furgoneta values (upper('"+furgo.getMatricula()+"'), "+furgo.getCapacidadCarga()+", upper('"+furgo.getCarnetRequerido().getNombre()+"'), "+furgo.getPrecioDiario()+")");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void updateFurgoneta(Furgoneta furgo) {
		
		int mes = furgo.getFechaAlta().get(Calendar.MONTH)+1;
		int dia = furgo.getFechaAlta().get(Calendar.DAY_OF_MONTH);
		int año = furgo.getFechaAlta().get(Calendar.YEAR);
		
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
		if (furgo.isAlquilado()) {
			alqui="T";
		}else {
			alqui="F";
		}
		
		try {
			st = AccesoADatos.getCn().createStatement();
			st.executeQuery("update furgoneta set capacidadcarga="+furgo.getCapacidadCarga()+", tipocarnet=upper('"+furgo.getCarnetRequerido().getNombre()+"') where matricula like '"+furgo.getMatricula()+"'");
			st.executeQuery("update combustion set consumo="+furgo.getConsumo()+", potencia=+"+furgo.getPotencia()+", n_emision='"+furgo.getNivelEmison().getLetra()+"' where matricula like '"+furgo.getMatricula()+"'");
			st.executeQuery("update vehiculo set marca=upper('"+furgo.getMarca()+"'), modelo=upper('"+furgo.getModelo()+"'),color=upper('"+furgo.getColor()+"'),fecha_alta='"+diaString+"/"+mesString+"/"+año+"',kms="+furgo.getKms()+",ofi=upper('"+furgo.getOficina().getCod()+"'),catego=upper('"+furgo.getCategoria().getCodigo()+"'),alquilado=upper('"+alqui+"') where matricula like '"+furgo.getMatricula()+"'");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
