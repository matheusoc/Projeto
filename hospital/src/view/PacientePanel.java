package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PacientePanel extends JPanel {

	private static final long serialVersionUID = 9219616472587819909L;
	
	private GridBagLayout bagLayout;
	
	private JLabel nameText;
	private GridBagConstraints nameConstraints;
	private JTextField nameField;
	private GridBagConstraints nameFieldConstraints;
	
	public PacientePanel(){
		init();
		setLayout(getBagLayout());
		setConstraints();
	}

	private void init() {
		
		setBorder(createBorder());
	}
	
	public Border createBorder() {
		EmptyBorder innerEmpty = new EmptyBorder(5, 5, 5, 5);
		TitledBorder titledBorder = new TitledBorder("Cadastro de paciente:");
		EmptyBorder outerEmpty = new EmptyBorder(5, 5, 5, 5);
		CompoundBorder innerCompound = new CompoundBorder(titledBorder,
				innerEmpty);
		CompoundBorder totalCompound = new CompoundBorder(outerEmpty,
				innerCompound);
		return totalCompound;
	}
	
	public GridBagLayout getBagLayout(){
		if(bagLayout == null) {
			bagLayout = new GridBagLayout();
		}
		return bagLayout;
	}
	
	private void setConstraints() {
		add(getNameText(), getNameConstraints());
		add(getNameField(), getNameTextConstraints());
	}
	
	public JLabel getNameText() {
		if(nameText == null){
			nameText = new JLabel("Nome paciente: ");
		}
		return nameText;
	}

	public GridBagConstraints getNameConstraints() {
		if(nameConstraints == null) {
			nameConstraints = new GridBagConstraints();
			nameConstraints.gridx = 0;
			nameConstraints.gridy = 0;
		}
		return nameConstraints;
	}

	public JTextField getNameField() {
		if(nameField == null) {
			nameField = new JTextField();
			Dimension dimension = nameField.getPreferredSize();
			dimension.width = 200;
			nameField.setPreferredSize(dimension);
		}
		return nameField;
	}

	public GridBagConstraints getNameTextConstraints() {
		if(nameFieldConstraints == null) {
			nameFieldConstraints = new GridBagConstraints();
			nameFieldConstraints.gridx = 1;
			nameFieldConstraints.gridy = 0;
		}
		return nameFieldConstraints;
	}
	
	
}
