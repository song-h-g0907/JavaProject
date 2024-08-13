package test240711.object3;
import java.util.Scanner;
public class Run {
/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 	우리는 도서관에서 책을 관리하는 프로그램을 만들려고 한다.
		 	해당 클래스는 도서관에 책을 등록할 때 사용하는 book객체를 생성할 Book클래스이다.
		 	필요하다고 생각하는 데이터와 기능을 구현해보자
		 	
		 
		
		//사용자로부터 제목, 장르, 저자, 책번호를 입력받아
		//b1이라는 객체를 생성하고 생성된 객체의 toStirng메소드를 호출하여 모든 정보를 확인하자
		
		Book[] barr = new Book[10];
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
				break;
			case 2:
				System.out.println("================ 등록 도서목록 ================");
				for(int i = 0 ; i < barr.length; i++) {
					if(barr[i]==null) {
						break;
					}
					System.out.println((i+1)+". "+barr[i].toString());
				}
				break;
			case 3:
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
				break;
			case 4:
				System.out.println("================ 등록 도서목록 ================");
				for(int i = 0 ; i < barr.length; i++) {
					if(barr[i]==null) {
						break;
					}
					System.out.println((i+1)+". "+barr[i].toString());
				}
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
				break;
			case 9:
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.out.println("목록에 있는 숫자를 입력해주십시오");
			}
			
		}
		
	}
	*/
}
