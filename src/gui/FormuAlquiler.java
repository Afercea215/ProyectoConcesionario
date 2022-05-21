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
import java.util.Date;
import java.util.GregorianCalendar;

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

import accesoADatos.RepositorioAlquiler;
import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioCocheCombustion;
import accesoADatos.RepositorioCocheElectrico;
import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioFurgoneta;
import accesoADatos.RepositorioMoto;
import accesoADatos.RepositorioTipoCarnet;
import controladoresDeEventos.ControlaLongitud;
import controladoresDeEventos.NoPermiteEscribir;
import controladoresDeEventos.SoloAdmiteNumeros;
import entidades.Alquiler;
import entidades.Cliente;
import entidades.CocheCombustion;
import entidades.CocheElectrico;
import entidades.Empleado;
import entidades.Furgoneta;
import entidades.Moto;
import entidades.Oficina;
import entidades.TipoCarnet;
import principal.Principal;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import org.jdatepicker.JDatePicker;

public class FormuAlquiler extends JDialog {

	private FormuAlquiler fAlqui=this;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigo;
	private JButton btGrabar;
	private Alquiler alqui;
	private JButton btBorrar;
	private JButton btnLupa;
	private JButton btnCancel;
	private ArrayList<Component> excepciones = new ArrayList<Component>();
	private JTextField tfEmple;
	private JTextField tfCliente;
	private JTextField tfPrecioPrevisto;
	private JComboBox cbTipoVehiculo;
	private JTextField tfVehiculo;
	private JButton btnLupaVehiculo;
	private JComboBox cbOfiIni;
	private JComboBox cbOfiFin;
	private JButton btnLupaEmple;
	private JButton btnLupaCliente;
	private JDatePicker dpIni;
	private JDatePicker dpFin;

	
	
	/**
	 * Launch the application.
	 */
	
