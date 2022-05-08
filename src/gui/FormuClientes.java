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

import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioTipoCarnet;
import entidades.Cliente;
import entidades.Oficina;
import entidades.TipoCarnet;
import principal.Principal;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

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
	
	private ArrayList<Component> listaExcepDesact= new ArrayList<>();;
	
	
	/**
	 * Launch the application.
	 */
	
	//////////////////////////////////////////
	//GETTERS Y SETTERS
	//////////////////////////////////////////
	
	
	public FormuClientes getfCli() {
		return fCli;
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

	public void setfCli(FormuClientes fCli) {
		this.fCli = fCli;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public void setTfCodigo(JTextField tfCodigo) {
		this.tfDni = tfCodigo;
	}

	public void setBtGrabar(JButton btGrabar) {
		this.btGrabar = btGrabar;
	}

	public void setO(Cliente o) {
		this.cli = o;
	}

	public void setBtBorrar(JButton btBorrar) {
		this.btBorrar = btBorrar;
	}
	
	/**
	 * Create the dialog.
	 */
	public FormuClientes() {
		
		setResizable(false);
		setModal(true);
		setTitle("Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\persona.png"));
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
		tfDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//si se pulsa intro se verifica si el coodigo es valido
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					 
					btGrabar.setEnabled(true);
					btBorrar.setEnabled(true);
	                   
					//si la longitud es correcta  
					if (miLibreria.metodos.Validadores.validarLongitud(tfDni.getText(), 9) && miLibreria.metodos.Validadores.DNIvalido(tfDni.getText())) {
						//se busca la oficina en la base de datos y se activa el formu
						cli = RepositorioCliente.buscaCliente(tfDni.getText());
		                    
	                    MetodosGUI.activPanel(getContentPanel());
	                    tfDni.setEnabled(false);
	                    tfNombre.setFocusable(true);
	                    btnLupa.setEnabled(false);
	                    btBorrar.setEnabled(true);
	                    btGrabar.setEnabled(true);
	                    
	                    //si ha encontrado una oficina, rellena el formu con los datos.
	                    if (cli!=null) {
	                    	/////////////
	    					MetodosGUI.activPanel(getContentPanel());
	    					
	    					tfDni.setText(cli.getDni());
	    					tfNombre.setText(cli.getNombre());
	    					tfAp1.setText(cli.getAp1());
	    					tfAp2.setText(cli.getAp2());
	    					
	    					java.util.Date date;
	    					try {
	    						date = new SimpleDateFormat("dd/MM/yyyy").parse(cli.fechaNacString());
	    						dtFechaNac.setDate(date);
	    					} catch (ParseException e1) {
	    						// TODO Auto-generated catch block
	    						e1.printStackTrace();
	    					}
	    					
	    					cbTipoCarnet.setSelectedItem(cli.getCarnetConducir().getNombre()); 
	    					tfNTarjeta.setText(cli.getnTarjetaCliente());

	    					tfDni.setEnabled(false);
	    					btnLupa.setEnabled(false);
	    					
	    					btGrabar.setEnabled(true);
	    					btBorrar.setEnabled(true);
	                    }
	                    
					 } else {
							JOptionPane.showMessageDialog(fCli, "DNI incorrecto.","Error en la busqueda",JOptionPane.ERROR_MESSAGE);
							tfDni.setText("");
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
				if (tfNTarjeta.getText().length()==4)
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		//LUPA
		btnLupa = new JButton("");
		btnLupa.setName("lupa");
		btnLupa.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\lupa.png"));
		btnLupa.setBounds(160, 11, 20, 21);
		contentPanel.add(btnLupa);
		
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListado vListCli = new VListado(MetodosCliente.creaDatosTabla());
				vListCli.setLocationRelativeTo(VentanaPrincipal.fCli);
				vListCli.setVisible(true);
				cli = (Cliente)vListCli.getElegido();
				vListCli.dispose();
				
				//SI se a selecciomnao alguna fila, se rellena en el formulario.
				if(cli!=null){
					MetodosGUI.activPanel(getContentPanel());
					
					tfDni.setText(cli.getDni());
					tfNombre.setText(cli.getNombre());
					tfAp1.setText(cli.getAp1());
					tfAp2.setText(cli.getAp2());
					
					java.util.Date date;
					try {
						date = new SimpleDateFormat("dd/MM/yyyy").parse(cli.fechaNacString());
						dtFechaNac.setDate(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					cbTipoCarnet.setSelectedItem(cli.getCarnetConducir().getNombre()); 
					tfNTarjeta.setText(cli.getnTarjetaCliente());

					tfDni.setEnabled(false);
					btnLupa.setEnabled(false);
					
					btGrabar.setEnabled(true);
					btBorrar.setEnabled(true);
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
				btBorrar.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\borrar.png"));

				btBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int n = JOptionPane.showConfirmDialog(fCli, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Cliente cli = RepositorioCliente.buscaCliente(tfDni.getText());
							if (cli!=null) {
								RepositorioCliente.borraCliente(cli.getDni());
								MetodosGUI.vaciarPanel(getContentPanel());
								MetodosGUI.desactPanel(getContentPanel(), listaExcepDesact);
								
//								tfDni.setEnabled(true);
//								btnLupa.setEnabled(true);
//								
//								btGrabar.setEnabled(false);
//								btBorrar.setEnabled(false);
							}else {
								JOptionPane.showMessageDialog(fCli,"El empleado que desea borrar no existe.");
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
				btGrabar.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\guardar.png"));
				btGrabar.setFocusPainted(false);
				btGrabar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MetodosCliente.grabaCliente(getContentPanel());
						MetodosGUI.desactPanel(getContentPanel(), listaExcepDesact);
//						btnCancel.setEnabled(true);
//						btnLupa.setEnabled(true);
//						tfDni.setEnabled(true);
						
						//ggrasbar
						
					}
				});
				btGrabar.setVerticalAlignment(SwingConstants.BOTTOM);
				buttonPane.add(btGrabar);
			}
			{
				btnCancel = new JButton("");
				btnCancel.setName("cancelar");
				btnCancel.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\iconos\\cancel.png"));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
				
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MetodosGUI.vaciarPanel(getContentPanel());
						MetodosGUI.desactPanel(getContentPanel(), listaExcepDesact);
						tfDni.setEnabled(true);
						btnLupa.setEnabled(true);
//						btGrabar.setEnabled(false);
//						btBorrar.setEnabled(false);
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
			
			listaExcepDesact.add(tfDni);
			listaExcepDesact.add(btnCancel);
			listaExcepDesact.add(btnLupa);
			
			
			MetodosGUI.desactPanel(getContentPanel(), listaExcepDesact);
			btnLupa.setEnabled(true);
	}
}
