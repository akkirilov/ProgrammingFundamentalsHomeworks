package p03_GraphicEditor;

public class Main {

	public static void main(String[] args) {
		
		Shape rectangle = new Rectangle(2.0, 3.0);
		Shape circle = new Circle(5.0);
		
		GraphicEditor editor = new GraphicEditor();
		editor.drawShape(rectangle);
		editor.drawShape(circle);
		
	}

}
