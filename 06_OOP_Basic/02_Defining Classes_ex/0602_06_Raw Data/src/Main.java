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

	    String model;
	    Car tempCar;
	    Engine tempEngine;
	    Cargo tempCargo;
	    Tire tempTire;
	    int n = Integer.parseInt(reader.readLine());
	    String[] tokens;
	    for (int i = 0; i < n; i++) {
	    	tokens = reader.readLine().split("\\s+");
	    	
	    	model = tokens[0];
	    	tempEngine = new Engine(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
	    	tempCargo = new Cargo(Integer.parseInt(tokens[3]), tokens[4]);
	    	
	    	tempCar = new Car(model, tempEngine, tempCargo);
	    	for (int j = 5; j < 12; j += 2) {
	    		tempTire = new Tire(Double.parseDouble(tokens[j]), Integer.parseInt(tokens[j + 1]));
	    		tempCar.addTire(tempTire);
			}
	    	
			cars.add(tempCar);
		}
	    
	    String command = reader.readLine();
	    
	    reader.close();
	    
	    for (Car c : cars) {
	    	if (command.equals("fragile")) {
	    		if (c.getCargo().getType().equals(command) && c.isTireWithPresureBelowOne()) {
					System.out.println(c);
				}
			} else {
				if (c.getEngine().getPower() > 250) {
					System.out.println(c);
				}
			}
		}

	}

}
