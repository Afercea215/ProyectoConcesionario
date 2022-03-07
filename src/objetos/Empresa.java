package objetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 34263471567L;
	
	private String nombre;
	private String desc;
	private TreeMap<String, Vehiculo> vehiculos;
	private TreeMap<String,Cliente> clientes;
	private TreeMap<String,Empleado> empleados;
	private TreeMap<String,Oficina> oficinas;
	private TreeMap<String,Categoria> categorias;
	private TreeMap<String,Alquiler> alquileres;
	private TreeMap<String,Devolucion> devoluciones;
	private TreeMap<String,TipoCarnet> tipoCarnet;
	
	private ArrayList<String> atributosMoto;
	private ArrayList<String> atributosFurgoneta;
	private ArrayList<String> atributosCocheElectrico;
	private ArrayList<String> atributosCocheCombustion;
	private ArrayList<String> atributosCategoria;
	private ArrayList<String> atributosOficina;
	private ArrayList<String> atributosCliente;
	private ArrayList<String> atributosEmpleado;
	
	private ArrayList<String> tipo;
	private ArrayList<String> nivelEmision;
		
	
	
	/**
	 * Constructor completo de empresa
	 * @param nombre String con el nombre de la empresa.
	 * @param desc  String con la descripcion de la empresa.
	 * @param vehiculos TreeMap de objetos vehiculo.
	 * @param clientes TreeMap de objetos clientes.
	 * @param empleados TreeMap de objetos empleado.
	 * @param oficinas TreeMap de objetos oficina.
	 * @param categorias TreeMap de objetos categoria.
	 * @param alquileres TreeMap de objetos alquiler.
	 * @param devoluciones TreeMap de objetos devolucion.
	 * @param tipoCarnet TreeMap de objetos TipoCarnet con el que trabaja la empresa.
	 */
	public Empresa(String nombre, String desc, TreeMap<String, Vehiculo> vehiculos, TreeMap<String,Cliente> clientes,
			TreeMap<String,Empleado> empleados, TreeMap<String,Oficina> oficinas,
			TreeMap<String,Categoria> categorias, TreeMap<String,Alquiler> alquileres,
			TreeMap<String,Devolucion> devoluciones, TreeMap<String,TipoCarnet> tipoCarnet) {
		super();
		this.nombre = nombre;
		this.desc = desc;
		this.vehiculos = vehiculos;
		this.clientes = clientes;
		this.empleados = empleados;
		this.oficinas = oficinas;
		this.categorias = categorias;
		this.alquileres = alquileres;
		this.devoluciones = devoluciones;
		this.tipoCarnet = tipoCarnet;
	}

	/**
	 * Graba los datos de la empresa en el archivi "datosEmpresa.ser"
	 */
	public void grabaDatosEmpresa() {
		FileOutputStream f = null;
		ObjectOutputStream o = null;
		
		try {
			f = new FileOutputStream ("datosEmpresa.ser");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			o = new ObjectOutputStream(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			o.writeObject(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Lee datos de la empresa del archivo datosEmpresa.ser
	 */
	public static Empresa leeDatosFichero(Empresa empresa) {
		FileInputStream f = null;
		ObjectInputStream o = null;
		
		try {
			f = new FileInputStream ("datosEmpresa.ser");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			o = new ObjectInputStream(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			try {
				empresa = (Empresa) o.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return empresa;
	}

	
	///////////////////////////////////
	//GETTERS Y SETTERS
	////////////////////
	
	public ArrayList<String> getAtributosCliente() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("DNI.");
		aux.add("Nombre.");
		aux.add("Apellido 1.");
		aux.add("Apellido 2.");
		aux.add("Fecha de nacimiento.");
		aux.add("Tipo de Carnet de conducir.");
		aux.add("Numero Tarjeta cliente.");
		this.atributosCliente=aux;
		return aux;
	}
	
	public ArrayList<String> getAtributosEmpleado() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("DNI.");
		aux.add("Nombre.");
		aux.add("Apellido 1.");
		aux.add("Apellido 2.");
		aux.add("Fecha de nacimiento.");
		aux.add("Fecha de alta.");
		aux.add("Oficina.");
		this.atributosEmpleado=aux;
		return aux;
	}
	
	public ArrayList<String> getNivelEmision() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("Nivel emisión : A");
		aux.add("Nivel emisión : B");
		aux.add("Nivel emisión : C");
		aux.add("Nivel emisión : D");
		aux.add("Nivel emisión : E");
		this.nivelEmision=aux;
		return aux;
	}
	
	public ArrayList<String> getTipo() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("4x4");
		aux.add("Deportivo");
		aux.add("Familiar");
		aux.add("Mini");
		this.tipo=aux;
		return aux;
	}
	
	public ArrayList<String> getAtributosCategoria() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("Codigo.");
		aux.add("Descripción.");
		aux.add("Porcentaje de Recargo.");
		this.atributosCategoria=aux;
		return aux;
	}
	
	public ArrayList<String> getAtributosOficina() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("Codigo.");
		aux.add("Descripción.");
		aux.add("Localidad.");
		aux.add("Provincia.");
		aux.add("¿Es oficina de aeropuerto?.");
		this.atributosOficina=aux;
		return aux;
	}
	
	public ArrayList<String> getAtributosMoto() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("Matricula");
		aux.add("Marca");
		aux.add("Modelo");
		aux.add("Color");
		aux.add("Fecha alta");
		aux.add("Kilometros");
		aux.add("Categoria");
		aux.add("Oficina");
		aux.add("Autonomia");
		aux.add("Tiempo de Recarga");
		aux.add("Cilindrada");
		aux.add("Carnet Requerido");
		this.atributosMoto=aux;
		return aux;
	}

	public ArrayList<String> getAtributosCocheCombustion() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("Matricula");
		aux.add("Marca");
		aux.add("Modelo");
		aux.add("Color");
		aux.add("Fecha alta");
		aux.add("Kilometros");
		aux.add("Categoria");
		aux.add("Oficina");
		aux.add("Cosumo");
		aux.add("Potencia");
		aux.add("Nivel Emision");
		aux.add("Numero de plazas");
		aux.add("Tipo");
		this.atributosCocheCombustion=aux;
		return aux;
	}
	
	public ArrayList<String> getAtributosCocheElectrico() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("Matricula");
		aux.add("Marca");
		aux.add("Modelo");
		aux.add("Color");
		aux.add("Fecha alta");
		aux.add("Kilometros");
		aux.add("Categoria");
		aux.add("Oficina");
		aux.add("Autonomia");
		aux.add("Tiempo de recarga");
		aux.add("Numero de plazas");
		aux.add("Tipo");
		this.atributosCocheElectrico=aux;
		return aux;
	}
	
	public ArrayList<String> getAtributosFurgoneta() {
		ArrayList<String> aux=new ArrayList<String>();
		aux.add("Matricula");
		aux.add("Marca");
		aux.add("Modelo");
		aux.add("Color");
		aux.add("Fecha alta");
		aux.add("Kilometros");
		aux.add("Categoria");
		aux.add("Oficina");
		aux.add("Cosumo");
		aux.add("Potencia");
		aux.add("Nivel Emision");
		aux.add("Capacidad Carga");
		aux.add("Carnet Requerido");
		this.atributosFurgoneta=aux;
		return aux;
	}
	
	public String getNombre() {
		String aux=this.nombre;
		return aux;
	}

	public TreeMap<String, TipoCarnet> getTipoCarnet() {
		TreeMap<String, TipoCarnet> aux=this.tipoCarnet;
		return aux;
	}

	public void setTipoCarnet(TreeMap<String, TipoCarnet> tipoCarnet) {
		TreeMap<String, TipoCarnet> aux = tipoCarnet;
		this.tipoCarnet = aux;
	}

	public String getDesc() {
		String aux=this.desc;
		return aux;
	}

	public TreeMap<String, Vehiculo> getVehiculos() {
		TreeMap<String, Vehiculo> aux=this.vehiculos;
		return aux;
	}

	public TreeMap<String,Cliente> getClientes() {
		TreeMap<String,Cliente> aux=this.clientes;
		return aux;
	}

	public TreeMap<String,Empleado> getEmpleados() {
		TreeMap<String,Empleado> aux=this.empleados;
		return aux;
	}

	public TreeMap<String,Oficina> getOficinas() {
		TreeMap<String,Oficina> aux=this.oficinas;
		return aux;
	}

	public TreeMap<String,Categoria> getCategorias() {
		TreeMap<String,Categoria> aux=this.categorias;
		return aux;
	}

	public TreeMap<String,Alquiler> getAlquileres() {
		TreeMap<String,Alquiler> aux=this.alquileres;
		return aux;
	}

	public TreeMap<String,Devolucion> getDevoluciones() {
		TreeMap<String,Devolucion> aux=this.devoluciones;
		return aux;
	}

	public void setNombre(String nombre) {
		String aux = nombre;
		this.nombre = aux;
	}

	public void setDesc(String desc) {
		String aux = desc;
		this.desc = aux;
	}

	public void setVehiculos(TreeMap<String, Vehiculo> vehiculos) {
		TreeMap<String, Vehiculo> aux = vehiculos;
		this.vehiculos = aux;
	}

	public void setClientes(TreeMap<String,Cliente> clientes) {
		TreeMap<String,Cliente> aux = clientes;
		this.clientes = aux;
	}

	public void setEmpleados(TreeMap<String,Empleado> empleados) {
		TreeMap<String,Empleado> aux = empleados;
		this.empleados = aux;
	}

	public void setOficinas(TreeMap<String,Oficina> oficinas) {
		TreeMap<String,Oficina> aux = oficinas;
		this.oficinas= aux;
	}

	public void setCategorias(TreeMap<String,Categoria> categorias) {
		TreeMap<String,Categoria> aux = categorias;
		this.categorias = aux;
	}

	public void setAlquileres(TreeMap<String,Alquiler> alquileres) {
		TreeMap<String,Alquiler> aux = alquileres;
		this.alquileres = aux;
	}

	public void setDevoluciones(TreeMap<String,Devolucion> devoluciones) {
		TreeMap<String,Devolucion> aux = devoluciones;
		this.devoluciones = aux;
	}
	
	/////////////////////////////////
	//MODIFICACION DE LAS LISTAS DENTRO DE EMPRESA
	///////////////////////////////

	/**
	 * Añade un vehiculo al treemap
	 * @param a Vehiculo que se desea añadir
	 */
	public void añadeVehiculo (Vehiculo a) {
		vehiculos.put(a.getMatricula(),a);
	}
	
	/**
	 * Añade un cliente al treemap
	 * @param a Cliente que se desea añadir
	 */
	public void añadeCliente (Cliente a) {
		clientes.put(a.getDni(),a);
	}
	
	/**
	 * Añade un empleado al treemap
	 * @param a Empleado que se desea añadir
	 */
	public void añadeEmpleado (Empleado a) {
		empleados.put(a.getDni(),a);
	}

	/**
	 * Añade un oficina al treemap
	 * @param a Oficina que se desea añadir
	 */
	public void añadeOficina (Oficina a) {
		oficinas.put(a.getCod(),a);
	}
	
	/**
	 * Añade un categoria al treemap
	 * @param a Categoria que se desea añadir
	 */
	public void añadeCategoria (Categoria a) {
		categorias.put(a.getCodigo(),a);
	}
	
	/**
	 * Añade un categoria al treemap
	 * @param a Categoria que se desea añadir
	 */
	public void añadeTipoCarnet (TipoCarnet a) {
		tipoCarnet.put(a.getNombre(),a);
	}
	
	/**
	 * Añade un Alquiler al treemap
	 * @param a Alquiler que se desea añadir
	 */
	public void añadeAlquiler (Alquiler a) {
		alquileres.put(a.getId(),a);
	}

	/**
	 * Añade un Devolucion al treemap
	 * @param a Devolucion que se desea añadir
	 */
	public void añadeDevolucion (Devolucion a) {
		devoluciones.put(a.getId(),a);
	}
	
	/**
	 * Elimina el vehiculo pasado por parametro del TreeMap.
	 * @param a Vehiculo que se deseea eleminar.
	 */
	public void eliminaVehiculo (Vehiculo a) {
		vehiculos.remove(a.getMatricula());
	}
	
	/**
	 * Elimina el cliente pasado por parametro del TreeMap.
	 * @param a Cliente que se deseea eleminar.
	 */
	public void eliminaCliente (Cliente a) {
		clientes.remove(a.getDni());
	}
	
	/**
	 * Elimina el Empleado pasado por parametro del TreeMap.
	 * @param a Empleado que se deseea eleminar.
	 */
	public void eliminaEmpleado (Empleado a) {
		empleados.remove(a.getDni());
	}
	
	/**
	 * Elimina el Oficina pasado por parametro del TreeMap.
	 * @param a Oficina que se deseea eleminar.
	 */
	public void eliminaOficina (Oficina a) {
		oficinas.remove(a.getCod());
	}
	
	/**
	 * Elimina el Categoria pasado por parametro del TreeMap.
	 * @param a Categoria que se deseea eleminar.
	 */
	public void eliminaCategoria (Categoria a) {
		categorias.remove(a.getCodigo());
	}
	
	/**
	 * Elimina el Alquiler pasado por parametro del TreeMap.
	 * @param a Alquiler que se deseea eleminar.
	 */
	public void eliminaAlquiler (Alquiler a) {
		alquileres.remove(a.getId());
	}
	
	/**
	 * Elimina el Devolucion pasado por parametro del TreeMap.
	 * @param a Devolucion que se deseea eleminar.
	 */
	public void eliminaDevolucion (Devolucion a) {
		devoluciones.remove(a.getId());
	}

	@Override
	public String toString() {
		return "Empresa " + nombre + ", " + desc + " ofi : " + oficinas;
	}
	
	
}
	

