package bookLibrary;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		
		Library library = new Library("library");
		for (int i = 0; i < number; i++) {
			String[] input = scanner.nextLine().split("\\s+");
			library.addBook(new Book(input[0], input[1], input[2], input[3], input[4], Double.parseDouble(input[5])));
		}
		scanner.close();
		
		library.getBooks().stream()
			.collect(Collectors.groupingBy(Book::getAuthor, Collectors.summingDouble(Book::getPrice)))
			.entrySet()
			.stream()
			.sorted((a, b) -> {
								int res = Double.compare(b.getValue(), a.getValue());
								if (res == 0) {
									res = a.getKey().compareTo(b.getKey());
								}
								return res;
							})
			.forEach(b -> {
							System.out.printf("%s -> %.2f%n", b.getKey(), b.getValue());
							});

	}

}
