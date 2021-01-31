package com.matthewwerth.springWebApp.repositories;

import com.matthewwerth.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
