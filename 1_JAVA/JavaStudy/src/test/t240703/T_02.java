package test.t240703;

import java.util.Scanner;

public class T_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int a = sc.nextInt();
		if(a<0) {
			System.out.println("양수만 입력해주세요.");
		}else if(a%2==0){
			System.out.println("짝수다");
		}else {
			System.out.println("홀수다");
		}
		sc.close();
	}

}
