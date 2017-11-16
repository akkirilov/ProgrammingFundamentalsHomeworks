package p01_ShapesDrawing;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

import p01_ShapesDrawing.drawables.Circle;
import p01_ShapesDrawing.drawables.Drawable;
import p01_ShapesDrawing.drawables.Rectangle;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    
		Queue<Integer> queue = new ArrayDeque<>();
	    for (int i = 0; i < 3; i++) {
	        queue.add(Integer.parseInt(scanner.nextLine()));
	    }
	    
	    scanner.close();

	    Drawable circle = new Circle(queue.poll());
	    Drawable rect = new Rectangle(queue.poll(), queue.poll());

	    circle.draw();
	    rect.draw();

	}

}
