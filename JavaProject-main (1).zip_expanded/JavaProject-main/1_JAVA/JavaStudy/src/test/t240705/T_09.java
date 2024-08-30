package test.t240705;

import java.util.Scanner;

public class T_09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("정수 : ");
			int a = sc.nextInt();
			if(a<=0) {
				System.out.println("양수가 아닙니다.");
				return;
			}
			for (int i = 1; i<=a; i++) {
				if(i%2==1) {
					System.out.print("박");
				}else {
					System.out.print("수");
				}
			
		}
			System.out.println();
		}
	}

}
