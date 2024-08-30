package com.kh.example.practice1;

public class Member {
	//필드
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private String email;
	//생성자
	public Member() {}
	//아이디, 비밀번호, 이름을 넘겨받아 초기화하는 생성사
	public Member(String ID,String Pwd, String name) {
		this.memberId = ID;
		this.memberPwd = Pwd;
		this.memberName = name;
	}
	//메소드
	
	//memberName의 필드값을 넘겨받은 name값으로 변경하는 메소드
	public void changeName(String name) {
		this.memberName = name;
	}
	//memberName의 값을 출력하는 메소드
	public void printName() {
		System.out.println(this.memberName);
	}
}
