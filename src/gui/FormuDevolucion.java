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

import principal.Principal;
import org.jdatepicker.JDatePicker;

import accesoADatos.RepositorioAlquiler;
import accesoADatos.RepositorioDevolucion;
import controladoresDeEventos.ControlaLongitud;
import controladoresDeEventos.NoPermiteEscribir;
import controladoresDeEventos.SoloAdmiteNumeros;
import entidades.Alquiler;
import entidades.Devolucion;
import entidades.Empleado;
import entidades.Oficina;

public class FormuDevolucion extends JDialog {

	private FormuDevolucion fDevo=this;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigoAlqui;
	private JButton btGrabar;
	private Devolucion devo;
	private JButton btBorrar;
	private JButton btnCancel;
	private ArrayList<Component> excepciones = new ArrayList<Component>();
	
	public JTextField getTfCodigoAlqui() {
		return tfCodigoAlqui;
	}

	public Devolucion getDevo() {
		return devo;
	}

	public JTextField getTfPrecio() {
		return tfPrecio;
	}

	public JComboBox getCbOfi() {
		return cbOfi;
	}

	public JButton getBtnLupaAlquiler() {
		return btnLupaAlquiler;
	}

	public JLabel getLblBuscarDevolucion() {
		return lblBuscarDevolucion;
	}

	public JButton getBtnLupaEmple() {
		return btnLupaEmple;
	}

	public JTextField getTfCodigo() {
		return tfCodigo;
	}

	public void setTfCodigoAlqui(JTextField tfCodigoAlqui) {
		this.tfCodigoAlqui = tfCodigoAlqui;
	}

	public void setDevo(Devolucion devo) {
		this.devo = devo;
	}

	public void setTfPrecio(JTextField tfPrecio) {
		this.tfPrecio = tfPrecio;
	}

	public void setCbOfi(JComboBox cbOfi) {
		this.cbOfi = cbOfi;
	}

	public void setBtnLupaAlquiler(JButton btnLupaAlquiler) {
		this.btnLupaAlquiler = btnLupaAlquiler;
	}

	public void setLblBuscarDevolucion(JLabel lblBuscarDevolucion) {
		this.lblBuscarDevolucion = lblBuscarDevolucion;
	}

	public void setBtnLupaEmple(JButton btnLupaEmple) {
		this.btnLupaEmple = btnLupaEmple;
	}

	public void setTfCodigo(JTextField tfCodigo) {
		this.tfCodigo = tfCodigo;
	}


	private JTextField tfEmple;
	private JTextField tfCliente;
	private JTextField tfPrecio;
	private JTextField tfVehiculo;
	private JComboBox cbOfi;
	private JButton btnLupaAlquiler;
	private JDatePicker dpFin;
	private JLabel lblBuscarDevolucion;
	private JButton btnLupaEmple;
	private JTextField tfCodigo;
	private JLabel lblkms;
	private JTextField tfkms;
	private JButton btnLupaDevo;

	
	
	/**
	 * Launch the application.
	 */
	
