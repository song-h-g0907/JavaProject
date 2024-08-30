package m.api.ex2;

import java.util.Scanner;

public class TokenMenu {
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();
	public void mainMenu() {
		while (true) {
			System.out.println("1. 지정 문자열");
			System.out.println("2. 입력 문자열");
			System.out.println("3. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 1:
				tokenMenu();
				break;
			case 2:
				inputMenu();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
		
	}
	public void tokenMenu() {
		String str = "J a v a P r o g r a m ";
		System.out.println(str);
		System.out.println(str.length());
		System.out.println(tc.afterToken(str));
		System.out.println(tc.afterToken(str).length());
		System.out.println(tc.afterToken(str).toUpperCase());
	}
	public void inputMenu() {
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		System.out.println(tc.firstCap(str));
		System.out.print("찾을 문자를 하나를 입력하세요 : ");
		char ch = sc.nextLine().charAt(0);
		System.out.println(tc.findChar(str, ch));
	}
}
