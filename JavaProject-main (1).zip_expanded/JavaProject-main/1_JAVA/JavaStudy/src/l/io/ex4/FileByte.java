package l.io.ex4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByte {
	/*
	 *  "바이트 스트림"을 통한 입출력해보기
	 *  
	 *  -바이트스트림 : 데이터를 1바이트 단위로 전송하는 통로(좁은통로 -> 한글깨짐)
	 *  -기반스트림 : 외부매체와 직접적으로 연결하는 통로
	 *  
	 *  xxxInputStream : xxx매체로부터 데이터를 입력받는 통로(외부로부터 데이터를 읽어오겠다.)
	 *  xxxOutputStream : xxx매체로부터 데이터를 출력하는 통로(외부매체로 데이터를 내보내겠다.)
	 *  
	 *  
	 */
	
	//프로그램(자바) -> 외부매체(파일) 데이터를 출력(프로그램상의 데이터를 팡일로 내보내보자)
	public void fileSave() {
		
		//1. FileOutputStream 객체 생성
		//해당파일이 없으면 새로 만들어주고 통로연결 / 있으면 해당 파일에 통로연결 
		//FileOutputStream에 두번째 매개변수에 true를 전달하면 해당 파일이 존재할 경우 기존데이터에 이어서 작성을 한다.
		try (FileOutputStream fout = new FileOutputStream("byte_test.txt",true);){
			
			//2. 파일에 데이터 출력
			//	 숫자를 출력하는 문자를 출력하면 실제로는 파일에 문자로 기록이 된다.
			//	(0~127)
			fout.write('1');
			fout.write('2');
			fout.write('3');
			fout.write('아'); //한글은 2byte여서 깨져서 저장됨
			
			
			fout.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	public void fileRead() {
		
		//1.스트림생성
		//2.스트림을 통해서 입력받음
		//3.사용이끝난 스트림 반납
		
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("byte_test.txt");
			while(true) {
				int value = fin.read();
				if(value == -1) {
					break;
				}
				System.out.print((char)value);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
}
