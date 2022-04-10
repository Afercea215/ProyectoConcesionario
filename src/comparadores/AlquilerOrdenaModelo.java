package comparadores;

import java.util.Comparator;

import entidades.*;

public class AlquilerOrdenaModelo implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		//extrae el modelo y lo compara
		return s1.substring(26 + s1.substring(26).indexOf(","), 26 + s1.substring(26).indexOf(",")).compareToIgnoreCase(s2.substring(26, s2.substring(26).indexOf(",")-1));
	}

	
	
	
}
