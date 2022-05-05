package gui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

import com.toedter.calendar.JDateChooser;

import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioOficina;
import entidades.*;

public class MetodosCliente {
	
	
	public static ArrayList<String> nombreColumnas() {
		ArrayList<String> nombreColumnas = new ArrayList<String>();
		nombreColumnas.add("Nombre Completo");
		nombreColumnas.add("Fecha nacimiento");
		nombreColumnas.add("Carnet");
		nombreColumnas.add("Num Cliente");
		nombreColumnas.add("DNI");
		nombreColumnas.add("obj");
		
		return nombreColumnas;
	}
	
	public static ArrayList<Integer> anchoColumnas() {
		ArrayList<Integer> anchoColumnas = new ArrayList<Integer>();
		anchoColumnas.add(250);
		anchoColumnas.add(100);
		anchoColumnas.add(55);
		anchoColumnas.add(55);
		anchoColumnas.add(55);
		anchoColumnas.add(0);
		
		return anchoColumnas;
	}
	
	public static DatosTabla creaDatosTabla() {
		return (new DatosTabla(MetodosCliente.nombreColumnas(), MetodosCliente.listaClientesTabla(), MetodosCliente.anchoColumnas()));
	}
	
	public static Object[][] listaClientesTabla(){
		ArrayList<Cliente> lista = RepositorioCliente.arrayListClientes();
		int numColumnas = 6;
		int numClientes = lista.size();
		Object[][] listaTabla = new Object[numClientes][numColumnas];		
		
		for (int i=0;i<numClientes;i++) {
				listaTabla[i][0]=lista.get(i).getNombre()+" "+lista.get(i).getAp1()+" "+lista.get(i).getAp2();
				listaTabla[i][1]=new Date(lista.get(i).getFechaNac().get(Calendar.YEAR), lista.get(i).getFechaNac().get(Calendar.MONTH), lista.get(i).getFechaNac().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][2]=lista.get(i).getCarnetConducir().getNombre();
				listaTabla[i][3]=lista.get(i).getnTarjetaCliente();
				listaTabla[i][4]=lista.get(i).getDni();
				listaTabla[i][5]=lista.get(i);
		}
		
		return listaTabla;
	}
	
	/**
	 * Crea un modelo con los datos dde la lista y lo devuelve.
	 * @param lista De clientes. 
	 * @return Modelo de la tabla.
	 */
	public static DefaultTableModel creaModelTabCli(ArrayList<Cliente> lista) {
		DefaultTableModel modelTabOfi = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		modelTabOfi.addColumn("Nombre Completo");
	    modelTabOfi.addColumn("Fecha de nacimiento");
	    modelTabOfi.addColumn("Carnet de conducir");
	    modelTabOfi.addColumn("NTarjetaCliente");
	    modelTabOfi.addColumn("DNI");
	    modelTabOfi.addColumn("Objeto");	
	    //añado datos a la tabla
	    for (Cliente a : lista) {
			modelTabOfi.addRow(new Object[] { a.getNombre()+" "+ a.getAp1()+" "+a.getAp2(),a.fechaNacString()+"",a.getCarnetConducir()+"",a.getnTarjetaCliente(), a.getDni()+"", a});
	    }
		return modelTabOfi;
	}

	/**
	 * Crea una tabla rellena con los datos pasados por parametro.
	 * @param lista lista de objetos para la tabla.
	 * @return tabla rellenada.
	 */
	public static JTable creaRellenaTabCliente(ArrayList<Cliente> lista) {
		JTable tableCliente = new JTable();
		tableCliente.setModel(creaModelTabCli(lista));
		tableCliente.removeColumn(tableCliente.getColumnModel().getColumn(6));
	    //ACTIVAMOS LA ORDENACION DE COLUMNAS
	    tableCliente.setAutoCreateRowSorter(true);
	    
		return tableCliente;
	}
	
	/**
	 * Coge el cliente del formulario y lo graba en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaCliente (JPanel panel) {
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel)) {
			
			//busco los componentes por su nombre y los guardo
			//////////////
			JTextField dni=((JTextField) MetodosGUI.buscarCompPorNombre(panel, "dni"));
			JTextField nombre=((JTextField) MetodosGUI.buscarCompPorNombre(panel, "nombre"));
			JTextField ap1=((JTextField) MetodosGUI.buscarCompPorNombre(panel, "ap1"));
			JTextField ap2=((JTextField) MetodosGUI.buscarCompPorNombre(panel, "ap2"));
			JComboBox<Object> carnet = ((JComboBox<Object>) MetodosGUI.buscarCompPorNombre(panel, "tipoCarnet"));
			JDateChooser fecha=((JDateChooser) MetodosGUI.buscarCompPorNombre(panel, "fechaNac"));
			JButton lupa = ((JButton) MetodosGUI.buscarCompPorNombre(panel, "lupa"));
			JTextField nTarjetaCliente=((JTextField) MetodosGUI.buscarCompPorNombre(panel, "tarjeta"));

			GregorianCalendar fechaNac = new GregorianCalendar();
			fechaNac.setTime(fecha.getDate());
			//si la cliente ya existe la borro
			if(RepositorioCliente.buscaCliente(dni.getText())!=null) {
				RepositorioCliente.borraCliente(dni.getText());
			}
			
			//creo la nueva cliente en la base de datos
			RepositorioCliente.creaCliente(dni.getText(), ap1.getText(), ap2.getText(), nombre.getText(), fechaNac, carnet.getSelectedItem()+"", nTarjetaCliente.getText());
			MetodosGUI.desactPanel(panel);
			MetodosGUI.vaciarPanel(panel);
			dni.setEnabled(true);
			lupa.setEnabled(true);
			
		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
}
