package test240715.object1;

import java.util.Scanner;
public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//정수 num1, num2, num3을 입력받아 홀짝을 출력하라
		//입력 : 6 4 7
		//짝 짝 홀
		
//		int num1,num2,num3;
//		System.out.print("입력 : ");
////		for (int i =0; i<3; i++) {
////			int num = sc.nextInt();
////			System.out.print((num%2==0?"짝":"홀")+" ");
////		}
//		num1 = sc.nextInt();
//		num2 = sc.nextInt();
//		num3 = sc.nextInt();
//		System.out.print(num1%2==0?"짝 ":"홀 ");
//		System.out.print(num2%2==0?"짝 ":"홀 ");
//		System.out.print(num3%2==0?"짝 ":"홀 ");
		
		//정수(1~100)을 입력받아 0부터 입력받은 수까지 출력
		//입력 : 7
		//0 1 2 3 4 5 6 7
		
//		System.out.print("입력 : ");
//		int num;
//		num = sc.nextInt();
//		for ( int i = 0 ; i <=num; i++ ) {
//			System.out.print(i+" ");
//		}
		
		//번호를 입력한 횟수를 구하는 프로그램을 작성한다.
		//번호 (1~20)까지를 무작위로 10번 입력받는다.
		//입력받은 1~20까지의 수가 각각 몇번 입력되었는지를 출력한다.
		//입력 : 1 5 7 10 15 5 1 7 7 2
		//입력횟수 : 2 1 0 0 2 0 3 0 0 1 0 0 0 0 1 0 0 0 0 0
//		int[] arr = new int[20];
//		System.out.print("입력 : ");
//		for(int i = 0 ; i<10; i++) {
//			int num = sc.nextInt();
//			arr[num-1]+=1;
//		}
//		System.out.print("입력횟수 : ")
//		for(int i = 0 ; i <arr.length; i++) {
//			System.out.print(arr[i]+" ");
//		}
		//학생성정관리 프로그램을 만들고자한다.
		//학생 클래스를 정의해보자. Student class는 name(String),classRoom(int), 
		//javaScore(double), sqlScore(double), practiceScore(double)값을 가진다.
		//또한 toString : 학생의 정보를 "xx반 xxx학생 xx점 xx점 xxx점 " 으로 정보를 반환하는 메소드 각점수는 자바,sql,practice순으로 작성
		//    isPassed : 모든 점수가 50점이상이면서 평균이 60점 이상이면 true 아니면 false를 반환하는 메소드
		//    reTest : 학생의 모든 점수를 랜덤(0~100)으로 다시부여하는 메소드 반환없음
		Student[] stArr = new Student[10];
		for (int i = 0 ; i <stArr.length; i++) {
			stArr[i]=new Student();
			System.out.print("이름 : ");
			stArr[i].setName(sc.nextLine());
			System.out.print("반 : ");
			stArr[i].setClassRoom(sc.nextInt());
			sc.nextLine();
			stArr[i].reTest();
			System.out.println(stArr[i].toString());
		}
		sc.close();
	}

}
