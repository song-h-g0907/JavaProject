package com.kh.example.practice1;
import java.util.Scanner;
public class Run {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member mb = new Member();
		mb.changeName(sc.nextLine());
		mb.printName();
	}

}
