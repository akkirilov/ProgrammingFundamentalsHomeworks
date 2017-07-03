package intersectionOfCircles;

public class Point {
	private int x;
	private int y;
	private int r;
	
	public Point(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getR() {
		return r;
	}
	
	public static boolean isIntersect(Point p1, Point p2) {
		double distance = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
		if (distance > p1.getR() + p2.getR()) {
			return false;
		}
		
		return true;
	}
	
}
