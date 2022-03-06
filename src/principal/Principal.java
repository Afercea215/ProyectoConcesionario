package principal;

import java.util.TreeMap;

import metodosEspecificos.DatosPrograma;
import objetos.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Empresa a = metodosEspecificos.DatosPrograma.creaEmpresaDefault();
	
	metodosEspecificos.DatosPrograma.importarDatos(a);
	
	a.grabaDatosEmpresa();
	
	a.leeDatosEmpresa();
	System.out.println(a.getAlquileres().size());	
	
	metodosEspecificos.InterfazUsuario.menuPrincipal(a);
	
	}

}
