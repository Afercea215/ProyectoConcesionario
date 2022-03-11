package metodos;

import objetos.*;
import principal.Principal;

import java.util.*;

public class Especificos {

	public static void menuPrincipal () {
		
		String opcion ="";
	
		do {
			InterfazUsuario.imprimeMenuPrincipal();
			opcion=eligeMenuPrincipal();

			switch (opcion)
			{
			case "1":
				menuGestionEmpresa();
				break;
			case "2":
				GestionEmpresa.creaAlquiler();
				break;
			case "3":
				GestionEmpresa.creaDevolucion();
				break;
			case "4":
				System.out.println("¡Adiós!");
				Principal.empresa.grabaDatosEmpresa();
				break;
			}
			
			
		}while (opcion.indexOf("4")==-1);


	}
	
	public static void menuGestionEmpresa() {

		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionEmpresa();
			opcion=eligeMenuGestionEmpresa();
			switch (opcion)
			{
			case "1":
				menuGestionVehiculos();
				break;
			case "2":
				menuGestionCategorias();
				break;
			case "3":
				menuGestionOficinas();
				break;
			case "4":
				menuGestionClientes();
				break;
			case "5":
				menuGestionEmpleados();
				break;
			case "6":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("6")==-1);

	}
	
	public static void menuGestionEmpleados() {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionEmpleados();
			opcion=eligeMenuGestionEmpleados();
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaEmpleado();
				System.out.println("Empleado creado.");
				break;
			case "2":
				Empleado empleado = pideEmpleado();
				GestionEmpresa.eliminaEmpleado(empleado.getDni());
				break;
			case "3":
				Empleado empleado2 = pideEmpleado();
				GestionEmpresa.modificaEmpleado(empleado2);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}
	
	public static void menuGestionClientes() {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionClientes();
			opcion=eligeMenuGestionCliente();
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaCliente();
				System.out.println("Cliente creado.");
				break;
			case "2":
				Cliente cliente = pideCliente();
				GestionEmpresa.eliminaCliente(cliente.getDni());
				break;
			case "3":
				Cliente cliente2 = pideCliente();
				GestionEmpresa.modificaCliente(cliente2);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}
 	
	public static void menuGestionCategorias() {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionCategorias();
			opcion=eligeMenuGestionCategorias();
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaCategoria();
				System.out.println("Vehiculo creado.");
				break;
			case "2":
				Categoria categoria = pideCategoria();
				GestionEmpresa.eliminaCategoria(categoria.getCodigo());
				break;
			case "3":
				Categoria categoria2 = pideCategoria();
				GestionEmpresa.modificaCategoria(categoria2);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}
	
	public static void menuGestionOficinas() {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionOficinas();
			opcion=eligeMenuGestionOficinas();
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaOficina();
				System.out.println("Oficina creada.");
				break;
			case "2":
				Oficina oficina = pideOficina();
				GestionEmpresa.eliminaOficina(oficina.getCod());
				break;
			case "3":
				Oficina oficina2 = pideOficina();
				GestionEmpresa.modificaOficina(oficina2);
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}

	
	public static void menuGestionVehiculos() {
		
		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuGestionVehiculos();
			opcion=eligeMenuGestionVehiculo();
			
			switch (opcion)
			{
			case "1":
				menuAñadirVehiculo();
				break;
			case "2":
				menuEliminarVehiculo();
				break;
			case "3":
				menuModificarVehiculo();
				break;
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("4")==-1);
	}
	
	
	public static void menuAñadirVehiculo() {
		String opcion="";
		
		do {
			InterfazUsuario.imprimeMenuVehiculo();
			opcion=eligeMenuVehiculo();
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaMoto();
				System.out.println("¡Vehiculo Creado!");
				break;
			case "2":
				GestionEmpresa.creaFurgoneta();
				System.out.println("¡Vehiculo Creado!");
				break;
			case "3":
				GestionEmpresa.creaCocheCombustion();
				System.out.println("¡Vehiculo Creado!");
				break;
			case "4":
				GestionEmpresa.creaCocheElectrico();
				System.out.println("¡Vehiculo Creado!");
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			break;
			
		}while (opcion.indexOf("5")==-1);
	}
	
