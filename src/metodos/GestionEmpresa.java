package metodos;

import objetos.*;
import principal.Principal;

import java.util.*;

public class GestionEmpresa {
	public static void creaMoto(){
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
		matricula = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Vehículo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Vehículo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de alta del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fecha_alta = new GregorianCalendar(año, mes, dia);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Vehículo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuCategoria();
		categoria = elegirCategoria();
		
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		System.out.println("Introduce la autonomia del Vehículo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce el Tiempo de Recarga del Vehículo.");
		tiempoRecarga = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce la Cilindrada del Vehículo.");
		cilindrada = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuTipoCarnet();
		tipoCarnet=elegirTipoCarnet();
		
		Principal.empresa.getVehiculos().put(matricula, new Moto(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, cilindrada, tipoCarnet));
	}
	
	public static void creaOficina(){
		String cod;
		String descripcion;
		String localidad;
		String provincia;
		boolean ofiAeropuerto;

		//pido todos los datos
		System.out.println("Introduce el codigo de la oficina.");
		cod = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la descripcion de la oficina.");
		descripcion = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce la localidad de la oficina.");
		localidad = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce la provincia de la oficina.");
		provincia = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		miLibreria.interfazDeUsuario.MenuBoolean.imprimir();
		ofiAeropuerto=miLibreria.interfazDeUsuario.MenuBoolean.pedirOpc();
		
		Principal.empresa.getOficinas().put(cod, new Oficina(cod, descripcion, localidad, provincia, ofiAeropuerto));
	}
	
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
		int año;
		Oficina oficinaDevolucion;
		GregorianCalendar finAlquilerPrevisto;
		
		int aux;
		//pido todos los datos
		System.out.println("Introduce el codigo del Alquiler.");
		id = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		do {
			System.out.println("Oficina donde se quiere realizar el alquiler.");
			InterfazUsuario.imprimeMenuOficina();
			oficinaAlquiler = elegirOficina();
			
			InterfazUsuario.imprimeMenuVehiculo();
			opcion=Especificos.eligeMenuVehiculo();
			
			switch (opcion)
			{
			case "1":
				if (InterfazUsuario.impimeMenuMotoDeOficina(oficinaAlquiler )> 0) {
					//aux=InterfazUsuario.impimeMenuMotoDeOficina(oficinaAlquiler);
					vehiculo = elegirMotoDeOficina(oficinaAlquiler);
				} else {
					System.out.println("Actualmente no tenemos es tipo de Vehiculos en esa Oficina.");
				}

				break;
			case "2":
				if (InterfazUsuario.impimeMenuFurgonetaDeOficina(oficinaAlquiler )> 0) {
					//aux=InterfazUsuario.impimeMenuFurgonetaDeOficina(oficinaAlquiler);
					vehiculo = elegirFurgonetaDeOficina(oficinaAlquiler);
				} else {
					System.out.println("Actualmente no tenemos es tipo de Vehiculos en esa Oficina.");
				}

				break;
			case "3":
				if (InterfazUsuario.impimeMenuCocheCombustionDeOficina(oficinaAlquiler )> 0) {
					//aux=InterfazUsuario.impimeMenuCocheCombustionDeOficina(oficinaAlquiler);
					vehiculo = elegirCocheCombustionDeOficina(oficinaAlquiler);
				} else {
					System.out.println("Actualmente no tenemos es tipo de Vehiculos en esa Oficina.");
				}

				break;
			case "4":
				if (InterfazUsuario.impimeMenuCocheElectricoDeOficina(oficinaAlquiler )> 0) {
					//aux=InterfazUsuario.impimeMenuCocheElectricoDeOficina(oficinaAlquiler);
					vehiculo = elegirCocheElectricoDeOficina(oficinaAlquiler);
				} else {
					System.out.println("Actualmente no tenemos es tipo de Vehiculos en esa Oficina.");
				}
			}
			
			if (InterfazUsuario.impimeMenuEmpleadoDeOficina(oficinaAlquiler )> 0) {
				aux=InterfazUsuario.impimeMenuEmpleadoDeOficina(oficinaAlquiler);
				empleado = elegirEmpleadoDeOficina(oficinaAlquiler);
			} else {
				System.out.println("Actualmente no tenemos trabajdores en esa Oficina.");
			}
			
			if (vehiculo==null || empleado==null) System.out.println("Vuelva a seleccionar.");
			
		}while (vehiculo==null && empleado==null);
		
		

	
		InterfazUsuario.impimeMenuCliente();
		cliente = elegirCliente();
		
