package metodos;

import java.util.*;

import comparadores.*;
import objetos.*;
import principal.Principal;

public class InterfazUsuario {

	/**
	 * Imprime los alquileres ordenados por oficina
	 */
	public static void imprimeAlquilerOrdenadoOfi() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		//lo ordeno con un comparator
		Collections.sort(list_opc, new AlquilerOrdenaOfi());
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Alquileres", opc_posibles, ".");
	}
	
	//imprime los alquileres ordenados por marcass
	public static void imprimeAlquilerOrdenadoMarcas() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		//lo ordeno con un comparator
		Collections.sort(list_opc, new AlquilerOrdenaMarca());
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Alquileres", opc_posibles, ".");
	}
	
	/**
	 * imprime los alquileres ordenados por modelos
	 */
	public static void imprimeAlquilerOrdenadoModelos() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		//lo ordeno con un comparator
		Collections.sort(list_opc, new AlquilerOrdenaModelo());
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Alquileres", opc_posibles, ".");
	}

	/**
	 * Imprime menu principal del programa
	 */
	public static void imprimeMenuPrincipal() {
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
		list_opc.add("Listados Empresa.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");	
	}
	
	/**
	 * Imprime menu de los listados posibles
	 */
	public static void imprimeMenuListados() {
		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Imprime Alquiler entre fechas.");
		list_opc.add("Imprime alquileres de un determinado Vehiculo.");
		list_opc.add("Menu Listados de Stock.");
		list_opc.add("Imprime listado Alquileres.");
		list_opc.add("Imprime listado Devoluciones.");
		list_opc.add("Imprime listado Vehiculos.");
		list_opc.add("Imprime Clientes.");
		list_opc.add("Imprime Empleados.");
		list_opc.add("Imprime Oficinas.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");	
	}
	
	/**
	 * Imprime menu con los listados con stock, segun el tipo de ordenacion
	 */
	public static void imprimeMenuListadoStock() {
		
		//1.Modificaión y Gestión empresa.
		//2.Alquiler vehiculo.
		//3.Devolver un Vehiculo.
		//4.Salir
		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Ordenado por oficinas.");
		list_opc.add("Ordenado por marcas.");
		list_opc.add("Ordenado por modelos.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");	
	}

	/**
	 * Imprime el menu con las opciones de gestion de la empresa
	 */
	public static void imprimeMenuGestionEmpresa() {
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
	}
	
	/**
	 * Imprime menu con las opciones de gestion de categorias
	 */
	public static void imprimeMenuGestionCategorias() {
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
	}
	
	/**
	 * Imprime menu con las opciones de gestion de oficinas
	 */
	public static void imprimeMenuGestionOficinas() {
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
	}

	/**
	 * Imprime menu con las opciones de gestion de empleados
	 */
	public static void imprimeMenuGestionEmpleados() {
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
	}
	
	/**
	 * Imprime menu con las opciones de gestion de clientes
	 */
	public static void imprimeMenuGestionClientes() {
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
	}
	
	/**
	 * Imprime menu con las opciones de gestion de vehiculos
	 */	
	public static void imprimeMenuGestionVehiculos() {
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");
	}
	
	/**
	 * Imprime menu con los tipos de vehiculos que hay
	 */
	public static void imprimeMenuVehiculo() {
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Tipo", opc_posibles, ".");
	}
	
	/**
	 * Imprime las categorias que hay
	 */
	public static void imprimeMenuCategoria() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Categoria> b : Principal.empresa.getCategorias().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecciona la categoria", opc_posibles, ".");
	}

	/**
	 * Imprime las oficinas que hay
	 */
	public static void imprimeMenuOficina() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Oficina> b : Principal.empresa.getOficinas().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Oficinas", opc_posibles, ".");
	}

	/**
	 * Imprime los tipos de carnet que hay
	 */
	public static void imprimeMenuTipoCarnet() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, TipoCarnet> b : Principal.empresa.getTipoCarnet().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Tipo de Carnet", opc_posibles, ".");
	}
	
	/**
	 * Imprime los niveles de emision que hay
	 */
	public static void imprimeMenuNivelEmision() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		list_opc.add("   A++");
		list_opc.add("   A+");
		list_opc.add("   A");
		list_opc.add("   B");
		list_opc.add("   C");
		list_opc.add("   D");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Emision", opc_posibles, ".");
	}

	/**
	 * Imprime los tipos de vehiculo que hay (4x4, familiar...)
	 */
	public static void imprimeMenuTipo() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getTipo();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Tipo de Coche", opc_posibles, ".");
	}
	
	/**
	 * Imprime las motos que hay
	 */
	public static void impimeMenuMotos() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof Moto) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige el vehiculo", opc_posibles, ".");
	}
	
	/**
	 * Imprime las motos de una oficina
	 * @param ofi la oficina que queremos filtrar
	 * @return contador con cuantas motos hay
	 */
	public static int impimeMenuMotoDeOficina( Oficina ofi) {
		int contador = 0;
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			
			boolean mismaOfi = false;
			String key = b.getKey();
			if (Principal.empresa.getVehiculos().get(key).getOficina().equals(ofi)) mismaOfi=true;
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof Moto && mismaOfi) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
				contador++;
			}
		}
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		if (contador>0) {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elija el vehículo", opc_posibles, ".");	
		}
		
		return contador;
	}
			
	/**
	 * Imprime las Furgonetas de una oficina
	 * @param ofi la oficina que queremos filtrar
	 * @return contador con cuantas furgonetas hay
	 */
	public static int impimeMenuFurgonetaDeOficina( Oficina ofi) {
		int contador = 0;
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			
			boolean mismaOfi = false;
			String key = b.getKey();
			if (Principal.empresa.getVehiculos().get(key).getOficina().equals(ofi)) mismaOfi=true;
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof Furgoneta && mismaOfi) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
				contador++;
			}
		}
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		if (contador>0) {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elija el vehículo", opc_posibles, ".");	
		}
		
		return contador;
	}

	/**
	 * Imprime las Empleado de una oficina
	 * @param ofi la oficina que queremos filtrar
	 * @return contador con cuantas empleados hay
	 */
	public static int impimeMenuEmpleadoDeOficina( Oficina ofi) {
		int contador = 0;
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		
		for (Map.Entry<String, Empleado> b : Principal.empresa.getEmpleados().entrySet()) {
			
			boolean mismaOfi = false;
			String key = b.getKey();
			if (Principal.empresa.getEmpleados().get(key).getOficina().compareTo(ofi)==0) {
				mismaOfi=true;
			}
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof Empleado && mismaOfi) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
				contador++;
			}
		}
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		if (contador>0) {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elija el empleado.", opc_posibles, ".");	
		}
		
		return contador;
	}

	/**
	 * Imprime las Coches de Combustion de una oficina
	 * @param ofi la oficina que queremos filtrar
	 * @return contador con cuantos Coches de combustion hay
	 */
	public static int imprimeMenuCocheCombustionDeOficina( Oficina ofi) {
		int contador = 0;
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			
			boolean mismaOfi = false;
			String key = b.getKey();
			if (Principal.empresa.getVehiculos().get(key).getOficina().equals(ofi)) mismaOfi=true;
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof CocheCombustion && mismaOfi) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
				contador++;
			}
		}
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		if (contador>0) {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elija el vehículo", opc_posibles, ".");	
		}
		
		return contador;
	}
	
	/**
	 * Imprime las Coche Electrico de una oficina
	 * @param ofi la oficina que queremos filtrar
	 * @return contador con cuantas coche electrico hay
	 */
	public static int imprimeMenuCocheElectricoDeOficina( Oficina ofi) {
		int contador = 0;
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			
			boolean mismaOfi = false;
			String key = b.getKey();
			if (Principal.empresa.getVehiculos().get(key).getOficina().equals(ofi)) mismaOfi=true;
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof CocheElectrico && mismaOfi) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
				contador++;
			}
		}
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		if (contador>0) {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elija el vehículo", opc_posibles, ".");	
		}
		
		return contador;
	}
	
	/**
	 * Imprime las Furgoneta de una oficina
	 * @param ofi la oficina que queremos filtrar
	 * @return contador con cuantas Furgoneta hay
	 */
	public static void impimeMenuFurgoneta() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof Furgoneta) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige el vehiculo", opc_posibles, ".");
	}

	/**
	 * Imprime los coches electricos que hay
	 */
	public static void imprimeMenuCocheElectrico() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof CocheElectrico) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige el vehiculo", opc_posibles, ".");
	}
	
	/**
	 * Imprime los coches combustion que hay
	 */
	public static void imprimeMenuCocheCombustión() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof CocheCombustion) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige el vehiculo", opc_posibles, ".");
	}
	
	/**
	 * Imprime las categorias que hay
	 */
	public static void imprimeMenuCategorias() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Categoria> b : Principal.empresa.getCategorias().entrySet()) {
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof Categoria) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la categoria", opc_posibles, ".");
	}
	
	/**
	 * Imprime las oficinas que hay
	 */
	public static void impimeMenuOficina() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Oficina> b : Principal.empresa.getOficinas().entrySet()) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la oficina", opc_posibles, ".");
	}
	
	/**
	 * Imprime los clientes que hay
	 */
	public static void imprimeMenuCliente() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Cliente> b : Principal.empresa.getClientes().entrySet()) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Clientes", opc_posibles, ".");
	}
	
	/**
	 * Imprime los alquileres que hay
	 */
	public static void imprimeMenuAlquiler() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige el alquiler", opc_posibles, ".");
	}
	
	/**
	 * Imprime los alquileres que hay entre dos fechas
	 * @param fechaIni Fecha de inicio
	 * @param fechaFin Fecha de fin
	 */
	public static void imprimeAlquilerEntreFechas(GregorianCalendar fechaIni, GregorianCalendar fechaFin) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
			if (b.getValue().getFechaIniAlquiler().compareTo(fechaIni)>0 && b.getValue().getFechaFinPrevista().compareTo(fechaFin)<0) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));	
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Alquileres", opc_posibles, ".");
	}
	
	/**
	 * Imprime los alquileres que hay
	 */
	public static void imprimeAlquileres() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));	
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Alquileres", opc_posibles, ".");
	}
	
	/**
	 * Imprime las devoluciones que hay
	 */
	public static void imprimeDevoluciones() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Devolucion> b : Principal.empresa.getDevoluciones().entrySet()) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));	
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Devoluciones", opc_posibles, ".");
	}
	
	/**
	 * Imprime los vehiculos que hay
	 */
	public static void imprimeVehiculos() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));	
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Vehiculos", opc_posibles, ".");
	}
	
	/**
	 * Imprime los alquieres de un determinado vehiculo
	 * @param a Vehiculo el cual queremos ver sus alquileres
	 */
	public static void imprimeListadoAlquilerVehiculo(Vehiculo a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
			if (b.getValue().getVehiculo().equals(a)) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));	
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		try {
			miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Alquileres", opc_posibles, ".");
		} catch (Exception e) {
			System.out.println("Este vehiculo no tiene alquileres.");
		}
	}

	/**
	 * Imprime las devoluciones que hay
	 */
	public static void impimeMenuDevolucion() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Devolucion> b : Principal.empresa.getDevoluciones().entrySet()) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la devolucion", opc_posibles, ".");
	}
	
	/**
	 * Imprime los empleados que hay
	 */
	public static void impimeMenuEmpleado() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Empleado> b : Principal.empresa.getEmpleados().entrySet()) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Empleados", opc_posibles, ".");
	}

	/**
	 * Imprime los atributos de motos que hay
	 */
	public static void imprimeAtributosMotos() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosMoto();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	/**
	 * Imprime los atributos de furgonetas que hay
	 */
	public static void imprimeAtributosFurgoneta() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosFurgoneta();
			
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	/**
	 * Imprime los atributos de coche de coombustion que hay
	 */
	public static void imprimeAtributosCocheCombustion() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCocheCombustion();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	/**
	 * Imprime los atributos de coches electricos que hay
	 */
	public static void imprimeAtributosCocheElectrico() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCocheElectrico();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	/**
	 * Imprime los atributos de categoria que hay
	 */
	public static void imprimeAtributosCategoria() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCategoria();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	/**
	 * Imprime los atributos de oficina que hay
	 */
	public static void imprimeAtributosOficina() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosOficina();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	/**
	 * Imprime los atributos de cliente que hay
	 */
	public static void imprimeAtributosCliente() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCliente();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	/**
	 * Imprime los atributos de empleado que hay
	 */
	public static void imprimeAtributosEmpleado() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosEmpleado();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	
}
