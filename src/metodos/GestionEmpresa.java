package metodos;

import principal.Principal;

import java.util.*;

import entidades.*;

public class GestionEmpresa {
	
	/**
	 * Pide datos de una moto y lo crea
	 */
	public static void creaMoto(){
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
		matricula = miLibreria.metodos.PedirDatos.pideMatricula(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Veh�culo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Veh�culo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de alta del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fecha_alta = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Veh�culo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuCategoria();
		categoria = elegirCategoria();
		
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		System.out.println("Introduce la autonomia del Veh�culo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce el Tiempo de Recarga del Veh�culo.");
		tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce la Cilindrada del Veh�culo.");
		cilindrada = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuTipoCarnet();
		tipoCarnet=elegirTipoCarnet();
		
		//Creo la nueva moto
		Principal.empresa.getVehiculos().put(matricula, new Moto(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, cilindrada, tipoCarnet));
	}
	
	/**
	 * Pide datos de una OFICINA y lo crea
	 */
	public static void creaOficina(){
		String cod;
		String descripcion;
		String localidad;
		String provincia;
		boolean ofiAeropuerto;

		//pido todos los datos
		System.out.println("Codigo de la oficina.");
		cod = Especificos.generaIdOficina();
		System.out.println(cod);
		System.out.println();

		System.out.println("Introduce la descripcion de la oficina.");
		descripcion = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce la provincia de la oficina.");
		provincia = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce la localidad de la oficina.");
		localidad = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("�Es una oficina de Aeropuerto?");
		miLibreria.interfazDeUsuario.MenuBoolean.imprimir();
		ofiAeropuerto=miLibreria.interfazDeUsuario.MenuBoolean.pedirOpc();
		
		Principal.empresa.getOficinas().put(cod, new Oficina(cod, descripcion, localidad, provincia, ofiAeropuerto));
	
	}
	
	/**
	 * Pide datos de un Alquiler y lo crea
	 */
	public static void creaAlquiler()
	{
		String id;
		Oficina oficinaAlquiler;
		String opcion;
		Vehiculo vehiculo = null;
		Empleado empleado=null;
		Cliente cliente;
		GregorianCalendar iniAlquiler;
		int dia;
		int mes;
		int a�o;
		Oficina oficinaDevolucion;
		GregorianCalendar finAlquilerPrevisto;
		
		int aux;
		//pido todos los datos
		System.out.println("Codigo del Alquiler.");
		id = Especificos.generaIdAlquiler();
		System.out.println(id);
		System.out.println();
		
		//bucle hasta que la oficina seleccionda tenga trabajdores, por si hay oficinas sin trabajdores en ese momento.
		do {
			System.out.println("Oficina donde se quiere realizar el alquiler.");
			InterfazUsuario.imprimeMenuOficina();
			oficinaAlquiler = elegirOficina();
			
			InterfazUsuario.imprimeMenuVehiculo();
			opcion=Especificos.eligeMenuVehiculo();
			
			//segun la opcion muestro y pide segun tipo de vehiculo
			switch (opcion)
			{
			case "1":
				if (InterfazUsuario.impimeMenuMotoDeOficina(oficinaAlquiler )> 0) {
					vehiculo = elegirMotoDeOficina(oficinaAlquiler);
				} else {
					System.out.println("Actualmente no tenemos es tipo de Vehiculos en esa Oficina.");
					break;
				}

				break;
			case "2":
				if (InterfazUsuario.impimeMenuFurgonetaDeOficina(oficinaAlquiler )> 0) {
					vehiculo = elegirFurgonetaDeOficina(oficinaAlquiler);
				} else {
					System.out.println("Actualmente no tenemos es tipo de Vehiculos en esa Oficina.");
					break;
				}

				break;
			case "3":
				if (InterfazUsuario.imprimeMenuCocheCombustionDeOficina(oficinaAlquiler )> 0) {
					vehiculo = elegirCocheCombustionDeOficina(oficinaAlquiler);
				} else {
					System.out.println("Actualmente no tenemos es tipo de Vehiculos en esa Oficina.");
					break;
				}

				break;
			case "4":
				if (InterfazUsuario.imprimeMenuCocheElectricoDeOficina(oficinaAlquiler )> 0) {
					vehiculo = elegirCocheElectricoDeOficina(oficinaAlquiler);
				} else {
					System.out.println("Actualmente no tenemos es tipo de Vehiculos en esa Oficina.");
					break;
				}
			}
			
			//pido y guardo el empleado, y si no hay lo imprimo
			if (InterfazUsuario.impimeMenuEmpleadoDeOficina(oficinaAlquiler )> 0) {
				empleado = elegirEmpleadoDeOficina(oficinaAlquiler);
			} else {
				System.out.println("Actualmente no tenemos trabajdores en esa Oficina.");
			}
			
			if (vehiculo==null || empleado==null) System.out.println("Vuelva a seleccionar.");
			
		}while (vehiculo==null && empleado==null);
		
		InterfazUsuario.imprimeMenuCliente();
		cliente = elegirCliente();
		
		System.out.println("Fecha de inicio Alquiler :");
		System.out.println("Introduce el dia de alquiler del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alquiler del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de alquiler del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		iniAlquiler = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
	
		//bulce hasta que la fecha de entrega sea mayor que la de comienzo
		do {
			System.out.println("Fecha de fin Alquiler prevista :");
			System.out.println("Introduce el dia de alquiler.");
			dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduce el mes de alquiler del Veh�culo.");
			mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduce el a�o de alquiler del Veh�culo.");
			a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			finAlquilerPrevisto = new GregorianCalendar(a�o, mes, dia);
			System.out.println();
			
			if (iniAlquiler.compareTo(finAlquilerPrevisto)>0) {
				System.out.println("La fecha de fin debe ser posterior a la de comienzo");
			}
			
		}while (iniAlquiler.compareTo(finAlquilerPrevisto)>0);
		
		
		System.out.println("Oficina donde se devuelver� el vehiculo : ");
		InterfazUsuario.imprimeMenuOficina();
		oficinaDevolucion = elegirOficina();
		
		//creo el alquiler
		Principal.empresa.getAlquileres().put(id, new Alquiler(Integer.valueOf(id), vehiculo, empleado, cliente, iniAlquiler, oficinaAlquiler, oficinaDevolucion, finAlquilerPrevisto));
	
		//imprimo el precio de alquiler previsto.
		System.out.println("Precio previsto : "+vehiculo.calculaAlquilerPrevisto(Principal.empresa.getAlquileres().get(id))+"�");
		//pongo el vehiculo en alquiler
		vehiculo.setAlquilado(true);
		System.out.println("Alquiler creado.");
	}
	
	/**
	 * Pide datos de un Devolucion y lo crea
	 */
	public static void creaDevolucion()
	{
		String id;
		Oficina oficina;
		Alquiler alquiler;
		int kmsRecorridos;
		Empleado empleado;
		GregorianCalendar fechaDevolucionReal;
		int dia;
		int mes;
		int a�o;
		Vehiculo vehiculo;
		Cliente cliente;
		
		//pido todos los datos
		System.out.println("Id de la Devolucion.");
		id = Especificos.generaIdDevolucion();
		System.out.println(id);

		System.out.println("Elige el alquiler que realiz�.");
		InterfazUsuario.imprimeMenuAlquiler();
		alquiler = elegirAlquiler();
		
		System.out.println("�Cuantos Kilometros a recorrido con el veh�culo?");
		kmsRecorridos=miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.impimeMenuEmpleadoDeOficina(alquiler.getOficinaDevolucion());
		empleado = elegirEmpleadoDeOficina(alquiler.getOficinaDevolucion());
			
		System.out.println("Fecha de finalizacion Alquiler :");
		System.out.println("Introduce el dia de devolucion del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de devolucion del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de devolucion del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fechaDevolucionReal = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
	
		vehiculo=alquiler.getVehiculo();
		cliente=alquiler.getCliente();
		oficina=alquiler.getOficinaDevolucion();
		
		//creo la devolucion
		Principal.empresa.getDevoluciones().put(id, new Devolucion(Integer.valueOf(id), oficina, alquiler, vehiculo, kmsRecorridos, fechaDevolucionReal, empleado, cliente));
		//actualizo los kms del vehiculo
		vehiculo.setKms(vehiculo.getKms()+kmsRecorridos);
		System.out.println("�Devolucion realizada!. Importe final : "+Principal.empresa.getVehiculos().get(vehiculo.getMatricula()).calculaAlquilerReal(alquiler, Principal.empresa.getDevoluciones().get(id))+"�");
		//pongo que el vehiculo no est� alquilado
		vehiculo.setAlquilado(false);
		System.out.println();
	}
	
	/**
	 * Pide datos de un empleado y lo crea
	 */
	public static void creaEmpleado(){
		String dni;
		String nombre;
		String ap1;
		String ap2;
		GregorianCalendar fechaNac;
		int dia;
		int mes;
		int a�o;
		GregorianCalendar fechaAlta;
		Oficina oficina;

		//pido todos los datos
		System.out.println("Introduce el DNI del Empleado.");
		dni = miLibreria.metodos.PedirDatos.pideDni(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce nombre del empleado.");
		nombre= miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el 1� apellido del empleado.");
		ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el 2� apellido del empleado.");
		ap2 = Principal.in.nextLine();
		System.out.println();

		System.out.println("Fecha de nacimiento :");
		System.out.println("Introduce el dia nacimineto del Empleado.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de nacimiento del Empleado.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de nacimiento del Empleado.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fechaNac = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Empleado.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Empleado.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de alta del Empleado.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fechaAlta = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
	
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		//creo el empleado
		Principal.empresa.getEmpleados().put(dni, new Empleado(ap1, ap2, nombre, fechaNac, dni, oficina, fechaAlta));
	}
	
	/**
	 * Pide datos de un cliente y lo crea
	 */
	public static void creaCliente(){
		String dni;
		String nombre;
		String ap1;
		String ap2;
		GregorianCalendar fechaNac;
		int dia;
		int mes;
		int a�o;
		TipoCarnet tipoCarnet;
		Oficina oficina;
		String nTarjeta;

		//pido todos los datos
		System.out.println("Introduce el DNI del Cliente.");
		dni = miLibreria.metodos.PedirDatos.pideDni(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce nombre del Cliente.");
		nombre= miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el 1� apellido del Cliente.");
		ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el 2� apellido del Cliente.");
		ap2 = Principal.in.nextLine();
		System.out.println();

		System.out.println("Fecha de nacimiento :");
		System.out.println("Introduce el dia nacimineto del Cliente.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de nacimiento del Cliente.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de nacimiento del Cliente.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fechaNac = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
		
		InterfazUsuario.imprimeMenuTipoCarnet();
		tipoCarnet = elegirTipoCarnet();
	
		System.out.println("N� de tarjeta del Cliente.");
		nTarjeta = Especificos.generaIdCliente();
		System.out.println(nTarjeta);
		System.out.println();
		
		Principal.empresa.getClientes().put(dni, new Cliente(ap1, ap2, nombre, fechaNac, dni, tipoCarnet, nTarjeta));
	}
	
	/**
	 * Pide datos de una Categoria y lo crea
	 */
	public static void creaCategoria(){
		String codigo;
		String desc;
		int porcentajeRecargo;

		//pido todos los datos
		System.out.println("Introduzca el codigo");
		codigo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la descripci�n de la categoria");
		desc = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el Porcentaje de recargo para la categoria.");
		porcentajeRecargo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		Principal.empresa.getCategorias().put(codigo, new Categoria(codigo, desc, porcentajeRecargo));
	}
	
	/**
	 * Pide datos de una furgoneta y lo crea
	 */
	public static void creaFurgoneta(){
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
		matricula = miLibreria.metodos.PedirDatos.pideMatricula(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Veh�culo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Veh�culo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de alta del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fecha_alta = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Veh�culo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuCategoria();
		categoria = elegirCategoria();
		
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		System.out.println("Introduce el consumo del Veh�culo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce la potencia del Veh�culo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuNivelEmision();
		nivelEmision=elegirNivelEmision();

		System.out.println("Introduce la capacidad de carga del Veh�culo.");
		capacidadCarga = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuTipoCarnet();
		tipoCarnet=elegirTipoCarnet();
		
		Principal.empresa.getVehiculos().put(matricula, new Furgoneta(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, consumo, potencia, nivelEmision, capacidadCarga, tipoCarnet));
	}
	
	/**
	 * Pide datos de un Coche de Combustion y lo crea
	 */
	public static void creaCocheCombustion(){
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
		matricula = miLibreria.metodos.PedirDatos.pideMatricula(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Veh�culo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Veh�culo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de alta del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fecha_alta = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Veh�culo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuCategoria();
		categoria = elegirCategoria();
		
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		System.out.println("Introduce el consumo del Veh�culo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce la potencia del Veh�culo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuNivelEmision();
		nivelEmision=elegirNivelEmision();

		System.out.println("Introduce el n�mero de Plazas del Veh�culo.");
		nPlazas = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuTipo();
		tipo=elegirTipo();
		
		Principal.empresa.getVehiculos().put(matricula, new CocheCombustion(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, consumo, potencia, nivelEmision, nPlazas, tipo));
	}

	/**
	 * Pide datos de un Coche Electrico y lo crea
	 */
	public static void creaCocheElectrico(){
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
		matricula = miLibreria.metodos.PedirDatos.pideMatricula(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Veh�culo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Veh�culo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Veh�culo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Veh�culo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el a�o de alta del Veh�culo.");
		a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fecha_alta = new GregorianCalendar(a�o, mes, dia);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Veh�culo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuCategoria();
		categoria = elegirCategoria();
		
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		System.out.println("Introduce la autonomia del Veh�culo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce el Tiempo de Recarga del Veh�culo.");
		tiempoRecarga= miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce el n�mero de Plazas del Veh�culo.");
		nPlazas = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuNivelEmision();
		tipo=elegirTipo();
		
		Principal.empresa.getVehiculos().put(matricula, new CocheElectrico(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, nPlazas, tipo));
	}
	
	/**
	 * Imprime menu para la opcion que deseamos modificar de una moto, y la modificamoss
	 */
	public static void modificaMoto( Moto moto){
		
		String opcion="";
				
		//imprimo y pido el atributo que deseeamos modificar
		InterfazUsuario.imprimeAtributosMotos();
		opcion = seleccionaPropiedadMoto();
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			moto.setMarca(Marca);
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			moto.setModelo(modelo);
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			moto.setColor(color);
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el a�o de alta :");
			int a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			moto.setFechaAlta(fecha);
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			moto.setKms(kms);
			break;
		case "7":
			InterfazUsuario.imprimeMenuCategoria();
			moto.setCategoria(elegirCategoria());
			break;
		case "8":
			InterfazUsuario.imprimeMenuOficina();
			moto.setOficina(elegirOficina());
			break;
		case "9":
			System.out.println("Introduzca la nueva autonomia :");
			int autonomia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			moto.setAutonomia(autonomia);
			break;
		case "10":
			System.out.println("Introduzca el nuevo tiempo de recarga :");
			int tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			moto.setTiempoRecarga(tiempoRecarga);
			break;
		case "11":
			System.out.println("Introduzca la nueva cilindrada :");
			int cilindrada = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			moto.setCilindrada(cilindrada);
			break;
		case "12":
			InterfazUsuario.imprimeMenuTipoCarnet();
			moto.setCarnetRequerido(elegirTipoCarnet());
			break;
		}
	}

	/**
	 * Imprime menu para la opcion que deseamos modificar de una furgoneta, y la modificamoss
	 */
	public static void modificaFurgoneta(Furgoneta furgoneta){
		
		String opcion="";
		
		InterfazUsuario.imprimeAtributosFurgoneta();
		opcion = seleccionaPropiedadFurgoneta();
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			furgoneta.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			furgoneta.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			furgoneta.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el a�o de alta :");
			int a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			furgoneta.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			furgoneta.setKms(kms);
			System.out.println("Vehiculo modificado.");
			break;
		case "7":
			InterfazUsuario.imprimeMenuCategoria();
			furgoneta.setCategoria(elegirCategoria());
			System.out.println("Vehiculo modificado.");
			break;
		case "8":
			InterfazUsuario.imprimeMenuOficina();
			furgoneta.setOficina(elegirOficina());
			System.out.println("Vehiculo modificado.");
			break;
		case "9":
			System.out.println("Introduzca el nuevo consumo :");
			int consumo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			furgoneta.setConsumo(consumo);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca la nueva potencia :");
			int potencia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			furgoneta.setPotencia(potencia);
			System.out.println("Vehiculo modificado.");
			break;
		case "11":
			InterfazUsuario.imprimeMenuNivelEmision();
			furgoneta.setNivel_emison(elegirNivelEmision());
			System.out.println("Vehiculo modificado.");
			break;
		case "12":
			System.out.println("Introduzca la nueva capacida de carga :");
			int capacidadCarga = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			furgoneta.setCapacidadCarga(capacidadCarga);
			System.out.println("Vehiculo modificado.");
			break;
		case "13":
			InterfazUsuario.imprimeMenuTipoCarnet();
			furgoneta.setCarnetRequerido(elegirTipoCarnet());
			System.out.println("Vehiculo modificado.");
			break;
		}
	}
	
	/**
	 * Imprime menu para la opcion que deseamos modificar de un coche de combustion, y la modificamoss
	 */
	public static void modificaCocheCombustion( CocheCombustion coche){
		
		String opcion="";
		
		InterfazUsuario.imprimeAtributosCocheCombustion();
		opcion = seleccionaPropiedadCocheCombustion();
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			System.out.println("Vehiculo modificado.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			coche.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			coche.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			coche.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el a�o de alta :");
			int a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			coche.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los nuevos Kilometros :");
			int kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			coche.setKms(kms);
			System.out.println("Vehiculo modificado.");
			break;
		case "7":
			InterfazUsuario.imprimeMenuCategoria();
			coche.setCategoria(elegirCategoria());
			System.out.println("Vehiculo modificado.");
			break;
		case "8":
			InterfazUsuario.imprimeMenuOficina();
			coche.setOficina(elegirOficina());
			System.out.println("Vehiculo modificado.");
			break;
		case "9":
			System.out.println("Introduzca el nuevo consunmo :");
			int consumo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			coche.setConsumo(consumo);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca la nueva potencia :");
			int potencia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			coche.setPotencia(potencia);
			System.out.println("Vehiculo modificado.");
			break;
		case "11":
			InterfazUsuario.imprimeMenuNivelEmision();
			coche.setNivel_emison(elegirNivelEmision());
			System.out.println("Vehiculo modificado.");
			break;
		case "12":
			System.out.println("Introduzca el numero de plazas :");
			int nPlazas = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			coche.setN_plazas(nPlazas);
			System.out.println("Vehiculo modificado.");
			break;
		case "13":
			InterfazUsuario.imprimeMenuTipo();
			coche.setTipo(elegirTipo());
			System.out.println("Vehiculo modificado.");
			break;
		}
	}

	/**
	 * Imprime menu para la opcion que deseamos modificar de un coche electrico, y la modificamoss
	 */
	public static void modificaCocheElectrico( CocheElectrico coche){
		
		String opcion="";
		
		InterfazUsuario.imprimeAtributosCocheElectrico();
		opcion = seleccionaPropiedadCocheElectrico();
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva marca :");
			String Marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			coche.setMarca(Marca);
			System.out.println("Vehiculo modificado.");
			break;
		case "3":
			System.out.println("Introduzca el nuevo modelo :");
			String modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			coche.setModelo(modelo);
			System.out.println("Vehiculo modificado.");
			break;
		case "4":
			System.out.println("Introduzca el nuevo color :");
			String color = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			coche.setColor(color);
			System.out.println("Vehiculo modificado.");
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el a�os de alta :");
			int a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			coche.setFechaAlta(fecha);
			System.out.println("Vehiculo modificado.");
			break;
		case "6":
			System.out.println("Introduzca los Kilometros :");
			int kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			coche.setKms(kms);
			System.out.println("Vehiculo modificado.");
			break;
		case "7":
			InterfazUsuario.imprimeMenuCategoria();
			coche.setCategoria(elegirCategoria());
			System.out.println("Vehiculo modificado.");
			break;
		case "8":
			InterfazUsuario.imprimeMenuOficina();
			coche.setOficina(elegirOficina());
			System.out.println("Vehiculo modificado.");
			break;
		case "9":
			System.out.println("Introduzca la autonomia :");
			int autonomia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			coche.setAutonomia(autonomia);
			System.out.println("Vehiculo modificado.");
			break;
		case "10":
			System.out.println("Introduzca el tiepo de recarga :");
			int tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			coche.setTiempoRecarga(tiempoRecarga);
			System.out.println("Vehiculo modificado.");
			break;
		case "11":
			System.out.println("Introduzca el numero de plazas :");
			int nPlazas = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			coche.setN_plazas(nPlazas);
			System.out.println("Vehiculo modificado.");
			break;
		case "12":
			InterfazUsuario.imprimeMenuTipo();
			coche.setTipo(elegirTipo());
			System.out.println("Vehiculo modificado.");
			break;
		}
	}
	
	/**
	 * Imprime menu para la opcion que deseamos modificar de una categoria, y la modificamoss
	 */
	public static void modificaCategoria(Categoria categoria){
		
		String opcion="";
				
		InterfazUsuario.imprimeAtributosCategoria();
		opcion = seleccionaPropiedadMoto();
		
		switch (opcion)
		{
		case "1":
			System.out.println("El codigo no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva descripcion :");
			String desc = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			categoria.setDesc(desc);
			break;
		case "3":
			System.out.println("Introduzca el nuevo Porcentaje de Recargo :");
			int porcentajeRecargo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			categoria.setPorcentajeRecargo(porcentajeRecargo);
			break;
		case "4":
			System.out.println("�Adios!");
			break;
		}
	}
	
	/**
	 * Imprime menu para la opcion que deseamos modificar de una oficina, y la modificamoss
	 */
	public static void modificaOficina(Oficina oficina){
		
		String opcion="";
				
		InterfazUsuario.imprimeAtributosOficina();
		opcion = seleccionaPropiedadOficina();
		
		switch (opcion)
		{
		case "1":
			System.out.println("El codigo no se puede modificar, si es erronea deber� borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva descripcion :");
			String desc = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			oficina.setDescripcion(desc);
			break;
		case "3":
			System.out.println("Introduzca la nueva localidad :");
			String loc = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			oficina.setLocalidad(loc);
			break;
		case "4":
			System.out.println("Introduzca la nueva provincia :");
			String prov = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			oficina.setProvincia(prov);
			break;
		case "5":
			miLibreria.interfazDeUsuario.MenuBoolean.imprimir();
			boolean ofiAeropuerto= miLibreria.interfazDeUsuario.MenuBoolean.pedirOpc();
			oficina.setOfiAeropuerto(ofiAeropuerto);
			break;
		case "6":
			System.out.println("�Adios!");
			break;
		}
	}
	
	/**
	 * Imprime menu para la opcion que deseamos modificar de un cliente, y la modificamoss
	 */
	public static void modificaCliente( Cliente cliente){
		
		String opcion="";
				
		InterfazUsuario.imprimeAtributosCliente();
		opcion = seleccionaPropiedadCliente();
		
		switch (opcion)
		{
		case "1":
			System.out.println("El DNI no se puede modificar, si es erroneo deber� borrar el cliente y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca el nuevo nombre :");
			String nombre = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			cliente.setNombre(nombre);
			break;
		case "3":
			System.out.println("Introduzca el nuevo apellido :");
			String ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			cliente.setAp1(ap1);
			break;
		case "4":
			System.out.println("Introduzca el nuevo apellido :");
			String ap2 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			cliente.setAp2(ap2);
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el a�o de alta :");
			int a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			cliente.setFechaNac(fecha);
			break;
		case "6":
			InterfazUsuario.imprimeMenuTipoCarnet();
			cliente.setCarnetConducir(elegirTipoCarnet());
			break;
		case "7":
			System.out.println("Introduzca el nuevo numero de tarjeta :");
			String nTarjeta = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			cliente.setnTarjetaCliente(nTarjeta);
			break;
		case "8":
			System.out.println("�Adios!");
			break;
		}
	}
	
	/**
	 * Imprime menu para la opcion que deseamos modificar de un empleado, y la modificamoss
	 */
	public static void modificaEmpleado( Empleado empleado){
		
		String opcion="";
				
		InterfazUsuario.imprimeAtributosEmpleado();
		opcion = seleccionaPropiedadEmpleado();
		
		switch (opcion)
		{
		case "1":
			System.out.println("El DNI no se puede modificar, si es erroneo deber� borrar el cliente y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca el nuevo nombre :");
			String nombre = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			empleado.setNombre(nombre);
			break;
		case "3":
			System.out.println("Introduzca el nuevo apellido :");
			String ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			empleado.setAp1(ap1);
			break;
		case "4":
			System.out.println("Introduzca el nuevo apellido :");
			String ap2 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			empleado.setAp2(ap2);
			break;
		case "5":
			System.out.println("Introduzca el dia de alta :");
			int dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el mes de alta :");
			int mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el a�o de alta :");
			int a�o = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(a�o, mes, dia);
			empleado.setFechaNac(fecha);
			break;
		case "6":
			System.out.println("Introduzca el dia de alta :");
			int dia2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el mes de alta :");
			int mes2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el a�o de alta :");
			int a�o2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fechaAlta = new GregorianCalendar(a�o2, mes2, dia2);
			empleado.setFechaAlta(fechaAlta);
			break;
		case "7":
			InterfazUsuario.imprimeMenuOficina();
			empleado.setOficina(elegirOficina());
			break;
		case "8":
			System.out.println("�Adios!");
			break;
		}
	}
	
	/**
	 * Elimina un vehiculo, que tenga la clave pasada por parametro	
	 * @param key , String con la matricula del vehiculo.
	 */
	public static void eliminaVehiculo( String key){		
		Principal.empresa.getVehiculos().remove(key);
	}
	
	/**
	 * Elimina una categoria, que tenga la clave pasada por parametro	
	 * @param key , String con la clave de la categoria.
	 */
	public static void eliminaCategoria( String key){		
		Principal.empresa.getCategorias().remove(key);
	}
	
	/**
	 * Elimina un alquiler, que tenga la clave pasada por parametro	
	 * @param key , String con la id del alquiler.
	 */
	public static void eliminaAlquiler( String key){		
		Principal.empresa.getAlquileres().remove(key);
	}
	
	/**
	 * Elimina una devolucion, que tenga la clave pasada por parametro	
	 * @param key , String con la id de la devolucion.
	 */
	public static void eliminaDevolucion( String key){		
		Principal.empresa.getDevoluciones().remove(key);
	}
	/**
	 * Elimina un cliente, que tenga la clave pasada por parametro	
	 * @param key , String con el dni del cliente.
	 */
	public static void eliminaCliente( String key){		
		Principal.empresa.getClientes().remove(key);
	}
	/**
	 * Elimina una oficina, que tenga la clave pasada por parametro	
	 * @param key , String con la id de la oficina.
	 */
	public static void eliminaOficina( String key){		
		Principal.empresa.getOficinas().remove(key);
	}
	/**
	 * Elimina un Empleado, que tenga la clave pasada por parametro	
	 * @param key , String con el dni del empleado.
	 */
	public static void eliminaEmpleado( String key){		
		Principal.empresa.getEmpleados().remove(key);
	}
	
	/**
	 * Pide categoria del menu imprimido
	 * @return Categoria seleccionda.
	 */
	public static Categoria elegirCategoria() {
		String opcion="";
		Categoria categoria = null;
		
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
		
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);

		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(10, 11);
		
		categoria=Principal.empresa.getCategorias().get(key);
		
		return categoria;
				
	}

	/**
	 * Pide oficina del menu imprimido
	 * @return oficina seleccionda.
	 */
	public static Oficina elegirOficina() {
		String opcion="";
		Oficina oficina= null;
		
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
	
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, 4);
		
		oficina=Principal.empresa.getOficinas().get(key);
		
		return oficina;
				
	}

	/**
	 * Pide alquiler del menu imprimido
	 * @return Alquiler seleccionda.
	 */
	public static Alquiler elegirAlquiler() {
		String opcion="";
		Alquiler alquiler= null;
		
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
	
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, 4);
		
		alquiler=Principal.empresa.getAlquileres().get(key);
		
		return alquiler;
				
	}

	/**
	 * Pide devolucion del menu imprimido
	 * @return Devolucion seleccionda.
	 */
	public static Devolucion elegirDevolucion() {
		String opcion="";
		Devolucion devolucion= null;
		
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
	
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, 4);
		
		devolucion=Principal.empresa.getDevoluciones().get(key);
		
		return devolucion;
	}

	/**
	 * Pide cliente del menu imprimido
	 * @return Cliente seleccionda.
	 */	
	public static Cliente elegirCliente() {
		String opcion="";
		Cliente cliente= null;
		
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
	
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, 9);
		
		cliente=Principal.empresa.getClientes().get(key);
		
		return cliente;
				
	}

	/**
	 * Pide empleado del menu imprimido
	 * @return Empleado seleccionda.
	 */
	public static Empleado elegirEmpleado() {
		String opcion="";
		Empleado empleado= null;
		
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
	
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, 9);
		
		empleado=Principal.empresa.getEmpleados().get(key);
		
		return empleado;
	}

	/**
	 * Pide moto de una determinada oficina, ya imprimidos en otro metodo.
	 * @param ofi Oficina del cual queremos filtrar
	 * @return Moto elegida
	 */
	public static Moto elegirMotoDeOficina ( Oficina ofi) {
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		int contador = 0;
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			
			boolean mismaOfi = false;
			String key = b.getKey();
			if (Principal.empresa.getVehiculos().get(key).getOficina().equals(ofi)) mismaOfi=true;
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof Moto && mismaOfi) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		Moto b = (Moto) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}

	/**
	 * Pide empleado de una determinada oficina, ya imprimidos en otro metodo.
	 * @param ofi Oficina del cual queremos filtrar
	 * @return Empleado elegida
	 */
	public static Empleado elegirEmpleadoDeOficina ( Oficina ofi) {
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		int contador = 0;
		for (Map.Entry<String, Empleado> b : Principal.empresa.getEmpleados().entrySet()) {
			
			boolean mismaOfi = false;
			String key = b.getKey();
			if (Principal.empresa.getEmpleados().get(key).getOficina().equals(ofi)) mismaOfi=true;
			//si es una moto se guarda en el arraylist
			if (b.getValue() instanceof Empleado && mismaOfi) {
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
			}
		}
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		Empleado b = (Empleado) Principal.empresa.getEmpleados().get(key);
		
		return b;
	}
	
	/**
	 * Pide Furgoneta de una determinada oficina, ya imprimidos en otro metodo.
	 * @param ofi Oficina del cual queremos filtrar
	 * @return Furgoneta elegida
	 */
	public static Furgoneta elegirFurgonetaDeOficina ( Oficina ofi) {
		
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
			}
		}
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		Furgoneta b = (Furgoneta) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}	

	/**
	 * Pide CocheElectrico de una determinada oficina, ya imprimidos en otro metodo.
	 * @param ofi Oficina del cual queremos filtrar
	 * @return CocheElctrico elegido
	 */
	public static CocheElectrico elegirCocheElectricoDeOficina ( Oficina ofi) {

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
			}
		}
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		CocheElectrico b = (CocheElectrico) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}
	
	/**
	 * Pide CocheCombustion de una determinada oficina, ya imprimidos en otro metodo.
	 * @param ofi Oficina del cual queremos filtrar
	 * @return CocheCombustion elegida
	 */
	public static CocheCombustion elegirCocheCombustionDeOficina ( Oficina ofi) {

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
			}
		}
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		CocheCombustion b = (CocheCombustion) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}

	/**
	 * Pide tipo carnet, de un menu ya impreso en otra funcion
	 * @return TipoCarnet elegido
	 */
	public static TipoCarnet elegirTipoCarnet() {
		String opcion="";
		TipoCarnet tipoCarnet= null;
		int posi;
			
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
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		tipoCarnet=Principal.empresa.getTipoCarnet().get(key);
		
		return tipoCarnet;
				
	}

	/**
	 * Pide nivel de emision, de un menu ya impreso en otra funcion
	 * @return NivelEmison elegido
	 */
	public static String elegirNivelEmision() {
		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getNivelEmision();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		return opcion;
				
	}
	
	/**
	 * Pide tipo vehiculo (4x4, familiar...etc), de un menu ya impreso en otra funcion
	 * @return Tipo elegido
	 */
	public static String elegirTipo() {
		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getTipo();

		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
				
		opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		return opcion;		
	}

	/**
	 * Pide moto, de un menu ya impreso en otra funcion
	 * @return Moto elegido
	 */
	public static Moto seleccionaMotoMenu () {
		
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
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		Moto b = (Moto) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}
	
	/**
	 * Pide Furgoneta, de un menu ya impreso en otra funcion
	 * @return Furgoneta elegido
	 */
	public static Furgoneta seleccionaFurgonetaMenu () {
		
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
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		Furgoneta b = (Furgoneta) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}
	
	/**
	 * Pide CocheElectrico, de un menu ya impreso en otra funcion
	 * @return CocheElectrico elegido
	 */
	public static CocheElectrico seleccionaCocheElectricoMenu () {
		
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
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		CocheElectrico b = (CocheElectrico) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}
	
	/**
	 * Pide cocheCombustion, de un menu ya impreso en otra funcion
	 * @return CocheCombustion elegido
	 */
	public static CocheCombustion seleccionaCocheCombustionMenu () {
		
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
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		
		//extraigo la clave de la opcion elegida para buscarlo en el Treemap
		int posi = list_opc.get(Integer.parseInt(opcion)-1).indexOf(",");
		String key = list_opc.get(Integer.parseInt(opcion)-1).substring(0, posi);
		
		CocheCombustion b = (CocheCombustion) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}
	
	/**
	 * Pide seleccionar una propiedad de una moto, de un menu ya impreso en otra funcion
	 * @return propiedad elegida
	 */
	public static String seleccionaPropiedadMoto () {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosMoto();
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		return opcion;
	}
	
	/**
	 * Pide seleccionar una propiedad de una Furgoneta, de un menu ya impreso en otra funcion
	 * @return propiedad elegida
	 */
	public static String seleccionaPropiedadFurgoneta () {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosFurgoneta();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		return opcion;
	}
	
	/**
	 * Pide seleccionar una propiedad de un coche electrico, de un menu ya impreso en otra funcion
	 * @return propiedad elegida
	 */
	public static String seleccionaPropiedadCocheElectrico () {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCocheElectrico();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		return opcion;
	}
	
	/**
	 * Pide seleccionar una propiedad de un coche de combustion, de un menu ya impreso en otra funcion
	 * @return propiedad elegida
	 */
	public static String seleccionaPropiedadCocheCombustion () {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCocheCombustion();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		return opcion;
	}

	/**
	 * Pide seleccionar una propiedad de una oficina, de un menu ya impreso en otra funcion
	 * @return propiedad elegida
	 */
	public static String seleccionaPropiedadOficina () {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosOficina();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		return opcion;
	}

	/**
	 * Pide seleccionar una propiedad de un cliente, de un menu ya impreso en otra funcion
	 * @return propiedad elegida
	 */
	public static String seleccionaPropiedadCliente () {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosCliente();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		return opcion;
	}
	
	/**
	 * Pide seleccionar una propiedad de un empleado, de un menu ya impreso en otra funcion
	 * @return propiedad elegida
	 */
	public static String seleccionaPropiedadEmpleado () {
		//opciones para el menu
		ArrayList<String> list_opc = Principal.empresa.getAtributosEmpleado();
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}		
		String opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
		return opcion;
	}
}
	
