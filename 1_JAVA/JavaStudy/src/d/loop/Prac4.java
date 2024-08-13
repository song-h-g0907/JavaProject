package d.loop;

import java.util.Scanner;

public class Prac4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=num; i++) {
			for(int k=1; k<=num-i; k++) {
				System.out.print(" ");
			}
			for(int j=1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
