package k.exception.ex2;
import java.util.Scanner;
public class CharacterMenu {
	CharacterController cc = new CharacterController();
	Scanner sc = new Scanner(System.in);
	public void menu() {
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		try {
			int len = cc.countAlpha(str);
			System.out.println("'"+str+"'에 포함된 영문자 개수 : "+len);
		}catch(CharCheckException c) {
			c.printStackTrace();
		}finally {
			sc.close();
		}
		
	}
}
