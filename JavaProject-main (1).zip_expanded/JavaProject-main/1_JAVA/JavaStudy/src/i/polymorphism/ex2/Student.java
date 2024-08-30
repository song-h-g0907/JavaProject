package i.polymorphism.ex2;

public class Student extends Human{
	private String number;
	private String major;
	public Student() {
		super();
	}
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	public String toString() {
		return super.toString()+" "+this.number+" "+major;
	}
	
}
