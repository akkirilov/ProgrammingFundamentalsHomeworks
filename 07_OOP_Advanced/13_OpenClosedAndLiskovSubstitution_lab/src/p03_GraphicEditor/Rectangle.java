package p03_GraphicEditor;

public class Rectangle extends Shape {
	
	private Double width;
	private Double height;
	
	public Rectangle(Double width, Double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void drow() {
		System.out.println("I'm a Rectangle!");
	}
	
}
