package metodosEspecificos;

import java.util.ArrayList;
import java.util.*;
import objetos.*;

public class InterfazUsuario {

	public static void menuPrincipal() {
		
		//1.Modificaión y Gestión empresa.
		//2.Alquiler vehiculo.
		//3.Devolver un Vehiculo.
		//4.Salir
		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Modificación de la empresa.");
		list_opc.add("Alquilar Vehiculo.");
		list_opc.add("Devolver un Vehículo.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
		opc_posibles.add("1");
		opc_posibles.add("2");
		opc_posibles.add("3");
		opc_posibles.add("4");
		
		//creo el scanner para pedir los datos.
		Scanner in = new Scanner(System.in);
		
		
		//bucle hasta la opcion salir
		do {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
			opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
			
			switch (opcion)
			{
			case "1":
				System.out.println();
				break;
			case "2":
				System.out.println();
				break;
			case "3":
				System.out.println();
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
			
		}while (opcion.indexOf("4")!=-1);
		
	}
	
	
}
