package metodos;

import principal.Principal;

import java.util.*;

import comparadores.*;
import entidades.*;

public class Especificos {
	
	public static boolean pideyVerificaContraseña () {
		boolean valido = false;
		String contraseña = "";
		
			contraseña=Principal.in.nextLine();
			if (contraseña.equalsIgnoreCase("Andres1234")) {
				valido=true;
			}
		
		return valido;
	}
	
	/**
	 * Genera ids unaicas para los clientes
	 * @return String con el id
	 */
	public static String generaIdCliente () {
		
		Random random = new Random();

		boolean distinto = true;
		int num=0;
		
		//genera un numero random de 4 digitos que no se encuentre en los clientes
		do {
			num = 1000+random.nextInt(9999);
			for (Map.Entry<String, Cliente> b : Principal.empresa.getClientes().entrySet()) {
				if (b.getValue().getnTarjetaCliente().equals(b)) distinto=false;
			}
		}while(!distinto && num>9999);
		
		return num+"";
	}
	
	/**
	 * Genera ids unicas para las oficinas
	 * @return String con el id
	 */
	public static String generaIdOficina () {
		
		Random random = new Random();

		boolean distinto = true;
		int num=0;
		//genera un numero random de 4 digitos que no se encuentre en las oficinas	
		do {
			num = 1000+random.nextInt(9999);
			for (Map.Entry<String, Oficina> b : Principal.empresa.getOficinas().entrySet()) {
				if (b.getKey().equals(b)) distinto=false;
			}
		}while(!distinto && num>9999);
		
		return num+"";
	}
	
	/**
	 * Genera ids unicas para los alquileres
	 * @return String con el id
	 */
	public static String generaIdAlquiler () {
		
		Random random = new Random();

		boolean distinto = true;
		int num=0;
		//genera un numero random de 4 digitos que no se encuentre en los alquileres	
		do {
			num = 1000+random.nextInt(9999);
			for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
				if (b.getKey().equals(b)) distinto=false;
			}
		}while(!distinto && num>9999);
		
