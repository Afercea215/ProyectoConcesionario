package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;

import accesoADatos.AccesoADatos;
import entidades.Oficina;

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
	
	public static void desactPanel (JPanel panel)
	{
		for (Component c : panel.getComponents())
		{
			if (!(c instanceof JLabel)){
				c.setEnabled(false);
			}
			if ((c instanceof JScrollPane)){
				desactPanel((JScrollPane)c);
			}
			if ((c instanceof JPanel)){
				desactPanel((JPanel)c);
			}	
			if ((c instanceof JViewport)) {
				desactPanel((JViewport)c);
			}
		}
	}
	
	public static void desactPanel (JPanel panel, ArrayList<Component> excepciones)
	{
		for (Component c : panel.getComponents())
		{
			for (Component l : excepciones) {
				if (l.getName().equals(c.getName())) {
					break;
				}else {
					if (!(c instanceof JLabel)){
						c.setEnabled(false);
					}
					if ((c instanceof JScrollPane)){
						desactPanel((JScrollPane)c);
					}
					if ((c instanceof JPanel)){
						desactPanel((JPanel)c);
					}	
					if ((c instanceof JViewport)) {
						desactPanel((JViewport)c);
					}
				}
			}
			
		}
	}
	
	
	public static void desactPanel (JScrollPane panel)
	{
		for (Component c : panel.getComponents())
		{
			if (!(c instanceof JLabel)){
				c.setEnabled(false);
			}
			if ((c instanceof JScrollPane)){
				desactPanel((JScrollPane)c);
			}
			if ((c instanceof JPanel)){
				desactPanel((JPanel)c);
			}	
			if ((c instanceof JViewport)) {
				desactPanel((JViewport)c);
			}
		}
	}
	
	public static void desactPanel (JViewport panel)
	{
		for (Component c : panel.getComponents())
		{
			if (!(c instanceof JLabel)){
				c.setEnabled(false);
			}
			if ((c instanceof JScrollPane)){
				desactPanel((JScrollPane)c);
			}
			if ((c instanceof JPanel)){
				desactPanel((JPanel)c);
			}			
			if ((c instanceof JViewport)) {
				desactPanel((JViewport)c);
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
			if ((c instanceof JScrollPane)){
				activPanel((JScrollPane)c);
			}
			if ((c instanceof JPanel)){
				activPanel((JPanel)c);
			}			
		}
	}
	
	public static void activPanel (JPanel panel, ArrayList<Component> excepciones)
	{
		for (Component c : panel.getComponents())
		{
			for (Component l : excepciones) {
				if (l.getName().equals(c.getName())) {
					break;
				}else {
					if (!(c instanceof JLabel)){
						c.setEnabled(true);
					}
					if ((c instanceof JScrollPane)){
						desactPanel((JScrollPane)c);
					}
					if ((c instanceof JPanel)){
						desactPanel((JPanel)c);
					}	
					if ((c instanceof JViewport)) {
						desactPanel((JViewport)c);
					}
				}
			}
			
		}
	}
	
	public static void activPanel (JScrollPane panel)
	{
		for (Component c : panel.getComponents())
		{
			if (!(c instanceof JLabel)){
				c.setEnabled(true);
			}
			if ((c instanceof JScrollPane)){
				activPanel((JScrollPane)c);
			}
			if ((c instanceof JPanel)){
				activPanel((JPanel)c);
			}	
			if ((c instanceof JViewport)) {
				activPanel((JViewport)c);
			}
		}
	}
	
	public static void activPanel (JViewport panel)
	{
		for (Component c : panel.getComponents())
		{
			if (!(c instanceof JLabel)){
				c.setEnabled(true);
			}
			if ((c instanceof JScrollPane)){
				activPanel((JScrollPane)c);
			}
			if ((c instanceof JPanel)){
				activPanel((JPanel)c);
			}	
			if ((c instanceof JViewport)) {
				activPanel((JViewport)c);
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
			if ((c instanceof JTextArea)){
				((JTextArea) c).setText("");
			}
			if ((c instanceof JCheckBox)){
				((JCheckBox) c).setSelected(false);
			}
			if ((c instanceof JComboBox)){
				((JComboBox) c).setSelectedIndex(-1);;
			}
			if ((c instanceof JScrollPane)) {
				vaciarPanel((JScrollPane)c);
			}
			if ((c instanceof JPanel)){
				vaciarPanel((JPanel)c);
			}			
		}
	}
	
	public static void vaciarPanel (JScrollPane panel)
	{
		for (Component c : panel.getComponents())
		{
			if ((c instanceof JTextField)){
				((JTextField) c).setText("");
			}
			if ((c instanceof JTextArea)){
				((JTextArea) c).setText("");
			}
			if ((c instanceof JCheckBox)){
				((JCheckBox) c).setSelected(false);
			}
			if ((c instanceof JComboBox)){
				((JComboBox) c).setSelectedIndex(-1);;
			}
			if ((c instanceof JScrollPane)) {
				vaciarPanel((JScrollPane)c);
			}
			if ((c instanceof JViewport)) {
				vaciarPanel((JViewport)c);
			}
			if ((c instanceof JPanel)){
				vaciarPanel((JPanel)c);
			}			
		}
	}
	
	public static void vaciarPanel (JViewport panel)
	{
		for (Component c : panel.getComponents())
		{
			if ((c instanceof JTextField)){
				((JTextField) c).setText("");
			}
			if ((c instanceof JTextArea)){
				((JTextArea) c).setText("");
			}
			if ((c instanceof JCheckBox)){
				((JCheckBox) c).setSelected(false);
			}
			if ((c instanceof JComboBox)){
				((JComboBox) c).setSelectedIndex(-1);;
			}
			if ((c instanceof JScrollPane)) {
				vaciarPanel((JScrollPane)c);
			}
			if ((c instanceof JViewport)) {
				vaciarPanel((JViewport)c);
			}
			if ((c instanceof JPanel)){
				vaciarPanel((JPanel)c);
			}			
		}
	}
	
	public static boolean datosRellenos (JPanel panel)
	{
		boolean relleno = true;
		for (Component c : panel.getComponents())
		{
			if ((c instanceof JTextField)){
				if(((JTextField) c).getText().equals("")) {
					relleno =false;
				}
			}
			if ((c instanceof JTextArea)){
				if(((JTextArea) c).getText().equals("")) {
					relleno =false;
				}
			}
			if ((c instanceof JComboBox)){
				if(((JComboBox) c).getSelectedIndex()==-1) {
					relleno =false;
				}
			}
			if ((c instanceof JScrollPane)) {
				relleno=datosRellenos((JScrollPane)c);
			}
			if ((c instanceof JViewport)) {
				relleno=datosRellenos((JViewport)c);
			}
			if ((c instanceof JPanel)){
				relleno=datosRellenos((JPanel)c);
			}			
		}
		return relleno;
	}
	public static boolean datosRellenos (JScrollPane panel)
	{
		boolean relleno = true;
		for (Component c : panel.getComponents())
		{
			if ((c instanceof JTextField)){
				if(((JTextField) c).getText().equals("")) {
					relleno =false;
				}
			}
			if ((c instanceof JTextArea)){
				if(((JTextArea) c).getText().equals("")) {
					relleno =false;
				}
			}
			if ((c instanceof JComboBox)){
				if(((JComboBox) c).getSelectedIndex()==-1) {
					relleno =false;
				}
			}
			if ((c instanceof JScrollPane)) {
				relleno=datosRellenos((JScrollPane)c);
			}
			if ((c instanceof JViewport)) {
				relleno=datosRellenos((JViewport)c);
			}
			if ((c instanceof JPanel)){
				relleno=datosRellenos((JPanel)c);
			}			
		}
		return relleno;
	}
	public static boolean datosRellenos (JViewport panel)
	{
		boolean relleno = true;
		for (Component c : panel.getComponents())
		{
			if ((c instanceof JTextField)){
				if(((JTextField) c).getText().equals("")) {
					relleno =false;
				}
			}
			if ((c instanceof JTextArea)){
				if(((JTextArea) c).getText().equals("")) {
					relleno =false;
				}
			}
			if ((c instanceof JComboBox)){
				if(((JComboBox) c).getSelectedIndex()==-1) {
					relleno =false;
				}
			}
			if ((c instanceof JScrollPane)) {
				relleno=datosRellenos((JScrollPane)c);
			}
			if ((c instanceof JViewport)) {
				relleno=datosRellenos((JViewport)c);
			}
			if ((c instanceof JPanel)){
				relleno=datosRellenos((JPanel)c);
			}			
		}
		return relleno;
	}
	
	public static Component buscarCompPorNombre (JPanel panel, String nombre) {
		Component comp = null;
		for (Component c : panel.getComponents())
		{
			System.out.println(c.getName());
			if ((c.getName()+"").equals(nombre)) {
				comp =  c;
				break;
			}
			if ((c instanceof JScrollPane)){
				JScrollPane scroll = (JScrollPane) c;
				comp=buscarCompPorNombre(scroll,nombre);
			}	
			if ((c instanceof JPanel)){
				comp=buscarCompPorNombre(panel,nombre);
			}	
			if ((c instanceof JViewport)) {
				comp=buscarCompPorNombre((JViewport)c,nombre);
			}
		}
		return comp;
	}
	
	public static Component buscarCompPorNombre (JScrollPane panel, String nombre) {
		Component comp = null;
		for (Component c : panel.getComponents())
		{
			if ((c.getName()+"").equals(nombre)) {
				comp =  c;
				break;
			}
			if ((c instanceof JScrollPane)){
				JScrollPane scroll = (JScrollPane) c;
				comp=buscarCompPorNombre(scroll,nombre);
			}	
			if ((c instanceof JPanel)){
				comp=buscarCompPorNombre(panel,nombre);
			}
			if ((c instanceof JViewport)) {
				comp=buscarCompPorNombre((JViewport)c,nombre);
			}
		}
		return comp;
	}
	
	public static Component buscarCompPorNombre (JViewport panel, String nombre) {
		Component comp = null;
		for (Component c : panel.getComponents())
		{
			if ((c.getName()+"").equals(nombre)) {
				comp =  c;
				break;
			}
			if ((c instanceof JScrollPane)){
				JScrollPane scroll = (JScrollPane) c;
				comp=buscarCompPorNombre(scroll,nombre);
			}	
			if ((c instanceof JPanel)){
				comp=buscarCompPorNombre(panel,nombre);
			}
			if ((c instanceof JViewport)) {
				comp=buscarCompPorNombre((JViewport)c,nombre);
			}
		}
		return comp;
	}
	
	public static Object cogerSeleccionado(JTable tabla, int numFila) {
		int fila = 0;
		Object elegido = null;
		
		fila=tabla.getSelectedRow();
		
		if(fila==-1) {
			JOptionPane.showMessageDialog(tabla, "Debe marcar una fila.","Error en la selección",JOptionPane.ERROR_MESSAGE);
		}else {
			elegido= tabla.getModel().getValueAt(fila,numFila);
			
		}
		
		return elegido;
	}
	
}
