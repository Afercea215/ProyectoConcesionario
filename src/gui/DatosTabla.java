package gui;

import java.util.ArrayList;

public class DatosTabla {
	
	private ArrayList<String> nombreColumnas;
	private Object[][] datosTabla;
	private ArrayList<Integer> anchuraColumnas;
	
	public ArrayList<String> getNombreColumnas() {
		return nombreColumnas;
	}

	public Object[][] getDatosTabla() {
		return datosTabla;
	}

	public ArrayList<Integer> getAnchuraColumnas() {
		return anchuraColumnas;
	}

	public void setNombreColumnas(ArrayList<String> nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public void setDatosTabla(Object[][] datosTabla) {
		this.datosTabla = datosTabla;
	}

	public void setAnchuraColumnas(ArrayList<Integer> anchuraColumnas) {
		this.anchuraColumnas = anchuraColumnas;
	}

	public DatosTabla(ArrayList<String> nombreColumnas, Object[][] datosTabla, ArrayList<Integer> anchuraColumnas) {
		super();
		this.nombreColumnas = nombreColumnas;
		this.datosTabla = datosTabla;
		this.anchuraColumnas = anchuraColumnas;
	}
	
	

}
