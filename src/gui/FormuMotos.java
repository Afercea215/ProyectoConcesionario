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

import accesoADatos.RepositorioCategoria;
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioMoto;
import entidades.Empleado;
import entidades.Moto;
import principal.Principal;
import javax.swing.JCheckBox;

public class FormuMotos extends JDialog {

	private FormuMotos fMoto=this;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfMarca;
	private JTextField tfMatricula;
	private JButton btGrabar;
	private JButton btBorrar;
	private JButton btnLupa;
	private JTextField tfModelo;
	private JComboBox cbOficina;
	private JDateChooser dtFechaAlta = new JDateChooser();
	private JButton btnCancel;
	private ArrayList<Component> excepciones = new ArrayList<Component>();
	private JTextField tfKms;
	private JTextField tfRecarga;
	private JTextField tfCilindrada;
	private JComboBox cbTipoCarnet;
	private JCheckBox chckbxAlquilado;
	private JTextField tfAutonomia;
	private JComboBox cbCateg;
	private JComboBox cbColor;

	
	
	/**
	 * Launch the application.
	 */
	
	//////////////////////////////////////////
	//GETTERS Y SETTERS
	//////////////////////////////////////////
	

	
	/**
	 * Create the dialog.
	 */
	public FormuMotos() {
		
		setResizable(false);
		setModal(true);
		setTitle("Motos");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/persona.png"));
		setBounds(100, 100, 491, 314);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		//CODIGO
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatricula.setBounds(10, 10, 56, 21);
		contentPanel.add(lblMatricula);
		
		
		tfMatricula = new JTextField();
		tfMatricula.setName("dni");
		tfMatricula.setColumns(4);
		tfMatricula.setBounds(72, 11, 67, 21);
		contentPanel.add(tfMatricula);
		tfMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//si se pulsa intro se verifica si el coodigo es valido
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					 MetodosMoto.rellenaPanelMoto(RepositorioMoto.buscaMoto(tfMatricula.getText()), fMoto);
					
					if (!tfMatricula.getText().equals("")) {
						MetodosGUI.activPanel(contentPanel);
						excepcionesActiva();
					}
	             }
			}
			
			//cuando escribe capamos que escriba valores que no sean numeros, intro o borrar. Tammbien cuango la long sea 0
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (tfMatricula.getText().length()==7)
				{
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		//NOMBRE
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(10, 43, 56, 21);
		contentPanel.add(lblMarca);
		
		tfMarca = new JTextField();
		tfMarca.setName("nombre");
		tfMarca.setBounds(72, 41, 156, 21);
		contentPanel.add(tfMarca);
		tfMarca.setColumns(30);
		
		//LUPA
		btnLupa = new JButton("");
		btnLupa.setName("lupa");
		btnLupa.setIcon(new ImageIcon("media/lupa.png"));
		btnLupa.setBounds(160, 11, 20, 21);
		contentPanel.add(btnLupa);
		
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListado vList = new VListado(MetodosMoto.creaDatosTabla());
				vList.setLocationRelativeTo(VentanaPrincipal.fMoto);
				vList.setVisible(true);
				Moto m = (Moto)vList.getElegido();
				vList.dispose();
				
				if (m!=null) {
					MetodosMoto.rellenaPanelMoto(m, fMoto);
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
						int n = JOptionPane.showConfirmDialog(fMoto, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Moto m = RepositorioMoto.buscaMoto(tfMatricula.getText());
							if (m!=null) {
								try {
									RepositorioMoto.borraMoto(m.getMatricula());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									MetodosGUI.mensajeErrorBorrado(fMoto);
								}
								MetodosGUI.vaciarPanel(contentPanel);
								MetodosGUI.desactPanel(contentPanel);
								excepcionesDesact();
							}else {
								JOptionPane.showMessageDialog(fMoto,"La moto que desea borrar no existe.");
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
							MetodosMoto.grabaMoto(fMoto);
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
			
			tfModelo = new JTextField();
			tfModelo.setName("modelo");
			tfModelo.setColumns(30);
			tfModelo.setBounds(72, 75, 156, 21);
			contentPanel.add(tfModelo);
			
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setName("");
			lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblModelo.setBounds(10, 74, 56, 21);
			contentPanel.add(lblModelo);
			
			JLabel lblColor = new JLabel("Color");
			lblColor.setName("");
			lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblColor.setBounds(11, 109, 56, 21);
			contentPanel.add(lblColor);
			
			cbOficina = MetodosOficina.comboBoxOficinas();
			cbOficina.setName("oficina");
			cbOficina.setBounds(72, 200, 156, 21);
			contentPanel.add(cbOficina);
		
			java.util.Date date;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
				dtFechaAlta.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dtFechaAlta.setName("fechaAlta");
			dtFechaAlta.setDateFormatString("dd/MM/YYYY");
			dtFechaAlta.setBounds(91, 140, 89, 19);
			contentPanel.add(dtFechaAlta);

			
			JLabel lblFechaAlta = new JLabel("Fecha de Alta");
			lblFechaAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaAlta.setBounds(10, 140, 127, 21);
			contentPanel.add(lblFechaAlta);
			
			JLabel lblOficina = new JLabel("Oficina");
			lblOficina.setName("");
			lblOficina.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblOficina.setBounds(10, 199, 56, 21);
			contentPanel.add(lblOficina);
			
			cbOficina.setSelectedIndex(0);
			
			MetodosGUI.desactPanel(contentPanel);
			
			
			cbColor = MetodosColores.comboBoxColores();
			cbColor.setBounds(72, 110, 139, 21);
			contentPanel.add(cbColor);
			cbColor.setSelectedIndex(0);
			
			tfKms = new JTextField();
			tfKms.setName("modelo");
			tfKms.setColumns(30);
			tfKms.setBounds(72, 170, 89, 21);
			contentPanel.add(tfKms);
			tfKms.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
			
			JLabel lblkms = new JLabel("Kms");
			lblkms.setName("");
			lblkms.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblkms.setBounds(10, 169, 56, 21);
			contentPanel.add(lblkms);
			
			
			cbCateg = MetodosCategoria.comboBoxColores();
			cbCateg.setSelectedIndex(0);
			cbCateg.setBounds(315, 9, 139, 21);
			contentPanel.add(cbCateg);
			
			JLabel lblCaet = new JLabel("Categoria");
			lblCaet.setName("");
			lblCaet.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCaet.setBounds(251, 11, 56, 21);
			contentPanel.add(lblCaet);
			
			JLabel lblAlqui = new JLabel("Alquilado");
			lblAlqui.setName("");
			lblAlqui.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblAlqui.setBounds(251, 43, 56, 21);
			contentPanel.add(lblAlqui);
			
			chckbxAlquilado = new JCheckBox("");
			chckbxAlquilado.setBounds(315, 42, 93, 21);
			contentPanel.add(chckbxAlquilado);
			
			tfAutonomia = new JTextField();
			tfAutonomia.setName("modelo");
			tfAutonomia.setColumns(30);
			tfAutonomia.setBounds(315, 74, 89, 21);
			contentPanel.add(tfAutonomia);
			tfAutonomia.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
			
			JLabel lblAutonomia = new JLabel("Autonomia");
			lblAutonomia.setName("");
			lblAutonomia.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblAutonomia.setBounds(251, 76, 89, 21);
			contentPanel.add(lblAutonomia);
			
			tfRecarga = new JTextField();
			tfRecarga.setName("modelo");
			tfRecarga.setColumns(30);
			tfRecarga.setBounds(348, 110, 89, 21);
			contentPanel.add(tfRecarga);
			tfRecarga.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
			
			JLabel lblTiempRecarga = new JLabel("Tiempo recarga");
			lblTiempRecarga.setName("");
			lblTiempRecarga.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTiempRecarga.setBounds(251, 108, 110, 21);
			contentPanel.add(lblTiempRecarga);
			
			tfCilindrada = new JTextField();
			tfCilindrada.setName("modelo");
			tfCilindrada.setColumns(30);
			tfCilindrada.setBounds(315, 139, 89, 21);
			contentPanel.add(tfCilindrada);
			tfCilindrada.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
			
			JLabel lblCilindrada = new JLabel("Cilindrada");
			lblCilindrada.setName("");
			lblCilindrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCilindrada.setBounds(251, 142, 110, 21);
			contentPanel.add(lblCilindrada);
			
			JLabel lblCarnet = new JLabel("TipoCarnet");
			lblCarnet.setName("");
			lblCarnet.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCarnet.setBounds(251, 172, 89, 21);
			contentPanel.add(lblCarnet);
			
			cbTipoCarnet = MetodosTipoCarnet.comboBoxColores();
			cbTipoCarnet.setSelectedIndex(0);
			cbTipoCarnet.setBounds(315, 170, 139, 21);
			contentPanel.add(cbTipoCarnet);
			
			MetodosGUI.desactPanel(contentPanel);
			excepcionesDesact();
	}

	public ArrayList<Component> getExcepciones() {
		return excepciones;
	}

	public void setExcepciones(ArrayList<Component> excepciones) {
		this.excepciones = excepciones;
	}

	public void excepcionesActiva () {
		tfMatricula.setEnabled(false);
		btnLupa.setEnabled(false);
		
		btGrabar.setEnabled(true);
		btBorrar.setEnabled(true);
	}
	
	public void excepcionesDesact () {
		tfMatricula.setEnabled(true);
		btnLupa.setEnabled(true);
		btnCancel.setEnabled(true);
		
		btGrabar.setEnabled(false);
		btBorrar.setEnabled(false);
	}

	public FormuMotos getfMoto() {
		return fMoto;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JTextField getTfMarca() {
		return tfMarca;
	}

	public JTextField getTfMatricula() {
		return tfMatricula;
	}

	public JButton getBtGrabar() {
		return btGrabar;
	}

	public JButton getBtBorrar() {
		return btBorrar;
	}

	public JButton getBtnLupa() {
		return btnLupa;
	}

	public JTextField getTfModelo() {
		return tfModelo;
	}

	public JComboBox getCbOficina() {
		return cbOficina;
	}

	public JDateChooser getDtFechaAlta() {
		return dtFechaAlta;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JTextField getTfKms() {
		return tfKms;
	}

	public JTextField getTfRecarga() {
		return tfRecarga;
	}

	public JTextField getTfCilindrada() {
		return tfCilindrada;
	}

	public JComboBox getCbTipoCarnet() {
		return cbTipoCarnet;
	}

	public JCheckBox getChckbxAlquilado() {
		return chckbxAlquilado;
	}

	public JTextField getTfAutonomia() {
		return tfAutonomia;
	}

	public JComboBox getCbCateg() {
		return cbCateg;
	}

	public JComboBox getCbColor() {
		return cbColor;
	}

	public void setfMoto(FormuMotos fMoto) {
		this.fMoto = fMoto;
	}

	public void setTfMarca(JTextField tfMarca) {
		this.tfMarca = tfMarca;
	}

	public void setTfMatricula(JTextField tfMatricula) {
		this.tfMatricula = tfMatricula;
	}

	public void setBtGrabar(JButton btGrabar) {
		this.btGrabar = btGrabar;
	}

	public void setBtBorrar(JButton btBorrar) {
		this.btBorrar = btBorrar;
	}

	public void setBtnLupa(JButton btnLupa) {
		this.btnLupa = btnLupa;
	}

	public void setTfModelo(JTextField tfModelo) {
		this.tfModelo = tfModelo;
	}

	public void setCbOficina(JComboBox cbOficina) {
		this.cbOficina = cbOficina;
	}

	public void setDtFechaAlta(JDateChooser dtFechaAlta) {
		this.dtFechaAlta = dtFechaAlta;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public void setTfKms(JTextField tfKms) {
		this.tfKms = tfKms;
	}

	public void setTfRecarga(JTextField tfRecarga) {
		this.tfRecarga = tfRecarga;
	}

	public void setTfCilindrada(JTextField tfCilindrada) {
		this.tfCilindrada = tfCilindrada;
	}

	public void setCbTipoCarnet(JComboBox cbTipoCarnet) {
		this.cbTipoCarnet = cbTipoCarnet;
	}

	public void setChckbxAlquilado(JCheckBox chckbxAlquilado) {
		this.chckbxAlquilado = chckbxAlquilado;
	}

	public void setTfAutonomia(JTextField tfAutonomia) {
		this.tfAutonomia = tfAutonomia;
	}

	public void setCbCateg(JComboBox cbCateg) {
		this.cbCateg = cbCateg;
	}


	public void setCbColor(JComboBox cbColor) {
		this.cbColor = cbColor;
	}

	

}
