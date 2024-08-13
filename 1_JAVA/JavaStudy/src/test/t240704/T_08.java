package test.t240704;

import java.util.Scanner;

public class T_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = {'일','월','화','수','목','금','토'};
		int a;
		while(true) {
			System.out.print("0 ~ 6 사이 숫자 입력 : ");
			a= sc.nextInt();
			if (a>6) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			break;
		}
		System.out.println(arr[a]+"요일");
	}

}
