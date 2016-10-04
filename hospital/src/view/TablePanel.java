package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.table.DefaultTableModel;

import dao.PacienteDAO;
import dao.RemediosDAO;
import model.Enfermeiro;
import model.Farmaceutico;
import model.Medico;
import view.medicamentos.AdicionarMedFrame;

public class TablePanel extends JPanel{

	private static final long serialVersionUID = 7261518674510605927L;
	
	private JTable table;
	
	private DefaultTableModel modelo;
	
	private JScrollPane scrollPane;
	
	private JButton atualizar;
	
	private JPanel buttonPanel;
	
	private int access;
	
	public TablePanel(int access){
		this.access = access;
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
			modelo.addColumn("Medicamentos");
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(350);
			table.getColumnModel().getColumn(2).setPreferredWidth(40);
			table.getColumnModel().getColumn(3).setPreferredWidth(200);
			atualisarModelo(getModelo());
			table.setPreferredScrollableViewportSize(new Dimension(300, 300));
			table.setFillsViewportHeight(true);
			table.addMouseListener(addAction());
			
			
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
		RemediosDAO rDAO = new RemediosDAO();
		ArrayList<String[]> pacientes = dao.readFile();
		ArrayList<String[]> remedios = rDAO.readFile();
		int tag = 0;
		for(String[] paciente : pacientes){
			for(String[] remedio: remedios){
				if(paciente[0].equals(remedio[0])){
					String confirm = null;
					if(remedio[3].equals("nok")){
						confirm = "Medicamento não está pronto";
					} else if(remedio[3].equals("ok")){
						confirm = "Medicamento está pronto";
					}  else if (remedio[3].equals("med")){
						confirm = "Pronto para ser medicado";
					}
					modelo.addRow(new Object[]{paciente[0], paciente[1], paciente[5], confirm});
					tag = 1;
					break;
				}
			}
			if(tag == 0){
				modelo.addRow(new Object[]{paciente[0], paciente[1], paciente[5], "Não há medicamentos"});
			}
			tag = 0;
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
	
	private MouseAdapter addAction(){
		return new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 2){
						if(Medico.MEDICO == access || access == 4 && checkOK("Não há medicamentos")) {
						String id = (String) getTable().getModel().getValueAt(getTable().getSelectedRow(), 0);
						PacienteDAO dao = new PacienteDAO();
						ArrayList<String[]> pacientes = dao.readFile();
						for(String[] paciente : pacientes) {
							if(paciente[0].equals(id)){
								int confirm = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um remédio ao paciente de registro "+id+" ?");
								if(confirm == JOptionPane.OK_OPTION){
									new AdicionarMedFrame(id, access);
								}
							}
						}
					} else if(Farmaceutico.FARMACEUTICO == access && checkOK("Medicamento não está pronto")){
						String id = (String) getTable().getModel().getValueAt(getTable().getSelectedRow(), 0);
						new AdicionarMedFrame(id, access);
					} else if(Enfermeiro.ENFERMEIRO == access && checkOK("Pronto para ser medicado")){
						String id = (String) getTable().getModel().getValueAt(getTable().getSelectedRow(), 0);
						new AdicionarMedFrame(id, access);
					}
				}
			}
		};
	}
	
	private boolean checkOK(String string){
		String status = (String) getTable().getModel().getValueAt(getTable().getSelectedRow(), 3);
		if(status.equals(string)){
			return true;
		} 
		return false;
	}
	
}
