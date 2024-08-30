package test;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[4];
		int[] arr2 = new int[4];
		int a = (int)(Math.random()*10);
		int b = (int)(Math.random()*10);
		while(a==b) {
			b=(int)(Math.random()*10);
		}
		int c = (int)(Math.random()*10);
		while(a==c||b==c) {
			c = (int)(Math.random()*10);
		}
		int d = (int)(Math.random()*10);
		while(a==d||b==d||c==d) {
			d = (int)(Math.random()*10);
		}
		arr1[0]=a;
		arr1[1]=b;
		arr1[2]=c;
		arr1[3]=d;
		while(true) {
			String tr = sc.nextLine();
			for (int i = 0; i<4; i++) {
				arr2[i]=Integer.parseInt(tr.charAt(i)+"");
			}
		}
	}
}
