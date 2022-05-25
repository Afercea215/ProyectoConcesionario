package gui;

import java.awt.Component;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import accesoADatos.RepositorioTipoCarnet;
import entidades.Cliente;
import entidades.TipoCarnet;
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
				listaTabla[i][1]=new Date(lista.get(i).getFechaNac().get(Calendar.YEAR)-1900, lista.get(i).getFechaNac().get(Calendar.MONTH), lista.get(i).getFechaNac().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][2]=lista.get(i).getCarnetConducir().getNombre();
				listaTabla[i][3]=lista.get(i).getnTarjetaCliente();
				listaTabla[i][4]=lista.get(i).getDni();
				listaTabla[i][5]=lista.get(i);
		}
		
		return listaTabla;
	}
	
	/**
	 * Coge el cliente del formulario y lo graba en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaCliente (JDialog jframe) {
		JPanel panel = (JPanel) jframe.getContentPane();
		FormuClientes formu = (FormuClientes) jframe;
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel,formu.getExcepciones(), true)) {
			
			Cliente c = creaCliPanel(formu);

			//si la cliente ya existe la borro
			if(RepositorioCliente.buscaCliente(c.getDni())!=null) {
				RepositorioCliente.updateCliente(c);
			}else {
				RepositorioCliente.creaCliente(c);
			}
			
			MetodosGUI.vaciarPanel(panel);
			MetodosGUI.desactPanel(panel);
			formu.excepcionesDesact();

		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Cliente creaCliPanel (JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuClientes formu = (FormuClientes) dialog;

		String dni=formu.getTfDni().getText();
		String nombre= formu.getTfNombre().getText();
		String ap1 = formu.getTfAp1().getText();
		String ap2 = formu.getTfAp2().getText();
		TipoCarnet tipoCarnet = RepositorioTipoCarnet.buscaTipoCarnet(formu.getCbTipoCarnet().getSelectedItem()+"");
		String nTarjeta = formu.getTfNTarjeta().getText();
		GregorianCalendar fechaNac = new GregorianCalendar(formu.getDtFechaNac().getDate().getYear(), formu.getDtFechaNac().getDate().getMonth(), formu.getDtFechaNac().getDate().getDay()) ;
		
		return new Cliente(ap1, ap2, nombre, fechaNac, dni, tipoCarnet, nTarjeta);
	}
	
	public static void rellenaPanelCli (Cliente c, JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuClientes formu = (FormuClientes) dialog;
		
		//si la longitud es correcta  
		if (c!=null) {
			
			if (miLibreria.metodos.Validadores.DNIvalido(c.getDni())) {
				int mes = c.getFechaNac().get(Calendar.MONTH)+1;
				int dia = c.getFechaNac().get(Calendar.DAY_OF_MONTH);
				int año = c.getFechaNac().get(Calendar.YEAR);
			
				//se busca la oficina en la base de datos y se activa el formu
	            //si ha encontrado una oficina, rellena el formu con los datos.
				formu.getTfDni().setText(c.getDni());
                formu.getTfNombre().setText(c.getNombre());
                formu.getTfAp1().setText(c.getAp1());
                formu.getTfAp2().setText(c.getAp2());
                formu.getCbTipoCarnet().setSelectedItem(c.getCarnetConducir().getNombre());
                formu.getTfNTarjeta().setText(c.getnTarjetaCliente());
                formu.getDtFechaNac().setDate(new java.util.Date(año, mes, dia));
			 }else {
					JOptionPane.showMessageDialog(formu.getfCli(), "DNI Incorrecto.","Error en la busqueda",JOptionPane.ERROR_MESSAGE);
					formu.getTfDni().setText("");
			 }
			 
		}else {
			 MetodosGUI.activPanel(panel);
			 formu.excepcionesActiva();
		}
	}
}
