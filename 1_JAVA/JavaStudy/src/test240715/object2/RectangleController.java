package test240715.object2;

public class RectangleController {
	Rectangle r  = new Rectangle();
	
	public String calcArea(int x , int y , int height , int width) {
		r = new Rectangle(x,y,height,width);
		return "넓이 : "+r.toString()+" / "+(height*width);
	}
	public String calcPerimeter(int x, int y, int height, int width) {
		r = new Rectangle(x,y,height,width);
		return "둘레 : "+r.toString()+" / "+((height+width)*2);
	}
}
