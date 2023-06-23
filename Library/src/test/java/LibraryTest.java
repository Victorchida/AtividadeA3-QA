import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Library;
import com.library.model.Publisher;
import com.library.service.LibraryService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {
    Library library = new Library();
    LibraryService libraryService = new LibraryService(library);

    @Test
    public void testAddBook() {
        Author author = new Author("J.R.R. Tolkien", "British");
        Publisher publisher = new Publisher("Houghton Mifflin", "USA");
        Book book = new Book("Lord of The Rings", author, publisher);
        libraryService.addBooks(book);

        assertEquals(1, library.getBooks().size());
        assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void testRemoveBook() {
        Author author1 = new Author("J.R.R. Tolkien", "British");
        Author author2 = new Author("J.K. Rowling", "British");
        Publisher publisher = new Publisher("Houghton Mifflin", "USA");
        Book book1 = new Book("The Hobbit", author1, publisher);
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", author2, publisher);

        libraryService.addBooks(book1);
        libraryService.addBooks(book2);

        libraryService.removeBook("The Hobbit", author1, publisher);

        assertEquals(1, library.getBooks().size());
        assertFalse(library.getBooks().contains(book1));
        assertTrue(library.getBooks().contains(book2));
    }
    
}
