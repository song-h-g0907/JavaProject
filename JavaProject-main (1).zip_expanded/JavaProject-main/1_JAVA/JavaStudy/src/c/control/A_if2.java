package c.control;

import java.util.Scanner;

public class A_if2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//나이를 입력 받아
		//13세 이하 : 어린이
		//13세 초과 19세 이하 : 청소년
		//19세 초과 : 성인
		//xx세는 xxx에 속합니다.
		/*
		int age;
		System.out.print("나이를 입력 : ");
		age = sc.nextInt();
		sc.nextLine();
		if (age<=13) {
			System.out.println(age+"세는 어린이에 속합니다.");
		}else if (age<=19) {
			System.out.println(age+"세는 청소년에 속합니다.");
		}else {
			System.out.println(age+"세는 성인에 속합니다.");
		}
		*/
		
		//성별을 (m/f)(대소문자 상관x)로 입력받아 남학생인지 여학생인지
		//출력하는 프로그램을 작성하세요
		//성별(m/f) : 
		//여학생입니다/남학생입니다/잘못입력하셨습니다.
		/*
		String str;
		char a;
		System.out.print("성별(m/f) : ");
		str=sc.next();
		sc.nextLine();
		if(str.length()!=1) {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		a=str.charAt(0);
		if(a=='m' || a=='M') {
			System.out.println("남학생입니다.");
		}else if(a=='f' || a=='F') {
			System.out.println("여학생입니다.");
		}else {
			System.out.println("잘못입력하셨습니다.");
		}
		*/
		
		//정수(양수)를 입력받아
		//짝수인지 홀수인지 출력하는 프로그램을 작성해라
		
		//정수 입력 : xx
		// 짝수다/ 홀수다 / 양수가 아닙니다.
		/*
		int a;
		System.out.print("정수 입력 : ");
		a=sc.nextInt();
		sc.nextLine();
		if (a<=0) {
			System.out.println("양수가 아닙니다.");
		}else if(a%2==0) {
			System.out.println("짝수입니다");
		}else {
			System.out.println("홀수입니다");
		}
		*/
		
	}

}
