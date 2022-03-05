package metodosEspecificos;

import objetos.*;
import java.util.*;

public class DatosPrograma {

	public static Empresa creaEmpresaDefault() {
		String nombre = "PacoSuarez";
		String desc = "sssssssssssss";
		TreeMap<String,Vehiculo> vehiculos = new TreeMap<String,Vehiculo>();
		TreeMap<String,Cliente> clientes = new TreeMap<String,Cliente>();
		TreeMap<String,Empleado> empleados = new TreeMap<String,Empleado>();
		TreeMap<String,Oficina> oficinas = new TreeMap<String,Oficina>();
		TreeMap<String,Categoria> categorias = new TreeMap<String,Categoria>();
		TreeMap<String,Alquiler> alquileres = new TreeMap<String,Alquiler>();
		TreeMap<String,Devolucion> devoluciones = new TreeMap<String,Devolucion>();
		TreeMap<String,TipoCarnet> tipoCarnets= new TreeMap<String,TipoCarnet>();

		Empresa a = new Empresa(nombre, desc, vehiculos, clientes, empleados, oficinas, categorias, alquileres, devoluciones, tipoCarnets);
		
		return a;
	}
	
	public static void importarDatos(Empresa a) {
		generarCategorias(a);
		generarTipoCarnet(a);
		generarOficinas(a);
		generarClientes(a);
		generarEmpleados(a);
		generarVehiculos(a);
		generarAlquileres(a);
		generarCategorias(a);
	}
	
	public static void generarAlquileres(Empresa a) {
		a.añadeAlquiler(new Alquiler(2343, a.getVehiculos().get("F8DF3G"), a.getEmpleados().get("23423343T"), a.getClientes().get("23423555E"), new GregorianCalendar(2021, 5, 21), a.getOficinas().get("4302"), new GregorianCalendar(2021, 6, 21)));
		a.añadeAlquiler(new Alquiler(5345, a.getVehiculos().get("SF9SDF"), a.getEmpleados().get("12341234J"), a.getClientes().get("87657555R"), new GregorianCalendar(2022, 1, 12), a.getOficinas().get("1002"), new GregorianCalendar(2022, 4, 12)));
		a.añadeAlquiler(new Alquiler(2343, a.getVehiculos().get("GEFD43"), a.getEmpleados().get("92846250P"), a.getClientes().get("93285267Z"), new GregorianCalendar(2022, 3, 05), a.getOficinas().get("6573"), new GregorianCalendar(2022, 6, 05)));
		a.añadeAlquiler(new Alquiler(2153, a.getVehiculos().get("4FD36K"), a.getEmpleados().get("54682357C"), a.getClientes().get("23422855J"), new GregorianCalendar(2018, 12, 30), a.getOficinas().get("1212"), new GregorianCalendar(2019, 5, 12)));
	}
	
	public static void generarDevoluciones(Empresa a) {
		a.añadeDevolucion(new Devolucion(2553, a.getOficinas().get("4302"), a.getAlquileres().get("2323"), a.getVehiculos().get("F8DF3G"), 1150 ,  new GregorianCalendar(2021, 6, 21), a.getEmpleados().get("23423343T"), a.getClientes().get("23423555E")));
		a.añadeDevolucion(new Devolucion(3424, a.getOficinas().get("1002"), a.getAlquileres().get("5345"), a.getVehiculos().get("SF9SDF"), 2220 ,  new GregorianCalendar(2022, 4, 13), a.getEmpleados().get("12341234J"), a.getClientes().get("87657555R")));
		a.añadeDevolucion(new Devolucion(7454, a.getOficinas().get("6573"), a.getAlquileres().get("2343"), a.getVehiculos().get("GEFD43"), 555 ,  new GregorianCalendar(2022, 6, 05), a.getEmpleados().get("92846250P"), a.getClientes().get("93285267Z")));
		a.añadeDevolucion(new Devolucion(6436, a.getOficinas().get("1212"), a.getAlquileres().get("2153"), a.getVehiculos().get("4FD36K"), 3333 ,  new GregorianCalendar(2019, 5, 16), a.getEmpleados().get("54682357C"), a.getClientes().get("23422855J")));
	}
	
