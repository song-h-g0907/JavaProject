package l.io.ex3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileController {
	FileDAO fd = new FileDAO();
	public boolean checkName(String file) {
		return fd.checkName(file);
	}
	public void fileSave(String file, StringBuilder sb) {
		
	}
	public StringBuilder fileOpen(String file) {
		StringBuilder res = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file));){
			String str=null;
			while((str=br.readLine()) != null) {
				res.append(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException el) {
			el.printStackTrace();
		}
		return res;
	}
	public void fileEdit(String file, StringBuilder sb) {
		fd.fileEdit(file, sb.toString());
	}
}
