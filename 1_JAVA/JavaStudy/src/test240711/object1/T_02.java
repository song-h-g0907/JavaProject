package test240711.object1;
import java.util.Scanner;
public class T_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//정수 num을입력받아 크기가 num인 정수형 배열을 만들고 1~100사이의 랜덤값으로 모든 배열의 인덱스 값을 대입합니다.
		// 이후 모든 배열의 값을 출력하고 홀수인덱스의 값을 더한 값을 출력하세요.
		System.out.print("정수를 하나 입력하시오 : ");
		int a = sc.nextInt();
		int[] arr = new int[a];
		int sum = 0;
		for (int i = 0 ; i <a; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		for ( int i = 0 ; i< a; i++) {
			System.out.print(arr[i] + " ");
			if(i%2==1) {
				sum+=arr[i];
			}
		}
		System.out.println();
		System.out.println("홀수index의 합 : "+sum);
	}

}
