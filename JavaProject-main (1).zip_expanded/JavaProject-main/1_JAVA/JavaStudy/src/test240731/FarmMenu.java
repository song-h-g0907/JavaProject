package test240731;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
//View : 사용자에게 
public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		while(true) {
			int num =0;
			System.out.println("****** 메인 메뉴 ******");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
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
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료.");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	public void adminMenu() {
		while(true) {
			int num =0;
			System.out.println("****** 직원 메뉴 ******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
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
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	public void customerMenu() {
		while(true) {
			System.out.println("현재 KH마크 농산물 수량");
			printFarm();
			int num =0;
			System.out.println("****** 고객 메뉴 ******");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농사물 보기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
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
				buyFarm();
				break;
			case 2:
				removeFarm();
				break;
			case 3:
				printBuyFarm();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	public void addNewKind() {
		while(true) {
			int num =0;
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			try {
				num = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("잘못된입력입니다.");
				sc.nextLine();
				continue;
			}
			if(num/4!=0) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("수량 : ");
			int amount = sc.nextInt();
			sc.nextLine();
			Farm newitem = null;
			switch (num) {
			case 1:
				newitem = new Fruit("과일",name);
				break;
			case 2:
				newitem = new Vegetable("채소",name);
				break;
			case 3:
				newitem = new Nut("견과",name);
				break;
			}
			if(fc.addNewKind(newitem, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			}else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				break;
			}
		}

	}
	public void removeKind() {
		while(true) {
			int num =0;
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("삭제할 종류 번호 : ");
			try {
				num = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("잘못된입력입니다.");
				sc.nextLine();
				continue;
			}
			if(num/4!=0) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			System.out.print("이름 : ");
			String name = sc.nextLine();
			Farm newitem = null;
			switch (num) {
			case 1:
				newitem = new Fruit("과일",name);
				break;
			case 2:
				newitem = new Vegetable("채소",name);
				break;
			case 3:
				newitem = new Nut("견과",name);
				break;
			}
			if(fc.removeKind(newitem)) {
				System.out.println("농산물 삭제에 성공하였습니다.");
				break;
			}else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	public void changeAmount() {
		while(true) {
			int num =0;
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("수정할 종류 번호 : ");
			try {
				num = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("잘못된입력입니다.");
				sc.nextLine();
				continue;
			}
			if(num/4!=0) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("수량 : ");
			int amount = sc.nextInt();
			sc.nextLine();
			Farm newitem = null;
			switch (num) {
			case 1:
				newitem = new Fruit("과일",name);
				break;
			case 2:
				newitem = new Vegetable("채소",name);
				break;
			case 3:
				newitem = new Nut("견과",name);
				break;
			}
			if(fc.changeAmount(newitem, amount)) {
				System.out.println("농산물 수량이 수정되었습니다.");
				break;
			}else {
				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	public void printFarm() {
		HashMap<Farm,Integer> fm = fc.printFarm();
		for (Farm key : fm.keySet()) {
			System.out.println(key+"("+fm.get(key)+"개)");
		}
	}
	public void buyFarm() {
		while(true) {
			int num =0;
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("구매 종류 번호 : ");
			try {
				num = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("잘못된입력입니다.");
				sc.nextLine();
				continue;
			}
			if(num/4!=0) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			System.out.print("이름 : ");
			String name = sc.nextLine();
			Farm newitem = null;
			switch (num) {
			case 1:
				newitem = new Fruit("과일",name);
				break;
			case 2:
				newitem = new Vegetable("채소",name);
				break;
			case 3:
				newitem = new Nut("견과",name);
				break;
			}
			if(fc.buyFarm(newitem)) {
				System.out.println("구매에 성공하였습니다.");
				break;
			}else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	public void removeFarm() {
		while(true) {
			int num =0;
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("취소 종류 번호 : ");
			try {
				num = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("잘못된입력입니다.");
				sc.nextLine();
				continue;
			}
			if(num/4!=0) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			System.out.print("이름 : ");
			String name = sc.nextLine();
			Farm newitem = null;
			switch (num) {
			case 1:
				newitem = new Fruit("과일",name);
				break;
			case 2:
				newitem = new Vegetable("채소",name);
				break;
			case 3:
				newitem = new Nut("견과",name);
				break;
			}
			if(fc.removeFarm(newitem)) {
				System.out.println("구매 취소에 성공하였습니다.");
				break;
			}else {
				System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	public void printBuyFarm() {
		ArrayList<Farm> list = fc.printBuyFarm();
		Iterator<Farm> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
