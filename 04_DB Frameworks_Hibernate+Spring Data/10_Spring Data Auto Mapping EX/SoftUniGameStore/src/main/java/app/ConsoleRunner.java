package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.commands.CommandFactory;
import app.commands.Executable;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] tokens;	
		String command;
		String result;
		while (true) {
			
			printMenu();
			
			tokens = scanner.nextLine().split("\\|");
			command = tokens[0];
			if (command.equals("end")) {
				break;
			}
			
			if (command.equals("init")) {
				initializeDatabase();
				continue;
			}
			
			String[] params = new String[tokens.length - 1];
			if (tokens.length > 1) {
				params = Arrays.copyOfRange(tokens, 1, tokens.length);
			}
			
			Executable executable = CommandFactory.getCommand(command);
			if (executable == null) {
				System.out.println("Invalid command!");
				continue;
			}
			
			result = executable.execute(params);
			System.out.println(result);
			
		}
		scanner.close();
		
	}
		
	private void printMenu() {
		System.out.println();
		System.out.println("end = Exit");
		System.out.println("init = Initialize Database");
		System.out.println("Register|<email>|<password>|<confirmPassword>|<fullName> = Register new user");
		System.out.println("Login|<email>|<password> = Login");
		System.out.println("Logout = Logout");
		System.out.println("AddGame|<title>|<price>|<size>|<trailer>|<thubnailURL>|<description>|<releaseDate> = Add new game");
		System.out.println("DeleteGame|<game id> = Delete game");
		System.out.println("EditGame|<game id> = Edit game");
		System.out.println("AllGames = View all games");
		System.out.println("GameDetails|<game title> = View game details");
		System.out.println("OwnedGames = View your games");
		System.out.println("AddToShoppingCart|<title> = Add game to shopping cart");
		System.out.println("RemoveFromShoppingCart|<title> = Remove game from shopping cart");
		System.out.println("BuyGames = Buy games from shopping cart");
		System.out.println();
	}

	public void initializeDatabase() {
		
		List<String> initCommands = new ArrayList<>();
		initCommands.add("Register|ivan@ivan.com|Ivan1s|Ivan1s|Ivan");
		initCommands.add("Register|gosho@goo.com|Ivan1s|Ivan1s|Gosho");
		initCommands.add("Register|pesho@goo.com|Ivan1s|Ivan1s|Pesho");
		initCommands.add("Register|tosho@goo.com|Ivan1s|Ivan1s|Tosho");
		initCommands.add("Register|rosho@goo.com|Ivan1s|Ivan1s|Rosho");
		initCommands.add("Login|ivan@ivan.com|Ivan1s");
		initCommands.add("AddGame|Overwatch|100.00|15.5|FqnKB22pOC0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-personshooter video "
				+ "game developed and published by Blizzard Entertainment.|24-05-2016");
		initCommands.add("AddGame|Overwatch 2|120.00|15.5|FREKB22pOCf|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2016");
		initCommands.add("AddGame|Overwatch 3|140.00|15.5|FDDKB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2017");
		initCommands.add("AddGame|GTA Vicy City|110.00|25.5|FBVCB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2010");
		initCommands.add("AddGame|GTA 3|110.00|25.5|FBVCB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2008");
		initCommands.add("AddGame|GTA 2|110.00|25.5|FBVCB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2007");
		initCommands.add("AddGame|NFS 3|110.00|25.5|FBVCB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2002");
		initCommands.add("AddGame|NFS 4|110.00|25.5|FBVCB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2003");
		initCommands.add("AddGame|NFS 5|110.00|25.5|FBVCB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2004");
		initCommands.add("AddGame|NFS 6|110.00|25.5|FBVCB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2005");
		initCommands.add("AddGame|NFS 7|110.00|25.5|FBVCB22pOD0|"
				+ "https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|"
				+ "Overwatch is a team-based multiplayer online first-person "
				+ "shooter video game developed and published by Blizzard Entertainment.|24-06-2006");
		initCommands.add("Logout");
		
		String[] tokens;	
		String command;
		String result;
		for (int i = 0; i < initCommands.size(); i++) {
			tokens = initCommands.get(i).split("\\|");
			
			command = tokens[0];
			String[] params = new String[tokens.length - 1];
			
			params = Arrays.copyOfRange(tokens, 1, tokens.length);
			Executable executable = CommandFactory.getCommand(command);
			
			result = executable.execute(params);
			System.out.println(result);
		}
		
	}
    
}
