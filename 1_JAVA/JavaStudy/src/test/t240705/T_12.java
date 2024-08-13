package test.t240705;

import java.util.Scanner;

public class T_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		int w = 0;
		int l = 0;
		int d = 0;
		int count =0;
		while(true) {
			System.out.print("가위바위보 : ");
			String myrsp = sc.nextLine();
			if(myrsp.equals("exit")) {
				System.out.println(count+"전 "+w+"승 "+d+"무 "+l+"패");
				break;
			}
			int rsp = (int)(Math.random()*3)+1;
			switch(rsp) {
			case 1:
				System.out.println("컴퓨터 : 바위");
				System.out.println(name + " : " + myrsp);
				if (myrsp.equals("가위")) {
					System.out.println("졌습니다 ㅠㅠ");
					l++;
					count++;
				}else if(myrsp.equals("바위")){
					System.out.println("비겼습니다");
					d++;
					count++;
				}else {
					System.out.println("이겼습니다");
					w++;
					count++;
				}
				break;
			case 2:
				System.out.println("컴퓨터 : 가위");
				System.out.println(name + " : " + myrsp);
				if (myrsp.equals("가위")) {
					System.out.println("비겼습니다");
					d++;
					count++;
				}else if(myrsp.equals("바위")){
					System.out.println("이겼습니다");
					w++;
					count++;
				}else {
					System.out.println("졌습니다 ㅠㅠ");
					l++;
					count++;
				}
				break;
			case 3:
				System.out.println("컴퓨터 : 보");
				System.out.println(name + " : " + myrsp);
				if (myrsp.equals("가위")) {
					System.out.println("이겼습니다");
					w++;
					count++;
				}else if(myrsp.equals("바위")){
					System.out.println("졌습니다 ㅠㅠ");
					l++;
					count++;
				}else {
					System.out.println("비겼습니다");
					d++;
					count++;
				}
				break;
			}
			
			
		}
	}

}
