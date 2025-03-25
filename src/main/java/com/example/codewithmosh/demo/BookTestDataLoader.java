package com.example.codewithmosh.demo;

import com.example.codewithmosh.entities.Book;
import com.example.codewithmosh.repositories.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookTestDataLoader {

    private final BookRepository bookRepository;

    public BookTestDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener
    public void loadBookTestData() {
        var book1 = new Book("1234567891", "northern Lights", "Lyra Silverstar", 9.90, "Manning");
        var book2 = new Book("1234567892", "Polar Journey", "Iorek Polarson", 12.90, "Oreilly");
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
