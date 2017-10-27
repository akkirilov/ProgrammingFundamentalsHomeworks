import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		List<Car> cars = new ArrayList<>();
		
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader reader = new BufferedReader(isr);

	    int n = Integer.parseInt(reader.readLine());
	    String[] tokens;
	    for (int i = 0; i < n; i++) {
	    	tokens = reader.readLine().split("\\s+");
			Car temp = new Car(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
			cars.add(temp);
		}
	    
	    
	    String msg = "";
	    String model;
	    int distance;
	    tokens = reader.readLine().split("\\s+");
	    while (!tokens[0].equals("End")) {
			model = tokens[1];
			distance = Integer.parseInt(tokens[2]);
			
			for (Car c : cars) {
				if (c.getModel().equals(model)) {
					msg = c.tryToDriveCar(distance);
					printIfError(msg);
					break;
				}
			}
			
			tokens = reader.readLine().split("\\s+");
		}
	    
	    reader.close();
	    
	    printCars(cars);

	}

	private static void printCars(List<Car> cars) {
	    for (Car c : cars) {
			System.out.println(c);
		}
	}

	private static void printIfError(String msg) {
		if (!msg.equals("ok")) {
			System.out.println(msg);
		}
	}

}
