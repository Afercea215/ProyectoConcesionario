package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Devolucion implements Comparable<Devolucion>, Serializable{
	private static final long serialVersionUID = 12345613234617L;
	private String id;
	private Oficina oficina;
	private Alquiler alquiler;
	private Vehiculo vehiculo;
	private int kmsRecorridos;
	private GregorianCalendar FechaDevolucionReal;
	private Empleado empleado;
	private Cliente cliente;
	private Double precio;
	

	public Devolucion(String id, Oficina oficina, Alquiler alquiler, Vehiculo vehiculo, int kmsRecorridos,
			GregorianCalendar fechaDevolucionReal, Empleado empleado, Cliente cliente, Double precio) {
		super();
		this.id = id;
		this.oficina = oficina;
		this.alquiler = alquiler;
		this.vehiculo = vehiculo;
		this.kmsRecorridos = kmsRecorridos;
		FechaDevolucionReal = fechaDevolucionReal;
		this.empleado = empleado;
		this.cliente = cliente;
		this.precio = precio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getId() {
		String aux=this.id;
		return aux;
	}

	public void setId(String id) {
		String aux = id;
		this.id= aux;
	}
	
	public Alquiler getAlquiler() {
		Alquiler aux=this.alquiler;
		return aux;
	}

	public void setAlquiler(Alquiler alquiler) {
		Alquiler aux = alquiler;
		this.alquiler = aux;
	}

	public Oficina getOficina() {
		Oficina aux=this.oficina;
		return aux;
	}

	public Vehiculo getVehiculo() {
		Vehiculo aux=this.vehiculo;
		return aux;
	}

	public int getKmsRecorridos() {
		int aux=this.kmsRecorridos;
		return aux;
	}

	public GregorianCalendar getFechaDevolucionReal() {
		GregorianCalendar aux=this.FechaDevolucionReal;
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

	public void setOficina(Oficina oficina) {
		Oficina aux = oficina;
		this.oficina = aux;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		Vehiculo aux = vehiculo;
		this.vehiculo = aux;
	}

	public void setKmsRecorridos(int kmsRecorridos) {
		int aux = kmsRecorridos;
		this.kmsRecorridos = aux;
	}

	public void setFechaDevolucionReal(GregorianCalendar fechaDevolucionReal) {
		GregorianCalendar aux = fechaDevolucionReal;
		this.FechaDevolucionReal = aux;
	}

	public void setEmpleado(Empleado empleado) {
		Empleado aux = empleado;
		this.empleado = aux;
	}

	public void setCliente(Cliente cliente) {
		Cliente aux = cliente;
		this.cliente = aux;
	}
	
	@Override
	public int compareTo(Devolucion a) {
		int devolver;
		//si su id es igual devuelvo 0, si no ordeno por fecha
		if (this.getId()==a.getId()) {
			devolver = 0;
		}else devolver = this.getFechaDevolucionReal().compareTo(a.getFechaDevolucionReal());
		
		return devolver;	
	}
	
	@Override
	public boolean equals(Object a) {
		boolean igual = false;
		Devolucion b= (Devolucion) a;
		
		if (b.compareTo(this)==0) igual = true;
		
		return igual;
    }
	
	@Override
	public String toString() {
		return id + ", Vehiculo : " + vehiculo +", Cliente : "+ cliente + ", Oficina :" + oficina +", Precio alquiler : "+vehiculo.calculaAlquilerReal(this.alquiler, this);
	}
		
	
}
