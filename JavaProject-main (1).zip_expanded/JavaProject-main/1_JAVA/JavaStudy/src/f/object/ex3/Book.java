package f.object.ex3;

public class Book {
	/*
	 * 접근제한자 : 해당구조에 접근할 수 있는 범위를 제한한다.
	 * 		 	 public > protected > default > private
	 * 
	 * 클래스에 사용 가능한 접근제한자 2가지
	 * default, public
	 * 
	 * 필드와 메소드에 사용할 수 있는 접근제한자 4가지
	 * public : 어디서든(같은패키지, 다른패키지 모두 ) 접근 가능
	 * projected : 같은패키지 + 다른패키지일 경우 상속관계에서만 접근 가능
	 * default : 같은패키지일때만 접근 가능
	 * private : 오직 해당 클래스에서만 접근 가능 
	 */
	//필드
	private String title; //제목
	private String genre; //장르
	private String author; //저자
	private int maxPage; //페이지수
	/*
	 * 생성자
	 * - 클래스의 이름과 동일한메소드로 반환형이 없다.
	 * - 필드 데이터의 초기화를 위한 특수목적의 메소드이다.
	 * - 매개변수가 하나도 없는 생성자를 우리는 기본생성자라고합니다.
	 * 
	 * - 생성자를 개발자가 직접 만들기 않는다면 컴파일러는 기본생성자를 만들어준다.
	 * - 개발자가 직접 생성자를 작성하면 기본생성자를 만들어주니 않는다.
	 * - 메소드의 매개변수의 갯수 또는 타입에 딸라서 메소드를 구분하는 메소드 오버로딩은 생성자에도 적용이 된다.
	 */
	public Book(String title, String genre ,String author, int maxPage) {
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.maxPage = maxPage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public Book() {
		System.out.println("기본생성자 호출");
	}
	//메소드
	//객체를 생성할 때 데이터를 초기화해주는 작업이 필수적으로 필요하기에
	//초기화를 위한 메소드를 만들어준다.
	
	public String toString() {
		/*
		 * this -> 인스턴스(메모리를 사용중인 객체) 자기 자신을 의미
		 * 1. 자기 자신의 메모리르 가르킨다.
		 * 2. 생성자에서 다른 생성자를 호출할 수 있다.
		 * 3. 자기 자신의 주소를 반환할 수 있다.
		 */
		return "제목 : " + this.title + "\n장르 : "+ 
		 		this.genre + "\n저자 : "+this.author+"\n페이지수 : "+this.maxPage;
	}
	
}
