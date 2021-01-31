package com.matthewwerth.springWebApp.repositories;

import com.matthewwerth.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

//  this needs us to specify what we are going to use and how to map..
//  Author is mapped by Long id
//  Spring takes care of the abstracted backend here
