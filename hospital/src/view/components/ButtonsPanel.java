package view.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;



public class ButtonsPanel extends JPanel{

	private static final long serialVersionUID = -2055101603972072938L;
	
	private ArrayList<ButtonsListener> listeners = new ArrayList<ButtonsListener>();
	
	private JButton okButton;
	private JButton cancelButton;
	
	public ButtonsPanel(){
		initialize();
	}
	public void initialize() {
		add(getOkButton());
		add(getCancelButton());
	}
	public JButton getOkButton() {
		if(okButton == null) {
			okButton = new JButton("OK");
		}
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				okClicked();
				
			}
		});
		return okButton;
	}

	public JButton getCancelButton() {
		if(cancelButton == null) {
			cancelButton = new JButton("Cancel");
		}
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cancelClicked();
				
			}
		});
		return cancelButton;
	}
	
	public void okClicked() {
		for(ButtonsListener listener: listeners) {
			listener.okPerform();
		}
	}
	
	public void cancelClicked() {
		for(ButtonsListener listener: listeners) {
			listener.cancelPerform();
		}
	}
	
	public void addButtonsListener(ButtonsListener listener) {
		listeners.add(listener);
	}
}
