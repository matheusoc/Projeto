package view.paciente;

import java.awt.BorderLayout;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFrame;

import dao.PacienteDAO;
import view.components.ButtonsListener;
import view.components.ButtonsPanel;

public class PacienteFrame extends JFrame{
	
	private static final long serialVersionUID = 6900892982050055367L;	
	
	private PacientePanel pacientePanel;
	private ButtonsPanel buttonsPanel;
	
	public PacienteFrame(){
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		init();
		pack();
	}

	private void init() {
		add(getPacientePanel(), BorderLayout.CENTER);
		add(getConfirmLabel(), BorderLayout.PAGE_END);
	}
	
	public PacientePanel getPacientePanel(){
		if(pacientePanel == null) {
			try {
				pacientePanel = new PacientePanel();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pacientePanel;
	}
	
	public ButtonsPanel getConfirmLabel() {
		if(buttonsPanel == null) {
			buttonsPanel = new ButtonsPanel();
		}
	
		buttonsPanel.addButtonsListener(new ButtonsListener() {
			
			@Override
			public void okPerform() {
				okClicked();
			}
			

			@Override
			public void cancelPerform() {
				cancelCliked();
				
			}

			
		});
		return buttonsPanel;
	}
	private void cancelCliked() {
		dispose();
	}
	private void okClicked() {
		try{
			if(getPacientePanel().checkEmpty()) {
				String write = getPacientePanel().toString();
				PacienteDAO pDAO = new PacienteDAO();
				try {
					pDAO.writeFile(write);
				} catch(IOException e){
					
				}
				dispose();
			}
		} catch(ParseException e) {
			
		}
		
	}
}
