package test.t240705;

import java.util.Scanner;

public class T_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			String o = sc.nextLine();
			if (o.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			System.out.print("정수1 : ");
			int a = sc.nextInt();
			sc.nextLine();
			System.out.print("정수2 : ");
			int b = sc.nextInt();
			sc.nextLine();
			switch(o.charAt(0)) {
			case '+':
				System.out.println(a+" + "+b+" = " +(a+b));
				break;
			case '-':
				System.out.println(a+" - "+b+" = " +(a-b));
				break;
			case '*':
				System.out.println(a+" * "+b+" = " +(a*b));
				break;
			case '/':
				if (b==0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					break;
				}
				System.out.println(a+" / "+b+" = " +(a/b));
				break;
			case '%':
				if (b==0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					break;
				}
				System.out.println(a+" % "+b+" = " +(a%b));
				break;
			default :
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
			}
		}
		
	}

}
