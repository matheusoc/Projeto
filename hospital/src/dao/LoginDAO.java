package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginDAO {
	
	private Scanner scanner;
	
	public ArrayList readFile(){
		File file = new File("logins.txt");
		ArrayList<String> array = new ArrayList<>();
		if(file.exists()) {
			
			try {
				
				scanner = new Scanner(file);
				while(scanner.hasNextLine()) {
					array.add(scanner.nextLine());
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
