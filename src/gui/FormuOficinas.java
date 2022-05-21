
package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Oficina;
import principal.Principal;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import accesoADatos.*;
import controladoresDeEventos.SoloAdmiteNumeros;

public class FormuOficinas extends JDialog {

	private FormuOficinas fOfi=this;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfCodigo;
	private JButton btGrabar;
	private JComboBox cbLocalidad = new JComboBox();
	private JComboBox cbProvincia;
	private JCheckBox chckbxOfiAeropuerto;
	private JButton btBorrar;
	private JButton btnLupa;
	private JScrollPane scrollPane;
	private JTextArea taObservaciones;
	private JButton btnCancel;
	private ArrayList<Component> lista = new ArrayList<Component>();


	public ArrayList<Component> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Component> lista) {
		this.lista = lista;
	}

	
	public JTextArea getTaObservaciones() {
		return taObservaciones;
	}

	public void setTaObservaciones(JTextArea taObservaciones) {
		this.taObservaciones = taObservaciones;
	}
	
	public FormuOficinas getfOfi() {
		return fOfi;
	}

	public JButton getBtnLupa() {
		return btnLupa;
	}

	public void setBtnLupa(JButton btnLupa) {
		this.btnLupa = btnLupa;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public JTextField getTfCodigo() {
		return tfCodigo;
	}

	public JButton getBtGrabar() {
		return btGrabar;
	}

	public JComboBox getCbLocalidad() {
		return cbLocalidad;
	}

	public JComboBox getCbProvincia() {
		return cbProvincia;
	}

	public JCheckBox getChckbxOfiAeropuerto() {
		return chckbxOfiAeropuerto;
	}


	public JButton getBtBorrar() {
		return btBorrar;
	}

	public void setfOfi(FormuOficinas fOfi) {
		this.fOfi = fOfi;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public void setTfCodigo(JTextField tfCodigo) {
		this.tfCodigo = tfCodigo;
	}

	public void setBtGrabar(JButton btGrabar) {
		this.btGrabar = btGrabar;
	}

	public void setCbLocalidad(JComboBox cbLocalidad) {
		this.cbLocalidad = cbLocalidad;
	}

	public void setCbProvincia(JComboBox cbProvincia) {
		this.cbProvincia = cbProvincia;
	}

	public void setChckbxOfiAeropuerto(JCheckBox chckbxOfiAeropuerto) {
		this.chckbxOfiAeropuerto = chckbxOfiAeropuerto;
	}


	public void setBtBorrar(JButton btBorrar) {
		this.btBorrar = btBorrar;
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	/**
	 * Create the dialog.
	 */
	public FormuOficinas() {
		
		setResizable(false);
		setModal(true);
		setTitle("Oficinas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/oficina.png"));
		setBounds(100, 100, 695, 316);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//CODIGO
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(10, 10, 56, 21);
		contentPanel.add(lblCodigo);
		
		
		tfCodigo = new JTextField();
		tfCodigo.setName("codigo");
		tfCodigo.setColumns(4);
		tfCodigo.setBounds(62, 10, 44, 21);
		contentPanel.add(tfCodigo);
		tfCodigo.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
		tfCodigo.addKeyListener(new controladoresDeEventos.ControlaLongitud(4));
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//si se pulsa intro se verifica si el coodigo es valido
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					MetodosOficina.rellenaPanelOfi(RepositorioOficina.buscaOficina(tfCodigo.getText()), fOfi);
					
					MetodosGUI.activPanel(contentPanel);
					excepcionesActiva();
	             }
			}
		});
		
		
		//NOMBRE
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 43, 56, 21);
		contentPanel.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setName("nombre");
		tfNombre.setBounds(62, 44, 237, 21);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(30);
		
		
		//LUPA
		btnLupa = new JButton("");
		btnLupa.setName("lupa");
		btnLupa.setIcon(new ImageIcon("media/lupa.png"));
		btnLupa.setBounds(118, 10, 20, 21);
		contentPanel.add(btnLupa);
		
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListado vListOfi = new VListado(MetodosOficina.creaDatosTabla());
				vListOfi.setLocationRelativeTo(VentanaPrincipal.fOfi);
				vListOfi.setVisible(true);
				Oficina o = (Oficina)vListOfi.getElegido();
				vListOfi.dispose();
				
				MetodosOficina.rellenaPanelOfi(o, fOfi);
				MetodosGUI.activPanel(contentPanel);
				excepcionesActiva();
			}
		});
		
			
		//OFIAEROPUERTO
		JLabel lblOficinaAeropuerto = new JLabel("Oficina de Aeropuerto");
		lblOficinaAeropuerto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOficinaAeropuerto.setBounds(10, 77, 129, 21);
		contentPanel.add(lblOficinaAeropuerto);
		
		chckbxOfiAeropuerto = new JCheckBox("");
		chckbxOfiAeropuerto.setName("aeropuerto");
		chckbxOfiAeropuerto.setBounds(145, 78, 93, 21);
		contentPanel.add(chckbxOfiAeropuerto);

		
		//PROVINCIIA
		JLabel lblProvincia = new JLabel("Provincia ");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProvincia.setBounds(10, 108, 56, 21);
		contentPanel.add(lblProvincia);
		
		////////////////////////////////////////////////
		cbProvincia = new JComboBox<>(MetodosGUI.defaultCBModelProv());
		cbProvincia.setSelectedIndex(0);
		cbProvincia.setBounds(62, 108, 116, 21);
		contentPanel.add(cbProvincia);
		cbProvincia.setName("provincia");
		
		cbProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				cbLocalidad.setModel(MetodosGUI.defaultCBModelLoc(cbProvincia.getSelectedItem()+""));
			}
		});
		
		
		
		//LOCALIDAD
		cbLocalidad.setModel(MetodosGUI.defaultCBModelLoc("ALBACETE"));
		cbLocalidad.setBounds(62, 141, 116, 21);
		contentPanel.add(cbLocalidad);
		cbLocalidad.setName("localidad");
		
		JLabel lblLocalidad = new JLabel("Localidad ");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocalidad.setBounds(10, 141, 56, 21);
		contentPanel.add(lblLocalidad);
		
		
		////////
		scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 44, 312, 141);
		contentPanel.add(scrollPane);
		
		//OBSERVACIONES
		taObservaciones = new JTextArea();
		taObservaciones.setEnabled(false);
		scrollPane.setViewportView(taObservaciones);
		taObservaciones.setRows(5);
		taObservaciones.setName("observaciones");
		
		JLabel lblObservaciones = new JLabel("Observaciones :");
		lblObservaciones.setBounds(320, 12, 93, 16);
		contentPanel.add(lblObservaciones);
		
		
		//POSICION RELATIVA
		this.setLocationRelativeTo(Principal.v);
		
		//PANEL ABAJO
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btBorrar = new JButton("");
				btBorrar.setIcon(new ImageIcon("media/borrar.png"));
				btBorrar.setEnabled(false);
				
				btBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int n = JOptionPane.showConfirmDialog(fOfi, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Oficina o = RepositorioOficina.buscaOficina(tfCodigo.getText());
							if (o!=null) {
								try {
									RepositorioOficina.borraOficina(o.getCod());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									MetodosGUI.mensajeErrorBorrado(fOfi);
								}
								MetodosGUI.vaciarPanel(contentPanel);
								MetodosGUI.desactPanel(contentPanel);
								excepcionesDesact();
							}else {
								JOptionPane.showMessageDialog(fOfi,"La oficina que desea borrar no existe.");
							}
						}
					}
				});
				btBorrar.setVerticalAlignment(SwingConstants.BOTTOM);
				btBorrar.setActionCommand("OK");
				buttonPane.add(btBorrar);
			}
			{
				btGrabar = new JButton("");
				btGrabar.setIcon(new ImageIcon("media/guardar.png"));
				btGrabar.setFocusPainted(false);
				btGrabar.setEnabled(false);
				btGrabar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							MetodosOficina.grabaOficina(fOfi);				
						}
				});
				btGrabar.setVerticalAlignment(SwingConstants.BOTTOM);
				buttonPane.add(btGrabar);
			}
			{
				btnCancel = new JButton("");
				btnCancel.setIcon(new ImageIcon("media/cancel.png"));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
				
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MetodosGUI.vaciarPanel(contentPanel);
						MetodosGUI.desactPanel(contentPanel);
						excepcionesDesact();
					}
				});
			}
		}
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		MetodosGUI.desactPanel(contentPanel);
		excepcionesDesact();
		
		lista.add(taObservaciones);
	}
	
	public void excepcionesActiva () {
		tfCodigo.setEnabled(false);
		btnLupa.setEnabled(false);
		
		btGrabar.setEnabled(true);
		btBorrar.setEnabled(true);
	}
	
	public void excepcionesDesact () {
		tfCodigo.setEnabled(true);
		btnLupa.setEnabled(true);
		btnCancel.setEnabled(true);
		
		btGrabar.setEnabled(false);
		btBorrar.setEnabled(false);
	}
}
