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
		setMinimumSize(new Dimension(450, 250));
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
				tableOficina = MetodosOficina.creaRellenaTabOfi(RepositorioOficina.arrayListOficinas());
				scrollPane.setViewportView(tableOficina);
				
			    
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
		   						 //cambio el model por un model que contenga el nombre introducido en el jtext.
				    			    tableOficina.setModel(MetodosOficina.creaModelTabOfi(RepositorioOficina.arrayListOficinasPorNombre(tfEscriNombre.getText().toUpperCase())));
				    			    tableOficina.removeColumn(tableOficina.getColumnModel().getColumn(6));
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
			    				 //cambio el model por un model que contenga el nombre introducido en el jtext.
			    			    tableOficina.setModel(MetodosOficina.creaModelTabOfi(RepositorioOficina.arrayListOficinasPorNombre(tfEscriNombre.getText().toUpperCase())));
			    			    tableOficina.removeColumn(tableOficina.getColumnModel().getColumn(6));
			    			}
			    		});
			    		panelBuscador.add(btnLupa);
			    	}
			    	{
			    		JButton btnRecargar = new JButton("recargar");
			    		btnRecargar.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent e) {
			    				tableOficina.setModel(MetodosOficina.creaModelTabOfi(RepositorioOficina.arrayListOficinas()));
			    				tfEscriNombre.setText("");
			    				tableOficina.removeColumn(tableOficina.getColumnModel().getColumn(6));
			    			}
			    		});
			    		panelBuscador.add(btnRecargar);
			    	}
			    }
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
						elegido=null;
						elegido= (Oficina) MetodosGUI.cogerSeleccionado(tableOficina,6);
						if (elegido!=null) {
							listOfi.setVisible(false);			
							}
						}
				});
				btSeleccionar.setActionCommand("Cancel");
				buttonPane.add(btSeleccionar);
			}
			
			
			tableOficina.addMouseListener(new java.awt.event.MouseAdapter() {
			      public void mouseClicked(java.awt.event.MouseEvent e) {
				      if(e.getClickCount()==2){
				    		elegido=null;
							elegido= (Oficina) MetodosGUI.cogerSeleccionado(tableOficina,6);
							if (elegido!=null) {
								listOfi.setVisible(false);			
								} 
				      }
				      
		     	 }
			 });
		}
		
	}
	
}
