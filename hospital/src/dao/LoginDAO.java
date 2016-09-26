package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginDAO {
	
	private static final String LOGINFILE = "logins.txt";
	
	private Scanner scanner;
	
	public void writeFile(String textToWrite) throws IOException{
		File file = new File(LOGINFILE);
		if(!file.exists()){
			file.createNewFile();
		}
		
		FileOutputStream fos = new FileOutputStream(file, true);
		PrintStream ps = new PrintStream(fos);
		ps.println(textToWrite);
		ps.close();
	}
	
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
