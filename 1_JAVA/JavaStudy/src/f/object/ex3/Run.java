package f.object.ex3;

public class Run {

	public static void main(String[] args) {
		//클래스명 참조변수명 = new 생성자();
		Book b1 = new Book("불안을 이기는 심리학","자리계발","황양밍",120);
		System.out.println(b1.toString());
		Book b2 = new Book("자바란 무엇일까?","전공서적","최지원",350);
		System.out.println(b2.toString());
		Book b3 = new Book("당신을 소모시키는 모든 것을 차단하라","자기계발","푸수",130);
		System.out.println(b3.toString());
	}

}
