package com.library;

public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void display() {
        System.out.println("Book Name : " + repository.getBook());
    }

}