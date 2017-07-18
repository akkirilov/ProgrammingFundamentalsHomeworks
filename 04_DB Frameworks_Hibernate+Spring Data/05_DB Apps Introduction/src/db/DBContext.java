package db;

import java.sql.SQLException;

public interface DBContext {
	
	// it will insert or update entity depending if it is attached to the context
	<E> boolean persist(E entity) 
			throws IllegalAccessException, SQLException;
	
	// returns collection of all entity objects of type E
	<E> Iterable<E> find(Class<E> table) 
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
	
	// returns collection of all entity objects of type T matching the criteria given in “where”
	<E> Iterable<E> find(Class<E> table, String where) 
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
	
	// returns the first entity object of type E
	<E> E findFirst(Class<E> table) 
			throws SQLException, InstantiationException, IllegalAccessException; 
	
	// returns the first entity object of type E matching the criteria given in “where”
	<E> E findFirst(Class<E> table, String where) 
			throws SQLException, InstantiationException, IllegalAccessException;

}
