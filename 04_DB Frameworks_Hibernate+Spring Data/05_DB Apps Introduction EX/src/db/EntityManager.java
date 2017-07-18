package db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Minion;
import entity.Town;
import entity.Vilain;

public class EntityManager {
	
	Connection conn;
	
	public EntityManager(Connection conn) {
		this.conn = conn;
	}
	
	public <E> void persist(E entity) 
			throws NoSuchFieldException, SecurityException, SQLException, IllegalArgumentException, IllegalAccessException {
		
		Field primary = getPrimaryField(entity);
		primary.setAccessible(true);	
		Object idValue = primary.get(entity);
		if (idValue == null || (Long)idValue <= 0) {
			insert(entity, primary);
		}
		
	}

	private <E> void insert(E entity, Field primary) 
			throws IllegalArgumentException, IllegalAccessException, SQLException {
		
		String insertQuery = "INSERT INTO " + getTableName(entity) + " (";
		String columns = "";
		String values = "";
		
		Field[] fields = entity.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (!fields[i].getName().equals(primary.getName())) {
				columns += fields[i].getName();
				values +=  getValueOfField(entity, fields[i]);
				if (i < fields.length - 1) {
					columns += ", ";
					values += ", ";
				}
			}
		}
		
		insertQuery += columns + ") VALUES (" + values + ");";
		try (PreparedStatement stmt = conn.prepareStatement(insertQuery)){
			stmt.execute();
		}
		
	}
	
	public void initTables() 
			throws NoSuchFieldException, SecurityException, SQLException, InstantiationException, IllegalAccessException {
		
		createTableIfNotExist(new Town("a", "a"));
		createTableIfNotExist(new Vilain("a", "a"));
		createTableIfNotExist(new Minion("a", 1, 1L));
		
		String createQuery = "CREATE TABLE IF NOT EXISTS vilains_minions ("
				+ "vilain_id BIGINT,"
				+ "minion_id BIGINT,"
				+ "CONSTRAINT pk_vilains_minions PRIMARY KEY(vilain_id, minion_id),"
				+ "CONSTRAINT fk_vilains_minions_vilains FOREIGN KEY(vilain_id)"
				+ "REFERENCES vilain(id),"
				+ "CONSTRAINT fk_vilains_minions_minions FOREIGN KEY(minion_id)"
				+ "REFERENCES minion(id));";	
		try (PreparedStatement stmt = conn.prepareStatement(createQuery)){
			stmt.execute();
		}
	}
	
	private <E> String getTableName(E entity) {
		
		return entity.getClass().getSimpleName().toLowerCase();
		
	}
	
	private <E> void createTableIfNotExist(E entity) 
			throws SQLException, NoSuchFieldException, SecurityException {
		
		Field primary = getPrimaryField(entity);

		String createQuery = "CREATE TABLE IF NOT EXISTS " + getTableName(entity) + " (";
		
		Field[] fields = entity.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			createQuery += fields[i].getName() + " " + getTypeOfField(fields[i], primary);
			if (fields[i].getName().endsWith("Id")) {
				createQuery += ", CONSTRAINT fk_" + getTableName(entity) + "_" + fields[i].getName() + " FOREIGN KEY(" + fields[i].getName() + ")"
						+ "REFERENCES " + fields[i].getName().substring(0, fields[i].getName().length() - 2) + "(id)";
			}
			if (i < fields.length - 1) {
				createQuery += ", ";
			}
		}
		
		createQuery += ");";
		try (PreparedStatement stmt = conn.prepareStatement(createQuery)){
			stmt.execute();
		}
		
	}

	private <E> Object getValueOfField(E entity, Field field) 
			throws IllegalArgumentException, IllegalAccessException {
		
		field.setAccessible(true);
		
		if (!(field.get(entity) instanceof Number)) {
			return "'" + field.get(entity) + "'";
		}
		
		Object res = field.get(entity).toString();
		return res;
		
	}
	
	private String getTypeOfField(Field field, Field primary) {
		
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
		
		Field primaryField;
		primaryField = entity.getClass().getDeclaredField("id");
		
		return primaryField;
	}

	public Long findOrInsertTown(String name) 
			throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException {
		
		Town town = findTownByName(name);
		
		if (town == null || town.getId() == null || town.getId() < 1) {
			
			town = new Town(name, "BG");
			Field primary = town.getClass().getDeclaredField("id");
			insert(town, primary);
			System.out.println("Town " + name + " was added to the database.");
			town = findTownByName(name);
		} 
		
		return town.getId();
	}

	public Town findTownByName(String name) 
			throws SQLException {
		
		String findOneByNameQuery = "SELECT * FROM town WHERE name = '" + name + "';";
		Town town = null;
		try (PreparedStatement stmt = conn.prepareStatement(findOneByNameQuery)) {
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				town = new Town(rs.getLong("id"), rs.getString("name"), rs.getString("country"));
			}
		}
		
		return town;
	}

	public Long findOrInsertVilain(String name) 
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		
		Vilain vilain = findVilainByName(name);
		
		if (vilain == null || vilain.getId() == null || vilain.getId() < 1) {
			vilain = new Vilain(name, "evil");
			Field primary = getPrimaryField(vilain);
			insert(vilain, primary);
			System.out.println("Villain " + name + " was added to the database.");
			
			vilain = findVilainByName(name);
		} 
		
		return vilain.getId();
	}

	public Vilain findVilainByName(String name) 
			throws SQLException {

		String findOneByNameQuery = "SELECT * FROM vilain WHERE name = '" + name + "';";
		
		Vilain vilain = null;
		try (PreparedStatement stmt = conn.prepareStatement(findOneByNameQuery)) {
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				vilain = new Vilain(rs.getLong("id"), rs.getString("name"), rs.getString("evilness"));
			}
		}
		
		return vilain;
	}
	
	public Long getLastInsertedId(String table) 
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	
		String lidQuery = "Select id FROM " + table + " ORDER BY id DESC LIMIT 1";
		
		try (PreparedStatement stmt =  conn.prepareStatement(lidQuery)) {
			ResultSet rs = stmt.executeQuery(lidQuery);
			rs.next();

			return rs.getLong("id");
		}
		
	}

	public void insertIntoVilainsMinions(Long vilainId) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		Long minionId = getLastInsertedId("minion");
		
		String insertQuery = "INSERT INTO vilains_minions (vilain_id, minion_id) "
				+ "VALUE (" + vilainId + ", " + minionId + ");";
		try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
			stmt.execute();
		}
				
	}

	public List<Vilain> getAllVilains() 
			throws SQLException {

		String getAllVilainsQuery = "SELECT * FROM vilain";
		
		List<Vilain> vilains = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(getAllVilainsQuery)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				vilains.add(new Vilain(rs.getLong("id"), rs.getString("name"), rs.getString("evilness")));
			}
		}
		
		return vilains;
	}

	public Integer getCountOfVilainMinions(Vilain vilain) 
			throws SQLException {

		String getQuery = "SELECT COUNT(*) AS count FROM vilains_minions WHERE vilain_id = " + vilain.getId() + ";";
		try (PreparedStatement stmt = conn.prepareStatement(getQuery)) {
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return rs.getInt("count");
		}
		
	}

	public boolean isExistedVilain(Long vilainsId) 
			throws SQLException {
		
		String isExistedVilainQuery = "SELECT * FROM vilain WHERE id = " + vilainsId + ";";
		try (PreparedStatement stmt = conn.prepareStatement(isExistedVilainQuery)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		}
		return false;
	}

	public List<Minion> getMinionsByVilainsId(Long VilainsId) 
			throws SQLException {
		
		String getMinionsIdQuery = "SELECT minion_id FROM vilains_minions WHERE vilain_id = " + VilainsId + ";";
		List<Minion> minions = new ArrayList<>();
		
		try (PreparedStatement stmt = conn.prepareStatement(getMinionsIdQuery)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				minions.add(getMinionById(rs.getLong("minion_id")));
			}
		}
		
		return minions;
	}

	public Minion getMinionById(long minionId) 
			throws SQLException {
		
		String getMinionQuery = "SELECT * FROM minion WHERE id = " + minionId + ";";
		try (PreparedStatement stmt = conn.prepareStatement(getMinionQuery)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Minion(rs.getLong("id"), rs.getString("name"), rs.getInt("age"), rs.getLong("townId"));
			}
		}
		
		return null;
	}
	
	public Vilain getVilainById(long vilainsId) 
			throws SQLException {
		
		String getVilainQuery = "SELECT * FROM vilain WHERE id = " + vilainsId + ";";
		try (PreparedStatement stmt = conn.prepareStatement(getVilainQuery)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Vilain(rs.getLong("id"), rs.getString("name"), rs.getString("evilness"));
			}
		}
		
		return null;
	}

	public boolean isExistedCountry(String country) 
			throws SQLException {
		
		String isExistedVilainQuery = "SELECT country FROM town WHERE country = '" + country + "';";
		try (PreparedStatement stmt = conn.prepareStatement(isExistedVilainQuery)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		}
		return false;
	}

	public List<String> getTownsNamesByCountryName(String country) 
			throws SQLException {
		
		String getTownsNamesQuery = "SELECT name FROM town WHERE country = '" + country + "';" ;
		List<String> townsNames = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(getTownsNamesQuery)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				townsNames.add(rs.getString("name"));
			}
		}
		return townsNames;
	}

	public void delateVilian(Vilain vilainToDelate) 
			throws SQLException {
		
		String delateVilian = "DELETE FROM vilains_minions WHERE vilain_id = " + vilainToDelate.getId() + ";";
		try (PreparedStatement stmt = conn.prepareStatement(delateVilian)) {
			stmt.execute();
		}
		
		delateVilian = "DELETE FROM vilain WHERE id = " + vilainToDelate.getId() + ";";
		try (PreparedStatement stmt = conn.prepareStatement(delateVilian)) {
			stmt.execute();
		}
	}

	public List<Minion> getAllMinions() 
			throws SQLException {

		String getAllVilainsQuery = "SELECT * FROM minion";
		
		List<Minion> minions = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(getAllVilainsQuery)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				minions.add(new Minion(rs.getLong("id"), rs.getString("name"), rs.getInt("age"), rs.getLong("townId")));
			}
		}
		
		return minions;
	}

	public void increaseMinionAge(long id) 
			throws SQLException {
		
		Integer currentAge = getMinionAge(id);
		String increaseAgeQuery = "UPDATE minion SET age = " + ++currentAge + " WHERE id = " + id + ";";
		try (PreparedStatement stmt = conn.prepareStatement(increaseAgeQuery)) {
			stmt.execute();
		}
	}

	private Integer getMinionAge(long id) 
			throws SQLException {
		
		String currentAge = "SELECT age FROM minion WHERE id = " + id + ";";
		try (PreparedStatement stmt = conn.prepareStatement(currentAge)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("age");
			}
		}
		return null;
	}

	public boolean isExistedMinion(long id) 
			throws SQLException {
		
		String isExistedMinionQuery = "SELECT * FROM minion WHERE id = " + id + ";";
		try (PreparedStatement stmt = conn.prepareStatement(isExistedMinionQuery)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		}
		return false;
	}

}
