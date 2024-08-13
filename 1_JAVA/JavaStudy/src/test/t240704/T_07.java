package test.t240704;

import java.util.Scanner;

public class T_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		char a;
		int count =0;
		System.out.print("문자열 : ");
		str = sc.nextLine();
		char[] arr = new char[str.length()];
		for (int i =0; i<arr.length; i++) {
			arr[i]=str.charAt(i);
		}
		System.out.print("문자 : ");
		a = sc.nextLine().charAt(0);
		System.out.print(str+"에 " + a +"가 존재하는 위치(인덱스) : ");
		for (int i =0; i<str.length(); i++) {
			if(arr[i]==a) {
				System.out.print(i+" ");
				count++;
			}
		}
		System.out.println();
		System.out.println(a + " 개수 : " + count);
		
	}

}
