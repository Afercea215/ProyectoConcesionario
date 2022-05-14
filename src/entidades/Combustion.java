// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package entidades;

import java.util.Calendar;
import java.util.GregorianCalendar;

/************************************************************/
/**
 * 
 */
public abstract class Combustion extends Vehiculo {
	private static final long serialVersionUID = 1234233464567L;
	private int consumo;
	private int potencia;
	private String nivel_emison;
	
	private int porcentajeSubida = 0;

	

	/**
	 * Construcor completo de vehiculo de tipo combustion
	 * @param matricula String matriculo vehiculo.
	 * @param marca String marca veh�culo.
	 * @param modelo String modelo veh�culo.
	 * @param color String color veh�culo.
	 * @param fechaAlta Calendar fecha de alta del veh�culo en el concesionario.
	 * @param kms Int kilometros que lleva recorrido el veh�culo.
	 * @param categoria Categor�a categoria del veh�culo.
	 * @param oficina Oficina donde se encuentra el veh�culo.
	 * @param alquilado Boolean si est� o no alquilado.
	 * @param consumo Double del consumo del vehicculo por km.
	 * @param potencia Int potencia del veh�culo.
	 * @param nivel_emison String nivel de emision.
	 */
	public Combustion(String matricula, String marca, String modelo, Color color, GregorianCalendar fechaAlta, int kms,
			Categoria categoria, Oficina oficina, boolean alquilado, int consumo, int potencia,
			String nivel_emison) {
		super(matricula, marca, modelo, color, fechaAlta, kms, categoria, oficina, alquilado);
		this.consumo = consumo;
		this.potencia = potencia;
		this.nivel_emison = nivel_emison;
	}


	public int getConsumo() {
		int aux=this.consumo;
		return aux;
	}


	public int getPotencia() {
		int aux=this.potencia;
		return aux;
	}


	public String getNivel_emison() {
		String aux=this.nivel_emison;
		return aux;
	}


	public void setConsumo(int consumo) {
		int aux = consumo;
		this.consumo = aux;	
	}


	public void setPotencia(int potencia) {
		int aux = potencia;
		this.potencia = aux;	
	}


	public void setNivel_emison(String nivel_emison) {
		String aux = nivel_emison;
		this.nivel_emison = aux;	
	}

	public int getPorcentajeSubida() {
		int aux=this.porcentajeSubida;
		return aux;
	}

	
	public abstract Double calculaAlquilerPrevisto(Alquiler a);
	public abstract Double calculaAlquilerReal(Alquiler a, Devolucion b);
	
	
	@Override
	public String toString() {
		return super.toString()+"Consumo : " + consumo +", Potencia : " + potencia+", ";
	}
}
