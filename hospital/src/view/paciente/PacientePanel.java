package view.paciente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class PacientePanel extends JPanel {

	private static final long serialVersionUID = 9219616472587819909L;
	
	private GridBagLayout bagLayout;
	
	private JLabel nameText;
	private GridBagConstraints nameConstraints;
	private JTextField nameField;
	private GridBagConstraints nameFieldConstraints;
	
	private JLabel nascText;
	private GridBagConstraints nascTextConstraints;
	private JFormattedTextField nascField;
	private GridBagConstraints nascFieldConstraints;
	
	private JLabel enterText;
	private GridBagConstraints enterTextConstraints;
	private JFormattedTextField enterField;
	private GridBagConstraints enterFieldConstraints;
	
	private JLabel ageText;
	private GridBagConstraints ageConstraints;
	private JFormattedTextField ageField;
	private GridBagConstraints ageFieldConstraints;
	
	private JLabel roomText;
	private GridBagConstraints roomConstraints;
	private JFormattedTextField roomField;
	private GridBagConstraints roomFieldConstraints;
	
	private JLabel allergyText;
	private GridBagConstraints allergyTextConstraints;
	private JScrollPane allergyScrollPane;
	private JTextArea allergyArea;
	private GridBagConstraints allergyAreaConstraints;
	
	public PacientePanel() throws ParseException{
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
	
	private void setConstraints() throws ParseException {
		add(getNameText(), getNameConstraints());
		add(getNameField(), getNameTextConstraints());
		
		add(getNascText(), getNascTextConstraints());
		add(getNascField(), getNascFieldConstraints());
		
		add(getEnterText(), getEnterTextConstraints());
		add(getEnterField(), getEnterFieldConstraints());
		
		add(getAgeText(), getAgeConstraints());
		add(getAgeField(), getAgeFieldConstraints());
		
		add(getRoomText(), getRoomConstraints());
		add(getRoomField(), getRoomFieldConstraints());
		
		add(getAllergyText(), getAllergyTextConstraints());
		add(getAllergyScrollPane(), getAllergyAreaConstraints());
	}
	
	public JLabel getNameText() {
		if(nameText == null){
			nameText = new JLabel("Nome paciente:");
		}
		return nameText;
	}

	public GridBagConstraints getNameConstraints() {
		if(nameConstraints == null) {
			nameConstraints = new GridBagConstraints();
			nameConstraints.gridx = 0;
			nameConstraints.gridy = 0;
			nameConstraints.insets = new Insets(2, 2, 2, 2);
			nameConstraints.anchor = GridBagConstraints.WEST;
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
			nameFieldConstraints.gridwidth = 4;
			nameFieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return nameFieldConstraints;
	}

	public JLabel getNascText() {
		if(nascText == null) {
			nascText = new JLabel("Data Nasc.");
		}
		return nascText;
	}

	public GridBagConstraints getNascTextConstraints() {
		if(nascTextConstraints == null){
			nascTextConstraints = new GridBagConstraints();
			nascTextConstraints.gridx = 5;
			nascTextConstraints.gridy = 0;
			nascTextConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return nascTextConstraints;
	}

	public JFormattedTextField getNascField() throws ParseException {
		if(nascField == null){
			
			try{
				MaskFormatter dataFormat = new MaskFormatter("##/##/####");
				nascField = new JFormattedTextField(dataFormat);
				Dimension dimension = nascField.getPreferredSize();
				dimension.width = 70;
				nascField.setPreferredSize(dimension);
			} catch(ParseException e) {
				
			}
			
			
		}
		return nascField;
	}

	public GridBagConstraints getNascFieldConstraints() {
		if(nascFieldConstraints == null){
			nascFieldConstraints = new GridBagConstraints();
			nascFieldConstraints.gridx = 6;
			nascFieldConstraints.gridy = 0;
			nascFieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return nascFieldConstraints;
	}


	public JLabel getEnterText() {
		if(enterText == null) {
			enterText = new JLabel("Data de entrada:");
		}
		return enterText;
	}

	public GridBagConstraints getEnterTextConstraints() {
		if(enterTextConstraints == null){
			enterTextConstraints = new GridBagConstraints();
			enterTextConstraints.gridx = 0;
			enterTextConstraints.gridy = 1;
			enterTextConstraints.insets = new Insets(2, 2, 2, 2);
			enterTextConstraints.anchor = GridBagConstraints.WEST;
		}
		return enterTextConstraints;
	}

	public JFormattedTextField getEnterField() {
		if(enterField == null) {
			try{
				MaskFormatter dataFormat = new MaskFormatter("##/##/####");
				enterField = new JFormattedTextField(dataFormat);
				Dimension dimension = nascField.getPreferredSize();
				dimension.width = 70;
				enterField.setPreferredSize(dimension);
			} catch(ParseException e) {
				
			}
		}
		return enterField;
	}

	public GridBagConstraints getEnterFieldConstraints() {
		if(enterFieldConstraints == null){
			enterFieldConstraints = new GridBagConstraints();
			enterFieldConstraints.gridx = 1;
			enterFieldConstraints.gridy = 1;
			enterFieldConstraints.anchor = GridBagConstraints.WEST;
			enterFieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return enterFieldConstraints;
	}

	public JLabel getAgeText() {
		if(ageText == null){
			ageText = new JLabel("Idade:");
		}
		return ageText;
	}

	public GridBagConstraints getAgeConstraints() {
		if(ageConstraints == null) {
			ageConstraints = new GridBagConstraints();
			ageConstraints.gridx = 2;
			ageConstraints.gridy = 1;
			ageConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return ageConstraints;
	}

	public JFormattedTextField getAgeField() {
		if(ageField == null) {
			try {
				MaskFormatter ageFormat = new MaskFormatter("##");
				ageField = new JFormattedTextField(ageFormat);
				Dimension dimension = ageField.getPreferredSize();
				dimension.width = 30;
				ageField.setPreferredSize(dimension);
			} catch(ParseException e) {
				
			}
			
		}
		return ageField;
	}

	public GridBagConstraints getAgeFieldConstraints() {
		if(ageFieldConstraints == null) {
			ageFieldConstraints = new GridBagConstraints();
			ageFieldConstraints.gridx = 3;
			ageFieldConstraints.gridy = 1;
			ageFieldConstraints.anchor = GridBagConstraints.WEST;
			ageFieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return ageFieldConstraints;
	}
	
	public JLabel getRoomText() {
		if(roomText == null){
			roomText = new JLabel("Quarto:");
		}
		return roomText;
	}

	public GridBagConstraints getRoomConstraints() {
		if(roomConstraints == null) {
			roomConstraints = new GridBagConstraints();
			roomConstraints.gridx = 4;
			roomConstraints.gridy = 1;
			roomConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return roomConstraints;
	}

	public JFormattedTextField getRoomField() {
		if(roomField == null) {
			try {
				MaskFormatter roomFormat = new MaskFormatter("###");
				roomField = new JFormattedTextField(roomFormat);
				Dimension dimension = roomField.getPreferredSize();
				dimension.width = 30;
				roomField.setPreferredSize(dimension);
			} catch(ParseException e){
				
			}
			
		}
		return roomField;
	}

	public GridBagConstraints getRoomFieldConstraints() {
		if(roomFieldConstraints == null) {
			roomFieldConstraints = new GridBagConstraints();
			roomFieldConstraints.gridx = 5;
			roomFieldConstraints.gridy = 1;
			roomFieldConstraints.anchor = GridBagConstraints.WEST;
			roomFieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return roomFieldConstraints;
	}

	public JLabel getAllergyText() {
		if(allergyText == null){
			allergyText = new JLabel("Observações:");
		}
		return allergyText;
	}

	public GridBagConstraints getAllergyTextConstraints() {
		if(allergyTextConstraints == null){
			allergyTextConstraints = new GridBagConstraints();
			allergyTextConstraints.gridx = 0;
			allergyTextConstraints.gridy = 2;
			allergyTextConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
			allergyTextConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return allergyTextConstraints;
	}

	public JScrollPane getAllergyScrollPane() {
		if(allergyScrollPane == null) {
			allergyScrollPane = new JScrollPane(getAllergyArea());
			allergyScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			allergyScrollPane.setPreferredSize(new Dimension(250, 50));
		}
		return allergyScrollPane;
	}

	public JTextArea getAllergyArea() {
		if(allergyArea == null) {
			allergyArea = new JTextArea();
			allergyArea.setLineWrap(true);
			allergyArea.setWrapStyleWord(true);
		}
		return allergyArea;
	}

	public GridBagConstraints getAllergyAreaConstraints() {
		if(allergyAreaConstraints == null) {
			allergyAreaConstraints = new GridBagConstraints();
		}
		allergyAreaConstraints.gridx = 1;
		allergyAreaConstraints.gridy = 2;
		allergyAreaConstraints.gridwidth = 6;
		allergyAreaConstraints.anchor = GridBagConstraints.WEST;
		allergyAreaConstraints.insets = new Insets(2, 2, 2, 2);
		return allergyAreaConstraints;
	}
	
	public boolean checkEmpty() throws ParseException{
		if(getNameField().getText().equals("")|| getNascField().equals("") ||
				getEnterField().equals("") || getAgeField().equals("") ||
				getRoomField().equals("") || getAllergyArea().equals("")) {
			
			JOptionPane.showMessageDialog(null, "Há campos sem preencher");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNameField().getText()+";");
		try {
			sb.append(getNascField().getText()+";");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sb.append(getEnterField().getText()+";");
		sb.append(getAgeField().getText()+";");
		sb.append(getRoomField().getText()+";");
		sb.append(getAllergyArea().getText());
		return sb.toString();
	}
		
}
