package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioOficina;
import entidades.Cliente;
import entidades.Oficina;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

public class VListado extends JDialog {

	private VListado listVentana;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object elegido;
	private int nColum;
	private JTextField tfContiene;
	private JTextField tfEmpiezaPor;
	private JPanel panelBuscador;
	private JButton btnSeleccionar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	
	
	//////////////////////////////////////////////
	//GETTERS Y SETTERS
	/////////////////////////////////////////////
	
	public VListado getListVentana() {
		return listVentana;
	}


	public JPanel getContentPanel() {
		return contentPanel;
	}


	public JTable getTable() {
		return table;
	}


	public Object getElegido() {
		return elegido;
	}

	public void setListVentana(VListado listVentana) {
		this.listVentana = listVentana;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public void setElegido(Object elegido) {
		this.elegido = elegido;
	}


	/////////////////crear model con los parametros ///// DefaultTableModel model 
	///////////////, ArrayList<Integer> anchuraColumnas
	
	public VListado(DatosTabla datos) {
		listVentana = this;
		setTitle("Listado");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\lista.png"));
		setModal(true);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		for (String a : datos.getNombreColumnas()){
			model.addColumn(a);
		}
		
		Object[] dato = new Object[model.getColumnCount()];
		int ancho=0;
		
		for (int i = 0; i<datos.getDatosTabla().length;i++) {
			for (int j = 0; j<model.getColumnCount();j++) {
				//meto el dato
				dato[j]= datos.getDatosTabla()[i][j];
				
			}
			//pongo la anchura min del esa colum
			table.getColumnModel().getColumn(i).setMinWidth(datos.getAnchuraColumnas().get(i));
			
			ancho=ancho+datos.getAnchuraColumnas().get(i);
			model.addRow(dato);
	    } 
		
		
		for (int i=0;i<model.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setMinWidth(datos.getAnchuraColumnas().get(i));
		
		}
		
		int minAlto = 250;
		int minAncho = 600;
		//ancho = ancho +50;
		
		if (ancho <minAncho) {
			ancho=minAncho;
		}
		
		this.setMinimumSize(new Dimension(ancho, minAlto));
		nColum = table.getModel().getColumnCount();
		
		setBounds(100, 100, ancho, minAlto);
		
		{

			{
				
			}
			
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				panelBuscador = new JPanel();
				panel.add(panelBuscador, BorderLayout.CENTER);
				panelBuscador.setLayout(null);
				
				JButton btSeleccionar = new JButton("");
				btSeleccionar.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\lupa.png"));
				btSeleccionar.setActionCommand("Cancel");
				btSeleccionar.setBounds(276, 34, 27, 28);
				panelBuscador.add(btSeleccionar);
				{
					tfEmpiezaPor = new JTextField();
					tfEmpiezaPor.setName("empiezaPor");
					tfEmpiezaPor.setBounds(104, 16, 156, 19);
					panelBuscador.add(tfEmpiezaPor);
					tfEmpiezaPor.setColumns(10);
				}
				
				JLabel lblNewLabel = new JLabel("Comienza por :");
				lblNewLabel.setBounds(9, 19, 70, 13);
				panelBuscador.add(lblNewLabel);
				
				JLabel lblContiene = new JLabel("Contiene :");
				lblContiene.setBounds(10, 43, 56, 13);
				panelBuscador.add(lblContiene);
				
				tfContiene = new JTextField();
				tfContiene.setName("contiene");
				tfContiene.setColumns(10);
				tfContiene.setBounds(104, 40, 156, 19);
				panelBuscador.add(tfContiene);
			}
			{
				JPanel panelBotones = new JPanel();
				panel.add(panelBotones, BorderLayout.EAST);
				panelBotones.setLayout(new MigLayout("", "[85px]", "[10][][21px]"));
				
				btnSeleccionar = new JButton("Seleccionar");
				btnSeleccionar.setName("seleccionar");
				panelBotones.add(btnSeleccionar, "cell 0 1,grow");
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setName("cancelar");
				panelBotones.add(btnCancelar, "cell 0 2,grow");
			}
		}
	   
		
		{
			
			table.addMouseListener(new java.awt.event.MouseAdapter() {
			      public void mouseClicked(java.awt.event.MouseEvent e) {
				      if(e.getClickCount()==2){
				    		elegido=null;
							elegido= MetodosGUI.cogerSeleccionado(table,nColum);
							if (elegido!=null) {
								listVentana.setVisible(false);			
								} 
				      }
				      
		     	 }
			 });
			
			
			table.removeColumn(table.getColumnModel().getColumn(nColum-1));
			//////////table.setUpdateSelectionOnSort(true);
		}
		
	}
}
