public class Circle extends Shape {

	private float radius;
	private String lineColor;
	
	Circle(float r,String lc) {
		   this.radius = r;
		   this.lineColor = lc;
		}

	@Override
	public float calculateArea() {
		// TODO Auto-generated method stub
		float area =  (float)Math.PI *this.radius*this.radius;
		return area;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Circle with radius=" + this.radius);
	}

	@Override
	public void lineColor() {
		// TODO Auto-generated method stub
		System.out.println("Line color of circle is: "+this.lineColor);
	}

	@Override
	public float calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2 *(float) Math.PI * this.radius;		
	}
	
	
}
