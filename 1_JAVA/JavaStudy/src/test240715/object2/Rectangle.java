package test240715.object2;

public class Rectangle extends Point{
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	public Rectangle() {
		super();
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() {
		return super.toString() + " , " + this.width + " , " + this.height;
	}
}
