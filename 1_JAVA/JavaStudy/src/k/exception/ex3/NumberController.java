package k.exception.ex3;

public class NumberController {

	public NumberController() {
		super();
	}
	public boolean checkDouble(int num1, int num2) throws NumRangeException{
		if(num1>100||num2>100) {
			throw new NumRangeException("1부터 100 사이의 값이 아닙니다.");
		}else {
			return (num1%num2==0);
		}
		
	}
}
