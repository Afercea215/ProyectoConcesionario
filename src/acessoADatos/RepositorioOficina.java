package acessoADatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Oficina;

public class RepositorioOficina {
	
	private static Statement st=null;

	public static ArrayList<Oficina> arrayListOficinas() {
		
		ArrayList<Oficina> lista = new ArrayList<Oficina>();
		String cod="";
		String desc="";
		String nomProv="";
		String nomLoc="";
		boolean ofiAero=false;
		Oficina o = null;
		
		try {
			st = AccesoADatos.getCn().createStatement();
			ResultSet rs = st.executeQuery("select * from oficina");
			
			while (rs.next()) {
				cod = rs.getString("COD");
				desc = rs.getString("DESCRIPCION");
				nomProv = rs.getString("NOMBREPROV");
				nomLoc = rs.getString("NOMBRELOC");
				ofiAero = rs.getBoolean("OFIAEROPUERTO");
				o=new Oficina(cod, desc, nomProv, nomLoc, ofiAero);
				
				lista.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
