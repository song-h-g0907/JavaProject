package test240713.object1;

public class test2 {
	public static void main(String[] args) {
		//문자열.split(구분자)
		//문자열을 구분자로 나눠서 배열로 반환하는 메소드
		//배열에 들어있는 모든 요소를 가져와서 사용하는경우가 매우많다.
		//for(자료형 변수명 : 배열){
		//		변수명 -> 배열에 있는 모든 요소가 한번씩 들어와서 반복
		//}
		String str = "1.22,4.12,5.93,8.71,9.34";
		int i=0;
		String[] array = str.split(",");
		double data[] = new double [array.length];
		double sum = 0;
		for (i = 0 ; i < data.length; i++) {
			data[i]=Double.parseDouble(array[i]);
			sum+=data[i];
		}
		
		System.out.printf("합계 : %.3f\n",sum);
		System.out.printf("평균 : %.3f",sum/i);
	}
}
