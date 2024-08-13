package f.object.ex4;
import java.util.Scanner;
public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		Student choi = new Student("최지원",15,70,60,80);
		Student kim = new Student("김도한",18,50,95,70);
		
		//choi의 모든 과목의 평균을 출력
		System.out.println(choi.getName()+"님의 평균 : "+choi.getEvg());
		//kim의 모든 과목의 평균을 출력
		System.out.println(kim.getName()+"님의 평균 : "+kim.getEvg());
		*/
		
		//사용자로부터 이름, 나이, 영어점수, 수학점수, 국어점수를 입력받아
		//평균을 구하고 출력하는 프로그램 작성
		Student st = new Student();
		System.out.print("이름 : ");
		st.setName(sc.nextLine());
		System.out.print("나이 : ");
		st.setAge(sc.nextInt());
		System.out.print("영어점수 : ");
		st.setEscore(sc.nextInt());
		System.out.print("수학점수 : ");
		st.setMscore(sc.nextInt());
		System.out.print("국어점수 : ");
		st.setKscore(sc.nextInt());
		st.printEvg();
	}

}
