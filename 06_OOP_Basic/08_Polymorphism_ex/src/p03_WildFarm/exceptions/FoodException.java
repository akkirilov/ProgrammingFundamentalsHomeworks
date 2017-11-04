package p03_WildFarm.exceptions;

public class FoodException extends Exception {

	private static final long serialVersionUID = 564156411L;

	private String message;
	
	public FoodException(String message) {
		setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}

}
