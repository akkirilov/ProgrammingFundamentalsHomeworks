package exeptions;

public class InsufficientContestantsException extends Exception {

	private static final long serialVersionUID = 5756534052288768084L;

	public InsufficientContestantsException(String message) {
        super(message);
    }
	
}
