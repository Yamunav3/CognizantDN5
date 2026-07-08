package org.example.Service;

import org.example.Repository.BookRepository;

public class BookService {
    public BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        bookRepository.saveBook();
    }
}


