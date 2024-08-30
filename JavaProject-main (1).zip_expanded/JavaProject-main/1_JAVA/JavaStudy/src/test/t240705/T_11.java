package test.t240705;

import java.util.Scanner;

public class T_11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int rd = (int)(Math.random()*100)+1;
		int count =0;
		int a;
		
		while (true) {
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요 : ");
			a= sc.nextInt();
			if (a<1||a>100) {
				System.out.println("1~100 사이의 숫자를 입력해주세요.");
				continue;
			}
			count++;
			if(a>rd) {
				System.out.println("DOWN !");
			}else if(a<rd) {
				System.out.println("UP !");	
			}else {
				System.out.println("정답입니다 !!");
				System.out.println(count + "회 만에 맞추셨습니다.");
				break;
			}
		}
		
	sc.close();	
	}

}
