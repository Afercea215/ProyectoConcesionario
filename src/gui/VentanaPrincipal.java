package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import principal.Principal;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.ComponentOrientation;
import javax.swing.JMenu;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	public static FormuOficinas fOfi = null;
	public static FormuClientes fCli = null;
	public static FormuEmpleados fEmple = null;
	public static FormuMotos fMoto = null;
	public static FormuCocheElectrico fCocheElectrico = null;
	public static FormuCocheCombustion fCocheCombustion = null;
	public static FormuFurgoneta fFurgoneta = null;
	public static FormuAlquiler fAlqui = null;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		setTitle("ENTERPRISE");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 401);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnListEInform = new JMenu("Listados e informes");
		menuBar.add(mnListEInform);
		
		JMenu mnProcesosDiarios = new JMenu("Procesos Diarios");
		menuBar.add(mnProcesosDiarios);
		
		JMenuItem mntmAlquiler = new JMenuItem("Alquiler");
		mntmAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fAlqui = new FormuAlquiler();
				fAlqui.setLocationRelativeTo(Principal.v);
				fAlqui.setVisible(true);
			}
		});
		mnProcesosDiarios.add(mntmAlquiler);
		
		JMenu mnFicherosMaestros = new JMenu("FicherosMaestros");
		menuBar.add(mnFicherosMaestros);
		
		JMenuItem mntmOficinas = new JMenuItem("Oficinas");
		mntmOficinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fOfi = new FormuOficinas();
				fOfi.setLocationRelativeTo(Principal.v);
				fOfi.setVisible(true);
			}
		});
		mnFicherosMaestros.add(mntmOficinas);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fCli = new FormuClientes();
				fCli.setLocationRelativeTo(Principal.v);
				fCli.setVisible(true);
			}
		});
		mnFicherosMaestros.add(mntmClientes);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fEmple = new FormuEmpleados();
				fEmple.setLocationRelativeTo(Principal.v);
				fEmple.setVisible(true);
			}
		});
		mnFicherosMaestros.add(mntmEmpleados);
		
		JMenuItem mntmMotos = new JMenuItem("Motos");
		mntmMotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fMoto = new FormuMotos();
				fMoto.setLocationRelativeTo(Principal.v);
				fMoto.setVisible(true);
			}
		});
		mnFicherosMaestros.add(mntmMotos);
		
		JMenuItem mntmCochesElectricos = new JMenuItem("Coches Electricos");
		mntmCochesElectricos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fCocheElectrico = new FormuCocheElectrico();
				fCocheElectrico.setLocationRelativeTo(Principal.v);
				fCocheElectrico.setVisible(true);
			}
		});
		mnFicherosMaestros.add(mntmCochesElectricos);
		
		JMenuItem mntmCochesCombustion = new JMenuItem("Coches Combustion");
		mntmCochesCombustion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fCocheCombustion = new FormuCocheCombustion();
				fCocheCombustion.setLocationRelativeTo(Principal.v);
				fCocheCombustion.setVisible(true);
			}
		});
		mnFicherosMaestros.add(mntmCochesCombustion);
		
		JMenuItem mntmFurgonetas = new JMenuItem("Furgonetas");
		mntmFurgonetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fFurgoneta = new FormuFurgoneta();
				fFurgoneta.setLocationRelativeTo(Principal.v);
				fFurgoneta.setVisible(true);
			}
		});
		mnFicherosMaestros.add(mntmFurgonetas);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,88,165));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);

		lblFondo.setIcon(new ImageIcon("media/logo.png"));
		lblFondo.setBackground(new Color(100, 0, 0));
		contentPane.add(lblFondo, BorderLayout.CENTER);
	}

}
