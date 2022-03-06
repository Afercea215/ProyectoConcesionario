package metodosEspecificos;

import java.util.ArrayList;

import java.util.*;
import objetos.*;

public class InterfazUsuario {

	public static void menuPrincipal(Empresa a) {
		
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
				menuGestionEmpresa(a);
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
			
		}while (opcion.indexOf("4")==-1);
		
	}

	public static void menuGestionEmpresa(Empresa a) {
		String opcion="";
		
		//creo el scanner para pedir los datos.
		Scanner in = new Scanner(System.in);
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Gestionar Vehiculos de la empresa.");
		list_opc.add("Gestionar Categorias de la empresa.");
		list_opc.add("Gestionar Oficinas de la empresa.");
		list_opc.add("Gestionar Empleados de la empresa.");
		list_opc.add("Gestionar Clientes de la empresa.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
		opc_posibles.add("1");
		opc_posibles.add("2");
		opc_posibles.add("3");
		opc_posibles.add("4");
		opc_posibles.add("5");
		opc_posibles.add("6");
		
		do {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
			opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
			
			switch (opcion)
			{
			case "1":
				menuGestionVehiculos(a);
				break;
			case "2":
				System.out.println();
				break;
			case "3":
				System.out.println();
				break;
			case "4":
				
				break;
			case "5":
				System.out.println();
				break;
			case "6":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("6")==-1);
	
	}
	
	public static void menuGestionVehiculos(Empresa a) {
		String opcion="";
		
		//creo el scanner para pedir los datos.
		Scanner in = new Scanner(System.in);
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Añadir Vehiculo.");
		list_opc.add("Eliminar Vehiculo.");
		list_opc.add("Modificar Vehiculo.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
		opc_posibles.add("1");
		opc_posibles.add("2");
		opc_posibles.add("3");
		opc_posibles.add("4");
				
		do {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
			opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
			
			switch (opcion)
			{
			case "1":
				menuAñadirVehiculo(a);
				break;
			case "2":
				menuEliminarVehiculo(a);
				break;
			case "3":
				System.out.println();
				break;
			case "4":
				
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	
	}
	
	public static void menuAñadirVehiculo(Empresa a) {
		String opcion="";
		
		//creo el scanner para pedir los datos.
		Scanner in = new Scanner(System.in);
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Moto.");
		list_opc.add("Furgoneta.");
		list_opc.add("Coche de combustión.");
		list_opc.add("Coche de electrico.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
		opc_posibles.add("1");
		opc_posibles.add("2");
		opc_posibles.add("3");
		opc_posibles.add("4");
		opc_posibles.add("5");
				
		do {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Tipo", opc_posibles, ".");
			opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.pideyCreaMoto(a, in);
				System.out.println("¡Vehiculo Creado!");
				break;
			case "2":
				GestionEmpresa.pideyCreaFurgoneta(a, in);
				System.out.println("¡Vehiculo Creado!");
				break;
			case "3":
				GestionEmpresa.pideyCreaCocheCombustion(a, in);
				System.out.println("¡Vehiculo Creado!");
				break;
			case "4":
				GestionEmpresa.pideyCreaCocheElectrico(a, in);
				System.out.println("¡Vehiculo Creado!");
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			break;
			
		}while (opcion.indexOf("5")==-1);
	
	}
	
	public static void menuEliminarVehiculo(Empresa a) {
		String opcion="";
		
		//creo el scanner para pedir los datos.
		Scanner in = new Scanner(System.in);
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Moto.");
		list_opc.add("Furgoneta.");
		list_opc.add("Coche de combustión.");
		list_opc.add("Coche de electrico.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
		opc_posibles.add("1");
		opc_posibles.add("2");
		opc_posibles.add("3");
		opc_posibles.add("4");
		opc_posibles.add("5");
				
		do {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Tipo", opc_posibles, ".");
			opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.pideyEliminaMoto(a, in);
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "2":
				GestionEmpresa.pideyEliminaFurgoneta(a, in);
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "3":
				GestionEmpresa.pideyEliminaCocheCombustion(a, in);
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "4":
				GestionEmpresa.pideyEliminaCocheElectrico(a, in);
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			break;
			
		}while (opcion.indexOf("5")==-1);
	
	}

	public static void menuEligeCategoria(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Categoria> b : a.getCategorias().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecciona la categoria", opc_posibles, ".");
		
	}
	
	public static void menuEligeOficina(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Oficina> b : a.getOficinas().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecciona la Oficina", opc_posibles, ".");
		
	}

	public static void menuEligeTipoCarnet(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, TipoCarnet> b : a.getTipoCarnet().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Tipo de Carnet", opc_posibles, ".");
		
	}
	
	public static void menuEligeNivelEmision(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Categoria> b : a.getCategorias().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecciona la categoria", opc_posibles, ".");
		
	}
	
	public static void menuEligeTipo(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("4x4");
		list_opc.add("Deportivo");
		list_opc.add("Familiar");
		list_opc.add("Mini");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Tipo de Coche", opc_posibles, ".");
	}
	
}