	public static void generarOficinas(Empresa a)
	{
		a.añadeOficina(new Oficina("2323", "Alide", "Baeza", "Jaén", false));
		a.añadeOficina(new Oficina("1212", "Geogeo", "Ibroz", "Jaén", false));
		a.añadeOficina(new Oficina("3452", "Caces", "Arniz", "Huelva", false));
		a.añadeOficina(new Oficina("1002", "Ramirez", "Castillo", "Cordoba", false));
		a.añadeOficina(new Oficina("4302", "Cositos", "Cadiz", "Cádiz", false));
		a.añadeOficina(new Oficina("6054", "Doritos", "Almen", "Almeria", false));
		a.añadeOficina(new Oficina("5424", "Nombre serio1", "Pescao", "Huelva", false));
		a.añadeOficina(new Oficina("6573", "ChingosVehiculos", "Chingos", "Granada", false));
		
	}
	
	public static void generarEmpleados(Empresa a)
	{
		a.añadeEmpleado(new Empleado("Fernandez", "Ceacero", "Andrés", new GregorianCalendar(2001, 02,22), "23423555R", a.getOficinas().get("5424"), new GregorianCalendar(2011, 05,25)));
		a.añadeEmpleado(new Empleado("Fernandez", "Fernandez", "Jose", new GregorianCalendar(2004, 01,24), "23423343T", a.getOficinas().get("4302"), new GregorianCalendar(2015, 12,01)));
		a.añadeEmpleado(new Empleado("Suarez", "Ceacero", "Paco", new GregorianCalendar(1700, 02,10), "12345678R", a.getOficinas().get("2323"), new GregorianCalendar(2004, 05,30)));
		a.añadeEmpleado(new Empleado("Ceacero", "Ceacero", "Roberto", new GregorianCalendar(2007, 10,01), "87654321J", a.getOficinas().get("6054"), new GregorianCalendar(2022, 01,20)));
		a.añadeEmpleado(new Empleado("Ramirez", "Suarez", "Antonio", new GregorianCalendar(1995, 11,11), "12341234J", a.getOficinas().get("1002"), new GregorianCalendar(2020, 06,11)));
		a.añadeEmpleado(new Empleado("Sanchez", "Ceacero", "Maria", new GregorianCalendar(1990, 12,16), "54682357C", a.getOficinas().get("1212"), new GregorianCalendar(2018, 06,02)));
		a.añadeEmpleado(new Empleado("Sanchez", "Suarez", "Sara", new GregorianCalendar(2000, 8,02), "92846250P", a.getOficinas().get("6573"), new GregorianCalendar(2015, 02,01)));
	}
	
	public static TreeMap<String, String> generarTipoCarnet () {
		TreeMap<String, String> b = new TreeMap<String, String>();
		
		b.put("AM", "Ciclomotores 50cc");
		b.put("A1", "Motocicletas 125cm");
		b.put("A2", "Motocicleta 35Kw");
		b.put("B", "Automoviles 3500kg");
		b.put("C1", "Automoviles 7500kg");
		
		return b;
	}
	
	public static void generarClientes(Empresa a) {
		a.añadeCliente(new Cliente("Hernandez", "Ceacero", "Andrés", new GregorianCalendar(2001, 05,22), "23423555E", a.getTipoCarnet().get("A1"), "1111"));
		a.añadeCliente(new Cliente("Fernandez", "Hernandez", "Paco", new GregorianCalendar(2002, 12,01), "23423HGDD", a.getTipoCarnet().get("A2"), "1352"));
		a.añadeCliente(new Cliente("Sanchez", "Ceacero", "Jose", new GregorianCalendar(2006, 11,11), "87657555R", a.getTipoCarnet().get("B"), "1754"));
		a.añadeCliente(new Cliente("Suarez", "Perez", "Sara", new GregorianCalendar(1999, 10,16), "23422855J", a.getTipoCarnet().get("AM"), "6453"));
		a.añadeCliente(new Cliente("Sanchez", "Perez", "Paco", new GregorianCalendar(1995, 9,26), "92857245B", a.getTipoCarnet().get("B"), "0904"));
		a.añadeCliente(new Cliente("Suarez", "Ceacero", "Maria", new GregorianCalendar(1990, 8,30), "93285267Z", a.getTipoCarnet().get("B+E"), "6864"));
		a.añadeCliente(new Cliente("Hernandez", "Sanchez", "Emilia", new GregorianCalendar(2005, 07,10), "20423564W", a.getTipoCarnet().get("B"), "4444"));
		a.añadeCliente(new Cliente("Sanchez", "Suarez", "Antonio", new GregorianCalendar(1985, 01,05), "45643734G", a.getTipoCarnet().get("B+E"), "7545"));
	}
	
