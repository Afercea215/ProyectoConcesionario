package entidades;

public class Color {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Color(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
