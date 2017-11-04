package p03_shape;

public class Rectangle extends Shape {
	
	private double height;
	private double width;

	public Rectangle(double height, double width) {
		super();
		setHeight(height);
		setWidth(width);
		super.setPerimeter(this.getPerimeter());
		super.setArea(this.getArea());
	}

	private final double getHeight() {
		return height;
	}

	private void setHeight(double height) {
		this.height = height;
	}

	private final double getWidth() {
		return width;
	}

	private void setWidth(double width) {
		this.width = width;
	}

	@Override
	protected double calculatePerimeter() {
		return 2 * (this.getHeight() + this.getWidth());
	}

	@Override
	protected double calculateArea() {
		return this.getHeight() * this.getWidth();
	}

}
