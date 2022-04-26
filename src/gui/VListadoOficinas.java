package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import acessoADatos.RepositorioOficina;
import entidades.Oficina;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class vListadoOficinas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableOficina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			vListadoOficinas dialog = new vListadoOficinas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public vListadoOficinas() {
		setTitle("Listado Oficinas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\oficina.png"));
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				tableOficina = new JTable();
				scrollPane.setViewportView(tableOficina);
				
				
				DefaultTableModel model = new DefaultTableModel();
			    
				model.addColumn("COD");
			    model.addColumn("Descripicion");
			    model.addColumn("Provincia");
			    model.addColumn("Localidad");
			    model.addColumn("Oficina Aeropuerto");
			    model.addColumn("Objeto");
			    
			    tableOficina.setModel(model);
			    
			    for (Oficina a : RepositorioOficina.arrayListOficinas()) {
			    	System.out.println(a);
			    	model.addRow(new Object[] { a.getCod()+"", a.getDescripcion()+"", a.getProvincia()+"",a.getLocalidad()+"",a.isOfiAeropuerto()+"",a});
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
					}
				});
				btSeleccionar.setActionCommand("Cancel");
				buttonPane.add(btSeleccionar);
			}
		}
	}
	
	

}
