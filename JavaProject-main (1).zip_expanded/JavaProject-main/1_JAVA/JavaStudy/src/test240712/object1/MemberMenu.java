package test240712.object1;
import java.util.Scanner;
public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	public MemberMenu() {
		
	}
	public void mainMenu() {
		while(true) {
			System.out.println("========== 메인 메뉴 ==========");
			System.out.println("최대 등록 가능한 회원 수는 "+mc.SIZE+"명입니다.");
			System.out.println("현재 등록된 회원 수는 "+mc.existMemberNum()+"명입니다.");
			if(mc.existMemberNum()!=10) {
				System.out.println("1. 새 회원 등록");
			}else if(mc.existMemberNum()==10) {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				insertMember();
				break;
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	public void insertMember() {
		String id,name,pwd,email,gender;
		int age;
		System.out.println("========== 새 회원 등록 ==========");
		while(true) {
			System.out.print("아이디 : ");
			id = sc.nextLine();
			if(mc.checkId(id)) {
				break;
			}
			System.out.println("중복된 아이디입니다. 다시 입력해주세요");
		}
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("비밀번호 : ");
		pwd = sc.nextLine();
		System.out.print("이메일 : ");
		email = sc.nextLine();
		while(true) {
			System.out.print("성별 : ");
			gender = sc.nextLine();
			if(gender.equals("M")||gender.equals("m")||gender.equals("f")||gender.equals("F")) {
				break;
			}
			System.out.println("성별을 다시 입력하세요");
		}
		System.out.print("나이 : ");
		age = sc.nextInt();
		mc.insertMember(id,name,pwd,email,gender,age);
	}
	public void searchMember() {
		System.out.println("========== 회원 검색 ==========");
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {
		case 1:
			searchId();
			break;
		case 2:
			searchName();
			break;
		case 3:
			searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String id = sc.nextLine();
		if(mc.searchId(id)==null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(mc.searchId(id));
		}
	}
	public void searchName() {
		int i =0;
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		if(mc.searchName(name)[0]==null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			while(mc.searchName(name)[i]!=null) {
				System.out.println(mc.searchName(name)[i].inform());
				i++;
			}
		}
	}
	public void searchEmail() {
		int i = 0;
		System.out.print("검색할 이메일 : ");
		String email = sc.nextLine();
		if(mc.searchEmail(email)[0]==null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			while(mc.searchEmail(email)[i]!=null) {
				System.out.println(mc.searchEmail(email)[i].inform());
				i++;
			}
		}
	}
	public void updateMember() {
		System.out.println("========== 회원 정보 수정 ==========");
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {
		case 1:
			updatePassword();
			break;
		case 2:
			updateName();
			break;
		case 3:
			updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void updatePassword() {
		System.out.print("비밀번호를 수정할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String pwd = sc.nextLine();
		if(mc.updatePassword(id, pwd)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	public void updateName() {
		System.out.print("이름을 수정할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		if(mc.updateName(id, name)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	public void updateEmail() {
		System.out.print("이메일을 수정할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		if(mc.updateEmail(id, email)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	public void deleteMember() {
		System.out.println("========== 회원 삭제 ==========");
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {
		case 1:
			deleteOne();
			break;
		case 2:
			deleteAll();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void deleteOne() {
		System.out.print("삭제할 회원 id : ");
		String id = sc.nextLine();
		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		char yn = sc.nextLine().charAt(0);
		if(yn=='Y'||yn=='y') {
			if(mc.delete(id)) {
				System.out.println("성공적으로 삭제하였습니다.");
			}else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
	}
	public void deleteAll() {
		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		char yn = sc.nextLine().charAt(0);
		if(yn=='Y'||yn=='y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}
	public void printAll() {

		Member mem[] = mc.printAll();
		if(mem[0]==null) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		}
		System.out.println("========== 모두 출력 ==========");
		for (int i =0; i < mc.SIZE; i++) {
			if(mem[i]==null) {
				break;
			}else {
				System.out.println(mem[i].inform());
			}
		}
	}
}
