package entidades;

public class NivelEmision {

	private String letra;
	private String descrip;
	public String getLetra() {
		return letra;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public NivelEmision(String letra, String descrip) {
		super();
		this.letra = letra;
		this.descrip = descrip;
	}
	@Override
	public String toString() {
		return letra + ", " + descrip;
	}

	
	
	
}
