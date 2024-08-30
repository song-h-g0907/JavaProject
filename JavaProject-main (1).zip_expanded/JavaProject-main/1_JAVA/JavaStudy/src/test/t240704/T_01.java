package test.t240704;

import java.util.Scanner;

public class T_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String ID = "myId";
		final String PWD = "myPassword12";
		String mid;
		String mpw;
		System.out.print("아이디 : ");
		mid=sc.nextLine();
		System.out.print("비밀번호 : ");
		mpw=sc.nextLine();
		if(mid.equals(ID)) {
			if(mpw.equals(PWD)) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}

}
