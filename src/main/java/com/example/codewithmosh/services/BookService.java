package com.example.codewithmosh.services;

import com.example.codewithmosh.common.exception.BookAlreadyExistsException;
import com.example.codewithmosh.common.exception.BookNotFoundException;
import com.example.codewithmosh.entities.Book;
import com.example.codewithmosh.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
  private final BookRepository bookRepository;


  public Iterable<Book> viewBookList() {
    return bookRepository.findAll();
  }

  public Book viewBookDetails(String isbn) {
    return bookRepository.findByIsbn(isbn)
        .orElseThrow(() -> new BookNotFoundException(isbn));
  }

  public Book addBookToCatalog(Book book) {
    if (bookRepository.existsByIsbn(book.getIsbn())) {
      throw new BookAlreadyExistsException(book.getIsbn());
    }
    return bookRepository.save(book);
  }

  public void removeBookFromCatalog(String isbn) {
    bookRepository.deleteByIsbn(isbn);
  }

  public Book editBookDetail(String isbn, Book book) {
    return bookRepository.findByIsbn(isbn)
        .map(existingBook -> {
          var bookToUpdate = Book.builder()
                  .isbn(existingBook.getIsbn())
                  .title(existingBook.getTitle())
                  .author(existingBook.getAuthor())
                  .price(existingBook.getPrice())
                  .build();
          return bookRepository.save(bookToUpdate);
        })
        .orElseGet(() -> addBookToCatalog(book));
  }
}
