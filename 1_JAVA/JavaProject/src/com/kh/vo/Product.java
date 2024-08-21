package com.kh.vo;

import java.io.Serializable;

public class Product implements Serializable{
	private int pnum;
	private String rename;
	private String pname;
	private int price;
	private String exp;
	private boolean nego;
	private int renum;
	
	public Product(int pnum, String rename, String pname, int price, String exp, boolean nego,int renum) {
		super();
		this.pnum = pnum;
		this.rename = rename;
		this.pname = pname;
		this.price = price;
		this.exp = exp;
		this.nego = nego;
		this.renum = renum;
	}

	public int getRenum() {
		return renum;
	}

	public void setRenum(int renum) {
		this.renum = renum;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}


	public Product() {
		super();
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public boolean isNego() {
		return nego;
	}

	public void setNego(boolean nego) {
		this.nego = nego;
	}

	@Override
	public String toString() {
		String str = String.format("제품명 : %s / 가격 : %,d\n네고가능여부 : %c / 설명 : %s",this.pname,this.price,(this.nego?'o':'x'),this.exp);
		return str;
	}
	
}
