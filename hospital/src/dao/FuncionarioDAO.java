package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FuncionarioDAO {
	
	private static final String FUNCIONARIO = "funcionarios.txt";
	
	public void writeFile(String textToWrite) throws IOException{
		File file = new File(FUNCIONARIO);
		if(!file.exists()){
			file.createNewFile();
		}
		
		FileOutputStream fos = new FileOutputStream(file, true);
		PrintStream ps = new PrintStream(fos);
		ps.println(textToWrite);
		ps.close();
	}

}