		return num+"";
	}
	/**
	 * Genera ids unicas para los alquileres
	 * @return String con el id
	 */
	public static String generaIdDevolucion () {
		
		Random random = new Random();

		boolean distinto = true;
		int num=0;
		//genera un numero random de 4 digitos que no se encuentre en los alquileres	
		do {
			num = 1000+random.nextInt(9999);
			for (Map.Entry<String, Alquiler> b : Principal.empresa.getAlquileres().entrySet()) {
				if (b.getKey().equals(b)) distinto=false;
			}
		}while(!distinto && num>9999);
		
		return num+"";
	}
	
	/**
	 * Menu principal del programa, que llama a los demás metodos (Imprime y pide).
	 */
	public static void menuPrincipal () {
		
		String opcion ="";
	
		do {

			//imprimo y pido opc del menu
			InterfazUsuario.imprimeMenuPrincipal();
			opcion=eligeMenuPrincipal();

			switch (opcion)
			{
			case "1":
				System.out.println("Introduce la clave de acceso :");
				if (!pideyVerificaContraseña()) {
					System.out.println("Clave Incorrecta.");
					break;
				}
				menuGestionEmpresa();
				Principal.empresa.grabaDatosEmpresa();
				break;
			case "2":
				GestionEmpresa.creaAlquiler();
				break;
			case "3":
				GestionEmpresa.creaDevolucion();
				break;
			case "4":
				menuListados();
				break;
			case "5":
				System.out.println("¡Adiós!");
				Principal.empresa.grabaDatosEmpresa();
				break;
			}
			//si no es la opcion SALIR, pertenece en en menu principal
		}while (opcion.indexOf("5")==-1);
	}
	
	/**
	 * Menu con la gention de la empresa, de vehiculos, categorias, oficinas....
	 */
	public static void menuGestionEmpresa() {

		String opcion ="";
		
		do {
			Principal.empresa.grabaDatosEmpresa();
			//imprimo y pido la opcion
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
				menuGestionEmpleados();
				break;
			case "5":
				menuGestionClientes();
				break;
			case "6":
				System.out.println("¡Adiós!");
				break;
			}
			
		}while (opcion.indexOf("6")==-1);
	}
	
	/**
	 * Menu para elegir el tipo de listado que deseamos mostrar.
	 */
	public static void menuListados() {

		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuListados();
			opcion=eligeMenuListados();
			switch (opcion)
			{
			case "1":
				//pido las fechas en las que quiero filtrar
				System.out.println("Introduce la fecha de inicio :");
				System.out.println("Introduce el dia inicio.");
				int dia = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
				System.out.println("Introduce el mes de inicio.");
				int mes = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
				System.out.println("Introduce el año de inicio.");
				int año = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
				GregorianCalendar fechaInicio = new GregorianCalendar(año, mes, dia);
				System.out.println();
				
				
				System.out.println("Introduce la fecha de fin :");
				System.out.println("Introduce el dia de fin.");
				int dia2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
				System.out.println("Introduce el mes de fin.");
				int mes2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
				System.out.println("Introduce el año de fin.");
				int año2 = miLibreria.metodos.PedirDatos.pideEntero(Principal.in);
				GregorianCalendar fechaFinal = new GregorianCalendar(año2, mes2, dia2);
				System.out.println();
				//imprimo los alquileres que estén entre las fechas pedidas
				InterfazUsuario.imprimeAlquilerEntreFechas(fechaInicio, fechaFinal);
				break;
			case "2":
				//imprimo todos los vehiculos.
				InterfazUsuario.imprimeVehiculos();
				//pido que vehiculo.
				Vehiculo vehiculo=eligeVehiculo();
				//imprimo el alquiler de ese vehiculo.
				InterfazUsuario.imprimeListadoAlquilerVehiculo(vehiculo);
				break;
			case "3":
				menuListadoStock();
				break; 
			case "4":
				InterfazUsuario.imprimeAlquileres();
				break;
			case "5":
				InterfazUsuario.imprimeDevoluciones();
				break;
			case "6":
				InterfazUsuario.imprimeVehiculos();
				break;
			case "7":
				InterfazUsuario.imprimeMenuCliente();
				break;
			case "8":
				InterfazUsuario.impimeMenuEmpleado();
				break;
			case "9":
				InterfazUsuario.imprimeMenuOficina();
				break;
			}
			
		}while (opcion.indexOf("10")==-1);
	}
	
	/**
	 * Menu que muetra y pide las dierentes tipos de impresiones segun orden
	 */
	public static void menuListadoStock() {

		String opcion ="";
		
		do {
			InterfazUsuario.imprimeMenuListadoStock();
			opcion=eligeMenuListados();
			switch (opcion)
			{
			case "1":
				InterfazUsuario.imprimeAlquilerOrdenadoOfi();
				break;
			case "2":
				try {
					InterfazUsuario.imprimeAlquilerOrdenadoMarcas();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Herramienta no funcional actualmente.");
				}
				break;
			case "3":
				try {
					InterfazUsuario.imprimeAlquilerOrdenadoModelos();
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Herramienta no funcional actualmente.");
				}
				break;  
			case "4":
				System.out.println("¡Adiós!");
				break;
			}
		}while (opcion.indexOf("4")==-1);
	}

	/**
	 * Imprime y pide opciones que hacer con los empleados, crear, modificar y eliminar.
	 */
	public static void menuGestionEmpleados() {
		
		String opcion ="";
		
		do {
			Principal.empresa.grabaDatosEmpresa();
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
	
	/**
	 * Imprime y pide opciones que hacer con los clientes, crear, modificar y eliminar.
	 */
	public static void menuGestionClientes() {
		
		String opcion ="";
		
		do {
			Principal.empresa.grabaDatosEmpresa();
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

	/**
	 * Imprime y pide opciones que hacer con las categorias, crear, modificar y eliminar.
	 */
	public static void menuGestionCategorias() {
		
		String opcion ="";
		
		do {
			Principal.empresa.grabaDatosEmpresa();
			InterfazUsuario.imprimeMenuGestionCategorias();
			opcion=eligeMenuGestionCategorias();
			
			switch (opcion)
			{
			case "1":
				GestionEmpresa.creaCategoria();
				System.out.println("Categoria creada.");
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
	
	/**
	 * Imprime y pide opciones que hacer con las oficinas, crear, modificar y eliminar.
	 */
	public static void menuGestionOficinas() {
		
		String opcion ="";
		
		do {
			Principal.empresa.grabaDatosEmpresa();
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

	/**
	 * Imprime y pide opciones que hacer con los vehiculos, crear, modificar y eliminar.
	 */
	public static void menuGestionVehiculos() {
		
		String opcion ="";
		
		do {
			Principal.empresa.grabaDatosEmpresa();
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
	
	/**
	 * Imprime y pide el tipo de vehiculo, para despues crearlo.
	 */
	public static void menuAñadirVehiculo() {
		String opcion="";
		
		do {
			InterfazUsuario.imprimeMenuVehiculo();
			opcion=eligeMenuVehiculo();
			
			//una vez elegido que tipo de vehiculo, empezamos a crearlo
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
	
	/**
	 * Imprime y pide tipo de vehiculo, para despues borrarlo.
	 */
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
	
	/**
	 * Imprime y pide tipo de vehiculo para despues modificarlo.
	 */
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

	/**
	 * pide opciones del menu principal.
	 */
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
		//relleno el array con numeros, segun con la cantidad de las opciones
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	/**
	 * pide opciones del menu de listados
	 */
	public static String eligeMenuListados () {

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
		//relleno el array con numeros, segun con la cantidad de las opciones	
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	/**
	 * pide opciones del menu de listados por stock.
	 */
	public static String eligeMenuListadoStock () {

		String opcion="";
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		list_opc.add("Ordenado por oficinas.");
		list_opc.add("Ordenado por marcas.");
		list_opc.add("Ordenado por modelos.");
		list_opc.add("Salir.");
		
		//opciones para el indicador del menu
		ArrayList<String> opc_posibles = new ArrayList<String>();
		//relleno el array con numeros, segun con la cantidad de las opciones		
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	/**
	 * pide opciones del menu de gestion de los vehiculos.
	 */
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
		//relleno el array con numeros, segun con la cantidad de las opciones	
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	/**
	 * pide opciones del menu de gestion de los categorias.
	 */
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
		//relleno el array con numeros, segun con la cantidad de las opciones	
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	/**
	 * pide opciones del menu de gestion de los oficinas.
	 */
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
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	/**
	 * pide opciones del menu de gestion de los empleados.
	 */
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
		//relleno el array con numeros, segun con la cantidad de las opciones	
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}
	
	/**
	 * pide opciones del menu de gestion de los cliente.
	 */
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
		//relleno el array con numeros, segun con la cantidad de las opciones		
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}

	/**
	 * pide opciones del menu de gestion de los empresa.
	 */
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
		//relleno el array con numeros, segun con la cantidad de las opciones			
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}

	/**
	 * pide opciones del menu de que tipo de vehiculo deseea.
	 */
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
		//relleno el array con numeros, segun con la cantidad de las opciones				
		for (int i=0; i<=list_opc.size();i++) {
			opc_posibles.add((i+1)+"");
		}
		//devuelvo la opcion pedida, con el metodo que lo valida
		return opcion=miLibreria.interfazDeUsuario.Menu.pedirValidarOpcMenu(opc_posibles, Principal.in);
	}

	/**
	 * Imprime y pide una moto del listado
	 * @return la Moto elegida
	 */
	public static Moto pideMoto(){		
		InterfazUsuario.impimeMenuMotos();
		Moto moto =	GestionEmpresa.seleccionaMotoMenu();	
		return moto;
	}

	/**
	 * Imprime y pide una furgoneta del listado
	 * @return la Furgoneta elegida
	 */
	public static Furgoneta pideFurgoneta(){		
		InterfazUsuario.impimeMenuFurgoneta();
		Furgoneta furgoneta=GestionEmpresa.seleccionaFurgonetaMenu();
		return furgoneta;
	}
	
	/**
	 * Imprime y pide una Coche Combustion del listado
	 * @return la Coche Combustion elegida
	 */
	public static CocheCombustion pideCocheCombustion(){		
		InterfazUsuario.imprimeMenuCocheCombustión();
		CocheCombustion coche =	GestionEmpresa.seleccionaCocheCombustionMenu();	
		return coche;
	}
	
	/**
	 * Imprime y pide una Coche Electrico del listado
	 * @return la Coche Electrico elegida
	 */
	public static CocheElectrico pideCocheElectrico(){		
		InterfazUsuario.imprimeMenuCocheCombustión();
		CocheElectrico coche =	GestionEmpresa.seleccionaCocheElectricoMenu();	
		return coche;	}

	/**
	 * Imprime y pide una categoria del listado
	 * @return la Categoria elegida
	 */
	public static Categoria pideCategoria(){		
		InterfazUsuario.imprimeMenuCategorias();
		Categoria categoria = GestionEmpresa.elegirCategoria();	
		return categoria;
	}

	/**
	 * Imprime y pide una Oficina del listado
	 * @return la Oficina elegida
	 */
	public static Oficina pideOficina(){		
		InterfazUsuario.impimeMenuOficina();
		Oficina oficina= GestionEmpresa.elegirOficina();	
		return oficina;
	}
	
	/**
	 * Imprime y pide un cliente del listado
	 * @return el cliente elegido
	 */
	public static Cliente pideCliente(){		
		InterfazUsuario.imprimeMenuCliente();
		Cliente cliente= GestionEmpresa.elegirCliente();	
		return cliente;
	}
	
	/**
	 * Imprime y pide un Empleado del listado
	 * @return el empleado elegida
	 */
	public static Empleado pideEmpleado(){		
		InterfazUsuario.impimeMenuEmpleado();
		Empleado empleado= GestionEmpresa.elegirEmpleado();	
		return empleado;
	}

	/**
	 * Pide un vehiculo validado
	 * @return el vehiculo elegido
	 */
	public static Vehiculo eligeVehiculo () {
		
		//opciones para el menu
		ArrayList<String> list_opc = new ArrayList<String>();
		//convierto el TreeMap en arraylist para el menu.
		for (Map.Entry<String, Vehiculo> b : Principal.empresa.getVehiculos().entrySet()) {
			//si es una moto se guarda en el arraylist
				list_opc.add(b.toString().substring(b.toString().indexOf("=")+1));
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
		
		return Principal.empresa.getVehiculos().get(key);
	}
}
