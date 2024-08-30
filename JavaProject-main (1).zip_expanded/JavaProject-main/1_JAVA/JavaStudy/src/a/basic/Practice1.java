package a.basic;
import java.util.Scanner;
public class Practice1 {
	/*
	 * 키보드로 정수 두개를 입력받아 두 수의 합, 차, 곱, 나누기한 값을 출력하세요.
	 * 
	 * 첫번째 정수 : (키보드로 숫자입력)
	 * 두번째 정수 : (키보드로 숫자입력)
	 * 
	 * 더하기 : 
	 * 빼기 : 
	 * 곱하기 : 
	 * 나누기 :
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		System.out.print("첫번째 정수 : ");
		a = sc.nextInt();
		sc.nextLine();
		System.out.print("두번째 정수 : ");
		b = sc.nextInt();
		sc.nextLine();
		System.out.println();
		System.out.println("=========================");
		System.out.println("더하기 : "+ (a+b));
		System.out.println("빼기 : " + (a-b));
		System.out.println("곱하기 : " + (a*b));
		System.out.println("나누기 : " + (a/b));
		System.out.println("=========================");
		sc.close();
	}
}
