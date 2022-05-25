package metodos;

import principal.Principal;

import java.util.*;

import entidades.Alquiler;
import entidades.Cliente;
import entidades.CocheCombustion;
import entidades.CocheElectrico;
import entidades.Combustion;
import entidades.Electrico;
import entidades.Furgoneta;
import entidades.Moto;
import entidades.Oficina;
import entidades.Vehiculo;
import entidades.*;

public class Especificos {
	
	public static int difDiasEntreFechas (GregorianCalendar a, GregorianCalendar b) {
		//consigo la diferencia de tiempo en milisegundos.
		long tiempSeg =  (b.getTimeInMillis() - a.getTimeInMillis())/1000;
		
		int tiempDias = (int) (((tiempSeg/60) /60) /24);
		
		//indico la unidad de tiempo que voy a usar.
//		TimeUnit unidad = TimeUnit.DAYS;
//		
//		//convierto los milisegundos del tiempo transcurrido en dias.
//		int dias = Math.toIntExact(unidad.convert(tiempTranscurrido, TimeUnit.MILLISECONDS)) ;
		
		return tiempDias;
	}
	
	public static Double calculaAlquiler (GregorianCalendar f1, GregorianCalendar f2, Vehiculo vehiculo) {
		Double precio=0.00;
		int difDias = difDiasEntreFechas(f1, f2);
		
		if (vehiculo instanceof Moto) {
			Double precioDiario = Moto.precioDiario;
			int porcentajeSubida = Electrico.porcentajeSubida;
			int porcentajeRecargo = (int) vehiculo.getCategoria().getPorcentajeRecargo();
			precio= (difDias*precioDiario)+((difDias*precioDiario)*(porcentajeSubida/100)) + ((difDias*precioDiario)*(porcentajeRecargo/100));
		}
		
		if (vehiculo instanceof Furgoneta) {
			Double precioDiario = Furgoneta.getPrecioDiario();
			int porcentajeSubida = Combustion.porcentajeSubida;
			int porcentajeRecargo = (int) vehiculo.getCategoria().getPorcentajeRecargo();
			precio= (difDias*precioDiario)+((difDias*precioDiario)*(porcentajeSubida/100)) + ((difDias*precioDiario)*(porcentajeRecargo/100));
		}
		
		if (vehiculo instanceof CocheCombustion) {
			Double precioDiario = CocheCombustion.precioDiario;
			int porcentajeSubida = Combustion.porcentajeSubida;
			int porcentajeRecargo = (int) vehiculo.getCategoria().getPorcentajeRecargo();
			precio= (difDias*precioDiario)+((difDias*precioDiario)*(porcentajeSubida/100)) + ((difDias*precioDiario)*(porcentajeRecargo/100));
		}
		
		if (vehiculo instanceof CocheElectrico) {
			Double precioDiario = CocheElectrico.precioDiario;
			int porcentajeSubida = Electrico.porcentajeSubida;
			int porcentajeRecargo = (int) vehiculo.getCategoria().getPorcentajeRecargo();
			precio= (difDias*precioDiario)+((difDias*precioDiario)*(porcentajeSubida/100)) + ((difDias*precioDiario)*(porcentajeRecargo/100));
		}
		
		return precio;
		}
	
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
	
	
}
