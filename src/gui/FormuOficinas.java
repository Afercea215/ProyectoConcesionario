package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acessoADatos.AccesoADatos;
import principal.Principal;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FormuOficinas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfCodigo;
	JComboBox cbLocalidad = new JComboBox();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public FormuOficinas() {
		setResizable(false);
		setModal(true);
		setTitle("Oficinas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\oficina.png"));
		setBounds(100, 100, 731, 469);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setBounds(10, 43, 56, 21);
			contentPanel.add(lblNombre);
		}
		
		tfNombre = new JTextField();
		tfNombre.setBounds(62, 44, 237, 21);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(30);
		
		JButton btnLupa = new JButton("");
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vListadoOficinas vListOfi = new vListadoOficinas();
				vListOfi.setLocationRelativeTo(VentanaPrincipal.fOfi);
				vListOfi.setVisible(true);
			}
		});
		btnLupa.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\lupa.png"));
		btnLupa.setBounds(128, 10, 32, 33);
		contentPanel.add(btnLupa);
		
		JLabel lblOficinaAeropuerto = new JLabel("Oficina de Aeropuerto");
		lblOficinaAeropuerto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOficinaAeropuerto.setBounds(10, 77, 129, 21);
		contentPanel.add(lblOficinaAeropuerto);
		
		JCheckBox chckbxOfiAeropuerto = new JCheckBox("");
		chckbxOfiAeropuerto.setBounds(145, 78, 93, 21);
		contentPanel.add(chckbxOfiAeropuerto);
		{
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCodigo.setBounds(10, 10, 56, 21);
			contentPanel.add(lblCodigo);
		}
		{
			tfCodigo = new JTextField();
			tfCodigo.setColumns(4);
			tfCodigo.setBounds(62, 10, 56, 21);
			contentPanel.add(tfCodigo);
		}
		{
			JLabel lblProvincia = new JLabel("Provincia ");
			lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblProvincia.setBounds(10, 108, 56, 21);
			contentPanel.add(lblProvincia);
		}
		
		
		
		JComboBox cbProvincia = new JComboBox<>(MetodosGUI.defaultCBModelProv());
		cbProvincia.setSelectedIndex(0);
		cbProvincia.setBounds(62, 108, 116, 21);
		contentPanel.add(cbProvincia);
		cbProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbLocalidad.setModel(MetodosGUI.defaultCBModelLoc(cbProvincia.getSelectedItem()+""));
			}
		});

		cbLocalidad.setModel(MetodosGUI.defaultCBModelLoc("ALBACETE"));
		cbLocalidad.setBounds(62, 141, 116, 21);
		contentPanel.add(cbLocalidad);
		
		JLabel lblLocalidad = new JLabel("Localidad ");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocalidad.setBounds(10, 141, 56, 21);
		contentPanel.add(lblLocalidad);
		
		this.setLocationRelativeTo(Principal.v);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btBorrar = new JButton("Borrar");
				btBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btBorrar.setVerticalAlignment(SwingConstants.BOTTOM);
				btBorrar.setActionCommand("OK");
				buttonPane.add(btBorrar);
			}
			{
				JButton btGrabar = new JButton("Grabar");
				btGrabar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btGrabar.setVerticalAlignment(SwingConstants.BOTTOM);
				btGrabar.setActionCommand("OK");
				buttonPane.add(btGrabar);
				getRootPane().setDefaultButton(btGrabar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cbProvincia.setSelectedIndex(0);
						tfNombre.setText("");
						tfCodigo.setText("");
						chckbxOfiAeropuerto.setSelected(false);
					}
				});
			}
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
		}
	}
}
