package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < count; i++){
            String[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .toArray(String[]::new);

            String title = tokens[0];
            String author = tokens[1];
            String publisher = tokens[2];
            LocalDate releaseDate = LocalDate.from(dtf.parse(tokens[3]));
            String isbn = tokens[4];
            Double price = Double.parseDouble(tokens[5]);

            Book book = new Book(title, author, publisher, releaseDate, isbn, price);

            books.add(book);
        }

        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book bk1, Book bk2) {
                if (bk1.getReleaseDate().isBefore(bk2.getReleaseDate())){
                    return -1;
                }
                else if(bk1.getReleaseDate().isAfter(bk2.getReleaseDate())){
                    return 1;
                }
                else {
                    for(int j = 0; j < Math.min(bk1.getTitle().length(), bk2.getTitle().length()); j++){
                        if(bk1.getTitle().charAt(j) > bk2.getTitle().charAt(j)){
                            return 1;
                        }
                        else if(bk1.getTitle().charAt(j) < bk2.getTitle().charAt(j)) {
                            return -1;
                        }
                    }
                    if (bk1.getTitle().length() > bk2.getTitle().length()){
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
            }
        });

        LocalDate afterDate = LocalDate.from(dtf.parse(scanner.nextLine()));

        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getReleaseDate().isAfter(afterDate)) {
                System.out.printf("%s -> %s", books.get(i).getTitle(), books.get(i).getReleaseDate().format(dtf));
                System.out.println();
            }
        }
    }
}