package i.polymorphism.ex5;

public class Sonata extends Car{

	public Sonata() {
		super();
	}

	public Sonata(int year, String color, String fuel) {
		super(year, color, fuel);
	}
	
	public void drive() {
		System.out.println("부응~부응~");
	}
	public void moveSonata() {
		System.out.println("소나타 이동");
	}
}
