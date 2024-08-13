package test.t240705;

import java.util.Scanner;

public class T_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 : ");
		double k = sc.nextDouble();
		System.out.print("영어 : ");
		double e = sc.nextDouble();
		System.out.print("수학 : ");
		double m = sc.nextDouble();
		int sum= (int)k + (int)e + (int)m;
		System.out.println("총점 : "+ sum);
		System.out.println("평균 : "+(sum/3));
	}

}
