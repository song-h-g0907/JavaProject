package c.control;

import java.util.Scanner;

public class Prac1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		sc.nextLine();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.print("연산자 : ");
		char operator = sc.next().charAt(0);
		if (operator == '+') {
			System.out.println(num1 + num2);
		}else if (operator == '-') {
			System.out.println(num1 - num2);
		}else if (operator == '*') {
			System.out.println(num1 * num2);
		}else {
			System.out.println(num1/num2);
		}
		switch(operator) {
		case '+':
			System.out.println(num1 + num2);
			break;
		case '-':
			System.out.println(num1 - num2);
			break;
		case '*':
			System.out.println(num1 * num2);
			break;
		default:
			System.out.println(num1/num2);
		}
	}

}
