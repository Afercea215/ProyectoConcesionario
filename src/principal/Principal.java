package principal;

import java.util.Scanner;

import java.util.TreeMap;

import accesoADatos.AccesoADatos;
import entidades.Empresa;
import entidades.*;
import gui.VentanaPrincipal;

public class Principal {
	
	public static Empresa empresa;
	public static Scanner in = new Scanner(System.in);
	public static VentanaPrincipal v = new VentanaPrincipal();	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		AccesoADatos.abreConexion();
		gui.MetodosGUI.centrarJFrame(v);
		v.setVisible(true);
	////////////////////////////////////////
	//	CONTRASE�A : Andres1234
	///////////////////////////////////////
    //empresa=Empresa.leeDatosFichero();
    
	//Scanner in = new Scanner(System.in);
	
	//metodos.Especificos.menuPrincipal();

	
	}

}
