package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.Medico;
import view.funcionario.FuncionarioFrame;
import view.login.LoginFrame;
import view.paciente.PacienteFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 8456560429229699542L;
	
	private JMenuBar menuBar;
	
	private JMenu menuRegister;
	private JMenu opcao;
	
	private JMenuItem itemPaciente;
	private JMenuItem itemFuncionario;
	
	private JMenuItem sair;
	
	private TablePanel tablePanel;
	
	private int access;

	public MainFrame(int width, int height, int access) {
		
		this.access = access;
		
		setVisible(true);
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		init();
	}
	
	private void init(){
		add(getTablePanel(), BorderLayout.CENTER);
		setJMenuBar(getMainMenuBar());
	}


	private JMenuBar getMainMenuBar() {
		if(menuBar == null) {
			menuBar = new JMenuBar();
			if(access == 4 || access == Medico.MEDICO)	{
				menuBar.add(getMenuRegister());
			}
			menuBar.add(getOpcao());
		}
		return menuBar;
	}
	
	public JMenu getMenuRegister() {
		if(menuRegister == null) {
			menuRegister = new JMenu("Cadastrar");
			menuRegister.add(getItemPaciente());
			if(access == 4) {
				menuRegister.addSeparator();
				menuRegister.add(getItemFuncionario());
			}
			
		}
		return menuRegister;
	}
	
	public JMenu getOpcao(){
		if(opcao == null) {
			opcao = new JMenu("Opções");
			opcao.add(getSair());
		}
		return opcao;
	}
	
	public JMenuItem getSair(){
		if(sair == null) {
			sair = new JMenuItem("Sair");
			sair.addActionListener(sairDaConta());
		}
		return sair;
	}

	public JMenuItem getItemPaciente() {
		if(itemPaciente == null){
			itemPaciente = new JMenuItem("Paciente");
			
			itemPaciente.addActionListener(cadastrarPaciente());
		}
		return itemPaciente;
	}

	public JMenuItem getItemFuncionario() {
		if(itemFuncionario == null){
			itemFuncionario = new JMenuItem("Funcionário");
			itemFuncionario.addActionListener(cadastrarFuncionario());
		}
		return itemFuncionario;
	}	
	
	public TablePanel getTablePanel() {
		if(tablePanel == null) {
			tablePanel = new TablePanel(access);
		}
		return tablePanel;
	}

	private ActionListener cadastrarPaciente() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PacienteFrame();
			}
		};
	}
	
	private ActionListener cadastrarFuncionario() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioFrame();
			}
		};
	}
	
	private ActionListener sairDaConta(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame();
				dispose();
			}
		};
	}

}
