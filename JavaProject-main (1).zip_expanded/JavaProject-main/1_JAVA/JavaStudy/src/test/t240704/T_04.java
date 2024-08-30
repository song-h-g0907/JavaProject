package test.t240704;

import java.util.Scanner;

public class T_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		while(true) {
			System.out.print("숫자 : ");
			a = sc.nextInt();
			if (a>9) {
				System.out.println("9이하의 숫자만 입력해주세요.");
				continue;
			}
			break;
		}
		
		for (int j=a; j<10; j++) {
			System.out.println("==== "+j+"단 ====");
			for (int i=1; i<10; i++) {
				System.out.println(j + " * " + i + " = " + j*i);
			}
		}
		
	}

}
