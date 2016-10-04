package controller;

import java.io.File;
import java.io.IOException;

import dao.ConfigDAO;
import dao.LoginDAO;

public abstract class ResetAll {
	
	private static final String PACIENTEFILE = "pacientes.txt";
	private static final String CONFIG = "config.txt";
	private static final String FUNCIONARIO = "funcionarios.txt";
	private static final String LOGINFILE = "logins.txt";
	private static final String REMEDIO = "remedios.txt";
	
	public static void resetAll(){
		File pacienteFile = new File(PACIENTEFILE);
		File confFile = new File(CONFIG);
		File funcFile = new File(FUNCIONARIO);
		File loginFile = new File(LOGINFILE);
		File remedioFile = new File(REMEDIO);
		
		if(pacienteFile.exists()){
			pacienteFile.delete();
			try {
				pacienteFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(confFile.exists()){
			confFile.delete();
			try {
				confFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ConfigDAO DAO = new ConfigDAO();
			DAO.write(0);
		}
		
		if(funcFile.exists()){
			funcFile.delete();
			try {
				funcFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(loginFile.exists()){
			loginFile.delete();
			try {
				loginFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			LoginDAO lDAO = new LoginDAO();
			try {
				lDAO.writeFile("admin;admin;4");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(remedioFile.exists()){
			remedioFile.delete();
			try {
				remedioFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
