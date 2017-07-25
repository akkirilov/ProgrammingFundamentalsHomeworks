package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.model.Author;
import app.model.Book;
import app.model.Category;
import app.repositories.AuthorRepository;
import app.repositories.BookRepository;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);

		String command = "";
		while (true) {
			
			System.out.println("0 = exit");
			System.out.println("2 = seed data from the files");
			System.out.println("31 = find books after some release year after...");
			System.out.println("32 = find authors by release year before...");
			System.out.println("33 = find authors and order them descending by count of books");
			System.out.println("34 = find all Books from George Powell");
			System.out.println("4 = set random related books");
			
			command = scanner.nextLine();
			if (command.equals("0")) {
				break;
			}
			
			switch (command) {
			case "2":
				readBooksAndSeedData();
				break;
			case "31":
				System.out.println("Enter year: ");
				int year = Integer.parseInt(scanner.nextLine());  
				List<Book> books = bookRepository.findByReleaseDateAfterYear(year);
				for (Book book : books) {
					System.out.println(book.getTitle() + " " + book.getReleaseDate());
				}
				if (books.size() < 1) {
					System.out.println("There are no books for you!");
				}
				break;
			case "32":
				System.out.println("Enter year: ");
				int year1 = Integer.parseInt(scanner.nextLine());
				List<Author> authors = authorRepository.findByReleaseDateOfBookBeforeYear(year1);
				for (Author author : authors) {
					System.out.println(author.getFirstName() + " " + author.getLastName());
				}
				if (authors.size() < 1) {
					System.out.println("There are no authors for you!");
				}
				break;
			case "33":
				List<Author> authors1 = authorRepository.findAllAndOrderByBooksCount();
				for (Author author : authors1) {
					System.out.println(author.getFirstName() + " " + author.getLastName() + " - " + author.getBooks().size());
				}
				break;
			case "34":
				List<Book> books1 = bookRepository.findAllFromGP();
				for (Book book : books1) {
					System.out.println(book.getTitle() + " " + book.getCopies() + " - " + book.getReleaseDate());
				}
				break;
			case "4":
				setRelatedBooks();
				break;
			default:
				continue;
			}
			
		}
		
		scanner.close();
		
	}
	
	public void setRelatedBooks(){
		
		Random random = new Random();
		List<Book> books = bookRepository.findAll();
		
		int count = 0;
		int bookIndex = 0;
		for (Book book : books) {
			
			Set<Book> relatedBooks = new HashSet<>();
			
			count = random.nextInt(books.size() - 1);
			if (count < 2) {
				count = 2;
			} else if (count > 5) {
				count = 5;
			}
			
			for (int i = 0; i < count; i++) {
				bookIndex = random.nextInt(books.size() - 1);
				if (bookIndex < 0) {
					bookIndex = 0;
				}
				if (book.getId() != bookIndex) {
					relatedBooks.add(books.get(bookIndex));
				}
			}
			
			book.setRelatedBooks(relatedBooks);
		}
		
		bookRepository.save(books);
		
	}
	
	public void readBooksAndSeedData() throws IOException, ParseException {
		
		List<Author> authors = new ArrayList<>();
		List<Category> categories = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		Random random = new Random();
		String dir = System.getProperty("user.dir") + "\\src\\main\\resources\\";
		FileReader authorFileReader = new FileReader(dir + "authors.txt");
		BufferedReader authorReader = new BufferedReader(authorFileReader);
		
		String line = authorReader.readLine();
		while((line = authorReader.readLine()) != null){
			String[] data = line.split("\\s+");
			Author author = new Author();
			author.setFirstName(data[0]);
			author.setLastName(data[1]);
			authors.add(author);
		}
		authorReader.close();
		
		FileReader categoryFileReader = new FileReader(dir + "categories.txt");
		BufferedReader categoryReader = new BufferedReader(categoryFileReader);
		
		while((line = categoryReader.readLine()) != null){
			Category category = new Category();
			category.setName(line);
			categories.add(category);
		}
		categoryReader.close();
		
		FileReader bookFileReader = new FileReader(dir + "books.txt");
		BufferedReader bookReader = new BufferedReader(bookFileReader);
		
		line = bookReader.readLine();
		while((line = bookReader.readLine()) != null){
			Book book = new Book();
			String[] data = line.split("\\s+");
			
		    Author author = authors.get(random.nextInt(authors.size() - 1));
		    book.setAuthor(author);
		    
		    Integer edition = Integer.parseInt(data[0]);
		    book.setEdition(edition);
		    
		    SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
		    Date releaseDate = formatter.parse(data[1]);
		    book.setReleaseDate(releaseDate);
		    
		    Integer copies = Integer.parseInt(data[2]);
		    book.setCopies(copies);
		    
		    BigDecimal price = new BigDecimal(data[3]);
		    book.setPrice(price);
		    
		    Integer ageRestriction = Integer.parseInt(data[4]);
		    book.setAgeRestriction(ageRestriction);
		    
		    StringBuffer title = new StringBuffer();
		    for (int i = 5; i < data.length; i++) {
		    	title.append(data[i] + " ");
			}
		    book.setTitle(title.toString());
		    
		    book.setDescription("some description");

		    Set<Category> categoriesToSet = new HashSet<>();
		    for (int i = 0; i < random.nextInt(categories.size()); i++) {
		    	int categoryIndex = random.nextInt(categories.size() - 1);
		    	categoriesToSet.add(categories.get(categoryIndex));
			}
		    if (categoriesToSet == null || categoriesToSet.size() < 0) {
		    	categoriesToSet.add(categories.get(0));
			}
		    book.setCategories(categoriesToSet);
		    
		    books.add(book);
		}
		
		bookReader.close();
		
		bookRepository.save(books);
		
	}
    
}
