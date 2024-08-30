package com.kh.vo;

import java.io.Serializable;

public class BuyProduct extends Product implements Serializable{
	int buyAccount;
	public BuyProduct(Product b,int buyAccount) {
		super(b.getPnum(),b.getRename(),b.getPname(),b.getPrice(),b.getExp(),b.isNego(),b.getRenum());
		this.buyAccount = buyAccount;
	}
	public int getBuyAccount() {
		return buyAccount;
	}
	public void setBuyAccount(int buyAccount) {
		this.buyAccount = buyAccount;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}
