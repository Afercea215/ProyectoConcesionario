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
import javax.swing.JFrame;
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
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioTipoCarnet;
import entidades.*;

public class MetodosEmpleado {
	
	
	public static ArrayList<String> nombreColumnas() {
		ArrayList<String> nombreColumnas = new ArrayList<String>();
		nombreColumnas.add("Nombre Completo");
		nombreColumnas.add("Fecha nacimiento");
		nombreColumnas.add("Oficina");
		nombreColumnas.add("Fecha alta");
		nombreColumnas.add("DNI");
		nombreColumnas.add("obj");
		
		return nombreColumnas;
	}
	
	public static ArrayList<Integer> anchoColumnas() {
		ArrayList<Integer> anchoColumnas = new ArrayList<Integer>();
		anchoColumnas.add(250);
		anchoColumnas.add(55);
		anchoColumnas.add(55);
		anchoColumnas.add(55);
		anchoColumnas.add(55);
		anchoColumnas.add(0);
		
		return anchoColumnas;
	}
	
	public static DatosTabla creaDatosTabla() {
		return (new DatosTabla(nombreColumnas(), listaEmpleadosTabla(), anchoColumnas()));
	}
	
	public static DatosTabla creaDatosTablaDeOfi(String codOfi) {
		return (new DatosTabla(nombreColumnas(), listaEmpleadosTablaDeOfi(codOfi), anchoColumnas()));
	}
	
	public static Object[][] listaEmpleadosTablaDeOfi(String codOfi){
		ArrayList<Empleado> lista = RepositorioEmpleado.arrayListEmpleadosOfi(codOfi);
		int numColumnas = 6;
		int numFilas = lista.size();
		Object[][] listaTabla = new Object[numFilas][numColumnas];		
		
		for (int i=0;i<numFilas;i++) {
				listaTabla[i][0]=lista.get(i).getNombre()+" "+lista.get(i).getAp1()+" "+lista.get(i).getAp2();
				listaTabla[i][1]=new Date(lista.get(i).getFechaNac().get(Calendar.YEAR)-1900, lista.get(i).getFechaNac().get(Calendar.MONTH), lista.get(i).getFechaNac().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][2]=lista.get(i).getOficina().getDescripcion();
				listaTabla[i][3]=new Date(lista.get(i).getFechaAlta().get(Calendar.YEAR)-1900, lista.get(i).getFechaAlta().get(Calendar.MONTH), lista.get(i).getFechaAlta().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][4]=lista.get(i).getDni();
				listaTabla[i][5]=lista.get(i);
		}
		return listaTabla;
	}
	
	public static Object[][] listaEmpleadosTabla(){
		ArrayList<Empleado> lista = RepositorioEmpleado.arrayListEmpleados();
		int numColumnas = 6;
		int numFilas = lista.size();
		Object[][] listaTabla = new Object[numFilas][numColumnas];		
		
		for (int i=0;i<numFilas;i++) {
				listaTabla[i][0]=lista.get(i).getNombre()+" "+lista.get(i).getAp1()+" "+lista.get(i).getAp2();
				listaTabla[i][1]=new Date(lista.get(i).getFechaNac().get(Calendar.YEAR)-1900, lista.get(i).getFechaNac().get(Calendar.MONTH), lista.get(i).getFechaNac().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][2]=lista.get(i).getOficina().getDescripcion();
				listaTabla[i][3]=new Date(lista.get(i).getFechaAlta().get(Calendar.YEAR)-1900, lista.get(i).getFechaAlta().get(Calendar.MONTH), lista.get(i).getFechaAlta().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][4]=lista.get(i).getDni();
				listaTabla[i][5]=lista.get(i);
		}
		
		return listaTabla;
	}
		
	/**
	 * Coge el cliente del formulario y lo graba en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaEmpleado (JDialog jframe) {
		JPanel panel = (JPanel) jframe.getContentPane();
		FormuEmpleados formu = (FormuEmpleados) jframe;
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel,formu.getExcepciones(), true)) {
			
			Empleado e = creaEmplePanel(formu);

			//si la cliente ya existe la borro
			if(RepositorioEmpleado.buscaEmpleado(e.getDni())!=null) {
				RepositorioEmpleado.updateEmpleado(e);
			}else {
				RepositorioEmpleado.creaEmpleado(e, formu);
			}
			MetodosGUI.vaciarPanel(panel);
			MetodosGUI.desactPanel(panel);
			formu.excepcionesDesact();

		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static Empleado creaEmplePanel (JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuEmpleados formu = (FormuEmpleados) dialog;

		String dni=formu.getTfDni().getText();
		String nombre= formu.getTfNombre().getText();
		String ap1 = formu.getTfAp1().getText();
		String ap2 = formu.getTfAp2().getText();
		GregorianCalendar fechaNac = new GregorianCalendar(formu.getDtFechaNac().getDate().getYear(), formu.getDtFechaNac().getDate().getMonth(), formu.getDtFechaNac().getDate().getDay()) ;
		GregorianCalendar fechaAlta = new GregorianCalendar(formu.getDtFechaAlta().getDate().getYear(), formu.getDtFechaAlta().getDate().getMonth(), formu.getDtFechaAlta().getDate().getDay()) ;
		Oficina ofi = RepositorioOficina.buscaOficina(( (Oficina) formu.getCbOficina().getSelectedItem()).getCod());
		 
		return new Empleado(ap1, ap2, nombre, fechaNac, dni, ofi, fechaAlta);
	}
	
	
	public static void rellenaPanelEmple (Empleado e, JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuEmpleados formu = (FormuEmpleados) dialog;
		
		//si la longitud es correcta  
		if (e!=null) {
			
			if (miLibreria.metodos.Validadores.DNIvalido(e.getDni())) {
				int mes = e.getFechaNac().get(Calendar.MONTH)+1;
				int dia = e.getFechaNac().get(Calendar.DAY_OF_MONTH);
				int año = e.getFechaNac().get(Calendar.YEAR);
				
				int mes2 = e.getFechaAlta().get(Calendar.MONTH)+1;
				int dia2 = e.getFechaAlta().get(Calendar.DAY_OF_MONTH);
				int año2 = e.getFechaAlta().get(Calendar.YEAR);
			
				//se busca la oficina en la base de datos y se activa el formu
	            //si ha encontrado una oficina, rellena el formu con los datos.
				formu.getTfDni().setText(e.getDni());
                formu.getTfNombre().setText(e.getNombre());
                formu.getTfAp1().setText(e.getAp1());
                formu.getTfAp2().setText(e.getAp2());
                formu.getDtFechaNac().setDate(new java.util.Date(año, mes, dia));
                formu.getDtFechaAlta().setDate(new java.util.Date(año2, mes2, dia2));
                formu.getCbOficina().setSelectedItem(e.getOficina());                
                
			 }else {
					JOptionPane.showMessageDialog(formu.getfEmple(), "DNI Incorrecto.","Error en la busqueda",JOptionPane.ERROR_MESSAGE);
					formu.getTfDni().setText("");
			 }
			 
		}else {
			 MetodosGUI.activPanel(panel);
			 formu.excepcionesActiva();
		}
	}
}
