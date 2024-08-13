package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		List<Integer> list = new ArrayList();
		list.add(a);
		list.add(b);
		list.add(c);
		int n = list.indexOf(Integer.parseInt("6"));
		System.out.println(n);
		System.out.println(list.get(n));
	}
}
