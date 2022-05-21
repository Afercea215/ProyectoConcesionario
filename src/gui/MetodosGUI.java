package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

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
	
	
	
	public static void desactPanel (JComponent panel)
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
	
	
	
	public static void activPanel (JComponent panel)
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

	
	public static void vaciarPanel (JComponent panel)
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
				((JComboBox) c).setSelectedIndex(0);
			}
//			if ((c instanceof JDateChooser)){
//				java.util.Date date = null;
//				try {
//					date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				((JDateChooser) c).setDate(date);
//			}
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
	
	
	public static boolean datosRellenos (JComponent componente, ArrayList<Component> excepciones, boolean relleno)
	{
		for (Component c : componente.getComponents())
		{
			for (Component l : excepciones) {
				if (l.equals(c)) {
					break;
				}else {
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
						relleno=datosRellenos((JScrollPane)c,excepciones,relleno);
					}
					if ((c instanceof JViewport)) {
						relleno=datosRellenos((JViewport)c, excepciones, relleno);
					}
					if ((c instanceof JPanel)){
						relleno=datosRellenos((JPanel)c, excepciones, relleno);
					}
				}
				
			}
		}
		return relleno;
	}
	
	
	
	public static boolean datosRellenos (JComponent componente, boolean relleno)
	{
		for (Component c : componente.getComponents())
		{
			if ((c instanceof JTextField)){
				if(((JTextField) c).getText().equals("")) {
					relleno =false;
					break;
				}
			}
			if ((c instanceof JTextArea)){
				if(((JTextArea) c).getText().equals("")) {
					relleno =false;
					break;
				}
			}
			if ((c instanceof JComboBox)){
				if(((JComboBox) c).getSelectedIndex()==-1) {
					relleno =false;
					break;
				}
			}
			if ((c instanceof JScrollPane)) {
				relleno=datosRellenos((JScrollPane)c, relleno);
			}
			if ((c instanceof JViewport)) {
				relleno=datosRellenos((JViewport)c, relleno);
			}
			if ((c instanceof JPanel)){
				relleno=datosRellenos((JPanel)c, relleno);
			}
			
		}
		return relleno;
	}
	
	public static Object cogerSeleccionado(JTable tabla, int numFila) {
		int fila = 0;
		Object elegido = null;
		
		fila=tabla.getSelectedRow();
		int filaModel = tabla.convertRowIndexToModel(fila);
		
		
		if(filaModel==-1) {
			JOptionPane.showMessageDialog(tabla, "Debe marcar una fila.","Error en la selección",JOptionPane.ERROR_MESSAGE);
		}else {
			elegido= tabla.getModel().getValueAt(filaModel,numFila);
		}
		
		return elegido;
		
	}
	
	public static void mensajeErrorBorrado (JDialog panel) {
		JOptionPane.showMessageDialog(panel,
				"No se puede borrar el elemento actual por que está en uso.","Error",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	
	
}