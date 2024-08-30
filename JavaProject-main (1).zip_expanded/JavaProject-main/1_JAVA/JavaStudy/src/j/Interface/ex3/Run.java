package j.Interface.ex3;

public class Run {

	public static void main(String[] args) {
		PhoneController pc = new PhoneController();
		String[] st = pc.method();
		for (int i = 0 ; i < st.length; i++) {
			System.out.println(st[i]);
			System.out.println();
		}
	}

}
