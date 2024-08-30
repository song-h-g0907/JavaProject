package l.io.ex1;

import java.io.File;
import java.io.IOException;

public class Run {
	
	/*
	 * 간단하게 파일을 만들어보자
	 * java.io.File클래스를 가지고
	 */
	public static void main(String[] args) {
		
		//1. 경로지정을 딱히 하지않고 파일 생성하기
		File f1 = new File("test.txt");//파일객체를 하나 만든상태(실제파일x)
		//2. 존재하는 폴더에 파일 생성
		File f2 = new File("D:\\test2.txt");
		//3. 존재하지 않는 결로에 파일생성
//		File f3 = new File("D:\\tmp\\test.txt");
		try {
			f1.createNewFile(); // createNewFile메소드가 실행할 때 실제 파일이 만들어짐
			f2.createNewFile();
//			
			//3. 폴더먼저 만들고 파일만들어지게 하는 방법
			File tmpFolder = new File("D:\\tmp");
			tmpFolder.mkdir();
			File f3 = new File("D:\\tmp\\test.txt");
			f3.createNewFile();
			
			File f4 = new File("ttt.txt");
			System.out.println();
			
			//----------------------------------------
			File folder = new File("parent");
			folder.mkdir();
			File file = new File("parent\\person.txt");
			file.createNewFile();
			
			System.out.println("파일명 : "+file.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
