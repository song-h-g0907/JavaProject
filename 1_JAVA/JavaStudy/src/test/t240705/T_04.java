package test.t240705;

import java.util.Scanner;

public class T_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		char[] arr2 = {'A','B','C'};
		for (int i = 0; i<arr2.length; i++) {
			System.out.print(arr2[i]+"사원의 연봉 : ");
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i<arr2.length; i++) {
			double r =0;
			if (i==0) {
				r=0.4;
			}else if(i==1){
				r=0;
			}else {
				r=0.15;
			}
			double c=arr[i]*(1+r);
			System.out.println(arr2[i]+"사원 연봉/연봉+a : "+arr[i]+'/' + c);
			if(c>=3000) {
				System.out.println("3000 이상");
			}else {
				System.out.println("3000 미만");
			}
		}
		
	}

}
