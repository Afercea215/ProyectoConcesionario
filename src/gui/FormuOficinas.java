package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acessoADatos.AccesoADatos;
import acessoADatos.RepositorioOficina;
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

public class FormuOficinas extends JDialog {

	private FormuOficinas fOfi=this;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfCodigo;
	private JButton btGrabar;
	private JComboBox cbLocalidad = new JComboBox();
	private JComboBox cbProvincia;
	private JCheckBox chckbxOfiAeropuerto;
	private Oficina o;
	private JButton btBorrar;
	private JButton btnLupa;
	private JScrollPane scrollPane;

	
	/**
	 * Launch the application.
	 */
	
	//////////////////////////////////////////
	//GETTERS Y SETTERS
	//////////////////////////////////////////
	
	
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

	public Oficina getO() {
		return o;
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

	public void setO(Oficina o) {
		this.o = o;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\oficina.png"));
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
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//si se pulsa intro se verifica si el coodigo es valido
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					 
					btGrabar.setEnabled(true);
					btBorrar.setEnabled(true);
	                   
					//si la longitud es correcta  
					if (miLibreria.metodos.Validadores.validarLongitud(tfCodigo.getText(), 4)) {
						//se busca la oficina en la base de datos y se activa el formu
						o = RepositorioOficina.buscaOficina(tfCodigo.getText());
		                    
	                    MetodosGUI.activPanel(contentPanel);
	                    tfCodigo.setEnabled(false);
	                    tfNombre.setFocusable(true);
	                    btnLupa.setEnabled(false);
	                    btBorrar.setEnabled(true);
	                    btGrabar.setEnabled(true);
	                    
	                    //si ha encontrado una oficina, rellena el formu con los datos.
	                    if (o!=null) {
	                    	
		                    tfNombre.setText(o.getDescripcion());
		                    chckbxOfiAeropuerto.setSelected(o.isOfiAeropuerto());
		                    cbProvincia.setSelectedItem(o.getProvincia());
		                    cbLocalidad.setSelectedItem(o.getLocalidad());
	                    }
	                    
					 } else {
							JOptionPane.showMessageDialog(fOfi, "Longitud del código incorrecta, debe ser de 4 digitos.","Error en la busqueda",JOptionPane.ERROR_MESSAGE);
							tfCodigo.setText("");
					 }
	             }
			}
			
			//cuando escribe capamos que escriba valores que no sean numeros, intro o borrar. Tammbien cuango la long sea 0
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE||c==KeyEvent.VK_ENTER||tfCodigo.getText().length()==4)
				{
					getToolkit().beep();
					e.consume();
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
		btnLupa.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\lupa.png"));
		btnLupa.setBounds(118, 10, 20, 21);
		contentPanel.add(btnLupa);
		
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListadoOficinas vListOfi = new VListadoOficinas(fOfi);
				vListOfi.setLocationRelativeTo(VentanaPrincipal.fOfi);
				vListOfi.setVisible(true);
				o = vListOfi.elegido;
				vListOfi.dispose();
				
				//SI se a selecciomnao alguna fila, se rellena en el formulario.
				if(o!=null){
					MetodosGUI.activPanel(contentPanel);
					
					tfCodigo.setText(o.getCod());
					tfNombre.setText(o.getDescripcion());
					chckbxOfiAeropuerto.setSelected(o.isOfiAeropuerto());
					cbProvincia.setSelectedItem(o.getProvincia().toUpperCase());
					cbLocalidad.setSelectedItem(o.getLocalidad().toUpperCase());
					tfCodigo.setEnabled(false);
					btnLupa.setEnabled(false);
					
					btGrabar.setEnabled(true);
					btBorrar.setEnabled(true);
				}
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
		
		
		//OBSERVACIONES
		JTextArea taObservaciones = new JTextArea();
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
				btBorrar.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\borrar.png"));
				btBorrar.setEnabled(false);
				
				btBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int n = JOptionPane.showConfirmDialog(fOfi, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Oficina o = RepositorioOficina.buscaOficina(tfCodigo.getText());
							if (o!=null) {
								RepositorioOficina.borraOficina(o.getCod());
								MetodosGUI.vaciarPanel(contentPanel);
								MetodosGUI.desactPanel(contentPanel);
								
								tfCodigo.setEnabled(true);
								btnLupa.setEnabled(true);
								
								btGrabar.setEnabled(false);
								btBorrar.setEnabled(false);
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
				btGrabar.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\guardar.png"));
				btGrabar.setFocusPainted(false);
				btGrabar.setEnabled(false);
				btGrabar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MetodosOficina.grabaOficina(contentPanel);
						//ggrasbar
						
					}
				});
				btGrabar.setVerticalAlignment(SwingConstants.BOTTOM);
				buttonPane.add(btGrabar);
			}
			{
				JButton cancelButton = new JButton("");
				cancelButton.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\cancel.png"));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MetodosGUI.vaciarPanel(contentPanel);
						MetodosGUI.desactPanel(contentPanel);
						tfCodigo.setEnabled(true);
						btnLupa.setEnabled(true);
						btGrabar.setEnabled(false);
						btBorrar.setEnabled(false);
					}
				});
			}
		}
		{
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
		}	
			
				
			MetodosGUI.desactPanel(contentPanel);
			tfCodigo.setEnabled(true);
			btnLupa.setEnabled(true);
				
			scrollPane = new JScrollPane();
			scrollPane.setBounds(319, 44, 312, 141);
			contentPanel.add(scrollPane);
			
		
			
			
		
	}
}
