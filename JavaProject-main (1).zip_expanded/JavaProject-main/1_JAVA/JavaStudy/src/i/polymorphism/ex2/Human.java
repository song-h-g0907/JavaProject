package i.polymorphism.ex2;

public class Human {
	private String name;
	private int age;
	private int height;
	private int weight;
	public Human(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	public Human() {
		super();
	}
	public String toString() {
		return this.name + " " + this.age +" "+this.height+" "+this.weight;
	}
}
