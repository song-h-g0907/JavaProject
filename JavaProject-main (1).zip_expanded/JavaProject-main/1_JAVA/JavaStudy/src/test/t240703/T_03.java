package test.t240703;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int k=sc.nextInt();
		System.out.print("수학점수 : ");
		int m=sc.nextInt();
		System.out.print("영어점수 : ");
		int e=sc.nextInt();
		int sum=k+m+e;
		double evg = (double)sum/3;
		if(k>=40&&m>=40&&e>=40&&(k+m+e)>=180) {
			System.out.println("국어 : "+k);
			System.out.println("수학 : "+m);
			System.out.println("영어 : "+e);
			System.out.println("합계 : "+sum);
			System.out.printf("평균 : %.1f\n",evg);
			System.out.println("축하합니다, 합격입니다!");
		}else {
			System.out.println("불합격입니다.");
		}
	}

}