		System.out.println("Fecha de inicio Alquiler :");
		System.out.println("Introduce el dia de alquiler del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alquiler del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de alquiler del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		iniAlquiler = new GregorianCalendar(año, mes, dia);
		System.out.println();
	
		
		System.out.println("Fecha de fin Alquiler prevista :");
		System.out.println("Introduce el dia de alquiler.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alquiler del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de alquiler del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		finAlquilerPrevisto = new GregorianCalendar(año, mes, dia);
		System.out.println();
	
		System.out.println("Oficina donde se devuelverá el vehiculo : ");
		InterfazUsuario.imprimeMenuOficina();
		oficinaDevolucion = elegirOficina();
		
		Principal.empresa.getAlquileres().put(id, new Alquiler(Integer.valueOf(id), vehiculo, empleado, cliente, iniAlquiler, oficinaDevolucion, finAlquilerPrevisto));
	
		System.out.println(vehiculo.calculaAlquilerPrevisto(Principal.empresa.getAlquileres().get(id))+"€");
	}
	
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
		int año;
		Vehiculo vehiculo;
		Cliente cliente;
		
		//pido todos los datos
		System.out.println("Introduce el id de la Devolucion.");
		id = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();

		System.out.println("Elige el alquiler que realizó.");
		InterfazUsuario.impimeMenuAlquiler();
		alquiler = elegirAlquiler();
		
		System.out.println("¿Cuantos Kilometros a recorrido con el vehículo?");
		kmsRecorridos=miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuGestionEmpleados();
		empleado = elegirEmpleado();
			
		System.out.println("Fecha de finalizacion Alquiler :");
		System.out.println("Introduce el dia de devolucion del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de devolucion del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de devolucion del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fechaDevolucionReal = new GregorianCalendar(año, mes, dia);
		System.out.println();
	
		vehiculo=alquiler.getVehiculo();
		cliente=alquiler.getCliente();
		oficina=alquiler.getOficina();
		
		Principal.empresa.getDevoluciones().put(id, new Devolucion(Integer.valueOf(id), oficina, alquiler, vehiculo, kmsRecorridos, fechaDevolucionReal, empleado, cliente));
	}
	
	
	public static void creaEmpleado(){
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
		dni = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce nombre del empleado.");
		nombre= miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el 1º apellido del empleado.");
		ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el 2º apellido del empleado.");
		ap2 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();

		System.out.println("Fecha de nacimiento :");
		System.out.println("Introduce el dia nacimineto del Empleado.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de nacimiento del Empleado.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de nacimiento del Empleado.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fechaNac = new GregorianCalendar(año, mes, dia);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Empleado.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Empleado.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de alta del Empleado.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fechaAlta = new GregorianCalendar(año, mes, dia);
		System.out.println();
	
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		Principal.empresa.getEmpleados().put(dni, new Empleado(ap1, ap2, nombre, fechaNac, dni, oficina, fechaAlta));
	}
	
	public static void creaCliente(){
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
		dni = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce nombre del Cliente.");
		nombre= miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el 1º apellido del Cliente.");
		ap1 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el 2º apellido del Cliente.");
		ap2 = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();

		System.out.println("Fecha de nacimiento :");
		System.out.println("Introduce el dia nacimineto del Cliente.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de nacimiento del Cliente.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de nacimiento del Cliente.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fechaNac = new GregorianCalendar(año, mes, dia);
		System.out.println();
		
		InterfazUsuario.imprimeMenuTipoCarnet();
		tipoCarnet = elegirTipoCarnet();
	
		System.out.println("Introduce el Nº de tarjeta del Cliente.");
		nTarjeta = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		Principal.empresa.getClientes().put(dni, new Cliente(ap1, ap2, nombre, fechaNac, dni, tipoCarnet, nTarjeta));
	}
	
	
	public static void creaCategoria(){
		String codigo;
		String desc;
		int porcentajeRecargo;

		//pido todos los datos
		System.out.println("Introduzca el codigo");
		codigo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la descripción de la categoria");
		desc = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el Porcentaje de recargo para la categoria.");
		porcentajeRecargo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		Principal.empresa.getCategorias().put(codigo, new Categoria(codigo, desc, porcentajeRecargo));
	}
	
	public static void creaFurgoneta(){
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
		matricula = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Vehículo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Vehículo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de alta del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fecha_alta = new GregorianCalendar(año, mes, dia);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Vehículo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuCategoria();
		categoria = elegirCategoria();
		
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		System.out.println("Introduce la autonomia del Vehículo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce el Tiempo de Recarga del Vehículo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuNivelEmision();
		nivelEmision=elegirNivelEmision();

		System.out.println("Introduce la capacidad de carga del Vehículo.");
		capacidadCarga = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuTipoCarnet();
		tipoCarnet=elegirTipoCarnet();
		
		Principal.empresa.getVehiculos().put(matricula, new Furgoneta(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, consumo, potencia, nivelEmision, capacidadCarga, tipoCarnet));
	}
	
	public static void creaCocheCombustion(){
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
		matricula = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Vehículo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Vehículo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de alta del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fecha_alta = new GregorianCalendar(año, mes, dia);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Vehículo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuCategoria();
		categoria = elegirCategoria();
		
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		System.out.println("Introduce el consumo del Vehículo.");
		consumo = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce la potencia del Vehículo.");
		potencia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuNivelEmision();
		nivelEmision=elegirNivelEmision();

		System.out.println("Introduce el número de Plazas del Vehículo.");
		nPlazas = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuTipo();
		tipo=elegirTipo();
		
		Principal.empresa.getVehiculos().put(matricula, new CocheCombustion(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, consumo, potencia, nivelEmision, nPlazas, tipo));
	}

	public static void creaCocheElectrico(){
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
		matricula = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in).toUpperCase();
		System.out.println();

		System.out.println("Introduce la marca del Vehículo.");
		marca = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Introduce el modelo del Vehículo.");
		modelo = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
		System.out.println();
		
		System.out.println("Fecha de alta :");
		System.out.println("Introduce el dia de alta del Vehículo.");
		dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el mes de alta del Vehículo.");
		mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		System.out.println("Introduce el año de alta del Vehículo.");
		año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		fecha_alta = new GregorianCalendar(año, mes, dia);
		System.out.println();
		
		System.out.println("Introduce los Kilometros del Vehículo.");
		kms = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuCategoria();
		categoria = elegirCategoria();
		
		InterfazUsuario.imprimeMenuOficina();
		oficina = elegirOficina();
		
		System.out.println("Introduce la autonomia del Vehículo.");
		autonomia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce el Tiempo de Recarga del Vehículo.");
		tiempoRecarga= miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		System.out.println("Introduce el número de Plazas del Vehículo.");
		nPlazas = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
		
		InterfazUsuario.imprimeMenuNivelEmision();
		tipo=elegirTipo();
		
		Principal.empresa.getVehiculos().put(matricula, new CocheElectrico(matricula, marca, modelo, color, fecha_alta, kms, categoria, oficina, false, autonomia, tiempoRecarga, nPlazas, tipo));
	}
	
	public static void modificaMoto( Moto moto){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosMotos();
		opcion = seleccionaPropiedadMoto();
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
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
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
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

	public static void modificaFurgoneta(Furgoneta furgoneta){
		
		String opcion="";
		
		InterfazUsuario.impimeAtributosFurgoneta();
		opcion = seleccionaPropiedadFurgoneta();
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
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
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
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
	
	public static void modificaCocheCombustion( CocheCombustion coche){
		
		String opcion="";
		
		InterfazUsuario.impimeAtributosCocheCombustion();
		opcion = seleccionaPropiedadCocheCombustion();
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
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
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
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

	public static void modificaCocheElectrico( CocheElectrico coche){
		
		String opcion="";
		
		InterfazUsuario.impimeAtributosCocheElectrico();
		opcion = seleccionaPropiedadCocheElectrico();
		
		switch (opcion)
		{
		case "1":
			System.out.println("La matricula no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
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
			System.out.println("Introduzca el años de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
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
	
	public static void modificaCategoria(Categoria categoria){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosCategoria();
		opcion = seleccionaPropiedadMoto();
		
		switch (opcion)
		{
		case "1":
			System.out.println("El codigo no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
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
			System.out.println("¡Adios!");
			break;
		}
	}
	
	public static void modificaOficina(Oficina oficina){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosOficina();
		opcion = seleccionaPropiedadOficina();
		
		switch (opcion)
		{
		case "1":
			System.out.println("El codigo no se puede modificar, si es erronea deberá borrar la Moto y volver a crearla.");
			break;
		case "2":
			System.out.println("Introduzca la nueva descripcion :");
			String desc = miLibreria.metodos.PedirDatos.pideStringNoVacia(Principal.in);
			oficina.setDescripcion(opcion);
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
			System.out.println("¡Adios!");
			break;
		}
	}
	
	public static void modificaCliente( Cliente cliente){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosCliente();
		opcion = seleccionaPropiedadCliente();
		
		switch (opcion)
		{
		case "1":
			System.out.println("El DNI no se puede modificar, si es erroneo deberá borrar el cliente y volver a crearla.");
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
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
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
			System.out.println("¡Adios!");
			break;
		}
	}
	
	public static void modificaEmpleado( Empleado empleado){
		
		String opcion="";
				
		InterfazUsuario.impimeAtributosEmpleado();
		opcion = seleccionaPropiedadEmpleado();
		
		switch (opcion)
		{
		case "1":
			System.out.println("El DNI no se puede modificar, si es erroneo deberá borrar el cliente y volver a crearla.");
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
			System.out.println("Introduzca el año de alta :");
			int año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
			empleado.setFechaNac(fecha);
			break;
		case "6":
			System.out.println("Introduzca el dia de alta :");
			int dia2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el mes de alta :");
			int mes2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			System.out.println("Introduzca el año de alta :");
			int año2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
			GregorianCalendar fechaAlta = new GregorianCalendar(año2, mes2, dia2);
			empleado.setFechaAlta(fechaAlta);
			break;
		case "7":
			InterfazUsuario.imprimeMenuOficina();
			empleado.setOficina(elegirOficina());
			break;
		case "8":
			System.out.println("¡Adios!");
			break;
		}
	}
	
	public static void eliminaVehiculo( String key){		
		Principal.empresa.getVehiculos().remove(key);
	}
	
	public static void eliminaCategoria( String key){		
		Principal.empresa.getCategorias().remove(key);
	}
	
	public static void eliminaCliente( String key){		
		Principal.empresa.getClientes().remove(key);
	}
	
	public static void eliminaOficina( String key){		
		Principal.empresa.getOficinas().remove(key);
	}
	
	public static void eliminaEmpleado( String key){		
		Principal.empresa.getEmpleados().remove(key);
	}
	
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
	
	public static CocheElectrico elegirCocheCombustionDeOficina ( Oficina ofi) {

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
		
		CocheElectrico b = (CocheElectrico) Principal.empresa.getVehiculos().get(key);
		
		return b;
	}

	
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
	
