package com.matthewwerth.springWebApp.repositories;

import com.matthewwerth.springWebApp.domain.Book;
import com.matthewwerth.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> { //// TODO: 1/31/21 not entirely clear what this should be?
}
