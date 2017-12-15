package exeptions;

public class DuplicateModelException extends Exception {
	
	private static final long serialVersionUID = 144465465411165L;

	public DuplicateModelException(String message) {
        super(message);
    }

}
