package shapesDrawing;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Drawable> drawable = new ArrayList<>();
		drawable.add(new Rectangle(8, 4));
		drawable.add(new Circle(3));
		
		for (Drawable drawableItem : drawable) {
			drawableItem.draw();
		}
		
	}

}
