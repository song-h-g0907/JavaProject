package test.t240705;

import java.util.Scanner;

public class T_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int count =0;
			System.out.print("문자열 : ");
			String str = sc.nextLine();
			System.out.print("문자 : ");
			char a = sc.nextLine().charAt(0);
			for (int i=0; i<str.length(); i++) {
				if(str.charAt(i)==a) {
					count++;
				}
			}
			System.out.println("포함된 개수 : "+count);
			while(true) {
				System.out.print("더 하시겠습니까? (y/n) : ");
				String yn = sc.nextLine();
				switch(yn.charAt(0)) {
				case 'y':
				case 'Y':
					break;
				case 'n':
				case 'N':
					return;
				default:
					System.out.println("잘못된 대답입니다. 다시 입력해주세요.");
					continue;
				}
				break;
			}
			
				
			
		}
		
		
	}

}
