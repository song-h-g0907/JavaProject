package a.basic;
import java.util.Scanner;
public class Practice2 {
	/*
	 * 키보드로 가로, 세로 값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 
	 * 가로 : (키보드로 입력)
	 * 세로 : (키보드로 입력)
	 * 
	 * 면적 : ~
	 * 둘레 : ~
	 * + 소수점 2번째 자리까지만 출력
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a,b;
		System.out.print("가로 : ");
		a=sc.nextDouble();
		sc.nextLine();
		System.out.print("세로 : ");
		b=sc.nextDouble();
		sc.nextLine();
		System.out.println();
		System.out.println("======================");
		System.out.printf("면적 :%.2f\n",(a*b));
		System.out.printf("둘레 :%.2f\n",(2*(a+b)));
		System.out.println("======================");
		sc.close();
	}

}
