package test.t240705;

import java.util.Scanner;

public class T_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] arr = new double[3];
		System.out.print("키 (m)를 입력해 주세요 : ");
		arr[0]=sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		arr[1]=sc.nextDouble();
		double bmi = arr[1]/(arr[0]*arr[0]);
		System.out.println("BMI 지수 : "+bmi);
		if(bmi>=30) {
			System.out.println("고도비만");
		}else if(bmi>=25) {
			System.out.println("비만");
		}else if (bmi >=23) {
			System.out.println("과체중");
		}else if (bmi >=18.5) {
			System.out.println("정상체중");
		}else {
			System.out.println("저체중");
		}
	}

}
