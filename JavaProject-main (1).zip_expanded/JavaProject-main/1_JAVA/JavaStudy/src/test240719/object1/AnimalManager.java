package test240719.object1;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] am = new Animal[5];
		am[0] = new Dog("123","123",12);
		am[1] = new Cat("123","123","123","123");
		am[2] = new Dog("1234","1235",13);
		am[3] = new Cat("123","123","123","123");
		am[4] = new Dog("1235","1234",14);
		for (int i = 0; i <5; i++) {
			am[i].speak();
		}
	}

}
