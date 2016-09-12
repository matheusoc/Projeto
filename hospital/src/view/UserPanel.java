package view;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class UserPanel extends JPanel{

	private static final long serialVersionUID = 2264463164562112935L;
	
	private JTextField userText;
	private JLabel userLabel;

	private JLabel passLabel;
	private JPasswordField passText;
	
	private GridLayout layout;
	
	public UserPanel() {
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
		TitledBorder titledBorder = new TitledBorder("Login de Usuário:");
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
		
		add(getUserLabel());
		add(getUserText());
		add(getPassLabel());
		add(getPassText());
	}
	
	public JTextField getUserText() {
		if(userText == null) {
			userText = new JTextField();
			Dimension d = userText.getPreferredSize();
			d.width = 100;
			userText.setPreferredSize(d);
		}
		return userText;
	}
	

	public JLabel getUserLabel() {
		if(userLabel == null) {
			userLabel = new JLabel("User name:");
			userLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		return userLabel;
	}

	public JPasswordField getPassText() {
		if(passText == null) {
			passText = new JPasswordField();
			Dimension d = passText.getPreferredSize();
			d.width = 100;
			passText.setPreferredSize(d);
		}
		return passText;
	}

	public JLabel getPassLabel() {
		if(passLabel == null) {
			passLabel = new JLabel("Password:");
			passLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		return passLabel;
	}
	
	public String getUser(){
		String user = getUserText().getText();
		String password = new String(getPassText().getPassword());
		String a = user+";"+password;
		return a;
	}
}
