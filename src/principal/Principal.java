package principal;

import java.util.Scanner;

import java.util.TreeMap;
import metodos.GestionEmpresa;
import objetos.*;

public class Principal {
	
	public static Empresa empresa;
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	//empresa = metodos.DatosPrograma.creaEmpresaDefault();
	//System.out.println(a.getClass());
	//metodos.DatosPrograma.importarDatos(empresa);
	
    
    //empresa.grabaDatosEmpresa();
    empresa=Empresa.leeDatosFichero();
    
	Scanner in = new Scanner(System.in);
	
	metodos.Especificos.menuPrincipal();

	
	}

}
