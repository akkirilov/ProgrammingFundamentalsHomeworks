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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.models.Author;
import app.models.Book;
import app.models.Category;
import app.models.ReducedBook;
import app.services.api.AuthorService;
import app.services.api.BookService;
import app.services.api.CategoryService;
import app.enums.AgeRestriction;
import app.enums.EditionType;

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
		
		String inputStr;
		String[] inputStrArr;
		Integer inputInt;
		Integer counter;
		Integer rowCount;
		Date date;
		SimpleDateFormat sdf;
		List<Book> books;
		List<Author> authors;
		List<Category> categories;
		List<Long> ids;
		Map<String, Integer> outputMapStrInt;
		Map<String, BigDecimal> outputMapStrBigDec;
		Map<Category, List<Book>> outputMapCatBooks;
		
		
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
				System.out.println("Enter Age Restriction:");
				inputStr = scanner.nextLine();
				books = bookService.findAllByAgeRestriction(AgeRestriction.valueOf(inputStr.toUpperCase()));
				for (Book book : books) {
					System.out.println(book.getTitle() + " (" + book.getAgeRestriction() + ")");
				}
				break;
			case "2":
				books = bookService.findAllGoldenBooksWithLessThan5000Copies();
				for (Book book : books) {
					System.out.println(book.getTitle() + " (Edition: " + book.getEdition() + "), (Copies: " + book.getCopies() + ")");
				}
				break;
			case "3":
				books = bookService.findAllByPriceNotInRange();
				for (Book book : books) {
					System.out.println(book.getTitle() + " (Price: " + book.getPrice() + ")");
				}
				break;
			case "4":
				System.out.println("Enter Year:");
				inputInt = Integer.parseInt(scanner.nextLine());
				books = bookService.findBooksNorReleasedOnGivenYear(inputInt);
				for (Book book : books) {
					System.out.println(book.getTitle() + " (Released: " + book.getReleaseDate() + ")");
				}
				break;
			case "5":
				System.out.println("Enter categories separated by space:");
				inputStrArr = scanner.nextLine().split("\\s+");
				categories = categoryService.findAllByNameIn(inputStrArr);
				books = bookService.findAllByCategoriesIn(categories);
				for (Book book : books) {
					System.out.println(book.getTitle());
				}
				break;
			case "6":
				sdf = new SimpleDateFormat("dd-MM-yyyy");
				System.out.println("Enter date in format 'dd-MM-yyyy'");
				date = sdf.parse(scanner.nextLine());
				books = bookService.findAllByReleaseDateBefore(date);
				for (Book book : books) {
					System.out.println(book.getTitle() + ", Released: " + book.getReleaseDate() + ", Price: " + book.getPrice());
				}
				break;
			case "7":
				System.out.println("Enter suffix for author's first name:");
				inputStr = scanner.nextLine();
				authors = authorService.findAllByFirstNameEndsWith(inputStr);
				for (Author author : authors) {
					System.out.println(author.getFirstName() + " " + author.getLastName());
				}
				break;
			case "8":
				System.out.println("Enter key word:");
				inputStr = scanner.nextLine();
				books = bookService.findAllByTitleContainingIgnoreCase(inputStr);
				for (Book book : books) {
					System.out.println(book.getTitle());
				}
				break;
			case "9":
				System.out.println("Enter prefix for author's last name:");
				inputStr = scanner.nextLine();
				books = bookService.findAllByAuthorLastNameStartingWithIgnoreCase(inputStr);
				for (Book book : books) {
					System.out.println(book.getTitle() + ", Author's last name: " + book.getAuthor().getLastName());
				}
				break;
			case "10":
				System.out.println("Enter title's min length: ");
				inputInt = Integer.parseInt(scanner.nextLine());
				books = bookService.findAllByMinLengthOfTitle(inputInt);
				System.out.println(books.size());
				break;
			case "11":
				authors = authorService.findAll();
				outputMapStrInt = new LinkedHashMap<>();
				for (Author author : authors) {
					outputMapStrInt.put(author.getFirstName() + " " + author.getLastName(), authorService.getTotalCopiesOfBooks(author.getId()));
				}
				outputMapStrInt
						.entrySet()
						.stream()
						.sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
						.forEach(x -> System.out.println(x.getKey() + " - " + x.getValue()));
				break;
			case "12":
				outputMapStrBigDec = new LinkedHashMap<>();
				categories = categoryService.findAll();
				for (Category category : categories) {
					outputMapStrBigDec.put(category.getName(), bookService.findTotalProfitByCategory(category.getId()));
				}
				outputMapStrBigDec
						.entrySet()
						.stream()
						.sorted((a, b) -> b.getValue().compareTo(a.getValue()))
						.forEach(x -> System.out.println(x.getKey() + " - " + x.getValue()));
				break;
			case "13":
				sdf = new SimpleDateFormat("yyyy");
				outputMapCatBooks = new LinkedHashMap<>();
				categories = categoryService.findAll();
				for (Category category : categories) {
					outputMapCatBooks.put(category, bookService.findByCategoryOrderDateDesc(category));
				}
				outputMapCatBooks = outputMapCatBooks
						.entrySet()
						.stream()
						.sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
				for (Map.Entry<Category, List<Book>> entry : outputMapCatBooks.entrySet()) {
					System.out.println("--" + entry.getKey().getName() + ": " + entry.getValue().size() + " books");
					counter = 0;
					for (Book book : entry.getValue()) {
						System.out.println(book.getTitle() + " " + sdf.format(book.getReleaseDate()));
						counter++;
						if (counter == 3) {
							break;
						}
					}
				}
				break;
			case "14":
				System.out.println("Enter title:");
				inputStr = scanner.nextLine();
				List<ReducedBook> reducedBooks = bookService.findAllByTitle(inputStr);
				for (ReducedBook book : reducedBooks) {
					System.out.println(book.getTitle() + " " + book.getEdition() + " " + book.getAgeRestriction() + " " + book.getPrice());
				}
				break;
			case "15":
				sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
				System.out.println("Enter date in format 'dd MMM yyyy':");
				date = sdf.parse(scanner.nextLine());
				System.out.println("Enter number to increase books copies");
				inputInt = Integer.parseInt(scanner.nextLine());
				rowCount = bookService.increaseBooksAfterGivenDateWithGivenNumber(date, inputInt);
				System.out.println(rowCount * inputInt);
				break;
			case "16":
				ids = new ArrayList<>();
				System.out.println("Enter min copies:");
				inputInt = Integer.parseInt(scanner.nextLine());
				books = bookService.findAll();
				for (Book book : books) {
					if (book.getCopies() < inputInt) {
						ids.add(book.getId());
					}
				}
				bookService.deleteRelatedBooksWithLowerCopiesThanGivenNumber(ids);
				rowCount = bookService.deleteBooksWithLowerCopiesThanGivenNumber(inputInt);
				System.out.println(rowCount + " books were deleted");
				break;
			case "17":
				//DELIMITER $$
				//CREATE PROCEDURE `udp_find_total_books` (IN firstName VARCHAR(255), IN lastName VARCHAR(255), OUT counter INT)
				//BEGIN
				//    SET counter := (SELECT COUNT(*) FROM books AS b 
				//			JOIN authors AS a ON b.author_id = a.id 
				//			WHERE a.first_name = firstName AND a.last_name = lastName);
				//END $$
				//DELIMITER ;
				System.out.println("Enter author's first and last names, separed by space:");
				inputStrArr = scanner.nextLine().split("\\s+");
				inputInt = authorService.getTotalBooks(inputStrArr[0], inputStrArr[1]);
				System.out.println(inputInt);
				break;
			default:
				break;
			}
			
		}
		scanner.close();
		
	}
	
	public void printMenu(){
		System.out.println("e = exit");
		System.out.println("0 = Initialize database");
		System.out.println("1 = Books Titles by Age Restriction");
		System.out.println("2 = Golden Books");
		System.out.println("3 = Books by Price");
		System.out.println("4 = Not Released Books");
		System.out.println("5 = Book Titles by Category");
		System.out.println("6 = Books Released Before Date");
		System.out.println("7 = Authors Search");
		System.out.println("8 = Books Search");
		System.out.println("9 = Book Titles Search");
		System.out.println("10 = Count Books");
		System.out.println("11 = Total Book Copies");
		System.out.println("12 = Find Profit");
		System.out.println("13 = Most Recent Books");
		System.out.println("14 = Reduced Book");
		System.out.println("15 = Increase Book Copies");
		System.out.println("16 = Remove Books");
		System.out.println("17 = Stored Procedure");
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
		    book.setTitle(title.toString().trim());
		    
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
