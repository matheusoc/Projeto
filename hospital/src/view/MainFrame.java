package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 8456560429229699542L;
	
	private JMenuBar menuBar;
	
	private JMenu menuRegister;
	private JMenu menuList;
	
	private JMenuItem itemPaciente;
	private JMenuItem itemFuncionario;
	
	private JMenuItem listPacientes;
	private JMenuItem listFuncionarios;

	public MainFrame(int width, int height) {
		setVisible(true);
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		init();
	}
	
	private void init(){
		setJMenuBar(getMainMenuBar());
	}


	private JMenuBar getMainMenuBar() {
		if(menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuRegister());
			menuBar.add(getMenuList());
		}
		return menuBar;
	}
	
	public JMenu getMenuRegister() {
		if(menuRegister == null) {
			menuRegister = new JMenu("Cadastrar");
			menuRegister.add(getItemPaciente());
			menuRegister.addSeparator();
			menuRegister.add(getItemFuncionario());
		
		}
		return menuRegister;
	}
	
	public JMenu getMenuList() {
		if(menuList == null) {
			menuList = new JMenu("Listar");
			menuList.add(getListPacientes());
			menuList.addSeparator();
			menuList.add(getListFuncionarios());
		}
		return menuList;
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

	
	public JMenuItem getListPacientes() {
		if(listPacientes == null) {
			listPacientes = new JMenuItem("Pacientes");
		}
		return listPacientes;
	}

	public JMenuItem getListFuncionarios() {
		if(listFuncionarios == null) {
			listFuncionarios = new JMenuItem("Funcionários");
		}
		return listFuncionarios;
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
				
			}
		};
	}

}
