package principal;

import java.util.Scanner;

import java.util.TreeMap;

import acessoADatos.AccesoADatos;
import entidades.*;
import gui.VentanaPrincipal;
import metodos.GestionEmpresa;

public class Principal {
	
	public static Empresa empresa;
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		AccesoADatos.abreConexion();
		VentanaPrincipal v = new VentanaPrincipal();	
		v.setVisible(true);
	////////////////////////////////////////
	//	CONTRASEŅA : Andres1234
	///////////////////////////////////////
    //empresa=Empresa.leeDatosFichero();
    
	//Scanner in = new Scanner(System.in);
	
	//metodos.Especificos.menuPrincipal();

	
	}

}
