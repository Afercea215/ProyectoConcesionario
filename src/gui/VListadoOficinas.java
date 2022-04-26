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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import acessoADatos.RepositorioOficina;
import entidades.Oficina;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
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

public class VListadoOficinas extends JDialog {

	private VListadoOficinas listOfi;
	private final JPanel contentPanel = new JPanel();
	private JTable tableOficina;
	public Oficina elegido;
	private DefaultTableModel modelTabOfi;
	private DefaultTableModel modelTabOfiPorNombre;
	private JButton btnLupa;
	public JTextField tfEscriNombre;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VListadoOficinas(JDialog padre) {
		setMinimumSize(new Dimension(375, 250));
		listOfi = this;
		padre=(FormuOficinas) padre;
		setTitle("Listado Oficinas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\oficina.png"));
		setModal(true);
		setBounds(100, 100, 375, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				tableOficina = new JTable();
				scrollPane.setViewportView(tableOficina);
				
				modelTabOfi = new DefaultTableModel(){
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
			    modelTabOfi.addColumn("Objeto");
			    
			    tableOficina.setModel(modelTabOfi);
			    
			    for (Oficina a : RepositorioOficina.arrayListOficinas()) {
			    	modelTabOfi.addRow(new Object[] { a.getCod()+"", a.getDescripcion()+"", a.getProvincia()+"",a.getLocalidad()+"",a.isOfiAeropuerto()+"",a});
			    }
			    
			    tableOficina.removeColumn(tableOficina.getColumnModel().getColumn(5));
			    
			    //ordenar tabla
			    //ACTIVAMOS LA ORDENACION DE COLUMNAS
			    tableOficina.setAutoCreateRowSorter(true);
			    
			    //CREAMOS LOS SORTERS NECESARIOS DE LA TABLA OFI
			    TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableOficina.getModel());
			    tableOficina.setRowSorter(sorter);
			    
			    {
			    	JPanel panelBuscador = new JPanel();
			    	contentPanel.add(panelBuscador, BorderLayout.NORTH);
			    	panelBuscador.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			    	{
			    		JLabel lblBuscaNombre = new JLabel("Buscar por nombre");
			    		panelBuscador.add(lblBuscaNombre);
			    	}
			    	{
			    		tfEscriNombre = new JTextField();
			    		tfEscriNombre.addKeyListener(new KeyAdapter() {
			    			@Override
			    			public void keyPressed(KeyEvent e) {
		   					 if(e.getKeyCode()==KeyEvent.VK_ENTER){
				    				modelTabOfiPorNombre = new DefaultTableModel();
				    				
				    				modelTabOfiPorNombre.addColumn("COD");
				    				modelTabOfiPorNombre.addColumn("Descripicion");
				    				modelTabOfiPorNombre.addColumn("Provincia");
				    				modelTabOfiPorNombre.addColumn("Localidad");
				    			    modelTabOfiPorNombre.addColumn("Oficina Aeropuerto");
				    			    modelTabOfiPorNombre.addColumn("Objeto");
				    			    
				    			    for (Oficina a : RepositorioOficina.arrayListOficinasPorNombre(tfEscriNombre.getText().toUpperCase())) {
				    			    	modelTabOfiPorNombre.addRow(new Object[] { a.getCod()+"", a.getDescripcion()+"", a.getProvincia()+"",a.getLocalidad()+"",a.isOfiAeropuerto()+"",a});
				    			    }
				    			    tableOficina.setModel(modelTabOfiPorNombre);
			    			    	System.out.println(modelTabOfiPorNombre.getRowCount());
		   		              }
			    			}
			    		});
			    		tfEscriNombre.setColumns(10);
			    		panelBuscador.add(tfEscriNombre);
			    	}
			    	{
			    		btnLupa = new JButton("");
			    		btnLupa.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\lupa.png"));
			    		btnLupa.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent e) {

			    				modelTabOfiPorNombre = new DefaultTableModel();
			    				
			    				modelTabOfiPorNombre.addColumn("COD");
			    				modelTabOfiPorNombre.addColumn("Descripicion");
			    				modelTabOfiPorNombre.addColumn("Provincia");
			    				modelTabOfiPorNombre.addColumn("Localidad");
			    			    modelTabOfiPorNombre.addColumn("Oficina Aeropuerto");
			    			    modelTabOfiPorNombre.addColumn("Objeto");
			    			    
			    			    for (Oficina a : RepositorioOficina.arrayListOficinasPorNombre(tfEscriNombre.getText().toUpperCase())) {
			    			    	modelTabOfiPorNombre.addRow(new Object[] { a.getCod()+"", a.getDescripcion()+"", a.getProvincia()+"",a.getLocalidad()+"",a.isOfiAeropuerto()+"",a});
			    			    }
			    			    tableOficina.setModel(modelTabOfiPorNombre);
		    			    	System.out.println(modelTabOfiPorNombre.getRowCount());
			    			}
			    		});
			    		panelBuscador.add(btnLupa);
			    	}
			    	{
			    		JButton btnRecargar = new JButton("recargar");
			    		btnRecargar.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent e) {
			    				tableOficina.setModel(modelTabOfi);
			    			}
			    		});
			    		panelBuscador.add(btnRecargar);
			    	}
			    }
			    List<RowSorter.SortKey> sortKeys = new ArrayList<>();
			    
			    //ORDENAR LA TABLA POR DEFAULT, PRIMERO POR NOMBRE, PROV, LOC.
			    sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
			    sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
			    sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
			    
			    //AÑADIMOS LOS SORTKEYS DE LAS CULOM QUE QUERAMOS AL SORTER
			    sorter.setSortKeys(sortKeys);
			    sorter.sort();
			}
			
		}
	   
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btSeleccionar = new JButton("Seleccionar");
				btSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int fila = tableOficina.getSelectedRow();
						if(fila==-1) {
							JOptionPane.showMessageDialog(tableOficina, "Debe marcar una fila.","Error en la selección",JOptionPane.ERROR_MESSAGE);
						}else {
							elegido= (Oficina) modelTabOfi.getValueAt(fila,5);
							
							listOfi.setVisible(false);
						}
						
					}
				});
				btSeleccionar.setActionCommand("Cancel");
				buttonPane.add(btSeleccionar);
			}
		}
		
		
	}
	
}
