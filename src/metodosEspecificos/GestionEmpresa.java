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
}
