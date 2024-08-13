package h.inherit.ex1;

public class Man {
	private String name;

	public Man(String name) {
		super();
		this.name = name;
	}

	public Man() {
		super();
	}
	public void tellYourName() {
		System.out.println("MY name is " + this.name);
	}
}
