package dao.api;

public interface TransactionSupport <E> {

	void rollback();
	
	void beginTransaction();
	
	void commit();
	
}
