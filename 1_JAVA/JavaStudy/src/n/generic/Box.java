package n.generic;

public class Box<T> {
	private T[] obArr; //어떤 것들을 담을질 알 수 없음 => 객체
	private int size;
	public T[] getObArr() {
		return obArr;
	}
	public void setObArr(T[] obArr) {
		this.obArr = obArr;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Box() {
		super();
	}
	public Box(T[] obArr, int size) {
		super();
		this.obArr = obArr;
		this.size = size;
	}
}
