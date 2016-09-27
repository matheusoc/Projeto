package view.medicamentos;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import dao.RemediosDAO;
import view.components.ButtonsListener;
import view.components.ButtonsPanel;

public class AdicionarMedFrame extends JFrame{

	private static final long serialVersionUID = 8903624461474043213L;
	
	private ButtonsPanel buttonsPanel;
	private AddMedPanel medPanel;
	private String id;
	
	public AdicionarMedFrame(String id){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		initialize();
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		
		this.id = id;
	}
	
	public void initialize() {
		add(getMedPanel(), BorderLayout.CENTER);
		add(getConfirmLabel(), BorderLayout.PAGE_END);
	}
	
	public AddMedPanel getMedPanel(){
		if(medPanel == null){
			medPanel = new AddMedPanel();
		}
		return medPanel;
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
			
			private void okClicked() {
				RemediosDAO rDAO = new RemediosDAO();
				if(getMedPanel().checkEmpty()){
					rDAO.writeFile(id+";"+getMedPanel().toString()+";nok");
					dispose();
				}
			}

			@Override
			public void cancelPerform() {
				cancelCliked();
				
			}

			private void cancelCliked() {
				dispose();
			}
		});
		return buttonsPanel;
	}

}
