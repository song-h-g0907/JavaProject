package test.t240704;

import java.util.Scanner;

public class T_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int a = sc.nextInt();
		int[] arr = new int[a];
		for (int i = 0; i<a; i++) {
			arr[i]=i+1;
		}
		for(int i = 0; i<a; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
