package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					MetodosGUI.centrarJFrame(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		setTitle("ENTERPRISE");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnListEInform = new JMenu("Listados e informes");
		menuBar.add(mnListEInform);
		
		JMenuItem mntmOficinas = new JMenuItem("Oficinas");
		mnListEInform.add(mntmOficinas);
		
		JMenu mnProcesosDiarios = new JMenu("Procesos Diarios");
		menuBar.add(mnProcesosDiarios);
		
		JMenu mnFicherosMaestros = new JMenu("FicherosMaestros");
		menuBar.add(mnFicherosMaestros);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,88,165));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);

		lblFondo.setIcon(new ImageIcon("C:\\Users\\Andres\\Desktop\\1\u00BADAW\\Programacion\\ProyectoConcesionario\\logo.png"));
		lblFondo.setBackground(new Color(100, 0, 0));
		contentPane.add(lblFondo, BorderLayout.CENTER);
	}

}
