package transaction;

public interface Command<E> {
	
	E execute();
	
}
