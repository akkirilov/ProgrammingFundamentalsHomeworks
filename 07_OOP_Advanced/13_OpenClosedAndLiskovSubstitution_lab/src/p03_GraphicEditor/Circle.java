package p03_GraphicEditor;

/**
 * Created by Buro on 3.4.2017 г..
 */
public class Circle extends Shape {
	
	private Double radius;

	public Circle(Double radius) {
		this.radius = radius;
	}

	@Override
	public void drow() {
		System.out.println("I'm a Circle!");
	}
	
}
