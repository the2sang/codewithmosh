package com.example.codewithmosh.repositories;

import com.example.codewithmosh.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, String> {
  Iterable<Book> findAll();

  Optional<Book> findByIsbn(String isbn);

  boolean existsByIsbn(String isbn);

  Book save(Book book);

  void deleteByIsbn(String isbn);
}
