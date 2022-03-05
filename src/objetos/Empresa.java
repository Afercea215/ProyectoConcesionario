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
	public void leeDatosEmpresa() {
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
				o.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

	
	///////////////////////////////////
	//GETTERS Y SETTERS
	////////////////////
	
	
	
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
	 * A�ade un vehiculo al treemap
	 * @param a Vehiculo que se desea a�adir
	 */
	public void a�adeVehiculo (Vehiculo a) {
		vehiculos.put(a.getMatricula(),a);
	}
	
	/**
	 * A�ade un cliente al treemap
	 * @param a Cliente que se desea a�adir
	 */
	public void a�adeCliente (Cliente a) {
		clientes.put(a.getDni(),a);
	}
	
	/**
	 * A�ade un empleado al treemap
	 * @param a Empleado que se desea a�adir
	 */
	public void a�adeEmpleado (Empleado a) {
		empleados.put(a.getDni(),a);
	}

	/**
	 * A�ade un oficina al treemap
	 * @param a Oficina que se desea a�adir
	 */
	public void a�adeOficina (Oficina a) {
		oficinas.put(a.getCod(),a);
	}
	
	/**
	 * A�ade un categoria al treemap
	 * @param a Categoria que se desea a�adir
	 */
	public void a�adeCategoria (Categoria a) {
		categorias.put(a.getCodigo(),a);
	}
	
	/**
	 * A�ade un categoria al treemap
	 * @param a Categoria que se desea a�adir
	 */
	public void a�adeTipoCarnet (TipoCarnet a) {
		tipoCarnet.put(a.getNombre(),a);
	}
	
	/**
	 * A�ade un Alquiler al treemap
	 * @param a Alquiler que se desea a�adir
	 */
	public void a�adeAlquiler (Alquiler a) {
		alquileres.put(a.getId(),a);
	}

	/**
	 * A�ade un Devolucion al treemap
	 * @param a Devolucion que se desea a�adir
	 */
	public void a�adeDevolucion (Devolucion a) {
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
	

