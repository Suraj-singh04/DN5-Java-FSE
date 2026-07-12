package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service =
                context.getBean("bookService", BookService.class);

        BookRepository repository =
                context.getBean("bookRepository", BookRepository.class);

        service.display();

        BookRepository repo1 =
        context.getBean("bookRepository", BookRepository.class);

        BookRepository repo2 =
                context.getBean("bookRepository", BookRepository.class);

        System.out.println(repo1 == repo2);

        System.out.println(repository.getBook());

    }
}