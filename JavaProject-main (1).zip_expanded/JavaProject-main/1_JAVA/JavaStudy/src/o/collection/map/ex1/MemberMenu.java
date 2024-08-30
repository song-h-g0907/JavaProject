package o.collection.map.ex1;

import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	public void mainMenu() {
		System.out.println("========== KH 사이트 ==========");
		while(true) {
			int num =0;
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			try {
				num = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("잘못된입력입니다.");
				sc.nextLine();
				continue;
			}
			switch (num) {
			case 1:
				joinMembership();
				break;
			case 2:
				login();
				memberMenu();
				break;
			case 3:
				sameName();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(0);
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
	}
	public void memberMenu() {
		System.out.println("****** 회원 메뉴 ******");
		while(true) {
			int num =0;
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 선택 : ");
			try {
				num = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("잘못된입력입니다.");
				sc.nextLine();
				continue;
			}
			switch (num) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				System.out.println("로그아웃 되었습니다.");
				return;
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
	}
	public void joinMembership() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			boolean su =mc.joinMembership(id, new Member(pw,name));
			if(su) {
				System.out.println("성공적으로 회원가입 완료하였습니다.");
				break;
			}else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
				continue;
			}
		}
		
	}
	public void login() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			String name = mc.login(id, pw);
			if(name!=null) {
				System.out.println(name +"님, 환영합니다.");
				break;
			}else {
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			}
		}
		
	}
	public void changePassword() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			System.out.print("새로운 비밀번호 : ");
			String newpw = sc.nextLine();
			if(mc.changePassword(id, pw, newpw)) {
				System.out.println("비밀번호 변경에 성공했습니다");
				break;
			}else {
				System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요");
			}
		}
	}
	/*
	 * 소서 에기르
	 * 기상 베히 하멘 하키
	 * 알카 베히 하멘 하키
	 * 서머너 하멘 하키
	 * 건슬 노멘
	 * 
	 */
	public void changeName() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			if(mc.login(id, pw)==null) {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요");
				continue;
			}
			String name = mc.login(id, pw);
			System.out.println("현재 설정된 이름 : "+name);
			System.out.print("변경할 이름 : ");
			String nname = sc.nextLine();
			mc.changeName(id, nname);
			System.out.println("이름 변경에 성공했습니다.");
		}
	}
	public void sameName() {
		System.out.println("검색할 이름 :");
		String name = sc.nextLine();
		TreeMap result = mc.sameName(name);
		if(result.isEmpty()) {
			System.out.println("회원을 찾지 못하였습니다.");
			
		}else {
			for(Object entry : result.entrySet()) {
				Entry<String, String> en =(Entry)entry;
				System.out.println(en.getKey() + " : " + en.getValue());
			}
		}
	}
}
