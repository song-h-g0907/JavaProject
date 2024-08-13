package f.object.ex5;

public class Student {
	private int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	public Student(int grade, int classroom, String name, double height, char gender) {
		this.grade = grade;
		this.classroom = classroom;
		this.name = name;
		this.height = height;
		this.gender = gender;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassromm() {
		return classroom;
	}
	public void setClassromm(int classromm) {
		this.classroom = classromm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void information() {
		System.out.println(this.grade+this.classroom+this.name+this.height+this.gender);
	}
}
