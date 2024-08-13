package test.t240704;

import java.util.Scanner;

public class T_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i =0; i<10; i++) {
			arr[i]=i+1;
		}
		for (int i = 0; i<10; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i<10; i++) {
			arr[i]=(arr.length-i);
		}
		for (int i = 0; i<10; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
