package view.funcionario;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class FuncionarioPanel extends JPanel{

	private static final long serialVersionUID = 2159474150943882364L;
	
	private GridBagLayout bagLayout;
	
	private JLabel nameText;
	private GridBagConstraints nameConstraints;
	private JTextField nameField;
	private GridBagConstraints nameFieldConstraints;
	
	private JLabel nascText;
	private GridBagConstraints nascTextConstraints;
	private JFormattedTextField nascField;
	private GridBagConstraints nascFieldConstraints;
	
	private JLabel ageText;
	private GridBagConstraints ageConstraints;
	private JFormattedTextField ageField;
	private GridBagConstraints ageFieldConstraints;
	
	private JLabel numRegistro;
	private GridBagConstraints numRegistroConstraints;
	private JFormattedTextField campoRegistro;
	private GridBagConstraints campoRegistroConstraints;
	
	private JLabel funcaoText;
	private GridBagConstraints funcaoTextConstraints;
	private JComboBox<String> funcaoComboBox;
	private GridBagConstraints funcaoComboBoxCostraints;
	
	private JLabel userLogin;
	private GridBagConstraints userLoginGridBagConstraints;
	private JTextField loginField;
	private GridBagConstraints loginFieldConstraints;
	
	private JLabel pass1;
	private GridBagConstraints pass1Constraints;
	private JPasswordField pass1Field;
	private GridBagConstraints pass1FieldConstraints;
	
	private JLabel pass2;
	private GridBagConstraints pass2Constraints;
	private JPasswordField pass2Field;
	private GridBagConstraints pass2FieldConstraints;
	
	public FuncionarioPanel() throws ParseException {
		init();
		setLayout(getBagLayout());
		setConstraints();
	}

	private void init() {
		
		setBorder(createBorder());
	}
	
	public Border createBorder() {
		EmptyBorder innerEmpty = new EmptyBorder(5, 5, 5, 5);
		TitledBorder titledBorder = new TitledBorder("Cadastro de funcionários:");
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
	
	private void setConstraints() throws ParseException{
		add(getNameText(), getNameConstraints());
		add(getNameField(), getNameFieldConstraints());
		
		add(getNascText(), getNascTextConstraints());
		add(getNascField(), getNascFieldConstraints());
		
		add(getAgeText(), getAgeConstraints());
		add(getAgeField(), getAgeFieldConstraints());
		
		add(getNumRegistro(), getNumRegistroConstraints());
		add(getCampoRegistro(), getCampoRegistroConstraints());
		
		add(getFuncaoText(), getFuncaoTextConstraints());
		add(getFuncaoComboBox(), getFuncaoComboBoxCostraints());
		
		add(getUserLogin(), getUserLoginGridBagConstraints());
		add(getLoginField(), getLoginFieldConstraints());
		
		add(getPass1(), getPass1Constraints());
		add(getPass1Field(), getPass1FieldConstraints());
		
		add(getPass2(), getPass2Constraints());
		add(getPass2Field(), getPass2FieldConstraints());
	}
	
	public JLabel getNameText() {
		if(nameText == null){
			nameText = new JLabel("Nome Funcionário:");
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
			dimension.width = 150;
			nameField.setPreferredSize(dimension);
		}
		return nameField;
	}

	public GridBagConstraints getNameFieldConstraints() {
		if(nameFieldConstraints == null) {
			nameFieldConstraints = new GridBagConstraints();
			nameFieldConstraints.gridx = 1;
			nameFieldConstraints.gridy = 0;
			nameFieldConstraints.gridwidth = 2;
			nameFieldConstraints.anchor = GridBagConstraints.WEST;
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
			nascTextConstraints.gridx = 2;
			nascTextConstraints.gridy = 0;
			nascTextConstraints.anchor = GridBagConstraints.EAST;
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
			nascFieldConstraints.gridx = 3;
			nascFieldConstraints.gridy = 0;
			nascFieldConstraints.insets = new Insets(2, 2, 2, 2);
			nascFieldConstraints.anchor = GridBagConstraints.WEST;
		}
		return nascFieldConstraints;
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
			ageConstraints.gridx = 0;
			ageConstraints.gridy = 1;
			ageConstraints.anchor = GridBagConstraints.EAST;
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
			ageFieldConstraints.gridx = 1;
			ageFieldConstraints.gridy = 1;
			ageFieldConstraints.anchor = GridBagConstraints.WEST;
			ageFieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return ageFieldConstraints;
	}

	public JLabel getNumRegistro() {
		if(numRegistro == null) {
			numRegistro = new JLabel("Número de registro");
		}
		return numRegistro;
	}

	public GridBagConstraints getNumRegistroConstraints() {
		if(numRegistroConstraints == null) {
			numRegistroConstraints = new GridBagConstraints();
			numRegistroConstraints.gridx = 2;
			numRegistroConstraints.gridy = 1;
			numRegistroConstraints.anchor = GridBagConstraints.WEST;
			numRegistroConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return numRegistroConstraints;
	}

	public JFormattedTextField getCampoRegistro() {
		if(campoRegistro == null) {
			try {
				MaskFormatter regFormat = new MaskFormatter("###.###");
				campoRegistro = new JFormattedTextField(regFormat);
				Dimension dimension = campoRegistro.getPreferredSize();
				dimension.width = 70;
				campoRegistro.setPreferredSize(dimension);
			} catch(ParseException e) {
				
			}
		}
		return campoRegistro;
	}

	public GridBagConstraints getCampoRegistroConstraints() {
		if(campoRegistroConstraints == null) {
			campoRegistroConstraints = new GridBagConstraints();
			campoRegistroConstraints.gridx = 3;
			campoRegistroConstraints.gridy = 1;
			campoRegistroConstraints.anchor = GridBagConstraints.WEST;
			campoRegistroConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return campoRegistroConstraints;
	}

	public JLabel getFuncaoText() {
		if(funcaoText == null) {
			funcaoText = new JLabel("Função");
		}
		return funcaoText;
	}

	public GridBagConstraints getFuncaoTextConstraints() {
		if(funcaoTextConstraints == null) {
			funcaoTextConstraints = new GridBagConstraints();
			funcaoTextConstraints.gridx = 0;
			funcaoTextConstraints.gridy = 2;
			funcaoTextConstraints.anchor = GridBagConstraints.EAST;
			funcaoTextConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return funcaoTextConstraints;
	}

	public JComboBox<String> getFuncaoComboBox() {
		if(funcaoComboBox == null) {
			String[] funcoes = {"Medico", "Enfermeiro", "Farmaceutico"};
			funcaoComboBox = new JComboBox<>(funcoes);
		}
		return funcaoComboBox;
	}

	public GridBagConstraints getFuncaoComboBoxCostraints() {
		if(funcaoComboBoxCostraints == null) {
			funcaoComboBoxCostraints = new GridBagConstraints();
			funcaoComboBoxCostraints.gridx = 1;
			funcaoComboBoxCostraints.gridy = 2;
			funcaoComboBoxCostraints.anchor = GridBagConstraints.WEST;
			funcaoComboBoxCostraints.insets = new Insets(2, 2, 2, 2);
		}
		return funcaoComboBoxCostraints;
	}

	public JLabel getUserLogin() {
		if(userLogin == null) {
			userLogin = new JLabel("Login:");
		}
		return userLogin;
	}

	public GridBagConstraints getUserLoginGridBagConstraints() {
		if(userLoginGridBagConstraints == null){
			userLoginGridBagConstraints = new GridBagConstraints();
			userLoginGridBagConstraints.gridx = 0;
			userLoginGridBagConstraints.gridy = 3;
			userLoginGridBagConstraints.anchor = GridBagConstraints.EAST;
			userLoginGridBagConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return userLoginGridBagConstraints;
	}

	public JTextField getLoginField() {
		if(loginField == null) {
			loginField = new JTextField();
			Dimension dimension = loginField.getPreferredSize();
			dimension.width = 100;
			loginField.setPreferredSize(dimension);
			
		}
		return loginField;
	}

	public GridBagConstraints getLoginFieldConstraints() {
		if(loginFieldConstraints == null) {
			loginFieldConstraints = new GridBagConstraints();
			loginFieldConstraints.gridx = 1;
			loginFieldConstraints.gridy = 3;
			loginFieldConstraints.anchor = GridBagConstraints.WEST;
			loginFieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return loginFieldConstraints;
	}

	public JLabel getPass1() {
		if(pass1 == null) {
			pass1 = new JLabel("Senha:");
		}
		return pass1;
	}

	public GridBagConstraints getPass1Constraints() {
		if(pass1Constraints == null){
			pass1Constraints = new GridBagConstraints();
			pass1Constraints.gridx = 2;
			pass1Constraints.gridy = 3;
			pass1Constraints.anchor = GridBagConstraints.EAST;
			pass1Constraints.insets = new Insets(2, 2, 2, 2);
		}
		return pass1Constraints;
	}

	public JPasswordField getPass1Field() {
		if(pass1Field == null){
			pass1Field = new JPasswordField();
			Dimension dimension = pass1Field.getPreferredSize();
			dimension.width = 100;
			pass1Field.setPreferredSize(dimension);
		}
		return pass1Field;
	}

	public GridBagConstraints getPass1FieldConstraints() {
		if(pass1FieldConstraints == null){
			pass1FieldConstraints = new GridBagConstraints();
			pass1FieldConstraints.gridx = 3;
			pass1FieldConstraints.gridy = 3;
			pass1FieldConstraints.anchor = GridBagConstraints.WEST;
			pass1FieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return pass1FieldConstraints;
	}

	public JLabel getPass2() {
		if(pass2 == null) {
			pass2 = new JLabel("Repita a senha:");
		}
		return pass2;
	}

	public GridBagConstraints getPass2Constraints() {
		if(pass2Constraints == null){
			pass2Constraints = new GridBagConstraints();
			pass2Constraints.gridx = 2;
			pass2Constraints.gridy = 4;
			pass2Constraints.anchor = GridBagConstraints.EAST;
			pass2Constraints.insets = new Insets(2, 2, 2, 2);
		}
		return pass2Constraints;
	}

	public JPasswordField getPass2Field() {
		if(pass2Field == null){
			pass2Field = new JPasswordField();
			Dimension dimension = pass2Field.getPreferredSize();
			dimension.width = 100;
			pass2Field.setPreferredSize(dimension);
		}
		return pass2Field;
	}

	public GridBagConstraints getPass2FieldConstraints() {
		if(pass2FieldConstraints == null){
			pass2FieldConstraints = new GridBagConstraints();
			pass2FieldConstraints.gridx = 3;
			pass2FieldConstraints.gridy = 4;
			pass2FieldConstraints.anchor = GridBagConstraints.WEST;
			pass2FieldConstraints.insets = new Insets(2, 2, 2, 2);
		}
		return pass2FieldConstraints;
	}
	
}
