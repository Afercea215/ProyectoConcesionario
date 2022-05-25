package excepciones;

import javax.swing.JOptionPane;

public class FormuIncompleto extends Exception{

	private static final long serialVersionUID=234l;
		
	public FormuIncompleto() {
		JOptionPane.showMessageDialog(null, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);		
	}
				

}