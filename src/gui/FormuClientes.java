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
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import principal.Principal;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioTipoCarnet;
import controladoresDeEventos.ControlaLongitud;
import controladoresDeEventos.SoloAdmiteNumeros;
import entidades.Cliente;
import entidades.Oficina;
import entidades.TipoCarnet;

public class FormuClientes extends JDialog {

	private FormuClientes fCli=this;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfDni;
	private JButton btGrabar;
	private Cliente cli;
	private JButton btBorrar;
	private JButton btnLupa;
	private JTextField tfAp1 = new JTextField();
	private JTextField tfAp2 = new JTextField();
	private JComboBox cbTipoCarnet;
	private JDateChooser dtFechaNac = new JDateChooser();
	private JButton btnCancel;
	private JTextField tfNTarjeta;
	private ArrayList<Component> excepciones = new ArrayList<Component>();
	
	public ArrayList<Component> getExcepciones() {
		return excepciones;
	}

	public void setExcepciones(ArrayList<Component> excepciones) {
		this.excepciones = excepciones;
	}

	/**
	 * Create the dialog.
	 */
	public FormuClientes() {
		
		setResizable(false);
		setModal(true);
		setTitle("Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/persona.png"));
		setBounds(100, 100, 273, 375);
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
					MetodosCliente.rellenaPanelCli(RepositorioCliente.buscaCliente(tfDni.getText()), fCli);
					if (!tfDni.getText().equals("")) {
						MetodosGUI.activPanel(contentPanel);
						excepcionesActiva();
					}
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
		
		tfNTarjeta = new JTextField();
		tfNTarjeta.setName("tarjeta");
		tfNTarjeta.setBounds(72, 218, 56, 19);
		contentPanel.add(tfNTarjeta);
		tfNTarjeta.setColumns(10);
		
		tfNTarjeta.addKeyListener(new KeyAdapter() {
			//cuando escribe capamos que escriba valores que no sean numeros, intro o borrar. Tammbien cuango la long sea 0
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE||c==KeyEvent.VK_ENTER||tfNTarjeta.getText().length()==4)
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		//LUPA
		btnLupa = new JButton("");
		btnLupa.setName("lupa");
		btnLupa.setIcon(new ImageIcon("media/lupa.png"));
		btnLupa.setBounds(160, 11, 20, 21);
		contentPanel.add(btnLupa);
		
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListado vList = new VListado(MetodosCliente.creaDatosTabla(),true);
				vList.setLocationRelativeTo(VentanaPrincipal.fCli);
				vList.setVisible(true);
				Cliente c = (Cliente)vList.getElegido();
				vList.dispose();
				
				if (c!=null) {
					MetodosCliente.rellenaPanelCli(c, fCli);
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
						int n = JOptionPane.showConfirmDialog(fCli, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Cliente c = RepositorioCliente.buscaCliente(tfDni.getText());
							if (c!=null) {
								try {
									RepositorioCliente.borraCliente(c.getDni());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									MetodosGUI.mensajeErrorBorrado(fCli);
								}
								MetodosGUI.vaciarPanel(contentPanel);
								MetodosGUI.desactPanel(contentPanel);
								excepcionesDesact();
							}else {
								JOptionPane.showMessageDialog(fCli,"El cliente que desea borrar no existe.");
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
						MetodosCliente.grabaCliente(fCli);
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
						MetodosGUI.vaciarPanel(contentPanel);
						MetodosGUI.desactPanel(contentPanel);
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
			lblFecha.setBounds(10, 182, 127, 21);
			contentPanel.add(lblFecha);
			
			JLabel lblTipoDeCarnet = new JLabel("Tipo de carnet");
			lblTipoDeCarnet.setName("ap1");
			lblTipoDeCarnet.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipoDeCarnet.setBounds(10, 146, 93, 21);
			contentPanel.add(lblTipoDeCarnet);
			
			cbTipoCarnet = new JComboBox();
			cbTipoCarnet.setName("tipoCarnet");
			cbTipoCarnet.setBounds(104, 146, 76, 21);
			contentPanel.add(cbTipoCarnet);
			
			//////////////////pasar a metodos TipoCarnet
			for (TipoCarnet t : RepositorioTipoCarnet.arrayListTipoCarnets()) {
				cbTipoCarnet.addItem(t.getNombre());
			}
			
			java.util.Date date;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
				dtFechaNac.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dtFechaNac.setName("fechaNac");
			dtFechaNac.setDateFormatString("dd/MM/yyyy");
			dtFechaNac.setBounds(134, 182, 89, 19);
			contentPanel.add(dtFechaNac);
			
			JLabel lblNTarjeta = new JLabel("nTarjeta");
			lblNTarjeta.setName("");
			lblNTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNTarjeta.setBounds(12, 216, 56, 21);
			contentPanel.add(lblNTarjeta);
			
			cbTipoCarnet.setSelectedIndex(0);
			
			MetodosGUI.desactPanel(contentPanel);
			excepcionesDesact();
			
			excepciones.add(tfAp2);
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
	

	public FormuClientes getfCli() {
		return fCli;
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


	public Cliente getCli() {
		return cli;
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


	public JComboBox getCbTipoCarnet() {
		return cbTipoCarnet;
	}


	public JDateChooser getDtFechaNac() {
		return dtFechaNac;
	}


	public JButton getBtnCancel() {
		return btnCancel;
	}


	public JTextField getTfNTarjeta() {
		return tfNTarjeta;
	}


	public void setfCli(FormuClientes fCli) {
		this.fCli = fCli;
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


	public void setCli(Cliente cli) {
		this.cli = cli;
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


	public void setCbTipoCarnet(JComboBox cbTipoCarnet) {
		this.cbTipoCarnet = cbTipoCarnet;
	}


	public void setDtFechaNac(JDateChooser dtFechaNac) {
		this.dtFechaNac = dtFechaNac;
	}


	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}


	public void setTfNTarjeta(JTextField tfNTarjeta) {
		this.tfNTarjeta = tfNTarjeta;
	}

}
