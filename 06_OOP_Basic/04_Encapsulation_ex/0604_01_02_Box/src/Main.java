import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		double length = Double.parseDouble(reader.readLine());
		double width = Double.parseDouble(reader.readLine()); 
		double height = Double.parseDouble(reader.readLine());
		
		reader.close();
		
		Box box = new Box();
		try {
			box.setLength(length);
			box.setWidth(width);
			box.setHeight(height);
			
			System.out.println(box);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
