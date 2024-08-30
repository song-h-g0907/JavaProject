package e.array;

import java.util.Scanner;

public class A_Array3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 크기가 10인 정수형 배열 생성 후
//		int[] arr = new int[10];
		//2. 반복문을 통해서 0번인덱스부터 마지막인덱스까지 모든값을 1로 초기화
//		for (int i=0; i<arr.length; i++) {
//			arr[i]=1;
//		}
		//3. 반복문을 통해서 0~마지막인덱스까지 전부 출력
//		for (int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		//4. 사용자에게 배열의 길이를 입력받아 해당크기의 문자열배열을 생성해라.
		/*
		System.out.print("길이 입력 : ");
		int a = sc.nextInt();
		sc.nextLine();
		String strArr[] = new String[a];
//		System.out.println(strArr.length);
		// 5. 반복문을 활용해서 매번 사용자에게 과일명을 입력받아 그값을 strArr에 대입(0~마지막인덱스)
		for (int i=0; i<a; i++) {
			System.out.print("과일명 : "); 
			strArr[i]=sc.nextLine();
		}
		//6. 반복문을 이용해서 strArr에 있는 모든 값을 출력
		for (int i=0; i<a; i++) {
			System.out.println(strArr[i]);
		}
		*/
		/*
		//사용자에게 문자열 하나 입력받은 후
		//각각의 인덱스에 있는 문자들을 char배열에 옮겨담기
		System.out.print("문자열 입력 : ");
		String str=sc.nextLine();
		char[] chArr = new char[str.length()];
		for (int i=0; i<str.length(); i++) {
			chArr[i]=str.charAt(i);
		}
		for (int i=0; i<chArr.length; i++) {
			System.out.println(chArr[i]);
		}
		*/
		
		//사용자에게 배열의 길이를 입력받아 해당 길이의 정수형배열 arr을 생성한다.
		//arr에 모든 인덱스값에 1~100사이의 랜덤값을 할당해주고
		//이중 짝수인 값의 총 합을 구해라
		System.out.print("배열의 길이 : ");
		int size = sc.nextInt();
		int sum=0;
		sc.nextLine();
		int[] arr = new int[size];
		for (int i =0; i<size; i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		for (int i=0; i<size; i++) {
			System.out.print(arr[i] + " ");
			if (arr[i]%2==0) {
				sum+=arr[i];
			}
		}
		System.out.println();
		System.out.println("짝수 총 합 : "+sum);
	}
}
