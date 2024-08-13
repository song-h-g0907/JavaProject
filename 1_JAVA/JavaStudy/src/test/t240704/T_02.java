package test.t240704;

import java.util.Scanner;

public class T_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String ra = sc.nextLine();
		switch(ra) {
		case "관리자":
			System.out.println("회원관리, 게시글관리, 게시글작성, 댓글작성, 게시글조회");
			break;
		case "회원":
			System.out.println("게시글 작성, 게시글 조회, 댓글 작성");
			break;
		case "비회원":
			System.out.println("게시글 조회");
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
		}
		if (ra.equals("관리자")) {
			System.out.println("회원관리, 게시글관리, 게시글작성, 댓글작성, 게시글조회");
		}else if(ra.equals("회원")) {
			System.out.println("게시글 작성, 게시글 조회, 댓글 작성");
		}else if(ra.equals("비회원")) {
			System.out.println("게시글 조회");
		}else {
			System.out.println("잘못입력하셨습니다.");
		}
	}

}
