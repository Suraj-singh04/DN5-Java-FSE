package com.library;

public class MagazineService {

    private BookRepository repository;

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void display() {
        System.out.println("Magazine uses : " + repository.getBook());
    }
}