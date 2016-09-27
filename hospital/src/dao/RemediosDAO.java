package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RemediosDAO {
	
	
	private static final String REMEDIO = "remedios.txt";
	
	public void writeFile(String textToWrite) {
		File file = new File(REMEDIO);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
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
		
	}
	
}
