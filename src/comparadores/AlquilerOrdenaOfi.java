package comparadores;

import java.util.Comparator;

import objetos.*;

public class AlquilerOrdenaOfi implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		//extrae la oficina y la compara
		return s1.substring(s1.indexOf(", Oficina :"), s1.indexOf(", Oficina :")+4).compareToIgnoreCase(s2.substring(s2.indexOf(", Oficina :"), s2.indexOf(", Oficina :")+4));
	}

	
	
	
}
