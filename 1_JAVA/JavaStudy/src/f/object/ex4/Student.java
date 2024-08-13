package f.object.ex4;

//이름 나이 수학점수 영어점수 국어점수를 데이터로 가지고 있는 개채를 만들어라
//데이터는 직접 접근을 허용하지 않고 모두 간접적으로 set/get을 해줄 수 있도록 작성해라
//모든 데이터를 매개변수로 받아 초기화하면서 객체를 생성할 수 있는 생성자를 작성
public class Student {
	//필드영역(데이터)
	private String name;
	private int age;
	private int mscore;
	private int escore;
	private int kscore;
	//생성자영역
	public Student(String name, int age, int mscore, int escore, int kscore) {
		this.name=name;
		this.age=age;
		this.mscore=mscore;
		this.escore=escore;
		this.kscore=kscore;
	}
	public Student() {}
	//메소드영역(기능)
	//getter, setter
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		if(age < 1) {
			this.age = 1;
			return; //메소드 종료
		}
		this.age=age;
	}
	public int getAge() {
		return this.age;
	}
	public void setMscore(int mscore) {
		if(mscore < 0) {
			this.mscore = 0;
			return; //메소드 종료
		}
		this.mscore=mscore;
	}
	public int getMscore() {
		return this.mscore;
	}
	public void setEscore(int escore) {
		if(escore < 0) {
			this.escore = 0;
			return; //메소드 종료
		}
		this.escore=escore;
	}
	public int getEscore() {
		return this.escore;
	}
	public void setKscore(int kscore) {
		if(kscore < 0) {
			this.kscore = 0;
			return; //메소드 종료
		}
		this.kscore=kscore;
	}
	public int getKscore() {
		return this.kscore;
	}
	public double getEvg() {
		double evg = (this.mscore+this.escore+this.kscore)/3.0;
		return evg;
	}
	
	public void printEvg() {
		System.out.println(this.name+"님의 평균 : "+this.getEvg());
	}
}

