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

import accesoADatos.RepositorioAlquiler;
import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioCocheCombustion;
import accesoADatos.RepositorioCocheElectrico;
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioFurgoneta;
import accesoADatos.RepositorioMoto;
import accesoADatos.RepositorioAlquiler;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioTipoCarnet;
import entidades.*;

public class MetodosAlquiler {
	
	
	public static ArrayList<String> nombreColumnas() {
		ArrayList<String> nombreColumnas = new ArrayList<String>();
		nombreColumnas.add("ID");
		nombreColumnas.add("Vehiculo");
		nombreColumnas.add("Alquiler");
		nombreColumnas.add("Cliente");
		nombreColumnas.add("Fecha Inicio");
		nombreColumnas.add("Oficina Alquiler");
		nombreColumnas.add("Oficina Devolucion");
		nombreColumnas.add("Fecha fin");
		nombreColumnas.add("Precio previsto");
		nombreColumnas.add("obj");
		
		return nombreColumnas;
	}
	
	public static ArrayList<Integer> anchoColumnas() {
		ArrayList<Integer> anchoColumnas = new ArrayList<Integer>();
		anchoColumnas.add(50);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(0);
		
		return anchoColumnas;
	}
	
	public static DatosTabla creaDatosTabla() {
		return (new DatosTabla(nombreColumnas(), listaAlquileresTabla(), anchoColumnas()));
	}
	
	public static Object[][] listaAlquileresTabla(){
		ArrayList<Alquiler> lista = RepositorioAlquiler.arrayListAlquiler();
		int numColumnas = 10;
		int numFilas = lista.size();
		Object[][] listaTabla = new Object[numFilas][numColumnas];		
		
		for (int i=0;i<numFilas;i++) {
				listaTabla[i][0]=lista.get(i).getId();
				listaTabla[i][1]=lista.get(i).getVehiculo().getMatricula();
				listaTabla[i][2]=lista.get(i).getEmpleado().getDni();
				listaTabla[i][3]=lista.get(i).getCliente().getDni();
				listaTabla[i][4]=new Date(lista.get(i).getFechaIniAlquiler().get(Calendar.YEAR), lista.get(i).getFechaIniAlquiler().get(Calendar.MONTH)-1, lista.get(i).getFechaIniAlquiler().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][5]=lista.get(i).getOficinaAlquiler().getCod();
				listaTabla[i][6]=lista.get(i).getOficinaDevolucion().getCod();
				listaTabla[i][7]=new Date(lista.get(i).getFechaFinPrevista().get(Calendar.YEAR), lista.get(i).getFechaFinPrevista().get(Calendar.MONTH)-1, lista.get(i).getFechaFinPrevista().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][8]=lista.get(i).getAlquilerPrevisto();
				listaTabla[i][9]=lista.get(i);
		}
		
		return listaTabla;
	}
		
