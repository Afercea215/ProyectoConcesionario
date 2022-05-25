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
import accesoADatos.RepositorioDevolucion;
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioFurgoneta;
import accesoADatos.RepositorioMoto;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioTipoCarnet;
import accesoADatos.RepositorioVehiculo;
import entidades.Alquiler;
import entidades.Cliente;
import entidades.Devolucion;
import entidades.Empleado;
import entidades.Oficina;
import entidades.Vehiculo;
import entidades.*;

public class MetodosDevolucion {
	
	
	public static ArrayList<String> nombreColumnas() {
		ArrayList<String> nombreColumnas = new ArrayList<String>();
		nombreColumnas.add("ID");
		nombreColumnas.add("Vehiculo");
		nombreColumnas.add("Devolucion");
		nombreColumnas.add("Empleado");
		nombreColumnas.add("Cliente");
		nombreColumnas.add("Fecha devolucion");
		nombreColumnas.add("Oficina Devolucion");
		nombreColumnas.add("Kms recorridos");
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
		anchoColumnas.add(0);
		
		return anchoColumnas;
	}
	
	public static DatosTabla creaDatosTabla() {
		return (new DatosTabla(nombreColumnas(), listaDevolucionesTabla(), anchoColumnas()));
	}
	
	public static Object[][] listaDevolucionesTabla(){
		ArrayList<Devolucion> lista = RepositorioDevolucion.arrayListDevolucion();
		int numColumnas = 9;
		int numFilas = lista.size();
		Object[][] listaTabla = new Object[numFilas][numColumnas];		
		
		for (int i=0;i<numFilas;i++) {
				listaTabla[i][0]=lista.get(i).getId();
				listaTabla[i][1]=lista.get(i).getVehiculo().getMatricula();
				listaTabla[i][2]=lista.get(i).getAlquiler().getId();
				listaTabla[i][3]=lista.get(i).getEmpleado().getDni();
				listaTabla[i][4]=lista.get(i).getCliente().getDni();
				listaTabla[i][5]=new Date(lista.get(i).getFechaDevolucionReal().get(Calendar.YEAR), lista.get(i).getFechaDevolucionReal().get(Calendar.MONTH)-1, lista.get(i).getFechaDevolucionReal().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][6]=lista.get(i).getOficina().getCod();
				listaTabla[i][7]=lista.get(i).getKmsRecorridos();
				listaTabla[i][8]=lista.get(i);
		}
		
		return listaTabla;
	}
		
	/**
	 * Coge el cliente del formulario y lo graba en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaDevolucion (JDialog jframe) {
		JPanel panel = (JPanel) jframe.getContentPane();
		FormuDevolucion formu = (FormuDevolucion) jframe;
		
		formu.getDpFin().updateUI();
		formu.getDpFin().setEnabled(true);
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel,formu.getExcepciones(), true)) {
			
			Devolucion a = creaDevoPanel(formu);

			//si la cliente ya existe la borro
			if(RepositorioDevolucion.buscaDevolucion(a.getId())!=null) {
				RepositorioDevolucion.updateDevolucion(a);
			}else {
				RepositorioDevolucion.creaDevolucion(a);
			}
			RepositorioVehiculo.actualizaKms(a.getVehiculo().getMatricula(), Integer.parseInt(formu.getTfkms().getText()));
			
			MetodosGUI.vaciarPanel(panel);
			MetodosGUI.desactPanel(panel);
			formu.excepcionesDesact();

		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static Devolucion creaDevoPanel (JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuDevolucion formu = (FormuDevolucion) dialog;

		String id=RepositorioDevolucion.generaID();
		
		Alquiler alqui = RepositorioAlquiler.buscaAlquiler(formu.getTfCodigoAlqui().getText());
		Vehiculo vehiculo= alqui.getVehiculo();
		Empleado emple= RepositorioEmpleado.buscaEmpleado(formu.getTfEmple().getText());
		Cliente cli= alqui.getCliente();
		GregorianCalendar fechaFin = new GregorianCalendar(formu.getDpFin().getModel().getYear(), formu.getDpFin().getModel().getMonth()+1, formu.getDpFin().getModel().getDay()) ;
		int kms = Integer.parseInt(formu.getTfkms().getText());
		Oficina ofi = RepositorioOficina.buscaOficina(( (Oficina) formu.getCbOfi().getSelectedItem()).getCod());
		String precioString = formu.getTfPrecioPrevisto().getText();
		Double precio=0.00;
		if (!precioString.equalsIgnoreCase("")) {
			precio = Double.parseDouble(precioString);	
		}
		
		return new Devolucion(id, ofi, alqui, vehiculo, kms, fechaFin, emple, cli, precio);
	}
	
	
	public static void rellenaPanelDevo (Devolucion a, JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuDevolucion formu = (FormuDevolucion) dialog;
		
		//si la longitud es correcta  
		if (a!=null) {
			
				int mes = a.getFechaDevolucionReal().get(Calendar.MONTH)+1;
				int dia = a.getFechaDevolucionReal().get(Calendar.DAY_OF_MONTH);
				int año = a.getFechaDevolucionReal().get(Calendar.YEAR);
				
				//se busca la oficina en la base de datos y se activa el formu
	            //si ha encontrado una oficina, rellena el formu con los datos.
				formu.getTfCodigoAlqui().setText(a.getAlquiler().getId());
				formu.getTfVehiculo().setText(a.getVehiculo().getMatricula());
                
                formu.getDpFin().getModel().setDay(dia);
                formu.getDpFin().getModel().setMonth(mes);
                formu.getDpFin().getModel().setYear(año);

                formu.getCbOfi().setSelectedItem(a.getOficina());
                formu.getTfPrecio().setText(a.getPrecio()+"");
                formu.getTfkms().setText(a.getKmsRecorridos()+"");
                formu.getTfEmple().setText(a.getEmpleado().getDni());
                formu.getTfCliente().setText(a.getCliente().getDni());
		}else {
			 MetodosGUI.activPanel(panel);
			 formu.excepcionesActiva();
		}
	}
}
