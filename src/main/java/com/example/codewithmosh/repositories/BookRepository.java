package com.example.codewithmosh.repositories;

import com.example.codewithmosh.entities.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, String> {
  Iterable<Book> findAll();

  Optional<Book> findByIsbn(String isbn);

  boolean existsByIsbn(String isbn);

  Book save(Book book);

  @Modifying
  @Query("delete from Book where isbn = :isbn")
  void deleteByIsbn(String isbn);
}
