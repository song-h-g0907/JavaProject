package i.polymorphism.ex5;

public class Avante extends Car{

	public Avante() {
		super();
	}

	public Avante(int year, String color, String fuel) {
		super(year, color, fuel);
	}
	public void drive() {
		System.out.println("슝~ 슝~");
	}
	public void moveAvante() {
		System.out.println("아반떼 이동");
	}
}