	public static void generarTipoCarnet(Empresa a) {
		a.añadeTipoCarnet(new TipoCarnet("A1", "Motocicletas 125cm"));;
		a.añadeTipoCarnet(new TipoCarnet("A1", "Motocicletas 125cm"));
		a.añadeTipoCarnet(new TipoCarnet("A2", "Motocicleta 35Kw"));
		a.añadeTipoCarnet(new TipoCarnet("B", "Automoviles 3500kg"));
		a.añadeTipoCarnet(new TipoCarnet("C1", "Automoviles 7500kg"));
	}
	
	public static void generarCategorias(Empresa a) {
		a.añadeCategoria(new Categoria("A", "PREMIUN", 20));
		a.añadeCategoria(new Categoria("C", "NORMAL", 5));
		a.añadeCategoria(new Categoria("D", "BASICO", 0));
	}
	
	public static void generarVehiculos(Empresa a)
	{
		a.añadeVehiculo(new CocheCombustion("453DGJ", "KIA" , "NIRA", "GRIS", new GregorianCalendar(2006, 01,05), 11000, a.getCategorias().get("A"), a.getOficinas().get("4302"), false,22, 150, "A", 5, "4x4"));
		a.añadeVehiculo(new CocheCombustion("4FD36K", "MERCEDES" , "GLB", "AZUL", new GregorianCalendar(2005, 12,02),25000, a.getCategorias().get("B"), a.getOficinas().get("6572"), false,10, 100, "B", 7, "FAMILIAR"));
		a.añadeVehiculo(new CocheCombustion("96G53W", "OPEL" , "ADAM", "NEGRO", new GregorianCalendar(1999, 9,01), 50000, a.getCategorias().get("C"), a.getOficinas().get("1212"), false,13, 70, "C", 2, "4x4"));
		a.añadeVehiculo(new CocheElectrico("96G53W", "TESLA" , "Z", "BLANCO", new GregorianCalendar(2010, 05,15), 2000, a.getCategorias().get("A"), a.getOficinas().get("1002"), false, 7000, 120, 5, "DEPORTIVO"));
		a.añadeVehiculo(new CocheElectrico("DFG53W", "RENAULT" , "ZOE", "GRIS", new GregorianCalendar(2011, 8,11), 3008, a.getCategorias().get("B"), a.getOficinas().get("3452"), false, 2000, 100, 7, "FAMILIAR"));
		a.añadeVehiculo(new CocheElectrico("96G53W", "SUZUKI" , "VITARA", "BLANCO", new GregorianCalendar(2019, 11,21), 4000, a.getCategorias().get("C"), a.getOficinas().get("6054"), false, 5000, 120, 5, "4X4"));
		a.añadeVehiculo(new Moto("GEFD43", "KIMKO" , "DTX", "NEGRA", new GregorianCalendar(2011, 8,11), 3008,a.getCategorias().get("B"), a.getOficinas().get("3452"), false, 5000, 120, 75, a.getTipoCarnet().get("A1")));
		a.añadeVehiculo(new Moto("G8FK38", "GUZZI" , "V85", "GRIS", new GregorianCalendar(2020, 4,30), 5555,a.getCategorias().get("A"), a.getOficinas().get("2323"), false, 7000, 100, 120, a.getTipoCarnet().get("A2")));
		a.añadeVehiculo(new Moto("D9F8S3", "FB MONDIAL" , "SMX", "GRIS", new GregorianCalendar(2022, 1,11), 6666,a.getCategorias().get("C"), a.getOficinas().get("6572"), false, 4444, 90, 75, a.getTipoCarnet().get("A1")));
		a.añadeVehiculo(new Furgoneta("F8DF3G", "RENAULT" , "ABC", "GRIS", new GregorianCalendar(2020, 7,21), 4000,a.getCategorias().get("C"), a.getOficinas().get("6572"), false, 300 ,4444, "B", 3500, a.getTipoCarnet().get("B")));
		a.añadeVehiculo(new Furgoneta("DFSG82", "FERRARI" , "FDS", "AZUL", new GregorianCalendar(2011, 11,29), 5555,a.getCategorias().get("A"), a.getOficinas().get("4302"), false, 350 ,5555, "A", 7500, a.getTipoCarnet().get("B+E")));
		a.añadeVehiculo(new Furgoneta("EFGWE4", "SUZUKI" , "ADAM", "NEGRO", new GregorianCalendar(2007, 2,21), 3555,a.getCategorias().get("B"), a.getOficinas().get("1002"), false, 255 ,3333, "C", 7500, a.getTipoCarnet().get("B+E")));
	}
	
	//public static void buscarOficina (Empresa a)
}
