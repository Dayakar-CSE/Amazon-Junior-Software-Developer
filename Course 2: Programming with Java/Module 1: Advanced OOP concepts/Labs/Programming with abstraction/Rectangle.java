public class Rectangle extends Shape {

	private float width;
	private float height; 
	private String lineColor;
	
	Rectangle(float w, float h,String lc) {
		   this.width = w;
		   this.height = h;
		   this.lineColor = lc;
		}

	@Override
	public float calculateArea() {
		// TODO Auto-generated method stub
		float area = this.width * this.height;
		   return area;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Rectangle with width=" + this.width + " height=" + this.height);
	}

	@Override
	public void lineColor() {
		// TODO Auto-generated method stub
		System.out.println("Line color of rectangle is: "+this.lineColor);
	}

	@Override
	public float calculatePerimeter() {
		// TODO Auto-generated method stub
		return this.width + this.width + this.height + this.height;
	}
	
	
	
	
}
