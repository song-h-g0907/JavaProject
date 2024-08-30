package test240711.object3;
import java.util.Scanner;
//사용자와의 소통
//입력을 받고 응답을 출력하는 것
public class Library {
	private Scanner sc = new Scanner(System.in);
	private Book[] barr = new Book[10];
	public void menu() {	
		while(true) {
			System.out.println("=============== 도서관리 프로그램 ===============");
			System.out.println("1. 도서등록");
			System.out.println("2. 도서목록 출력");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 삭제");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				this.addBook();
				break;
			case 2:
				this.printBookList();
				break;
			case 3:
				this.searchBook();
				break;
			case 4:
				this.printBookList();
				this.deleteBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
	public void addBook() {
		String title,genre,author;
		int bookNum;
		System.out.print("도서 제목 : ");
		title = sc.nextLine();
		System.out.print("장르 : ");
		genre = sc.nextLine();
		System.out.print("저자 : ");
		author = sc.nextLine();
		System.out.print("책번호 : ");
		bookNum = sc.nextInt();
		for (int i = 0 ; i < barr.length; i++) {
			if(barr[barr.length-1]!=null) {
				System.out.println("이미 등록할 수 있는 책이 가득 찼습니다.");
				break;
			}
			if(barr[i]==null) {
				barr[i]=new Book(title,genre,author,bookNum);
				System.out.println("책을 등록하엿습니다.");
				break;
			}
		}
	}
	public void printBookList() {
		System.out.println("================ 등록 도서목록 ================");
		for(int i = 0 ; i < barr.length; i++) {
			if(barr[i]==null) {
				break;
			}
			System.out.println((i+1)+". "+barr[i].toString());
		}
	}
	public void searchBook() {
		System.out.println("================ 등록 도서목록 ================");
		System.out.print("검색할 책 이름을 입력 : ");
		String str = sc.nextLine();
		for (int i = 0 ; i < barr.length; i++) {
			if(barr[i]==null) {
				System.out.println("입력하신 제목의 책은 등록되어있지 않습니다.");
				break;
			}else if(barr[i].getTitle().equals(str)) {
				System.out.println(barr[i].toString());
				break;
			}
		}
	}
	public void deleteBook() {
		System.out.print("삭제할 도서의 번호 입력 : ");
		int num = sc.nextInt();
		for (int i = 0 ; i < barr.length; i++) {
			if(barr[i]==null) {
				System.out.println("삭제할 도서의 번호를 찾지 못하였습니다.");
				break;
			}else if(num==barr[i].getBookNum()){
				for (int j = i; j <barr.length-1; j++) {
					barr[j]=barr[j+1];
				}
				barr[barr.length-1]=null;
				System.out.println("삭제가 완료되었습니다.");
				break;
			}
		}
	}
}


