// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package objetos;

import java.util.Calendar;
import java.util.GregorianCalendar;

/************************************************************/
/**
 * 
 */
public abstract class Electrico extends Vehiculo{
	private int autonomia;
	private int tiempoRecarga;

	private int porcentajeSubida = 15;
	
	/**
	 * Constructor de un veh�culo electrico completo, con todas las propiedades.
	 * @param matricula String matriculo vehiculo.
	 * @param marca String marca veh�culo.
	 * @param modelo String modelo veh�culo.
	 * @param color String color veh�culo.
	 * @param fechaAlta Calendar fecha de alta del veh�culo en el concesionario.
	 * @param kms Int kilometros que lleva recorrido el veh�culo.
	 * @param categoria Categor�a categoria del veh�culo.
	 * @param oficina Oficina donde se encuentra el veh�culo.
	 * @param alquilado Boolean si est� o no alquilado.
	 * @param autonimia Double con la autonomia del Vehiculo en horas (Ej : 1.5 horas)
	 * @param tiempoRecarga Double con el tiempo de recarga del Vehiculo en horas (Ej : 1.5 horas)
	 */
	public Electrico(String matricula, String marca, String modelo, String color, GregorianCalendar fechaAlta, int kms,
			Categoria categoria, Oficina oficina, boolean alquilado, int autonomia, int tiempoRecarga) {
		super(matricula, marca, modelo, color, fechaAlta, kms, categoria, oficina, alquilado);
		this.autonomia = autonomia;
		this.tiempoRecarga = tiempoRecarga;
	}

	public int getAutonimia() {
		int aux=this.autonomia;
		return aux;
	}

	public int getTiempoRecarga() {
		int aux=this.tiempoRecarga;
		return aux;
	}
	public void setAutonomia(int autonomia) {
		int aux = autonomia;
		this.autonomia = aux;	
	}
	public void setTiempoRecarga(int tiempoRecarga) {
		int aux = tiempoRecarga;
		this.tiempoRecarga = aux;	
	}

	public int getPorcentajeSubida() {
		int aux=this.porcentajeSubida;
		return aux;
	}

	@Override
	public String toString() {
		return super.toString()+"Autonom�a : " + autonomia +", Tiempo de recarga : " + tiempoRecarga+", ";
	}

	public abstract Double calculaAlquilerPrevisto(Alquiler a);
	public abstract Double calculaAlquilerReal(Alquiler a, Devolucion b);
}
