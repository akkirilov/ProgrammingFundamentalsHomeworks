package minions;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import db.Connector;
import db.EntityManager;
import entity.Minion;
import entity.Vilain;

public class Minions {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		Scanner scanner = new Scanner(System.in);
		
		Connection conn = Connector.getConnection();		
		EntityManager em = new EntityManager(conn);
		em.initTables();
		
		System.out.println("Hello User!");
		
		String command;
		while (true) {
			
			System.out.println();
			System.out.println("View vilains and minions's count: 2");
			System.out.println("View minions by vilain's id: 3");
			System.out.println("Add new minion: 4");
			System.out.println("View town names to uppercase: 5");
			System.out.println("Delate vilain: 6");
			System.out.println("View all minion names: 7");
			System.out.println("Increase minions age: 8");
			System.out.println("To exit enter: 0");
			
			command = scanner.nextLine();
			if (command.equals("0")) {
				break;
			}
			
			switch (command) {
			case "4":
				System.out.println("Enter data in order: name age town vilain");
				String[] data = scanner.nextLine().split("\\s+");
				
				String name = data[0];
				Integer age;
				
				try {
					age = Integer.parseInt(data[1]);
				} catch (NumberFormatException e) {
					System.out.println("Invalid age!");
					continue;
				}
				
				Long townId = em.findOrInsertTown(data[2]);
				Long vilainId = em.findOrInsertVilain(data[3]);
				
				Minion tempMinion = new Minion(name, age, townId);
				em.persist(tempMinion);
				System.out.println("Successfully added " + name + " to be minion of " + data[3] + ".");

				try {
					em.insertIntoVilainsMinions(vilainId);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "2":
				List<Vilain> vilains = em.getAllVilains();
				for (Vilain vilain : vilains) {
					System.out.println(vilain.getName() + " " + em.getCountOfVilainMinions(vilain));
				}
				break;
			case "3":
				System.out.println("Enter the vilain's id: ");
				Long vilainsId = Long.parseLong(scanner.nextLine());
				if (!em.isExistedVilain(vilainsId)) {
					System.out.println("No villain with ID " + vilainsId + " exists in the database.");
					continue;
				}
				
				List<Minion> minions = em.getMinionsByVilainsId(vilainsId);
				
				int counter = 1;
				boolean isFound = false;
				Vilain vilain = em.getVilainById(vilainsId);
				System.out.println("Vilain: " + vilain.getName());
				for (Minion minion : minions) {
					System.out.println(counter++ + ". " + minion.getName() + " " + minion.getAge());
					isFound = true;
				}
				
				if (!isFound) {
					System.out.println("<no minions>");
				}
				break;
			case "5":
				System.out.println("Enter the country name:");
				String country = scanner.nextLine();
				
				if (!em.isExistedCountry(country)) {
					System.out.println("No town names were affected.");
				}
				
				List<String> countryNames = em.getTownsNamesByCountryName(country);
				countryNames = countryNames.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());

				System.out.println(countryNames.size() + "town names were affected.");
				System.out.println(countryNames);
				break;
			case "6":
				System.out.println("Enter the vilain's id: ");
				Long vilainIdToDelate = Long.parseLong(scanner.nextLine());
				if (!em.isExistedVilain(vilainIdToDelate)) {
					System.out.println("No villain with ID " + vilainIdToDelate + " exists in the database.");
					continue;
				}
				
				Vilain vilainToDelate = em.getVilainById(vilainIdToDelate);
				Integer releasedMinions = em.getCountOfVilainMinions(vilainToDelate);
				
				em.delateVilian(vilainToDelate);
				
				System.out.println(vilainToDelate.getName() + " was deleted");
				System.out.println(releasedMinions + " minions released");
				break;
			case "7":
				List<Minion> minionsList = em.getAllMinions();
				
				Integer count = 0;
				Integer length = minionsList.size() / 2;
				boolean isOdd = false;
				if (minionsList.size() / 2 % 2 != 0) {
					isOdd = true;
					length++;
				}
				
				for (int i = 0; i < length; i++) {
					if (isOdd) {
						System.out.println(minionsList.get(i).getName());
					} else {
						System.out.println(minionsList.get(i).getName());
						System.out.println(minionsList.get(minionsList.size() - 1 - count).getName());
					}
					count++;
				}
				break;
			case "8":
				System.out.println("Enter minions id in array separed by space:");
				long[] minionsToIncreaseAge = Arrays.stream(scanner.nextLine().split("\\s+"))
						.mapToLong(Long::parseLong)
						.toArray();
				for (int i = 0; i < minionsToIncreaseAge.length; i++) {
					if (em.isExistedMinion(minionsToIncreaseAge[i])) {
						em.increaseMinionAge(minionsToIncreaseAge[i]);
					} else {
						System.out.println("There are no minion with such Id!");
					}
					
				}
				
				List<Minion> minionsWithNewAge = em.getAllMinions();
				for (Minion minion : minionsWithNewAge) {
					System.out.println(minion.getName() + " " + minion.getAge());
				}
				break;
				
			default:
				continue;
				
			}
			
			
		}
		conn.close();
		scanner.close();
		
	}	

}
