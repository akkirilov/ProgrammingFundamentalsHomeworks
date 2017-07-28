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

import app.models.Author;
import app.models.Book;
import app.models.Category;
import app.services.api.AuthorService;
import app.services.api.BookService;
import app.services.api.CategoryService;
import enums.AgeRestriction;
import enums.EditionType;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	private final BookService bookService;
	private final AuthorService authorService;
	private final CategoryService categoryService;
	
	private Random random; 
	
	@Autowired
	public ConsoleRunner (BookService bookService, AuthorService authorService, CategoryService categoryService) {
		this.bookService = bookService;
		this.authorService = authorService;
		this.categoryService = categoryService;
		this.random = new Random();
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);

		String command = "";
		while (true) {
			
			printMenu();
			
			command = scanner.nextLine();
			if (command.equals("e")) {
				break;
			}
			
			switch (command) {
			case "0":
				initializeDatabase();
				break;
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			case "9":
				break;
			default:
				break;
			}
			
		}
		scanner.close();
		
	}
	
	public void printMenu(){
		System.out.println("e = exit");
		System.out.println("0 = initialize database");
		System.out.println("1 = ");
		System.out.println("2 = ");
		System.out.println("3 = ");
		System.out.println("4 = ");
		System.out.println("5 = ");
		System.out.println("6 = ");
		System.out.println("7 = ");
		System.out.println("8 = ");
		System.out.println("9 = ");
		System.out.println("10 = ");
		System.out.println("11 = ");
		System.out.println("12 = ");
		System.out.println("13 = ");
		System.out.println("14 = ");
		System.out.println("15 = ");
		System.out.println("16 = ");
		System.out.println("17 = ");
	}
	
	public void setRelatedBooks(){
		
		List<Book> books = bookService.findAll();
		
		int count = 0;
		int bookIndex = 0;
		for (Book book : books) {
			Set<Book> relatedBooks = new HashSet<>();
			count = random.nextInt(3);
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
		
		bookService.save(books);
		
	}
	
	public void initializeDatabase() throws IOException, ParseException {
		
		if (bookService.isExist(1L)) {
			System.out.println("The Database is already initialized!");
			return;
		}
		
		List<Author> authors = new ArrayList<>();
		List<Category> categories = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
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
		    
		    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
		    book.setEdition(editionType);
		    
		    Date releaseDate = formatter.parse(data[1]);
		    book.setReleaseDate(releaseDate);
		    
		    Integer copies = Integer.parseInt(data[2]);
		    book.setCopies(copies);
		    
		    BigDecimal price = new BigDecimal(data[3]);
		    book.setPrice(price);
		    
		    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
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
		
		bookService.save(books);
		
		setRelatedBooks();
		
	}
    
}
