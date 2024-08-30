package d.loop;

public class Prac2 {

	public static void main(String[] args) {
		for(int i=2; i<=9; i+=2) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
		}
	}

}
