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

	////////////////////////////////////////
	//	CONTRASE�A : Andres1234
	///////////////////////////////////////
    empresa=Empresa.leeDatosFichero();
    
	Scanner in = new Scanner(System.in);
	
	metodos.Especificos.menuPrincipal();

	
	}

}
