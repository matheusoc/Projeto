package view.funcionario;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import view.components.ButtonsListener;
import view.components.ButtonsPanel;

public class FuncionarioFrame extends JFrame {
	
	private static final long serialVersionUID = -1030524573484086342L;
	
	private FuncionarioPanel funcionarioPanel;
	private ButtonsPanel buttonsPanel;
	
	public FuncionarioFrame(){
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		init();
		pack();
	}

	private void init() {
		add(getFuncionarioPanel(), BorderLayout.CENTER);
		add(getConfirmLabel(), BorderLayout.PAGE_END);
	}
	
	public FuncionarioPanel getFuncionarioPanel(){
		if(funcionarioPanel == null) {
			try {
				funcionarioPanel = new FuncionarioPanel();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return funcionarioPanel;
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
		
	}
}
