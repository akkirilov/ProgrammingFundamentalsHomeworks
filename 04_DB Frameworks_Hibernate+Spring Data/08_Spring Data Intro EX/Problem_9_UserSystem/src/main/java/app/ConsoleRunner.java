package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.entities.Album;
import app.entities.Picture;
import app.entities.Town;
import app.entities.User;
import app.services.TownService;
import app.services.UserService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private TownService townService;
	
	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		String line = "";
		while (true) {
			System.out.println("0 = exit");
			System.out.println("1 = add Pesho (seed data)");
			System.out.println("2 = add born town and living town to Pesho (seed data)");
			System.out.println("3 = add Gosho (seed data)");
			System.out.println("4 = add born town and living town to Gosho (seed data)");
			System.out.println("5 = add last Name to Pesho (seed data)");
			System.out.println("6 = add last Name to Gosho (seed data)");
			System.out.println("7 = get Gosho's full name");
			System.out.println("8 = get Pesho's full name");
			System.out.println("9 = add frieand to Pesho");
			System.out.println("10 = add frieand to Gosho");
			System.out.println("11 = add album to Pesho");
			line = scanner.nextLine();
			if (line.equals("0")) {
				break;
			}
			switch (line) {
			case "1":
				addPesho();
				break;
			case "2":
				addTownsToPesho();
				break;
			case "3":
				addGosho();
				break;
			case "4":
				addTownsToGosho();
				break;
			case "5":
				addLastNameToPesho();
				break;
			case "6":
				addLastNameToGosho();
				break;
			case "7":
				User gosho = userService.findByUsername("gosho");
				System.out.println(gosho.getFullName());
				break;
			case "8":
				User pesho = userService.findByUsername("pesho");
				System.out.println(pesho.getFullName());
				break;
			case "9":
				addFriendToPesho();
				break;
			case "10":
				addFriendToGosho();
				break;
			case "11":
				addAlbumToPesho();
				break;
			default:
				break;
			}
			
		}
		scanner.close();
		
	}

	private void addAlbumToPesho() {
		Picture picture1 = new Picture();
		picture1.setTitle("pic1");
		picture1.setPicturePath("images/pic1.jpeg");
		Picture picture2 = new Picture();
		picture2.setTitle("pic2");
		picture2.setPicturePath("images/pic2.jpeg");
		Picture picture3 = new Picture();
		picture3.setTitle("pic3");
		picture3.setPicturePath("images/pic3.jpeg");
		Picture picture4 = new Picture();
		picture4.setTitle("pic4");
		picture4.setPicturePath("images/pic4.jpeg");
		Picture picture5 = new Picture();
		picture5.setTitle("pic5");
		picture5.setPicturePath("images/pic5.jpeg");
		
		Set<Picture> pictures1 = new HashSet<>();
		pictures1.add(picture1);
		pictures1.add(picture2);
		pictures1.add(picture3);
		pictures1.add(picture4);
		pictures1.add(picture5);
		Set<Picture> pictures2 = new HashSet<>();
		pictures2.add(picture1);
		pictures2.add(picture2);
		Set<Picture> pictures3 = new HashSet<>();
		pictures3.add(picture3);
		pictures3.add(picture4);
		pictures3.add(picture5);
		
		Album album1 = new Album();
		album1.setName("album1");
		album1.setBackgroundColor("White");
		album1.setPictures(pictures1);
		Album album2 = new Album();
		album2.setName("album2");
		album2.setBackgroundColor("White");
		album2.setPictures(pictures2);
		Album album3 = new Album();
		album3.setName("album3");
		album3.setBackgroundColor("White");
		album3.setPictures(pictures3);
		
		User pesho = userService.findByUsername("pesho");
		pesho.addAlbum(album1);
		pesho.addAlbum(album2);
		pesho.addAlbum(album3);
		
		userService.save(pesho);
	}

	private void addFriendToPesho() {
		User gosho = userService.findByUsername("gosho");
		User pesho = userService.findByUsername("pesho");
		pesho.addFriend(gosho);
		userService.save(pesho);
	}
	
	private void addFriendToGosho() {
		User gosho = userService.findByUsername("gosho");
		User pesho = userService.findByUsername("pesho");
		gosho.addFriend(pesho);
		userService.save(gosho);
	}
	
	private void addLastNameToGosho() {
		User gosho = userService.findByUsername("gosho");
		gosho.setFirstName("Gosho");
		gosho.setLastName("Gosharsky");
		userService.save(gosho);
	}

	private void addLastNameToPesho() {
		User pesho = userService.findByUsername("pesho");
		userService.setLastNameManual(pesho, "Manivelsky");
	}

	private void addTownsToPesho() {
		User pesho = userService.findByUsername("pesho");
		
		Town bornTown = new Town();
		bornTown.setName("Peshov dol");
		bornTown.setCountry("Peshaviya");
		
		Town livingTown = new Town();
		livingTown.setName("Peshovgrad");
		livingTown.setCountry("Peshaviya");
		
		pesho.setBornTown(bornTown);
		pesho.setLivingTown(livingTown);
		
		userService.save(pesho);
	}
	
	private void addTownsToGosho() {
		User gosho = userService.findByUsername("gosho");
		
		String bornTownName = "Peshov dol";
		Town bornTown = null;
		bornTown = townService.findByName(bornTownName);
		if (bornTown == null) {
			bornTown = new Town();
			bornTown.setName(bornTownName);
			bornTown.setCountry("Peshaviya");
		}
		
		String livingTownName = "Goshovgrad";
		Town livingTown = null;
		livingTown = townService.findByName(livingTownName);
		if (livingTown == null) {
			livingTown = new Town();
			livingTown.setName(livingTownName);
			livingTown.setCountry("Peshaviya");
		}
		
		gosho.setBornTown(bornTown);
		gosho.setLivingTown(livingTown);
		
		userService.save(gosho);
	}
	
	private void addPesho () {
		try {
			User user1 = new User();
			user1.setUsername("pesho");
			user1.setPassword("paSS1!");
			user1.setPicturePath("/pic.jpeg");
			user1.setAge(5);
			user1.setEmail("user@user.us");
			user1.setIsDeleted(false);
			user1.setRegistrationDate(new Date());
			user1.setLastLogin(new Date());
			
			userService.saveAndFlush(user1);
		} catch (IllegalArgumentException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	private void addGosho () {
		try {
			User user1 = new User();
			user1.setUsername("gosho");
			user1.setPassword("paSS1!");
			user1.setPicturePath("/pic.jpeg");
			user1.setAge(5);
			user1.setEmail("user@user.us");
			user1.setIsDeleted(false);
			user1.setRegistrationDate(new Date());
			user1.setLastLogin(new Date());
			
			userService.saveAndFlush(user1);
		} catch (IllegalArgumentException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
}
