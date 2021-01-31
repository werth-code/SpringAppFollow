package com.matthewwerth.springWebApp.bootstrap;

import com.matthewwerth.springWebApp.domain.Author;
import com.matthewwerth.springWebApp.domain.Book;
import com.matthewwerth.springWebApp.repositories.AuthorRepository;
import com.matthewwerth.springWebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component // Tells Spring to use this as a component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book travelTheWorld = new Book("Travel The World", "012345");
        eric.getBooks().add(travelTheWorld);
        travelTheWorld.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(travelTheWorld);

        Author robert = new Author("Robert", "Ternita");
        Book staycation = new Book("Staycation", "123456");
        eric.getBooks().add(staycation);
        travelTheWorld.getAuthors().add(robert);

        authorRepository.save(robert);
        bookRepository.save(staycation);

        System.out.println("Started... in bootstrap");
        System.out.println("Number of Books" + bookRepository.count());

    }
}
