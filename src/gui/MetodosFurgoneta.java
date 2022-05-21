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
import accesoADatos.RepositorioFurgoneta;
import accesoADatos.RepositorioColor;
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioMoto;
import accesoADatos.RepositorioNivelEmision;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioTipoCarnet;
import entidades.*;

public class MetodosFurgoneta {
	
	
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
		nombreColumnas.add("Consumo");
		nombreColumnas.add("Potencia");
		nombreColumnas.add("N Emision");
		nombreColumnas.add("Capacidad carga");
		nombreColumnas.add("Carnet Requerido");
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
		anchoColumnas.add(75);
		anchoColumnas.add(125);
		anchoColumnas.add(125);
		anchoColumnas.add(55);
		
		return anchoColumnas;
	}
	
	public static DatosTabla creaDatosTabla() {
		return (new DatosTabla(nombreColumnas(), listaFurgonetasTabla(), anchoColumnas()));
	}
	
	public static Object[][] listaFurgonetasTabla(){
		ArrayList<Furgoneta> lista = RepositorioFurgoneta.arrayListfurgosCombustion();
		int numColumnas = 16;
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
				
				listaTabla[i][9]=lista.get(i).getConsumo();
				listaTabla[i][10]=lista.get(i).getPotencia();
				listaTabla[i][11]=lista.get(i).getNivelEmison();
				 
				listaTabla[i][12]=lista.get(i).getCapacidadCarga();
				listaTabla[i][13]=lista.get(i).getCarnetRequerido().getNombre();
				listaTabla[i][14]=lista.get(i).getPrecioDiario();
				listaTabla[i][15]=lista.get(i);
		}
		
		return listaTabla;
	}
		
	/**
	 * Coge el cliente del formulario y lo graba en la base de datos.
	 * @param panel Panel donde se encuentran los componjentes
	 */
	public static void grabaFurgoneta (JDialog jframe) {
		
		FormuFurgoneta formu = (FormuFurgoneta) jframe;
		JPanel panel = formu.getContentPanel();
		
		//si todo esta relleno lo graba, si no sale un mensaje
		if (MetodosGUI.datosRellenos(panel, true)) {
			
			Furgoneta furgo = creaFurgonetaPanel(formu);

			//si la cliente ya existe la borro
			if(RepositorioFurgoneta.buscaFurgoneta(furgo.getMatricula())!=null) {
				RepositorioFurgoneta.updateFurgoneta(furgo);
			}else {
				RepositorioFurgoneta.creaFurgoneta(furgo);
			}
			MetodosGUI.vaciarPanel(panel);
			MetodosGUI.desactPanel(panel);
			formu.excepcionesDesact();

		} else {
			JOptionPane.showMessageDialog(panel, "Hay datos que debe rellenar","Error en la grabación de datos",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static Furgoneta creaFurgonetaPanel (JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuFurgoneta formu = (FormuFurgoneta) dialog;

		String matricula=formu.getTfMatricula().getText();
		String marca=formu.getTfMarca().getText();
		String modelo=formu.getTfModelo().getText();
		Color color=RepositorioColor.buscaColor(formu.getCbColor().getSelectedItem()+"");
		int kms=Integer.parseInt(formu.getTfKms().getText());
		Categoria cat = RepositorioCategoria.buscaCategoria(( (Categoria)formu.getCbCateg().getSelectedItem()).getCodigo());
		boolean alquilado = formu.getChckbxAlquilado().isSelected();
		
		int consumo=Integer.parseInt(formu.getTfConsumo().getText());
		int potencia=Integer.parseInt(formu.getTfPotencia().getText());
		NivelEmision nivelEmision=RepositorioNivelEmision.buscaNivelEmision(((NivelEmision)formu.getCbNivelEmision().getSelectedItem()).getLetra());
		
		int capacidadCarga=Integer.parseInt(formu.getTfCapacidadCarga().getText());
		TipoCarnet tipoCarnet=RepositorioTipoCarnet.buscaTipoCarnet(( (TipoCarnet)formu.getCbTipoCarnet().getSelectedItem()).getNombre());
		
		GregorianCalendar fechaAlta = new GregorianCalendar(formu.getDtFechaAlta().getDate().getYear(), formu.getDtFechaAlta().getDate().getMonth(), formu.getDtFechaAlta().getDate().getDay()) ;
		Oficina ofi = RepositorioOficina.buscaOficina(( (Oficina) formu.getCbOficina().getSelectedItem()).getCod());
		
		return new Furgoneta(matricula, marca, modelo, color, fechaAlta, kms, cat, ofi, alquilado, consumo, potencia, nivelEmision, capacidadCarga, tipoCarnet);
	}
	
	
	public static void rellenaPanelFurgoneta (Furgoneta furgo, JDialog dialog) {
		
		JPanel panel = (JPanel) dialog.getContentPane();
		FormuFurgoneta formu = (FormuFurgoneta) dialog;
		
		//si la longitud es correcta  
		if (furgo!=null) {
			int mes = furgo.getFechaAlta().get(Calendar.MONTH);
			int dia = furgo.getFechaAlta().get(Calendar.DAY_OF_MONTH);
			int año = furgo.getFechaAlta().get(Calendar.YEAR);
		
			//se busca la oficina en la base de datos y se activa el formu
            //si ha encontrado una oficina, rellena el formu con los datos.
			formu.getTfMatricula().setText(furgo.getMatricula());
            formu.getTfMarca().setText(furgo.getMarca());
            formu.getTfModelo().setText(furgo.getModelo());
            formu.getCbColor().setSelectedItem(furgo.getColor());
            formu.getDtFechaAlta().setDate(new java.util.Date(año, mes, dia));
            formu.getTfKms().setText(furgo.getKms()+"");
            formu.getCbOficina().setSelectedItem(furgo.getOficina());
            formu.getCbCateg().setSelectedItem(furgo.getCategoria());
            formu.getChckbxAlquilado().setSelected(furgo.isAlquilado());
            
            formu.getTfConsumo().setText(furgo.getConsumo()+"");
            formu.getTfPotencia().setText(furgo.getPotencia()+"");
            formu.getCbNivelEmision().setSelectedItem(furgo.getNivelEmison());
            
            formu.getCbTipoCarnet().setSelectedItem(furgo.getCarnetRequerido());
            formu.getTfCapacidadCarga().setText(furgo.getCapacidadCarga()+"");

		}else {
			 MetodosGUI.activPanel(panel);
			 formu.excepcionesActiva();
		}
	}
}
