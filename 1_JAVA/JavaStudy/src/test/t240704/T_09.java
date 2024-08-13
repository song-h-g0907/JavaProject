package test.t240704;

public class T_09 {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<arr[i].length; j++) {
				arr[i][j]=(i*4)+j+1;
			}
		}
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<arr[i].length; j++) {
				System.out.printf("%4d ",arr[i][j]); 
			}
			System.out.println();
		}
	}

}
