package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PacienteDAO {
	
	private Scanner scanner;
	
	private static final String PACIENTEFILE = "pacientes.txt";
	
	public void writeFile(String textToWrite) throws IOException{
		ConfigDAO dao = new ConfigDAO();
		File file = new File(PACIENTEFILE);
		if(!file.exists()){
			file.createNewFile();
		}
		textToWrite = dao.read()+";"+ textToWrite;
		FileOutputStream fos = new FileOutputStream(file, true);
		PrintStream ps = new PrintStream(fos);
		ps.println(textToWrite);
		ps.close();
	}
	
	public ArrayList<String[]> readFile(){
		File file = new File(PACIENTEFILE);
		ArrayList<String[]> array = new ArrayList<>();
		String line;
		String[] dados;
		if(file.exists()) {
			
			try {
				
				scanner = new Scanner(file);
				while(scanner.hasNextLine()) {
					line = scanner.nextLine();
					dados = line.split(";");
					array.add(dados);
				}
			} catch(FileNotFoundException e) {
				
			} finally {
				scanner.close();
			}
			
		} else {
			System.out.println("Arquivo não encontrado");
		}
		
		return array;
	}
}
