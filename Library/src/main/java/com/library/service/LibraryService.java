package com.library.service;

import com.library.model.Book;
import com.library.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private Library library;

    @Autowired
    public LibraryService(Library library) {
        this.library = library;
    }

    public void addBooks(Book book) {
        this.library.getBooks().add(book);
    }

    public void removeBook(String title, Author author, Publisher publisher) {
    library.getBooks().removeIf(book -> book.getTitle().equals(title) &&
                                book.getAuthor().equals(author) &&
                                book.getPublisher().equals(publisher));
    }

}

