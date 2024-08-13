package test.t240705;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력1 : ");
		int a = sc.nextInt();
		System.out.print("입력2 : ");
		int b = sc.nextInt();
		System.out.print("입력3 : ");
		int c = sc.nextInt();
//		if(a==b&&b==c&&a==c) {
//			System.out.println("true");
//		}else {
//			System.out.println("false");
//		}
		System.out.println(a==b&&b==c);
	}

}
