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
import java.util.Calendar;
import java.util.TimeZone;

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
import accesoADatos.RepositorioFurgoneta;
import accesoADatos.RepositorioMoto;
import entidades.Empleado;
import entidades.Furgoneta;
import entidades.Moto;
import principal.Principal;
import javax.swing.JCheckBox;


public class FormuFurgoneta extends JDialog {

	private FormuFurgoneta fFurgoneta=this;
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
	private JTextField tfKms;
	private JTextField tfPotencia;
	private JTextField tfCapacidadCarga;
	private JComboBox cbTipoCarnet;
	private JCheckBox chckbxAlquilado;
	private JTextField tfConsumo;
	private JComboBox cbCateg;
	private JComboBox cbColor;
	private JComboBox cbNivelEmision;

	
	
	/**
	 * Launch the application.
	 */
	
	//////////////////////////////////////////
	//GETTERS Y SETTERS
	//////////////////////////////////////////
	

	
	/**
	 * Create the dialog.
	 */
	public FormuFurgoneta() {
		
		setResizable(false);
		setModal(true);
		setTitle("Furgoneta");
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

		
		
		tfMatricula = new JTextField();
		tfMatricula.setName("dni");
		tfMatricula.setColumns(4);
		tfMatricula.setBounds(72, 11, 67, 21);
		tfMatricula.addKeyListener(new controladoresDeEventos.ControlaLongitud(7));
		tfMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//si se pulsa intro se verifica si el coodigo es valido
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					
					 MetodosFurgoneta.rellenaPanelFurgoneta(RepositorioFurgoneta.buscaFurgoneta(tfMatricula.getText()), fFurgoneta);
					
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

		
		tfMarca = new JTextField();
		tfMarca.setName("nombre");
		tfMarca.setBounds(72, 41, 156, 21);

		tfMarca.setColumns(30);
		
		//LUPA
		btnLupa = new JButton("");
		btnLupa.setName("lupa");
		btnLupa.setIcon(new ImageIcon("media/lupa.png"));
		btnLupa.setBounds(160, 11, 20, 21);

		
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListado vList = new VListado(MetodosFurgoneta.creaDatosTabla(),true);
				vList.setLocationRelativeTo(VentanaPrincipal.fFurgoneta);
				vList.setVisible(true);
				Furgoneta coche = (Furgoneta)vList.getElegido();

				System.out.println(coche.getFechaAlta().get(Calendar.YEAR)+" s, ");
				
				vList.dispose();
				
				if (coche!=null) {
					MetodosFurgoneta.rellenaPanelFurgoneta(coche, fFurgoneta);
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
						int n = JOptionPane.showConfirmDialog(fFurgoneta, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Furgoneta coche = RepositorioFurgoneta.buscaFurgoneta(tfMatricula.getText());
							if (coche!=null) {
								try {
									RepositorioFurgoneta.borraFurgoneta(tfMatricula.getText());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									MetodosGUI.mensajeErrorBorrado(fFurgoneta);
								}
								MetodosGUI.vaciarPanel(contentPanel);
								MetodosGUI.desactPanel(contentPanel);
								excepcionesDesact();
							}else {
								JOptionPane.showMessageDialog(fFurgoneta,"El coche combustion que desea borrar no existe.");
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
							MetodosFurgoneta.grabaFurgoneta(fFurgoneta);
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

			
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setName("");
			lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblModelo.setBounds(10, 74, 56, 21);

			
			JLabel lblColor = new JLabel("Color");
			lblColor.setName("");
			lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblColor.setBounds(11, 109, 56, 21);

			
			cbOficina = MetodosOficina.comboBoxOficinas();
			cbOficina.setName("oficina");
			cbOficina.setBounds(72, 200, 156, 21);

		
			java.util.Date date;
			
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


			
			JLabel lblFechaAlta = new JLabel("Fecha de Alta");
			lblFechaAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaAlta.setBounds(10, 140, 127, 21);
			
			
			JLabel lblOficina = new JLabel("Oficina");
			lblOficina.setName("");
			lblOficina.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblOficina.setBounds(10, 199, 56, 21);
			
			
			cbOficina.setSelectedIndex(0);
			
			MetodosGUI.desactPanel(contentPanel);
			
			
			cbColor = MetodosColores.comboBoxColores();
			cbColor.setBounds(72, 110, 139, 21);
			
			cbColor.setSelectedIndex(0);
			
			tfKms = new JTextField();
			tfKms.setName("modelo");
			tfKms.setColumns(30);
			tfKms.setBounds(72, 170, 89, 21);
			
			tfKms.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
			
			JLabel lblkms = new JLabel("Kms");
			lblkms.setName("");
			lblkms.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblkms.setBounds(10, 169, 56, 21);
			
			
			
			cbCateg = MetodosCategoria.comboBoxColores();
			cbCateg.setSelectedIndex(0);
			cbCateg.setBounds(315, 9, 139, 21);
			
			
			JLabel lblCaet = new JLabel("Categoria");
			lblCaet.setName("");
			lblCaet.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCaet.setBounds(251, 11, 56, 21);
			
			
			JLabel lblAlqui = new JLabel("Alquilado");
			lblAlqui.setName("");
			lblAlqui.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblAlqui.setBounds(251, 43, 56, 21);
			
			
			chckbxAlquilado = new JCheckBox("");
			chckbxAlquilado.setBounds(315, 42, 93, 21);
			
			
			tfConsumo = new JTextField();
			tfConsumo.setName("modelo");
			tfConsumo.setColumns(30);
			tfConsumo.setBounds(315, 74, 89, 21);
			
			tfConsumo.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
			
			JLabel lblConsumo = new JLabel("Consumo");
			lblConsumo.setName("");
			lblConsumo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblConsumo.setBounds(251, 76, 89, 21);
			
			
			tfPotencia = new JTextField();
			tfPotencia.setName("modelo");
			tfPotencia.setColumns(30);
			tfPotencia.setBounds(315, 109, 89, 21);

			tfPotencia.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
			
			JLabel lblPotencia = new JLabel("Potencia");
			lblPotencia.setName("");
			lblPotencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPotencia.setBounds(251, 108, 110, 21);

			
			tfCapacidadCarga = new JTextField();
			tfCapacidadCarga.setName("modelo");
			tfCapacidadCarga.setColumns(30);
			tfCapacidadCarga.setBounds(348, 171, 89, 21);
			tfCapacidadCarga.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
			
			JLabel lblCapacidadCarga = new JLabel("Capacidad Carga");
			lblCapacidadCarga.setName("");
			lblCapacidadCarga.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCapacidadCarga.setBounds(251, 171, 110, 21);
			
			MetodosGUI.desactPanel(contentPanel);
			
			JLabel lblTipoCarnet = new JLabel("Tipo Carnet");
			lblTipoCarnet.setName("");
			lblTipoCarnet.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipoCarnet.setBounds(251, 199, 110, 21);

			JLabel lblTipoEmision = new JLabel("Nivel Emision");
			lblTipoEmision.setName("");
			lblTipoEmision.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipoEmision.setBounds(251, 140, 110, 21);
			contentPanel.add(lblTipoEmision);
			
			cbNivelEmision = MetodosNivelEmision.comboBoxNivelEmision();
			cbNivelEmision.setBounds(315, 141, 121, 21);

			cbTipoCarnet = MetodosTipoCarnet.comboBoxTipoCarnet();
			cbTipoCarnet.setBounds(315, 200, 89, 21);
			
			contentPanel.add(lblPotencia);
			contentPanel.add(tfConsumo);
			contentPanel.add(chckbxAlquilado);
			contentPanel.add(lblAlqui);
			contentPanel.add(lblCaet);
			contentPanel.add(cbCateg);
			contentPanel.add(lblkms);
			contentPanel.add(tfKms);
			contentPanel.add(cbColor);
			contentPanel.add(lblOficina);
			contentPanel.add(lblFechaAlta);
			contentPanel.add(dtFechaAlta);
			contentPanel.add(cbOficina);
			contentPanel.add(lblColor);
			contentPanel.add(lblModelo);
			contentPanel.add(tfModelo);
			contentPanel.add(btnLupa);
			contentPanel.add(tfMarca);
			contentPanel.add(lblMarca);
			contentPanel.add(tfMatricula);
			contentPanel.add(lblMatricula);
			contentPanel.add(lblTipoCarnet);
			contentPanel.add(lblCapacidadCarga);
			contentPanel.add(tfPotencia);
			contentPanel.add(lblConsumo);
			contentPanel.add(tfCapacidadCarga);
			contentPanel.add(cbTipoCarnet);
			contentPanel.add(cbNivelEmision);
			

			MetodosGUI.desactPanel(contentPanel);
			excepcionesDesact();
	}

	public JTextField getTfCapacidadCarga() {
		return tfCapacidadCarga;
	}

	public void setTfCapacidadCarga(JTextField tfCapacidadCarga) {
		this.tfCapacidadCarga = tfCapacidadCarga;
	}

	public JComboBox getcbTipoCarnet() {
		return cbTipoCarnet;
	}

	public void setcbTipoCarnet(JComboBox cbTipoCarnet) {
		this.cbTipoCarnet = cbTipoCarnet;
	}

	public JTextField getTfPotencia() {
		return tfPotencia;
	}

	public JTextField getTfConsumo() {
		return tfConsumo;
	}

	public JComboBox getCbNivelEmision() {
		return cbNivelEmision;
	}

	public void setTfPotencia(JTextField tfPotencia) {
		this.tfPotencia = tfPotencia;
	}

	public void setTfConsumo(JTextField tfConsumo) {
		this.tfConsumo = tfConsumo;
	}

	public void setCbNivelEmision(JComboBox cbNivelEmision) {
		this.cbNivelEmision = cbNivelEmision;
	}

	public JTextField getTfNPlazas() {
		return tfCapacidadCarga;
	}

	public void setTfNPlazas(JTextField tfNPlazas) {
		this.tfCapacidadCarga = tfNPlazas;
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

	public FormuFurgoneta getfFurgoneta() {
		return fFurgoneta;
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
		return tfPotencia;
	}

	public JTextField getTfCilindrada() {
		return tfCapacidadCarga;
	}

	public JComboBox getCbTipoCarnet() {
		return cbTipoCarnet;
	}

	public JCheckBox getChckbxAlquilado() {
		return chckbxAlquilado;
	}

	public JTextField getTfAutonomia() {
		return tfConsumo;
	}

	public JComboBox getCbCateg() {
		return cbCateg;
	}

	public JComboBox getCbColor() {
		return cbColor;
	}

	public void setfFurgoneta(FormuFurgoneta fFurgoneta) {
		this.fFurgoneta = fFurgoneta;
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
		this.tfPotencia = tfRecarga;
	}

	public void setTfCilindrada(JTextField tfCilindrada) {
		this.tfCapacidadCarga = tfCilindrada;
	}

	public void setCbTipoCarnet(JComboBox cbTipoCarnet) {
		this.cbTipoCarnet = cbTipoCarnet;
	}

	public void setChckbxAlquilado(JCheckBox chckbxAlquilado) {
		this.chckbxAlquilado = chckbxAlquilado;
	}

	public void setTfAutonomia(JTextField tfAutonomia) {
		this.tfConsumo = tfAutonomia;
	}

	public void setCbCateg(JComboBox cbCateg) {
		this.cbCateg = cbCateg;
	}


	public void setCbColor(JComboBox cbColor) {
		this.cbColor = cbColor;
	}
}
