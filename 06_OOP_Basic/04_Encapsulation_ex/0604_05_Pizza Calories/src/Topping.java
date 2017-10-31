import java.util.HashMap;
import java.util.Map;

public class Topping {
	
	private static final Map<String, Double> TYPES = initializeTypes();
	
	private String type;
	private int weight;
	
	public Topping(String type, int weight) {
		super();
		setType(type);
		setWeight(weight, type);
	}

	private void setType(String type) {
		if (!TYPES.containsKey(type)) {
			throw new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
		}
		this.type = type;
	}

	private void setWeight(int weight, String type) {
		if (weight < 0 || weight > 50) {
			throw new IllegalArgumentException(type + " weight should be in the range [1..50].");
		}
		this.weight = weight;
	}
	
	public double getCallories() {
		return TYPES.get(this.type) * weight * 2;
	}
	
	private static Map<String, Double> initializeTypes() {
		HashMap<String, Double> res = new HashMap<>();
		res.put("Meat", 1.2);
		res.put("Veggies", 0.8);
		res.put("Cheese", 1.1);
		res.put("Sauce", 0.9);
		return res;
	}
}
