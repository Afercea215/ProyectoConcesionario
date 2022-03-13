// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package objetos;
import java.io.Serializable;
import java.util.*;

import miLibreria.objetos.Persona;
/************************************************************/
/**
 * 
 */
public class Alquiler implements Comparable<Alquiler>, Serializable{
	private static final long serialVersionUID = 123456234324167L;
	private String id;
	private Vehiculo vehiculo;
	private Empleado empleado;
	private Cliente cliente;
	private GregorianCalendar fechaIniAlquiler;
	private Oficina oficina;
	private GregorianCalendar fechaFinPrevista;
	
	/**
	 * Constructor de alquiler completo 
	 * @param id int id de alquiler.
	 * @param vehiculo objeto Vehiculo, que es alquilado.
	 * @param empleado objeto Empleado, que administra el alquiler.
	 * @param cliente objeto Cliente, que alguila el vehiculo.
	 * @param fechaIniAlquiler objeto GregorianCalendar, que es la fecha de inicio del alquiler.
	 * @param oficina objeto Oficina, en el que se realiza el alquiler.
	 * @param fechaFinPrevista objeto GregorianCalendar, fecha prevista donde se termine el alquiler.
	 */
	public Alquiler(int id,Vehiculo vehiculo, Empleado empleado, Cliente cliente, GregorianCalendar fechaIniAlquiler, Oficina oficina,
			GregorianCalendar fechaFinPrevista) 
	{
		super();
		this.id = id+"";
		this.vehiculo = vehiculo;
		this.empleado = empleado;
		this.cliente = cliente;
		this.fechaIniAlquiler = fechaIniAlquiler;
		this.oficina = oficina;
		this.fechaFinPrevista = fechaFinPrevista;
	}

	
	public String getId() {
		String aux=this.id;
		return aux;
	}

	public void setId(String id) {
		String aux = id;
		this.id= aux;
	}

	public Vehiculo getVehiculo() {
		Vehiculo aux=this.vehiculo;
		return aux;
	}

	public Empleado getEmpleado() {
		Empleado aux=this.empleado;
		return aux;
	}

	public Cliente getCliente() {
		Cliente aux=this.cliente;
		return aux;
	}

	public GregorianCalendar getFechaIniAlquiler() {
		GregorianCalendar aux=this.fechaIniAlquiler;
		return aux;
	}

	public Oficina getOficina() {
		Oficina aux=this.oficina;
		return aux;
	}

	public GregorianCalendar getFechaFinPrevista() {
		GregorianCalendar aux=this.fechaFinPrevista;
		return aux;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		Vehiculo aux = vehiculo;
		this.vehiculo = aux;
	}

	public void setEmpleado(Empleado empleado) {
		Empleado aux = empleado;
		this.empleado= aux;
	}

	public void setCliente(Cliente cliente) {
		Cliente aux = cliente;
		this.cliente = aux;
	}

	public void setFechaIniAlquiler(GregorianCalendar fechaIniAlquiler) {
		GregorianCalendar aux = fechaIniAlquiler;
		this.fechaIniAlquiler = aux;
	}

	public void setOficina(Oficina oficina) {
		Oficina aux = oficina;
		this.oficina = aux;
	}

	public void setFechaFinPrevista(GregorianCalendar fechaFinPrevista) {
		GregorianCalendar aux = fechaFinPrevista;
		this.fechaFinPrevista = aux;
	}
	
	@Override
	public int compareTo(Alquiler a) {
		int devolver;
		//si su id es igual devuelvo 0, si no ordeno por fecha
		if (this.getId()==a.getId()) {
			devolver = 0;
		}else devolver = this.getFechaIniAlquiler().compareTo(a.fechaIniAlquiler);
		
		return devolver;	
	}
	
	@Override
	public boolean equals(Object a) {
		boolean igual = false;
		Alquiler b= (Alquiler) a;
		
		if (b.compareTo(this)==0) igual = true;
		
		return igual;
    }

	@Override
	public String toString() {
		int mes = fechaIniAlquiler.get(Calendar.MONTH);
		int dia = fechaIniAlquiler.get(Calendar.DAY_OF_MONTH);
		int a�o = fechaIniAlquiler.get(Calendar.YEAR);
		
		return id +", Vehiculo : " + vehiculo.getMatricula()+", "+vehiculo.getMarca() +", "+vehiculo.getModelo()+", Alquilador por : "+ cliente.nombreCompleto() + ", Fecha alquiler : " + dia+"/"+mes+"/"+a�o+", Oficina :" + oficina.getDescripcion()+", "+oficina.getLocalidad() +", Precio previsto : "+vehiculo.calculaAlquilerPrevisto(this);
	}

}
