package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RemediosDAO {
	
	private Scanner scanner;
	private static final String REMEDIO = "remedios.txt";
	
	public void writeFile(String textToWrite) {
		File file = new File(REMEDIO);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(file, true);
				PrintStream ps = new PrintStream(fos);
				ps.println(textToWrite);
				ps.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		
		
	}
	
	public ArrayList<String[]> readFile(){
		File file = new File(REMEDIO);
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
	
	public void eraseAndWrite(String[] textToWrite){
		File file = new File(REMEDIO);
		ArrayList<String[]> array = readFile();
		for(int i = 0; i<array.size(); i++){
			if(array.get(i)[0].equals(textToWrite[0])){
				array.remove(i);
				break;
			}
		}
		
		try {
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file, true);
			PrintStream ps = new PrintStream(fos);
			for(String[] write: array) {
				String sb = write[0]+";"+write[1]+";"+write[2]+";"+write[3];
				ps.println(sb);
			}
			textToWrite[3] = "med";
			String sb = textToWrite[0]+";"+textToWrite[1]+";"+textToWrite[2]+";"+textToWrite[3];
			ps.println(sb);
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void eraseAll(String[] textToWrite){
		File file = new File(REMEDIO);
		ArrayList<String[]> array = readFile();
		for(int i = 0; i<array.size(); i++){
			if(array.get(i)[0].equals(textToWrite[0])){
				array.remove(i);
				break;
			}
		}
		
		try {
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file, true);
			PrintStream ps = new PrintStream(fos);
			for(String[] write: array) {
				String sb = write[0]+";"+write[1]+";"+write[2]+";"+write[3];
				ps.println(sb);
			}
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