	//////////////////////////////////////////
	//GETTERS Y SETTERS
	//////////////////////////////////////////
	

	
	/**
	 * Create the dialog.
	 */
	public FormuDevolucion() {
		
		setResizable(false);
		setModal(true);
		setTitle("Devolucion");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/persona.png"));
		setBounds(100, 100, 265, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setVisible(true);
		contentPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//CODIGO
		JLabel lblCodigoAlqui = new JLabel("Codigo Alquiler");
		lblCodigoAlqui.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoAlqui.setBounds(10, 41, 89, 21);
		contentPanel.add(lblCodigoAlqui);
		
		tfCodigoAlqui = new JTextField();
		tfCodigoAlqui.setName("cod");
		tfCodigoAlqui.setColumns(4);
		tfCodigoAlqui.setBounds(102, 41, 67, 21);
		contentPanel.add(tfCodigoAlqui);
		tfCodigoAlqui.addKeyListener(new controladoresDeEventos.ControlaLongitud(4));
		tfCodigoAlqui.addKeyListener(new controladoresDeEventos.SoloAdmiteNumeros());
		tfCodigoAlqui.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//si se pulsa intro se verifica si el coodigo es valido
				 if(e.getKeyCode()==KeyEvent.VK_ENTER){
					 
					 Alquiler a = RepositorioAlquiler.buscaAlquiler(tfCodigoAlqui.getText());
						if (a!=null) {
							tfCodigoAlqui.setText(a.getId());
							tfVehiculo.setText(a.getVehiculo().getMatricula());
							tfEmple.setText(a.getEmpleado().getDni());
							tfCliente.setText(a.getCliente().getDni());
							cbOfi.setSelectedItem(a.getOficinaDevolucion());
							tfPrecio.setText(metodos.Especificos.calculaAlquiler(a.getFechaIniAlquiler(), new GregorianCalendar(), a.getVehiculo())+"");
							MetodosGUI.activPanel(contentPanel);
							excepcionesActiva();
						}
					if (!tfCodigoAlqui.getText().equals("")) {
						MetodosGUI.activPanel(contentPanel);
						excepcionesActiva();
					}
	             } 
			}
		});
		//LUPA
		btnLupaAlquiler = new JButton("");
		btnLupaAlquiler.setName("lupa");
		btnLupaAlquiler.setIcon(new ImageIcon("media/lupa.png"));
		btnLupaAlquiler.setBounds(190, 41, 20, 21);
		contentPanel.add(btnLupaAlquiler);
		
		btnLupaAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
				VListado vList = new VListado(MetodosAlquiler.creaDatosTablaNoFinalizado(),true);
				vList.setLocationRelativeTo(VentanaPrincipal.fDevo);
				vList.setVisible(true);
				Alquiler a = (Alquiler)vList.getElegido();
				vList.dispose();
				
				if (a!=null) {
					tfCodigoAlqui.setText(a.getId());
					tfVehiculo.setText(a.getVehiculo().getMatricula());
					tfCliente.setText(a.getCliente().getDni());
					cbOfi.setSelectedItem(a.getOficinaDevolucion());
					tfPrecio.setText(metodos.Especificos.calculaAlquiler(new GregorianCalendar(a.getFechaIniAlquiler().get(Calendar.YEAR)+1900, a.getFechaIniAlquiler().get(Calendar.MONTH)-1, a.getFechaIniAlquiler().get(Calendar.DAY_OF_MONTH)), new GregorianCalendar(), a.getVehiculo())+"");
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
						int n = JOptionPane.showConfirmDialog(fDevo, "¿Está seguro de que quiere borrarlo?","ADVERTENCIA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						//si elige el boton si
						if (n==0) {
							//para comprobar que existe la ofi
							Devolucion a = RepositorioDevolucion.buscaDevolucion(tfCodigoAlqui.getText());
							if (a!=null) {
								try {
									RepositorioDevolucion.borraDevolucion(a.getAlquiler().getId());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									MetodosGUI.mensajeErrorBorrado(fDevo);
								}
								MetodosGUI.vaciarPanel(contentPanel);
								MetodosGUI.desactPanel(contentPanel);
								excepcionesDesact();
							}else {
								JOptionPane.showMessageDialog(fDevo,"La devoluion que desea borrar no existe.");
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
						MetodosDevolucion.grabaDevolucion(fDevo);
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
			
			JLabel lblVehiculo = new JLabel("Vehiculo");
			lblVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblVehiculo.setBounds(10, 72, 56, 21);
			contentPanel.add(lblVehiculo);
			
			tfVehiculo = new JTextField();
			tfVehiculo.setName("dni");
			tfVehiculo.setEnabled(true);
			tfVehiculo.setColumns(4);
			tfVehiculo.setBounds(72, 72, 67, 21);
			tfVehiculo.addKeyListener(new NoPermiteEscribir());
			contentPanel.add(tfVehiculo);
			btnLupaAlquiler.setIcon(new ImageIcon("media/lupa.png"));
			
			JLabel lblOfi = new JLabel("Oficina");
			lblOfi.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblOfi.setBounds(10, 103, 129, 21);
			contentPanel.add(lblOfi);
			
			cbOfi = MetodosOficina.comboBoxOficinas();
			cbOfi.setBounds(72, 104, 138, 21);
			contentPanel.add(cbOfi);
			
			JLabel lblEmple = new JLabel("Empleado");
			lblEmple.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEmple.setBounds(10, 166, 56, 21);
			contentPanel.add(lblEmple);
			
			tfEmple = new JTextField();
			tfEmple.setName("dni");
			tfEmple.setEnabled(true);
			tfEmple.setColumns(4);
			tfEmple.setBounds(72, 166, 67, 21);
			tfEmple.addKeyListener(new ControlaLongitud(9));
			contentPanel.add(tfEmple);
			
			JLabel lblCliente = new JLabel("Cliente");
			lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCliente.setBounds(10, 197, 56, 21);
			contentPanel.add(lblCliente);
			
			tfCliente = new JTextField();
			tfCliente.setName("dni");
			tfCliente.setEnabled(true);
			tfCliente.setColumns(4);
			tfCliente.setBounds(72, 197, 67, 21);
			contentPanel.add(tfCliente);
			tfCliente.addKeyListener(new ControlaLongitud(9));
			
			JLabel lblPrecio = new JLabel("Precio");
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPrecio.setBounds(10, 258, 89, 21);
			contentPanel.add(lblPrecio);
			
			tfPrecio = new JTextField();
			tfPrecio.setName("dni");
			tfPrecio.setEnabled(true);
			tfPrecio.setColumns(4);
			tfPrecio.setBounds(72, 259, 67, 21);
			tfPrecio.addKeyListener(new NoPermiteEscribir());
			
			JLabel lblFecha = new JLabel("Fecha final");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFecha.setBounds(10, 135, 127, 21);
			contentPanel.add(lblFecha);

			cbOfi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfEmple.setText("");
				}
			});
			
			contentPanel.add(tfPrecio);

			dpFin = new JDatePicker(new Date());
			dpFin.getModel().setSelected(true);
			dpFin.setBounds(92, 134, 118, 21);
			dpFin.addKeyListener(new NoPermiteEscribir());
			contentPanel.add(dpFin);
			
			btnLupaDevo = new JButton("");
			btnLupaDevo.setName("lupa");
			btnLupaDevo.setEnabled(true);
			btnLupaDevo.setBounds(119, 10, 20, 21);
			btnLupaDevo.setIcon(new ImageIcon("media/lupa.png"));
			btnLupaDevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
					VListado vList = new VListado(MetodosDevolucion.creaDatosTabla(),true);
					vList.setLocationRelativeTo(VentanaPrincipal.fDevo);
					vList.setVisible(true);
					Devolucion a = (Devolucion)vList.getElegido();
					vList.dispose();
					
					if (a!=null) {
						MetodosDevolucion.rellenaPanelDevo(a, fDevo);
						MetodosGUI.activPanel(contentPanel);
						excepcionesActiva();
					}
				}
			});
			contentPanel.add(btnLupaDevo);
			
			lblBuscarDevolucion = new JLabel("Buscar devolucion");
			lblBuscarDevolucion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblBuscarDevolucion.setBounds(10, 10, 107, 21);
			contentPanel.add(lblBuscarDevolucion);
			
			btnLupaEmple = new JButton("");
			btnLupaEmple.setName("lupa");
			btnLupaEmple.setEnabled(true);
			btnLupaEmple.setBounds(149, 167, 20, 21);
			btnLupaEmple.setIcon(new ImageIcon("media/lupa.png"));
			btnLupaEmple.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//CUANDO CLIICK, SE ABRE UNA NUEVA VENTANA DE LISTADO OFIS
					VListado vList = new VListado(MetodosEmpleado.creaDatosTablaDeOfi( ((Oficina) cbOfi.getSelectedItem()).getCod()),true);
					vList.setLocationRelativeTo(VentanaPrincipal.fAlqui);
					vList.setVisible(true);
					Empleado a = (Empleado)vList.getElegido();
					vList.dispose();
					
					if (a!=null) {
						tfEmple.setText(a.getDni());
					}
				}
			});
			contentPanel.add(btnLupaEmple);
			
			tfCodigo = new JTextField();
			tfCodigo.setVisible(false);
			tfCodigo.setEnabled(false);
			tfCodigo.setBounds(152, 99, 96, 19);
			contentPanel.add(tfCodigo);
			tfCodigo.setColumns(10);
			
			lblkms = new JLabel("Kms recorridos");
			lblkms.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblkms.setBounds(10, 228, 89, 21);
			contentPanel.add(lblkms);
			
			tfkms = new JTextField();
			tfkms.setName("dni");
			tfkms.setEnabled(true);
			tfkms.setColumns(4);
			tfkms.setBounds(102, 227, 67, 21);
			tfkms.addKeyListener(new SoloAdmiteNumeros());
			contentPanel.add(tfkms);

			MetodosGUI.desactPanel(contentPanel);
			excepcionesDesact();
	}

	public JTextField getTfkms() {
		return tfkms;
	}

	public void setTfkms(JTextField tfkms) {
		this.tfkms = tfkms;
	}

	public Devolucion getdevo() {
		return devo;
	}

	public JDatePicker getDpFin() {
		return dpFin;
	}

	public void setdevo(Devolucion devo) {
		this.devo = devo;
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
		tfCodigoAlqui.setEnabled(false);
		btnLupaAlquiler.setEnabled(false);
		btnLupaDevo.setEnabled(false);
		
		btGrabar.setEnabled(true);
		btBorrar.setEnabled(true);
	}
	
	public void excepcionesDesact () {
		tfCodigoAlqui.setEnabled(true);
		btnLupaAlquiler.setEnabled(true);
		btnLupaDevo.setEnabled(true);
		btnCancel.setEnabled(true);
		
		btGrabar.setEnabled(false);
		btBorrar.setEnabled(false);
	}



	public FormuDevolucion getfDevo() {
		return fDevo;
	}



	public JPanel getContentPanel() {
		return contentPanel;
	}


	public JButton getBtGrabar() {
		return btGrabar;
	}



	public JButton getBtBorrar() {
		return btBorrar;
	}


	public JButton getBtnCancel() {
		return btnCancel;
	}


	public void setfDevo(FormuDevolucion fDevo) {
		this.fDevo = fDevo;
	}


	public void setBtGrabar(JButton btGrabar) {
		this.btGrabar = btGrabar;
	}

	public void setBtBorrar(JButton btBorrar) {
		this.btBorrar = btBorrar;
	}


	public JTextField getTfEmple() {
		return tfEmple;
	}

	public JTextField getTfCliente() {
		return tfCliente;
	}

	public JTextField getTfPrecioPrevisto() {
		return tfPrecio;
	}

	public JTextField getTfVehiculo() {
		return tfVehiculo;
	}


	public void setTfEmple(JTextField tfEmple) {
		this.tfEmple = tfEmple;
	}

	public void setTfCliente(JTextField tfCliente) {
		this.tfCliente = tfCliente;
	}

	public void setTfPrecioPrevisto(JTextField tfPrecioPrevisto) {
		this.tfPrecio = tfPrecioPrevisto;
	}

	public void setTfVehiculo(JTextField tfVehiculo) {
		this.tfVehiculo = tfVehiculo;
	}


	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}
}
