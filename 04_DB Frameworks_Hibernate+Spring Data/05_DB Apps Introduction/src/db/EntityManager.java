package db;

import entity.User;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EntityManager implements DBContext {
	
	private Connection connection;
	private Set<Object> persistEntities;
	private Field primary;

	public EntityManager(Connection connection) {
		this.connection = connection;
		this.persistEntities = new HashSet<>();
	}

	@Override
	public <E> boolean persist(E entity) 
			throws IllegalAccessException, SQLException {
		
		try {
			this.primary = getPrimaryField(entity);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doCreate(entity, primary);

		primary.setAccessible(true);
		Object idValue = primary.get(entity);
		if (idValue == null || (Long)idValue <= 0) {
			try {
				insert(entity);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			update(entity, idValue);
		}
		
		return false;
	}

	private <E> void update(E entity, Object idValue) 
			throws IllegalArgumentException, IllegalAccessException, SQLException {
		
		String tableName = entity.getClass().getSimpleName().toLowerCase();
		Field[] fields = entity.getClass().getDeclaredFields();
		
		String updateQuery = "UPDATE " + tableName + " SET ";
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (!fields[i].getName().equals(primary.getName())) {
				updateQuery += fields[i].getName() + "=" + getValue(fields[i], entity);
				if (i < fields.length - 1) {
					updateQuery += ", ";
				}
			}
		}
		
		updateQuery += " WHERE id=" + (Long)idValue + ";";
		try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
			stmt.execute();
		}
		
		
	}
	
	private <E> void insert(E entity) 
			throws IllegalArgumentException, IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException {
		
		String tableName = entity.getClass().getSimpleName().toLowerCase();
		Field[] fields = entity.getClass().getDeclaredFields();
		
		String insertQuery = "INSERT INTO " + tableName + "(";
		String columns = "";
		String values = "";
		
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (!fields[i].getName().equals(primary.getName())) {
				columns += fields[i].getName();
				values += getValue(fields[i], entity);
				if (i < fields.length - 1) {
					columns += ", ";
					values += ", ";
				}
			}
		}
		insertQuery += columns + ")";
		insertQuery += "VALUES (" + values + ");";
		
		try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
			stmt.execute();
			User user = (User) entity;
			user.setId(getLastInsertedId(tableName));
		}
		
	}

	private <E> String getValue(Field field, E entity) 
			throws IllegalArgumentException, IllegalAccessException {
		
		if (!(field.get(entity) instanceof Number)) {
			return "'" + field.get(entity) + "'";
		}
		return field.get(entity).toString();
	}

	@Override
	public <E> Iterable<E> find(Class<E> table) 
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		String tableName = table.getSimpleName().toLowerCase();
		String findAllQuery = "Select * FROM " + tableName;
		
		try (PreparedStatement stmt =  connection.prepareStatement(findAllQuery)) {
			ResultSet rs = stmt.executeQuery();
			List<E> users = new ArrayList<>();
			
			if (tableName.equals("user")) {
				while (rs.next()) {
					users.add((E) new User(rs.getLong("id"), rs.getString("name"), rs.getInt("age"), rs.getDate("registrationDate")));
				}
			}
			
			return users;
		}
		
	}
	
	public Long getLastInsertedId(String table) 
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	
		String lidQuery = "Select id FROM " + table + " ORDER BY id DESC LIMIT 1";
		
		try (PreparedStatement stmt =  connection.prepareStatement(lidQuery)) {
			ResultSet rs = stmt.executeQuery(lidQuery);
			rs.next();

			return rs.getLong("id");
		}
		
	}

	@Override
	public <E> Iterable<E> find(Class<E> table, String where) 
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		String tableName = table.getSimpleName().toLowerCase();
		String findAllQuery = "Select * FROM " + tableName + " WHERE " + where + ";";
		
		try (PreparedStatement stmt =  connection.prepareStatement(findAllQuery)) {
			ResultSet rs = stmt.executeQuery();
			List<E> users = new ArrayList<>();
			
			if (tableName.equals("user")) {
				while (rs.next()) {
					users.add((E) new User(rs.getLong("id"), rs.getString("name"), rs.getInt("age"), rs.getDate("registrationDate")));
				}
			}
			
			return users;
		}
		
	}

	@Override
	public <E> E findFirst(Class<E> table) 
			throws SQLException, InstantiationException, IllegalAccessException {
		
		String tableName = table.getSimpleName().toLowerCase();
		String findFirstQuery = "Select * FROM " + tableName + " LIMIT 1;";
		
		try (PreparedStatement stmt =  connection.prepareStatement(findFirstQuery)) {
			ResultSet rs = stmt.executeQuery();
			rs.next();
			E user = (E) new User(rs.getLong("id"), rs.getString("name"), rs.getInt("age"), rs.getDate("registrationDate"));
			
			return user;
		}
	}

	@Override
	public <E> E findFirst(Class<E> table, String where) 
			throws SQLException, InstantiationException, IllegalAccessException {
		
		String tableName = table.getSimpleName().toLowerCase();
		String findFirstQuery = "Select * FROM " + tableName
				+ " WHERE " + where + " LIMIT 1;";
		
		try (PreparedStatement stmt =  connection.prepareStatement(findFirstQuery)) {
			ResultSet rs = stmt.executeQuery();
			rs.next();
			E user = (E) new User(rs.getLong("id"), rs.getString("name"), rs.getInt("age"), rs.getDate("registrationDate"));
			
			return user;
		}
	}
	
	public <E> boolean doCreate(E entity, Field primary) 
			throws SQLException {
		
		String tableName = entity.getClass().getSimpleName().toLowerCase();
		Field[] fields = entity.getClass().getDeclaredFields(); 
		
		String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
		for (int i = 0; i < fields.length; i++) {
			createTableQuery += fields[i].getName() + " " + getType(fields[i], primary);
			if (i < fields.length - 1) {
				createTableQuery += ", ";
			}
		}
		createTableQuery += ");";
		
		try (PreparedStatement stmt = connection.prepareStatement(createTableQuery)) {
			return stmt.execute();
		} 
		
	}
	
	private String getType(Field field, Field primary) {
		
		field.setAccessible(true);
		
		if (field.getName().equals(primary.getName())) {
			return "BIGINT PRIMARY KEY AUTO_INCREMENT";
		}
		
		switch (field.getType().getSimpleName()) {
		case "int":
			return "INT";
		case "Integer":
			return "INT";
		case "Long":
			return "BIGINT";
		case "Double":
			return "DOUBLE";
		case "String":
			return "VARCHAR(255)";
		case "Date":
			return "DATE";
		}
		
		return null;
	}
	
	private <E> Field getPrimaryField(E entity) 
			throws NoSuchFieldException, SecurityException {
		
		return entity.getClass().getDeclaredField("id");
	}

}
