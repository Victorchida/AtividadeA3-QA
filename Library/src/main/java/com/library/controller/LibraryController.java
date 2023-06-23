package com.library.controller;

import com.library.model.Book;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        libraryService.addBooks(book);
    }

     @GetMapping("/books")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) Author author,
                                  @RequestParam(required = false) Publisher publisher) {
        return libraryService.searchBooks(title, author, publisher);
    }

    @DeleteMapping("/books")
    public void removeBook(@RequestParam String title,
                           @RequestParam Author author,
                           @RequestParam Publisher publisher) {
        libraryService.removeBook(title, author, publisher);
    }

}


