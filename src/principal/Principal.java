package principal;

import java.util.Scanner;
import java.util.TreeMap;

import metodos.DatosPrograma;
import objetos.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	Empresa a = metodos.DatosPrograma.creaEmpresaDefault();
	
	metodos.DatosPrograma.importarDatos(a);
	
	a.grabaDatosEmpresa();
	
	//a.leeDatosEmpresa();
	//System.out.println(a.getAlquileres().size());	
	
	Scanner in = new Scanner(System.in);
	
	metodos.Especificos.menuPrincipal(a, in);
	
	}

}
