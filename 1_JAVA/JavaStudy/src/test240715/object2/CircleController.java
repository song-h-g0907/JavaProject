package test240715.object2;

public class CircleController {
	private Circle c = new Circle();
	public String calcArea(int x, int y, int radius) {
		c = new Circle(x,y,radius);
		return c.toString() + " / "+(radius*radius*Math.PI);
	}
	public String calcCircum(int x, int y , int radius) {
		c = new Circle(x,y,radius);
		return c.toString() + " / "+(radius*2*Math.PI);
	}
}
