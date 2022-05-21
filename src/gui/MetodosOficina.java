package gui;

import java.awt.Component;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioOficina;
import entidades.Cliente;
import entidades.Oficina;
import principal.Principal;

public class MetodosOficina {
	
	
	public static JComboBox<Oficina> comboBoxOficinas (){
		JComboBox<Oficina> cb = new JComboBox<Oficina>();
		
		for (Oficina a : RepositorioOficina.arrayListOficinas() ){
			cb.addItem(a);
		}
		return cb;
	}
	
	public static ArrayList<String> nombreColumnas() {
		ArrayList<String> nombreColumnas = new ArrayList<String>();
		nombreColumnas.add("COD");
		nombreColumnas.add("Descripicion");
		nombreColumnas.add("Provincia");
	    nombreColumnas.add("Localidad");
	    nombreColumnas.add("Oficina Aeropuerto");
	    nombreColumnas.add("Observaciones");
	    nombreColumnas.add("Objeto");
		
		return nombreColumnas;
	}
	
	public static ArrayList<Integer> anchoColumnas() {
		ArrayList<Integer> anchoColumnas = new ArrayList<Integer>();
		anchoColumnas.add(55);
		anchoColumnas.add(150);
		anchoColumnas.add(55);
		anchoColumnas.add(55);
		anchoColumnas.add(55);
		anchoColumnas.add(200);
		anchoColumnas.add(0);
		
		return anchoColumnas;
	}
	
	public static DatosTabla creaDatosTabla() {
		return (new DatosTabla(nombreColumnas(), listaOficinasTabla(), anchoColumnas()));
	}
	
	public static Object[][] listaOficinasTabla(){
		ArrayList<Oficina> lista = RepositorioOficina.arrayListOficinas();
		int numColumnas = 7;
		int numFilas = lista.size();
		Object[][] listaTabla = new Object[numFilas][numColumnas];		
		
		for (int i=0;i<numFilas;i++) {
			String aeropuerto ="";
			if (lista.get(i).isOfiAeropuerto()) {
				aeropuerto = "Si";
			} else {
				aeropuerto="No";
			}
			listaTabla[i][0]=lista.get(i).getCod();
			listaTabla[i][1]=lista.get(i).getDescripcion();
			listaTabla[i][2]=lista.get(i).getProvincia();
			listaTabla[i][3]=lista.get(i).getLocalidad();
			listaTabla[i][4]=aeropuerto;
			listaTabla[i][5]=lista.get(i).getObservaciones();
			listaTabla[i][6]=lista.get(i);
		}
		
		return listaTabla;
	}
	
	/**
	 * Graba la oficina en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaOficina (JDialog jframe) {
		
		FormuOficinas formu = (FormuOficinas) jframe;
		JPanel panel = formu.getContentPanel();
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel,formu.getLista(),true)) {
			
			Oficina o = creaOfiPanel(formu);
			
			//si la oficina ya existe la borro
			if(RepositorioOficina.buscaOficina(o.getCod()) !=null) {
				RepositorioOficina.updateOficina(o);
			}else {
				RepositorioOficina.creaOficina(o);
			}
			
			MetodosGUI.vaciarPanel(panel);
			MetodosGUI.desactPanel(panel);
			formu.excepcionesDesact();
			
		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Oficina creaOfiPanel (JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuOficinas formu = (FormuOficinas) dialog;

		String codigo=formu.getTfCodigo().getText();
		String nombre= formu.getTfNombre().getText();
		String provincia = formu.getCbProvincia().getSelectedItem()+"";
		String localidad = formu.getCbLocalidad().getSelectedItem()+"";
		boolean aeropuerto = formu.getChckbxOfiAeropuerto().isSelected();
		String observaciones = formu.getTaObservaciones().getText();
		
		return new Oficina(codigo, nombre, localidad, provincia,aeropuerto, observaciones);
	
	}
	
	
	public static void rellenaPanelOfi (Oficina o, JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuOficinas formu = (FormuOficinas) dialog;

		//si la longitud es correcta  
		if (o!=null) {
			formu.getTfCodigo().setText(o.getCod());
            formu.getTfNombre().setText(o.getDescripcion());
            formu.getChckbxOfiAeropuerto().setSelected(o.isOfiAeropuerto());
            formu.getCbProvincia().setSelectedItem(o.getProvincia());
            formu.getCbLocalidad().setSelectedItem(o.getLocalidad());
            formu.getTaObservaciones().setText(o.getObservaciones());
		}
		
	}
}
