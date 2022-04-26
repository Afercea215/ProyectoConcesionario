package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;

import acessoADatos.AccesoADatos;

public class MetodosGUI {

	public static void centrarJFrame (JFrame j) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		j.setLocation(dim.width/2-j.getSize().width/2, dim.height/2-j.getSize().height/2);
	}
	
	public static DefaultComboBoxModel defaultCBModelProv() {
		DefaultComboBoxModel modelProv = new DefaultComboBoxModel(AccesoADatos.arrayListNombreProv().toArray());
		return modelProv;
	}
	
	public static DefaultComboBoxModel defaultCBModelLoc(String prov) {
		DefaultComboBoxModel modelLoc = new DefaultComboBoxModel(AccesoADatos.arrayListNombreLocDeProv(prov).toArray());
		return modelLoc;
	}
	
	public static void descactPanel (JPanel panel)
	{
		for (Component c : panel.getComponents())
		{
			if (!(c instanceof JLabel)){
				c.setEnabled(false);
			}
			if ((c instanceof JPanel)){
				descactPanel((JPanel)c);
			}			
		}
	}
	
	
	public static void activPanel (JPanel panel)
	{
		for (Component c : panel.getComponents())
		{
			if (!(c instanceof JLabel)){
				c.setEnabled(true);
			}
			if ((c instanceof JPanel)){
				activPanel((JPanel)c);
			}			
		}
	}
	
	public static void vaciarPanel (JPanel panel)
	{
		for (Component c : panel.getComponents())
		{
			if ((c instanceof JTextField)){
				((JTextField) c).setText("");
			}
			if ((c instanceof JCheckBox)){
				((JCheckBox) c).setSelected(false);
			}
			if ((c instanceof JComboBox)){
				((JComboBox) c).setSelectedIndex(-1);;
			}
			if ((c instanceof JPanel)){
				activPanel((JPanel)c);
			}			
		}
	}
	
}
