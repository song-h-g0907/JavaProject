package d.loop;

public class Prac3 {

	public static void main(String[] args) {
		for(int i = 2; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				if(i>=j) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
				}else {
					break;
				}
			}
		}
	}

}
