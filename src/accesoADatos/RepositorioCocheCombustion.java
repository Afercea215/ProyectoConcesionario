package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import entidades.Categoria;
import entidades.Cliente;
import entidades.CocheCombustion;
import entidades.CocheElectrico;
import entidades.Color;
import entidades.Moto;
import entidades.NivelEmision;
import entidades.Oficina;
import entidades.TipoCarnet;
import miLibreria.objetos.Persona;

public class RepositorioCocheCombustion {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<CocheCombustion> arrayListCochesCombustion() {
		
		ArrayList<CocheCombustion> lista = new ArrayList<CocheCombustion>();
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
		
		int nPlazas=0;
		String tipoCoche="";
		int precioDirario=0;
		
		CocheCombustion coche;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from vehiculo m join combustion e on m.MATRICULA=e.MATRICULA join coche_combustion v on e.MATRICULA=v.MATRICULA");
			
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
				
				nPlazas = rs.getInt("n_plazas");
				tipoCoche = rs.getString("tipo_coche");
				
				coche=new CocheCombustion(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, consumo, potencia, nivelEmision, nPlazas, tipoCoche);
				
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
	public static CocheCombustion buscaCocheCombustion (String matricula) {
		
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
		
		
		int nPlazas=0;
		String tipoCoche="";
		int precioDirario=0;
		
		CocheCombustion coche = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
 			ResultSet rs = st.executeQuery("select * from vehiculo m join combustion e on m.MATRICULA=e.MATRICULA join coche_combustion v on e.MATRICULA=v.MATRICULA where v.matricula like upper('"+matricula+"')");
			
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
				
				nPlazas = rs.getInt("n_plazas");
				tipoCoche = rs.getString("tipo_coche");
				
				coche=new CocheCombustion(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, consumo, potencia, nivelEmision, nPlazas, tipoCoche);
				
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
	public static void borraCocheCombustion(String matriucla) throws SQLException {
		st = AccesoADatos.getCn().createStatement();
		st.executeQuery("delete from coche_combustion where matricula like '"+matriucla+"'");
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
	public static void creaCocheCombustion (CocheCombustion coche) {
		
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
			st.executeQuery("insert into combustion values (upper('"+coche.getMatricula()+"'), "+coche.getConsumo()+", "+coche.getPotencia()+", '"+coche.getNivelEmison().getLetra()+"')");
			st.executeQuery("insert into coche_combustion values (upper('"+coche.getMatricula()+"'), "+coche.getN_plazas()+", upper('"+coche.getTipo()+"'), "+coche.getPrecioDiario()+")");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void updateCocheCombustion(CocheCombustion coche) {
		
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
			st.executeQuery("update coche_combustion set n_plazas="+coche.getN_plazas()+", tipo_coche=upper('"+coche.getTipo()+"') where matricula like '"+coche.getMatricula()+"'");
			st.executeQuery("update combustion set consumo="+coche.getConsumo()+", potencia=+"+coche.getPotencia()+", n_emision='"+coche.getNivelEmison().getLetra()+"' where matricula like '"+coche.getMatricula()+"'");
			st.executeQuery("update vehiculo set marca=upper('"+coche.getMarca()+"'), modelo=upper('"+coche.getModelo()+"'),color=upper('"+coche.getColor()+"'),fecha_alta='"+diaString+"/"+mesString+"/"+año+"',kms="+coche.getKms()+",ofi=upper('"+coche.getOficina().getCod()+"'),catego=upper('"+coche.getCategoria().getCodigo()+"'),alquilado=upper('"+alqui+"') where matricula like '"+coche.getMatricula()+"'");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
