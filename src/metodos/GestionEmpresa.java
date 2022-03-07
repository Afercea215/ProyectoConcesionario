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
		int año;
		int kms;
		Categoria categoria;
		Oficina oficina;
		int autonomia;
		int tiempoRecarga;
		int cilindrada;
		TipoCarnet tipoCarnet;

		//pido todos los datos
		System.out.println("Introduce la matricula del Vehículo.");
		matricula = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Vehículo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Vehículo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el año de alta del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(in);
		fecha_alta = new GregorianCalendar(dia, mes, año);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Vehículo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuCategoria(a);
		categoria = elegirCategoria(a, in);
		
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		System.out.println("Introduce la autonomia del Vehículo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Vehículo.");
		tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce la Cilindrada del Vehículo.");
		cilindrada = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuTipoCarnet(a);
		tipoCarnet=elegirTipoCarnet(a, in);
		
		a.getVehiculos().put(matricula, new Moto(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, cilindrada, tipoCarnet));
	}
	
	public static void creaOficina(Empresa a, Scanner in){
		String cod;
		String descripcion;
		String localidad;
		String provincia;
		boolean ofiAeropuerto;

		//pido todos los datos
		System.out.println("Introduce el codigo de la Oficina.");
		cod = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la descripcion de la oficina.");
		descripcion = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce la localidad de la oficina.");
		localidad = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce la provincia de la oficina.");
		provincia = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		miLibreria.interfazDeUsuario.MenuBoolean.imprimir();
		ofiAeropuerto=miLibreria.interfazDeUsuario.MenuBoolean.pedirOpc();
		
		a.getOficinas().put(cod, new Oficina(cod, descripcion, localidad, provincia, ofiAeropuerto));
	}
	
	public static void creaEmpleado(Empresa a, Scanner in){
		String dni;
		String nombre;
		String ap1;
		String ap2;
		GregorianCalendar fechaNac;
		int dia;
		int mes;
		int año;
		GregorianCalendar fechaAlta;
		Oficina oficina;

		//pido todos los datos
		System.out.println("Introduce el DNI del Empleado.");
		dni = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce nombre del empleado.");
		nombre= miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce el 1º apellido del empleado.");
		ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce el 2º apellido del empleado.");
		ap2 = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();

		System.out.println("Fecha de nacimiento :");
		System.out.println("Introduce el dia nacimineto del Empleado.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de nacimiento del Empleado.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el año de nacimiento del Empleado.");
		año = miLibreria.metodos.PedirDatos.pideEntero(in);
		fechaNac = new GregorianCalendar(dia, mes, año);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Empleado.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Empleado.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el año de alta del Empleado.");
		año = miLibreria.metodos.PedirDatos.pideEntero(in);
		fechaAlta = new GregorianCalendar(dia, mes, año);
		System.out.println();
	
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		a.getEmpleados().put(dni, new Empleado(ap1, ap2, nombre, fechaNac, dni, oficina, fechaAlta));
	}
	
	public static void creaCliente(Empresa a, Scanner in){
		String dni;
		String nombre;
		String ap1;
		String ap2;
		GregorianCalendar fechaNac;
		int dia;
		int mes;
		int año;
		TipoCarnet tipoCarnet;
		Oficina oficina;
		String nTarjeta;

		//pido todos los datos
		System.out.println("Introduce el DNI del Cliente.");
		dni = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce nombre del Cliente.");
		nombre= miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce el 1º apellido del Cliente.");
		ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce el 2º apellido del Cliente.");
		ap2 = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();

		System.out.println("Fecha de nacimiento :");
		System.out.println("Introduce el dia nacimineto del Cliente.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de nacimiento del Cliente.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el año de nacimiento del Cliente.");
		año = miLibreria.metodos.PedirDatos.pideEntero(in);
		fechaNac = new GregorianCalendar(dia, mes, año);
		System.out.println();
		
		InterfazUsuario.imprimeMenuTipoCarnet(a);
		tipoCarnet = elegirTipoCarnet(a, in);
	
		System.out.println("Introduce el Nº de tarjeta del Cliente.");
		nTarjeta = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		a.getClientes().put(dni, new Cliente(ap1, ap2, nombre, fechaNac, dni, tipoCarnet, nTarjeta));
	}
	
	
	public static void creaCategoria(Empresa a, Scanner in){
		String codigo;
		String desc;
		int porcentajeRecargo;

		//pido todos los datos
		System.out.println("Introduzca el codigo");
		codigo = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la descripción de la categoria");
		desc = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
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
		int año;
		int kms;
		Categoria categoria;
		Oficina oficina;
		int consumo;
		int potencia;
		String nivelEmision;
		int capacidadCarga;
		TipoCarnet tipoCarnet;

		//pido todos los datos
		System.out.println("Introduce la matricula del Vehículo.");
		matricula = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Vehículo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Vehículo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el año de alta del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(in);
		fecha_alta = new GregorianCalendar(dia, mes, año);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Vehículo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuCategoria(a);
		categoria = elegirCategoria(a, in);
		
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		System.out.println("Introduce la autonomia del Vehículo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Vehículo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuNivelEmision(a);
		nivelEmision=elegirNivelEmision(a, in);

		System.out.println("Introduce la capacidad de carga del Vehículo.");
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
		int año;
		int kms;
		Categoria categoria;
		Oficina oficina;
		int consumo;
		int potencia;
		String nivelEmision;
		int nPlazas;
		String tipo;

		//pido todos los datos
		System.out.println("Introduce la matricula del Vehículo.");
		matricula = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Vehículo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Vehículo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el año de alta del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(in);
		fecha_alta = new GregorianCalendar(dia, mes, año);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Vehículo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuCategoria(a);
		categoria = elegirCategoria(a, in);
		
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		System.out.println("Introduce el consumo del Vehículo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce la potencia del Vehículo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuNivelEmision(a);
		nivelEmision=elegirNivelEmision(a, in);

		System.out.println("Introduce el número de Plazas del Vehículo.");
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
		int año;
		int kms;
		Categoria categoria;
		Oficina oficina;
		int autonomia;
		int tiempoRecarga;
		int nPlazas;
		String tipo;

		//pido todos los datos
		System.out.println("Introduce la matricula del Vehículo.");
		matricula = in.nextLine().toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Vehículo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Vehículo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el mes de alta del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(in);
		System.out.println("Introduce el año de alta del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(in);
		fecha_alta = new GregorianCalendar(dia, mes, año);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Vehículo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		InterfazUsuario.imprimeMenuCategoria(a);
		categoria = elegirCategoria(a, in);
		
		InterfazUsuario.imprimeMenuOficina(a);
		oficina = elegirOficina(a, in);
		
		System.out.println("Introduce la autonomia del Vehículo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el Tiempo de Recarga del Vehículo.");
		tiempoRecarga= miLibreria.metodos.PedirDatos.pideEntero(in);
		
		System.out.println("Introduce el número de Plazas del Vehículo.");
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
			System.out.println("La matricula no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			moto.setMarca(Marca);
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			moto.setModelo(modelo);
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			moto.setColor(color);
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
			moto.setFechaAlta(fecha);
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			int autonomia = miLibreria.metodos.PedirDatos.pideEntero(in);
			moto.setAutonomia(autonomia);
			break;
		case "10":
			System.out.println("Introduzca el nuevo tiempo de recarga :");
			int tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(in);
			moto.setTiempoRecarga(tiempoRecarga);
			break;
		case "11":
			System.out.println("Introduzca la nueva cilindrada :");
			int cilindrada = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			System.out.println("La matricula no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			furgoneta.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			furgoneta.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			furgoneta.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
			furgoneta.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			int consumo = miLibreria.metodos.PedirDatos.pideEntero(in);
			furgoneta.setConsumo(consumo);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca la nueva potencia :");
			int potencia = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			int capacidadCarga = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			System.out.println("La matricula no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
			System.out.println("Vehiculo modificado.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			coche.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			coche.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			coche.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
			coche.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			int consumo = miLibreria.metodos.PedirDatos.pideEntero(in);
			coche.setConsumo(consumo);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca la nueva potencia :");
			int potencia = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			int nPlazas = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			System.out.println("La matricula no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			coche.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			coche.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			coche.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el años de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
			coche.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los Kilometros :");
			int kms = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			int autonomia = miLibreria.metodos.PedirDatos.pideEntero(in);
			coche.setAutonomia(autonomia);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca el tiepo de recarga :");
			int tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(in);
			coche.setTiempoRecarga(tiempoRecarga);
			System.out.println("Vehiculo modificado.");
			break;
		case "11":
			System.out.println("Introduzca el numero de plazas :");
			int nPlazas = miLibreria.metodos.PedirDatos.pideEntero(in);
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
			System.out.println("El codigo no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva descripcion :");
			String desc = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			categoria.setDesc(desc);
			break;
		case "3":
			System.out.println("Introduzca el nuevo Porcentaje de Recargo :");
			int porcentajeRecargo = miLibreria.metodos.PedirDatos.pideEntero(in);
			categoria.setPorcentajeRecargo(porcentajeRecargo);
			break;
		case "4":
			System.out.println("¡Adios!");
			break;
		}
	}
	
	public static void modificaOficina(Empresa a, Scanner in, Oficina oficina){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosOficina(a);
		opcion = seleccionaPropiedadOficina(a, in);
		
		switch (opcion)
		{
		case "1":
			System.out.println("El codigo no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva descripcion :");
			String desc = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			oficina.setDescripcion(opcion);
			break;
		case "3":
			System.out.println("Introduzca la nueva localidad :");
			String loc = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			oficina.setLocalidad(loc);
			break;
		case "4":
			System.out.println("Introduzca la nueva provincia :");
			String prov = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			oficina.setProvincia(prov);
			break;
		case "5":
			miLibreria.interfazDeUsuario.MenuBoolean.imprimir();
			boolean ofiAeropuerto= miLibreria.interfazDeUsuario.MenuBoolean.pedirOpc();
			oficina.setOfiAeropuerto(ofiAeropuerto);
			break;
		case "6":
			System.out.println("¡Adios!");
			break;
		}
	}
	
	public static void modificaCliente(Empresa a, Scanner in, Cliente cliente){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosCliente(a);
		opcion = seleccionaPropiedadCliente(a, in);
		
		switch (opcion)
		{
		case "1":
			System.out.println("El DNI no se puede modificar, si es erroneo deberá borrar el cliente y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca el nuevo nombre :");
			String nombre = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			cliente.setNombre(nombre);
			break;
		case "3":
			System.out.println("Introduzca el nuevo apellido :");
			String ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			cliente.setAp1(ap1);
			break;
		case "4":
			System.out.println("Introduzca el nuevo apellido :");
			String ap2 = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			cliente.setAp2(ap2);
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
			cliente.setFechaNac(fecha);
			break;
		case "6":
			InterfazUsuario.imprimeMenuTipoCarnet(a);
			cliente.setCarnetConducir(elegirTipoCarnet(a, in));
			break;
		case "7":
			System.out.println("Introduzca el nuevo numero de tarjeta :");
			String nTarjeta = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			cliente.setnTarjetaCliente(nTarjeta);
			break;
		case "8":
			System.out.println("¡Adios!");
			break;
		}
	}
	
	public static void modificaEmpleado(Empresa a, Scanner in, Empleado empleado){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosEmpleado(a);
		opcion = seleccionaPropiedadEmpleado(a, in);
		
		switch (opcion)
		{
		case "1":
			System.out.println("El DNI no se puede modificar, si es erroneo deberá borrar el cliente y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca el nuevo nombre :");
			String nombre = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			empleado.setNombre(nombre);
			break;
		case "3":
			System.out.println("Introduzca el nuevo apellido :");
			String ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			empleado.setAp1(ap1);
			break;
		case "4":
			System.out.println("Introduzca el nuevo apellido :");
			String ap2 = miLibreria.metodos.PedirDatos.pideStringNoVacia(in);
			empleado.setAp2(ap2);
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
			empleado.setFechaNac(fecha);
			break;
		case "6":
			System.out.println("Introduzca el dia de alta :");
			int dia2 = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el mes de alta :");
			int mes2 = miLibreria.metodos.PedirDatos.pideEntero(in);
			System.out.println("Introduzca el año de alta :");
			int año2 = miLibreria.metodos.PedirDatos.pideEntero(in);
			GregorianCalendar fechaAlta = new GregorianCalendar(año2, mes2, dia2);
			empleado.setFechaAlta(fechaAlta);
			break;
		case "7":
			InterfazUsuario.imprimeMenuOficina(a);
			empleado.setOficina(elegirOficina(a, in));
			break;
		case "8":
			System.out.println("¡Adios!");
			break;
		}
	}
	
	public static void eliminaVehiculo(Empresa a, String key){		
		a.getVehiculos().remove(key);
	}
	
	public static void eliminaCategoria(Empresa a, String key){		
		a.getCategorias().remove(key);
	}
	
	public static void eliminaCliente(Empresa a, String key){		
		a.getClientes().remove(key);
	}
	
	public static void eliminaOficina(Empresa a, String key){		
		a.getOficinas().remove(key);
	}
	
	public static void eliminaEmpleado(Empresa a, String key){		
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

	public static Cliente elegirCliente(Empresa a, Scanner in) {
		String opcion="";
		Cliente cliente= null;
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Cliente> b : a.getClientes().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
	
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, 9);
		
		cliente=a.getClientes().get(key);
		
		return cliente;
				
	}

	public static Empleado elegirEmpleado(Empresa a, Scanner in) {
		String opcion="";
		Empleado empleado= null;
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Empleado> b : a.getEmpleados().entrySet()) {
			list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
	
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, 9);
		
		empleado=a.getEmpleados().get(key);
		
		return empleado;
				
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

	public static String seleccionaPropiedadOficina (Empresa a, Scanner in) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosOficina();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		return opcion;
	}

	public static String seleccionaPropiedadCliente (Empresa a, Scanner in) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosCliente();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		return opcion;
	}
	
	public static String seleccionaPropiedadEmpleado (Empresa a, Scanner in) {
		//opciones para el menu
		ArrayList<String> list_opc = a.getAtributosEmpleado();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, in);
		return opcion;
	}


}
	
