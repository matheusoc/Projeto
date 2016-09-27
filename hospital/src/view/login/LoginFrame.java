package view.login;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.LoginDAO;
import view.MainFrame;
import view.components.ButtonsListener;
import view.components.ButtonsPanel;

public class LoginFrame extends JFrame {
	
	private static final long serialVersionUID = 6597839756768366998L;
	
	private UserPanel userPanel;
	private ButtonsPanel buttonsPanel;
	private ArrayList<String[]> array;
	
	public LoginFrame() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		initialize();
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		
		LoginDAO login = new LoginDAO();
		array = login.readFile();

	}
	
	public void initialize() {
		add(getUserLabel(), BorderLayout.CENTER);
		add(getConfirmLabel(), BorderLayout.PAGE_END);
	}
	
	public UserPanel getUserLabel() {
		if(userPanel == null) {
			userPanel = new UserPanel();
		}
		return userPanel;
	}
	
	public ButtonsPanel getConfirmLabel() {
		if(buttonsPanel == null) {
			buttonsPanel = new ButtonsPanel();
		}
	
		buttonsPanel.addButtonsListener(new ButtonsListener() {
			
			@Override
			public void okPerform() {
				try {
					okClicked();
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void cancelPerform() {
				cancelCliked();
				
			}
		});
		return buttonsPanel;
	}
	
	private void okClicked() throws FileNotFoundException {
		String user = getUserLabel().getUser();
		int tag = 0;
		for(String[] list: array) {
			String line = list[0]+";"+list[1];
			if(line.equals(user)) {
				JOptionPane.showMessageDialog(null, "Login feito com sucesso!!!");
				new MainFrame(700, 540, Integer.valueOf(list[2]));
				dispose();
				tag = 1;
				break;
			} 
			
		}
		if(tag == 0) {
			JOptionPane.showMessageDialog(null, "Login não realizado");
		}
		
	}
	
	private void cancelCliked() {
		String message = "Deseja mesmo sair ?";
		int i = JOptionPane.showConfirmDialog(this, message, "Sair", JOptionPane.YES_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			dispose();
			System.exit(0);
		}
	}
}