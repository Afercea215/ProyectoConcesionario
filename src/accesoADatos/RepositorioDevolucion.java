package accesoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import entidades.Alquiler;
import entidades.Cliente;
import entidades.Devolucion;
import entidades.Empleado;
import entidades.Oficina;
import entidades.TipoCarnet;
import entidades.Vehiculo;
import gui.FormuDevolucion;
import miLibreria.objetos.Persona;

public class RepositorioDevolucion {
	
	private static Statement st=null;

	/**
	 * Devuelve todas las clientes de la base de datos.
	 * @return ArrayList con los clientes
	 */
	public static ArrayList<Devolucion> arrayListDevolucion() {
		
		ArrayList<Devolucion> lista = new ArrayList<Devolucion>();
		String id="";
		Alquiler alqui=null;
		Cliente cli=null;
		Empleado emple=null;
		int kms=0;
		GregorianCalendar fecha=null;
		Oficina ofi=null;
		Vehiculo vehiculo=null;
		Double precio=0.0;
		Devolucion dev=null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select ID, PRECIO, alquiler, VEHICULO, empleado, CLIENTE2, TO_CHAR(FECHADevolucionreal,'DD-MM-YYYY'), OFICINA, kmsrecorridos from Devolucion");
			
			while (rs.next()) {
				id = rs.getString("id");
				precio = rs.getDouble("precio");
				cli = RepositorioCliente.buscaCliente(rs.getString("CLIENTE2"));
				ofi = RepositorioOficina.buscaOficina(rs.getString("OFICINA"));
				emple = RepositorioEmpleado.buscaEmpleado(rs.getString("EMPLEADO"));
				fecha = AccesoADatos.convierteStringFecha(rs.getString("TO_CHAR(FECHADevolucionreal,'DD-MM-YYYY')"));
				kms = rs.getInt("kmsrecorridos");
				alqui = RepositorioAlquiler.buscaAlquiler(rs.getString("alquiler"));
				
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
				
				
				dev=new Devolucion(id, ofi, alqui, vehiculo, kms, fecha, emple, cli, precio);
				lista.add(dev);
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
	public static Devolucion buscaDevolucion(String id) {
		
		Alquiler alqui=null;
		Cliente cli=null;
		Empleado emple=null;
		int kms=0;
		GregorianCalendar fecha=null;
		Oficina ofi=null;
		Vehiculo vehiculo=null;
		Double precio=0.0;
		Devolucion dev=null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select ID,precio, alquiler, VEHICULO, empleado, CLIENTE2, TO_CHAR(FECHADevolucionreal,'DD-MM-YYYY'), OFICINA, kmsrecorridos from Devolucion where alquiler like upper('"+id+"')");
			
			while (rs.next()) {
				cli = RepositorioCliente.buscaCliente(rs.getString("CLIENTE2"));
				ofi = RepositorioOficina.buscaOficina(rs.getString("OFICINA"));
				emple = RepositorioEmpleado.buscaEmpleado(rs.getString("EMPLEADO"));
				fecha = AccesoADatos.convierteStringFecha(rs.getString("TO_CHAR(FECHADevolucionreal,'DD-MM-YYYY')"));
				kms = rs.getInt("kmsrecorridos");
				precio = rs.getDouble("precio");
				alqui = RepositorioAlquiler.buscaAlquiler(rs.getString("alquiler"));
				
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
				
				dev=new Devolucion(id, ofi, alqui, vehiculo, kms, fecha, emple, cli, precio);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dev;
	}
	
	
	/**
	 * Borra el cliente que tenga el id en la base de datos
	 * @param id id del cliente
	 * @throws SQLException 
	 */
	public static void borraDevolucion(String id) throws SQLException {
		st = AccesoADatos.getCn().createStatement();
		st.executeQuery("delete from Devolucion where alquiler like '"+id+"'");
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
	public static void creaDevolucion(Devolucion a) {
		
		int mes = a.getFechaDevolucionReal().get(Calendar.MONTH);
		int dia = a.getFechaDevolucionReal().get(Calendar.DAY_OF_MONTH);
		int año = a.getFechaDevolucionReal().get(Calendar.YEAR);
		
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
			
			st.executeQuery("insert into Devolucion values (upper('"+a.getId()+"'), upper('"+a.getOficina().getCod()+"'), upper('"+a.getAlquiler().getId()+"'), upper('"+a.getVehiculo().getMatricula()+"'), "+a.getKmsRecorridos()+", upper('"+diaString+"/"+mesString+"/"+año+"'),upper('"+a.getEmpleado().getDni()+"'), upper('"+a.getCliente().getDni()+"'), "+a.getPrecio()+")");
			st.executeQuery("update alquiler set finalizado='S' where id like '"+a.getAlquiler().getId()+"'");
			st.executeQuery("update from vehiculo set alquilado='F' WHERE MATRICULA LIKE '"+a.getVehiculo().getMatricula()+"'");
			st.executeQuery("commit");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	
	public static void updateDevolucion(Devolucion a) {
		
		int mes = a.getFechaDevolucionReal().get(Calendar.MONTH)+1;
		int dia = a.getFechaDevolucionReal().get(Calendar.DAY_OF_MONTH);
		int año = a.getFechaDevolucionReal().get(Calendar.YEAR)+1900;
		
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
			st.executeQuery("update Devolucion set id='"+a.getId()+"', vehiculo=UPPER('"+a.getVehiculo().getMatricula()+"'), empleado=UPPER('"+a.getEmpleado().getDni()+"'), CLIENTE2=UPPER('"+a.getCliente().getDni()+"'), fechaDevolucionreal='"+diaString+"/"+mesString+"/"+año+"', oficina='"+a.getOficina().getCod()+"', kmsrecorridos="+a.getKmsRecorridos()+", alquiler='"+a.getAlquiler().getId()+"', precio "+a.getPrecio()+" where id like upper('"+a.getId()+"')");
			st.executeQuery("commit");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
public static String generaID() {
		
		ArrayList<String> listId = new ArrayList<String>();
		String id;
		int b= 1000+(int)(Math.random()*9999);
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select ID from Devolucion");
			
			while (rs.next()) {
				listId.add(rs.getString("id"));
			}
			
			
			for (String a : listId) {
				if (a.equals(b) || (b<1000 || b>9999)) {
					b= 1000+(int)(Math.random()*9999);
				}

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b+"";
	}
}
