package com.kh.practice;

public class SnackController {
	Snack s = new Snack();
	public SnackController(){
		
	}
	public String saveData(String kind,String name,String flavor, int numOf,int price) {
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return "저장 완료 되었습니다.";
	}
	public String confirmData() {
		return s.information();
	}
}