	//////////////////////////////////////////
	//GETTERS Y SETTERS
	//////////////////////////////////////////
	

	
	/**
	 * Create the dialog.
	 */
	public FormuAlquiler() {
		
		setResizable(false);
		setModal(true);
		setTitle("Alquiler");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/persona.png"));
		setBounds(100, 100, 517, 261);
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
		tfCodigo.setName("cod");
		tfCodigo.setColumns(4);
		tfCodigo.setBounds(72, 10, 67, 21);
		contentPanel.add(tfCodigo);
		tfCodigo.addKeyListener(new controladoresDeEventos.ControlaLongitud(4));
		tfCodigo.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//si se pulsa intro se verifica si el coodigo es valido
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					 MetodosAlquiler.rellenaPanelAlqui(RepositorioAlquiler.buscaAlquiler(tfCodigo.getText()), fAlqui);
					if (!tfCodigo.getText().equals("")) {
						MetodosGUI.activPanel(contentPanel);
						excepcionesActiva();
					}
	             } 
			}
		});
		//LUPA
		btnLupa = new JButton("");
		btnLupa.setName("lupa");
		btnLupa.setIcon(new ImageIcon("media/lupa.png"));
		btnLupa.setBounds(160, 10, 20, 21);
		contentPanel.add(btnLupa);
		
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListado vList = new VListado(MetodosAlquiler.creaDatosTabla());
				vList.setLocationRelativeTo(VentanaPrincipal.fAlqui);
				vList.setVisible(true);
				Alquiler a = (Alquiler)vList.getElegido();
				vList.dispose();
				
				if (a!=null) {
					MetodosAlquiler.rellenaPanelAlqui(a, fAlqui);
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
						int n = JOptionPane.showConfirmDialog(fAlqui, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Alquiler a = RepositorioAlquiler.buscaAlquiler(tfCodigo.getText());
							if (a!=null) {
								try {
									RepositorioAlquiler.borraAlquiler(a.getId());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									MetodosGUI.mensajeErrorBorrado(fAlqui);
								}
								MetodosGUI.vaciarPanel(contentPanel);
								MetodosGUI.desactPanel(contentPanel);
								excepcionesDesact();
							}else {
								JOptionPane.showMessageDialog(fAlqui,"El empleado que desea borrar no existe.");
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
						System.out.println(dpFin.getModel().getDay());
						MetodosAlquiler.grabaAlquiler(fAlqui);
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
			
			JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo");
			lblTipoVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipoVehiculo.setBounds(10, 41, 100, 21);
			contentPanel.add(lblTipoVehiculo);
			
			cbTipoVehiculo = MetodosTipoVehiculo.comboBoxTipoVehiculo();
			cbTipoVehiculo.setSelectedIndex(0);
			cbTipoVehiculo.setBounds(99, 41, 81, 21);
			contentPanel.add(cbTipoVehiculo);
			cbTipoVehiculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfVehiculo.setText("");
				}
			});
			
			JLabel lblVehiculo = new JLabel("Vehiculo");
			lblVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblVehiculo.setBounds(10, 75, 56, 21);
			contentPanel.add(lblVehiculo);
			
			tfVehiculo = new JTextField();
			tfVehiculo.setName("dni");
			tfVehiculo.setEnabled(true);
			tfVehiculo.setColumns(4);
			tfVehiculo.setBounds(72, 75, 67, 21);
			contentPanel.add(tfVehiculo);
			
			btnLupaVehiculo = new JButton("");
			btnLupa.setIcon(new ImageIcon("media/lupa.png"));
			btnLupaVehiculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rellenaMatricula();
				}
			});
			btnLupaVehiculo.setName("lupa");
			btnLupaVehiculo.setEnabled(true);
			btnLupaVehiculo.setBounds(160, 75, 20, 21);
			contentPanel.add(btnLupaVehiculo);
			
			JLabel lblOfiIni = new JLabel("Oficina inicio alquiler");
			lblOfiIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblOfiIni.setBounds(10, 106, 129, 21);
			contentPanel.add(lblOfiIni);
			
			cbOfiIni = MetodosOficina.comboBoxOficinas();

	
			cbOfiIni.setBounds(125, 106, 81, 21);
			contentPanel.add(cbOfiIni);
			
			JLabel lblOfiFin = new JLabel("Oficina inicio alquiler");
			lblOfiFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblOfiFin.setBounds(10, 141, 129, 21);
			contentPanel.add(lblOfiFin);
			
			cbOfiFin = MetodosOficina.comboBoxOficinas();
			cbOfiFin.setBounds(125, 141, 81, 21);
			contentPanel.add(cbOfiFin);
			
			JLabel lblEmple = new JLabel("Empleado");
			lblEmple.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEmple.setBounds(245, 75, 56, 21);
			contentPanel.add(lblEmple);
			
			tfEmple = new JTextField();
			tfEmple.setName("dni");
			tfEmple.setEnabled(true);
			tfEmple.setColumns(4);
			tfEmple.setBounds(307, 75, 67, 21);
			tfEmple.addKeyListener(new ControlaLongitud(9));
			contentPanel.add(tfEmple);
			
			btnLupaEmple = new JButton("");
			btnLupaEmple.setIcon(new ImageIcon("media/lupa.png"));
			btnLupaEmple.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VListado vList = new VListado(MetodosEmpleado.creaDatosTablaDeOfi( ((Oficina) cbOfiIni.getSelectedItem()).getCod()) );
					vList.setLocationRelativeTo(VentanaPrincipal.fAlqui);
					vList.setVisible(true);
					Empleado a = (Empleado)vList.getElegido();
					vList.dispose();
					
					if (a!=null) {
						tfEmple.setText(a.getDni());
					}
				}
			});
			btnLupaEmple.setName("lupa");
			btnLupaEmple.setEnabled(true);
			btnLupaEmple.setBounds(395, 75, 20, 21);
			contentPanel.add(btnLupaEmple);
			
			JLabel lblCliente = new JLabel("Cliente");
			lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCliente.setBounds(245, 106, 56, 21);
			contentPanel.add(lblCliente);
			
			tfCliente = new JTextField();
			tfCliente.setName("dni");
			tfCliente.setEnabled(true);
			tfCliente.setColumns(4);
			tfCliente.setBounds(307, 106, 67, 21);
			contentPanel.add(tfCliente);
			tfCliente.addKeyListener(new ControlaLongitud(9));
			
			btnLupaCliente = new JButton("");
			btnLupaCliente.setIcon(new ImageIcon("media/lupa.png"));
			btnLupaCliente.setName("lupa");
			btnLupaCliente.setEnabled(true);
			btnLupaCliente.setBounds(395, 106, 20, 21);
			contentPanel.add(btnLupaCliente);
			btnLupaCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VListado vList = new VListado(MetodosCliente.creaDatosTabla());
					vList.setLocationRelativeTo(VentanaPrincipal.fAlqui);
					vList.setVisible(true);
					Cliente a = (Cliente)vList.getElegido();
					vList.dispose();
					
					if (a!=null) {
						tfCliente.setText(a.getDni());
					}
					
					if ((cbTipoVehiculo.getSelectedItem()+"").equals("Moto")) {
						Moto moto = RepositorioMoto.buscaMoto(tfVehiculo.getText());
						if (!comparaCarnet(moto.getCarnetRequerido(), a.getCarnetConducir())) {
							JOptionPane.showMessageDialog(fAlqui, "El cliente debe de tener un Carnet valido para el vehiculo seleccionado.","Error.",JOptionPane.ERROR_MESSAGE);
							tfCliente.setText("");
						}
					}
					if ((cbTipoVehiculo.getSelectedItem()+"").equals("Furgoneta")) {
						Furgoneta furgo = RepositorioFurgoneta.buscaFurgoneta(tfVehiculo.getText());
						if (!comparaCarnet(furgo.getCarnetRequerido(), a.getCarnetConducir())) {
							JOptionPane.showMessageDialog(fAlqui, "El cliente debe de tener un Carnet valido para el vehiculo seleccionado.","Error.",JOptionPane.ERROR_MESSAGE);
							tfCliente.setText("");
						}
					}
					if ((cbTipoVehiculo.getSelectedItem()+"").equals("Coche Electrico")) {
						if (!comparaCarnet(new TipoCarnet("B", "Coches"), a.getCarnetConducir())) {
							JOptionPane.showMessageDialog(fAlqui, "El cliente debe de tener un Carnet valido para el vehiculo seleccionado.","Error.",JOptionPane.ERROR_MESSAGE);
							tfCliente.setText("");
						}
					}
					if ((cbTipoVehiculo.getSelectedItem()+"").equals("Coche Combustion")) {
						if (!comparaCarnet(new TipoCarnet("B", "Coches"), a.getCarnetConducir())) {
							JOptionPane.showMessageDialog(fAlqui, "El cliente debe de tener un Carnet valido para el vehiculo seleccionado.","Error.",JOptionPane.ERROR_MESSAGE);
							tfCliente.setText("");
						}
					}
				}
			});
			
			JLabel lblPrecioPrevisto = new JLabel("Precio Previsto");
			lblPrecioPrevisto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPrecioPrevisto.setBounds(245, 141, 89, 21);
			contentPanel.add(lblPrecioPrevisto);
			
			tfPrecioPrevisto = new JTextField();
			tfPrecioPrevisto.setName("dni");
			tfPrecioPrevisto.setEnabled(true);
			tfPrecioPrevisto.setColumns(4);
			tfPrecioPrevisto.setBounds(337, 141, 67, 21);
			tfPrecioPrevisto.addKeyListener(new NoPermiteEscribir());
			
			JLabel lblFechaIni = new JLabel("Fecha inicio alquiler");
			lblFechaIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaIni.setBounds(245, 10, 127, 21);
			contentPanel.add(lblFechaIni);
			
			java.util.Date date;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			

			
			JLabel lblFechaAlta = new JLabel("Fecha fin alquiler");
			lblFechaAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaAlta.setBounds(245, 41, 127, 21);
			contentPanel.add(lblFechaAlta);

			cbOfiIni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfEmple.setText("");
				}
			});
			
			
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			contentPanel.add(tfPrecioPrevisto);
			
			JButton btnCalcula = new JButton("Calcula");
			btnCalcula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GregorianCalendar fIni = new GregorianCalendar(dpIni.getModel().getYear(), dpIni.getModel().getMonth()+1, dpIni.getModel().getDay());
					GregorianCalendar fFin = new GregorianCalendar(dpFin.getModel().getYear(), dpFin.getModel().getMonth()+1, dpFin.getModel().getDay());
					
					if (!tfVehiculo.getText().equals("") && !tfEmple.getText().equals("") && !tfCliente.getText().equals("")) {
						if ((cbTipoVehiculo.getSelectedItem()+"").equals("Moto")) {
							Moto moto = RepositorioMoto.buscaMoto(tfVehiculo.getText());
							tfPrecioPrevisto.setText(metodos.Especificos.calculaAlquiler(fIni, fFin, moto)+"");
						}
						if ((cbTipoVehiculo.getSelectedItem()+"").equals("Furgoneta")) {
							Furgoneta furgo = RepositorioFurgoneta.buscaFurgoneta(tfVehiculo.getText());
							tfPrecioPrevisto.setText(metodos.Especificos.calculaAlquiler(fIni, fFin, furgo)+"");
						}
						if ((cbTipoVehiculo.getSelectedItem()+"").equals("Coche Electrico")) {
							CocheElectrico coche = RepositorioCocheElectrico.buscaCocheElectrico(tfVehiculo.getText());
							tfPrecioPrevisto.setText(metodos.Especificos.calculaAlquiler(fIni, fFin, coche)+"");
						}
						if ((cbTipoVehiculo.getSelectedItem()+"").equals("Coche Combustion")) {
							CocheCombustion coche = RepositorioCocheCombustion.buscaCocheCombustion(tfVehiculo.getText());
							tfPrecioPrevisto.setText(metodos.Especificos.calculaAlquiler(fIni, fFin, coche)+"");
						}
					} else JOptionPane.showMessageDialog(fAlqui, "Debe de rellenar todos lo campos.","Error.",JOptionPane.ERROR_MESSAGE);
				}
			});
			
			MetodosGUI.desactPanel(contentPanel);
			btnCalcula.setBounds(414, 142, 67, 21);
			contentPanel.add(btnCalcula);
			
			dpIni = new JDatePicker();
			dpIni.getModel().setSelected(true);
			
			
