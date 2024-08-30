package test.t240705;

import java.util.Scanner;

public class T_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(-포함) : ");
		char a=sc.nextLine().charAt(7);
		if(a=='1'||a=='3') {
			System.out.println("남자");
		}else if(a=='2'||a=='4'){
			System.out.println("여자");
		}else {
			System.out.println("잘못입력하셨습니다.");
		}
	}

}
