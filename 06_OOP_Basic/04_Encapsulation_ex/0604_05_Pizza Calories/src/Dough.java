import java.util.HashMap;
import java.util.Map;

public class Dough {
	
	private static final Map<String, Double> TYPES = initializeTypes();
	private static final Map<String, Double> ADDITIONALS = initializeAdditionalInfo();
	
	private String type;
	private String additionalInfo;
	private int weight;
	
	public Dough(String type, String additionalInfo, int weight) {
		super();
		setType(type);
		setAdditionalInfo(additionalInfo);
		setWeight(weight);
	}
	
	private void setType(String type) {
		if (!TYPES.containsKey(type)) {
			throw new IllegalArgumentException("Invalid type of dough.");
		}
		this.type = type;
	}

	private void setAdditionalInfo(String additionalInfo) {
		if (!ADDITIONALS.containsKey(additionalInfo)) {
			throw new IllegalArgumentException("Invalid type of dough.");
		}
		this.additionalInfo = additionalInfo;
	}

	private void setWeight(int weight) {
		if (weight < 0 || weight > 200) {
			throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
		}
		this.weight = weight;
	}
	
	public double getCallories() {
		return TYPES.get(this.type) * ADDITIONALS.get(this.additionalInfo) * weight * 2;
	}
	
	private static HashMap<String, Double> initializeTypes() {
		HashMap<String, Double> res = new HashMap<>();
		res.put("White", 1.5);
		res.put("Wholegrain", 1.0);
		return res;
	}
	
	private static HashMap<String, Double> initializeAdditionalInfo() {
		HashMap<String, Double> res = new HashMap<>();
		res.put("Crispy", 0.9);
		res.put("Chewy", 1.1);
		res.put("Homemade", 1.0);
		return res;
	}

}