//			dpIni.getModel().setDay(27);
//			dpIni.getModel().setMonth(5);
//			dpIni.getModel().setYear(2022);
			dpIni.setBounds(364, 10, 129, 21);
			contentPanel.add(dpIni);
			
			dpFin = new JDatePicker();
//			dpFin.getModel().setDay(28);
//			dpFin.getModel().setMonth(5);
//			dpFin.getModel().setYear(2022);
			dpFin.getModel().setSelected(true);
			dpFin.getFormattedTextField().addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					dpFin.updateUI();
					dpIni.updateUI();
					
					Date fFin = new Date(dpFin.getModel().getYear(), dpFin.getModel().getMonth()+1, dpFin.getModel().getDay());
					Date fIni = new Date(dpIni.getModel().getYear(), dpIni.getModel().getMonth()+1, dpIni.getModel().getDay());
					
						if (fFin.before(fIni)){
							JOptionPane.showMessageDialog(fAlqui, "La fecha de fina debe ser mayor a la de inicio.","Error.",JOptionPane.ERROR_MESSAGE);
							dpFin.getModel().setDay(dpIni.getModel().getDay()+1);
							dpFin.getModel().setMonth(dpIni.getModel().getMonth());
							dpFin.getModel().setYear(dpIni.getModel().getYear());
						}
					
					
				}
			});
			dpFin.setBounds(364, 40, 129, 21);
			contentPanel.add(dpFin);

			excepcionesDesact();
	}

	public Alquiler getAlqui() {
		return alqui;
	}

	public JDatePicker getDpIni() {
		return dpIni;
	}

	public JDatePicker getDpFin() {
		return dpFin;
	}

	public void setAlqui(Alquiler alqui) {
		this.alqui = alqui;
	}


	public void setDpIni(JDatePicker dpIni) {
		this.dpIni = dpIni;
	}

	public void setDpFin(JDatePicker dpFin) {
		this.dpFin = dpFin;
	}

	public ArrayList<Component> getExcepciones() {
		return excepciones;
	}

	public void setExcepciones(ArrayList<Component> excepciones) {
		this.excepciones = excepciones;
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



	public FormuAlquiler getfAlqui() {
		return fAlqui;
	}



	public JPanel getContentPanel() {
		return contentPanel;
	}

	public JTextField getTfDni() {
		return tfCodigo;
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


	public JButton getBtnCancel() {
		return btnCancel;
	}


	public void setfAlqui(FormuAlquiler fAlqui) {
		this.fAlqui = fAlqui;
	}

	public void setTfDni(JTextField tfDni) {
		this.tfCodigo = tfDni;
	}



	public void setBtGrabar(JButton btGrabar) {
		this.btGrabar = btGrabar;
	}

	public void setBtBorrar(JButton btBorrar) {
		this.btBorrar = btBorrar;
	}



	public JTextField getTfCodigo() {
		return tfCodigo;
	}

	public JTextField getTfEmple() {
		return tfEmple;
	}

	public JTextField getTfCliente() {
		return tfCliente;
	}

	public JTextField getTfPrecioPrevisto() {
		return tfPrecioPrevisto;
	}

	public JComboBox getCbTipoVehiculo() {
		return cbTipoVehiculo;
	}

	public JTextField getTfVehiculo() {
		return tfVehiculo;
	}

	public JButton getBtnLupaVehiculo() {
		return btnLupaVehiculo;
	}

	public JComboBox getCbOfiIni() {
		return cbOfiIni;
	}

	public JComboBox getCbOfiFin() {
		return cbOfiFin;
	}

	public JButton getBtnLupaEmple() {
		return btnLupaEmple;
	}

	public JButton getBtnLupaCliente() {
		return btnLupaCliente;
	}

	public void setTfCodigo(JTextField tfCodigo) {
		this.tfCodigo = tfCodigo;
	}

	public void setTfEmple(JTextField tfEmple) {
		this.tfEmple = tfEmple;
	}

	public void setTfCliente(JTextField tfCliente) {
		this.tfCliente = tfCliente;
	}

	public void setTfPrecioPrevisto(JTextField tfPrecioPrevisto) {
		this.tfPrecioPrevisto = tfPrecioPrevisto;
	}

	public void setCbTipoVehiculo(JComboBox cbTipoVehiculo) {
		this.cbTipoVehiculo = cbTipoVehiculo;
	}

	public void setTfVehiculo(JTextField tfVehiculo) {
		this.tfVehiculo = tfVehiculo;
	}

	public void setBtnLupaVehiculo(JButton btnLupaVehiculo) {
		this.btnLupaVehiculo = btnLupaVehiculo;
	}

	public void setCbOfiIni(JComboBox cbOfiIni) {
		this.cbOfiIni = cbOfiIni;
	}

	public void setCbOfiFin(JComboBox cbOfiFin) {
		this.cbOfiFin = cbOfiFin;
	}

	public void setBtnLupaEmple(JButton btnLupaEmple) {
		this.btnLupaEmple = btnLupaEmple;
	}

	public void setBtnLupaCliente(JButton btnLupaCliente) {
		this.btnLupaCliente = btnLupaCliente;
	}

	public void setBtnLupa(JButton btnLupa) {
		this.btnLupa = btnLupa;
	}


	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}
	
	private void rellenaMatricula () {
		String selec=cbTipoVehiculo.getSelectedItem()+"";
		if (selec.equalsIgnoreCase("Moto")) {
			VListado vList = new VListado(MetodosMoto.creaDatosTabla());
			vList.setLocationRelativeTo(VentanaPrincipal.fAlqui);
			vList.setVisible(true);
			Moto m = (Moto)vList.getElegido();
			vList.dispose();
			
			if (m!=null) {
				tfVehiculo.setText(m.getMatricula());
			}
		} else if (selec.equalsIgnoreCase("Furgoneta")) {
			VListado vList = new VListado(MetodosFurgoneta.creaDatosTabla());
			vList.setLocationRelativeTo(VentanaPrincipal.fAlqui);
			vList.setVisible(true);
			Furgoneta f = (Furgoneta)vList.getElegido();
			vList.dispose();
			
			if (f!=null) {
				tfVehiculo.setText(f.getMatricula());
			}
		}else if (selec.equalsIgnoreCase("Coche Electrico")) {
			VListado vList = new VListado(MetodosCocheElectrico.creaDatosTabla());
			vList.setLocationRelativeTo(VentanaPrincipal.fAlqui);
			vList.setVisible(true);
			CocheElectrico m = (CocheElectrico)vList.getElegido();
			vList.dispose();
			
			if (m!=null) {
				tfVehiculo.setText(m.getMatricula());
			}
		}else if (selec.equalsIgnoreCase("Coche Combustion")) {
			VListado vList = new VListado(MetodosCocheCombustion.creaDatosTabla());
			vList.setLocationRelativeTo(VentanaPrincipal.fAlqui);
			vList.setVisible(true);
			CocheCombustion m = (CocheCombustion)vList.getElegido();
			vList.dispose();
			
			if (m!=null) {
				tfVehiculo.setText(m.getMatricula());
			}
		}
	
	}
	
	
	
	private boolean comparaCarnet(TipoCarnet carnetCoche, TipoCarnet carnetPersona) {
		boolean valido=false;
			
		//si es igual validosd
		if (carnetCoche.equals(carnetPersona)) valido = true;
		//si es a1 es siempre valido
		if (carnetCoche.getNombre().equals("A1")) valido = true;
		//si es a2, si no es a1 siempre valido
		if (carnetCoche.getNombre().equals("A2") && !carnetPersona.getNombre().equals("A1")) valido = true;
		//si es B, si no es a1 O A2 siempre valido
		if (carnetCoche.getNombre().equals("B") && !carnetPersona.getNombre().equals("A1")&& !carnetPersona.getNombre().equals("A2")) valido = true;
		
		return valido;
	}
	
}
