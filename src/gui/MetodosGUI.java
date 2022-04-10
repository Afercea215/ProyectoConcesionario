package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class MetodosGUI {

	public static void centrarJFrame (JFrame j) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		j.setLocation(dim.width/2-j.getSize().width/2, dim.height/2-j.getSize().height/2);
	}
	
}
