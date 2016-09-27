package view.medicamentos;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.RemediosDAO;
import model.Enfermeiro;
import model.Farmaceutico;
import model.Medico;
import view.components.ButtonsListener;
import view.components.ButtonsPanel;

public class AdicionarMedFrame extends JFrame{

	private static final long serialVersionUID = 8903624461474043213L;
	
	private ButtonsPanel buttonsPanel;
	private AddMedPanel medPanel;
	private CriarMedPanel criarMedPanel;
	private MedicarPanel medicarPanel;
	private String id;
	private int access;
	
	public AdicionarMedFrame(String id, int access){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.access = access;
		this.id = id;
		initialize();
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	
	public void initialize() {
		if(access == Medico.MEDICO || access == 4){
			add(getMedPanel(), BorderLayout.CENTER);
		} else if(access == Farmaceutico.FARMACEUTICO){
			add(getCriarMedPanel(), BorderLayout.CENTER);
		} else if(access == Enfermeiro.ENFERMEIRO){
			add(getMedicarPanel());
		}
		add(getConfirmLabel(), BorderLayout.PAGE_END);
	}
	
	public AddMedPanel getMedPanel(){
		if(medPanel == null){
			medPanel = new AddMedPanel();
		}
		return medPanel;
	}
	
	public CriarMedPanel getCriarMedPanel() {
		if(criarMedPanel == null){
			criarMedPanel = new CriarMedPanel(id);
		}
		return criarMedPanel;
	}
	
	

	public MedicarPanel getMedicarPanel() {
		if(medicarPanel == null){
			medicarPanel = new MedicarPanel(id);
		}
		return medicarPanel;
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
				if(access == Medico.MEDICO || access == 4){
					if(getMedPanel().checkEmpty()){
						rDAO.writeFile(id+";"+getMedPanel().toString()+";nok");
						dispose();	
					} 
				}else if(access == Enfermeiro.ENFERMEIRO){
					if(getMedicarPanel().getCheckPac().isSelected()){
						String[] med = getCriarMedPanel().getMed();
						rDAO.eraseAll(med);
						dispose();	
					} else {
						JOptionPane.showMessageDialog(null, "Remédio não selecionado");
					}
				} else if(access == Farmaceutico.FARMACEUTICO) {
					if(getCriarMedPanel().getCheckPac().isSelected()){
						String[] med = getCriarMedPanel().getMed();
						rDAO.eraseAndWrite(med);
						dispose();	
					}
					else {
						JOptionPane.showMessageDialog(null, "Remédio não selecionado");
					}
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
