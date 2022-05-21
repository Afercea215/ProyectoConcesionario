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
import accesoADatos.RepositorioCocheElectrico;
import accesoADatos.RepositorioColor;
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioMoto;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioTipoCarnet;
import entidades.*;

public class MetodosCocheElectrico {
	
	
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
		nombreColumnas.add("N Plazas");
		nombreColumnas.add("TipoCoche");
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
		return (new DatosTabla(nombreColumnas(), listaCochesElectricosTabla(), anchoColumnas()));
	}
	
	public static Object[][] listaCochesElectricosTabla(){
		ArrayList<CocheElectrico> lista = RepositorioCocheElectrico.arrayListCochesElectricos();
		int numColumnas = 15;
		int numFilas = lista.size();
		Object[][] listaTabla = new Object[numFilas][numColumnas];	
		
		String alqui="";
		
		for (int i=0;i<numFilas;i++) {
				listaTabla[i][0]=lista.get(i).getMatricula();
				listaTabla[i][1]=lista.get(i).getMarca();
				listaTabla[i][2]=lista.get(i).getModelo();
				listaTabla[i][3]=lista.get(i).getColor();
				listaTabla[i][4]=new Date(lista.get(i).getFechaAlta().get(Calendar.YEAR)-1900, lista.get(i).getFechaAlta().get(Calendar.MONTH), lista.get(i).getFechaAlta().get(Calendar.DAY_OF_MONTH));
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
				listaTabla[i][11]=lista.get(i).getN_plazas();
				listaTabla[i][12]=lista.get(i).getTipo();
				listaTabla[i][13]=lista.get(i).getPrecioDiario();
				listaTabla[i][14]=lista.get(i);
		}
		
		return listaTabla;
	}
		
	/**
	 * Coge el cliente del formulario y lo graba en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaCocheElectrico (JDialog jframe) {
		
		FormuCocheElectrico formu = (FormuCocheElectrico) jframe;
		JPanel panel = formu.getContentPanel();
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel, true)) {
			
			CocheElectrico coche = creaCocheElectricoPanel(formu);

			//si la cliente ya existe la borro
			if(RepositorioCocheElectrico.buscaCocheElectrico(coche.getMatricula())!=null) {
				RepositorioCocheElectrico.updateCocheElectrico(coche);
			}else {
				RepositorioCocheElectrico.creaCocheElectrico(coche);
			}
			MetodosGUI.vaciarPanel(panel);
			MetodosGUI.desactPanel(panel);
			formu.excepcionesDesact();

		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static CocheElectrico creaCocheElectricoPanel (JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuCocheElectrico formu = (FormuCocheElectrico) dialog;

		String matricula=formu.getTfMatricula().getText();
		String marca=formu.getTfMarca().getText();
		String modelo=formu.getTfModelo().getText();
		Color color=RepositorioColor.buscaColor(formu.getCbColor().getSelectedItem()+"");
		int kms=Integer.parseInt(formu.getTfKms().getText());
		Categoria cat = RepositorioCategoria.buscaCategoria(( (Categoria)formu.getCbCateg().getSelectedItem()).getCodigo());
		boolean alquilado = formu.getChckbxAlquilado().isSelected();
		int autonomia=Integer.parseInt(formu.getTfAutonomia().getText());
		int tiempoRecarga=Integer.parseInt(formu.getTfRecarga().getText());
		int nPlazas=Integer.parseInt(formu.getTfNPlazas().getText());
		String tipoCoche=formu.getCbTipoCoche().getSelectedItem()+"";
		GregorianCalendar fechaAlta = new GregorianCalendar(formu.getDtFechaAlta().getDate().getYear(), formu.getDtFechaAlta().getDate().getMonth(), formu.getDtFechaAlta().getDate().getDay()) ;
		Oficina ofi = RepositorioOficina.buscaOficina(( (Oficina) formu.getCbOficina().getSelectedItem()).getCod());
		
		return new CocheElectrico(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, autonomia, tiempoRecarga, nPlazas, tipoCoche);
	}
	
	
	public static void rellenaPanelCocheElctrico (CocheElectrico coche, JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuCocheElectrico formu = (FormuCocheElectrico) dialog;
		
		//si la longitud es correcta  
		if (coche!=null) {
			int mes = coche.getFechaAlta().get(Calendar.MONTH);
			int dia = coche.getFechaAlta().get(Calendar.DAY_OF_MONTH);
			int año = coche.getFechaAlta().get(Calendar.YEAR);
		
			//se busca la oficina en la base de datos y se activa el formu
            //si ha encontrado una oficina, rellena el formu con los datos.
			formu.getTfMatricula().setText(coche.getMatricula());
            formu.getTfMarca().setText(coche.getMarca());
            formu.getTfModelo().setText(coche.getModelo());
            formu.getCbColor().setSelectedItem(coche.getColor());
            formu.getDtFechaAlta().setDate(new java.util.Date(año, mes, dia));
            formu.getTfKms().setText(coche.getKms()+"");
            formu.getCbOficina().setSelectedItem(coche.getOficina());
            formu.getCbCateg().setSelectedItem(coche.getCategoria());
            formu.getChckbxAlquilado().setSelected(coche.isAlquilado());
            formu.getTfAutonomia().setText(coche.getAutonimia()+"");
            formu.getTfRecarga().setText(coche.getTiempoRecarga()+"");
            formu.getCbTipoCoche().setSelectedItem(coche.getTipo());
            formu.getTfNPlazas().setText(coche.getN_plazas()+"");

		}else {
			 MetodosGUI.activPanel(panel);
			 formu.excepcionesActiva();
		}
	}
}
