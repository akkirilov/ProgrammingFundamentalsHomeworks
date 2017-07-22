package service.api;

import java.util.List;

import transaction.Command;
import transaction.MultiCommand;

public interface TransactionExecutor<E> {

	E runInTransaction(Command<E> command);
	
	List<E> runInTransaction(MultiCommand<E> command);
	
}
