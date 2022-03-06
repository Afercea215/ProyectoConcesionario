package metodos;

import objetos.*;
import java.util.*;

public class Especificos {

	public static void menuPrincipal (Empresa a, Scanner in) {
		
		String opcion ="";
	
		do {
			InterfazUsuario.imprimeMenuPrincipal(a);
			opcion=eligeMenuPrincipal(a, in);

			switch (opcion)
			{
			case "1":
				menuGestionEmpresa(a, in);
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
	
	public static void menuGestionEmpresa(Empresa a, Scanner in) {

		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionEmpresa(a);
			opcion=eligeMenuGestionEmpresa(a, in);
			switch (opcion)
			{
			case "1":
				menuGestionVehiculos(a, in);
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
	
	public static void menuGestionVehiculos(Empresa a, Scanner in) {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionVehiculos(a);
			opcion=eligeMenuGestionVehiculo(a, in);
			
			switch (opcion)
			{
			case "1":
				menuAñadirVehiculo(a, in);
				break;
			case "2":
				menuEliminarVehiculo(a,in);
				break;
			case "3":
				menuModificarVehiculo(a,in);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}
	
	public static void menuAñadirVehiculo(Empresa a, Scanner in) {
		String opcion="";
		
		do {
			InterfazUsuario.imprimeMenuVehiculo(a);
			opcion=eligeMenuVehiculo(a, in);
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaMoto(a, in);
				System.out.println("¡Vehiculo Creado!");
				break;
			case "2":
				GestionEmpresa.creaFurgoneta(a, in);
				System.out.println("¡Vehiculo Creado!");
				break;
			case "3":
				GestionEmpresa.creaCocheCombustion(a, in);
				System.out.println("¡Vehiculo Creado!");
				break;
			case "4":
				GestionEmpresa.creaCocheElectrico(a, in);
				System.out.println("¡Vehiculo Creado!");
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			break;
			
		}while (opcion.indexOf("5")==-1);
	}
	
	public static void menuEliminarVehiculo(Empresa a, Scanner in) {
		String opcion="";
		
		do {
			InterfazUsuario.imprimeMenuVehiculo(a);
			opcion=eligeMenuVehiculo(a, in);
			
			switch (opcion)
			{
			case "1":
				Moto moto = pideMoto(a, in);
				GestionEmpresa.eliminaVehiculo(a, moto.getMatricula());
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "2":
				Furgoneta furgoneta = pideFurgoneta(a, in);
				GestionEmpresa.eliminaVehiculo(a, furgoneta.getMatricula());
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "3":
				CocheCombustion cocheCombustion = pideCocheCombustion(a, in);
				GestionEmpresa.eliminaVehiculo(a, cocheCombustion.getMatricula());
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "4":
				CocheElectrico cocheElectrico = pideCocheElectrico(a, in);
				GestionEmpresa.eliminaVehiculo(a, cocheElectrico.getMatricula());
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			break;
			
		}while (opcion.indexOf("5")==-1);
	}
	
	public static void menuModificarVehiculo(Empresa a, Scanner in) {
		String opcion="";
		
		do {
			InterfazUsuario.imprimeMenuVehiculo(a);
			opcion=eligeMenuVehiculo(a, in);
			
			switch (opcion)
			{
			case "1":
				Moto moto = pideMoto(a, in);
				GestionEmpresa.modificaMoto(a, in, moto);
				System.out.println("¡Vehiculo Modificado!");
				break;
			case "2":
				Furgoneta furgoneta= pideFurgoneta(a, in);
				GestionEmpresa.modificaFurgoneta(a, in, furgoneta);
				System.out.println("¡Vehiculo Modificado!");
				break;
			case "3":
				CocheCombustion cocheCombustion = pideCocheCombustion(a, in);
				GestionEmpresa.modificaCocheCombustion(a, in, cocheCombustion);
				System.out.println("¡Vehiculo Modificado!");
				break;
			case "4":
				CocheElectrico cocheElectrico = pideCocheElectrico(a, in);
				GestionEmpresa.modificaCocheElectrico(a, in, cocheElectrico);
				System.out.println("¡Vehiculo Modificado!");
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			break;
			
		}while (opcion.indexOf("5")==-1);
	}
	
	public static String eligeMenuPrincipal (Empresa a, Scanner in) {

		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Modificación de la empresa.");
		list_opc.add("Alquilar Vehiculo.");
		list_opc.add("Devolver un Vehículo.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
	}
	
	public static String eligeMenuGestionVehiculo (Empresa a, Scanner in) {
		String opcion="";

		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Añadir Vehiculo.");
		list_opc.add("Eliminar Vehiculo.");
		list_opc.add("Modificar Vehiculo.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
	}
	
	public static String eligeMenuGestionEmpresa (Empresa a, Scanner in) {
		String opcion="";
		
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
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
	}

	public static String eligeMenuVehiculo (Empresa a, Scanner in) {

		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Moto.");
		list_opc.add("Furgoneta.");
		list_opc.add("Coche de combustión.");
		list_opc.add("Coche de electrico.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
	}

	public static Moto pideMoto(Empresa a, Scanner in){		
		String opcion="";
		
		InterfazUsuario.impimeMenuMotos(a);
		Moto moto =	GestionEmpresa.seleccionaMotoMenu(a, in);	
		return moto;
	}

	public static Furgoneta pideFurgoneta(Empresa a, Scanner in){		
		String opcion="";
		
		InterfazUsuario.impimeMenuFurgoneta(a);
		Furgoneta furgoneta=GestionEmpresa.seleccionaFurgonetaMenu(a, in);
		return furgoneta;
	}
	
	public static CocheCombustion pideCocheCombustion(Empresa a, Scanner in){		
		String opcion="";
		
		InterfazUsuario.impimeMenuCocheCombustión(a);
		CocheCombustion coche =	GestionEmpresa.seleccionaCocheCombustionMenu(a, in);	
		return coche;
	}
	
	public static CocheElectrico pideCocheElectrico(Empresa a, Scanner in){		
		String opcion="";
		
		InterfazUsuario.impimeMenuCocheCombustión(a);
		CocheElectrico coche =	GestionEmpresa.seleccionaCocheElectricoMenu(a, in);	
		return coche;	}
}
