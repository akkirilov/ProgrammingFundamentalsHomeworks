import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import db.Connector;
import db.EntityManager;
import entity.User;

public class JDBC {

	public static void main(String[] args) 
			throws SQLException, NoSuchFieldException, SecurityException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		Connector.initConnection();
		Connection connection = Connector.getConnection();
		
		EntityManager em = new EntityManager(connection);
		User res = new User("Gosho", 1000, Date.valueOf(LocalDate.now()));
		em.persist(res);
		res.setAge(5000);
		em.persist(res);
		System.out.printf("%s is %d years old and was registered on %s%n", res.getName(), res.getAge(), res.getRegistrationDate());
		print(em.findFirst(User.class, "name='Gosho'"));
		connection.close();

	}

	private static <E> void print(User res) {
		System.out.printf("%s is %d years old and was registered on %s%n", res.getName(), res.getAge(), res.getRegistrationDate());
		
	}

}
