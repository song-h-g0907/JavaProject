package test240712.object1;

public class MemberController {
	public final int SIZE=10;
	private Member[] m = new Member[SIZE];
	
	public int existMemberNum() {
		int count = 0;
		for (int i = 0 ; i < SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			count++;
		}
		return count;
	}
	public Boolean checkId(String inputId) {
		for (int i = 0; i< SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getId().equals(inputId)) {
				return false;
			}
		}
		return true;
	}
	public void insertMember(String id,String name, String password,
			String email,String gender, int age) {
		for(int i = 0 ; i<SIZE; i++) {
			if(m[i]==null) {
				m[i]=new Member(id,name,password,email,(gender.charAt(0)),age);
				break;
			}
		}
	}
	public String searchId(String id) {
		for(int i = 0; i<SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getId().equals(id)) {
				return m[i].inform();
			}
		}
		return null;
	}
	public Member[] searchName(String name) {
		Member[] me = new Member[SIZE];
		int count =0;
		for(int i = 0; i<SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getName().equals(name)) {
				me[count]=m[i];
				count++;
			}
		}
		return me;
	}
	public Member[] searchEmail(String email) {
		Member[] me = new Member[SIZE];
		int count =0;
		for(int i = 0; i<SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getEmail().equals(email)) {
				me[count]=m[i];
				count++;
			}
		}
		return me;
	}
	public Boolean updatePassword(String id, String password) {
		for (int i = 0; i<SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getId().equals(id)) {
				m[i].setPassword(password);
				return true;
			}
		}
		return false;
	}
	public Boolean updateName(String id, String name) {
		for (int i = 0; i<SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getId().equals(id)) {
				m[i].setName(name);
				return true;
			}
		}
		System.out.println("일치하는 아이디가 없습니다");
		return false;
	}
	public Boolean updateEmail(String id, String email) {
		for (int i = 0; i<SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getId().equals(id)) {
				m[i].setEmail(email);
				return true;
			}
		}
		System.out.println("일치하는 아이디가 없습니다");
		return false;
	}
	public Boolean delete(String id) {
		for ( int i = 0 ; i<SIZE; i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getId().equals(id)) {
				for (int j =i ; j<SIZE-1; j++) {
					m[j]=m[j+1];
				}
				m[SIZE-1]=null;
				return true;
			}
		}
		return false;
	}
	public void delete() {
		this.m = new Member[SIZE];
	}
	public Member[] printAll() {
		return m;
	}
}
