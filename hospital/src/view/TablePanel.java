package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.PacienteDAO;
import view.medicamentos.AdicionarMedFrame;

public class TablePanel extends JPanel{

	private static final long serialVersionUID = 7261518674510605927L;
	
	private JTable table;
	
	private DefaultTableModel modelo;
	
	private JScrollPane scrollPane;
	
	private JButton atualizar;
	
	private JPanel buttonPanel;
	
	public TablePanel(){
		init();
	}
	
	private void init(){
		setBorder(createBorder());
		setLayout(new BorderLayout());
		add(getScrollPane(), BorderLayout.CENTER);
		add(getButtonPanel(), BorderLayout.PAGE_END);
	}
	public Border createBorder() {
		EmptyBorder innerEmpty = new EmptyBorder(5, 5, 5, 5);
		TitledBorder titledBorder = new TitledBorder("Pacientes:");
		EmptyBorder outerEmpty = new EmptyBorder(5, 5, 5, 5);
		CompoundBorder innerCompound = new CompoundBorder(titledBorder,
				innerEmpty);
		CompoundBorder totalCompound = new CompoundBorder(outerEmpty,
				innerCompound);
		return totalCompound;
	}

	public JTable getTable() {
		if(table == null){
			table = new JTable(getModelo());
			modelo.addColumn("Registro");
			modelo.addColumn("Nome");
			modelo.addColumn("Quarto");
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(500);
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			atualisarModelo(getModelo());
			table.setPreferredScrollableViewportSize(new Dimension(300, 300));
			table.setFillsViewportHeight(true);
			table.getSelectionModel().addListSelectionListener(selection());;
		}
		return table;
	}
	
	public DefaultTableModel getModelo(){
		if(modelo == null) {
			modelo = new DefaultTableModel(){
		
				private static final long serialVersionUID = -1776467914450089355L;

				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			
		}
		return modelo;
	}
	
	public void atualisarModelo(DefaultTableModel modelo){
		modelo.setNumRows(0);
		PacienteDAO dao = new PacienteDAO();
		ArrayList<String[]> pacientes = dao.readFile();
		
		for(String[] paciente : pacientes){
			modelo.addRow(new Object[]{paciente[0], paciente[1], paciente[5]});
		}
	}

	public JScrollPane getScrollPane() {
		if(scrollPane == null) {
			scrollPane = new JScrollPane(getTable());
		}
		return scrollPane;
	}
	
	

	public JPanel getButtonPanel() {
		if(buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getAtualizar());
		}
		return buttonPanel;
	}

	public JButton getAtualizar() {
		if(atualizar == null) {
			atualizar = new JButton("Atualizar tabela");
			atualizar.addActionListener(refresh());
			Dimension d = atualizar.getPreferredSize();
			d.width = 200;
			atualizar.setPreferredSize(d);
		}
		return atualizar;
	}
	
	private ActionListener refresh(){
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				atualisarModelo(getModelo());
			}
		};
	}
	
	private ListSelectionListener selection() {
		return new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				getTable().getSelectedRow();
				String id = (String) getTable().getModel().getValueAt(getTable().getSelectedRow(), 0);
				PacienteDAO dao = new PacienteDAO();
				ArrayList<String[]> pacientes = dao.readFile();
				for(String[] paciente : pacientes) {
					if(paciente[0].equals(id)){
						int confirm = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um remédio ao paciente de registro "+id+" ?");
						if(confirm == JOptionPane.OK_OPTION){
							new AdicionarMedFrame(id);
						}
					}
				}
			}
		};
	}
	
}
