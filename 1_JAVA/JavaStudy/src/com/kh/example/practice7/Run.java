package com.kh.example.practice7;

public class Run {

	public static void main(String[] args) {
		Employee em = new Employee();
		em.setEmpNo(100);
		em.setEmpName("홍길동");
		em.setDept("영업부");
		em.setJob("과장");
		em.setAge(25);
		em.setGender('남');
		em.setSalary(2500000);
		em.setBonusPoint(0.05);
		em.setPhone("010-1234-5678");
		em.setAddress("서울시 강남구");
		System.out.println("번호 : "+em.getEmpNo());
		System.out.println("이름 : "+em.getEmpName());
		System.out.println("부서 : "+em.getDept());
		System.out.println("직책 : "+em.getJob());
		System.out.println("나이 : "+em.getAge());
		System.out.println("성별 : "+em.getGender());
		System.out.println("급여 : "+em.getSalary());
		System.out.println("보너스 : "+em.getBonusPoint());
		System.out.println("전화번호 : "+em.getPhone());
		System.out.println("주소 : "+em.getAddress());
	}

}
