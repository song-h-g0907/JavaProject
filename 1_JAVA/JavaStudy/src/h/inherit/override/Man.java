package h.inherit.override;

public class Man {
	private String name;

	public Man(String name) {
		super();
		this.name = name;
	}

	public Man() {
		super();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void tellYourName() {
		System.out.println("MY name is " + this.name);
	}
	@Override
	public String toString() {
		return "이름 : " + this.name;
	}
}
