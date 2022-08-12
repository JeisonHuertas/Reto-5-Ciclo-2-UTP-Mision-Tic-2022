package com.view;


import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.controller.ReportesController;
import com.model.vo.LiderVo;
import com.model.vo.ProyectoVo;
import com.model.vo.CompraVo;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Incio extends JFrame {

	private JPanel contentPane;
	private JTable tablaLideres;
	private ReportesController controller;
	DefaultTableModel modeloLideres;
	private JTable tablaProyectos;
	DefaultTableModel modeloProyectos;
	private JTable tablaCompras;
	DefaultTableModel modeloCompras;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Incio() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 542);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane contendorPaneles = new JTabbedPane(JTabbedPane.TOP);
		contendorPaneles.setBackground(Color.WHITE);
		contendorPaneles.setToolTipText("");
		contendorPaneles.setBounds(0, 0, 696, 503);
		contentPane.add(contendorPaneles);
		
		JPanel panelLideres = new JPanel();
		panelLideres.setBackground(SystemColor.activeCaption);
		panelLideres.setToolTipText("");
		contendorPaneles.addTab("Lideres", null, panelLideres, null);
		panelLideres.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 86, 528, 364);
		panelLideres.add(scrollPane);
		
		tablaLideres = new JTable();
		modeloLideres = new DefaultTableModel ();
		modeloLideres.addColumn("ID_Lider");
		modeloLideres.addColumn("Nombre");
		modeloLideres.addColumn("Primer_Apellido");
		modeloLideres.addColumn("Ciudad_Residencia");
		
		mostrarLideres(modeloLideres);
		
		tablaLideres.setModel(modeloLideres);
		scrollPane.setViewportView(tablaLideres);
		
		JLabel lblNewLabel = new JLabel("Informe Lideres");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(75, 23, 141, 32);
		panelLideres.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Incio.class.getResource("/com/images/logo misonTic-UTP resize.png")));
		lblNewLabel_1.setBounds(412, 0, 269, 83);
		panelLideres.add(lblNewLabel_1);
		
		JPanel panelProyectos = new JPanel();
		panelProyectos.setBackground(SystemColor.activeCaption);
		contendorPaneles.addTab("Proyectos", null, panelProyectos, null);
		panelProyectos.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(81, 114, 529, 246);
		panelProyectos.add(scrollPane_1);
		
		tablaProyectos = new JTable();
		modeloProyectos = new DefaultTableModel();
		modeloProyectos.addColumn("ID_Proyecto");
		modeloProyectos.addColumn("Constructora");
		modeloProyectos.addColumn("Num_Habitaciones");
		modeloProyectos.addColumn("Ciudad");
		tablaProyectos.setModel(modeloProyectos);
		
		mostrarProyectos(modeloProyectos);
		
		scrollPane_1.setViewportView(tablaProyectos);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Incio.class.getResource("/com/images/logo misonTic-UTP resize.png")));
		lblNewLabel_1_1.setBounds(412, 0, 269, 83);
		panelProyectos.add(lblNewLabel_1_1);
		
		JLabel lblInformeProyectos = new JLabel("Informe Proyectos");
		lblInformeProyectos.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblInformeProyectos.setBounds(79, 22, 182, 32);
		panelProyectos.add(lblInformeProyectos);
		
		JPanel panelCompras = new JPanel();
		panelCompras.setBackground(SystemColor.activeCaption);
		contendorPaneles.addTab("Compras", null, panelCompras, null);
		panelCompras.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(96, 89, 498, 296);
		panelCompras.add(scrollPane_2);
		
		tablaCompras = new JTable();
		modeloCompras = new DefaultTableModel();
		modeloCompras.addColumn("ID_Compra");
		modeloCompras.addColumn("Constructora");
		modeloCompras.addColumn("Banco_Vinculado");
		
		mostrarCompras(modeloCompras);
		
		tablaCompras.setModel(modeloCompras);
		scrollPane_2.setViewportView(tablaCompras);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(Incio.class.getResource("/com/images/logo misonTic-UTP resize.png")));
		lblNewLabel_1_2.setBounds(422, 0, 269, 83);
		panelCompras.add(lblNewLabel_1_2);
		
		JLabel lblInformeCompras = new JLabel("Informe Compras");
		lblInformeCompras.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblInformeCompras.setBounds(94, 21, 162, 32);
		panelCompras.add(lblInformeCompras);
	}
	
	public void mostrarLideres(DefaultTableModel model) throws SQLException {
		try{
			controller = new ReportesController();
			List<LiderVo> comprasLideres =  controller.listarLideresQueMasGastan();
			String[] lider = new String[4];
			for (LiderVo comprasLider : comprasLideres) {
				lider[0]= comprasLider.getId_lider();
				lider[1]= comprasLider.getNombre();
				lider[2]= comprasLider.getPrimer_Apellido();
				lider[3]= comprasLider.getCiudad_residencia();
				
				model.addRow(lider);
            }
			
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void mostrarProyectos(DefaultTableModel model) throws SQLException {
		try{
			controller = new ReportesController();
			List<ProyectoVo> proyectos = controller.listarTotalAdeudadoProyectos();
			String[] aProyecto = new String[4];
            for (ProyectoVo proyecto : proyectos) {
                aProyecto[0] = Integer.toString(proyecto.getId_proyecto());
                aProyecto[1] = proyecto.getConstructora();
                aProyecto[2] = Integer.toString(proyecto.getNum_habitaciones());
                aProyecto[3] = proyecto.getCiudad();
				
				model.addRow(aProyecto);
            }
			
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void mostrarCompras(DefaultTableModel model) throws SQLException {
		try{
			controller = new ReportesController();
			List<CompraVo> listar = controller.listarProyectosPorBanco();
			String[] aCompras = new String[3];
            for (CompraVo compras : listar) {
                aCompras[0] = Integer.toString(compras.getId_Compra());
                aCompras[1] = compras.getConstructora();
                aCompras[2] = compras.getBanco_Vinculado();
				
				model.addRow(aCompras);
            }
			
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
