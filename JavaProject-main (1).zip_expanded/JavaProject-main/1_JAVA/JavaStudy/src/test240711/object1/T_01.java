package test240711.object1;
import java.util.Scanner;
public class T_01 {

	public static void main(String[] args) {
		//정수 n(2~9)를 입력받아 2부터 n까지 중 짝수의 구구단을 출력하는  코드를 작성하세요.
		//만약 2~9사이의 값을 입력하지 않는다면 다시입력하세요를 반복합니다.
		Scanner sc = new Scanner(System.in);
		int a;
		while(true) {
			System.out.print("2 ~ 9사이 값을 입력하시오 : ");
			a = sc.nextInt();
			if(a<2||a>9) {
				System.out.println("다시입력하세요");
				continue;
			}
			for (int i = 2 ; i <=a; i++) {
				for ( int j = 1; j < 10; j++) {
					if(i%2==0) {
						System.out.println(i+" * "+j+" = "+(i*j));
					}
				}
			}
			break;
		}
	}

}