	public static void menuEliminarVehiculo() {
		String opcion="";
		
		do {
			InterfazUsuario.imprimeMenuVehiculo();
			opcion=eligeMenuVehiculo();
			
			switch (opcion)
			{
			case "1":
				Moto moto = pideMoto();
				GestionEmpresa.eliminaVehiculo(moto.getMatricula());
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "2":
				Furgoneta furgoneta = pideFurgoneta();
				GestionEmpresa.eliminaVehiculo(furgoneta.getMatricula());
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "3":
				CocheCombustion cocheCombustion = pideCocheCombustion();
				GestionEmpresa.eliminaVehiculo(cocheCombustion.getMatricula());
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "4":
				CocheElectrico cocheElectrico = pideCocheElectrico();
				GestionEmpresa.eliminaVehiculo(cocheElectrico.getMatricula());
				System.out.println("¡Vehiculo Eliminado!");
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			break;
			
		}while (opcion.indexOf("5")==-1);
	}
	
	public static void menuModificarVehiculo() {
		String opcion="";
		
		do {
			InterfazUsuario.imprimeMenuVehiculo();
			opcion=eligeMenuVehiculo();
			
			switch (opcion)
			{
			case "1":
				Moto moto = pideMoto();
				GestionEmpresa.modificaMoto( moto);
				break;
			case "2":
				Furgoneta furgoneta= pideFurgoneta();
				GestionEmpresa.modificaFurgoneta( furgoneta);
				break;
			case "3":
				CocheCombustion cocheCombustion = pideCocheCombustion();
				GestionEmpresa.modificaCocheCombustion( cocheCombustion);
				break;
			case "4":
				CocheElectrico cocheElectrico = pideCocheElectrico();
				GestionEmpresa.modificaCocheElectrico( cocheElectrico);
				break;
			case "5":
				System.out.println("¡Adiós!");
				break;
			}
			break;
			
		}while (opcion.indexOf("5")==-1);
	}

	public static String eligeMenuPrincipal () {

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
		
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	public static String eligeMenuGestionVehiculo () {
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
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	public static String eligeMenuGestionCategorias () {
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
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	public static String eligeMenuGestionOficinas () {
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
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	public static String eligeMenuGestionEmpleados () {
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
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	public static String eligeMenuGestionCliente() {
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
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}

	
	public static String eligeMenuGestionEmpresa () {
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
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}

	public static String eligeMenuVehiculo () {

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
		
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}

	public static Moto pideMoto(){		
		InterfazUsuario.impimeMenuMotos();
		Moto moto =	GestionEmpresa.seleccionaMotoMenu();	
		return moto;
	}

	public static Furgoneta pideFurgoneta(){		
		InterfazUsuario.impimeMenuFurgoneta();
		Furgoneta furgoneta=GestionEmpresa.seleccionaFurgonetaMenu();
		return furgoneta;
	}
	
	public static CocheCombustion pideCocheCombustion(){		
		InterfazUsuario.impimeMenuCocheCombustión();
		CocheCombustion coche =	GestionEmpresa.seleccionaCocheCombustionMenu();	
		return coche;
	}
	
	public static CocheElectrico pideCocheElectrico(){		
		InterfazUsuario.impimeMenuCocheCombustión();
		CocheElectrico coche =	GestionEmpresa.seleccionaCocheElectricoMenu();	
		return coche;	}

	public static Categoria pideCategoria(){		
		InterfazUsuario.impimeMenuCategorias();
		Categoria categoria = GestionEmpresa.elegirCategoria();	
		return categoria;
	}

	public static Oficina pideOficina(){		
		InterfazUsuario.impimeMenuOficina();
		Oficina oficina= GestionEmpresa.elegirOficina();	
		return oficina;
	}
	
	public static Cliente pideCliente(){		
		InterfazUsuario.impimeMenuCliente();
		Cliente cliente= GestionEmpresa.elegirCliente();	
		return cliente;
	}
	
	public static Empleado pideEmpleado(){		
		InterfazUsuario.impimeMenuEmpleado();
		Empleado empleado= GestionEmpresa.elegirEmpleado();	
		return empleado;
	}

}
