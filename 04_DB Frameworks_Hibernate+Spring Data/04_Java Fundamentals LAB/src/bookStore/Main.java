package bookStore;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Stream.of(
				new Book("Vinetu3", 20d, "Karl Mai"),
				new Book("Vinetu1", 21d, "Karl Mai"),
				new Book("Vinetu2", 15d, "Karl Mai"),
				new Book("Sherlock Holmes", 12d, "Arthur C. Doyl"),
				new Book("The Lost World", 43d, "Arthur C. Doyl"))
			.collect(Collectors.groupingBy(
				Book::getAuthor, 
				Collectors.summingDouble(Book::getPrice)))
			.entrySet()				
			.stream()
			.sorted((a, b) -> {
				int result = Double.compare(b.getValue(), a.getValue());
				if (result == 0) {
					result = a.getKey().compareTo(b.getKey());
				}
				return result;
			})
			.forEach(x -> System.out.println(x.getKey() + "=" + x.getValue()));


	}

}
