package com.kh.menu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import com.kh.controller.Controller;


public class MainMenu {
	private Controller cr = new Controller();
	private Scanner sc = new Scanner(System.in);
	public void menu() {
		while(true) {
			int num =0;
			System.out.println(title("로그인"));
			System.out.println("1. 로그인");
			System.out.println("2. 비회원 로그인");
			System.out.println("3. 회원가입");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			switch (num) {
			case 1:
				int a = cr.checkac();
				if(a==0) {
					memberMenu();
				}
				break;
			case 2:
				bememberMenu();
				break;
			case 3:
				this.insertac();
				break;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
	}
	
	public void bememberMenu() {
		int num =0;
		System.out.println(title("비회원"));
		System.out.println("비회원은 게시판 확인만 가능합니다.");
		cr.showBoard(cr.clpd(),1);
		while(true) {
			System.out.println("======================");
			System.out.println("1. 초기화면");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			switch (num) {
			case 1:
				menu();
				break;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
		
	}
	
	public void memberMenu() {
		int num =0;
		while(true) {
			System.out.println(title(""));
			System.out.println(cr.getUser().getNname()+"님 환영합니다.");
			System.out.println(title(""));
			System.out.println("1. 거래 게시판");
			System.out.println("2. 마이페이지");
			System.out.println("3. 로그아웃");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			switch (num) {
			case 1:
				boardMenu();
				break;
			case 2:
				myPage();
				break;
			case 3:
				System.out.println("로그아웃되었습니다.");
				System.out.println("초기화면으로 돌아갑니다.");
				return;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
		
	}
	
	public void myPage() {
		int num =0;
		while(true) {
			System.out.println(title("마이페이지"));
			System.out.println("1. 내 정보");
			System.out.println("2. 내 거래");
			System.out.println("3. 로그아웃");
			System.out.println("4. 이전 화면으로");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			switch (num) {
			case 1:
				myinfoPage();
				break;
			case 2:
				myBoardmenu();
				break;
			case 3:
				System.out.println("로그아웃되었습니다.");
				System.out.println("초기화면으로 돌아갑니다.");
				menu();
				break;
			case 4:
				return;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
	}
	
	public void myinfoPage() {
		
		int num =0;
		while(true) {
			System.out.println(title("내정보"));
			cr.myinfo();
			System.out.println(title(""));
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 닉네임 변경");
			System.out.println("3. 로그아웃");
			System.out.println("4. 이전 화면으로");
			System.out.println("5. 회원탈퇴");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			switch (num) {
			case 1:
				for(int i = 1 ; i <=5; i++) {
					String npwd;
					System.out.print("현재 비밀번호 : ");
					String pwd = sc.nextLine();
					if(cr.checkPwd(pwd)) {
						while(true) {
							System.out.print("새로운 비밀번호 : ");
							npwd = sc.nextLine();
							if(npwd.equals(cr.getUser().getPwd())) {
								System.out.println("기존 비밀번호와 일치합니다.");
								continue;
							}
							break;
						}
						while(true) {
							System.out.print("새로운 비밀번호 확인 : ");
							String nnpwd = sc.nextLine();
							if(cr.checkPwd(npwd,nnpwd)) {
								cr.changePwd(npwd);
								break;
							}
						}
					break;
					}else if(i==5) {
						System.out.println("5회 이상 틀렸습니다. 이전 화면으로 돌아갑니다.");
						break;
					}
					else {
						System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
						System.out.println("현재 "+i+"회 틀렸습니다. 5회 이상 틀릴시 이전 화면으로 돌아갑니다.");
					}
				}
				break;
			case 2:
				for(int i = 1 ; i <=5; i++) {
					System.out.print("현재 비밀번호 : ");
					String pwd = sc.nextLine();
					if(cr.checkPwd(pwd)) {
						while(true) {
							System.out.print("새로운 닉네임 : ");
							String nname = sc.nextLine();
							if(nname.equals(cr.getUser().getNname())) {
								System.out.println("기존과 동일한 닉네임입니다.");
								continue;
							}
							if(cr.checkNname(nname)) {
								cr.changeNname(nname);
								break;
							}
						}
						break;
					}else if(i==5){
						System.out.println("5회 이상 틀렸습니다. 이전 화면으로 돌아갑니다.");
						break;
					}else {
						System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
						System.out.println("현재 "+i+"회 틀렸습니다. 5회 이상 틀릴시 이전 화면으로 돌아갑니다.");
					}
				}
				break;
			case 3:
				System.out.println("로그아웃되었습니다.");
				System.out.println("초기화면으로 돌아갑니다.");
				menu();
				break;
			case 4:
				return;
			case 5:
				if(cr.wdcheck()==1) {
					menu();
					
				}
				break;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
	}
	
	public void boardMenu() {
		while(true) {
			cr.showBoard(cr.clpd(),1);
			int num =0;
			System.out.println(title("거래메뉴"));
			System.out.println("1. 구매하기");
			System.out.println("2. 검색하기");
			System.out.println("3. 등록하기");
			System.out.println("4. 이전 화면으로");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			switch (num) {
			case 1:
				System.out.print("구매할 제품번호 : ");
				switch(cr.buy(checkInt(sc.nextLine()))) {
				case 0:
					System.out.println("정상적으로 구매되었습니다.");
					break;
				case 1:
					System.out.println("본인제품은 구매할 수 없습니다.");
					break;
				case 2:
					System.out.println("존재하지 않는 제품번호입니다.");
					break;
				}
				break;
			case 2:
				searchMenu();
				break;
			case 3:
				cr.reg();
				break;
			case 4:
				return;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
	}
	
	public void searchMenu() {
		while(true) {
			int num =0;
			System.out.println(title("검색메뉴"));
			System.out.println("1. 제품번호로 검색");
			System.out.println("2. 작성자로 검색");
			System.out.println("3. 제품명으로 검색");
			System.out.println("4. 이전 화면으로");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			List pl;
			switch (num) {
			case 1:
				System.out.print("검색할 제품번호 : ");
				int pnum = checkInt(sc.nextLine());
				pl = cr.srnum(pnum);
				if (pl.isEmpty()) {
					System.out.println("일치하는 제품번호가 없습니다.");
					break;
				}else {
					cr.showBoard(pl,1);
				}
				break;
			case 2:
				System.out.print("검색할 작성자명 : ");
				String rename = sc.nextLine();
				pl = cr.srname(rename);
				if (pl.isEmpty()) {
					System.out.println("일치하는 작성자가 없습니다.");
					break;
				}else {
					cr.showBoard(pl,1);
				}
				break;
			case 3:
				System.out.print("검색할 제품명 : ");
				String pname = sc.nextLine();
				pl = cr.srpname(pname);
				if (pl.isEmpty()) {
					System.out.println("일치하는 제품명이 없습니다.");
					break;
				}else {
					cr.showBoard(pl,1);
				}
				break;
			case 4:
				return;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
	}
	
	public String title(String s) {
		String s1 = String.format("==="+"%-17s",s).replace(" ","=");
		return s1;
	}
	
	public void myBoardmenu() {
		while(true) {
			int num =0;
			System.out.println(title("내거래메뉴"));
			System.out.println("1. 내 구매목록");
			System.out.println("2. 내 판매중인목록");
			System.out.println("3. 내 판매목록");
			System.out.println("4. 이전 화면으로");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			switch (num) {
			case 1:
				cr.showBoard(cr.buyList(),0);
				break;
			case 2:
				cr.showBoard(cr.myBoard(),0);
				if(cr.myBoard().isEmpty()) {
					break;
				}
				mySellMenu();
				break;
			case 3:
				cr.showBoard(cr.cellList(),0);
				break;
			case 4:
				return;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		}
	}
	
	public void mySellMenu() {
		while(true) {
			int num =0;
			System.out.println(title("거래편집메뉴"));
			System.out.println("1. 수정하기");
			System.out.println("2. 삭제하기");
			System.out.println("4. 이전 화면으로");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			num=checkInt(sc.nextLine());
			switch (num) {
			case 1:
				System.out.print("수정할 제품번호 : ");
				int pnum1=checkInt(sc.nextLine());
				if(cr.moProduct(pnum1)) {
					System.out.println("정상적으로 수정되었습니다.");
				}else {
					System.out.println("존재하지 않거나 수정할 수 없는 제품번호입니다.");
				}
				break;
			case 2:
				System.out.print("삭제할 제품번호 : ");
				int pnum2=checkInt(sc.nextLine());
				if(cr.rmProduct(pnum2)) {
					System.out.println("정상적으로 삭제되었습니다.");
				}else {
					System.out.println("존재하지 않거나 삭제할 수 없는 제품번호입니다.");
				}
				break;
			case 4:
				return;
			case 9:
				this.fnProgram();
			default:
				System.out.println("잘못된입력입니다.");
			}
		
		}
			
	}
	public void insertac() {
		String usid,uspw,usnname;
		while(true) {
			System.out.print("사용할 아이디 : ");
			String id = sc.nextLine();
			if(cr.checkId(id)) {
				usid=id;
				break;
			}else {
				System.out.println("중복된 아이디입니다. 다시 입력하세요");
			}
		}
		System.out.print("사용할 비밀번호 : ");
		String pwd = sc.nextLine();
		while(true) {
			System.out.print("비밀번호 확인 : ");
			String npwd = sc.nextLine();
			if(cr.checkPwd(pwd, npwd)) {
				uspw = pwd;
				break;
			}
		}
		while(true) {
			System.out.print("사용할 닉네임 : ");
			String nname = sc.nextLine();
			if(cr.checkNname(nname)) {
				usnname=nname;
				break;
			}else {
				System.out.println("중복된 닉네임입니다. 다시 입력하세요");
			}
		}
		cr.insertac(usid,uspw,usnname);
	}
	
	public void saveObject() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product1.txt"));){
			for(int i = 0; i <cr.clpd().size(); i++) {
				oos.writeObject(cr.clpd().get(i));
			}
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product2.txt"));){
			for(int i = 0; i <cr.clba().size(); i++) {
				oos.writeObject(cr.clba().get(i));
			}
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int checkInt(String str) {
		try {
			return Integer.parseInt(str);
		}catch(Exception e) {
			return 0;
		}
	}
	
	public void fnProgram() {
		System.out.println("프로그램을 종료합니다.");
		saveObject();
		sc.close();
		System.exit(0);
	}

}
