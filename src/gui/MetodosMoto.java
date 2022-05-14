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

import accesoADatos.RepositorioCategoria;
import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioColor;
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioMoto;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioTipoCarnet;
import entidades.*;

public class MetodosMoto {
	
	
	public static ArrayList<String> nombreColumnas() {
		ArrayList<String> nombreColumnas = new ArrayList<String>();
		nombreColumnas.add("Matricula");
		nombreColumnas.add("Marca");
		nombreColumnas.add("Modelo");
		nombreColumnas.add("Color");
		nombreColumnas.add("Fecha alta");
		nombreColumnas.add("kms");
		nombreColumnas.add("Oficina");
		nombreColumnas.add("Categoria");
		nombreColumnas.add("Alquilado");
		nombreColumnas.add("Autonomía");
		nombreColumnas.add("Tiempo de recarga");
		nombreColumnas.add("Cilindrada");
		nombreColumnas.add("TipoCarnet");
		nombreColumnas.add("PrecioDiario");
		nombreColumnas.add("obj");
		
		return nombreColumnas;
	}
	
	public static ArrayList<Integer> anchoColumnas() {
		ArrayList<Integer> anchoColumnas = new ArrayList<Integer>();
		anchoColumnas.add(75);
		anchoColumnas.add(100);
		anchoColumnas.add(100);
		anchoColumnas.add(60);
		anchoColumnas.add(75);
		anchoColumnas.add(50);
		anchoColumnas.add(175);
		anchoColumnas.add(175);
		anchoColumnas.add(75);
		anchoColumnas.add(75);
		anchoColumnas.add(100);
		anchoColumnas.add(75);
		anchoColumnas.add(75);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(55);
		
		return anchoColumnas;
	}
	
	public static DatosTabla creaDatosTabla() {
		return (new DatosTabla(nombreColumnas(), listaMotosTabla(), anchoColumnas()));
	}
	
	public static Object[][] listaMotosTabla(){
		ArrayList<Moto> lista = RepositorioMoto.arrayListMotos();
		int numColumnas = 15;
		int numFilas = lista.size();
		Object[][] listaTabla = new Object[numFilas][numColumnas];	
		
		String alqui="";
		
		for (int i=0;i<numFilas;i++) {
				listaTabla[i][0]=lista.get(i).getMatricula();
				listaTabla[i][1]=lista.get(i).getMarca();
				listaTabla[i][2]=lista.get(i).getModelo();
				listaTabla[i][3]=lista.get(i).getColor();
				listaTabla[i][4]=new Date(lista.get(i).getFechaAlta().get(Calendar.YEAR), lista.get(i).getFechaAlta().get(Calendar.MONTH), lista.get(i).getFechaAlta().get(Calendar.DAY_OF_MONTH));
				listaTabla[i][5]=lista.get(i).getKms();
				listaTabla[i][6]=lista.get(i).getOficina().getDescripcion();
				listaTabla[i][7]=lista.get(i).getCategoria();
				if (lista.get(i).isAlquilado()) {
					alqui="Si";
				}else {
					alqui="No";
				}
				listaTabla[i][8]=alqui;
				listaTabla[i][9]=lista.get(i).getAutonimia();
				listaTabla[i][10]=lista.get(i).getTiempoRecarga();
				listaTabla[i][11]=lista.get(i).getCilindrada();
				listaTabla[i][12]=lista.get(i).getCarnetRequerido().getNombre();
				listaTabla[i][13]=lista.get(i).getPrecioDiario();
				listaTabla[i][14]=lista.get(i);
		}
		
		return listaTabla;
	}
		
	/**
	 * Coge el cliente del formulario y lo graba en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaMoto (JDialog jframe) {
		JPanel panel = (JPanel) jframe.getContentPane();
		FormuMotos formu = (FormuMotos) jframe;
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel,formu.getExcepciones(), true)) {
			
			Moto m = creaMotoPanel(formu);

			//si la cliente ya existe la borro
			if(RepositorioMoto.buscaMoto(m.getMatricula())!=null) {
				RepositorioMoto.updateMoto(m);
			}else {
				RepositorioMoto.creaMoto(m);
			}
			MetodosGUI.vaciarPanel(panel);
			MetodosGUI.desactPanel(panel);
			formu.excepcionesDesact();

		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static Moto creaMotoPanel (JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuMotos formu = (FormuMotos) dialog;

		String matricula=formu.getTfMatricula().getText();
		String marca=formu.getTfMarca().getText();
		String modelo=formu.getTfModelo().getText();
		Color color=RepositorioColor.buscaColor(formu.getCbColor().getSelectedItem()+"");
		int kms=Integer.parseInt(formu.getTfKms().getText());
		Categoria cat = RepositorioCategoria.buscaCategoria(( (Categoria)formu.getCbCateg().getSelectedItem()).getCodigo());
		boolean alquilado = formu.getChckbxAlquilado().isSelected();
		int autonomia=Integer.parseInt(formu.getTfAutonomia().getText());
		int tiempoRecarga=Integer.parseInt(formu.getTfRecarga().getText());
		int cilindrada=Integer.parseInt(formu.getTfCilindrada().getText());
		TipoCarnet carnet = RepositorioTipoCarnet.buscaTipoCarnet( ( (TipoCarnet)formu.getCbTipoCarnet().getSelectedItem()).getNombre());
		GregorianCalendar fechaAlta = new GregorianCalendar(formu.getDtFechaAlta().getDate().getYear(), formu.getDtFechaAlta().getDate().getMonth(), formu.getDtFechaAlta().getDate().getDay()) ;
		Oficina ofi = RepositorioOficina.buscaOficina(( (Oficina) formu.getCbOficina().getSelectedItem()).getCod());
		
		return new Moto(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, autonomia, tiempoRecarga, cilindrada, carnet);
	}
	
	
	public static void rellenaPanelMoto (Moto m, JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuMotos formu = (FormuMotos) dialog;
		
		//si la longitud es correcta  
		if (m!=null) {
			int mes = m.getFechaAlta().get(Calendar.MONTH);
			int dia = m.getFechaAlta().get(Calendar.DAY_OF_MONTH);
			int año = m.getFechaAlta().get(Calendar.YEAR);
		
			//se busca la oficina en la base de datos y se activa el formu
            //si ha encontrado una oficina, rellena el formu con los datos.
			formu.getTfMatricula().setText(m.getMatricula());
            formu.getTfMarca().setText(m.getMarca());
            formu.getTfModelo().setText(m.getModelo());
            formu.getCbColor().setSelectedItem(m.getColor());
            formu.getDtFechaAlta().setDate(new java.util.Date(año, mes, dia));
            formu.getTfKms().setText(m.getKms()+"");
            formu.getCbOficina().setSelectedItem(m.getOficina());
            formu.getCbCateg().setSelectedItem(m.getCategoria());
            formu.getChckbxAlquilado().setSelected(m.isAlquilado());
            formu.getTfAutonomia().setText(m.getAutonimia()+"");
            formu.getTfRecarga().setText(m.getTiempoRecarga()+"");
            formu.getTfCilindrada().setText(m.getCilindrada()+"");
            formu.getCbTipoCarnet().setSelectedItem(m.getCarnetRequerido());

		}else {
			 MetodosGUI.activPanel(panel);
			 formu.excepcionesActiva();
		}
	}
}
