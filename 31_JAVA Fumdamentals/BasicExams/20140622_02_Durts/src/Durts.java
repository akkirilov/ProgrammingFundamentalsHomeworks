import java.util.Arrays;
import java.util.Scanner;

public class Durts {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer[] center = Arrays.stream(scanner.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.toArray(Integer[]::new);
		
		int r = Integer.parseInt(scanner.nextLine());
		int turns = Integer.parseInt(scanner.nextLine());
		if (turns <= 0) {
			return;
		}
		
		Integer[] darts = Arrays.stream(scanner.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.toArray(Integer[]::new);
		
		double verticalRectMinX = center[0] - (0.5 * r);
		double verticalRectMaxX = center[0] + (0.5 * r);
		double verticalRectMinY = center[1] - r;
		double verticalRectMaxY = center[1] + r;
		
		double horizontalRectMinX = center[0] - r;
		double horizontalRectMaxX = center[0] + r;
		double horizontalRectMinY = center[1] - (0.5*r);
		double horizontalRectMaxY = center[1] + (0.5*r);
		
		boolean impact;
		int x;
		int y;
		
		for (int i  = 0; i  < darts.length; i += 2) {
			x = darts[i];
			y = darts[i + 1];
			impact = isPointInRectangle(
					x, y, 
					verticalRectMinX, verticalRectMaxX, 
					verticalRectMinY, verticalRectMaxY) ||
					isPointInRectangle(
					x, y, 
					horizontalRectMinX, horizontalRectMaxX, 
					horizontalRectMinY, horizontalRectMaxY);
			System.out.println(impact ? "yes" : "no");
		}
	}

	private static boolean isPointInRectangle(int x, int y,
			double minX, double maxX, double minY, double maxY) {
		boolean inside = (x >= minX) && (x <= maxX) && (y >= minY) && (y <= maxY);
		return inside;
	}
}