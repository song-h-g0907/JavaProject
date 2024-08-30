package test.t240703;

import java.util.Scanner;

public class T_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int a= sc.nextInt();
		int sum =0;
		for (int i=1; i<=a; i++) {
			if(i==a) {
				System.out.print(i);
				break;
			}
			System.out.print(i+" + ");
			sum+=i;
		}
		System.out.println(" = "+sum);
	}

}
