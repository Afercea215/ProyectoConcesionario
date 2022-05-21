package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioTipoCarnet;
import entidades.Cliente;
import entidades.Empleado;
import entidades.TipoCarnet;
import principal.Principal;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FormuEmpleados extends JDialog {

	private FormuEmpleados fEmple=this;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfDni;
	private JButton btGrabar;
	private Empleado emple;
	private JButton btBorrar;
	private JButton btnLupa;
	private JTextField tfAp1 = new JTextField();
	private JTextField tfAp2 = new JTextField();
	private JComboBox cbOficina;
	private JDateChooser dtFechaNac = new JDateChooser();
	private JDateChooser dtFechaAlta = new JDateChooser();
	private JButton btnCancel;
	private ArrayList<Component> excepciones = new ArrayList<Component>();

	
	
	/**
	 * Launch the application.
	 */
	
	//////////////////////////////////////////
	//GETTERS Y SETTERS
	//////////////////////////////////////////
	

	
	/**
	 * Create the dialog.
	 */
	public FormuEmpleados() {
		
		setResizable(false);
		setModal(true);
		setTitle("Empleados");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/persona.png"));
		setBounds(100, 100, 273, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		//CODIGO
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDNI.setBounds(10, 10, 56, 21);
		contentPanel.add(lblDNI);
		
		
		tfDni = new JTextField();
		tfDni.setName("dni");
		tfDni.setColumns(4);
		tfDni.setBounds(72, 11, 67, 21);
		contentPanel.add(tfDni);
		tfDni.addKeyListener(new controladoresDeEventos.ControlaLongitud(9));
		tfDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//si se pulsa intro se verifica si el coodigo es valido
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					 MetodosEmpleado.rellenaPanelEmple(RepositorioEmpleado.buscaEmpleado(tfDni.getText()), fEmple);
					
					if (!tfDni.getText().equals("")) {
						MetodosGUI.activPanel(contentPanel);
						excepcionesActiva();
					}
	             }
			}
			
			//cuando escribe capamos que escriba valores que no sean numeros, intro o borrar. Tammbien cuango la long sea 0
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (tfDni.getText().length()==9)
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
		tfNombre.setBounds(72, 41, 156, 21);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(30);
		
		//LUPA
		btnLupa = new JButton("");
		btnLupa.setName("lupa");
		btnLupa.setIcon(new ImageIcon("media/lupa.png"));
		btnLupa.setBounds(160, 11, 20, 21);
		contentPanel.add(btnLupa);
		
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListado vList = new VListado(MetodosEmpleado.creaDatosTabla());
				vList.setLocationRelativeTo(VentanaPrincipal.fEmple);
				vList.setVisible(true);
				Empleado em = (Empleado)vList.getElegido();
				vList.dispose();
				
				if (em!=null) {
					MetodosEmpleado.rellenaPanelEmple(em, fEmple);
					MetodosGUI.activPanel(contentPanel);
					excepcionesActiva();
				}
			}
		});
		
		
		//POSICION RELATIVA
		this.setLocationRelativeTo(Principal.v);
		
		//PANEL ABAJO
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btBorrar = new JButton("");
				btBorrar.setName("borrar");
				btBorrar.setIcon(new ImageIcon("media/borrar.png"));

				btBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int n = JOptionPane.showConfirmDialog(fEmple, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Empleado em = RepositorioEmpleado.buscaEmpleado(tfDni.getText());
							if (em!=null) {
								try {
									RepositorioEmpleado.borraEmpleado(em.getDni());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									MetodosGUI.mensajeErrorBorrado(fEmple);
								}
								MetodosGUI.vaciarPanel(contentPanel);
								MetodosGUI.desactPanel(contentPanel);
								excepcionesDesact();
							}else {
								JOptionPane.showMessageDialog(fEmple,"El empleado que desea borrar no existe.");
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
				btGrabar.setName("grabar");
				btGrabar.setIcon(new ImageIcon("media/guardar.png"));
				btGrabar.setFocusPainted(false);
				btGrabar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (dtFechaAlta.getDate().before(dtFechaNac.getDate())) {
							JOptionPane.showMessageDialog(fEmple, "La fecha de alta debe ser mayor a la de nacimiento.","Error.",JOptionPane.ERROR_MESSAGE);
							dtFechaAlta.setDate(dtFechaNac.getDate());
						} else {
							MetodosEmpleado.grabaEmpleado(fEmple);
						}
					}
				});
				btGrabar.setVerticalAlignment(SwingConstants.BOTTOM);
				buttonPane.add(btGrabar);
			}
			{
				btnCancel = new JButton("");
				btnCancel.setName("cancelar");
				btnCancel.setIcon(new ImageIcon("media/cancel.png"));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
				
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MetodosGUI.vaciarPanel(getContentPanel());
						MetodosGUI.desactPanel(getContentPanel());
						excepcionesDesact();
					}
				});
			}
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
		}	
			
				
		
			
			tfAp1 = new JTextField();
			tfAp1.setName("ap1");
			tfAp1.setColumns(30);
			tfAp1.setBounds(72, 75, 156, 21);
			contentPanel.add(tfAp1);
			
			tfAp2 = new JTextField();
			tfAp2.setName("ap2");
			tfAp2.setColumns(30);
			tfAp2.setBounds(72, 110, 156, 21);
			contentPanel.add(tfAp2);
			
			JLabel lblAp1 = new JLabel("Apellido 1");
			lblAp1.setName("");
			lblAp1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblAp1.setBounds(10, 74, 56, 21);
			contentPanel.add(lblAp1);
			
			JLabel lblApellido2 = new JLabel("Apellido 2");
			lblApellido2.setName("");
			lblApellido2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblApellido2.setBounds(11, 109, 56, 21);
			contentPanel.add(lblApellido2);
			
			JLabel lblFecha = new JLabel("Fecha de nacimiento");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFecha.setBounds(10, 141, 127, 21);
			contentPanel.add(lblFecha);
			
			cbOficina = MetodosOficina.comboBoxOficinas();
			cbOficina.setName("oficina");
			cbOficina.setBounds(72, 200, 156, 21);
			contentPanel.add(cbOficina);
		
			java.util.Date date;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
				dtFechaNac.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dtFechaNac.setName("fechaNac");
			dtFechaNac.setDateFormatString("dd/MM/YYYY");
			dtFechaNac.setBounds(139, 143, 89, 19);
			contentPanel.add(dtFechaNac);

			
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
				dtFechaAlta.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dtFechaAlta.setName("fechaAlta");
			dtFechaAlta.setDateFormatString("dd/MM/YYYY");
			dtFechaAlta.setBounds(139, 172, 89, 19);
			contentPanel.add(dtFechaAlta);

			
			JLabel lblFechaAlta = new JLabel("Fecha de Alta");
			lblFechaAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaAlta.setBounds(10, 168, 127, 21);
			contentPanel.add(lblFechaAlta);
			
			JLabel lblOficina = new JLabel("Oficina");
			lblOficina.setName("");
			lblOficina.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblOficina.setBounds(10, 199, 56, 21);
			contentPanel.add(lblOficina);
			
			cbOficina.setSelectedIndex(0);
			
			MetodosGUI.desactPanel(contentPanel);
			excepcionesDesact();
			
			excepciones.add(tfAp2);
	}

	public ArrayList<Component> getExcepciones() {
		return excepciones;
	}

	public void setExcepciones(ArrayList<Component> excepciones) {
		this.excepciones = excepciones;
	}

	public void excepcionesActiva () {
		tfDni.setEnabled(false);
		btnLupa.setEnabled(false);
		
		btGrabar.setEnabled(true);
		btBorrar.setEnabled(true);
	}
	
	public void excepcionesDesact () {
		tfDni.setEnabled(true);
		btnLupa.setEnabled(true);
		btnCancel.setEnabled(true);
		
		btGrabar.setEnabled(false);
		btBorrar.setEnabled(false);
	}



	public FormuEmpleados getfEmple() {
		return fEmple;
	}



	public JPanel getContentPanel() {
		return contentPanel;
	}



	public JTextField getTfNombre() {
		return tfNombre;
	}



	public JTextField getTfDni() {
		return tfDni;
	}



	public JButton getBtGrabar() {
		return btGrabar;
	}



	public Empleado getEmple() {
		return emple;
	}



	public JButton getBtBorrar() {
		return btBorrar;
	}



	public JButton getBtnLupa() {
		return btnLupa;
	}



	public JTextField getTfAp1() {
		return tfAp1;
	}



	public JTextField getTfAp2() {
		return tfAp2;
	}



	public JComboBox getCbOficina() {
		return cbOficina;
	}



	public JDateChooser getDtFechaNac() {
		return dtFechaNac;
	}



	public JDateChooser getDtFechaAlta() {
		return dtFechaAlta;
	}



	public JButton getBtnCancel() {
		return btnCancel;
	}


	public void setfEmple(FormuEmpleados fEmple) {
		this.fEmple = fEmple;
	}



	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}



	public void setTfDni(JTextField tfDni) {
		this.tfDni = tfDni;
	}



	public void setBtGrabar(JButton btGrabar) {
		this.btGrabar = btGrabar;
	}



	public void setEmple(Empleado emple) {
		this.emple = emple;
	}



	public void setBtBorrar(JButton btBorrar) {
		this.btBorrar = btBorrar;
	}



	public void setBtnLupa(JButton btnLupa) {
		this.btnLupa = btnLupa;
	}



	public void setTfAp1(JTextField tfAp1) {
		this.tfAp1 = tfAp1;
	}



	public void setTfAp2(JTextField tfAp2) {
		this.tfAp2 = tfAp2;
	}



	public void setCbOficina(JComboBox cbOficina) {
		this.cbOficina = cbOficina;
	}



	public void setDtFechaNac(JDateChooser dtFechaNac) {
		this.dtFechaNac = dtFechaNac;
	}



	public void setDtFechaAlta(JDateChooser dtFechaAlta) {
		this.dtFechaAlta = dtFechaAlta;
	}



	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

}
