package metodos;

import java.util.*;
import objetos.*;

public class InterfazUsuario {

	public static void imprimeMenuPrincipal(Empresa a) {
		
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
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Selecione una opción", opc_posibles, ".");	
	}

	public static void imprimeMenuGestionEmpresa(Empresa a) {
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
	
	public static void imprimeMenuGestionCategorias(Empresa a) {
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
	
	public static void imprimeMenuGestionVehiculos(Empresa a) {
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
	
	public static void imprimeMenuVehiculo(Empresa a) {
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
		
	public static void imprimeMenuCategoria(Empresa a) {
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
	
	public static void imprimeMenuOficina(Empresa a) {
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

	public static void imprimeMenuTipoCarnet(Empresa a) {
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
	
	public static void imprimeMenuNivelEmision(Empresa a) {
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
	
	public static void imprimeMenuTipo(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getTipo();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Tipo de Coche", opc_posibles, ".");
	}
	
	public static void impimeMenuMotos(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : a.getVehiculos().entrySet()) {
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
	
	public static void impimeMenuFurgoneta(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : a.getVehiculos().entrySet()) {
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

	public static void impimeMenuCocheElectrico(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : a.getVehiculos().entrySet()) {
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
	
	public static void impimeMenuCocheCombustión(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : a.getVehiculos().entrySet()) {
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
	
	public static void impimeMenuCategorias(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Categoria> b : a.getCategorias().entrySet()) {
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
	
	
	public static void impimeAtributosMotos(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosMoto();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
	public static void impimeAtributosFurgoneta(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosFurgoneta();
			
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	public static void impimeAtributosCocheCombustion(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosCocheCombustion();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	public static void impimeAtributosCocheElectrico(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosCocheElectrico();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}

	public static void impimeAtributosCategoria(Empresa a) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosCategoria();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige la propiedad", opc_posibles, ".");
	}
	
}
