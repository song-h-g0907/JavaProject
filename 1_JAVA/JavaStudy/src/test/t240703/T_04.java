package test.t240703;

import java.util.Scanner;

public class T_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		while(true) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			a=sc.nextInt();
			if (a>=1) {
				for (int i =1; i<=a; i++) {
					System.out.print(i+" ");
				}
				break;
			}
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
		
		
	}

}
