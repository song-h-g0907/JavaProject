package i.polymorphism.ex5;

public class Car {
	private int year;
	private String color;
	private String fuel;
	public Car(int year, String color, String fuel) {
		super();
		this.year = year;
		this.color = color;
		this.fuel = fuel;
	}
	public Car() {
		super();
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	@Override
	public String toString() {
		return year + " " + color + " " + fuel;
	}
	
	public void drive() {
		System.out.println("부릉부릉~");
	}
}
