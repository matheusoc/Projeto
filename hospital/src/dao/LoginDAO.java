package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginDAO {
	
	private static final String LOGINFILE = "logins.txt";
	
	private Scanner scanner;
	
	public ArrayList<String[]> readFile(){
		File file = new File(LOGINFILE);
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
