package test240711.object2;

public class Human {
	TV tv = new TV();
	private String name;
	private int money;
	public Human(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	public void buy(TV tv) {
		if(this.money<tv.getPrice()) {
			System.out.println(this.name+"님은 잔액이 부족하여 구매하실 수 없습니다");
		}else {
			System.out.println(this.name+"님 구매내역");
			tv.show();
			this.money -= tv.getPrice();
			System.out.println("남은 잔액 : " + this.money);
		}
		return ;
	}
}
