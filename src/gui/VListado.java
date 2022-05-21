package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import accesoADatos.RepositorioCliente;
import accesoADatos.RepositorioOficina;
import entidades.Cliente;
import entidades.Oficina;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Point;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

public class VListado extends JDialog {

	private VListado listVentana = this;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object elegido;
	private int nColum;
	private JTextField tfContiene;
	private JTextField tfEmpiezaPor;
	private JPanel panelBuscador;
	private JButton btnSeleccionar;
	private JButton btnCancelar;
	private int selectedRow=0;
	private int selectedColum=0;
	private int columOrdenada=0;

	/**
	 * Launch the application.
	 */
	
	
	//////////////////////////////////////////////
	//GETTERS Y SETTERS
	/////////////////////////////////////////////
	
	public VListado getListVentana() {
		return listVentana;
	}


	public JPanel getContentPanel() {
		return contentPanel;
	}


	public JTable getTable() {
		return table;
	}


	public Object getElegido() {
		return elegido;
	}

	public void setListVentana(VListado listVentana) {
		this.listVentana = listVentana;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public void setElegido(Object elegido) {
		this.elegido = elegido;
	}


	/////////////////crear model con los parametros ///// DefaultTableModel model 
	///////////////, ArrayList<Integer> anchuraColumnas
	 public boolean isCellEditable(int row, int column) {                
         return false;               
	 };
	
	
	public VListado(DatosTabla datos) {
		
		setTitle("Listado");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/lista.png"));
		setModal(true);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		DefaultTableModel model = new DefaultTableModel() {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
		};
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		for (String a : datos.getNombreColumnas()){
			model.addColumn(a);
		}
		
		Object[] dato = new Object[model.getColumnCount()];
		int ancho=0;
		int cont=0;
		for (int i = 0; i<datos.getDatosTabla().length;i++) {
			for (int j = 0; j<model.getColumnCount();j++) {
				//meto el dato
				dato[j]= datos.getDatosTabla()[i][j];
				
				//pongo la anchura min del esa colum
				table.getColumnModel().getColumn(j).setMinWidth(datos.getAnchuraColumnas().get(j));
				cont++;
				if (cont<model.getColumnCount()) {
					ancho=ancho+datos.getAnchuraColumnas().get(j);
				}
			}

			model.addRow(dato);
	    } 
		
		
		for (int i=0;i<model.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setMinWidth(datos.getAnchuraColumnas().get(i));
		
		}
		
		int minAlto = 250;
		int minAncho = 600;
		//ancho = ancho +50;
		
		if (ancho <minAncho) {
			ancho=minAncho;
		}
		
		this.setMinimumSize(new Dimension(ancho, minAlto));
		nColum = table.getModel().getColumnCount();
		
		setBounds(100, 100, 609, 250);
		
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				panelBuscador = new JPanel();
				panel.add(panelBuscador, BorderLayout.CENTER);
				panelBuscador.setLayout(null);
				
				{
				tfEmpiezaPor = new JTextField();
				tfEmpiezaPor.setName("empiezaPor");
				tfEmpiezaPor.setBounds(104, 16, 156, 19);
				panelBuscador.add(tfEmpiezaPor);
				tfEmpiezaPor.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("Comienza por :");
				lblNewLabel.setBounds(9, 19, 70, 13);
				panelBuscador.add(lblNewLabel);
				
				JLabel lblContiene = new JLabel("Contiene :");
				lblContiene.setBounds(10, 43, 56, 13);
				panelBuscador.add(lblContiene);
				
				tfContiene = new JTextField();
				tfContiene.setName("contiene");
				tfContiene.setColumns(10);
				tfContiene.setBounds(104, 40, 156, 19);
				panelBuscador.add(tfContiene);
				
				JButton btnLupa = new JButton("New button");
				btnLupa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int filaModel;
						int fila=table.getSelectedRow();
						filaModel= table.convertRowIndexToModel(fila);
						if(!tfContiene.getText().equals("")) {
							for (int i=0;i<model.getRowCount();i++) {
								filaModel= table.convertRowIndexToModel(i);
								///////
								String valor = (model.getValueAt(filaModel, columOrdenada))+"";
								
								if(valor.toUpperCase().indexOf(tfContiene.getText().toUpperCase())!=-1) {
									//filaModel= table.convertRowIndexToModel(i);
									table.setRowSelectionInterval(0, i);
									break;
								}
							}
						} 				
					}
				});
				btnLupa.setBounds(270, 39, 85, 21);
				panelBuscador.add(btnLupa);
			}
			{
				JPanel panelBotones = new JPanel();
				panel.add(panelBotones, BorderLayout.EAST);
				panelBotones.setLayout(new MigLayout("", "[85px]", "[10][][21px]"));
				
				btnSeleccionar = new JButton("Seleccionar");
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						elegido=null;
						elegido= MetodosGUI.cogerSeleccionado(table,nColum-1);
						if (elegido!=null) {
							listVentana.setVisible(false);	
							tfContiene.setText("");
							tfEmpiezaPor.setText("");
						} 
					}
				});
				btnSeleccionar.setName("seleccionar");
				panelBotones.add(btnSeleccionar, "cell 0 1,grow");
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						table.setRowSelectionInterval(0, 0);
						tfContiene.setText("");
						tfEmpiezaPor.setText("");
					}
				});
				btnCancelar.setName("cancelar");
				panelBotones.add(btnCancelar, "cell 0 2,grow");
			}
		}
	   
		
		{
			
			table.addMouseListener(new java.awt.event.MouseAdapter() {
			      public void mouseClicked(java.awt.event.MouseEvent e) {
			    	  
			    	  if(e.getClickCount()==2){
				    		elegido=null;
							elegido= MetodosGUI.cogerSeleccionado(table,nColum-1);
							if (elegido!=null) {
								listVentana.setVisible(false);			
							} 
				      }
		     	 }
			 });
			
			table.setRowSelectionAllowed(true);
			
			table.getRowSorter().addRowSorterListener(new RowSorterListener() {
			    @Override
			    public void sorterChanged(RowSorterEvent e) {
			    	if (e.getType() == RowSorterEvent.Type.SORT_ORDER_CHANGED) {
	                    List<SortKey> keys = (List<SortKey>) e.getSource().getSortKeys();
	                    for (SortKey key : keys) {
	                    	columOrdenada=key.getColumn();
	                    	break;
	                    }
	                }
			    }
			});
			
			table.removeColumn(table.getColumnModel().getColumn(nColum-1));
			table.getRowSorter().toggleSortOrder(0);

			tfEmpiezaPor.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					int filaModel;
					int fila=table.getSelectedRow();
					filaModel= table.convertRowIndexToModel(fila);
					if(!tfEmpiezaPor.getText().equals("")) {
						for (int i=0;i<model.getRowCount();i++) {
							
							filaModel= table.convertRowIndexToModel(i);
							String valor = (model.getValueAt(filaModel, columOrdenada))+"";
							
							if(valor.toUpperCase().startsWith(tfEmpiezaPor.getText().toUpperCase())) {
								//filaModel= table.convertRowIndexToModel(i);
								table.setRowSelectionInterval(0, i);
								break;
							}
						}
					} 					
				}
			});
			
			if (table.getRowCount()>0) {
				table.setRowSelectionInterval(0, 0);
				table.setRowSelectionAllowed(true);
			} else {
				JOptionPane.showMessageDialog(this,"No hay datos en la tabla con los datos proporcionados.");
			}
			
		}
		
	}
}
}