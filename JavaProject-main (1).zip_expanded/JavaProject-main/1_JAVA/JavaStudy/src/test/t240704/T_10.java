package test.t240704;

public class T_10 {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		int res=16;
		for (int i =0; i<arr.length;i++) {
			for (int j = 0; j<arr[i].length; j++) {
				arr[i][j]=(arr.length*arr[i].length)-(4*i+j);//res--
			}
		}
		for (int i =0; i<arr.length;i++) {
			for (int j = 0; j<arr[i].length; j++) {
				System.out.printf("%4d",arr[i][j]);   
			}
			System.out.println();
		}
	}

}
