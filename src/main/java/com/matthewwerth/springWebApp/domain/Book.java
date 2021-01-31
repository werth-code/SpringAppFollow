package com.matthewwerth.springWebApp.domain;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity // java persistence entity
public class Book {
    @Id // set this as the id for our database
    @GeneratedValue(strategy = GenerationType.AUTO) // set this as our ordering strategy
    private Long id;

    private String title;
    private String isbn;
    private Set<Author> authors;

    private Book(){};

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