	/**
	 * Coge el cliente del formulario y lo graba en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaAlquiler (JDialog jframe) {
		JPanel panel = (JPanel) jframe.getContentPane();
		FormuAlquiler formu = (FormuAlquiler) jframe;
		
		formu.getDpIni().updateUI();
		formu.getDpFin().updateUI();
		formu.getDpFin().setEnabled(true);
		formu.getDpIni().setEnabled(true);
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel,formu.getExcepciones(), true)) {
			
			Alquiler a = creaAlquiPanel(formu);

			//si la cliente ya existe la borro
			if(RepositorioAlquiler.buscaAlquiler(a.getId())!=null) {
				RepositorioAlquiler.updateAlquiler(a);
			}else {
				RepositorioAlquiler.creaAlquiler(a);
			}
			MetodosGUI.vaciarPanel(panel);
			MetodosGUI.desactPanel(panel);
			formu.excepcionesDesact();

		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static Alquiler creaAlquiPanel (JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuAlquiler formu = (FormuAlquiler) dialog;

		String id=formu.getTfCodigo().getText();
		
		Vehiculo vehiculo= null;
		String vehiculoSeleccionado=formu.getCbTipoVehiculo().getSelectedItem()+"";

		if (vehiculoSeleccionado.equalsIgnoreCase("Coche")) {
			vehiculo= RepositorioMoto.buscaMoto(formu.getTfVehiculo().getText());
		} else if (vehiculoSeleccionado.equalsIgnoreCase("Furgoneta")) {
			vehiculo= RepositorioFurgoneta.buscaFurgoneta(formu.getTfVehiculo().getText());
		} else if (vehiculoSeleccionado.equalsIgnoreCase("Coche Electrico")) {
			vehiculo= RepositorioCocheElectrico.buscaCocheElectrico(formu.getTfVehiculo().getText());
		} else if (vehiculoSeleccionado.equalsIgnoreCase("Coche Combustion")) {
			vehiculo= RepositorioCocheCombustion.buscaCocheCombustion(formu.getTfVehiculo().getText());
		}
		
		Empleado emple= RepositorioEmpleado.buscaEmpleado(formu.getTfEmple().getText());
		Cliente cli= RepositorioCliente.buscaCliente(formu.getTfCliente().getText());
		GregorianCalendar fechaIni = new GregorianCalendar(formu.getDpIni().getModel().getYear(), formu.getDpIni().getModel().getMonth()+1, formu.getDpIni().getModel().getDay()) ;
		GregorianCalendar fechaFin = new GregorianCalendar(formu.getDpFin().getModel().getYear(), formu.getDpFin().getModel().getMonth()+1, formu.getDpFin().getModel().getDay()) ;
		System.out.println(fechaFin.get(Calendar.DAY_OF_MONTH));
		
		Oficina ofiAlqui = RepositorioOficina.buscaOficina(( (Oficina) formu.getCbOfiIni().getSelectedItem()).getCod());
		Oficina ofiDevo = RepositorioOficina.buscaOficina(( (Oficina) formu.getCbOfiFin().getSelectedItem()).getCod());
		String precioString = formu.getTfPrecioPrevisto().getText();
		Double PrecioPrevisto=0.00;
		if (!precioString.equalsIgnoreCase("")) {
			PrecioPrevisto = Double.parseDouble(precioString);	
		}
		
		return new Alquiler(id, vehiculo, emple, cli, fechaIni, ofiAlqui, ofiDevo, fechaFin, PrecioPrevisto);
	}
	
	
	public static void rellenaPanelAlqui (Alquiler a, JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuAlquiler formu = (FormuAlquiler) dialog;
		
		//si la longitud es correcta  
		if (a!=null) {
			
				int mes = a.getFechaIniAlquiler().get(Calendar.MONTH)+1;
				int dia = a.getFechaIniAlquiler().get(Calendar.DAY_OF_MONTH);
				int año = a.getFechaIniAlquiler().get(Calendar.YEAR);
				
				int mes2 = a.getFechaFinPrevista().get(Calendar.MONTH)+1;
				int dia2 = a.getFechaFinPrevista().get(Calendar.DAY_OF_MONTH);
				int año2 = a.getFechaFinPrevista().get(Calendar.YEAR);
			
				//se busca la oficina en la base de datos y se activa el formu
	            //si ha encontrado una oficina, rellena el formu con los datos.
				formu.getTfCodigo().setText(a.getId());
				formu.getTfVehiculo().setText(a.getVehiculo().getMatricula());
                formu.getTfEmple().setText(a.getEmpleado().getDni());
                formu.getTfCliente().setText(a.getCliente().getDni());
                
                formu.getDpIni().getModel().setDay(dia);
                formu.getDpIni().getModel().setMonth(mes);
                formu.getDpIni().getModel().setYear(año);

                formu.getDpFin().getModel().setDay(dia2);
                formu.getDpFin().getModel().setMonth(mes2);
                formu.getDpFin().getModel().setYear(año2);

                formu.getCbOfiIni().setSelectedItem(a.getOficinaAlquiler());                
                formu.getCbOfiIni().setSelectedItem(a.getOficinaDevolucion());
                formu.getTfPrecioPrevisto().setText(a.getAlquilerPrevisto()+"");
                
		}else {
			 MetodosGUI.activPanel(panel);
			 formu.excepcionesActiva();
		}
	}
}
