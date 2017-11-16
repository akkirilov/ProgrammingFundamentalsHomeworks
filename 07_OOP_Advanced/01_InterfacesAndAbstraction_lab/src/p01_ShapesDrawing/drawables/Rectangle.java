package p01_ShapesDrawing.drawables;

public class Rectangle implements Drawable {

	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	private void drawLine(int width, char end, char mid) {
		System.out.print(end);
		for (int i = 1; i < width - 1; ++i) {
			System.out.print(mid);
		}
		System.out.println(end);
	}

	public void draw() {
		drawLine(this.width, '*', '*');
		for (int i = 1; i < this.height - 1; ++i) {
			drawLine(this.width, '*', ' ');
		}
		drawLine(this.width, '*', '*');
	}

}
