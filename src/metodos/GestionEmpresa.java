package metodos;

import objetos.*;
import java.util.*;

public class GestionEmpresa {
	public static void creaMoto(Empresa a, Scanner in){
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
		
		InterfazUsuario.imprimeMenuCategoria(a);
		categoria = elegirCategoria(a, in);
		
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		System.out.println("Introduce la autonomia del Veh�culo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Veh�culo.");
		tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce la Cilindrada del Veh�culo.");
		cilindrada = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuTipoCarnet(a);
		tipoCarnet=elegirTipoCarnet(a, in);
		
		a.getVehiculos().put(matricula, new Moto(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, cilindrada, tipoCarnet));
	}
	
	public static void creaCategoria(Empresa a, Scanner in){
		String codigo;
		String desc;
		int porcentajeRecargo;

		//pido todos los datos
		System.out.println("Introduzca el codigo");
		codigo = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la descripci�n de la categoria");
		desc = in.nextLine();
		System.out.println();
		
		System.out.println("Introduce el Porcentaje de recargo para la categoria.");
		porcentajeRecargo = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		a.getCategorias().put(codigo, new Categoria(codigo, desc, porcentajeRecargo));
	}
	
	public static void creaFurgoneta(Empresa a, Scanner in){
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
		
		InterfazUsuario.imprimeMenuCategoria(a);
		categoria = elegirCategoria(a, in);
		
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		System.out.println("Introduce la autonomia del Veh�culo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Veh�culo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuNivelEmision(a);
		nivelEmision=elegirNivelEmision(a, in);

		System.out.println("Introduce la capacidad de carga del Veh�culo.");
		capacidadCarga = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuTipoCarnet(a);
		tipoCarnet=elegirTipoCarnet(a, in);
		
		a.getVehiculos().put(matricula, new Furgoneta(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, consumo, potencia, nivelEmision, capacidadCarga, tipoCarnet));
	}
	
	public static void creaCocheCombustion(Empresa a, Scanner in){
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
		
		InterfazUsuario.imprimeMenuCategoria(a);
		categoria = elegirCategoria(a, in);
		
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		System.out.println("Introduce el consumo del Veh�culo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce la potencia del Veh�culo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuNivelEmision(a);
		nivelEmision=elegirNivelEmision(a, in);

		System.out.println("Introduce el n�mero de Plazas del Veh�culo.");
		nPlazas = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuTipo(a);
		tipo=elegirTipo(a, in);
		
		a.getVehiculos().put(matricula, new CocheCombustion(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, consumo, potencia, nivelEmision, nPlazas, tipo));
	}

	public static void creaCocheElectrico(Empresa a, Scanner in){
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
		
		InterfazUsuario.imprimeMenuCategoria(a);
		categoria = elegirCategoria(a, in);
		
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		System.out.println("Introduce la autonomia del Veh�culo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Veh�culo.");
		tiempoRecarga= miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el n�mero de Plazas del Veh�culo.");
		nPlazas = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuNivelEmision(a);
		tipo=elegirTipo(a, in);
		
		a.getVehiculos().put(matricula, new CocheElectrico(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, nPlazas, tipo));
	}
	
	public static void modificaMoto(Empresa a, Scanner in, Moto moto){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosMotos(a);
		opcion = seleccionaPropiedadMoto(a, in);
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = in.nextLine();
			moto.setMarca(Marca);
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = in.nextLine();
			moto.setModelo(modelo);
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = in.nextLine();
			moto.setColor(color);
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = in.nextInt();
			System.out.println("Introduzca el mes de alta :");
			int mes = in.nextInt();
			System.out.println("Introduzca el a�o de alta :");
			int a�o = in.nextInt();
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			moto.setFechaAlta(fecha);
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = in.nextInt();
			moto.setKms(kms);
			break;
		case "7":
			InterfazUsuario.imprimeMenuCategoria(a);
			moto.setCategoria(elegirCategoria(a, in));
			break;
		case "8":
			InterfazUsuario.imprimeMenuOficina(a);
			moto.setOficina(elegirOficina(a, in));
			break;
		case "9":
			System.out.println("Introduzca la nueva autonomia :");
			int autonomia = in.nextInt();
			moto.setAutonomia(autonomia);
			break;
		case "10":
			System.out.println("Introduzca el nuevo tiempo de recarga :");
			int tiempoRecarga = in.nextInt();
			moto.setTiempoRecarga(tiempoRecarga);
			break;
		case "11":
			System.out.println("Introduzca la nueva cilindrada :");
			int cilindrada = in.nextInt();
			moto.setCilindrada(cilindrada);
			break;
		case "12":
			InterfazUsuario.imprimeMenuTipoCarnet(a);
			moto.setCarnetRequerido(elegirTipoCarnet(a, in));
			break;
		}
	}

	public static void modificaFurgoneta(Empresa a, Scanner in, Furgoneta furgoneta){
		
		String opcion="";
		
		InterfazUsuario.impimeAtributosFurgoneta(a);
		opcion = seleccionaPropiedadFurgoneta(a, in);
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = in.nextLine();
			furgoneta.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = in.nextLine();
			furgoneta.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = in.nextLine();
			furgoneta.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = in.nextInt();
			System.out.println("Introduzca el mes de alta :");
			int mes = in.nextInt();
			System.out.println("Introduzca el a�o de alta :");
			int a�o = in.nextInt();
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			furgoneta.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = in.nextInt();
			furgoneta.setKms(kms);
			System.out.println("Vehiculo modificado.");
			break;
		case "7":
			InterfazUsuario.imprimeMenuCategoria(a);
			furgoneta.setCategoria(elegirCategoria(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		case "8":
			InterfazUsuario.imprimeMenuOficina(a);
			furgoneta.setOficina(elegirOficina(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		case "9":
			System.out.println("Introduzca el nuevo consumo :");
			int consumo = in.nextInt();
			furgoneta.setConsumo(consumo);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca la nueva potencia :");
			int potencia = in.nextInt();
			furgoneta.setPotencia(potencia);
			System.out.println("Vehiculo modificado.");
			break;
		case "11":
			InterfazUsuario.imprimeMenuNivelEmision(a);
			furgoneta.setNivel_emison(elegirNivelEmision(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		case "12":
			System.out.println("Introduzca la nueva capacida de carga :");
			int capacidadCarga = in.nextInt();
			furgoneta.setCapacidadCarga(capacidadCarga);
			System.out.println("Vehiculo modificado.");
			break;
		case "13":
			InterfazUsuario.imprimeMenuTipoCarnet(a);
			furgoneta.setCarnetRequerido(elegirTipoCarnet(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		}
	}
	
	public static void modificaCocheCombustion(Empresa a, Scanner in, CocheCombustion coche){
		
		String opcion="";
		
		InterfazUsuario.impimeAtributosCocheCombustion(a);
		opcion = seleccionaPropiedadCocheCombustion(a, in);
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			System.out.println("Vehiculo modificado.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = in.nextLine();
			coche.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = in.nextLine();
			coche.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = in.nextLine();
			coche.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = in.nextInt();
			System.out.println("Introduzca el mes de alta :");
			int mes = in.nextInt();
			System.out.println("Introduzca el a�o de alta :");
			int a�o = in.nextInt();
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			coche.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = in.nextInt();
			coche.setKms(kms);
			System.out.println("Vehiculo modificado.");
			break;
		case "7":
			InterfazUsuario.imprimeMenuCategoria(a);
			coche.setCategoria(elegirCategoria(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		case "8":
			InterfazUsuario.imprimeMenuOficina(a);
			coche.setOficina(elegirOficina(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		case "9":
			System.out.println("Introduzca el nuevo consunmo :");
			int consumo = in.nextInt();
			coche.setConsumo(consumo);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca la nueva potencia :");
			int potencia = in.nextInt();
			coche.setPotencia(potencia);
			System.out.println("Vehiculo modificado.");
			break;
		case "11":
			InterfazUsuario.imprimeMenuNivelEmision(a);
			coche.setNivel_emison(elegirNivelEmision(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		case "12":
			System.out.println("Introduzca el numero de plazas :");
			int nPlazas = in.nextInt();
			coche.setN_plazas(nPlazas);
			System.out.println("Vehiculo modificado.");
			break;
		case "13":
			InterfazUsuario.imprimeMenuTipo(a);
			coche.setTipo(elegirTipo(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		}
	}

	public static void modificaCocheElectrico(Empresa a, Scanner in, CocheElectrico coche){
		
		String opcion="";
		
		InterfazUsuario.impimeAtributosCocheElectrico(a);
		opcion = seleccionaPropiedadCocheElectrico(a, in);
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = in.nextLine();
			coche.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = in.nextLine();
			coche.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = in.nextLine();
			coche.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = in.nextInt();
			System.out.println("Introduzca el mes de alta :");
			int mes = in.nextInt();
			System.out.println("Introduzca el a�os de alta :");
			int a�o = in.nextInt();
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			coche.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los Kilometros :");
			int kms = in.nextInt();
			coche.setKms(kms);
			System.out.println("Vehiculo modificado.");
			break;
		case "7":
			InterfazUsuario.imprimeMenuCategoria(a);
			coche.setCategoria(elegirCategoria(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		case "8":
			InterfazUsuario.imprimeMenuOficina(a);
			coche.setOficina(elegirOficina(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		case "9":
			System.out.println("Introduzca la autonomia :");
			int autonomia = in.nextInt();
			coche.setAutonomia(autonomia);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca el tiepo de recarga :");
			int tiempoRecarga = in.nextInt();
			coche.setTiempoRecarga(tiempoRecarga);
			System.out.println("Vehiculo modificado.");
			break;
		case "11":
			System.out.println("Introduzca el numero de plazas :");
			int nPlazas = in.nextInt();
			coche.setN_plazas(nPlazas);
			System.out.println("Vehiculo modificado.");
			break;
		case "12":
			InterfazUsuario.imprimeMenuTipo(a);
			coche.setTipo(elegirTipo(a, in));
			System.out.println("Vehiculo modificado.");
			break;
		}
	}
	
	public static void modificaCategoria(Empresa a, Scanner in, Categoria categoria){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosCategoria(a);
		opcion = seleccionaPropiedadMoto(a, in);
		
		switch (opcion)
		{
		case "1":
			System.out.println("El codigo no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva descripcion :");
			String desc = in.nextLine();
			categoria.setDesc(desc);
			break;
		case "3":
			System.out.println("Introduzca el nuevo Porcentaje de Recargo :");
			int porcentajeRecargo = miLibreria.metodos.PedirDatos.pideEntero(in);
			categoria.setPorcentajeRecargo(porcentajeRecargo);
			break;
		case "4":
			System.out.println("�Adios!");
			break;
		}
	}
	
	public static void eliminaVehiculo(Empresa a, String key){		
		a.getVehiculos().remove(key);
	}
	
	public static void eliminaCategoria(Empresa a, String key){		
		a.getCategorias().remove(key);
	}
	
	public static void eliminaClientes(Empresa a, String key){		
		a.getClientes().remove(key);
	}
	
	public static void eliminaOficinas(Empresa a, String key){		
		a.getOficinas().remove(key);
	}
	
	public static void eliminaEmpleados(Empresa a, String key){		
		a.getEmpleados().remove(key);
	}
	

	public static Categoria elegirCategoria(Empresa a, Scanner in) {
		String opcion="";
		Categoria categoria = null;
		
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
		
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);

		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(10, 11);
		
		categoria=a.getCategorias().get(key);
		
		return categoria;
				
	}

	public static Oficina elegirOficina(Empresa a, Scanner in) {
		String opcion="";
		Oficina oficina= null;
		
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
	
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, 4);
		
		oficina=a.getOficinas().get(key);
		
		return oficina;
				
	}

	public static TipoCarnet elegirTipoCarnet(Empresa a, Scanner in) {
		String opcion="";
		TipoCarnet tipoCarnet= null;
		int posi;
			
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
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		tipoCarnet=a.getTipoCarnet().get(key);
		
		return tipoCarnet;
				
	}

	public static String elegirNivelEmision(Empresa a, Scanner in) {
		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = a.getNivelEmision();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		return opcion;
				
	}
	
	public static String elegirTipo(Empresa a, Scanner in) {
		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = a.getTipo();

		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		return opcion;		
	}

	public static Moto seleccionaMotoMenu (Empresa a, Scanner in) {
		
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
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		Moto b = (Moto) a.getVehiculos().get(key);
		
		return b;
	}
	
	public static Furgoneta seleccionaFurgonetaMenu (Empresa a, Scanner in) {
		
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
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		Furgoneta b = (Furgoneta) a.getVehiculos().get(key);
		
		return b;
	}
	
	public static CocheElectrico seleccionaCocheElectricoMenu (Empresa a, Scanner in) {
		
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
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		CocheElectrico b = (CocheElectrico) a.getVehiculos().get(key);
		
		return b;
	}
	
	public static CocheCombustion seleccionaCocheCombustionMenu (Empresa a, Scanner in) {
		
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
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		CocheCombustion b = (CocheCombustion) a.getVehiculos().get(key);
		
		return b;
	}
	
	public static String seleccionaPropiedadMoto (Empresa a, Scanner in) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosMoto();
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		return opcion;
	}
	
	public static String seleccionaPropiedadFurgoneta (Empresa a, Scanner in) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosFurgoneta();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		return opcion;
	}
	
	public static String seleccionaPropiedadCocheElectrico (Empresa a, Scanner in) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosCocheElectrico();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		return opcion;
	}
	
	public static String seleccionaPropiedadCocheCombustion (Empresa a, Scanner in) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosCocheCombustion();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		return opcion;
	}
}
