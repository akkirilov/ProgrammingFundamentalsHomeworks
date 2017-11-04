package p03_shape;

public class Circle extends Shape {
	
	private double radius;
	
	public Circle(double radius) {
		setRadius(radius);
		super.setPerimeter(this.getPerimeter());
		super.setArea(this.getArea());
	}

	private final double getRadius() {
		return this.radius;
	}

	private void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	protected double calculatePerimeter() {
		return Math.PI * 2 * this.getRadius();
	}

	@Override
	protected double calculateArea() {
		return Math.PI * Math.pow(this.getRadius(), 2);
	}

}
