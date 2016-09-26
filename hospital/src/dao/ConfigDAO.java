package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ConfigDAO {

	private Scanner scanner;
	
	private static final String CONFIG = "config.txt";
	
	public int read(){
		File file = new File(CONFIG);
		int read = -1;
		if(file.exists()){
			try {
				scanner = new Scanner(file);
				read = Integer.valueOf(scanner.nextLine());
				write(read);
			} catch (FileNotFoundException e) {
				
			} finally {
				scanner.close();
			}
		}
		return read;
	}
	
	public void write(int i){
		File file = new File(CONFIG);
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch (IOException e) {
				
			}
		}
		FileOutputStream fos;
		PrintStream ps = null;
		try {
			fos = new FileOutputStream(file, false);
			ps = new PrintStream(fos);
			ps.print(i+1);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally{
			ps.close();
		}
		
	}
}
