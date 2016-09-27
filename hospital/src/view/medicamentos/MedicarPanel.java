package view.medicamentos;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dao.RemediosDAO;

public class MedicarPanel extends JPanel{

	private static final long serialVersionUID = -2776525152141845614L;
	
	private JLabel idPac;
	private JLabel dosagem;
	private JLabel nome;
	private JCheckBox checkPac;
	private String[] medicamento;
	
	private String id;
	
	public MedicarPanel(String id){
		this.id = id;
		setBorder(createBorder());
		getMedicamento();
		add(getIdPac());
		add(getNome());
		add(getDosagem());
		add(getCheckPac());
	}
	
	public Border createBorder() {
		EmptyBorder innerEmpty = new EmptyBorder(5, 5, 5, 5);
		TitledBorder titledBorder = new TitledBorder("Medicar paciente:");
		EmptyBorder outerEmpty = new EmptyBorder(5, 5, 5, 5);
		CompoundBorder innerCompound = new CompoundBorder(titledBorder,
				innerEmpty);
		CompoundBorder totalCompound = new CompoundBorder(outerEmpty,
				innerCompound);
		return totalCompound;
	}
	
	public JLabel getIdPac() {
		if(idPac == null){
			idPac = new JLabel("Paciente N°: "+medicamento[0]+" ");
		}
		return idPac;
	}

	public JLabel getNome() {
		if(nome == null){
			nome = new JLabel("Medicamento: "+medicamento[2]+" ");
		}
		return nome;
	}
	
	
	
	public JLabel getDosagem() {
		if(dosagem == null) {
			dosagem = new JLabel("Dose: "+medicamento[1]+" ");
		}
		return dosagem;
	}

	public JCheckBox getCheckPac() {
		if(checkPac == null){
			checkPac = new JCheckBox();
		}
		return checkPac;
	}
	
	private void getMedicamento(){
		RemediosDAO dao = new RemediosDAO();
		ArrayList<String[]> remedios = dao.readFile();
		
		for(String[] remedio : remedios){
			if(remedio[0].equals(id)){
				medicamento = remedio;
				break;
			}
		}
		
	}
	
	public String[] getMed(){
		return medicamento;
	}

}
