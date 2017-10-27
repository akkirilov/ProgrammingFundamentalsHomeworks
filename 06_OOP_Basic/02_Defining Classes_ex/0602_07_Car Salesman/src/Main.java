import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		List<Engine> engines = new ArrayList<>();
		List<Car> cars = new ArrayList<>();
		
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader reader = new BufferedReader(isr);

	    String model;
	    int power;
	    Engine tempEngine = null;
	    int n = Integer.parseInt(reader.readLine());
	    String[] tokens;
	    for (int i = 0; i < n; i++) {
	    	tokens = reader.readLine().split("\\s+");
	    	model = tokens[0];
	    	power = Integer.parseInt(tokens[1]);
	    	if (tokens.length == 3) {
				if (Character.isDigit(tokens[2].charAt(0))) {
					tempEngine = new Engine(model, power, Integer.parseInt(tokens[2]));
				} else {
					tempEngine = new Engine(model, power, tokens[2]);
				}
			} else if (tokens.length == 4) {
				tempEngine = new Engine(model, power, Integer.parseInt(tokens[2]), tokens[3]);
			} else {
				tempEngine = new Engine(model, power);
			}
	    	
	    	engines.add(tempEngine);
		}

	    Car tempCar;
	    n = Integer.parseInt(reader.readLine());
	    for (int i = 0; i < n; i++) {
	    	tokens = reader.readLine().split("\\s+");
	    	model = tokens[0];
	    	for (Engine e : engines) {
				if (e.getModel().equals(tokens[1])) {
					tempEngine = e;
					break;
				}
			}
	    	
	    	if (tokens.length == 3) {
				if (Character.isDigit(tokens[2].charAt(0))) {
					tempCar = new Car(model, tempEngine, Integer.parseInt(tokens[2]));
				} else {
					tempCar = new Car(model, tempEngine, tokens[2]);
				}
			} else if (tokens.length == 4) {
				tempCar = new Car(model, tempEngine, Integer.parseInt(tokens[2]), tokens[3]);
			} else {
				tempCar = new Car(model, tempEngine);
			}
	    	cars.add(tempCar);
		}
	    
	    reader.close();
	    
	    for (Car c : cars) {
	    	System.out.println(c);
		}

	}

}
