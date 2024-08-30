package com.kh.practice;
import java.util.Scanner;
public class SnackMenu {
	Scanner sc = new Scanner(System.in);
	SnackController scr = new SnackController();
	public void menu() {
		String kind,name,flavor;
		int numOf,price;
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		kind = sc.next();
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("맛 : ");
		flavor = sc.next();
		System.out.print("개수 : ");
		numOf = sc.nextInt();
		System.out.print("가격 : ");
		price = sc.nextInt();
		System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		char yn = sc.next().charAt(0);
		if (yn=='y') {
			String sdata = scr.confirmData();
			System.out.println(sdata);
		}else {
			return;
		}
		
	}
}

