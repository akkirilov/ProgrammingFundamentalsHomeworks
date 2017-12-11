package p05_Square;

public class Rectangle {
	
    private int width;
    private int height;

    public Rectangle(int width, int height) {
		this.height = width;
		this.height = height;
	}

	public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }
    
}
