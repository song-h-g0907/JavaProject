package test.t240704;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		while(true) {
			System.out.print("첫 번째 숫자 : ");
			a = sc.nextInt();
			System.out.print("두 번째 숫자 : ");
			b = sc.nextInt();
			if (a<1||b<1) {
				System.out.println("1 이상의 숫자를 입력해주세요");
				continue;
			}
			break;
		}
		if(a>b) {
			for (int i=b; i<=a; i++) {
				System.out.print(i+" ");
			}
		}else {
			for (int i=a; i<=b; i++) {
				System.out.print(i+" ");
			}
		}
	}

}
