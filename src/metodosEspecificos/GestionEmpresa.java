package metodosEspecificos;

import objetos.*;
import java.util.*;

public class GestionEmpresa {
	public static void pideyCreaMoto(Empresa a, Scanner in){
		String matricula ="";
		String marca ="";
		String modelo="";
		String color ="";
		GregorianCalendar fecha_alta;
		int dia;
		int mes;
		int a�o;
		int kms;
		Categoria categoria;
		Oficina oficina;
		int autonomia;
		int tiempoRecarga;
		int cilindrada;
		TipoCarnet tipoCarnet;

		//pido todos los datos
		System.out.println("Introduce la matricula del Veh�culo.");
		matricula = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Veh�culo.");
		marca = in.nextLine();
		System.out.println();
		
		System.out.println("Introduce el modelo del Veh�culo.");
		modelo = in.nextLine();
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el a�o de alta del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(in);
		fecha_alta = new GregorianCalendar(dia, mes, a�o);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Veh�culo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		categoria = InterfazUsuario.menuSeleccionaCategoria(a);
		
		oficina = InterfazUsuario.menuSeleccionaOficina(a);
		
		System.out.println("Introduce la autonomia del Veh�culo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Veh�culo.");
		tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce la Cilindrada del Veh�culo.");
		cilindrada = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		tipoCarnet=InterfazUsuario.menuSeleccionaTipoCarnet(a);
		
		a.getVehiculos().put(matricula, new Moto(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, cilindrada, tipoCarnet));
	}
	
	public static void pideyCreaFurgoneta(Empresa a, Scanner in){
		String matricula ="";
		String marca ="";
		String modelo="";
		String color ="";
		GregorianCalendar fecha_alta;
		int dia;
		int mes;
		int a�o;
		int kms;
		Categoria categoria;
		Oficina oficina;
		int consumo;
		int potencia;
		String nivelEmision;
		int capacidadCarga;
		TipoCarnet tipoCarnet;

		//pido todos los datos
		System.out.println("Introduce la matricula del Veh�culo.");
		matricula = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Veh�culo.");
		marca = in.nextLine();
		System.out.println();
		
		System.out.println("Introduce el modelo del Veh�culo.");
		modelo = in.nextLine();
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el a�o de alta del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(in);
		fecha_alta = new GregorianCalendar(dia, mes, a�o);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Veh�culo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		categoria = InterfazUsuario.menuSeleccionaCategoria(a);
		
		oficina = InterfazUsuario.menuSeleccionaOficina(a);
		
		System.out.println("Introduce la autonomia del Veh�culo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Veh�culo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		nivelEmision=InterfazUsuario.menuSeleccionaNivelEmision();

		System.out.println("Introduce la capacidad de carga del Veh�culo.");
		capacidadCarga = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		tipoCarnet=InterfazUsuario.menuSeleccionaTipoCarnet(a);
		
		a.getVehiculos().put(matricula, new Furgoneta(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, consumo, potencia, nivelEmision, capacidadCarga, tipoCarnet));
	}
	
	public static void pideyCreaCocheCombustion(Empresa a, Scanner in){
		String matricula ="";
		String marca ="";
		String modelo="";
		String color ="";
		GregorianCalendar fecha_alta;
		int dia;
		int mes;
		int a�o;
		int kms;
		Categoria categoria;
		Oficina oficina;
		int consumo;
		int potencia;
		String nivelEmision;
		int nPlazas;
		String tipo;

		//pido todos los datos
		System.out.println("Introduce la matricula del Veh�culo.");
		matricula = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Veh�culo.");
		marca = in.nextLine();
		System.out.println();
		
		System.out.println("Introduce el modelo del Veh�culo.");
		modelo = in.nextLine();
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el a�o de alta del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(in);
		fecha_alta = new GregorianCalendar(dia, mes, a�o);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Veh�culo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		categoria = InterfazUsuario.menuSeleccionaCategoria(a);
		
		oficina = InterfazUsuario.menuSeleccionaOficina(a);
		
		System.out.println("Introduce el consumo del Veh�culo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce la potencia del Veh�culo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		nivelEmision=InterfazUsuario.menuSeleccionaNivelEmision();

		System.out.println("Introduce el n�mero de Plazas del Veh�culo.");
		nPlazas = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		tipo=InterfazUsuario.menuSeleccionaTipo();
		
		a.getVehiculos().put(matricula, new CocheCombustion(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, consumo, potencia, nivelEmision, nPlazas, tipo));
	}

	public static void pideyCreaCocheElectrico(Empresa a, Scanner in){
		String matricula ="";
		String marca ="";
		String modelo="";
		String color ="";
		GregorianCalendar fecha_alta;
		int dia;
		int mes;
		int a�o;
		int kms;
		Categoria categoria;
		Oficina oficina;
		int autonomia;
		int tiempoRecarga;
		int nPlazas;
		String tipo;

		//pido todos los datos
		System.out.println("Introduce la matricula del Veh�culo.");
		matricula = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Veh�culo.");
		marca = in.nextLine();
		System.out.println();
		
		System.out.println("Introduce el modelo del Veh�culo.");
		modelo = in.nextLine();
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el a�o de alta del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(in);
		fecha_alta = new GregorianCalendar(dia, mes, a�o);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Veh�culo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		categoria = InterfazUsuario.menuSeleccionaCategoria(a);
		
		oficina = InterfazUsuario.menuSeleccionaOficina(a);
		
		System.out.println("Introduce la autonomia del Veh�culo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Veh�culo.");
		tiempoRecarga= miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el n�mero de Plazas del Veh�culo.");
		nPlazas = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		tipo=InterfazUsuario.menuSeleccionaTipo();
		
		a.getVehiculos().put(matricula, new CocheElectrico(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, nPlazas, tipo));
	}
	
	public static void pideyEliminaMoto(Empresa a, Scanner in){
		
		String opcion="";
		int posi;
		
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige", opc_posibles, ".");
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		a.getVehiculos().remove(key);
		
	}

	public static void pideyEliminaCocheElectrico(Empresa a, Scanner in){
		
		String opcion="";
		int posi;
		
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige", opc_posibles, ".");
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		a.getVehiculos().remove(key);
		
	}
	
	public static void pideyEliminaCocheCombustion(Empresa a, Scanner in){
		
		String opcion="";
		int posi;
		
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige", opc_posibles, ".");
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		a.getVehiculos().remove(key);
		
	}

	public static void pideyEliminaFurgoneta(Empresa a, Scanner in){
		
		String opcion="";
		int posi;
		
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
				
		miLibreria.interfazDeUsuario.Menu.imprimeMenu(list_opc, "Elige", opc_posibles, ".");
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		a.getVehiculos().remove(key);
		
	}
	
}
