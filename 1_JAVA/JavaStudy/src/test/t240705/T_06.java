package test.t240705;

import java.util.Scanner;

public class T_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		double[] arr = new double[4];
		System.out.print("중간 고사 점수 : ");
		arr[0]=sc.nextDouble();
		System.out.print("기말 고사 점수 : ");
		arr[1]=sc.nextDouble();
		System.out.print("과제 점수 : ");
		arr[2]=sc.nextDouble();
		System.out.print("출석 회수 : ");
		arr[3]=sc.nextDouble();
		System.out.println("================ 결과 ================");
		double sum =0;
		System.out.println("중간 고사 점수(20) : "+arr[0]*0.2);
		sum+=arr[0]*0.2;
		System.out.println("기말 고사 점수(30) : "+arr[1]*0.3);
		sum+=arr[1]*0.3;
		System.out.println("과제 점수(30)    : "+arr[2]*0.3);
		sum+=arr[2]*0.3;
		System.out.println("출석 점수(20) : "+arr[3]);
		sum+=arr[3];
		System.out.println("총점 : "+ sum);
		if(sum>=70&&arr[3]>=14) {
			System.out.println("Pass");
		}else if(sum < 70){
			System.out.println("Fail [점수 미달]");
		}else {
			System.out.println("Fail [출석 미달]");
		}
	}

}
