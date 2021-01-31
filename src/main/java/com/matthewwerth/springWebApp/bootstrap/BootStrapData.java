package com.matthewwerth.springWebApp.bootstrap;

import com.matthewwerth.springWebApp.domain.Author;
import com.matthewwerth.springWebApp.domain.Book;
import com.matthewwerth.springWebApp.domain.Publisher;
import com.matthewwerth.springWebApp.repositories.AuthorRepository;
import com.matthewwerth.springWebApp.repositories.BookRepository;
import com.matthewwerth.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component // Tells Spring to use this as a component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started... in bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Werth Publishing");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book travelTheWorld = new Book("Travel The World", "012345");
        eric.getBooks().add(travelTheWorld);
        travelTheWorld.getAuthors().add(eric);

        travelTheWorld.setPublisher(publisher);
        publisher.getPublishedBooks().add(travelTheWorld);

        authorRepository.save(eric);
        bookRepository.save(travelTheWorld);
        publisherRepository.save(publisher);

        Author robert = new Author("Robert", "Ternita");
        Book staycation = new Book("Staycation", "123456");
        eric.getBooks().add(staycation);
        travelTheWorld.getAuthors().add(robert);

        staycation.setPublisher(publisher);
        publisher.getPublishedBooks().add(staycation);

        authorRepository.save(robert);
        bookRepository.save(staycation);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number Of Books: " + publisher.getPublishedBooks().size());
    }
}


//Referential integrity constraint violation: "FKGTVT7P649S4X80Y6F4842PNFQ: PUBLIC.BOOK FOREIGN KEY(PUBLISHER_ID) REFERENCES PUBLIC.PUBLISHER(ID) (111222)"; SQL statement: