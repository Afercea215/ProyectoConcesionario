package metodos;

import java.util.*;

import comparadores.*;
import objetos.*;
import principal.Principal;

public class InterfazUsuario {

	public static void imprimeAlquilerOrdenadoOfi() {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		Collections.sort(list_opc, new AlquilerOrdenaOfi());
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Alquileres", opc_posibles, ".");
	}
	
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
	
	public static void imprimeMenuListados() {
		
		//1.Modificaión y Gestión empresa.
		//2.Alquiler vehiculo.
		//3.Devolver un Vehiculo.
		//4.Salir
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

	
	public static int impimeMenuCocheCombustionDeOficina( Oficina ofi) {
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
	
	public static int impimeMenuCocheElectricoDeOficina( Oficina ofi) {
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

	public static void impimeMenuCocheElectrico() {
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
	
	public static void impimeMenuCocheCombustión() {
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
	
	public static void impimeMenuCategorias() {
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
	
	public static void impimeMenuCliente() {
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
	
	public static void impimeMenuAlquiler() {
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

	
	public static void impimeAtributosMotos() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosMoto();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	public static void impimeAtributosFurgoneta() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosFurgoneta();
			
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	public static void impimeAtributosCocheCombustion() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCocheCombustion();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	public static void impimeAtributosCocheElectrico() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCocheElectrico();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	public static void impimeAtributosCategoria() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCategoria();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	public static void impimeAtributosOficina() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosOficina();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	public static void impimeAtributosCliente() {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCliente();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	public static void impimeAtributosEmpleado() {
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
