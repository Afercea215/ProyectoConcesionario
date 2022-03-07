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
				menuGestionCategorias(a, in);
				break;
			case "3":
				menuGestionOficinas(a, in);
				break;
			case "4":
				menuGestionClientes(a, in);
				break;
			case "5":
				menuGestionEmpleados(a,in);
				break;
			case "6":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("6")==-1);

	}
	
	public static void menuGestionEmpleados(Empresa a, Scanner in) {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionEmpleados(a);
			opcion=eligeMenuGestionEmpleados(a, in);
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaEmpleado(a, in);
				System.out.println("Empleado creado.");
				break;
			case "2":
				Empleado empleado = pideEmpleado(a, in);
				GestionEmpresa.eliminaEmpleado(a, empleado.getDni());
				break;
			case "3":
				Empleado empleado2 = pideEmpleado(a, in);
				GestionEmpresa.modificaEmpleado(a, in, empleado2);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}
	
	public static void menuGestionClientes(Empresa a, Scanner in) {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionClientes(a);
			opcion=eligeMenuGestionCliente(a, in);
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaCliente(a, in);
				System.out.println("Cliente creado.");
				break;
			case "2":
				Cliente cliente = pideCliente(a, in);
				GestionEmpresa.eliminaCliente(a, cliente.getDni());
				break;
			case "3":
				Cliente cliente2 = pideCliente(a, in);
				GestionEmpresa.modificaCliente(a, in, cliente2);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}
	
	public static void menuGestionCategorias(Empresa a, Scanner in) {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionCategorias(a);
			opcion=eligeMenuGestionCategorias(a, in);
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaCategoria(a, in);
				System.out.println("Vehiculo creado.");
				break;
			case "2":
				Categoria categoria = pideCategoria(a, in);
				GestionEmpresa.eliminaCategoria(a, categoria.getCodigo());
				break;
			case "3":
				Categoria categoria2 = pideCategoria(a, in);
				GestionEmpresa.modificaCategoria(a, in, categoria2);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}
	
	public static void menuGestionOficinas(Empresa a, Scanner in) {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionOficinas(a);
			opcion=eligeMenuGestionOficinas(a, in);
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaOficina(a, in);
				System.out.println("Oficina creada.");
				break;
			case "2":
				Oficina oficina = pideOficina(a, in);
				GestionEmpresa.eliminaOficina(a, oficina.getCod());
				break;
			case "3":
				Oficina oficina2 = pideOficina(a, in);
				GestionEmpresa.modificaOficina(a, in, oficina2);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
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
				break;
			case "2":
				Furgoneta furgoneta= pideFurgoneta(a, in);
				GestionEmpresa.modificaFurgoneta(a, in, furgoneta);
				break;
			case "3":
				CocheCombustion cocheCombustion = pideCocheCombustion(a, in);
				GestionEmpresa.modificaCocheCombustion(a, in, cocheCombustion);
				break;
			case "4":
				CocheElectrico cocheElectrico = pideCocheElectrico(a, in);
				GestionEmpresa.modificaCocheElectrico(a, in, cocheElectrico);
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
	
	public static String eligeMenuGestionCategorias (Empresa a, Scanner in) {
		String opcion="";

		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Añadir Categoria.");
		list_opc.add("Eliminar Categoria.");
		list_opc.add("Modificar Categoria.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
	}
	
	public static String eligeMenuGestionOficinas (Empresa a, Scanner in) {
		String opcion="";

		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Añadir Oficina.");
		list_opc.add("Eliminar Oficina.");
		list_opc.add("Modificar Oficina.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
	}
	
	public static String eligeMenuGestionEmpleados (Empresa a, Scanner in) {
		String opcion="";

		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Añadir Empleado.");
		list_opc.add("Eliminar Empleado.");
		list_opc.add("Modificar Empleado.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
	}
	
	public static String eligeMenuGestionCliente(Empresa a, Scanner in) {
		String opcion="";

		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Añadir Cliente.");
		list_opc.add("Eliminar Cliente.");
		list_opc.add("Modificar Cliente.");
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
		InterfazUsuario.impimeMenuMotos(a);
		Moto moto =	GestionEmpresa.seleccionaMotoMenu(a, in);	
		return moto;
	}

	public static Furgoneta pideFurgoneta(Empresa a, Scanner in){		
		InterfazUsuario.impimeMenuFurgoneta(a);
		Furgoneta furgoneta=GestionEmpresa.seleccionaFurgonetaMenu(a, in);
		return furgoneta;
	}
	
	public static CocheCombustion pideCocheCombustion(Empresa a, Scanner in){		
		InterfazUsuario.impimeMenuCocheCombustión(a);
		CocheCombustion coche =	GestionEmpresa.seleccionaCocheCombustionMenu(a, in);	
		return coche;
	}
	
	public static CocheElectrico pideCocheElectrico(Empresa a, Scanner in){		
		InterfazUsuario.impimeMenuCocheCombustión(a);
		CocheElectrico coche =	GestionEmpresa.seleccionaCocheElectricoMenu(a, in);	
		return coche;	}

	public static Categoria pideCategoria(Empresa a, Scanner in){		
		InterfazUsuario.impimeMenuCategorias(a);
		Categoria categoria = GestionEmpresa.elegirCategoria(a, in);	
		return categoria;
	}

	public static Oficina pideOficina(Empresa a, Scanner in){		
		InterfazUsuario.impimeMenuOficina(a);
		Oficina oficina= GestionEmpresa.elegirOficina(a, in);	
		return oficina;
	}
	
	public static Cliente pideCliente(Empresa a, Scanner in){		
		InterfazUsuario.impimeMenuCliente(a);
		Cliente cliente= GestionEmpresa.elegirCliente(a, in);	
		return cliente;
	}
	
	public static Empleado pideEmpleado(Empresa a, Scanner in){		
		InterfazUsuario.impimeMenuEmpleado(a);
		Empleado empleado= GestionEmpresa.elegirEmpleado(a, in);	
		return empleado;
	}

}
