package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

import accesoADatos.RepositorioOficina;
import entidades.Oficina;

public class MetodosOficina {
	
	/**
	 * Crea un modelo con los datos dde la lista y lo devuelve.
	 * @param lista De oficinas. 
	 * @return Modelo de la tabla.
	 */
	public static DefaultTableModel creaModelTabOfi(ArrayList<Oficina> lista) {
		DefaultTableModel modelTabOfi = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		modelTabOfi.addColumn("COD");
		modelTabOfi.addColumn("Descripicion");
		modelTabOfi.addColumn("Provincia");
	    modelTabOfi.addColumn("Localidad");
	    modelTabOfi.addColumn("Oficina Aeropuerto");
	    modelTabOfi.addColumn("Observaciones");
	    modelTabOfi.addColumn("Objeto");	
	    //añado datos a la tabla
	    for (Oficina a : lista) {
			modelTabOfi.addRow(new Object[] { a.getCod()+"", a.getDescripcion()+"", a.getProvincia()+"",a.getLocalidad()+"",a.isOfiAeropuerto()+"",a.getObservaciones(),a});
	    }
		return modelTabOfi;
	}

	/**
	 * Crea una tabla rellena con los datos pasados por parametro.
	 * @param lista lista de objetos para la tabla.
	 * @return tabla rellenada.
	 */
	public static JTable creaRellenaTabOfi(ArrayList<Oficina> lista) {
		JTable tableOficina = new JTable();
	    tableOficina.setModel(creaModelTabOfi(lista));
	    tableOficina.removeColumn(tableOficina.getColumnModel().getColumn(6));
	    //ACTIVAMOS LA ORDENACION DE COLUMNAS
	    tableOficina.setAutoCreateRowSorter(true);
	    
		return tableOficina;
	}
	
	/**
	 * Graba la oficina en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaOficina (JPanel panel) {
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel)) {
			
			//busco los componentes por su nombre y los guardo
			JTextField codigo=((JTextField) MetodosGUI.buscarCompPorNombre(panel, "codigo"));
			JTextField nombre=((JTextField) MetodosGUI.buscarCompPorNombre(panel, "nombre"));
			JComboBox<Object> provincia = ((JComboBox<Object>) MetodosGUI.buscarCompPorNombre(panel, "provincia"));
			JComboBox<Object> localidad = ((JComboBox<Object>) MetodosGUI.buscarCompPorNombre(panel, "localidad"));
			JCheckBox aeropuerto = ((JCheckBox) MetodosGUI.buscarCompPorNombre(panel, "aeropuerto"));
			JTextArea observaciones = ((JTextArea) MetodosGUI.buscarCompPorNombre(panel, "observaciones"));
			JButton lupa = ((JButton) MetodosGUI.buscarCompPorNombre(panel, "lupa"));
			
			//si la oficina ya existe la borro
			if(RepositorioOficina.buscaOficina(codigo.getText())!=null) {
				RepositorioOficina.borraOficina(codigo.getText());
			}
			
			//creo la nueva oficina en la base de datos
			RepositorioOficina.creaOficina(codigo.getText(), nombre.getText(), provincia.getSelectedItem()+"", localidad.getSelectedItem()+"", aeropuerto.isSelected(),observaciones.getText());
			MetodosGUI.desactPanel(panel);
			MetodosGUI.vaciarPanel(panel);
			codigo.setEnabled(true);
			lupa.setEnabled(true);
			
		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
}
