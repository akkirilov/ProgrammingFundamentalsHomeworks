package exeptions;

public class RaceAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = -4525501684305513666L;

	public RaceAlreadyExistsException(String message) {
        super(message);
    }
    
}
