package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        List<Library> libraries = new ArrayList<>();

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

            int index = -1;
            for (int j = 0; j < libraries.size(); j++) {
                if (libraries.get(j).getName().equals(author)) {
                    index = j;
                    break;
                }
            }

            if (index >= 0){
                libraries.get(index).addBook(book);
            }
            else {
                List<Book> bks = new ArrayList<>();
                bks.add(book);

                Library lib = new Library();
                lib.setName(author);
                lib.setBooks(bks);

                libraries.add(lib);
            }
        }

        Collections.sort(libraries, new Comparator<Library>() {
            public int compare(Library lib1, Library lib2) {
                if (lib1.totalPrices() < lib2.totalPrices()) {
                    return 1;
                }
                else if(lib1.totalPrices() == lib2.totalPrices()){
                    for(int j = 0; j < Math.min(lib1.getName().length(), lib2.getName().length()); j++){
                        if(lib1.getName().charAt(j) > lib2.getName().charAt(j)){
                            return 1;
                        }
                        else if(lib1.getName().charAt(j) < lib2.getName().charAt(j)) {
                            return -1;
                        }
                    }
                    if (lib1.getName().length() > lib2.getName().length()){
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
                else {
                    return -1;
                }
            }
        });

        for(int i = 0; i < libraries.size(); i++) {
            System.out.printf("%s -> %.2f", libraries.get(i).getName(), libraries.get(i).totalPrices());
            System.out.println();
        }
    }
}