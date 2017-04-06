package com.company;

import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public double totalPrices(){
        double sum = 0;
        for(int i = 0; i < books.size(); i++){
            sum += books.get(i).getPrice();
        }

        return sum;
    }
}