package exeptions;

public class NonExistantModelException extends Exception {
	
	private static final long serialVersionUID = -6226683104958171945L;

	public NonExistantModelException(String message) {
        super(message);
    }
    
}
