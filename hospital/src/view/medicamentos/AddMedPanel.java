package view.medicamentos;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AddMedPanel extends JPanel{

	private static final long serialVersionUID = 9059959978766796882L;
	
	private GridLayout layout;
	
	private JTextField doseText;
	private JLabel doseLabel;
	
	private JTextField medText;
	private JLabel medLabel;
	
	public AddMedPanel(){
		initialize();
	}
	
	public GridLayout getGridLayout() {
		layout = new GridLayout();
		layout.setColumns(2);
		layout.setRows(2);
		layout.setHgap(5);
		layout.setVgap(5);
		return layout;
	}
	
	public Border createBorder() {
		EmptyBorder innerEmpty = new EmptyBorder(5, 5, 5, 5);
		TitledBorder titledBorder = new TitledBorder("Adicionar medicamento:");
		EmptyBorder outerEmpty = new EmptyBorder(5, 5, 5, 5);
		CompoundBorder innerCompound = new CompoundBorder(titledBorder,
				innerEmpty);
		CompoundBorder totalCompound = new CompoundBorder(outerEmpty,
				innerCompound);
		return totalCompound;
	}
	
	public void initialize() {
		setLayout(getGridLayout());
		setBorder(createBorder());
		
		add(getDoseLabel());
		add(getMedLabel());
		add(getDoseText());
		add(getMedText());
	}

	public JTextField getDoseText() {
		if(doseText == null){
			doseText = new JTextField();
			Dimension d = doseText.getPreferredSize();
			d.width = 50;
			doseText.setPreferredSize(d);
		}
		return doseText;
	}

	public JLabel getDoseLabel() {
		if(doseLabel == null) {
			doseLabel = new JLabel("Dosagem");
			doseLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return doseLabel;
	}

	public JTextField getMedText() {
		if(medText == null){
			medText = new JTextField();
			Dimension d = medText.getPreferredSize();
			d.width = 150;
			medText.setPreferredSize(d);
		}
		return medText;
	}

	public JLabel getMedLabel() {
		if(medLabel == null) {
			medLabel = new JLabel("Medicamento");
			medLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return medLabel;
	}
	
	public boolean checkEmpty(){
		if(getDoseText().getText().equals("") || getMedText().getText().equals("") ){
			JOptionPane.showMessageDialog(null, "Há campos vazios");
			return false;
		} else return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getDoseText().getText()+";");
		sb.append(getMedText().getText());
		return sb.toString();
	}
	
}
